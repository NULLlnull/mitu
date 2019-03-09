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
			url: contextPath + "/jzlxx/list.do",
			type: 'post',
			data: function(d) {
				d.search = $('#search').val();
			}
		},
		columns: [{
			data: "id"
		}, {
			data: "jzlmc"
		}, {
			data: "ssxy"
		}, {
			data: "ssxq"
		}, {
			data: "sfzsl"
		}],
		columnDefs: [{
			targets: [0],
			render: function(data, type, row, meta) {
				return '<input id="input-' + data + '" type="checkbox" name="single"><label for="input-' + data + '"></label>';
			}  
		},{
			targets: [4],
			render: function(data, type, row, meta) {
				if(data == 1)
					return "是";
				else
					return "否";
			}  
		},{
			targets: [5],
			render: function(data, type, row, meta) {
                return getEditBtn('jzlxx/toEdit.do',row.id);
			}
		}]
	});
});
