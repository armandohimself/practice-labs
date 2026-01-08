# Creating New Challenges

This guide explains how to create new practice challenges in the Practice Labs environment.

## Java Challenges

### Using the Generator Script (Recommended)

```bash
# Create a new challenge
./scripts/new-java-challenge.sh MyChallenge

# Create attempt #2 of an existing challenge
./scripts/new-java-challenge.sh MyChallenge 2
```

This automatically creates:

- Implementation file: `java-practice/src/main/java/practice/mychallenge/MyChallenge.java`
- Test file: `java-practice/src/test/java/practice/mychallenge/MyChallengeTest.java` (if it doesn't exist)
- Proper package structure

### Manual Creation

1. **Create an interface** (optional but recommended for multiple attempts):

    ```java
    // java-practice/src/main/java/practice/mychallenge/MyChallengeSolution.java
    package practice.mychallenge;

    public interface MyChallengeSolution {
        ResultType solve(InputType input);
    }
    ```

2. **Create implementation(s)**:

    ```java
    // java-practice/src/main/java/practice/mychallenge/MyChallenge.java
    package practice.mychallenge;

    public class MyChallenge implements MyChallengeSolution {
        @Override
        public ResultType solve(InputType input) {
            // Your solution
        }
    }

    // Later attempts: MyChallenge2.java, MyChallenge3.java, etc.
    ```

3. **Create test file**:

    ```java
    // java-practice/src/test/java/practice/mychallenge/MyChallengeTest.java
    package practice.mychallenge;

    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;
    import practice.util.TargetResolver;
    import static org.junit.jupiter.api.Assertions.*;

    @DisplayName("MyChallenge Tests")
    class MyChallengeTest {

        private MyChallengeSolution solution;

        @BeforeEach
        void setUp() throws Exception {
            solution = TargetResolver.resolve("practice.mychallenge", "MyChallenge");
        }

        @Test
        @DisplayName("Test case 1")
        void testExample() {
            assertEquals(expected, solution.solve(input));
        }
    }
    ```

## JavaScript Challenges

### Create Implementation

```javascript
// js-practice/practice/myChallenge.js
function solve(input) {
  // Your solution
}

module.exports = { solve };
```

### Create Test File

```javascript
// js-practice/tests/myChallenge.test.js
const TargetResolver = require("../utils/targetResolver");

describe("MyChallenge", () => {
  let solution;

  beforeAll(() => {
    solution = TargetResolver.resolve("myChallenge");
  });

  test("should handle basic case", () => {
    expect(solution.solve(input)).toBe(expected);
  });
});
```

### Create Additional Attempts

Just create numbered files:

- `myChallenge2.js`
- `myChallenge3.js`
- etc.

The tests automatically use the highest number.

## SQL Challenges

### 1. Add Challenge Query

```sql
-- sql-practice/challenges/my_query.sql
SELECT
    column1,
    column2
FROM table_name
WHERE condition
ORDER BY column1;
```

### 2. Run and Capture Expected Output

```bash
./scripts/run-sql-tests.sh
```

This will show the actual output.

### 3. Save Expected Output

Copy the output and save it:

```bash
# sql-practice/expected/my_query.txt
column1  column2
-------  -------
value1   value2
value3   value4
```

**Important**: The output format must match exactly (including spacing).

## Best Practices

### Naming Conventions

- **Java**: PascalCase (e.g., `TwoSum`, `LongestSubstring`)
- **JavaScript**: camelCase (e.g., `twoSum`, `longestSubstring`)
- **SQL**: snake_case (e.g., `top_customers`, `sales_by_region`)

### Challenge Structure

1. **Clear Problem Statement**: Include in class/file docstring
2. **Examples**: Show input → output
3. **Edge Cases**: Document expected behavior for:

   - Null/undefined/empty inputs
   - Single-element collections
   - Negative numbers
   - Large values
   - Special characters (for strings)

4. **Constraints**: Document any limitations

### Test Coverage

Include tests for:

- ✅ Basic/happy path cases
- ✅ Edge cases
- ✅ Boundary conditions
- ✅ Error conditions
- ✅ Performance (if relevant)

### Example Template

```java
/**
 * [Challenge Name]
 *
 * [Brief description of the problem]
 *
 * Example:
 *   Input: [example input]
 *   Output: [expected output]
 *
 * Example 2:
 *   Input: [example input]
 *   Output: [expected output]
 *
 * Constraints:
 *   - [constraint 1]
 *   - [constraint 2]
 *
 * Edge Cases:
 *   - Null → [expected behavior]
 *   - Empty → [expected behavior]
 */
public class ChallengeName implements ChallengeNameSolution {
    public ResultType methodName(InputType input) {
        // Implementation
    }
}
```

## Workflow

1. **Create** challenge using generator or manually
2. **Implement** initial solution
3. **Write tests** covering all cases
4. **Run tests**: `./gradlew test` or `npm test`
5. **Create attempt 2** when you want to try a different approach
6. **Tests automatically run** against your latest attempt
7. **Compare approaches** using `PRACTICE_TARGET` environment variable

## Tips

- Start with the simplest working solution
- Don't over-engineer on first attempt
- Use subsequent attempts to try:

  - Different algorithms
  - Performance optimizations
  - Alternative data structures
  - Different coding styles

- Keep test files unchanged - they should work for all attempts
- Use meaningful variable names
- Add comments explaining complex logic

## Getting Help

- Check existing challenges (e.g., `LargestSum`) as examples
- Review the [main README](../README.md)
- Test your implementation before creating additional attempts
