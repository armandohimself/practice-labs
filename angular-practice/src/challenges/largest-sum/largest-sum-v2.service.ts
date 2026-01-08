import { Injectable } from '@angular/core';

/**
 * LargestSum Challenge - Version 2
 * 
 * ALTERNATIVE IMPLEMENTATION using array sorting.
 * 
 * Same problem as Version 1, but uses a different approach.
 * 
 * IMPLEMENTATION APPROACH:
 * This version sorts the array and takes the top 2 elements.
 * 
 * TRADE-OFFS:
 * - Simpler code (easier to understand)
 * - Worse time complexity: O(n log n) vs O(n)
 * - Creates a copy of the array: O(n) space vs O(1)
 * 
 * Use this version to compare different algorithmic approaches!
 */
@Injectable({
  providedIn: 'root'
})
export class LargestSumV2Service {

  constructor() { }

  /**
   * Calculate the sum of the two largest integers using sorting.
   * 
   * ALGORITHM:
   * 1. Handle edge cases
   * 2. Sort array in descending order
   * 3. Sum first two elements
   * 
   * TIME COMPLEXITY: O(n log n) - due to sorting
   * SPACE COMPLEXITY: O(n) - creates array copy
   * 
   * @param nums - Array of numbers
   * @returns Sum of two largest numbers
   */
  bigSum(nums: number[] | null | undefined): number {
    // Edge cases
    if (!nums || nums.length === 0) {
      return 0;
    }
    
    if (nums.length === 1) {
      return nums[0];
    }
    
    // Sort in descending order (largest first)
    // [...nums] creates a copy so we don't modify the original
    const sorted = [...nums].sort((a, b) => b - a);
    
    // Sum the first two elements
    return sorted[0] + sorted[1];
  }
}
