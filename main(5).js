function Event(name, date, category, seats) {
  this.name = name;
  this.date = date;
  this.category = category;
  this.seats = seats;
}

Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

const event1 = new Event("Photography Workshop", "2025-07-01", "art", 5);
const event2 = new Event("Marathon", "2025-06-28", "sports", 0);

const events = [event1, event2];

events.forEach(e => {
  console.log(`${e.name}: ${e.checkAvailability() ? "Available" : "Full"}`);
});

const keysAndValues = Object.entries(event1);
console.log(keysAndValues);
