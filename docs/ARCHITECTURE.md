# Practice Labs - Architecture & Troubleshooting Guide

This document explains how all the pieces of the Practice Labs repository connect together, in the order they were created. Use this to understand the system architecture and troubleshoot issues.

## Table of Contents

1. [Repository Structure](#repository-structure)
2. [Build Order & Dependencies](#build-order--dependencies)
3. [How Everything Connects](#how-everything-connects)
4. [Core Mechanisms](#core-mechanisms)
5. [Troubleshooting Guide](#troubleshooting-guide)

---

## Repository Structure

```
practice-labs/
├── Root Build System (Gradle)
│   ├── settings.gradle              # Project structure definition
│   ├── build.gradle                 # Root build configuration
│   ├── gradle.properties            # Java version configuration
│   ├── gradlew                      # Gradle wrapper script (Unix)
│   └── gradlew.bat                  # Gradle wrapper script (Windows)
│
├── Java Module (:java-practice)
│   ├── build.gradle                 # Java-specific build config
│   ├── src/main/java/practice/
│   │   ├── util/
│   │   │   └── TargetResolver.java  # Auto-selects latest attempt
│   │   └── largestsum/
│   │       ├── LargestSumSolution.java   # Interface
│   │       ├── LargestSum.java           # Attempt 1
│   │       └── LargestSum2.java          # Attempt 2
│   └── src/test/java/practice/
│       └── largestsum/
│           └── LargestSumTest.java  # Tests (uses TargetResolver)
│
├── JavaScript Module (js-practice)
│   ├── package.json                 # Dependencies & test scripts
│   ├── utils/
│   │   └── targetResolver.js        # Auto-selects latest attempt
│   ├── practice/
│   │   ├── largestSum.js            # Attempt 1
│   │   └── largestSum2.js           # Attempt 2
│   └── tests/
│       └── largestSum.test.js       # Tests (uses targetResolver)
│
├── Angular Module (angular-practice)
│   ├── package.json                 # Angular dependencies
│   ├── angular.json                 # Angular CLI config
│   ├── tsconfig.json                # TypeScript config
│   ├── karma.conf.js                # Test runner config
│   ├── src/services/
│   │   └── target-resolver.service.ts  # Info about barrel pattern
│   └── src/challenges/largest-sum/
│       ├── largest-sum.service.ts        # Attempt 1
│       ├── largest-sum-v2.service.ts     # Attempt 2
│       ├── index.ts                      # Barrel file (exports "Current")
│       └── largest-sum.service.spec.ts   # Tests (imports from barrel)
│
├── SQL Module (sql-practice)
│   ├── seed.sql                     # Test database schema & data
│   ├── challenges/
│   │   └── top_n_customers.sql      # Example query
│   └── expected/
│       └── top_n_customers.txt      # Expected output
│
├── Scripts
│   ├── new-java-challenge.sh        # Generate Java challenges
│   ├── new-angular-challenge.sh     # Generate Angular challenges
│   └── run-sql-tests.sh             # Run SQL tests
│
├── CI/CD
│   └── .github/workflows/ci.yml     # GitHub Actions workflow
│
└── Documentation
    ├── README.md                    # Main usage guide
    ├── docs/CREATING_CHALLENGES.md  # How to create challenges
    ├── docs/SETUP_COMPLETE.md       # Setup verification
    └── docs/ARCHITECTURE.md         # This file
```

---

## Build Order & Dependencies

### 1. Root Configuration (Created First)

**Files Created:**
- `settings.gradle` - Defines multi-module project structure
- `build.gradle` - Root tasks (like `testAll`)
- `gradle.properties` - Java version configuration
- `.gitignore` - What to exclude from git
- Gradle wrapper (`gradlew`, `gradlew.bat`, `gradle/`)

**Purpose:**
Establishes the foundation for the entire project. Gradle orchestrates the Java module.

**Dependencies:**
- Requires: Java 17+ installed
- Used by: Java module

---

### 2. Java Practice Module (Created Second)

**Files Created in Order:**

1. **`java-practice/build.gradle`**
   - Configures Java 17 toolchain
   - Sets up JUnit 5 dependencies
   - Configures test task to pass PRACTICE_TARGET env var

2. **`java-practice/src/main/java/practice/util/TargetResolver.java`**
   - Core mechanism for auto-selecting latest implementation
   - Uses reflection to scan classpath
   - Reads PRACTICE_TARGET environment variable

3. **`java-practice/src/main/java/practice/largestsum/LargestSumSolution.java`**
   - Interface that all attempts implement
   - Ensures consistent method signature

4. **`java-practice/src/main/java/practice/largestsum/LargestSum.java`**
   - First implementation (attempt 1)
   - Implements LargestSumSolution interface

5. **`java-practice/src/test/java/practice/largestsum/LargestSumTest.java`**
   - Test class that never changes
   - Uses TargetResolver in @BeforeEach to get latest implementation

6. **`java-practice/src/main/java/practice/largestsum/LargestSum2.java`**
   - Second implementation (demonstrates version switching)

7. **`scripts/new-java-challenge.sh`**
   - Script to generate new challenges
   - Creates implementation + test files

**Dependencies:**
- Requires: Gradle wrapper, Java 17+
- Used by: Root `testAll` task, CI/CD

**How It Connects:**
```
Root build.gradle
  └── includes :java-practice module
        └── runs tests in java-practice/build.gradle
              └── tests use TargetResolver
                    └── finds latest LargestSum*.class
```

---

### 3. JavaScript Practice Module (Created Third)

**Files Created in Order:**

1. **`js-practice/package.json`**
   - Defines Jest as test framework
   - Scripts: `test`, `test:watch`, `test:coverage`

2. **`js-practice/utils/targetResolver.js`**
   - Similar to Java version but uses file system scanning
   - Reads PRACTICE_TARGET environment variable

3. **`js-practice/practice/largestSum.js`**
   - First implementation
   - Exports `{ bigSum }` function

4. **`js-practice/tests/largestSum.test.js`**
   - Uses Jest (describe, test, expect)
   - Imports from targetResolver

5. **`js-practice/practice/largestSum2.js`**
   - Second implementation (demonstrates version switching)

**Dependencies:**
- Requires: Node.js 16+, npm
- Standalone (not connected to Gradle)

**How It Connects:**
```
package.json
  └── defines "test" script
        └── runs Jest
              └── tests use targetResolver
                    └── finds latest largestSum*.js
```

---

### 4. SQL Practice Module (Created Fourth)

**Files Created in Order:**

1. **`sql-practice/seed.sql`**
   - Creates tables (customers, orders)
   - Inserts sample data

2. **`sql-practice/challenges/top_n_customers.sql`**
   - Example SQL query

3. **`sql-practice/expected/top_n_customers.txt`**
   - Expected output for validation

4. **`scripts/run-sql-tests.sh`**
   - Creates SQLite database
   - Loads seed data
   - Runs each challenge query
   - Compares output to expected

5. **`sql-practice/README.md`**
   - SQL-specific documentation

**Dependencies:**
- Requires: sqlite3 command-line tool
- Standalone (not connected to Gradle or npm)

**How It Connects:**
```
run-sql-tests.sh
  └── creates temp database
        └── loads seed.sql
              └── runs challenges/*.sql
                    └── compares output to expected/*.txt
```

---

### 5. Angular Practice Module (Created Fifth)

**Files Created in Order:**

1. **`angular-practice/package.json`**
   - Angular 17 dependencies
   - Karma + Jasmine for testing
   - Test scripts

2. **`angular-practice/tsconfig.json`**
   - TypeScript compiler configuration
   - ES2022 target, strict mode

3. **`angular-practice/angular.json`**
   - Angular CLI configuration
   - Test builder settings

4. **`angular-practice/karma.conf.js`**
   - Test runner configuration
   - Chrome/ChromeHeadless browsers
   - Coverage reporting

5. **`angular-practice/tsconfig.spec.json`**
   - TypeScript config for tests
   - Includes Jasmine types

6. **`angular-practice/src/test.ts`**
   - Test environment initialization
   - Loaded by Karma

7. **`angular-practice/src/services/target-resolver.service.ts`**
   - Service explaining barrel file pattern
   - Info only (doesn't actually resolve)

8. **`angular-practice/src/challenges/largest-sum/largest-sum.service.ts`**
   - First implementation

9. **`angular-practice/src/challenges/largest-sum/largest-sum-v2.service.ts`**
   - Second implementation (different algorithm)

10. **`angular-practice/src/challenges/largest-sum/index.ts`**
    - Barrel file that exports "Current" version
    - Change export to switch which version is tested

11. **`angular-practice/src/challenges/largest-sum/largest-sum.service.spec.ts`**
    - Tests that import from barrel file
    - Automatically test whichever version is "Current"

12. **`scripts/new-angular-challenge.sh`**
    - Generate Angular challenges
    - Creates service + spec + barrel files

13. **`angular-practice/README.md`**
    - Angular-specific documentation

**Dependencies:**
- Requires: Node.js 16+, npm, Chrome (for tests)
- Optional: Repository works without Angular installed

**How It Connects:**
```
angular.json
  └── defines test builder
        └── uses karma.conf.js
              └── runs tests via Karma
                    └── tests import from barrel files (index.ts)
                          └── barrel exports "Current" version
```

**Key Difference from Java/JavaScript:**
Angular uses **static exports** (barrel files) instead of dynamic discovery because:
- TypeScript/Angular requires compile-time type checking
- Import paths must be known at build time
- More explicit = easier to debug

---

### 6. Documentation & CI/CD (Created Last)

**Files Created:**

1. **`README.md`** - Main repository documentation
2. **`docs/CREATING_CHALLENGES.md`** - Tutorial for creating challenges
3. **`docs/SETUP_COMPLETE.md`** - Verification checklist
4. **`docs/ARCHITECTURE.md`** - This file
5. **`.github/workflows/ci.yml`** - GitHub Actions workflow

**CI/CD Workflow:**
```yaml
CI runs on: push, pull_request

Jobs:
  1. java-tests
       → Setup JDK 17
       → Run ./gradlew :java-practice:test
  
  2. javascript-tests
       → Setup Node 20
       → npm install in js-practice
       → npm test
  
  3. sql-tests
       → Install sqlite3
       → Run ./scripts/run-sql-tests.sh
  
  4. all-tests-complete
       → Depends on all above jobs
       → Confirms everything passed
```

---

## How Everything Connects

### Test Execution Flow

#### Java
```
User runs: ./gradlew :java-practice:test

1. Gradle reads java-practice/build.gradle
2. Gradle compiles src/main/java → build/classes
3. Gradle compiles src/test/java → build/classes/test
4. JUnit finds and runs *Test.java classes
5. LargestSumTest.setUp() calls TargetResolver.resolve()
6. TargetResolver scans build/classes for LargestSum*.class
7. Finds: LargestSum.class, LargestSum2.class
8. Extracts numbers: 0, 2
9. Returns highest: LargestSum2
10. Tests run against LargestSum2 instance
```

#### JavaScript
```
User runs: npm test (in js-practice)

1. package.json "test" script runs Jest
2. Jest finds tests/*.test.js files
3. largestSum.test.js imports TargetResolver
4. beforeAll() calls TargetResolver.resolve('largestSum')
5. TargetResolver scans practice/ directory
6. Finds: largestSum.js, largestSum2.js
7. Extracts numbers: 0, 2
8. Returns highest: largestSum2.js
9. Requires largestSum2.js and returns exports
10. Tests run against largestSum2 exports
```

#### Angular
```
User runs: npm test (in angular-practice)

1. package.json "test" script runs Angular CLI
2. Angular CLI reads angular.json
3. angular.json specifies karma.conf.js
4. Karma loads src/test.ts
5. Karma finds *.spec.ts files
6. largest-sum.service.spec.ts imports from './index'
7. index.ts barrel file exports LargestSumV2Service as CurrentLargestSumService
8. Tests run against LargestSumV2Service instance
```

#### SQL
```
User runs: ./scripts/run-sql-tests.sh

1. Script creates temp SQLite database
2. Loads sql-practice/seed.sql
3. Scans sql-practice/challenges/ for *.sql files
4. For each challenge file:
   a. Runs query against database
   b. Captures output
   c. Compares to sql-practice/expected/<name>.txt
   d. Reports PASS/FAIL
5. Exits with code 0 (all passed) or 1 (failures)
```

---

## Core Mechanisms

### 1. Automatic Version Resolution

**Problem:** How do tests find the latest implementation without manual updates?

**Java Solution: Reflection + Classpath Scanning**
```java
// 1. Convert package to path
String packagePath = "practice.largestsum".replace('.', '/');

// 2. Get classloader's view of classpath
ClassLoader cl = Thread.currentThread().getContextClassLoader();
Enumeration<URL> resources = cl.getResources(packagePath);

// 3. List .class files in directory
File[] files = directory.listFiles((dir, name) -> 
    name.endsWith(".class") && name.startsWith("LargestSum"));

// 4. Extract version numbers, sort, return highest
```

**JavaScript Solution: File System Scanning**
```javascript
// 1. Read directory contents
const files = fs.readdirSync('practice/');

// 2. Filter by pattern (largestSum*.js)
const pattern = /^largestSum(\d*)\.js$/;
const matches = files.filter(file => pattern.test(file));

// 3. Extract version numbers, sort, return highest
```

**Angular Solution: Barrel File (Manual)**
```typescript
// index.ts - manually edit this line
export { LargestSumV2Service as CurrentLargestSumService } from './largest-sum-v2.service';

// Tests import "Current" version
import { CurrentLargestSumService } from './index';
```

### 2. Environment Variable Override

All three systems support `PRACTICE_TARGET` environment variable:

```bash
# Java
PRACTICE_TARGET=LargestSum ./gradlew test

# JavaScript
PRACTICE_TARGET=largestSum npm test

# Angular (doesn't use this - edit barrel file instead)
```

**Why?**
- Compare different implementations
- Test specific version for debugging
- Regression testing

### 3. Interface/Contract Enforcement

**Java: Interface**
```java
public interface LargestSumSolution {
    int bigSum(List<Integer> nums);
}

// All attempts implement this
public class LargestSum implements LargestSumSolution { ... }
public class LargestSum2 implements LargestSumSolution { ... }
```

**JavaScript: Convention**
```javascript
// All files export same structure
module.exports = { bigSum };
```

**Angular: TypeScript Interface (implicit)**
```typescript
// All services have same method signature
bigSum(nums: number[] | null | undefined): number
```

---

## Troubleshooting Guide

### Problem: Java tests fail with ClassNotFoundException

**Symptoms:**
```
No implementation found for LargestSum in package practice.largestsum
```

**Causes & Solutions:**

1. **Files not compiled**
   ```bash
   ./gradlew clean build
   ```

2. **Wrong package name**
   - Check `package practice.largestsum;` matches directory structure
   - Package should be lowercase

3. **Class name mismatch**
   - TargetResolver looks for exact pattern
   - `LargestSum`, `LargestSum2`, NOT `LargestSum_2`

### Problem: JavaScript tests fail to find implementation

**Symptoms:**
```
No implementation found for largestSum in /path/to/practice
```

**Causes & Solutions:**

1. **Wrong directory**
   ```javascript
   // Check targetResolver.js default path
   TargetResolver.resolve('largestSum', './practice');
   ```

2. **File naming**
   - Must be: `largestSum.js`, `largestSum2.js`
   - NOT: `LargestSum.js`, `largest-sum.js`

3. **Module not exported**
   ```javascript
   // File must end with:
   module.exports = { bigSum };
   ```

### Problem: Angular tests fail with "Cannot find module"

**Symptoms:**
```
Cannot find module './index'
```

**Causes & Solutions:**

1. **Barrel file missing**
   - Create `index.ts` in challenge folder
   - Export at least one version

2. **Import path wrong**
   ```typescript
   // Correct:
   import { CurrentLargestSumService } from './index';
   
   // Wrong:
   import { CurrentLargestSumService } from './largest-sum.service';
   ```

3. **Not exported as "Current"**
   ```typescript
   // index.ts must have:
   export { SomeService as CurrentMyChallengeService } from './some.service';
   ```

### Problem: Tests pass locally but fail in CI

**Symptoms:**
GitHub Actions shows failures, but `./gradlew test` works locally.

**Causes & Solutions:**

1. **Files not committed**
   ```bash
   git status
   git add .
   git commit -m "Add missing files"
   ```

2. **Java version mismatch**
   - CI uses Java 17
   - Check `gradle.properties`: `javaVersion=17`

3. **Node version mismatch**
   - CI uses Node 20
   - Check locally: `node -v`

4. **Missing dependencies**
   ```bash
   # JavaScript
   cd js-practice && npm ci
   
   # Angular
   cd angular-practice && npm ci
   ```

### Problem: SQL tests show incorrect output formatting

**Symptoms:**
```
Expected:
customer_id  name
-----------  ----
1            Bob

Actual:
customer_id  name
-----------  -----
1            Bob
```

**Causes & Solutions:**

1. **Column width differences**
   - SQLite formats based on data
   - Capture actual output: `./scripts/run-sql-tests.sh`
   - Update `expected/*.txt` with exact output (including spaces)

2. **Line ending differences** (Windows vs Unix)
   ```bash
   # Convert to Unix line endings
   dos2unix sql-practice/expected/*.txt
   ```

### Problem: TargetResolver always picks version 1

**Symptoms:**
Even after creating `LargestSum2.java`, tests still use `LargestSum`.

**Causes & Solutions:**

1. **Version naming**
   - Must be: `LargestSum2`, NOT `LargestSum_2` or `LargestSum-v2`

2. **Not implementing interface**
   ```java
   // Must implement:
   public class LargestSum2 implements LargestSumSolution { ... }
   ```

3. **Build cache**
   ```bash
   ./gradlew clean build
   ```

### Problem: Generator script fails

**Symptoms:**
```
Permission denied: ./scripts/new-java-challenge.sh
```

**Solution:**
```bash
chmod +x ./scripts/*.sh
```

---

## How to Extend the System

### Adding a New Language

1. **Create module directory** (e.g., `python-practice/`)

2. **Add test framework** (e.g., pytest)

3. **Implement target resolver**:
   - Scan for files matching pattern
   - Extract version numbers
   - Return latest

4. **Create example challenge**

5. **Add generator script**

6. **Update CI/CD** to run tests

7. **Document** in README

### Adding Test Generation

Currently, test files have boilerplate but require manual editing. To auto-generate tests:

1. **Define test template** with placeholders

2. **Add to generator script**:
   ```bash
   # In new-java-challenge.sh
   generate_test_cases() {
     # Create test methods based on annotations in implementation
   }
   ```

3. **Use JavaDoc/comments** to specify test cases:
   ```java
   /**
    * @testCase input=[1,2,3] expected=5
    * @testCase input=[] expected=0
    */
   ```

4. **Parse annotations** and generate test methods

---

## Summary

The Practice Labs system consists of:

1. **Four independent practice modules** (Java, JavaScript, Angular, SQL)
2. **Automatic version resolution** (except Angular, which uses barrels)
3. **Generator scripts** to create new challenges
4. **Comprehensive testing** via Gradle, Jest, Karma, and shell scripts
5. **CI/CD integration** via GitHub Actions

Everything is designed to **minimize manual edits** when creating new attempts. Once a challenge is set up, you never touch the test files—just create new implementation files and the system auto-selects the latest.
