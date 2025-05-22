const eventList = [
  { name: "Tree Plantation Drive", date: "2025-06-10", seats: 0 },
  { name: "Yoga Workshop", date: "2025-07-01", seats: 20 },
  { name: "Music Fest", date: "2025-05-15", seats: 30 },
];

const today = new Date("2025-05-22"); // Simulating current date

function displayValidEvents() {
  eventList.forEach((event) => {
    const eventDate = new Date(event.date);
    if (eventDate >= today && event.seats > 0) {
      console.log(`Event: ${event.name}, Date: ${event.date}, Seats: ${event.seats}`);
    } else {
      console.log(`Event "${event.name}" is not available for registration.`);
    }
  });
}

function registerToEvent(eventName) {
  try {
    const event = eventList.find(e => e.name === eventName);
    if (!event) throw new Error("Event not found.");
    if (new Date(event.date) < today) throw new Error("Event has already happened.");
    if (event.seats === 0) throw new Error("No seats available.");

    event.seats--;
    console.log(`Registered for ${event.name}. Remaining seats: ${event.seats}`);
  } catch (err) {
    console.error("Registration failed:", err.message);
  }
}

displayValidEvents();

registerToEvent("Tree Plantation Drive");  // Should fail
registerToEvent("Yoga Workshop");          // Should succeed
