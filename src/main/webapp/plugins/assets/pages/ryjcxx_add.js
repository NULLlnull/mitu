/**
 * 菜单添加
 */
$(function ($) {
    var entityID = getQueryString('id');
    if (entityID) {
        $.post(contextPath + "/ryjcxx/edit.do", {"id": entityID}, function (result) {
            $("#form-article-add").JsonToForm(result);
        });
    }

    $('input[type=radio]').iCheck({
        checkboxClass: 'icheckbox_minimal',
        radioClass: 'iradio_minimal',
        increaseArea: '20%'
    });

    $("#form-article-add").validate({
        rules: {
            rybh: {
                required: true,
                minlength: 2,
                maxlength: 10
            },
            xm: "required",
            url: {
                maxlength: 1000
            },
            sort: {
                digits: true
            }
        },
        submitHandler: function (form) {
            $.ajax({
                type: "post",
                url: contextPath + "/ryjcxx/" + (entityID ? "update.do" : "add.do"),
                data: $(form).serialize(),
                dataType: "json",
                success: function (data) {
                    alert(data.status);
                    if (data.status == 0) {
                        var message = entityID ? '更新成功!' : '添加成功!';
                        showSuccessMessage(message, '', goBack);
                    } else {
                        var message = entityID ? '添加失败!' : '添加失败!';
                        showFailMessage(message, '', '');
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(errorThrown);
                    return false;
                }
            });
            return false;
        }
    });

    $.Huitab("#tab-category .tabBar span", "#tab-category .tabCon", "current", "click", "0");
});

