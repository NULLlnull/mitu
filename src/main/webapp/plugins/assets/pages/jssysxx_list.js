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
			url: contextPath + "/jssysxx/list.do",
			type: 'post',
			data: function(d) {
				d.search = $('#search').val();
			}
		},
		columns: [{
			data: "id"
		}, {
			data: "jssysmc"
		}, {
			data: "ssxy"
		}, {
			data: "ssxqmc",
			defaultContent: ""
		}, {
			data: "ssjzlmc",
			defaultContent: ""
		}, {
			data: "ch"
		}, {
			data: "mph"
		}, {
			data: "xsrl",
			defaultContent: ""
		}, {
			data: "sfydmtsb"
		}, {
			data: "sfytyysb"
		}, {
			data: "sfyktsb"
		}, {
			data: "sfylzsb"
		}, {
			data: "sfyycspsb"
		}],
		columnDefs: [{
			targets: [0],
			render: function(data, type, row, meta) {
				return '<input id="input-' + data + '" type="checkbox" name="single"><label for="input-' + data + '"></label>';
			}  
		},{
			targets: [9],
			render: function(data, type, row, meta) {
				if(data == 1)
					return "√";
				else
					return "-";
			}  
		},{
			targets: [10],
			render: function(data, type, row, meta) {
				if(data == 1)
					return "√";
				else
					return "-";
			}  
		},{
			targets: [11],
			render: function(data, type, row, meta) {
				if(data == 1)
					return "√";
				else
					return "-";
			}  
		},{
			targets: [12],
			render: function(data, type, row, meta) {
				if(data == 1)
					return "√";
				else
					return "-";
			}  
		},{
			targets: [13],
			render: function(data, type, row, meta) {
                return getEditBtn('jssysxx/toEdit.do',row.id);
			}
		}]
	});
});
