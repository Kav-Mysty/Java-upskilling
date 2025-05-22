document.querySelectorAll('.register-btn').forEach(btn => {
  btn.onclick = () => {
    alert('You have registered for the event');
  };
});

document.querySelector('#categoryFilter').onchange = (e) => {
  const selected = e.target.value;
  console.log(`Filtering events by: ${selected}`);
};

document.querySelector('#searchInput').addEventListener('keydown', (e) => {
  if (e.key === 'Enter') {
    console.log(`Searching for: ${e.target.value}`);
  }
});
