/**
 * 论文添加
 */
$(function ($) {
    // 填充下拉框信息
    fillSelect('刊物类型,本人排名', 'publishTypeId,myRankId');

    //修改和新增时切换附件上传记录
    changeAttachdiv();

    var entityID = getQueryString('id');
    if (entityID) {
        $.post(contextPath + "/zypyjh/edit.do", {
            "id": entityID
        }, function (result) {
            $("#form-article-add").JsonToForm(result);
            var attachementNames = result.attachementNames;
            var attachementUrls = result.attachements;
            if (attachementNames != null && attachementUrls != null) {
                var names = attachementNames.split('||');
                var urls = attachementUrls.split('||');
                var link = "";
                for (var i = 0; i < names.length; i++) {
                    link += "<div style='margin:5px 20px 5px 10px;float:left'><a style='color:red' href='zypyjh/download.do?fileName=" + urls[i] + "'>" + names[i] + "</a></div>";
                }
                $("#attachUrl").html(link);
            }

            if (attachementNames != null && attachementNames != '') {
                $("#attachdiv").css('display', 'block');
            } else {
                $("#attachdiv").css('display', 'none');
            }
        });
    }

    $('input[type=radio]').iCheck({
        checkboxClass: 'icheckbox_minimal',
        radioClass: 'iradio_minimal',
        increaseArea: '20%'
    });

    $("#form-article-add").validate({
        rules: {
            name: "required",
            journalOfPublications: "required",
            myRankingId: {
                digits: true,
                required: true
            }
        },
        submitHandler: function (form) {
            submitForm(entityID);
        }
    });
    $.Huitab("#tab-category .tabBar span", "#tab-category .tabCon", "current", "click", "0");

});

// 提交表单
function submitForm(entityID) {
    $.ajax({
        type: "post",
        url: contextPath + "/zypyjh/" + (entityID ? "update.do" : "add.do"),
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

//显示上传文件
function changeAttachdiv() {
    var entityID = getQueryString('id');
    if (!entityID) {
        $("#attachdiv").css('display', 'none');
    } else {
        $("#attachdiv").css('display', 'block');
    }
}

