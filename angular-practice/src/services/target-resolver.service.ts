import { Injectable } from '@angular/core';

/**
 * TargetResolver Service
 * 
 * This service helps automatically select the latest implementation of a challenge.
 * 
 * HOW IT WORKS:
 * -------------
 * In Angular, we use a "barrel file" pattern to export the current implementation.
 * 
 * Example structure:
 *   /src/challenges/largest-sum/
 *     ├── largest-sum.service.ts       (Attempt 1)
 *     ├── largest-sum-v2.service.ts    (Attempt 2)
 *     ├── largest-sum-v3.service.ts    (Attempt 3)
 *     └── index.ts                     (Barrel file - exports "current")
 * 
 * The index.ts barrel file exports whichever implementation you want to test:
 *   export { LargestSumV3Service as CurrentLargestSumService } from './largest-sum-v3.service';
 * 
 * Then in your test, you import from the barrel:
 *   import { CurrentLargestSumService } from './challenges/largest-sum';
 * 
 * To switch which implementation is tested, just update the barrel file export.
 * No need to change any test code!
 */
@Injectable({
  providedIn: 'root'  // Makes this service available throughout the app
})
export class TargetResolverService {

  constructor() { }

  /**
   * Get information about the current target resolution pattern.
   * 
   * This is informational only - the actual resolution happens
   * through barrel file exports (index.ts files).
   */
  getResolutionInfo(): string {
    return `
      Angular Practice uses barrel file exports for target resolution.
      
      To test a specific implementation:
      1. Update the barrel file (index.ts) in your challenge folder
      2. Export your chosen implementation as 'Current[ChallengeName]Service'
      3. Tests will automatically use that implementation
      
      Example:
        // In challenges/my-challenge/index.ts
        export { MyChallengeV2Service as CurrentMyChallengeService } from './my-challenge-v2.service';
    `;
  }
}
