SELECT Employees0.employee_id
FROM   (Employees AS Employees0
JOIN   Employees AS Employees1
ON     Employees0.manager_id = Employees1.employee_id
JOIN   Employees AS Employees2
ON     Employees1.manager_id = Employees2.employee_id
JOIN   Employees AS Employees3
ON     Employees2.manager_id = Employees3.employee_id)
WHERE  Employees0.employee_id != 1
AND    Employees3.employee_id = 1;