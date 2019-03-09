/**
 * 公用函数
 */

/**
 * 从URL连接中获取key为name的value
 * @param {Object} name
 */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = location.search.substr(1).match(reg);
    if (r != null)
        return unescape(r[2]);
    return null;
}

/**
 * 刷新DT
 */
function reloadTable() {
    datatable.ajax.reload();
}

/**
 * 获取datatables选中行的ID
 */
function getDTSelect() {
    var idList = [];
    var lines = datatable.rows('.selected').data();
    for (var i = 0; i < lines.length; i++) {
        idList.push(lines[i].id);
    }
    return idList;
}

function goBack() {
    $('#backBtn').click();
}

/**
 * 添加
 *
 * @param {Object} title 弹窗标题
 * @param {Object} url 打开的URL地址
 */
function add(title, url) {
    var index = layer.open({
        type: 2,
        title: title,
        shadeClose: false,
        shade: false,
        maxmin: true, //开启最大化最小化按钮
        area: ['893px', '600px'],
        content: url
    });
}

/**
 * 编辑
 * @param {Object} title 弹窗标题
 * @param {Object} url 打开的URL地址
 * @param {Object} id 实体ID
 */
function edit(title, url, id) {
    var index = layer.open({
        type: 2,
        title: title,
        shadeClose: false,
        shade: false,
        maxmin: true, //开启最大化最小化按钮
        area: ['893px', '600px'],
        content: url + '?id=' + id
    });
}

function edit(title, url, id, width, height) {
    var index = layer.open({
        type: 2,
        title: title,
        shadeClose: false,
        shade: false,
        maxmin: false, //开启最大化最小化按钮
        area: [width + 'px', height + 'px'],
        content: url + '?id=' + id
    });
}


/**
 * 改变数据状态
 * @param {Object} url 请求的地址
 * @param {Object} id 实体ID
 * @param {Object} status 实体当前状态
 * @param {Object} successFn 成功回调函数
 */
function changeStatus(url, id, status, successFn) {
    $.ajax({
        type: "post",
        url: contextPath + url,
        data: {
            id: id,
            status: status
        },
        success: function (data) {
            if (data.status = 200) {
                showSuccessMessage('操作成功!', successFn);
            } else {
                showFailMessage('操作失败失败!');
            }
        }
    });
}

/**
 * 删除
 * @param {Object} idList 要删除的id数组
 * @param {Object} url 请求URL
 * @param {Object} successFn 成功回调函数
 */
function del(idList, url, successFn) {
    if (!idList.length) {
        showFailMessage('没有数据被选中!');
        return false;
    }
    showConfirmMessage('确认要删除吗?', function () {
        $.ajax({
            type: "post",
            url: contextPath + url,
            data: {
                "ids": idList
            },
            success: function (data) {
                if (data.status == 0) {
                    showSuccessMessage('删除成功!', '', successFn);
                } else {
                    showFailMessage('删除失败!');
                }
            }
        });
    });
}

/**
 * 判断指定函数是否存在
 * @param {Object} funcName函数名
 */
function isExitsFunction(funcName) {
    try {
        if (typeof(funcName) == "function") {
            return true;
        }
    } catch (e) {
    }
    return false;
}

/**
 * 是否存在指定变量
 * @param {Object} variableName 变量名
 */
function isExitsVariable(variableName) {
    try {
        if (typeof(variableName) == "undefined") {
            return false;
        } else {
            return true;
        }
    } catch (e) {
    }
    return false;
}

/**
 * 显示右上角成功提示消息
 * @param  message 消息
 * @param  successFn 打开时回调
 * @param  endFn 销毁时回调
 */
function showSuccessMessage(message, successFn, endFn) {
    successFn = isExitsFunction(successFn) ? successFn : function () {
    };
    endFn = isExitsFunction(endFn) ? endFn : function () {
    };
    //alert(successFn);
    layer.alert(message, {
        icon: 6,
        title: '成功',
        time: 2000,
        shade: 0,
        btn: 0,
        succss: successFn,
        end: endFn,
        offset: ['50px']
    });
}

/**
 * 显示右上角失败提示消息
 * @param  message 消息
 * @param  successFn 打开时回调
 * @param  endFn 销毁时回调
 */
function showFailMessage(message, successFn, endFn) {
    successFn = isExitsFunction(successFn) ? successFn : function () {
    };
    endFn = isExitsFunction(endFn) ? endFn : function () {
    };
    layer.alert(message, {
        icon: 5,
        title: '失败',
        time: 2000,
        shade: 0,
        btn: 0,
        succss: successFn,
        end: endFn,
        offset: ['50px']
    });
}

/**
 * 显示右上角询问提示消息
 * @param  message 询问消息
 * @param  sureFn 确定按钮回调
 * @param  cancelFn 取消按钮回调
 */
function showConfirmMessage(message, sureFn, cancelFn) {
    sureFn = isExitsFunction(sureFn) ? sureFn : function () {
    };
    cancelFn = isExitsFunction(cancelFn) ? cancelFn : function () {
    };
    layer.confirm(message, {
        btn: ['确定', '取消'],
        icon: 3,
        title: '确认',
        shade: 0,
        shift: 6,
        offset: ['40px']
    }, sureFn, cancelFn);
}

/**
 * 编辑按钮
 */
function getEditBtn(url, id) {
    var html = '&nbsp;<a title="编辑" href="' + url + '?id=' + id + '" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>&nbsp;';
    return html;
}

/**
 * 查看按钮
 */
function getViewBtn(url, id) {
    var html = '&nbsp;<a title="详情" href="' + url + '?id=' + id + '" style="text-decoration:none"><i class="Hui-iconfont">&#xe637;</i></a>&nbsp;';
    return html;
}

/**
 * 添加编辑页
 * @param url
 */
function toAdd(url) {
    window.location.href = url;
}

var datatable = null;

/**
 * 加载下拉菜单（字典）
 * zdlbs 字典名称，逗号分隔
 * domIds 下拉菜单ID，逗号分隔
 */
function fillSelect(zdlbs, domIds) {
    var arr_zdlb = zdlbs.split(",");
    var arr_dom = domIds.split(",");
    $.ajax({
        url: contextPath + "/zddm/property.do",
        type: "post",
        data: {
            "zdlbs": zdlbs
        },
        async: false,
        success: function (result) {
            if (result != null && result.status == 0) {
                for (var i = 0; i < arr_zdlb.length; i++) {
                    var list=result.data[arr_zdlb[i]];
                    $.each(list, function (index, item) {
                        var option = "<option value='" + item.dmbh + "'>" + item.dmmc + "</option>";
                        $('#' + arr_dom[i]).append(option);
                    });
                }
            } else {
                showFailMessage("获取数据失败，请重试！", '', '');
            }
        }
    });
}

Date.prototype.format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}


//========================================================

function initTree() {
    var setting = {
        view: {
            dblClickExpand: false,
            showLine: false,
            selectedMulti: false,
            fontCss: getFont
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
            onClick: onTreeClick
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

function getFont(treeId, node) {
    return node.font ? node.font : {};
}
