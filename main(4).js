function addEvent(name, date, category, seats) {
  eventList.push({ name, date, category, seats });
}

function registerUser(eventName) {
  const event = eventList.find(e => e.name === eventName);
  if (event && event.seats > 0) {
    event.seats--;
    console.log(`User registered to ${event.name}`);
  } else {
    console.log(`Cannot register to ${eventName}`);
  }
}

function filterEventsByCategory(category) {
  return eventList.filter(e => e.category === category);
}

function createCategoryCounter() {
  const count = {};
  return function(category) {
    count[category] = (count[category] || 0) + 1;
    return count[category];
  };
}

function searchEvents(callback) {
  return eventList.filter(callback);
}

const countRegistration = createCategoryCounter();

addEvent("Coding Bootcamp", "2025-06-05", "tech", 25);
addEvent("Classical Dance Night", "2025-06-10", "music", 10);

registerUser("Coding Bootcamp");
registerUser("Coding Bootcamp");

console.log(filterEventsByCategory("tech"));

console.log(countRegistration("tech"));
console.log(countRegistration("tech"));
console.log(countRegistration("music"));

console.log(searchEvents(e => e.seats < 20));
