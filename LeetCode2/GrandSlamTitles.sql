SELECT DISTINCT Unpivot_Table.player_id, 
       Players.player_name,
       COUNT(Unpivot_Table.title) OVER(PARTITION BY Players.player_id) AS grand_slams_count
FROM Championships
UNPIVOT (
    player_id
    FOR title IN (Wimbledon, Fr_open, US_open, Au_open)
) AS Unpivot_Table
JOIN Players
ON   Players.player_id = Unpivot_Table.player_id;