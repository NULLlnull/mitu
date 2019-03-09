/**
 * DataTables
 */
var datatable = null,idList=[];

$(function() {
    datatable = $('.table-sort').DataTable({
        order: [
            [0, 'desc']
        ],
        "bSort": false,
        ajax: {
            url: contextPath + "/bjxx/list.do",
            type: 'post',
            data: function(d) {
                d.search = $('#search').val();
            }
        },
        columns: [{
            data: "id"
        }, {
            data: "ssxqmc"
        }, {
            data: "ssxbmc"
        }, {
            data: "sszymc"
        }, {
            data: "pydx"
        }, {
            data: "pydxmc"
        }, {
            data: "pyccmc"
        }, {
            data: "zyfxmc",
            defaultContent: ""
        }, {
            data: "bjmc"
        }, {
            data: "nj"
        }, {
            data: "xz"
        }],
        columnDefs: [{
            targets: [0],
            render: function(data, type, row, meta) {
                return '<input id="input-' + data + '" type="checkbox" name="single"><label for="input-' + data + '"></label>';
            }
        },{
            targets: [11],
            render: function(data, type, row, meta) {
                return getEditBtn('bjxx/toEdit.do',row.id);
            }
        }]
    });
});
