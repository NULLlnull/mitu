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
			url: contextPath + "/menu/list.do",
			type: 'post',
			data: function(d) {
				d.search = $('#search').val();
			}
		},
		columns: [{
			data: "id"
		}, {
			data: "name"
		}, {
			data: "resUrl"
		}, {
			data: "type"
		}, {
			data: "level",
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
				if(data == 0)
					return "目录";
				else if(data == 1)
					return "菜单";
				else
					return "按钮";
			}  
		},{
			targets: [5],
			render: function(data, type, row, meta) {
                return getEditBtn('menu/toEdit.do', row.id);
            }
		}]
	});
});
