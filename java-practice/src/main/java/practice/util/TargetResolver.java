package main.java.practice.util;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TargetResolver automatically finds the latest implementation of a challenge.
 *
 * HOW IT WORKS:
 * -------------
 * 1. Scans the classpath for .class files matching the base name
 * 2. Extracts version numbers from filenames (LargestSum2 -> version 2)
 * 3. Returns the highest numbered version
 * 4. Allows override via PRACTICE_TARGET environment variable
 *
 * For a challenge named "LargestSum", it will look for:
 *   - LargestSum.java (attempt 0 - no number)
 *   - LargestSum2.java (attempt 2)
 *   - LargestSum3.java (attempt 3)
 *   etc.
 *
 * By default, it returns the highest numbered attempt.
 * You can override with environment variable PRACTICE_TARGET=LargestSum2
 *
 * EXAMPLE USAGE:
 * --------------
 *   // In your test class:
 *   LargestSumSolution solution = TargetResolver.resolve("practice.largestsum", "LargestSum");
 *   // Returns instance of LargestSum3 if that's the highest version
 */
public class TargetResolver {

    // Environment variable name for overriding which version to test
    private static final String ENV_OVERRIDE = "PRACTICE_TARGET";

    /**
     * Find and instantiate the target implementation class.
     *
     * PROCESS:
     * --------
     * 1. Check for PRACTICE_TARGET environment variable
     * 2. If set, use that specific class
     * 3. If not set, find the latest (highest numbered) implementation
     * 4. Load the class using reflection
     * 5. Create and return a new instance
     *
     * @param basePackage The package containing the challenge (e.g., "practice.largestsum")
     * @param baseName The base class name (e.g., "LargestSum")
     * @return Instance of the target class (cast to your interface type)
     * @throws Exception if class not found or cannot be instantiated
     */
    @SuppressWarnings("unchecked")
    public static <T> T resolve(String basePackage, String baseName) throws Exception {
        // Check if user wants to test a specific version via environment variable
        String envTarget = System.getenv(ENV_OVERRIDE);

        String targetClassName;
        if (envTarget != null && !envTarget.isEmpty()) {
            // Use environment variable override (e.g., PRACTICE_TARGET=LargestSum2)
            targetClassName = basePackage + "." + envTarget;
            System.out.println("🎯 Using PRACTICE_TARGET override: " + targetClassName);
        } else {
            // Find the latest attempt automatically
            targetClassName = findLatestAttempt(basePackage, baseName);
            System.out.println("🎯 Testing latest attempt: " + targetClassName);
        }

        // Use reflection to load the class and create an instance
        Class<T> clazz = (Class<T>) Class.forName(targetClassName);
        return clazz.getDeclaredConstructor().newInstance();
    }

    /**
     * Find the latest numbered attempt of a challenge.
     *
     * ALGORITHM:
     * ----------
     * 1. Convert package name to file path (. -> /)
     * 2. Search classpath for the package directory
     * 3. List all .class files that start with baseName
     * 4. Extract version numbers from filenames
     * 5. Return the class with the highest version number
     *
     * EXAMPLE:
     * For baseName="LargestSum", finds: LargestSum.class, LargestSum2.class, LargestSum3.class
     * Returns: "practice.largestsum.LargestSum3"
     *
     * @param basePackage Package to search (e.g., "practice.largestsum")
     * @param baseName Base class name (e.g., "LargestSum")
     * @return Full class name of latest version (e.g., "practice.largestsum.LargestSum3")
     * @throws ClassNotFoundException if no matching classes found
     */
    private static String findLatestAttempt(String basePackage, String baseName) throws Exception {
        // List to store all found class names
        List<String> foundClasses = new ArrayList<>();

        // Convert package name to path (practice.largestsum -> practice/largestsum)
        String packagePath = basePackage.replace('.', '/');

        // Get the classloader to search for compiled .class files
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources(packagePath);

        // Regex pattern to match: LargestSum, LargestSum2, LargestSum3, etc.
        // The (\\d*) captures optional digits after the base name
        Pattern pattern = Pattern.compile(baseName + "(\\d*)");

        // Search through all locations where this package appears
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            File directory = new File(resource.toURI());

            if (directory.exists() && directory.isDirectory()) {
                // Filter files: must end with .class and start with baseName
                File[] files = directory.listFiles((dir, name) ->
                    name.endsWith(".class") && name.startsWith(baseName));

                if (files != null) {
                    for (File file : files) {
                        // Remove .class extension to get class name
                        String className = file.getName().replace(".class", "");
                        Matcher matcher = pattern.matcher(className);
                        if (matcher.matches()) {
                            foundClasses.add(className);
                        }
                    }
                }
            }
        }

        // Throw error if no implementations found
        if (foundClasses.isEmpty()) {
            throw new ClassNotFoundException(
                "No implementation found for " + baseName + " in package " + basePackage);
        }

        // Sort classes by version number and get the highest
        String latest = foundClasses.stream()
            .max(Comparator.comparingInt(TargetResolver::extractAttemptNumber))
            .orElseThrow();

        // Return fully qualified class name
        return basePackage + "." + latest;
    }

    /**
     * Extract the attempt number from a class name.
     *
     * EXAMPLES:
     * ---------
     * LargestSum   -> 0 (no number, so it's attempt 0/baseline)
     * LargestSum2  -> 2
     * LargestSum10 -> 10
     *
     * HOW IT WORKS:
     * Uses regex to find digits at the end of the class name.
     * If no digits found, returns 0 (making baseline version lowest priority).
     *
     * @param className Simple class name (e.g., "LargestSum2")
     * @return Version number (2 for LargestSum2, 0 for LargestSum)
     */
    private static int extractAttemptNumber(String className) {
        // Regex: \D+ (one or more non-digits) followed by (\d+)$ (digits at end)
        Pattern pattern = Pattern.compile("\\D+(\\d+)$");
        Matcher matcher = pattern.matcher(className);

        if (matcher.find()) {
            // Extract and parse the digit group
            return Integer.parseInt(matcher.group(1));
        }
        // No number found - this is the base version (attempt 0)
        return 0;
    }
}
