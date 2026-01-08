import { TestBed } from '@angular/core/testing';
import { CurrentLargestSumService } from './index';

/**
 * Tests for LargestSum Challenge
 * 
 * IMPORTANT: These tests import from the barrel file (./index)
 * This means they automatically test whichever version is exported
 * as "CurrentLargestSumService" in index.ts
 * 
 * TO TEST A DIFFERENT VERSION:
 * Just update the export in index.ts - NO need to change this test file!
 * 
 * HOW ANGULAR TESTING WORKS:
 * --------------------------
 * 1. TestBed.configureTestingModule() - Sets up the testing environment
 * 2. TestBed.inject() - Gets an instance of the service
 * 3. expect() - Makes assertions about expected behavior
 * 
 * TEST STRUCTURE:
 * ---------------
 * - describe() blocks group related tests
 * - beforeEach() runs setup code before each test
 * - it() blocks define individual test cases
 */

describe('LargestSum Challenge (Current Implementation)', () => {
  let service: CurrentLargestSumService;

  // Setup: Create fresh service instance before each test
  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CurrentLargestSumService);
  });

  // Verify service creation
  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  // GROUP: Basic functionality tests
  describe('Basic functionality', () => {
    
    it('should handle duplicates (5+5=10)', () => {
      const nums = [5, 4, 2, 5, 0];
      expect(service.bigSum(nums)).toBe(10);
    });
    
    it('should handle normal case (5+4=9)', () => {
      const nums = [0, 4, 2, 5, 0];
      expect(service.bigSum(nums)).toBe(9);
    });
    
    it('should handle negative numbers', () => {
      const nums = [-5, -2, -8, -1, -3];
      expect(service.bigSum(nums)).toBe(-3); // -1 + (-2)
    });
    
    it('should handle mixed positive and negative', () => {
      const nums = [-5, 10, -2, 8, -1];
      expect(service.bigSum(nums)).toBe(18); // 10 + 8
    });
  });

  // GROUP: Edge cases
  describe('Edge cases', () => {
    
    it('should return 0 for null', () => {
      expect(service.bigSum(null)).toBe(0);
    });
    
    it('should return 0 for undefined', () => {
      expect(service.bigSum(undefined)).toBe(0);
    });
    
    it('should return 0 for empty array', () => {
      expect(service.bigSum([])).toBe(0);
    });
    
    it('should return element for single-element array', () => {
      expect(service.bigSum([42])).toBe(42);
    });
    
    it('should handle two-element array', () => {
      expect(service.bigSum([3, 7])).toBe(10);
    });
    
    it('should handle all same values', () => {
      expect(service.bigSum([5, 5, 5, 5])).toBe(10);
    });
    
    it('should handle large numbers', () => {
      expect(service.bigSum([1000000, 999999, 1, 2, 3])).toBe(1999999);
    });
  });
});
