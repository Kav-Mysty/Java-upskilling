SELECT 
    e.title AS event_title,
    AVG(f.rating) AS average_rating,
    COUNT(f.feedback_id) AS total_feedbacks
FROM Feedback f
JOIN Events e ON f.event_id = e.event_id
GROUP BY f.event_id
HAVING COUNT(f.feedback_id) >= 10
ORDER BY average_rating DESC;
