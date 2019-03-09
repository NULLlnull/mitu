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
			url: contextPath + "/ryjcxx/list.do",
			type: 'post',
			data: function(d) {
				d.search = $('#search').val();
			}
		},
		columns: [{
			data: "id"
		}, {
			data: "rybh"
		}, {
			data: "xm"
		}, {
			data: "xb"
		}, {
			data: "zjlxmc"
		}, {
			data: "zjh",
			defaultContent: ""
		}, {
			data: "hklbmc"
		}, {
			data: "hkdqmc"
		}, {
			data: "mzmc",
			defaultContent: ""
		}, {
			data: "zzmmmc",
			defaultContent: ""
		}, {
			data: "hyzkmc",
			defaultContent: ""
		}, {
			data: "bgdh",
			defaultContent: ""
		}, {
			data: "yddh",
			defaultContent: ""
		}, {
			data: "zgxlmc",
			defaultContent: ""
		}, {
			data: "zgxwmc",
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
					return "男";
				else
					return "女";
			}  
		},{
			targets: [15],
			render: function(data, type, row, meta) {
                return getEditBtn('ryjcxx/toEdit.do', row.id);
			}
		}]
	});
});

