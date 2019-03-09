<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<c:set var="resIdAdd" value="${resId}:add"/> 
<c:set var="resIdDel" value="${resId}:del"/> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
      <i class="Hui-iconfont">&#xe67f;</i> 人员管理
      <span class="c-gray en">&gt;</span>学生管理
      <a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);" title="刷新">
         <i class="Hui-iconfont">&#xe68f;</i>
      </a>
   </nav>
   <div class="page-container">
      <div class="cl pd-5 mt-10">
         <c:if test="${sessionScope._cutrrent_privilege[resIdAdd]}">
            <button class="btn btn-primary" type="button" onclick="toAdd('xsxx/toEdit.do')">
               <i class="Hui-iconfont">&#xe600;</i> 新增
            </button>
         </c:if>
         <c:if test="${sessionScope._cutrrent_privilege[resIdDel]}">
            <button class="btn btn-danger" type="button" onclick="del(getDTSelect(), '/xsxx/del.do', reloadTable)">
               <i class="Hui-iconfont">&#xe609;</i> 删除
            </button>
         </c:if>
         <button class="btn btn-success" type="button" onclick="exportExecl();"><i class="Hui-iconfont">&#xe644;</i> 导出
         </button>
         <a id="download" href="" style="visibility: hidden;"></a>
         <div style="float: right">
            <div class="select-box" style="width: 120px;margin-left: 30px">
               <select class="select" id="publicationCategoryId">
                  <option selected="selected" value="">刊物类型</option>
                  <option value="1">类别1</option>
                  <option value="2">类别2</option>
                  <option value="3">类别3</option>
                  <option value="4">类别4</option>
                  <option value="5">类别5</option>
               </select>
            </div>
            <input type="text" id="search" placeholder="论文名称/刊物名称/刊号" style="width:200px" class="input-text">
            <button id="doSearch" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
         </div>
      </div>
      <table class="table table-border table-bordered table-hover table-bg table-sort" width="100%">
         <thead>
            <tr class="text-c">
               <th>
                  <input id="input-0" type="checkbox" name="all">
                  <label for="input-0"></label>
               </th>
               <th>学号</th>
               <th>姓名</th>
               <th>性别</th>
               <th>证件类型</th>
               <th>证件号</th>
               <th>民族</th>
               <th>政治面貌</th>
               <th>所属学院</th>
               <th>所属系部</th>
               <th>所属专业</th>
               <th>所属班级</th>
               <th>学生类别</th>
               <th>学籍状态</th>
               <th>住宿情况</th>
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
   <script type="text/javascript" src="plugins/assets/pages/xsxx_list.js"></script>
</body>
</html>
