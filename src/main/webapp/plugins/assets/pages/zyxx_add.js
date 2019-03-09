/**
 * 菜单添加
 */
$(function ($) {
    fillSelect('培养对象,培养层次', 'pydxDm,pyccDm');

    var entityID = getQueryString('id');
    if (entityID) {
        $.post(contextPath + "/zyxx/edit.do", {"id": entityID}, function (result) {
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
            zszydm: "required",
            ynzydm: "required",
            ynzymc: "required",
            zszymc: "required",
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

    init_ztree();
});

function submitForm(entityID) {
    var url = contextPath + "/zyxx/" + (entityID ? "update.do" : "add.do");
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

var treeNodes, showId, valId;
function init_ztree() {
    var setting = {
        view: {
            dblClickExpand: false
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },
        callback: {
            beforeClick: beforeClick,
            onClick: onClick
        }
    };

    $.ajax({
        url: "xyjgxx/list.do?jxjg=1",
        contentType: "application/json;charset=utf-8",
        data: {},
        dataType: "text",
        success: function (result) {
            treeNodes = eval(result);
            $.fn.zTree.init($("#treeDemo"), setting, treeNodes);
        },
        error: function (msg) {
        }
    });
}

function beforeClick(treeId, treeNode) {
    // var check = (treeNode && !treeNode.isParent);
    // if (!check) alert("只能选择城市...");
    // return check;
    return true;
}

function onClick(e, treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
        nodes = zTree.getSelectedNodes(),
        v = "",txt="";
    nodes.sort(function compare(a, b) {
        return a.id - b.id;
    });
    for (var i = 0, l = nodes.length; i < l; i++) {
        v = nodes[i].jgdm;
        txt = nodes[i].name;
    }
    //if (v.length > 0) v = v.substring(0, v.length - 1);
    $(showId).val(txt);
    $(valId).val(v);
}

function showTreeMenu(sId, vId) {
    showId = sId;
    valId = vId;
    var cityObj = $(showId);
    var cityOffset = $(showId).offset();
    $("#menuContent").css({
        left: cityOffset.left + "px",
        top: cityOffset.top + cityObj.outerHeight() + "px"
    }).slideDown("fast");

    $("body").bind("mousedown", onBodyDown);
}

function hideTreeMenu() {
    $("#menuContent").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);
}

function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length > 0)) {
        hideTreeMenu();
    }
}

$(document).ready(function () {
});