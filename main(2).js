const eventName = "Community Music Fest";
const eventDate = "2025-06-15";
let availableSeats = 50;

console.log(`Upcoming Event: ${eventName} on ${eventDate}`);
console.log(`Available Seats: ${availableSeats}`);

function registerUser() {
  if (availableSeats > 0) {
    availableSeats--;
    console.log(`Registration successful. Remaining seats: ${availableSeats}`);
  } else {
    console.log("Sorry, the event is full.");
  }
}

registerUser();
registerUser();
