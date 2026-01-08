// Import Node.js modules for file system operations
const fs = require("fs"); // File system - read files and directories
const path = require("path"); // Path manipulation - join paths correctly

/**
 * TargetResolver - Automatically finds the latest implementation of a challenge
 *
 * HOW IT WORKS:
 * -------------
 * 1. Scans the practice directory for .js files matching the base name
 * 2. Extracts version numbers from filenames (largestSum2.js -> version 2)
 * 3. Returns the file with the highest version number
 * 4. Allows override via PRACTICE_TARGET environment variable
 *
 * For a challenge named "largestSum", it will look for:
 *   - largestSum.js (attempt 0 - no number)
 *   - largestSum2.js (attempt 2)
 *   - largestSum3.js (attempt 3)
 *   etc.
 *
 * By default, returns the highest numbered attempt.
 * Override with environment variable: PRACTICE_TARGET=largestSum2
 *
 * EXAMPLE USAGE:
 * --------------
 *   // In your test file:
 *   const solution = TargetResolver.resolve('largestSum');
 *   // Returns exports from largestSum3.js if that's the highest version
 */
class TargetResolver {
  /**
   * Find and require the target implementation module.
   *
   * PROCESS:
   * --------
   * 1. Check for PRACTICE_TARGET environment variable
   * 2. If set, use that specific file
   * 3. If not set, find the latest (highest numbered) file
   * 4. Require (import) that file
   * 5. Return its exports
   *
   * @param {string} challengeName - Base name of the challenge (e.g., "largestSum")
   * @param {string} practiceDir - Directory containing practice files (default: "../practice")
   * @returns {*} The exported module from the target file (e.g., { bigSum: function })
   */
  static resolve(challengeName, practiceDir = path.join(__dirname, "../practice")) {
    // Check if user wants to test a specific version via environment variable
    const envTarget = process.env.PRACTICE_TARGET;

    let targetFile;
    if (envTarget) {
      // Use environment variable override (e.g., PRACTICE_TARGET=largestSum2)
      targetFile = `${envTarget}.js`;
      console.log(`🎯 Using PRACTICE_TARGET override: ${targetFile}`);
    } else {
      // Find the latest attempt automatically
      targetFile = this.findLatestAttempt(challengeName, practiceDir);
      console.log(`🎯 Testing latest attempt: ${targetFile}`);
    }

    // Build full path to the target file
    const targetPath = path.join(practiceDir, targetFile);

    // Verify file exists before trying to require it
    if (!fs.existsSync(targetPath)) {
      throw new Error(`Target file not found: ${targetPath}`);
    }

    // Import and return the module (what it exports)
    return require(targetPath);
  }

  /**
   * Find the latest numbered attempt of a challenge.
   *
   * ALGORITHM:
   * ----------
   * 1. Read all files in the practice directory
   * 2. Filter files that match pattern: baseName + optional number + .js
   * 3. Extract version numbers (no number = 0)
   * 4. Sort by version number (descending)
   * 5. Return the highest version
   *
   * EXAMPLE:
   * For baseName="largestSum", finds: largestSum.js, largestSum2.js, largestSum3.js
   * Returns: "largestSum3.js"
   *
   * @param {string} baseName - Base name (e.g., "largestSum")
   * @param {string} dir - Directory to search
   * @returns {string} Filename of latest attempt (e.g., "largestSum3.js")
   */
  static findLatestAttempt(baseName, dir) {
    // Verify directory exists
    if (!fs.existsSync(dir)) {
      throw new Error(`Practice directory not found: ${dir}`);
    }

    // Read all files in directory
    const files = fs.readdirSync(dir);

    // Create regex pattern to match: baseName + optional digits + .js
    // Example: /^largestSum(\d*)\.js$/
    // This matches: largestSum.js, largestSum2.js, largestSum10.js
    const pattern = new RegExp(`^${baseName}(\\d*)\\.js$`);

    // Filter and transform matching files
    const matches = files
      .filter((file) => pattern.test(file)) // Keep only matching files
      .map((file) => {
        const match = file.match(pattern);
        // Extract number from filename (empty string -> 0, "2" -> 2)
        const attemptNum = match[1] ? parseInt(match[1], 10) : 0;
        return { file, attemptNum };
      })
      .sort((a, b) => b.attemptNum - a.attemptNum); // Sort descending (highest first)

    // Throw error if no matching files found
    if (matches.length === 0) {
      throw new Error(`No implementation found for ${baseName} in ${dir}`);
    }

    // Return the filename with highest version number
    return matches[0].file;
  }
}

// Export the TargetResolver class so other files can use it
// Usage: const TargetResolver = require('./targetResolver');
module.exports = TargetResolver;
