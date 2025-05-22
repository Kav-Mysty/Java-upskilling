<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
$(document).ready(function() {
  $('#registerBtn').click(function() {
    $('#eventCards').fadeOut(500, function() {
      $(this).fadeIn(500);
    });
  });
});
</script>
