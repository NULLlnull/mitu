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
<script type="text/javascript">
    var baseUrl = '<%=basePath%>';
</script>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <base href=" <%=basePath%>">
    <title>控制台 - 后台管理</title>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="assets/css/css.css?family=Open+Sans:400,300"/>
    <link rel="stylesheet" href="assets/css/ace.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-skins.min.css"/>
    <script src="assets/js/ace-extra.min.js" type="text/javascript"></script>
    <style type="text/css">
        #list thead tr th, tbody tr td {
            text-align: center;
            font-size: 11px
        }

        table tr td {
            height: 35px
        }

        table tr td:first-child {
            width: 4%;
            height: 35px
        }

        table tr th {
            text-align: center
        }

        h2 {
            margin-top: 0px;
            margin-bottom: 5px;
        }

        @page {
            size: landscape;
            margin: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="#">首页</a>
                    </li>
                    <li class="active">课程安排</li>
                </ul>
                <div class="nav-search" id="nav-search">
                  <span class="input-icon">
                     <button class="btn btn-light btn-xs" style="height: 35px" id="loadAllBtn">
                        <i class="icon-save"></i>全校课程表
                     </button>
                     <button class="btn btn-light btn-xs" style="height: 35px" id="printBtn">
						<i class="icon-print"></i>打印
					</button>
                     <button class="btn btn-light btn-xs" style="height: 35px" id="exportExecl">
                        <i class="icon-save"></i>导出
                     </button>
                     <input id="lastOper" type="hidden">
                  </span>
                </div>
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-sm-12">
                        <div id="calendar" class="fc fc-ltr">
                            <table class="fc-header" style="width: 3000px;">
                                <tbody>
                                <tr>
                                    <td class="fc-header-center">
                                    <span class="fc-header-title">
                                       <h2 id="title"></h2>
                                    </span>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="fc-view fc-view-month fc-grid" style="position: relative" unselectable="on">
                                <table class="fc-border-separate" style="width: 3000px" cellspacing="0" id="data">
                                    <thead>
                                    <tr class="fc-first fc-last">
                                        <th class="fc-day-header fc-sun fc-widget-header fc-first"></th>
                                        <th class="fc-day-header fc-mon fc-widget-header" colspan="14">星期一</th>
                                        <th class="fc-day-header fc-mon fc-widget-header" colspan="14">星期二</th>
                                        <th class="fc-day-header fc-tue fc-widget-header" colspan="14">星期三</th>
                                        <th class="fc-day-header fc-wed fc-widget-header" colspan="14">星期四</th>
                                        <th class="fc-day-header fc-thu fc-widget-header" colspan="14">星期五</th>
                                        <th class="fc-day-header fc-fri fc-widget-header" colspan="14">星期六</th>
                                        <th class="fc-day-header fc-sat fc-widget-header" colspan="14">星期日</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="assets/js/jquery.mobile.custom.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/typeahead-bs2.min.js" type="text/javascript"></script>
<script src="assets/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="assets/js/jquery.dataTables.bootstrap.js"
        type="text/javascript"></script>
<script src="assets/js/ace-elements.min.js" type="text/javascript"></script>
<script src="assets/js/ace.min.js" type="text/javascript"></script>
<script src="js/table.js" type="text/javascript"></script>
<script src="js/jquery.print.js" type="text/javascript"></script>
<script type="text/javascript" src="plugins/assets/pages/pkxx_listall.js"></script>
<!-- 筛选渲染 -->
</body>
</html>
