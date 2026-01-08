import { TestBed } from "@angular/core/testing";
import { TargetResolverService } from "./target-resolver.service";

/**
 * Test file for TargetResolverService
 *
 * This demonstrates basic Angular testing with Jasmine.
 *
 * KEY CONCEPTS:
 * -------------
 * - describe(): Groups related tests together (test suite)
 * - beforeEach(): Runs before each test (it() block)
 * - TestBed: Angular's testing utility for configuring and initializing services/components
 * - it(): Defines a single test case
 * - expect(): Makes an assertion about what should be true
 */

describe("TargetResolverService", () => {
  // Variable to hold the service instance
  let service: TargetResolverService;

  // This runs before each test case
  // It sets up the Angular testing module and creates a fresh service instance
  beforeEach(() => {
    TestBed.configureTestingModule({}); // Configure the testing module (empty for simple service)
    service = TestBed.inject(TargetResolverService); // Get an instance of the service
  });

  // Test 1: Verify the service can be created
  it("should be created", () => {
    expect(service).toBeTruthy(); // Service should exist (not null/undefined)
  });

  // Test 2: Verify the service returns resolution information
  it("should return resolution info", () => {
    const info = service.getResolutionInfo();
    expect(info).toContain("barrel file"); // Info should mention barrel files
    expect(info).toContain("index.ts"); // Info should mention index.ts
  });
});
