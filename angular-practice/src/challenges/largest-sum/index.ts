/**
 * Barrel File for LargestSum Challenge
 * 
 * WHAT IS A BARREL FILE?
 * ----------------------
 * A barrel file (index.ts) re-exports items from multiple files
 * in a single location. This provides a clean import path and
 * allows us to control which implementation is "current".
 * 
 * HOW TO USE FOR PRACTICE:
 * ------------------------
 * 1. Create multiple implementations (v1, v2, v3, etc.)
 * 2. Export your chosen implementation as "CurrentLargestSumService"
 * 3. Tests import from this barrel file
 * 4. To test a different version, just change the export below
 * 
 * EXAMPLE: To test Version 1
 *   export { LargestSumService as CurrentLargestSumService } from './largest-sum.service';
 * 
 * EXAMPLE: To test Version 2
 *   export { LargestSumV2Service as CurrentLargestSumService } from './largest-sum-v2.service';
 */

// Currently testing: Version 2 (sorting approach)
// Change this line to test a different version!
export { LargestSumV2Service as CurrentLargestSumService } from './largest-sum-v2.service';

// Also export all versions individually (for manual comparison if needed)
export { LargestSumService } from './largest-sum.service';
export { LargestSumV2Service } from './largest-sum-v2.service';
