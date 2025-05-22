const eventList = document.querySelector('#eventList');

const events = [
  { name: "Yoga Class", date: "2025-06-01" },
  { name: "Book Club", date: "2025-06-05" }
];

events.forEach(event => {
  const card = document.createElement('div');
  card.className = 'event-card';
  card.textContent = `${event.name} - ${event.date}`;
  eventList.appendChild(card);
});

function updateUI(message) {
  const status = document.querySelector('#status');
  status.textContent = message;
}
