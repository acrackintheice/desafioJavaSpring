$(document).ready(function() {
    $('.btn-action').click(function(){
        var url = $(this).data("url");
        fetch('http://localhost:8080/' + url)
            .then(function(response) {
                return response.json();
            })
            .then(function(myJson) {
                console.log(JSON.stringify(myJson));
                // update modal content
                $('.modal-title').text(myJson['nome']);
                $('.modal-body').text(myJson['descricao']);
                // show modal
                $('#myModal').modal('show');
            }); 
    });
  });

