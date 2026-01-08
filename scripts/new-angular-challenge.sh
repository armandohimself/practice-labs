#!/bin/bash

# new-angular-challenge.sh - Generate a new Angular practice challenge
#
# WHAT THIS SCRIPT DOES:
# ----------------------
# Creates the scaffolding for a new Angular challenge including:
# - Service file(s) for your implementation
# - Spec (test) file with pre-written test boilerplate
# - Barrel file (index.ts) for version management
#
# USAGE:
# ------
#   ./scripts/new-angular-challenge.sh <ChallengeName> [type] [version]
#
# PARAMETERS:
#   ChallengeName - Name of your challenge (PascalCase recommended)
#   type          - 'service' or 'component' (default: service)
#   version       - Version number for additional attempts (optional)
#
# EXAMPLES:
# ---------
#   # Create a new service challenge
#   ./scripts/new-angular-challenge.sh MyChallenge service
#
#   # Create version 2 of existing challenge
#   ./scripts/new-angular-challenge.sh MyChallenge service 2
#
#   # Create a component challenge (future feature)
#   ./scripts/new-angular-challenge.sh MyChallenge component

set -e  # Exit on any error

# Check if challenge name provided
if [ -z "$1" ]; then
    echo "❌ Error: Challenge name required"
    echo ""
    echo "Usage: $0 <ChallengeName> [type] [version]"
    echo ""
    echo "Examples:"
    echo "  $0 MyChallenge service          # Create new service challenge"
    echo "  $0 MyChallenge service 2        # Create version 2"
    echo ""
    exit 1
fi

# Parse arguments
CHALLENGE_NAME="$1"                    # e.g., "MyChallenge"
TYPE="${2:-service}"                   # Default to 'service'
VERSION="${3:-}"                       # Optional version number

# Convert challenge name to different case formats
# PascalCase -> kebab-case for folders/files
# e.g., "MyChallenge" -> "my-challenge"
KEBAB_NAME=$(echo "$CHALLENGE_NAME" | sed -E 's/([A-Z])/-\1/g' | sed 's/^-//' | tr '[:upper:]' '[:lower:]')

# Determine file names based on version
if [ -n "$VERSION" ]; then
    # Version 2, 3, etc.
    SERVICE_CLASS="${CHALLENGE_NAME}V${VERSION}Service"
    SERVICE_FILE="${KEBAB_NAME}-v${VERSION}.service"
else
    # Version 1 (no suffix)
    SERVICE_CLASS="${CHALLENGE_NAME}Service"
    SERVICE_FILE="${KEBAB_NAME}.service"
fi

# Set up directory paths
BASE_DIR="$(cd "$(dirname "$0")/.." && pwd)"
CHALLENGE_DIR="$BASE_DIR/angular-practice/src/challenges/$KEBAB_NAME"

# TypeScript file paths
SERVICE_TS="$CHALLENGE_DIR/${SERVICE_FILE}.ts"
SPEC_TS="$CHALLENGE_DIR/${KEBAB_NAME}.service.spec.ts"
INDEX_TS="$CHALLENGE_DIR/index.ts"

echo "🔨 Creating Angular challenge: $CHALLENGE_NAME"
echo "📁 Location: $CHALLENGE_DIR"

# Create challenge directory if it doesn't exist
mkdir -p "$CHALLENGE_DIR"

# ============================================================================
# CREATE SERVICE FILE
# ============================================================================
if [ -f "$SERVICE_TS" ]; then
    echo "⚠️  File already exists: $SERVICE_TS"
    read -p "Overwrite? (y/N) " -n 1 -r
    echo
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        echo "❌ Aborted"
        exit 1
    fi
fi

cat > "$SERVICE_TS" <<EOF
import { Injectable } from '@angular/core';

/**
 * $SERVICE_CLASS
 *
 * PROBLEM:
 * [TODO: Describe the challenge problem here]
 *
 * EXAMPLES:
 * [TODO: Add example inputs and outputs]
 *   Input: ...
 *   Output: ...
 *
 * REQUIREMENTS:
 * [TODO: List any special requirements or constraints]
 */
@Injectable({
  providedIn: 'root'
})
export class $SERVICE_CLASS {

  constructor() { }

  /**
   * [TODO: Add method description]
   *
   * ALGORITHM:
   * [TODO: Describe your approach]
   *
   * TIME COMPLEXITY: [TODO]
   * SPACE COMPLEXITY: [TODO]
   *
   * @param input - [TODO: Describe parameter]
   * @returns [TODO: Describe return value]
   */
  solve(input: any): any {
    // TODO: Implement your solution here
    throw new Error('Not implemented yet');
  }
}
EOF

echo "✅ Created: $SERVICE_TS"

# ============================================================================
# CREATE TEST FILE (only if it doesn't exist)
# ============================================================================
if [ ! -f "$SPEC_TS" ]; then
    cat > "$SPEC_TS" <<EOF
import { TestBed } from '@angular/core/testing';
import { Current${CHALLENGE_NAME}Service } from './index';

/**
 * Tests for $CHALLENGE_NAME Challenge
 *
 * IMPORTANT: These tests import from the barrel file (./index)
 * This means they automatically test whichever version is exported
 * as "Current${CHALLENGE_NAME}Service" in index.ts
 *
 * TO TEST A DIFFERENT VERSION:
 * Just update the export in index.ts - NO need to change this test file!
 *
 * HOW TO ADD TESTS:
 * -----------------
 * 1. Create a describe() block for a group of related tests
 * 2. Use it() to define individual test cases
 * 3. Use expect() to make assertions
 *
 * EXAMPLE:
 *   it('should handle basic case', () => {
 *     expect(service.solve(input)).toBe(expected);
 *   });
 */

describe('$CHALLENGE_NAME Challenge (Current Implementation)', () => {
  let service: Current${CHALLENGE_NAME}Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Current${CHALLENGE_NAME}Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('Basic functionality', () => {

    it('should handle basic case', () => {
      // TODO: Add your test
      // const result = service.solve(input);
      // expect(result).toBe(expected);
      pending('Add your test implementation');
    });

    // TODO: Add more test cases
  });

  describe('Edge cases', () => {

    it('should handle null input', () => {
      // TODO: Test null/undefined handling
      pending('Add your test implementation');
    });

    it('should handle empty input', () => {
      // TODO: Test empty input handling
      pending('Add your test implementation');
    });

    // TODO: Add more edge case tests
  });
});
EOF
    echo "✅ Created: $SPEC_TS"
else
    echo "ℹ️  Test file already exists: $SPEC_TS"
fi

# ============================================================================
# CREATE OR UPDATE BARREL FILE (index.ts)
# ============================================================================
if [ ! -f "$INDEX_TS" ]; then
    # Create new barrel file for version 1
    cat > "$INDEX_TS" <<EOF
/**
 * Barrel File for $CHALLENGE_NAME Challenge
 *
 * WHAT IS A BARREL FILE?
 * ----------------------
 * A barrel file (index.ts) re-exports items from multiple files.
 * This lets tests import from one location and automatically test
 * whichever version you specify as "current".
 *
 * HOW TO USE:
 * -----------
 * 1. Create multiple versions (v1, v2, v3, etc.)
 * 2. Export your chosen version as "Current${CHALLENGE_NAME}Service"
 * 3. Tests import from this file
 * 4. To test a different version, just change the export below
 *
 * TO SWITCH VERSIONS:
 * Change the line below to export a different version!
 */

// Currently testing: Version 1
export { ${SERVICE_CLASS} as Current${CHALLENGE_NAME}Service } from './${SERVICE_FILE}';

// Also export all versions individually
export { ${SERVICE_CLASS} } from './${SERVICE_FILE}';
EOF
    echo "✅ Created: $INDEX_TS"
else
    # Update existing barrel file to add new version
    if [ -n "$VERSION" ]; then
        # Add export for new version
        echo "" >> "$INDEX_TS"
        echo "// Version $VERSION" >> "$INDEX_TS"
        echo "export { ${SERVICE_CLASS} } from './${SERVICE_FILE}';" >> "$INDEX_TS"
        echo "ℹ️  Updated: $INDEX_TS (added version $VERSION export)"
        echo ""
        echo "⚠️  To test this version, update the 'Current' export in $INDEX_TS"
    else
        echo "ℹ️  Barrel file already exists: $INDEX_TS"
    fi
fi

# ============================================================================
# SUMMARY
# ============================================================================
echo ""
echo "========================================="
echo "✅ Challenge created successfully!"
echo "========================================="
echo ""
echo "📝 Next steps:"
echo "  1. Edit: $SERVICE_TS"
echo "  2. Add tests: $SPEC_TS"
if [ -n "$VERSION" ]; then
    echo "  3. Update barrel: $INDEX_TS (change Current export to V$VERSION)"
    echo "  4. Run tests: cd angular-practice && npm test"
else
    echo "  3. Run tests: cd angular-practice && npm test"
fi
echo ""
echo "🎯 Create another version:"
echo "  ./scripts/new-angular-challenge.sh $CHALLENGE_NAME service 2"
echo ""
