-- 11. Daily New User Count (last 7 days)
SELECT registration_date, COUNT(user_id) AS new_users
FROM Users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date
ORDER BY registration_date;

-- 12. Event with Maximum Sessions
SELECT e.event_id, e.title, COUNT(s.session_id) AS session_count
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
HAVING session_count = (
    SELECT MAX(session_counts) FROM (
        SELECT COUNT(session_id) AS session_counts
        FROM Sessions
        GROUP BY event_id
    ) AS counts
);

-- 13. Average Rating per City
SELECT e.city, ROUND(AVG(f.rating), 2) AS avg_rating
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.city
ORDER BY avg_rating DESC;
