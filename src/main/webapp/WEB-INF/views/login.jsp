<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<script>
if (window != top){
    top.location.href = location.href;
}
</script>
<base href=" <%=basePath%>">
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>控制台 - 基础信息平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="css/style.css" />
<script src="assets/js/ace-extra.min.js"></script>
<script src="js/jquery-1.9.1.min.js"></script>
<script src="assets/layer/layer.js" type="text/javascript"></script>
</head>
<body class="login-layout">
   <div class="logintop">
      <span>欢迎进入基础信息管理平台</span>
   </div>
   <div class="loginbody">
      <div class="login-container">
         <div class="center">
            <h1>
               <i class="icon-leaf green"></i>
               <span class="orange">基础信息</span>
               <span class="white">后台管理系统</span>
            </h1>
            <h4 class="white">datahouse Management System</h4>
         </div>
         <div class="space-6"></div>
         <div class="position-relative">
            <div id="login-box" class="login-box widget-box no-border visible">
               <div class="widget-body">
                  <div class="widget-main">
                     <h4 class="header blue lighter bigger">
                        <i class="icon-coffee green"></i> 管理员登陆
                     </h4>
                     <div class="login_icon">
                        <img src="images/login.png" />
                     </div>
                     <form class="">
                        <fieldset>
                           <label class="block clearfix"> <span class="block input-icon input-icon-right">
                                 <input type="text" class="form-control" placeholder="登录名" name="username">
                                 <i class="icon-user"></i>
                              </span>
                           </label> <label class="block clearfix"> <span class="block input-icon input-icon-right">
                                 <input type="password" class="form-control" placeholder="密码" name="password">
                                 <i class="icon-lock"></i>
                              </span>
                           </label>
                           <div class="space"></div>
                           <div class="clearfix">
                              <label class="inline"> <input type="checkbox" class="ace"> <span class="lbl">保存密码</span>
                              </label>
                              <button type="button" class="width-35 pull-right btn btn-sm btn-primary" id="login_btn">
                                 <i class="icon-key"></i> 登陆
                              </button>
                           </div>
                           <div class="space-4"></div>
                        </fieldset>
                     </form>
                  </div>
                  <div class="toolbar clearfix"></div>
               </div>
            </div>
         </div>
      </div>
   </div>
   <div class="loginbm">
                      版权所有 2018 &nbsp;&nbsp;<a href="">基础信息管理平台</a>
   </div>
</body>
</html>
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
</script>
<script src="plugins/assets/pages/login.js"></script>