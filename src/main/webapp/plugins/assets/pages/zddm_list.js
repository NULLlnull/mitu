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
			url: contextPath + "/zddm/list.do",
			type: 'post',
			data: function(d) {
				d.search = $('#search').val();
			}
		},
		columns: [{
			data: "id"
		}, {
			data: "sszdlb"
		}, {
			data: "dmbh"
		}, {
			data: "dmmc"
		}, {
			data: "sort"
		}, {
			data: "pykssy",
			defaultContent: ""
		}],
		columnDefs: [{
			targets: [0],
			render: function(data, type, row, meta) {
				return '<input id="input-' + data + '" type="checkbox" name="single"><label for="input-' + data + '"></label>';
			}  
		},{
			targets: [6],
			render: function(data, type, row, meta) {
                return getEditBtn('zddm/toEdit.do', row.id);
			}
		}]
	});
});

