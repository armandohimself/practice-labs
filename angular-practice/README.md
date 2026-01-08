# Angular Practice

Angular 17 practice challenges using Karma + Jasmine for testing.

## Setup (Optional)

**Note**: Angular is optional. The rest of the repository works without it.

```bash
cd angular-practice
npm install
```

## How It Works

### Barrel File Pattern for Version Management

Unlike Java and JavaScript which use dynamic class/file discovery, Angular uses a **barrel file pattern** for managing multiple implementations.

**Structure:**
```
src/challenges/my-challenge/
├── my-challenge.service.ts       # Version 1
├── my-challenge-v2.service.ts    # Version 2
├── my-challenge-v3.service.ts    # Version 3
├── my-challenge.service.spec.ts  # Tests (never edit!)
└── index.ts                      # Barrel file (controls which version is tested)
```

**Barrel File (index.ts):**
```typescript
// Change this line to test a different version!
export { MyChallengeV2Service as CurrentMyChallengeService } from './my-challenge-v2.service';

// Individual exports
export { MyChallengeService } from './my-challenge.service';
export { MyChallengeV2Service } from './my-challenge-v2.service';
```

**Test File:**
```typescript
import { CurrentMyChallengeService } from './index';
// Tests automatically use whichever version is exported as "Current"
```

## Running Tests

```bash
# Run all tests once
npm test

# Watch mode (re-run on changes)
npm run test:watch

# With coverage
npm run test:coverage
```

## Creating New Challenges

### Using the Generator (Recommended)

```bash
# Create new challenge
./scripts/new-angular-challenge.sh MyChallenge service

# Create version 2
./scripts/new-angular-challenge.sh MyChallenge service 2
```

### Manual Creation

1. **Create service file(s)**:
```typescript
// my-challenge.service.ts
@Injectable({ providedIn: 'root' })
export class MyChallengeService {
  solve(input: any): any {
    // Your implementation
  }
}
```

2. **Create barrel file**:
```typescript
// index.ts
export { MyChallengeService as CurrentMyChallengeService } from './my-challenge.service';
```

3. **Create test file**:
```typescript
// my-challenge.service.spec.ts
import { CurrentMyChallengeService } from './index';

describe('MyChallenge', () => {
  let service: CurrentMyChallengeService;
  
  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CurrentMyChallengeService);
  });
  
  it('should work', () => {
    expect(service.solve(input)).toBe(expected);
  });
});
```

## Test Structure

Angular uses **Jasmine** for testing. Key concepts:

- `describe()`: Groups related tests
- `beforeEach()`: Runs before each test
- `it()`: Defines a single test case
- `expect()`: Makes assertions

**Example:**
```typescript
describe('Feature', () => {
  beforeEach(() => {
    // Setup
  });
  
  it('should do something', () => {
    expect(result).toBe(expected);
  });
});
```

## Example Challenge

See `src/challenges/largest-sum/` for a complete example with:
- Two implementations (v1 and v2)
- Comprehensive tests
- Barrel file setup

## Troubleshooting

### Tests not running

```bash
# Clear cache and reinstall
rm -rf node_modules
npm install
```

### Browser issues

Tests use ChromeHeadless by default. If Chrome isn't available:
1. Install Chrome
2. Or modify `karma.conf.js` to use a different browser

### TypeScript errors

```bash
# Check TypeScript version
npx tsc --version

# Should be ~5.2.2 for Angular 17
```
