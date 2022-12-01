$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/board-game/boardgamelist"
    }).then(function(data) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
    });
});COPY
