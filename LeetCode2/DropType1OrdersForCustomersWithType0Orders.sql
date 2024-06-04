WITH temp AS (
SELECT *,
       MIN(order_type) OVER(PARTITION BY customer_id) AS min
FROM Orders
)
SELECT order_id,
       customer_id,
       order_type
FROM   temp
WHERE  order_type = min;  	