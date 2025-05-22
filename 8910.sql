-- 8. Sessions per Upcoming Event
SELECT e.event_id, e.title, COUNT(s.session_id) AS session_count
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id, e.title
ORDER BY e.event_id;

-- 9. Organizer Event Summary
SELECT e.organizer_id, u.full_name AS organizer_name,
       COUNT(e.event_id) AS total_events,
       GROUP_CONCAT(DISTINCT e.status ORDER BY e.status) AS statuses
FROM Events e
JOIN Users u ON e.organizer_id = u.user_id
GROUP BY e.organizer_id, u.full_name
ORDER BY total_events DESC;

-- 10. Feedback Gap
SELECT e.event_id, e.title
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
LEFT JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(r.registration_id) > 0 AND COUNT(f.feedback_id) = 0;
