var treeNodes;
$(function () {
    fillSelect('培养对象,培养层次', 'pydxDm,pyccDm');

    initTree();

    datatable = $('.table-sort').DataTable({
        order: [[0, 'desc']],
        "bSort": false,
        ajax: {
            url: contextPath + "/kcxx/list.do",
            type: 'post',
            data: function (d) {
                d.search = $('#search').val(),
                    d.publishTypeId = $('#publishTypeId').val(),
                    d.timeMin = $("#timeMin").val(),
                    d.timeMax = $("#timeMax").val()
            }
        },
        columns: [{
            data: "id"
        }, {
            data: "kcfl"
        }, {
            data: "kcdm"
        }, {
            data: "kcmc"
        }, {
            data: "kcjc"
        }, {
            data: "ssjys"
        }, {
            data: "ssjys"
        }],
        columnDefs: [
            {
                targets: [0],
                render: function (data, type, row, meta) {
                    return '<input id="input-' + data + '" type="checkbox" name="single"><label for="input-' + data + '"></label>';
                }
            },
            {
                targets: [7],
                render: function (data, type, row, meta) {
                    var btns = new Array('edit', 'del');
                    return getEditBtn('kcxx/toEdit.do', row.id);
                }
            }]
    });
});

$('#publishTypeId').on('change', function () {
    datatable.ajax.reload();
});

// 导出execl
function exportExecl() {
    var params = "search=" + $('#search').val();
    params += "&publishTypeId=" + $('#publishTypeId').val();
    params += "&timeMin=" + $('#timeMin').val();
    params += "&timeMax=" + $('#timeMax').val();
    $('#download').attr('href',
        encodeURI(encodeURI("kcxx/exportExecl.do?" + params)));
    $("#download")[0].click();
}


function onTreeClick(event, treeId, treeNode, clickFlag) {
    $('#ssxb').val(treeNode.jgdm);
    datatable.ajax.reload();
}