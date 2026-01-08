/**
 * LargestSum Challenge
 *
 * Find the sum of the two largest integers in an array.
 *
 * Example:
 *   [0, 4, 2, 5, 0] -> 9 (4 + 5)
 *   [5, 4, 2, 5, 0] -> 10 (5 + 5)
 *
 * Requirements:
 *   - Return 0 for null, undefined, or empty arrays
 *   - Return the single element for single-element arrays
 *   - Handle negative numbers
 *   - Duplicates are allowed (can sum the same value twice)
 */

/**
 * Calculate the sum of the two largest integers.
 *
 * @param {number[]|null|undefined} nums - Array of numbers
 * @returns {number} Sum of two largest integers, or 0 if insufficient data
 */
function bigSum(nums) {
  // TODO: Implement your solution here

  if (!nums || nums.length === 0) {
    return 0;
  }

  if (nums.length === 1) {
    return nums[0];
  }

  // Find two largest numbers
  let largest = -Infinity;
  let secondLargest = -Infinity;

  for (const num of nums) {
    if (num > largest) {
      secondLargest = largest;
      largest = num;
    } else if (num > secondLargest) {
      secondLargest = num;
    }
  }

  return largest + secondLargest;
}

module.exports = { bigSum };
