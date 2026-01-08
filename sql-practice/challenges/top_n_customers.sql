-- Challenge: Top N Customers
--
-- Write a query to find the top 5 customers by total_spent.
-- Return: customer_id, name, total_spent
-- Order by: total_spent DESC, then customer_id ASC

SELECT
    customer_id,
    name,
    total_spent
FROM customers
ORDER BY total_spent DESC, customer_id ASC
LIMIT 5;
