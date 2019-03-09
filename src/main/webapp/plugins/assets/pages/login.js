$(document).keyup(function(event) {
	if (event.keyCode == 13) {
		$("#login_btn").trigger("click");
	}
});

$('#login_btn').on('click', function() {
	var username = $("input[name='username']").val();
	if (username == "") {
		showFailMsg("用户名不能为空！\r\n");
		return;
	}
	var pwd = $("input[name='password']").val();
	if (pwd == "") {
		showFailMsg("密码不能为空！\r\n");
		return;
	}

	$.ajax({
		type : "post",
		url : contextPath + "/user/userLogin.do",
		data : {
			"username" : username,
			"password" : pwd
		},
		async : false,
		success : function(data) {
			if (data.status == 0) {
				showSuccessMsg();
			} else {
				showFailMsg("登录失败!\r\n")
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			showFailMsg("登录失败!\r\n")
			return false;
		}
	});
});

function showSuccessMsg() {
	layer.alert("登录成功!\r\n", {
		title : '提示框',
		icon : 1,
		time : 2000,
		end : function() {
			window.location.href = "index.do"
		}
	});
}

function showFailMsg(msg) {
	layer.alert(msg, {
		title : '提示框',
		icon : 0,
	});
}