$(function() {

	var roleId = getQueryString('roleId');
	if (roleId) {
		$.post(contextPath + "/role/getPrivilegeByRoleId.do", {
			"roleId" : roleId
		}, function(result) {
			if (result.status == 0) {
				var data = result.data;
				$.each(data, function(index, item) {
					if (item.type == 1) {
						$('#parent' + item.menuId).attr("checked", true);
					} else if (item.type == 2) {
						$('#child' + item.menuId).attr("checked", true);
						if (item.addFlag == 'true') {
							$('#addFlag' + item.menuId).attr("checked", true);
						}
						if (item.updateFlag == 'true') {
							$('#updateFlag' + item.menuId).attr("checked", true);
						}
						if (item.deleteFlag == 'true') {
							$('#deleteFlag' + item.menuId).attr("checked", true);
						}
						if (item.selectFlag == 'true') {
							$('#selectFlag' + item.menuId).attr("checked", true);
						}
					}
				});
			}
		});
	}

	$('#admin-role-save').click(function() {
		$.ajax({
			type : 'post',
			url : contextPath + '/role/addPrivilege.do',
			data : $("#form-admin-role-add").serialize(),
			async : false,
			success : function(data) {
				if (data.status == 0) {
					showSuccessMessage('添加成功!', '', goBack);
				} else {
					showFailMessage("添加失败！", '', '');
				}
			},
			error : function(xhr, status, errorThrown) {
				showFailMessage(errorThrown, '', '');
				return false;
			}
		});
	});
});

/**
 * 一级全选
 * 
 * @param flag
 */
function firstSelectAll(flag, id) {
	// 一级下面最左边的复选框
	var child = $('input[data-menu="' + id + '"]');
	for (var i = 0; i < child.length; i++) {
		var secondChildVal = child[i].value;
		var secondChild = document.getElementsByClassName("" + secondChildVal);
		if (flag) {
			child[i].checked = true;
			for (var j = 0; j < secondChild.length; j++) {
				secondChild[j].checked = true;
			}
		} else {
			child[i].checked = false;
			for (var j = 0; j < secondChild.length; j++) {
				secondChild[j].checked = false;
			}
		}
	}
}

/**
 * 二级全选
 * 
 * @param flag
 */
function secondSelectAll(flag, id, parentId) {
	// 二级下面的增删改查复选框
	var secondChild = document.getElementsByClassName("" + id);
	for (var i = 0; i < secondChild.length; i++) {
		if (flag) {
			secondChild[i].checked = true;
		} else {
			secondChild[i].checked = false;
		}
	}
	judgeFirst(flag, parentId);
}

/**
 * 单个复选框操作相关
 */
function selectSingle(flag, id, parentId) {
	var thirdChild = document.getElementsByClassName("" + id);
	// 目前只有增删改查4个，二级分类目是否选中
	if (thirdChild[0].checked || thirdChild[1].checked || thirdChild[2].checked
			|| thirdChild[3].checked) {
		document.getElementById("child" + id).checked = true;
	} else {
		document.getElementById("child" + id).checked = false;
	}
	judgeFirst(flag, parentId);
}

/**
 * 判断一级复选框是否选中
 * 
 * @param parentId
 */
function judgeFirst(flag, parentId) {
	var child = $('input[data-menu="' + parentId + '"]');
	for (var index = 0; index < child.length; index++) {
		flag = flag || child[index].checked;
	}
	if (flag) {
		$('input[data-menu="parent' + parentId + '"]')[0].checked = true;
	} else {
		$('input[data-menu="parent' + parentId + '"]')[0].checked = false;
	}
}
