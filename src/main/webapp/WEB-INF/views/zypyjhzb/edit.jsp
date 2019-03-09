<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<html>
<head>
    <base href=" <%=basePath%>">
    <meta charset="utf-8"/>
    <title>控制台 - 后台管理</title>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="assets/css/css.css?family=Open+Sans:400,300"/>
    <link rel="stylesheet" href="assets/css/ace.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" type="text/css" href="plugins/assets/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="plugins/assets/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="plugins/assets/lib/Hui-iconfont/1.0.7/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="plugins/assets/lib/icheck/skins/minimal/minimal.css"/>
    <link rel="stylesheet" type="text/css" href="plugins/assets/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="plugins/assets/static/h-ui.admin/css/style.css"/>
    <link rel="stylesheet" href="plugins/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="#">教学基础数据</a>
                    </li>
                    <li class="active">专业管理</li>
                </ul>
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <form action="" method="post" class="form form-horizontal" id="form-article-add">
                            <input type="hidden" name="id"/>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">院内专业代码：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="ynzydm">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">招生专业代码：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="zszydm">
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">院内专业名称：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="ynzymc">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">招生专业名称：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="zszymc">
                                    </div>
                                </div>
                            </div>
                            <div class="dashed"></div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">所属系部：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="ssxbName" id="ssxbName" readonly
                                               onclick="showTreeMenu('#ssxbName','#ssxb'); return false;">
                                        <input type="hidden" name="ssxb" id="ssxb"/>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">培养对象：</label>
                                    <div class="formControls">
                                 <span class="select-box">
                                    <select class="select" name="pydxDm" id="pydxDm">
                                       <option value="">请选择</option>
                                    </select>
                                 </span>
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">培养层次：</label>
                                    <div class="formControls">
                                        <select class="select" name="pyccDm" id="pyccDm">
                                            <option value="">请选择</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">学制：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="xz">
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix cl">
                                <div class="Button_operation">
                                    <button id="submit" class="btn btn-primary radius" type="submit">
                                        <i class="icon-save "></i>保存
                                    </button>
                                    <button onClick="window.history.back(-1);" class="btn btn-default radius"
                                            type="button" id="backBtn">&nbsp;&nbsp;返回&nbsp;&nbsp;
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <table class="table table-border table-bordered table-hover table-bg table-sort" width="100%">
                    <thead>
                    <tr class="text-c">
                        <th>
                            <input id="input-0" type="checkbox" name="all">
                            <label for="input-0"></label>
                        </th>
                        <th>所属系部</th>
                        <th>所属专业</th>
                        <th>开设年级</th>
                        <th>所属教研室</th>
                        <th>计划类型</th>
                        <th>学期</th>
                        <th>课程名称</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<div id="menuContent" class="menuContent"
     style="display:none;background-color: white;position:absolute;z-index:9999;border: 1px solid #DDDDDD">
    <ul id="treeDemo" class="ztree" style="margin-top:0; width:200px;"></ul>
</div>

<script type="text/javascript" src="plugins/assets/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="plugins/assets/lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="plugins/assets/lib/icheck/icheck.min.js"></script>
<script type="text/javascript" src="plugins/assets/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="assets/js/ace-extra.min.js"></script>
<script type="text/javascript" src="plugins/zTree/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="plugins/zTree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plugins/assets/lib/jquery.validation/1.14.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="plugins/assets/lib/jquery.validation/1.14.0/messages_zh.min.js"></script>
<script type="text/javascript" src="plugins/assets/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="plugins/assets/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript"> var contextPath = "${pageContext.request.contextPath}"; </script>
<script type="text/javascript" src="plugins/assets/lib/datatables/datatables.optimize.js"></script>
<script type="text/javascript" src="plugins/assets/lib/formHandle.js"></script>
<script type="text/javascript" src="plugins/assets/pages/commandScript.js"></script>
<script type="text/javascript" src="plugins/assets/pages/zyxx_add.js"></script>
</body>
</html>
