SELECT 
    u.full_name,
    u.city,
    e.title AS event_title,
    e.start_date,
    e.end_date
FROM Registrations r
JOIN Users u ON r.user_id = u.user_id
JOIN Events e ON r.event_id = e.event_id
WHERE e.status = 'upcoming' AND u.city = e.city
ORDER BY e.start_date;
