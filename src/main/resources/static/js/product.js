function viewProducts(categoryId) {
    $.get(
        "/products/category/" + categoryId,
        function (data) {
            var rows = $("#productsTable").find("> tbody").children();
            for (var i = 1; i < rows.length; i++){
                rows[i].remove();
            }

            for (var i = 0; i < data.length; i++){

                var element = data[i];
                var name = element.name;
                var description = element.description;
                var id = element.id;
                var manufacturer = element.manufacturer;
                var price = element.price;
                var additionDate = element.additionDate;
                var category = element.category;

                var row = $("<tr></tr>");
                row.append($("<td>" + name + "</td>"));
                row.append($("<td>" + description + "</td>"));
                row.append($("<td>" + manufacturer + "</td>"));
                row.append($("<td>" + price + "</td>"));
                row.append($("<td>" + additionDate + "</td>"));
                row.append($("<td>" + category.name + "</td>"));
                row.append(
                    $("<td><input type='submit' value='Редактировать' onclick='updateProduct(" + id + ")'/></td>")
                );
                row.append($("<td><input type='submit' value='Удалить' onclick='deleteProduct(" + id + ")'/></td>"));

                $("#productsTable").find("tr:last").after(row);
            }

            $("#categoriesDiv").hide();

            $("#createNewProductButton").prop('onclick',null).off('click');
            $("#createNewProductButton").click(
                function () {
                    createNewProduct(categoryId);
                }
            );
            $("#productsDiv").show();
        }
    );
}

function createNewProduct(categoryId) {

    $.get(
        {
            url: "/categories",
            success: function (data) {

                var children = $("#productCategorySelect").children();
                for (var i = 0; i < children.length; i++){
                    children[i].remove();
                }

                for (var i = 0; i < data.length; i++){
                    var category = data[i];
                    $("#productCategorySelect").append(
                        $('<option value="' + category.id + '">' + category.name + '</option>')
                    );
                }
            },
            async: false
        }
    );

    var dialog = $("#productCreationUpdateDiv").dialog(
        {
            width: 400,
            title: "Создать новый продукт",
            buttons: {
                "Создать": function () {
                    $.ajax(
                        {
                            type: "POST",
                            url: "/products",
                            data: JSON.stringify(
                                {
                                    name: $("#productNameInput").val(),
                                    description: $("#productDescriptionInput").val(),
                                    manufacturer: $("#productManufacturerInput").val(),
                                    price: $("#productPriceInput").val(),
                                    category: {id: $("#productCategorySelect").val()}
                                }
                            ),
                            success: function (data) {
                                $("#productNameInput").val("");
                                $("#productDescriptionInput").val("");
                                $("#productManufacturerInput").val("");
                                $("#productPriceInput").val("");
                                dialog.dialog("close");
                                viewProducts(categoryId);
                            },
                            contentType: 'application/json'
                        }
                    );
                }
            }
        }
    );
}

function deleteProduct(id) {

    $.get(
        "/products/" + id,
        function (data) {

            var categoryId = data.category.id;

            $.ajax(
                {
                    url: "/products/" + id,
                    type: "DELETE",
                    success: function (data) {
                        viewProducts(categoryId);
                    }
                }
            );
        }
    );
}