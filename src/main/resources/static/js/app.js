$.ajax({
  url: '127.0.0.1:8723/dashboard/student/1',
  success: function(items) {
    // Generate the list items using the Thymeleaf template
    var template = $('#item-template').html();
    var rendered = Mustache.render(template, {items: items});

    // Insert the generated items into the list container
    $('#list-container').html(rendered);
  }
});