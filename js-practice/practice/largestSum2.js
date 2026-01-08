/**
 * LargestSum Challenge - Attempt 2
 *
 * Alternative approach using sorting
 */

function bigSum(nums) {
  if (!nums || nums.length === 0) {
    return 0;
  }

  if (nums.length === 1) {
    return nums[0];
  }

  // Alternative: Sort and take top 2
  const sorted = [...nums].sort((a, b) => b - a);
  return sorted[0] + sorted[1];
}

module.exports = { bigSum };
