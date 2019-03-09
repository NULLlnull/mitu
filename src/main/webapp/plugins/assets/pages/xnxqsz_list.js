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
			url: contextPath + "/xnxqsz/list.do",
			type: 'post',
			data: function(d) {
				d.search = $('#search').val();
			}
		},
		columns: [{
			data: "id"
		}, {
			data: "xn"
		}, {
			data: "xq"
		}, {
			data: "kxsj"
		}, {
			data: "jssj"
		}, {
			data: "zs",
			defaultContent: ""
		}, {
			data: "xsbdsj"
		}, {
			data: "zckjxrcapkfkssj"
		}, {
			data: "zckjxrcapkfjssj",
			defaultContent: ""
		}, {
			data: "cjlrkssj",
			defaultContent: ""
		}, {
			data: "cjlrjssj",
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
				var date = new Date();
				date.setTime(data);
				return date.format('yyyy-MM-dd');
			}  
		},{
			targets: [4],
			render: function(data, type, row, meta) {
				var date = new Date();
				date.setTime(data);
				return date.format('yyyy-MM-dd');
			}  
		},{
			targets: [6],
			render: function(data, type, row, meta) {
				var date = new Date();
				date.setTime(data);
				return date.format('yyyy-MM-dd');
			}  
		},{
			targets: [7],
			render: function(data, type, row, meta) {
				var date = new Date();
				date.setTime(data);
				return date.format('yyyy-MM-dd');
			}  
		},{
			targets: [8],
			render: function(data, type, row, meta) {
				var date = new Date();
				date.setTime(data);
				return date.format('yyyy-MM-dd');
			}  
		},{
			targets: [9],
			render: function(data, type, row, meta) {
				var date = new Date();
				date.setTime(data);
				return date.format('yyyy-MM-dd');
			}  
		},{
			targets: [10],
			render: function(data, type, row, meta) {
				var date = new Date();
				date.setTime(data);
				return date.format('yyyy-MM-dd');
			}  
		},{
			targets: [11],
			render: function(data, type, row, meta) {
                return getEditBtn('xnxqsz/toEdit.do', row.id);
			}
		}]
	});
});
