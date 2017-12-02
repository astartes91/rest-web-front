$(document).ready(
    function () {
        $("#showCategoriesButton").click(getCategories);
        $("#createNewCategoryButton").click(createNewCategory);

        getCategories();
    }
);

function createNewCategory () {
    var dialog = $("#categoryCreationDiv").dialog(
        {
            width: 400,
            title: "Создать новую категорию",
            buttons: {
                "Создать": function () {
                    $.ajax(
                        {
                            type: "POST",
                            url: "/categories",
                            data: JSON.stringify(
                                {
                                    name: $("#categoryNameInput").val(),
                                    description: $("#categoryDescriptionInput").val()
                                }
                            ),
                            success: function (data) {
                                dialog.dialog("close");
                                getCategories();
                            },
                            contentType: 'application/json'
                        }
                    );
                }
            }
        }
    );
}

function getCategories() {

    $.get(
        "/categories",
        function (data) {
            var rows = $("#categoriesTable").find("> tbody").children();
            for (var i = 1; i < rows.length; i++){
                rows[i].remove();
            }

            for (var i = 0; i < data.length; i++){

                var element = data[i];
                var name = element.name;
                var description = element.description;
                var id = element.id;

                var row = $("<tr></tr>");
                row.append($("<td>" + name + "</td>"));
                row.append($("<td>" + description + "</td>"));
                row.append($("<td><input type='submit' value='Просмотр'/></td>"));
                row.append($("<td><input type='submit' value='Редактировать'/></td>"));
                row.append($("<td><input type='submit' value='Удалить' onclick='deleteEntity(" + id + ")'/></td>"));

                $("#categoriesTable").find("tr:last").after(row);
            }
        }
    );
}

function deleteEntity(id) {
    $.ajax(
        {
            url: "/categories/" + id,
            type: "DELETE",
            success: function (data) {
                getCategories();
            }
        }
    );
}