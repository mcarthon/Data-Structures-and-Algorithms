WITH Temp AS (
    SELECT *,
           (
            CASE
                WHEN operation LIKE 'B%' THEN -1 * price
                ELSE price
            END
           ) AS profits
    FROM Stocks           
)
SELECT stock_name,
       SUM(profits) AS capital_gain_loss
FROM Temp
GROUP BY stock_name;