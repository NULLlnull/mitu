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
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/css.css?family=Open+Sans:400,300" />
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="css/style.css"/>   
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<script src="assets/js/ace-extra.min.js"></script>
<style type="text/css">
#list thead tr th, tbody tr td {
	text-align: center;
	font-size: 13px
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
                     <a href="#">系统管理</a>
                  </li>
                  <li class="active">用户管理</li>
               </ul>
            </div>
            <div class="page-content">
               <div class="row">
                  <div class="col-xs-12">
                     <form action="" method="post" class="form form-horizontal" id="form-article-add">
                        <input type="hidden" name="id"/>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">用户名：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="username">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">状态：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="status">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">类型：</label>
                              <div class="formControls">
                                 <span class="select-box">
                                    <select class="select" name="type">
                                       <option value="1">教师</option>
                                       <option value="2">学生</option>
                                    </select>
                                 </span>
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">外键：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="fk">
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
   <script type="text/javascript" src="plugins/assets/pages/user_add.js"></script>
</body>
</html>
