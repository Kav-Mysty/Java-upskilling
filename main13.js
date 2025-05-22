const form = document.querySelector('#registrationForm');
const message = document.querySelector('#responseMessage');

form.addEventListener('submit', function(event) {
  event.preventDefault();

  const data = {
    name: form.elements['name'].value.trim(),
    email: form.elements['email'].value.trim(),
    event: form.elements['event'].value
  };

  message.textContent = 'Submitting...';

  fetch('https://jsonplaceholder.typicode.com/posts', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(data)
  })
  .then(response => {
    if (!response.ok) throw new Error('Network response was not ok');
    return response.json();
  })
  .then(json => {
    setTimeout(() => {
      message.textContent = 'Registration successful! Thank you.';
      form.reset();
    }, 1000);
  })
  .catch(error => {
    message.textContent = 'Submission failed. Please try again.';
  });
});
