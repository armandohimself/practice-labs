# Java Practice Challenges

This directory contains **87 Java coding challenges** with automated testing using JUnit 5.

## Structure

```
java-practice/
├── src/
│   ├── main/java/practice/          # Challenge implementations
│   │   ├── largestsum/
│   │   │   ├── LargestSum.java      # Your solution
│   │   │   ├── LargestSum2.java     # Second attempt (optional)
│   │   │   └── Application.java     # Main runner
│   │   ├── fibonacci/
│   │   ├── fizzbuzz/
│   │   └── ... (87 total challenges)
│   └── test/java/practice/          # Test files
│       ├── largestsum/LargestSumTest.java
│       ├── fibonacci/FibonacciTest.java
│       └── ... (60 test suites, 234+ tests)
└── build.gradle
```

## Challenge Categories

### Algorithms (15+)
- FizzBuzz, Fibonacci, Prime Numbers
- Sorting and Searching (Binary Search, Insert Position)
- Two-Sum, Largest Sum, Array Absolute Value
- Even/Odd Detection, Get Max/Min

### Data Structures (20+)
- **Arrays**: ArraysAreEqual, Contains, DoesNotContain, ContainsDuplicates, SubArray
- **Lists**: ArrayList operations, List exercises
- **Maps**: HashMap operations, WordCountMap, Map exercises
- **Sets**: HashSet operations, Set exercises
- **Queues**: Queue operations and exercises
- **Stacks**: Stack implementations

### String Manipulation (15+)
- Palindrome, Reverse String, Return Longest String
- Pig Latin, Isogram, Char Comparison
- Most Common Character, String Methods
- Index Of, String Concatenation

### Object-Oriented Programming (10+)
- Classes and Constructors
- Inheritance and Polymorphism
- Generics
- BankAccount, FlightTracker, GroceryList

### Exception Handling (5+)
- Checked Exceptions
- Unchecked Exceptions
- Custom Exceptions
- Throw Custom Exception

### Boolean Logic & Control Flow (10+)
- Advanced Booleans, Boolean Operators
- Comparisons, Greater or Lesser
- For Loops, While Loops
- If Statements

### Type Conversion (3+)
- Casting
- Type conversions
- Parsing

### Other (9+)
- Instantiation
- Average calculations
- Guessing Game
- Hard-coded Login
- Is Sorted, Is There Sum

## Running Tests

### All Tests
```bash
./gradlew :java-practice:test
```

### Specific Test Class
```bash
./gradlew :java-practice:test --tests LargestSumTest
./gradlew :java-practice:test --tests FizzBuzzTest
```

### With Latest Attempt Selection
Tests automatically run against your newest solution (e.g., `LargestSum3.java` over `LargestSum2.java`).

Override to test a specific attempt:
```bash
PRACTICE_TARGET=LargestSum2 ./gradlew :java-practice:test --tests LargestSumTest
```

### Force Re-run (ignore caching)
```bash
./gradlew :java-practice:test --rerun-tasks
```

## Creating New Solutions

### Method 1: Use the Script
```bash
./scripts/new-java-challenge.sh MyChallenge
```

This creates:
- `src/main/java/practice/mychallenge/MyChallenge.java`
- `src/main/java/practice/mychallenge/Application.java`
- `src/test/java/practice/mychallenge/MyChallengeTest.java`

### Method 2: Manual Creation
1. Create package directory: `src/main/java/practice/yourchallenge/`
2. Add your solution class: `YourChallenge.java`
3. Add test file: `src/test/java/practice/yourchallenge/YourChallengeTest.java`

## Multiple Attempts

Work on the same challenge multiple times without editing tests:

```bash
practice/largestsum/
├── LargestSum.java      # First attempt
├── LargestSum2.java     # Second attempt (tests run this)
└── LargestSum3.java     # Third attempt (tests run this automatically!)
```

The `TargetResolver` utility automatically discovers and tests your latest attempt.

## Test Status

- ✅ **234+ tests** across 60 test suites
- ✅ All tests compile and pass
- ⚠️ **5 challenges** have smoke tests (original tests had compilation errors):
  - `SimpleStringMethodsTest`
  - `OtherStringMethodsTest`
  - `MostCommonCharacterTest`
  - `MapExerciseTest`
  - `InsertPositionTest`

These can be improved by reviewing the original challenge requirements and rewriting proper assertions.

## Build Information

- **Java**: 17+ (compatible with Java 21)
- **Gradle**: 8.5
- **Testing Framework**: JUnit 5 (Jupiter)
- **Build Tool**: Gradle with Kotlin DSL

## Common Issues

### Tests showing "UP-TO-DATE"
Gradle uses incremental builds. If you see:
```
BUILD SUCCESSFUL in 384ms
3 actionable tasks: 3 up-to-date
```

This means Gradle detected no changes since last run (cached). Force re-run:
```bash
./gradlew :java-practice:test --rerun-tasks
```

### Class Not Found
Make sure package declarations match directory structure:
```java
// File: src/main/java/practice/fibonacci/Fibonacci.java
package practice.fibonacci;  // Must match directory path
```

## Contributing

When adding new challenges:
1. Follow existing naming conventions (PascalCase for classes)
2. Use JUnit 5 annotations (`@Test`, `@BeforeEach`, etc.)
3. Add descriptive JavaDoc comments
4. Include multiple test cases (happy path, edge cases)
5. Use `assertEquals(expected, actual)` format

## Resources

- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)
- [Gradle Java Testing](https://docs.gradle.org/current/userguide/java_testing.html)
- [Java 17 Documentation](https://docs.oracle.com/en/java/javase/17/)
