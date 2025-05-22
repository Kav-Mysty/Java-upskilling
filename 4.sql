SELECT 
    e.title AS event_title,
    COUNT(s.session_id) AS peak_hour_sessions
FROM Sessions s
JOIN Events e ON s.event_id = e.event_id
WHERE TIME(s.start_time) < '12:00:00'
  AND TIME(s.end_time) > '10:00:00'
GROUP BY s.event_id;
