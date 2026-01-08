import { Injectable } from "@angular/core";

/**
 * LargestSum Challenge - Version 1
 *
 * PROBLEM:
 * Find the sum of the two largest numbers in an array.
 *
 * EXAMPLES:
 * [0, 4, 2, 5, 0] → 9 (4 + 5)
 * [5, 4, 2, 5, 0] → 10 (5 + 5, duplicates allowed)
 *
 * REQUIREMENTS:
 * - Return 0 for null, undefined, or empty arrays
 * - Return the single element for single-element arrays
 * - Handle negative numbers
 * - Duplicates are allowed
 *
 * IMPLEMENTATION APPROACH:
 * This version uses a single-pass algorithm with two variables
 * to track the largest and second-largest values.
 */
@Injectable({
  providedIn: "root",
})
export class LargestSumService {
  constructor() {}

  /**
   * Calculate the sum of the two largest integers.
   *
   * ALGORITHM:
   * 1. Handle edge cases (null, empty, single element)
   * 2. Iterate through array once
   * 3. Track the largest and second-largest values
   * 4. Return their sum
   *
   * TIME COMPLEXITY: O(n) - single pass through array
   * SPACE COMPLEXITY: O(1) - only uses two variables
   *
   * @param nums - Array of numbers (can be null/undefined/empty)
   * @returns Sum of two largest numbers, or 0 if insufficient data
   */
  bigSum(nums: number[] | null | undefined): number {
    // Edge case 1: Handle null or undefined
    if (!nums || nums.length === 0) {
      return 0;
    }

    // Edge case 2: Single element - return it
    if (nums.length === 1) {
      return nums[0];
    }

    // Initialize trackers with smallest possible value
    let largest = -Infinity;
    let secondLargest = -Infinity;

    // Single pass through the array
    for (const num of nums) {
      if (num > largest) {
        // Found new largest - bump current largest to second place
        secondLargest = largest;
        largest = num;
      } else if (num > secondLargest) {
        // Found new second largest
        secondLargest = num;
      }
    }

    return largest + secondLargest;
  }
}
