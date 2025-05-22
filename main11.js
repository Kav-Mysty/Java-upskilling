const form = document.querySelector('#registrationForm');
const errorMsg = document.querySelector('#errorMsg');
const successMsg = document.querySelector('#successMsg');

form.addEventListener('submit', function(event) {
  event.preventDefault();

  const name = form.elements['name'].value.trim();
  const email = form.elements['email'].value.trim();
  const eventSelected = form.elements['event'].value;

  errorMsg.textContent = '';
  successMsg.textContent = '';

  if (!name || !email || !eventSelected) {
    errorMsg.textContent = 'Please fill all required fields.';
    return;
  }

  if (!validateEmail(email)) {
    errorMsg.textContent = 'Please enter a valid email.';
    return;
  }

  successMsg.textContent = `Thank you, ${name}. You registered for ${eventSelected}.`;
  form.reset();
});

function validateEmail(email) {
  return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}
