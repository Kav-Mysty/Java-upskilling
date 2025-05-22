let events = [
  { name: 'Music Fest', date: '2025-06-10', category: 'Music' },
  { name: 'Art Expo', date: '2025-06-15', category: 'Art' },
  { name: 'Tech Meetup', date: '2025-06-20', category: 'Tech' }
];

function addEvent(newEvent = { name: 'New Event', date: '2025-07-01', category: 'General' }) {
  events = [...events, newEvent];
}

function getEventDetails({ name, date, category }) {
  return `${name} is on ${date} under ${category} category.`;
}

function filterEventsByCategory(eventsList, category) {
  const clonedEvents = [...eventsList];
  return clonedEvents.filter(event => event.category === category);
}

addEvent({ name: 'Dance Workshop', date: '2025-07-05', category: 'Dance' });

const [firstEvent, ...otherEvents] = events;

console.log(getEventDetails(firstEvent));

const musicEvents = filterEventsByCategory(events, 'Music');

console.log('Music events:', musicEvents);
