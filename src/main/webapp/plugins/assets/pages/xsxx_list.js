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
			url: contextPath + "/xsxx/list.do",
			type: 'post',
			data: function(d) {
				d.search = $('#search').val();
			}
		},
		columns: [{
			data: "id"
		}, {
			data: "xsxh"
		}, {
			data: "xm"
		}, {
			data: "xb"
		}, {
			data: "zjlxmc",
			defaultContent: ""
		}, {
			data: "zjh",
			defaultContent: ""
		}, {
			data: "mzmc",
			defaultContent: ""
		}, {
			data: "zzmmmc",
			defaultContent: ""
		}, {
			data: "ssxy",
			defaultContent: ""
		}, {
			data: "ssxbmc",
			defaultContent: ""
		}, {
			data: "sszymc",
			defaultContent: ""
		}, {
			data: "ssbjmc",
			defaultContent: ""
		}, {
			data: "xslbmc",
			defaultContent: ""
		}, {
			data: "xjzt",
			defaultContent: ""
		}, {
			data: "zsqkmc",
			defaultContent: ""
		}],
		columnDefs: [{
			targets: [0],
			render: function(data, type, row, meta) {
				return '<input id="input-' + data + '" type="checkbox" name="single"><label for="input-' + data + '"></label>';
			}  
		},{
			targets: [3],
			render: function(data, type, row, meta) {
				if(data == 1)
					return "女";
				else
					return "男";
			}  
		},{
			targets: [15],
			render: function(data, type, row, meta) {
                return getEditBtn('xsxx/toEdit.do', row.id);
			}
		}]
	});
});

