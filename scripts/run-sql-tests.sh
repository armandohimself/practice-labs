#!/bin/bash

# run-sql-tests.sh - Run SQL practice challenge tests
#
# This script uses SQLite to run SQL challenges against test data
# and validates the output matches expected results.

set -e

BASE_DIR="$(cd "$(dirname "$0")/.." && pwd)"
SQL_DIR="$BASE_DIR/sql-practice"
DATA_DIR="$SQL_DIR/data"
CHALLENGES_DIR="$SQL_DIR/challenges"
EXPECTED_DIR="$SQL_DIR/expected"

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo "🗄️  Running SQL Practice Tests"
echo "================================="

# Check if sqlite3 is available
if ! command -v sqlite3 &> /dev/null; then
    echo -e "${RED}❌ sqlite3 not found${NC}"
    echo "Install with: brew install sqlite3"
    exit 1
fi

# Create data directory if it doesn't exist
mkdir -p "$DATA_DIR"

# Initialize test database
DB_FILE="$DATA_DIR/test.db"
rm -f "$DB_FILE"

echo "📊 Initializing test database..."

# Load seed data
if [ -f "$SQL_DIR/seed.sql" ]; then
    sqlite3 "$DB_FILE" < "$SQL_DIR/seed.sql"
    echo "✅ Seed data loaded"
else
    echo -e "${YELLOW}⚠️  No seed.sql found${NC}"
fi

# Run each challenge
TOTAL=0
PASSED=0
FAILED=0

for challenge_file in "$CHALLENGES_DIR"/*.sql; do
    if [ ! -f "$challenge_file" ]; then
        continue
    fi

    TOTAL=$((TOTAL + 1))
    challenge_name=$(basename "$challenge_file" .sql)
    expected_file="$EXPECTED_DIR/${challenge_name}.txt"

    echo ""
    echo "Testing: $challenge_name"

    # Run the challenge query
    actual_output=$(sqlite3 -header -column "$DB_FILE" < "$challenge_file" 2>&1)

    if [ ! -f "$expected_file" ]; then
        echo -e "${YELLOW}⚠️  No expected output file: $expected_file${NC}"
        echo "Actual output:"
        echo "$actual_output"
        continue
    fi

    expected_output=$(cat "$expected_file")

    # Compare outputs
    if [ "$actual_output" = "$expected_output" ]; then
        echo -e "${GREEN}✅ PASSED${NC}"
        PASSED=$((PASSED + 1))
    else
        echo -e "${RED}❌ FAILED${NC}"
        echo "Expected:"
        echo "$expected_output"
        echo ""
        echo "Actual:"
        echo "$actual_output"
        FAILED=$((FAILED + 1))
    fi
done

# Summary
echo ""
echo "================================="
echo "📊 Test Summary"
echo "================================="
echo "Total:  $TOTAL"
echo -e "${GREEN}Passed: $PASSED${NC}"
if [ $FAILED -gt 0 ]; then
    echo -e "${RED}Failed: $FAILED${NC}"
    exit 1
else
    echo "Failed: $FAILED"
fi

echo ""
echo -e "${GREEN}✅ All tests passed!${NC}"
