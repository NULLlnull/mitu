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
    <script src="assets/js/ace-extra.min.js"></script>
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
                    <li class="active">班级管理</li>
                </ul>
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <form action="" method="post" class="form form-horizontal" id="form-article-add">
                            <input type="hidden" name="id"/>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">所属学院：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="ssxy">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">所属校区：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="ssxq">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">所属校区：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="ssxqmc">
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">所属系部：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="ssxb">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">所属系部：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="ssxbmc">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">所属专业：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="sszy">
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">所属专业：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="sszymc">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">培养对象：</label>
                                    <div class="formControls">
                                 <span class="select-box">
                                    <select class="select" name="pydx" id="pydx">
                                       <option value="">请选择</option>
                                    </select>
                                 </span>
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">培养对象：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="pydxmc">
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">培养层次：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="pycc">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">培养层次：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="pyccmc">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">专业方向：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="zyfx">
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">专业方向名称：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="zyfxmc">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">班级代码：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="bjdm">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">班级名称：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="bjmc">
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">班级简称：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="bjjc">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">年级：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="nj">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">学制：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="xz">
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">建立时间：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="jlsj" format="yyyy-MM-dd">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">毕业届别：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="byjb">
                                    </div>
                                </div>
                            </div>
                            <div class="dashed"></div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">班级在校人数：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="bjzxrs">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">在校人数_男：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="bjzxrs_m">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">在校人数_女：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="bjzxrs_f">
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">实际在校人数：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="bjsjzxrs">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">实际在校数_男：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="bjsjzxrs_m">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">实际在校数_女：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="bjsjzxrs_f">
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">停用标志：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="tybz">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">辅导员：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="fdy ">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">辅导员姓名：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="fdyxm">
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix cl">
                                <div class="Add_p_s">
                                    <label class="form-label">学委：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="xw">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">学委姓名：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="xwxm">
                                    </div>
                                </div>
                                <div class="Add_p_s">
                                    <label class="form-label">辅助考勤开放：</label>
                                    <div class="formControls">
                                        <input type="text" class="input-text" name="xwfzkqkf">
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
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="plugins/assets/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="plugins/assets/lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="plugins/assets/lib/icheck/icheck.min.js"></script>
<script type="text/javascript" src="plugins/assets/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="plugins/assets/lib/jquery.validation/1.14.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="plugins/assets/lib/jquery.validation/1.14.0/messages_zh.min.js"></script>
<script type="text/javascript" src="plugins/assets/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="plugins/assets/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript"> var contextPath = "${pageContext.request.contextPath}"; </script>
<script type="text/javascript" src="plugins/assets/lib/formHandle.js"></script>
<script type="text/javascript" src="plugins/assets/pages/commandScript.js"></script>
<script type="text/javascript" src="plugins/assets/pages/bjxx_add.js"></script>
</body>
</html>
