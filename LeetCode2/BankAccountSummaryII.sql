WITH Temp AS (
     SELECT name,
       SUM(amount) OVER(PARTITION BY Transactions.account) AS balance
FROM   Users
INNER JOIN Transactions
ON Users.account = Transactions.account
)

SELECT DISTINCT name,
       balance
FROM   Temp       
WHERE balance > 10000; 