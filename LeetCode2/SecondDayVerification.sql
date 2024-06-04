SELECT Emails.user_id
FROM Emails
INNER JOIN Texts
ON Emails.email_id = Texts.email_id
WHERE Texts.signup_action LIKE 'V%'
AND DATE(Texts.action_date) - DATE(Emails.signup_date) = 1
ORDER BY Emails.user_id ASC;