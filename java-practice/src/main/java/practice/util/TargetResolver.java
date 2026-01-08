package practice.util;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TargetResolver automatically finds the latest implementation of a challenge.
 *
 * For a challenge named "LargestSum", it will look for:
 *   - LargestSum.java (attempt 0)
 *   - LargestSum2.java (attempt 2)
 *   - LargestSum3.java (attempt 3)
 *   etc.
 *
 * By default, it returns the highest numbered attempt.
 * You can override with environment variable PRACTICE_TARGET=LargestSum2
 */
public class TargetResolver {

    private static final String ENV_OVERRIDE = "PRACTICE_TARGET";

    /**
     * Find and instantiate the target implementation class.
     *
     * @param basePackage The package containing the challenge (e.g., "practice.largestsum")
     * @param baseName The base class name (e.g., "LargestSum")
     * @return Instance of the target class
     * @throws Exception if class not found or cannot be instantiated
     */
    @SuppressWarnings("unchecked")
    public static <T> T resolve(String basePackage, String baseName) throws Exception {
        String envTarget = System.getenv(ENV_OVERRIDE);

        String targetClassName;
        if (envTarget != null && !envTarget.isEmpty()) {
            // Use environment variable override
            targetClassName = basePackage + "." + envTarget;
            System.out.println("🎯 Using PRACTICE_TARGET override: " + targetClassName);
        } else {
            // Find the latest attempt
            targetClassName = findLatestAttempt(basePackage, baseName);
            System.out.println("🎯 Testing latest attempt: " + targetClassName);
        }

        Class<T> clazz = (Class<T>) Class.forName(targetClassName);
        return clazz.getDeclaredConstructor().newInstance();
    }

    /**
     * Find the latest numbered attempt of a challenge.
     * Scans the classpath for classes matching the pattern.
     */
    private static String findLatestAttempt(String basePackage, String baseName) throws Exception {
        List<String> foundClasses = new ArrayList<>();

        // Convert package to path
        String packagePath = basePackage.replace('.', '/');

        // Get the package directory from classpath
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources(packagePath);

        Pattern pattern = Pattern.compile(baseName + "(\\d*)");

        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            File directory = new File(resource.toURI());

            if (directory.exists() && directory.isDirectory()) {
                File[] files = directory.listFiles((dir, name) ->
                    name.endsWith(".class") && name.startsWith(baseName));

                if (files != null) {
                    for (File file : files) {
                        String className = file.getName().replace(".class", "");
                        Matcher matcher = pattern.matcher(className);
                        if (matcher.matches()) {
                            foundClasses.add(className);
                        }
                    }
                }
            }
        }

        if (foundClasses.isEmpty()) {
            throw new ClassNotFoundException(
                "No implementation found for " + baseName + " in package " + basePackage);
        }

        // Sort to find the highest numbered attempt
        String latest = foundClasses.stream()
            .max(Comparator.comparingInt(TargetResolver::extractAttemptNumber))
            .orElseThrow();

        return basePackage + "." + latest;
    }

    /**
     * Extract the attempt number from a class name.
     * LargestSum -> 0
     * LargestSum2 -> 2
     * LargestSum10 -> 10
     */
    private static int extractAttemptNumber(String className) {
        Pattern pattern = Pattern.compile("\\D+(\\d+)$");
        Matcher matcher = pattern.matcher(className);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0; // Base version has no number
    }
}
