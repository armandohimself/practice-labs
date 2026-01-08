const TargetResolver = require("../utils/targetResolver");

/**
 * Tests for LargestSum challenge.
 *
 * These tests automatically run against your latest attempt.
 * Create new attempts: largestSum2.js, largestSum3.js, etc.
 *
 * Override target with: PRACTICE_TARGET=largestSum2 npm test
 */
describe("LargestSum Challenge", () => {
  let solution;

  beforeAll(() => {
    // Automatically resolve to the latest implementation
    solution = TargetResolver.resolve("largestSum");
  });

  describe("Basic functionality", () => {
    test("should handle duplicates (5+5=10)", () => {
      const nums = [5, 4, 2, 5, 0];
      expect(solution.bigSum(nums)).toBe(10);
    });

    test("should handle normal case (5+4=9)", () => {
      const nums = [0, 4, 2, 5, 0];
      expect(solution.bigSum(nums)).toBe(9);
    });

    test("should handle negative numbers", () => {
      const nums = [-5, -2, -8, -1, -3];
      expect(solution.bigSum(nums)).toBe(-3); // -1 + (-2)
    });

    test("should handle mixed positive and negative", () => {
      const nums = [-5, 10, -2, 8, -1];
      expect(solution.bigSum(nums)).toBe(18); // 10 + 8
    });
  });

  describe("Edge cases", () => {
    test("should return 0 for null", () => {
      expect(solution.bigSum(null)).toBe(0);
    });

    test("should return 0 for undefined", () => {
      expect(solution.bigSum(undefined)).toBe(0);
    });

    test("should return 0 for empty array", () => {
      expect(solution.bigSum([])).toBe(0);
    });

    test("should return element for single-element array", () => {
      expect(solution.bigSum([42])).toBe(42);
    });

    test("should handle two-element array", () => {
      expect(solution.bigSum([3, 7])).toBe(10);
    });

    test("should handle all same values", () => {
      expect(solution.bigSum([5, 5, 5, 5])).toBe(10);
    });

    test("should handle large numbers", () => {
      expect(solution.bigSum([1000000, 999999, 1, 2, 3])).toBe(1999999);
    });
  });
});
