# Practice Labs - Setup Complete! 🎉

Your multi-language practice environment is ready to use.

## What's Been Created

### ✅ Core Infrastructure

- [x] Multi-module Gradle project with Java 17
- [x] Node.js + Jest for JavaScript
- [x] SQLite-based SQL testing
- [x] GitHub Actions CI/CD pipeline
- [x] Automatic "latest attempt" resolution system

### ✅ Working Examples

- [x] **Java**: LargestSum challenge with 2 attempts

  - `LargestSum.java` - Original implementation
  - `LargestSum2.java` - Second attempt (currently tested)
  - Tests automatically select LargestSum2

- [x] **JavaScript**: LargestSum challenge with 2 attempts

  - `largestSum.js` - Original implementation
  - `largestSum2.js` - Alternative using sort (currently tested)
  - Tests automatically select largestSum2.js

- [x] **SQL**: Top N Customers example
  - Seed data with customers and orders
  - Example query with expected output validation

### ✅ Developer Tools

- [x] Java challenge generator: `./scripts/new-java-challenge.sh`
- [x] SQL test runner: `./scripts/run-sql-tests.sh`
- [x] Comprehensive documentation

## Quick Verification

Run all tests to confirm everything works:

```bash
# Java tests (confirms LargestSum2 is tested)
./gradlew :java-practice:test

# JavaScript tests (confirms largestSum2.js is tested)
cd js-practice && npm test && cd ..

# SQL tests
./scripts/run-sql-tests.sh

# All at once
./gradlew testAll && cd js-practice && npm test && cd .. && ./scripts/run-sql-tests.sh
```

## Key Features Demonstrated

### 1. Automatic Latest-Attempt Selection ✨

**Java Output:**

```
🎯 Testing latest attempt: practice.largestsum.LargestSum2
```

**JavaScript Output:**

```
🎯 Testing latest attempt: largestSum2.js
```

### 2. Manual Override Capability

```bash
# Java - test specific attempt
PRACTICE_TARGET=LargestSum ./gradlew :java-practice:test

# JavaScript - test specific attempt
PRACTICE_TARGET=largestSum npm test
```

### 3. Zero Test Code Changes

Tests in `LargestSumTest.java` and `largestSum.test.js` never need editing when you create new attempts. They automatically find and test your latest solution.

## Next Steps

1. **Create your first new challenge:**

   ```bash
   ./scripts/new-java-challenge.sh MyChallenge
   ```

2. **Try multiple attempts:**

   - Implement `MyChallenge.java`
   - Run tests to verify it works
   - Create `MyChallenge2.java` with a different approach
   - Tests automatically switch to testing MyChallenge2

3. **Compare implementations:**

   ```bash
   # Test first attempt
   PRACTICE_TARGET=MyChallenge ./gradlew test

   # Test second attempt
   PRACTICE_TARGET=MyChallenge2 ./gradlew test
   ```

## Project Structure Summary

```
practice-labs/
├── java-practice/          ✅ Java 17 + JUnit 5
│   ├── src/main/java/practice/
│   │   ├── largestsum/    ✅ Example with 2 attempts
│   │   └── util/          ✅ TargetResolver
│   └── src/test/java/
│
├── js-practice/           ✅ Node + Jest
│   ├── practice/          ✅ Example with 2 attempts
│   ├── tests/
│   └── utils/             ✅ targetResolver.js
│
├── sql-practice/          ✅ SQLite
│   ├── challenges/        ✅ 1 example query
│   ├── expected/
│   └── seed.sql
│
├── scripts/
│   ├── new-java-challenge.sh   ✅ Generator
│   └── run-sql-tests.sh        ✅ SQL runner
│
├── docs/
│   └── CREATING_CHALLENGES.md  ✅ Full guide
│
└── .github/workflows/
    └── ci.yml             ✅ Automated testing
```

## Documentation

- **Main README**: [README.md](../README.md) - Complete usage guide
- **Creating Challenges**: [docs/CREATING_CHALLENGES.md](CREATING_CHALLENGES.md) - Step-by-step guide
- **SQL Practice**: [sql-practice/README.md](../sql-practice/README.md) - SQL-specific docs

## Configuration

### Java Version

Default: Java 17
To change: Edit [gradle.properties](../gradle.properties)

```properties
javaVersion=21  # Switch to Java 21
```

### Dependencies

- Java: Edit [java-practice/build.gradle](../java-practice/build.gradle)
- JavaScript: Edit [js-practice/package.json](../js-practice/package.json)

## Commands Reference

| Task                  | Command                                           |
| --------------------- | ------------------------------------------------- |
| Java tests            | `./gradlew :java-practice:test`                   |
| JS tests              | `cd js-practice && npm test`                      |
| SQL tests             | `./scripts/run-sql-tests.sh`                      |
| All Java tests        | `./gradlew testAll`                               |
| New Java challenge    | `./scripts/new-java-challenge.sh ChallengeName`   |
| New attempt           | `./scripts/new-java-challenge.sh ChallengeName 2` |
| Test specific attempt | `PRACTICE_TARGET=ChallengeName2 ./gradlew test`   |

## Troubleshooting

All tests passing? You're ready to go! ✅

Issues? Check:

- Java version: `java -version` (should be 17+)
- Node version: `node -v` (should be 16+)
- SQLite: `sqlite3 --version`

Full troubleshooting: See [README.md](../README.md#troubleshooting)

## Ready to Practice

Start with the LargestSum examples, then create your own challenges. Happy coding! 🚀

---

**Pro Tips:**

- Use `npm run test:watch` for instant feedback in JavaScript
- The TargetResolver shows which file is being tested in console
- Create attempt #2 when you want to try a different algorithm
- All tests run in CI automatically on push
