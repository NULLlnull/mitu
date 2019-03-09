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
			url: contextPath + "/jysxx/list.do",
			type: 'post',
			data: function(d) {
				d.search = $('#search').val();
			}
		},
		columns: [{
			data: "id"
		}, {
			data: "pxh"
		}, {
			data: "jysmc"
		}, {
			data: "ssxb"
		}, {
			data: "ssxy"
		}, {
			data: "fzrxm"
		}],
		columnDefs: [{
			targets: [0],
			render: function(data, type, row, meta) {
				return '<input id="input-' + data + '" type="checkbox" name="single"><label for="input-' + data + '"></label>';
			}  
		},{
			targets: [6],
			render: function(data, type, row, meta) {
                return getEditBtn('jysxx/toEdit.do',row.id);
			}
		}]
	});
});
