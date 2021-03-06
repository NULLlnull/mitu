<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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
    <meta charset="utf-8"/>
    <title>控制台 - 后台管理</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" type="text/css" href="plugins/assets/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="plugins/assets/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="plugins/assets/lib/Hui-iconfont/1.0.7/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="plugins/assets/lib/icheck/skins/minimal/minimal.css"/>
    <link rel="stylesheet" type="text/css" href="plugins/assets/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="plugins/assets/static/h-ui.admin/css/style.css"/>
    <link rel="stylesheet" href="plugins/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 教学基础数据
    <span class="c-gray en">&gt;</span>专业管理
    <a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="cl pd-5 mt-10 col-xs-2">
        <div class="widget-body" style="border: 1px solid #CCC">
            <div class="widget-main padding-8">
                <div id="treeDemo" class="ztree" style="font-size: 36px">组织机构</div>
            </div>
        </div>
    </div>
    <div class="cl col-xs-10">
        <div class="pd-5 mt-10">
            <c:if test="${sessionScope._cutrrent_privilege[resIdAdd]}">
                <button class="btn btn-primary" type="button" onclick="toAdd('zyxx/toEdit.do')">
                    <i class="Hui-iconfont">&#xe600;</i> 新增
                </button>
            </c:if>
            <c:if test="${sessionScope._cutrrent_privilege[resIdDel]}">
                <button class="btn btn-danger" type="button" onclick="del(getDTSelect(), '/zyxx/del.do', reloadTable)">
                    <i class="Hui-iconfont">&#xe609;</i> 删除
                </button>
            </c:if>
            <button class="btn btn-success" type="button" onclick="exportExecl();"><i class="Hui-iconfont">&#xe644;</i>
                导出
            </button>
            <a id="download" href="" style="visibility: hidden;"></a>
            <div style="float: right">
                <div class="select-box" style="width: 120px;margin-left: 30px">
                    <select class="select" id="pydxDm">
                        <option selected="selected" value="">培养对象</option>
                    </select>
                </div>
                <div class="select-box" style="width: 120px;margin-left: 30px">
                    <select class="select" id="pyccDm">
                        <option selected="selected" value="">培养层次</option>
                    </select>
                </div>
                <input type="text" id="search" placeholder="专业代码/专业名称" style="width:200px" class="input-text">
                <input type="hidden" id="ssxb">
                <button id="doSearch" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索
                </button>
            </div>
        </div>
        <table class="table table-border table-bordered table-hover table-bg table-sort" width="100%">
            <thead>
            <tr class="text-c">
                <th>
                    <input id="input-0" type="checkbox" name="all">
                    <label for="input-0"></label>
                </th>
                <th>院内专业代码</th>
                <th>招生专业代码</th>
                <th>院内专业名称</th>
                <th>招生专业名称</th>
                <th>所属系部</th>
                <th>培养对象</th>
                <th>培养层次</th>
                <th>学制</th>
                <th>操作</th>
            </tr>
            </thead>
        </table>
    </div>
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
<script type="text/javascript" src="plugins/zTree/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="plugins/zTree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plugins/assets/pages/commandScript.js"></script>
<script type="text/javascript" src="plugins/assets/pages/zyxx_list.js"></script>
</body>
</html>
