/**
 * 菜单添加
 */
$(function ($) {
    $.post(contextPath + "/xyxx/edit.do", {}, function (result) {
        $("#form-article-add").JsonToForm(result);
    });

    $('input[type=radio]').iCheck({
        checkboxClass: 'icheckbox_minimal',
        radioClass: 'iradio_minimal',
        increaseArea: '20%'
    });

    $("#form-article-add").validate({
        rules: {
            name: {
                required: true,
                minlength: 2,
                maxlength: 10
            },
            type: "required",
            status: "required",
            url: {
                maxlength: 1000
            },
            sort: {
                digits: true
            }
        },
        submitHandler: function (form) {
            submitForm(entityID);
        }
    });

    $.Huitab("#tab-category .tabBar span", "#tab-category .tabCon", "current", "click", "0");
});


function submitForm(entityID) {
    var url = contextPath + "/xyxx/" + (entityID ? "update.do" : "add.do");
    //alert(url);
    $.ajax({
        type: "post",
        url: url,
        data: new FormData($("#form-article-add")[0]),
        processData: false,
        contentType: false,
        async: false,
        success: function (data) {
            if (data.status == 0) {
                var message = entityID ? '更新成功!' : '添加成功!';
                showSuccessMessage(message, '', goBack);
            } else {
                var message = entityID ? '添加失败!' : '添加失败!';
                showFailMessage(message, '', '');
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            showFailMessage(errorThrown, '', '');
            return false;
        }
    });
    return false;
}

