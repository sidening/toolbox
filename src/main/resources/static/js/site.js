$(function () {
    alert(",,,,,")
    $.ajax({
        type: "GET",
        url: "/cms/site/options",
        dataType: "json",
        success: function (json) {
            $.each(json, function (i, item) {
                $(select[gate='gate']).append(
                    '<option value="'+item.id+'">'+item.name+'</option>'
                )
            })
        }
    });
    $(select[gate='gate']).append()
})