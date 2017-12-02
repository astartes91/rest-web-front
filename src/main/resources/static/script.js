$(document).ready(
    function () {
        $("showCategoriesButton").click(
            function () {
                getCategories();
            }
        );

        getCategories();
    }
);

function getCategories() {

    $.get(
        "/categories",
        function (data) {
            var rows = $("#categoriesTable").children();
            for (var i = 1; i < rows.length; i++){
                rows[i].remove();
            }

            for (var i = 0; i < data.length; i++){

                var element = data[i];
                var name = element.name;
                var description = element.description;

                var row = $("<tr></tr>");
                row.append($("<td>" + name + "</td>"));
                row.append($("<td>" + description + "</td>"));

                $("#categoriesTable tr:last").after(row);
            }
        }
    );
}