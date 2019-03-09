var treeNodes;
$(function () {
    fillSelect('培养对象,培养层次', 'pydxDm,pyccDm');

    initTree();

    datatable = $('.table-sort').DataTable({
        order: [[0, 'desc']],
        "bSort": false,
        ajax: {
            url: contextPath + "/zyxx/list.do",
            type: 'post',
            data: function (d) {
                d.search = $('#search').val(),
                    d.pydxDm = $('#pydxDm').val(),
                    d.pyccDm = $('#pyccDm').val(),
                    d.ssxb = $('#ssxb').val()
            }
        },
        columns: [{
            data: "id"
        }, {
            data: "ynzydm"
        }, {
            data: "zszydm"
        }, {
            data: "ynzymc"
        }, {
            data: "zszymc"
        }, {
            data: "ssxbName",
            defaultContent: ""
        }, {
            data: "pydxName"
        }, {
            data: "pyccName",
            defaultContent: ""
        }, {
            data: "xz",
            defaultContent: ""
        }],
        columnDefs: [{
            targets: [0],
            render: function (data, type, row, meta) {
                return '<input id="input-' + data + '" type="checkbox" name="single"><label for="input-' + data + '"></label>';
            }
        }, {
            targets: [9],
            render: function (data, type, row, meta) {
                return getEditBtn('zyxx/toEdit.do', row.id);
            }
        }]
    });
});

$('#pydxDm').on('change', function () {
    datatable.ajax.reload();
});

$('#pyccDm').on('change', function () {
    datatable.ajax.reload();
});

// 导出execl
function exportExecl() {
    var params = "search=" + $('#search').val();
    // params += "&degreeId=" + $('#degreeId').val();
    // params += "&timeMin=" + $('#timeMin').val();
    // params += "&timeMax=" + $('#timeMax').val();
    $('#download').attr('href',
        encodeURI(encodeURI("zyxx/exportExecl.do?" + params)));
    $("#download")[0].click();
}

function onTreeClick(event, treeId, treeNode, clickFlag) {
    $('#ssxb').val(treeNode.jgdm);
    datatable.ajax.reload();
}