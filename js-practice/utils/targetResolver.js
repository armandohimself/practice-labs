const fs = require("fs");
const path = require("path");

/**
 * TargetResolver - Automatically finds the latest implementation of a challenge
 *
 * For a challenge named "largestSum", it will look for:
 *   - largestSum.js (attempt 0)
 *   - largestSum2.js (attempt 2)
 *   - largestSum3.js (attempt 3)
 *   etc.
 *
 * By default, returns the highest numbered attempt.
 * Override with environment variable: PRACTICE_TARGET=largestSum2
 */
class TargetResolver {
  /**
   * Find and require the target implementation module.
   *
   * @param {string} challengeName - Base name of the challenge (e.g., "largestSum")
   * @param {string} practiceDir - Directory containing practice files (default: "../practice")
   * @returns {*} The exported module from the target file
   */
  static resolve(challengeName, practiceDir = path.join(__dirname, "../practice")) {
    const envTarget = process.env.PRACTICE_TARGET;

    let targetFile;
    if (envTarget) {
      // Use environment variable override
      targetFile = `${envTarget}.js`;
      console.log(`🎯 Using PRACTICE_TARGET override: ${targetFile}`);
    } else {
      // Find the latest attempt
      targetFile = this.findLatestAttempt(challengeName, practiceDir);
      console.log(`🎯 Testing latest attempt: ${targetFile}`);
    }

    const targetPath = path.join(practiceDir, targetFile);

    if (!fs.existsSync(targetPath)) {
      throw new Error(`Target file not found: ${targetPath}`);
    }

    return require(targetPath);
  }

  /**
   * Find the latest numbered attempt of a challenge.
   *
   * @param {string} baseName - Base name (e.g., "largestSum")
   * @param {string} dir - Directory to search
   * @returns {string} Filename of latest attempt
   */
  static findLatestAttempt(baseName, dir) {
    if (!fs.existsSync(dir)) {
      throw new Error(`Practice directory not found: ${dir}`);
    }

    const files = fs.readdirSync(dir);
    const pattern = new RegExp(`^${baseName}(\\d*)\\.js$`);

    const matches = files
      .filter((file) => pattern.test(file))
      .map((file) => {
        const match = file.match(pattern);
        const attemptNum = match[1] ? parseInt(match[1], 10) : 0;
        return { file, attemptNum };
      })
      .sort((a, b) => b.attemptNum - a.attemptNum); // Sort descending

    if (matches.length === 0) {
      throw new Error(`No implementation found for ${baseName} in ${dir}`);
    }

    return matches[0].file;
  }
}

module.exports = TargetResolver;
