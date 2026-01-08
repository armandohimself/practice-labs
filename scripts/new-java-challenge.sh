#!/bin/bash

# new-java-challenge.sh - Generate a new Java practice challenge
#
# Usage:
#   ./scripts/new-java-challenge.sh ChallengeName
#   ./scripts/new-java-challenge.sh ChallengeName 2  (create attempt #2)
#
# Examples:
#   ./scripts/new-java-challenge.sh LargestSum
#   ./scripts/new-java-challenge.sh LargestSum 2

set -e

if [ -z "$1" ]; then
    echo "❌ Error: Challenge name required"
    echo "Usage: $0 <ChallengeName> [attemptNumber]"
    echo "Example: $0 LargestSum"
    echo "Example: $0 LargestSum 2"
    exit 1
fi

CHALLENGE_NAME="$1"
ATTEMPT_NUM="${2:-}"  # Optional attempt number

# Convert to lowercase for package name
PACKAGE_NAME=$(echo "$CHALLENGE_NAME" | tr '[:upper:]' '[:lower:]')

# Determine class name
if [ -n "$ATTEMPT_NUM" ]; then
    CLASS_NAME="${CHALLENGE_NAME}${ATTEMPT_NUM}"
else
    CLASS_NAME="$CHALLENGE_NAME"
fi

# Paths
BASE_DIR="$(cd "$(dirname "$0")/.." && pwd)"
SRC_DIR="$BASE_DIR/java-practice/src/main/java/practice/$PACKAGE_NAME"
TEST_DIR="$BASE_DIR/java-practice/src/test/java/practice/$PACKAGE_NAME"

CLASS_FILE="$SRC_DIR/$CLASS_NAME.java"
TEST_FILE="$TEST_DIR/${CHALLENGE_NAME}Test.java"

echo "🔨 Creating Java challenge: $CLASS_NAME"

# Create directories
mkdir -p "$SRC_DIR"
mkdir -p "$TEST_DIR"

# Create implementation file
if [ -f "$CLASS_FILE" ]; then
    echo "⚠️  File already exists: $CLASS_FILE"
    read -p "Overwrite? (y/N) " -n 1 -r
    echo
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        echo "❌ Aborted"
        exit 1
    fi
fi

cat > "$CLASS_FILE" <<EOF
package practice.$PACKAGE_NAME;

/**
 * $CLASS_NAME Challenge
 *
 * TODO: Add challenge description here
 *
 * Example:
 *   Input: ...
 *   Output: ...
 */
public class $CLASS_NAME {

    /**
     * TODO: Add method signature and implementation
     *
     * @param input Description
     * @return Description
     */
    public Object solve(Object input) {
        // TODO: Implement your solution here
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
EOF

echo "✅ Created: $CLASS_FILE"

# Create test file (only if it doesn't exist)
if [ ! -f "$TEST_FILE" ]; then
    cat > "$TEST_FILE" <<EOF
package practice.$PACKAGE_NAME;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for $CHALLENGE_NAME challenge.
 *
 * These tests automatically run against your latest attempt.
 * Create new attempts: ${CHALLENGE_NAME}2.java, ${CHALLENGE_NAME}3.java, etc.
 *
 * Override target with: PRACTICE_TARGET=${CHALLENGE_NAME}2 ./gradlew test
 */
@DisplayName("$CHALLENGE_NAME Challenge Tests")
class ${CHALLENGE_NAME}Test {

    private $CHALLENGE_NAME solution;

    @BeforeEach
    void setUp() throws Exception {
        // Automatically resolve to the latest implementation
        solution = TargetResolver.resolve("practice.$PACKAGE_NAME", "$CHALLENGE_NAME");
    }

    @Test
    @DisplayName("TODO: Add test description")
    void testExample() {
        // TODO: Add your test cases here
        fail("Not implemented yet - add your test cases");
    }
}
EOF
    echo "✅ Created: $TEST_FILE"
else
    echo "ℹ️  Test file already exists: $TEST_FILE"
fi

echo ""
echo "========================================="
echo "✅ Challenge created successfully!"
echo "========================================="
echo ""
echo "📝 Next steps:"
echo "  1. Edit: $CLASS_FILE"
echo "  2. Add tests: $TEST_FILE"
echo "  3. Run tests: ./gradlew :java-practice:test --tests ${CHALLENGE_NAME}Test"
echo ""
echo "🎯 Create another attempt:"
echo "  ./scripts/new-java-challenge.sh $CHALLENGE_NAME 2"
echo ""
