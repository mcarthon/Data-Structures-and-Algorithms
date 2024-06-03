SELECT Teams1.team_name AS home_team,
       Teams2.team_name AS away_team
FROM   Teams AS Teams1
JOIN   Teams AS Teams2
WHERE  Teams1.team_name != Teams2.team_name;       