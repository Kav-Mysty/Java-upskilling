function showLoader(state) {
  const loader = document.getElementById('loader');
  loader.style.display = state ? 'block' : 'none';
}

function fetchEventsWithThen() {
  showLoader(true);
  fetch('https://jsonplaceholder.typicode.com/posts')
    .then(response => response.json())
    .then(data => {
      console.log('Events fetched using then:', data.slice(0, 5));
    })
    .catch(error => {
      console.error('Fetch error:', error);
    })
    .finally(() => {
      showLoader(false);
    });
}

async function fetchEventsAsync() {
  showLoader(true);
  try {
    const response = await fetch('https://jsonplaceholder.typicode.com/posts');
    const data = await response.json();
    console.log('Events fetched using async/await:', data.slice(0, 5));
  } catch (error) {
    console.error('Async fetch error:', error);
  } finally {
    showLoader(false);
  }
}

fetchEventsWithThen();
