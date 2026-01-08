# Challenge Scaffolding Guide

This document explains how challenge scaffolds were created and how to add more.

## Current Status

### Implemented (6 challenges)

1. **LargestSum** (existing - has working solution)
   - Find sum of two largest numbers in a list
   - Package: `practice.largestsum`

2. **HelloWorld** ✨ NEW
   - Return "Hello, world!" string
   - Package: `practice.helloworld`

3. **FizzBuzz** ✨ NEW
   - Return "Fizz", "Buzz", "FizzBuzz" or "" based on divisibility rules
   - Package: `practice.fizzbuzz`

4. **EvenOrOdd** ✨ NEW
   - Determine if number is even or odd
   - Package: `practice.evenorodd`

5. **Contains** ✨ NEW
   - Check if array contains a target value
   - Package: `practice.contains`

6. **GetMax** ✨ NEW
   - Find maximum value in an array
   - Package: `practice.getmax`

## Pending Challenges (from PEPLabs)

The following challenges are available in the [PEPLabs](https://github.com/PEPLabs) organization and can be added following the same pattern:

### Basic Java Fundamentals
- InsertPosition
- Arrays
- Add
- Subtract
- Math
- Comparisons
- BooleanOperators
- AdvancedBooleans
- CharComparison

### String Manipulation
- CombineStrings
- StringMethods
- OtherStringMethods
- IndexOf
- ReturnLongestString
- ReverseAString
- RemoveAllCharacters
- StringIsPalindrome
- Isogram
- PigLatin

### Arrays & Collections
- ReturnArrayContents
- ArraySum
- ArrayAbsoluteValue
- SubArray
- Search2dArray
- ArraysAreEqual
- SetAllArrayElementsToN
- DoesNotContain
- ContainsDuplicates
- IsSorted
- IsThereSum

### Algorithms
- MaxMinusMin
- GreaterOrLesser
- Fibonacci
- Pyramid
- Average

### Object-Oriented Programming
- IntroToOOP
- Instantiation
- Constructors
- MethodParameters
- Casting
- Overriding
- ParentObjectClassMethods
- Interfaces
- Generic
- StaticKeyword

### Data Structures
- Queue
- Stack
- Sets
- Lists
- Map

### Exception Handling
- Exceptions
- UncheckedException
- ThrowCustomException

### Practical Applications
- BankAccount
- GroceryList
- FlightTracker
- Library
- WordCount
- WordCountMap
- MostCommonCharacter
- GuessingGame

### Control Flow
- ForLoop
- WhileLoop
- EvenOrOdd (✅ completed)

### SQL Challenges
- CreateTable
- SelectAll
- SelectColumns (SelectWhere)
- SelectWhere
- SelectWhereAndOr
- Insert
- Update
- Delete
- AlterTable
- Truncate
- DropTable
- CreateView
- InnerJoin
- OuterJoin
- GroupBy
- OrderBy
- AggregateFunctions
- PrimaryKey
- ForeignKey

### Spring Boot / Web
- CreatingEndpoints
- PathParameters
- RequestBody
- StatusCodes
- HardcodedLogin

## How to Add a New Challenge

### 1. Create Directory Structure

```bash
mkdir -p java-practice/src/main/java/practice/<packagename>
mkdir -p java-practice/src/test/java/practice/<packagename>
```

Where `<packagename>` is the challenge name in lowercase (e.g., `insertposition`).

### 2. Fetch Original Files from PEPLabs

Visit `https://github.com/PEPLabs/<ChallengeName>` and locate:
- Implementation: `src/main/java/Lab.java` or `src/main/java/<ChallengeName>.java`
- Tests: `src/test/java/<ChallengeName>Test.java` or `src/test/java/LabTest.java`

### 3. Create Interface File

Create `<ChallengeName>Solution.java`:

```java
package practice.<packagename>;

/**
 * Interface for <ChallengeName> challenge implementations.
 */
public interface <ChallengeName>Solution {
    // Add method signatures from implementation
    ReturnType methodName(ParamType param);
}
```

### 4. Create Implementation File

Create `<ChallengeName>.java` with:
- Package declaration: `package practice.<packagename>;`
- Original PEPLabs code (preserve javadocs and TODOs)
- Implement the interface: `implements <ChallengeName>Solution`
- Add source attribution comment at top

Example:
```java
package practice.insertposition;

/**
 * InsertPosition Challenge
 * 
 * Original source: https://github.com/PEPLabs/InsertPosition
 * 
 * [Original description from PEPLabs]
 */
public class InsertPosition implements InsertPositionSolution {
    public int searchInsert(int[] nums, int target) {
        return -1; // TODO: Implement
    }
}
```

### 5. Create Test File

Create `<ChallengeName>Test.java`:

```java
package practice.<packagename>;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("<ChallengeName> Challenge Tests")
class <ChallengeName>Test {

    private <ChallengeName>Solution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.<packagename>", "<ChallengeName>");
    }

    @Test
    @DisplayName("Test description")
    public void test1() {
        // Convert JUnit 4 tests to JUnit 5
        // Replace Assert.assertEquals with assertEquals
        // Add @DisplayName annotations
    }
}
```

### 6. Adapt JUnit 4 to JUnit 5

Original PEPLabs tests use JUnit 4. Convert to JUnit 5:

**JUnit 4 → JUnit 5 Mapping:**

| JUnit 4 | JUnit 5 |
|---------|---------|
| `import org.junit.Test;` | `import org.junit.jupiter.api.Test;` |
| `import org.junit.Assert;` | `import static org.junit.jupiter.api.Assertions.*;` |
| `@BeforeClass public static void setUp()` | `@BeforeEach void setUp()` |
| `Assert.assertEquals(expected, actual)` | `assertEquals(expected, actual)` |
| `@Test public void testName()` | `@Test @DisplayName("Description") void testName()` |

### 7. Build and Test

```bash
# Compile
gradle :java-practice:compileJava

# Run tests (they should fail for scaffolds)
gradle :java-practice:test

# Run specific challenge tests
gradle :java-practice:test --tests <ChallengeName>Test
```

### 8. Verify

- [ ] Code compiles without errors
- [ ] Tests run (failing is OK for scaffolds)
- [ ] TargetResolver finds the implementation
- [ ] Package declarations are correct
- [ ] Original PEPLabs documentation preserved

## Pattern Summary

Each challenge follows this structure:

```
java-practice/src/
├── main/java/practice/<packagename>/
│   ├── <ChallengeName>.java          # Implementation (scaffold)
│   └── <ChallengeName>Solution.java   # Interface
└── test/java/practice/<packagename>/
    └── <ChallengeName>Test.java       # Tests with TargetResolver
```

## Best Practices

1. **Preserve Original Code**: Keep PEPLabs javadocs and TODOs intact
2. **Attribution**: Add source URL in implementation file header
3. **Lowercase Packages**: Package names should be lowercase challenge name
4. **Interface Naming**: Use `<ChallengeName>Solution` pattern
5. **Test Consistency**: All tests use TargetResolver pattern
6. **Display Names**: Add meaningful @DisplayName to tests

## Example: Complete Workflow

```bash
# 1. Create directories
mkdir -p java-practice/src/main/java/practice/fibonacci
mkdir -p java-practice/src/test/java/practice/fibonacci

# 2. Fetch from PEPLabs
# Visit: https://github.com/PEPLabs/Fibonacci
# Copy implementation and test content

# 3. Create three files:
# - FibonacciSolution.java (interface)
# - Fibonacci.java (implementation)
# - FibonacciTest.java (tests)

# 4. Build and verify
gradle :java-practice:test --tests FibonacciTest

# 5. Commit
git add java-practice/src/main/java/practice/fibonacci
git add java-practice/src/test/java/practice/fibonacci
git commit -m "Add Fibonacci challenge scaffold"
```

## SQL Challenges Note

SQL challenges from PEPLabs are designed for the `sql-practice` module, not `java-practice`. They should be added to the SQL practice section following the SQL testing pattern documented in `sql-practice/README.md`.

## Spring Boot Challenges Note

Spring Boot challenges (CreatingEndpoints, PathParameters, etc.) may require additional Spring dependencies and configuration. Consider adding these to a separate `spring-practice` module if pursuing that direction.
