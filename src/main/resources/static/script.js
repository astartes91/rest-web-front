$(document).ready(function () {
    $.get("/categories", function (data) {
        alert(data);
    });
});