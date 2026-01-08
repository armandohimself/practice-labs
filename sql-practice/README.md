# SQL Practice

This directory contains SQL practice challenges using SQLite.

## Structure

```
sql-practice/
├── seed.sql              # Sample data initialization
├── challenges/           # Your SQL solution files
│   └── *.sql
├── expected/             # Expected query results
│   └── *.txt
└── data/                 # Generated SQLite database (gitignored)
```

## Running Tests

```bash
./scripts/run-sql-tests.sh
```

## Creating a New Challenge

1. Create a SQL file in `challenges/` (e.g., `my_challenge.sql`)
2. Write your query
3. Run the test script to see actual output
4. Save the expected output to `expected/my_challenge.txt`

## Example Challenge

See `challenges/top_n_customers.sql` for a working example.
