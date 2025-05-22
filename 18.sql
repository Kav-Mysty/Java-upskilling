-- 14. Most Registered Events (Top 3)
SELECT e.event_id, e.title, COUNT(r.registration_id) AS total_registrations
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
ORDER BY total_registrations DESC
LIMIT 3;

-- 15. Event Session Time Conflict (Overlapping Sessions)
SELECT s1.event_id, s1.session_id AS session1, s2.session_id AS session2
FROM Sessions s1
JOIN Sessions s2 ON s1.event_id = s2.event_id
    AND s1.session_id < s2.session_id
    AND s1.start_time < s2.end_time
    AND s2.start_time < s1.end_time
ORDER BY s1.event_id;

-- 16. Unregistered Active Users (registered in last 30 days but no event registration)
SELECT u.user_id, u.full_name, u.registration_date
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
WHERE u.registration_date >= CURDATE() - INTERVAL 30 DAY
  AND r.registration_id IS NULL;

-- 17. Multi-Session Speakers (speakers with more than one session)
SELECT speaker_name, COUNT(session_id) AS session_count
FROM Sessions
GROUP BY speaker_name
HAVING session_count > 1
ORDER BY session_count DESC;

-- 18. Resource Availability Check (events with no resources)
SELECT e.event_id, e.title
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(r.resource_id) = 0;
