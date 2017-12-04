//Columbia Pictures не представляет, как хорошо мне с jQuery бывает!
$(document).ready(
    function () {
        $("#showCategoriesButton").click(getCategories);
        $("#createNewCategoryButton").click(createNewCategory);
        $("#createNewProductButton").click(createNewProduct);

        getCategories();
    }
);