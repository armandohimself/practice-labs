# Practice Labs

A multi-language practice environment where you can solve the same coding challenge multiple times and have tests automatically run against your **latest attempt** without editing test code.

## Quick Start

### Prerequisites

- **Java 17+** (or Java 21 - see configuration below)
- **Node.js 16+** and npm
- **SQLite3** (for SQL challenges)
- **Git**
- **Chrome** (optional, for Angular tests)

### Setup

```bash
# Clone and navigate to the repo
cd practice-labs

# Install JavaScript dependencies
cd js-practice && npm install && cd ..

# OPTIONAL: Install Angular dependencies
cd angular-practice && npm install && cd ..

# Verify setup - run all tests
./gradlew testAll                    # Java tests
cd js-practice && npm test && cd ..  # JavaScript tests
./scripts/run-sql-tests.sh           # SQL tests

# Optional: Angular tests
cd angular-practice && npm test && cd ..
```

## Core Concept: Latest-Attempt Resolution

The key feature of this practice environment is that **tests automatically run against your newest solution** without you editing test code.

### How It Works

**Java Example:**

```
java-practice/src/main/java/practice/largestsum/
├── LargestSum.java      ← First attempt
├── LargestSum2.java     ← Second attempt (tests run this)
└── LargestSum3.java     ← Third attempt (tests run this)
```

The test file `LargestSumTest.java` uses `TargetResolver` to automatically find the highest-numbered class:

```java
@BeforeEach
void setUp() throws Exception {
    solution = TargetResolver.resolve("practice.largestsum", "LargestSum");
}
```

**JavaScript Example:**

```
js-practice/practice/
├── largestSum.js        ← First attempt
├── largestSum2.js       ← Second attempt (tests run this)
└── largestSum3.js       ← Third attempt (tests run this)
```

### Override Mechanism

Force tests to run against a specific attempt:

```bash
# Java
PRACTICE_TARGET=LargestSum2 ./gradlew :java-practice:test

# JavaScript
PRACTICE_TARGET=largestSum2 npm test --prefix js-practice
```

## Language-Specific Guides

### ☕ Java (Gradle + JUnit 5)

#### Run Tests

```bash
# All Java tests
./gradlew :java-practice:test

# Specific test class
./gradlew :java-practice:test --tests LargestSumTest

# With specific attempt
PRACTICE_TARGET=LargestSum2 ./gradlew :java-practice:test
```

#### Create New Challenge

```bash
# Generate scaffold for new challenge
./scripts/new-java-challenge.sh MyChallenge

# Create attempt #2 of existing challenge
./scripts/new-java-challenge.sh LargestSum 2
```

This creates:

- `java-practice/src/main/java/practice/mychallenge/MyChallenge.java`
- `java-practice/src/test/java/practice/mychallenge/MyChallengeTest.java` (if doesn't exist)

#### Java Version Configuration

Default is **Java 17**. To switch to Java 21:

1. Edit [gradle.properties](gradle.properties):

   ```properties
   javaVersion=21
   ```

2. Verify:

   ```bash
   ./gradlew :java-practice:dependencies --configuration runtimeClasspath
   ```

### 🟨 JavaScript (Node + Jest)

#### Run Tests

```bash
cd js-practice

# All tests
npm test

# Watch mode (re-run on file changes)
npm run test:watch

# With coverage
npm run test:coverage

# Specific attempt
PRACTICE_TARGET=largestSum2 npm test
```

#### Create New Attempt

Manually create files following the naming pattern:

```javascript
// practice/myChallenge.js
function solve(input) {
  // Your solution
}
module.exports = { solve };
```

```javascript
// tests/myChallenge.test.js
const TargetResolver = require("../utils/targetResolver");

describe("MyChallenge", () => {
  let solution;

  beforeAll(() => {
    solution = TargetResolver.resolve("myChallenge");
  });

  test("example test", () => {
    expect(solution.solve(input)).toBe(expected);
  });
});
```

### 🅰️ Angular (Karma + Jasmine)

**Note:** Angular is optional. The repository works fine without it.

#### Run Tests

```bash
cd angular-practice

# Run all tests once
npm test

# Watch mode (re-run on changes)
npm run test:watch

# With coverage
npm run test:coverage
```

#### Create New Challenge

```bash
# Create new challenge
./scripts/new-angular-challenge.sh MyChallenge service

# Create version 2
./scripts/new-angular-challenge.sh MyChallenge service 2
```

#### How Version Switching Works

Angular uses a **barrel file pattern** instead of automatic discovery:

```typescript
// challenges/my-challenge/index.ts (barrel file)
// Change this line to switch versions!
export { MyChallengeV2Service as CurrentMyChallengeService } from './my-challenge-v2.service';

// Test file automatically uses "Current" version
import { CurrentMyChallengeService } from './index';
```

See [angular-practice/README.md](angular-practice/README.md) for more details.

### 🗄️ SQL (SQLite)

#### Run Tests

```bash
./scripts/run-sql-tests.sh
```

#### Create New Challenge

1. Create query file: `sql-practice/challenges/my_query.sql`
2. Run test script to see output
3. Save expected output: `sql-practice/expected/my_query.txt`

See [sql-practice/README.md](sql-practice/README.md) for more details.

---

## Angular Module (Optional)

The Angular module uses a **barrel file pattern** due to TypeScript's compile-time requirements.

### How It Works

Unlike Java/JS which can discover files at runtime, Angular requires manual version management:

```typescript
// src/challenges/largest-sum/index.ts
export { LargestSumService as CurrentLargestSumService } from './largest-sum.service';
// export { LargestSumV2Service as CurrentLargestSumService } from './largest-sum-v2.service';
```

**To test a different version:** Comment/uncomment the appropriate export line.

### Setup

```bash
cd angular-practice
npm install
npm test
```

### Create New Challenge

```bash
./scripts/new-angular-challenge.sh MyChallenge
```

This generates:
- Service file: `src/challenges/my-challenge/my-challenge.service.ts`
- Test file: `src/challenges/my-challenge/my-challenge.service.spec.ts`
- Barrel file: `src/challenges/my-challenge/index.ts`

---

## Example Challenge: LargestSum

Find the sum of the two largest integers in a list/array.

**Examples:**

- `[0, 4, 2, 5, 0]` → `9` (4 + 5)
- `[5, 4, 2, 5, 0]` → `10` (5 + 5)

**Edge Cases:**

- Null/empty → `0`
- Single element → return that element
- Handles negatives and duplicates

**Implementations:**

- Java: [LargestSum.java](java-practice/src/main/java/practice/largestsum/LargestSum.java)
- JavaScript: [largestSum.js](js-practice/practice/largestSum.js)
- Angular: [largest-sum.service.ts](angular-practice/src/challenges/largest-sum/largest-sum.service.ts)

## Project Structure

```
practice-labs/
├── java-practice/              # Java module (Gradle)
│   ├── src/main/java/practice/
│   │   ├── largestsum/         # Example challenge
│   │   │   ├── LargestSum.java
│   │   │   └── LargestSum2.java  (create more attempts)
│   │   └── util/
│   │       └── TargetResolver.java  # Automatic resolution
│   └── src/test/java/practice/
│       └── largestsum/
│           └── LargestSumTest.java  # Tests (never edit)
│
├── js-practice/                # JavaScript module (Node + Jest)
│   ├── practice/               # Your implementations
│   │   ├── largestSum.js
│   │   └── largestSum2.js      (create more attempts)
│   ├── tests/                  # Test files (never edit)
│   │   └── largestSum.test.js
│   └── utils/
│       └── targetResolver.js   # Automatic resolution
│
├── sql-practice/               # SQL module (SQLite)
│   ├── challenges/             # Your SQL queries
│   ├── expected/               # Expected outputs
│   └── seed.sql                # Test data
│
├── angular-practice/           # Angular module (optional)
│   ├── src/challenges/         # Challenge implementations
│   │   └── largest-sum/
│   │       ├── index.ts        # Barrel file (manual switching)
│   │       ├── largest-sum.service.ts
│   │       └── largest-sum-v2.service.ts  (create more attempts)
│   └── src/services/
│       └── target-resolver.service.ts
│
├── scripts/
│   ├── new-java-challenge.sh   # Java challenge generator
│   ├── new-angular-challenge.sh  # Angular challenge generator
│   └── run-sql-tests.sh        # SQL test runner
│
└── README.md                   # This file
```

## Commands Reference

| Task                           | Command                                           |
| ------------------------------ | ------------------------------------------------- |
| **Run all Java tests**         | `./gradlew :java-practice:test`                   |
| **Run all tests (aggregate)**  | `./gradlew testAll`                               |
| **Run JS tests**               | `cd js-practice && npm test`                      |
| **Run SQL tests**              | `./scripts/run-sql-tests.sh`                      |
| **Run Angular tests**          | `cd angular-practice && npm test`                 |
| **Create Java challenge**      | `./scripts/new-java-challenge.sh ChallengeName`   |
| **Create Angular challenge**   | `./scripts/new-angular-challenge.sh ChallengeName`|
| **Create Java attempt #N**     | `./scripts/new-java-challenge.sh ChallengeName N` |
| **Test specific Java attempt** | `PRACTICE_TARGET=LargestSum2 ./gradlew test`      |
| **Test specific JS attempt**   | `PRACTICE_TARGET=largestSum2 npm test`            |
| **Watch JS tests**             | `cd js-practice && npm run test:watch`            |

## CI/CD

GitHub Actions automatically runs all tests on push. See [.github/workflows/ci.yml](.github/workflows/ci.yml).

## Tips & Best Practices

1. **Never edit test files** - They automatically target your latest attempt
2. **Name attempts sequentially** - `Challenge.java`, `Challenge2.java`, `Challenge3.java`
3. **Use environment variable** to test older attempts: `PRACTICE_TARGET=Challenge2`
4. **Keep solutions simple** - Focus on learning, not over-engineering
5. **Use watch mode** for rapid feedback (JavaScript: `npm run test:watch`)

## Troubleshooting

### Java tests fail with "Class not found"

Rebuild the project:

```bash
./gradlew clean build
```

### JavaScript tests can't find module

Reinstall dependencies:

```bash
cd js-practice && rm -rf node_modules && npm install
```

### SQL tests fail

Check SQLite installation:

```bash
sqlite3 --version
# If not installed: brew install sqlite3
```

### Wrong Java version

Check active version:

```bash
java -version
```

Switch version (macOS with SDKMAN):

```bash
sdk list java
sdk use java 17.0.9-tem
```

## License

MIT

## Contributing

Feel free to add more challenges, improve the scripts, or enhance the documentation!

---

**Happy Practicing!** 🚀
