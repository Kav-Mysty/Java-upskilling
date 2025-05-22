-- 5. Most Active Cities (Top 5 by distinct user registrations)
SELECT 
    u.city,
    COUNT(DISTINCT r.user_id) AS total_users
FROM Registrations r
JOIN Users u ON r.user_id = u.user_id
GROUP BY u.city
ORDER BY total_users DESC
LIMIT 5;

-- 6. Event Resource Summary
SELECT 
    e.title AS event_title,
    COUNT(r.resource_id) AS total_resources
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
GROUP BY e.event_id;

-- 7. Low Feedback Alerts (Rating < 3)
SELECT 
    u.full_name,
    e.title AS event_title,
    f.rating,
    f.comments
FROM Feedback f
JOIN Users u ON f.user_id = u.user_id
JOIN Events e ON f.event_id = e.event_id
WHERE f.rating < 3;
