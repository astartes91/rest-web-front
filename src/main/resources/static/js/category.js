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
                row.append($("<td><input type='submit' value='Просмотр' onclick='viewProducts(" + id + ")'/></td>"));
                row.append(
                    $("<td><input type='submit' value='Редактировать' onclick='updateCategory(" + id + ")'/></td>")
                );
                row.append($("<td><input type='submit' value='Удалить' onclick='deleteCategory(" + id + ")'/></td>"));

                $("#categoriesTable").find("tr:last").after(row);
            }

            $("#productsDiv").hide();
            $("#categoriesDiv").show();
        }
    );
}

function createNewCategory () {
    var dialog = $("#categoryCreationUpdateDiv").dialog(
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
                                onSuccessfulCategoryCreationUpdate(dialog);
                            },
                            contentType: 'application/json'
                        }
                    );
                }
            }
        }
    );
}

function updateCategory(id) {

    $.get(
        "/categories/" + id,
        function (data) {
            $("#categoryNameInput").val(data.name);
            $("#categoryDescriptionInput").val(data.description);

            var dialog = $("#categoryCreationUpdateDiv").dialog(
                {
                    width: 400,
                    title: "Обновить категорию",
                    buttons: {
                        "Обновить": function () {
                            $.ajax(
                                {
                                    type: "PUT",
                                    url: "/categories",
                                    data: JSON.stringify(
                                        {
                                            id: data.id,
                                            name: $("#categoryNameInput").val(),
                                            description: $("#categoryDescriptionInput").val()
                                        }
                                    ),
                                    success: function (data) {
                                        onSuccessfulCategoryCreationUpdate(dialog);
                                    },
                                    contentType: 'application/json'
                                }
                            );
                        }
                    }
                }
            );
        }
    );
}

function deleteCategory(id) {
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

function onSuccessfulCategoryCreationUpdate(dialog) {
    $("#categoryNameInput").val("");
    $("#categoryDescriptionInput").val("");
    dialog.dialog("close");
    getCategories();
}