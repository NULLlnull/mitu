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
			url: contextPath + "/role/list.do",
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
			data: "desc"
		}],
		columnDefs: [{
			targets: [0],
			render: function(data, type, row, meta) {
				return '<input id="input-' + data + '" type="checkbox" name="single"><label for="input-' + data + '"></label>';
			}  
		},{
			targets: [3],
			render: function(data, type, row, meta) {
				var html = getEditBtn('role/toEdit.do',row.id);
                html += "&nbsp;<a data-title='授权' href='role/permit.do?roleId=" + row.id +"' style='text-decoration:none'><i class='Hui-iconfont'>&#xe637;</i></a>&nbsp;";
				return html;
			}
		}]
	});
});

function permit(title, url, id, width, height) {
	var index = layer.open({
		type: 2,
		title: title,
		shadeClose: false,
		shade: false,
		maxmin: false, //开启最大化最小化按钮
		area: [width +'px', height +'px'],
		content: url + '?id=' + id
	});
}