<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
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
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="plugins/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script src="assets/js/jquery-2.0.3.min.js"></script>
    <script type="text/javascript" src="plugins/zTree/js/jquery.ztree.all-3.5.min.js"></script>
    <script type="text/javascript" src="plugins/zTree/js/jquery.ztree.core-3.5.min.js"></script>
    <script src="assets/js/ace-elements.min.js"></script>
    <script src="assets/js/ace.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/typeahead-bs2.min.js"></script>
</head>
<body>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li><i class="icon-home home-icon"></i> <a href="#">系统管理</a></li>
                    <li class="active">组织机构管理</li>
                </ul>
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-body" style="border: 1px solid #CCC">
                            <div class="widget-main padding-8">
                                <div id="treeDemo" class="ztree" style="font-size: 36px"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var setting = {
        view: {
            dblClickExpand: false,
            showLine: false,
            selectedMulti: false,
            fontCss: getFont
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },
        callback: {}
    };

    function getFont(treeId, node) {
        return node.font ? node.font : {};
    }

    var treeNodes;
    $(document).ready(function () {
        $.ajax({
            url: "xyjgxx/list.do",
            contentType: "application/json;charset=utf-8",
            data: {},
            dataType: "text",
            success: function (result) {
                treeNodes = eval(result);
                $.fn.zTree.init($("#treeDemo"), setting, treeNodes);
            },
            error: function (msg) {
            }
        });
    });
</script>
</body>
</html>
