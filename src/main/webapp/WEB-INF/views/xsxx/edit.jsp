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
</head>
<body>
   <div class="main-container" id="main-container">
      <div class="main-container-inner">
         <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
               <ul class="breadcrumb">
                  <li>
                     <i class="icon-home home-icon"></i>
                     <a href="#">人员管理</a>
                  </li>
                  <li class="active">学生管理</li>
               </ul>
            </div>
            <div class="page-content">
               <div class="row">
                  <div class="col-xs-12">
                     <form action="" method="post" class="form form-horizontal" id="form-article-add">
                        <input type="hidden" name="id"/>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">学生学号：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="xsxh">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">姓名：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="xm">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">性别：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="xb">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                        	<div class="Add_p_s">
                              <label class="form-label">证件类型：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zjlxmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">证件号：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zjh">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">出生年月：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="csny">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">民族代码：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="mzdm">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">民族名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="mzmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">政治面貌代码：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zzmmdm">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">政治面貌名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zzmmmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">婚姻状况代码：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="hyzkdm">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">家庭电话：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="jtdh">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                        	<div class="Add_p_s">
                              <label class="form-label">家庭地址：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="jtdz">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">家庭地址邮编：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="jtdzyb">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">拼音快速索引：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="pykssy">
                              </div>
                           </div>
                        </div>
                        <div class="dashed"></div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">毕业学校：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="byxx">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">毕业专业：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="byzy">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">高考考生号：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="gkksh">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">入学年月：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="rxny">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">所属学院：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="ssxy">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">所属系部：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="ssxb">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">所属系部名称：</label>
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
                           <div class="Add_p_s">
                              <label class="form-label">所属专业名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="sszymc">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">所属班级：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="ssbj">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">所属班级名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="ssbjmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">学生类别：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="xslb">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                        	<div class="Add_p_s">
                              <label class="form-label">学生类别名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="xslbmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">学生状态：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="xszt">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">学籍状态：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="xjzt">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">毕业状态：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="byzt">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">联系人姓名：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="lxrxm">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">联系人电话：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="lxrdh">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">操作人员：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="czry">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">操作人姓名：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="czrxm">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">住宿情况  ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zsqk">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                        	<div class="Add_p_s">
                              <label class="form-label">住宿情况：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zsqkmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">个人照片：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zp">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">银行名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="yhmc">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">银行帐号：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="yhzh">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">生源地  ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="sydq"/>
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">生源地：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="sydqmc">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                        	<div class="Add_p_s">
                              <label class="form-label">住宿建筑楼：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zsssjzl">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">住宿房间号：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zsssfjh">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">住宿建筑楼名：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zsssjzlmc">
                              </div>
                           </div>
                        </div>
                        <div class="dashed"></div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">港澳台侨外  ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="gatqwdm">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">港澳台侨外 ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="gatqwmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">是否随迁子女：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="sfsqzn">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">出生地区：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="csdq">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">出生地区：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="csdqmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">户口地址 ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="hkdz">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                        	<div class="Add_p_s">
                              <label class="form-label">户口地派出所 ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="hksspcs">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">户口所在地区：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="hkszdq">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">户口所在地区：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="hkszdqmc">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">健康状况：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="jkzkdm">
                              </div>
                           </div>		
                           <div class="Add_p_s">
                              <label class="form-label">健康状况 ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="jkzkmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">住址地区 ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zzdq">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                        	<div class="Add_p_s">
                              <label class="form-label">住址地区：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zzdqmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">居住地类型：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="jzdlxdm">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">居住地类型：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="jzdlxmc">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">是否独生子女 ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="sfdszn">
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
   <script type="text/javascript" src="plugins/assets/pages/xsxx_add.js"></script>
</body>
</html>
