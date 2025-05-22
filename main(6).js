let events = [
  { name: "Music Night", category: "music" },
  { name: "Art Fair", category: "art" },
  { name: "Cooking Demo", category: "food" }
];

events.push({ name: "Jazz Concert", category: "music" });

const musicEvents = events.filter(e => e.category === "music");
console.log("Music Events:", musicEvents);

const formattedEvents = events.map(e => `Workshop on ${e.name}`);
console.log("Formatted Events:", formattedEvents);
