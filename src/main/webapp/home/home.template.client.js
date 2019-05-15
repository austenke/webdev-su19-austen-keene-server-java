(function () {
    const $courseFld = $('#courseFld');

    function create() {
        $('#classes').prepend("<li class=\"list-group-item\"><div class=\"row\"><div class=\"col-sm-3\"><i " +
            "class=\"fa fa-file-text\"></i> " + $courseFld.val() + "</div><div class=\"col-sm-3\">Created by:Me</div><div " +
            "class=\"col-sm-3\">Last edited:12/12/1990</div><div class=\"col-sm-3\"><button " +
            "class=\"btn btn-outline-success my-2 my-sm-0 float-right\" type=\"button\"><i " +
            "class=\"fa fa-times\"></i></button></div></div></li>");
        $courseFld.val("");
    }

    $('#wbdv-create').click(create);
})();