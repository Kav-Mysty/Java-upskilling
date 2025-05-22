-- 19. Completed Events with Feedback Summary
SELECT e.event_id, e.title,
       COUNT(DISTINCT r.registration_id) AS total_registrations,
       ROUND(AVG(f.rating), 2) AS avg_rating
FROM Events e
LEFT JOIN Registrations r ON e.event_id = r.event_id
LEFT JOIN Feedback f ON e.event_id = f.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id, e.title
ORDER BY total_registrations DESC;

-- 20. User Engagement Index
SELECT u.user_id, u.full_name,
       COUNT(DISTINCT r.event_id) AS events_attended,
       COUNT(DISTINCT f.feedback_id) AS feedback_submitted
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
LEFT JOIN Feedback f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name
ORDER BY events_attended DESC, feedback_submitted DESC;

-- 21. Top Feedback Providers (Top 5 users by feedback count)
SELECT u.user_id, u.full_name, COUNT(f.feedback_id) AS feedback_count
FROM Users u
JOIN Feedback f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name
ORDER BY feedback_count DESC
LIMIT 5;

-- 22. Duplicate Registrations Check (same user registered multiple times for same event)
SELECT user_id, event_id, COUNT(*) AS registration_count
FROM Registrations
GROUP BY user_id, event_id
HAVING registration_count > 1;

-- 23. Registration Trends (month-wise count for last 12 months)
SELECT DATE_FORMAT(registration_date, '%Y-%m') AS month, COUNT(user_id) AS registrations
FROM Registrations
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
GROUP BY month
ORDER BY month;
