WITH temp AS (
    SELECT sale_date,
           fruit,
           CASE WHEN fruit LIKE 'apples' THEN sold_num ELSE -sold_num END AS sold
    FROM Sales
)
SELECT sale_date,
       SUM(sold) AS diff
FROM temp
GROUP BY sale_date