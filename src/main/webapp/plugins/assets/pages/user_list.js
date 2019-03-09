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
			url: contextPath + "/user/list.do",
			type: 'post',
			data: function(d) {
				d.search = $('#search').val();
			}
		},
		columns: [{
			data: "id"
		}, {
			data: "username"
		}, {
			data: "status"
		}, {
			data: "last_login_time"
		}, {
			data: "last_login_ip",
			defaultContent: ""
		}, {
			data: "login_count"
		}, {
			data: "type"
		}, {
			data: "fk",
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
				if(data == "")
					return "-";
				var date = new Date();
				date.setTime(data);
				return date.format('yyyy-MM-dd');
			}  
		},{
			targets: [6],
			render: function(data, type, row, meta) {
				if(data == 1)
					return "教师";
				else
					return "学生";
			}  
		},{
			targets: [8],
			render: function(data, type, row, meta) {
                return getEditBtn('user/toEdit.do', row.id);
			}
		}]
	});
});
