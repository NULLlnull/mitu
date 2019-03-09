<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<html>
<head>
<base href=" <%=basePath%>"> 
<meta charset="utf-8" />
<title>控制台 - 后台管理</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css" href="plugins/assets/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="plugins/assets/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="plugins/assets/lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css" href="plugins/assets/lib/icheck/skins/minimal/minimal.css" />
<link rel="stylesheet" type="text/css" href="plugins/assets/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="plugins/assets/static/h-ui.admin/css/style.css" />
</head>
<body>
   <nav class="breadcrumb">
      <i class="Hui-iconfont">&#xe67f;</i> 系统管理
      <span class="c-gray en">&gt;</span>角色管理
      <a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);" title="刷新">
         <i class="Hui-iconfont">&#xe68f;</i>
      </a>
   </nav>
   <div class="page-container">
      <div class="cl pd-5 bg-1 bk-gray mt-20">
      </div>
      <table class="table table-border table-bordered table-hover table-bg table-sort" width="100%">
         <thead>
            <tr class="text-c">
               <th>
                  <input id="input-0" type="checkbox" name="all">
                  <label for="input-0"></label>
               </th>
               <th>名称</th>
               <th>描述</th>
               <th>操作</th>
            </tr>
         </thead>
      </table>
   </div>
   <script type="text/javascript" src="plugins/assets/lib/jquery/1.9.1/jquery.min.js"></script>
   <script type="text/javascript" src="plugins/assets/lib/layer/2.1/layer.js"></script>
   <script type="text/javascript" src="plugins/assets/lib/icheck/icheck.min.js"></script>
   <script type="text/javascript" src="plugins/assets/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
   <script type="text/javascript" src="plugins/assets/static/h-ui/js/H-ui.js"></script>
   <script type="text/javascript" src="plugins/assets/static/h-ui.admin/js/H-ui.admin.js"></script>
   <script type="text/javascript">
		var contextPath = "${pageContext.request.contextPath}";
   </script>
   <script type="text/javascript" src="plugins/assets/lib/datatables/datatables.optimize.js"></script>
   <script type="text/javascript" src="plugins/assets/pages/commandScript.js"></script>
   <script type="text/javascript" src="plugins/assets/pages/role_list.js"></script>
</body>
</html>
