-- Seed data for SQL practice challenges
-- This creates tables and inserts sample data for testing

-- Customers table
CREATE TABLE customers (
    customer_id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    total_spent DECIMAL(10, 2) DEFAULT 0
);

INSERT INTO customers (customer_id, name, email, total_spent) VALUES
    (1, 'Alice Johnson', 'alice@example.com', 1500.00),
    (2, 'Bob Smith', 'bob@example.com', 2300.50),
    (3, 'Charlie Brown', 'charlie@example.com', 890.25),
    (4, 'Diana Prince', 'diana@example.com', 3200.00),
    (5, 'Eve Wilson', 'eve@example.com', 1750.75),
    (6, 'Frank Miller', 'frank@example.com', 450.00),
    (7, 'Grace Lee', 'grace@example.com', 2100.00),
    (8, 'Henry Davis', 'henry@example.com', 675.50),
    (9, 'Ivy Martinez', 'ivy@example.com', 3500.00),
    (10, 'Jack Thompson', 'jack@example.com', 920.00);

-- Orders table
CREATE TABLE orders (
    order_id INTEGER PRIMARY KEY,
    customer_id INTEGER,
    order_date DATE,
    amount DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

INSERT INTO orders (order_id, customer_id, order_date, amount) VALUES
    (101, 1, '2024-01-15', 500.00),
    (102, 2, '2024-01-20', 1200.50),
    (103, 1, '2024-02-10', 1000.00),
    (104, 4, '2024-02-15', 3200.00),
    (105, 3, '2024-03-01', 890.25),
    (106, 5, '2024-03-10', 1750.75),
    (107, 2, '2024-03-20', 1100.00),
    (108, 9, '2024-04-05', 3500.00),
    (109, 7, '2024-04-12', 2100.00),
    (110, 10, '2024-04-18', 920.00);
