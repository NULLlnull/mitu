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
                  <li class="active">教师管理</li>
               </ul>
            </div>
            <div class="page-content">
               <div class="row">
                  <div class="col-xs-12">
                     <form action="" method="post" class="form form-horizontal" id="form-article-add">
                        <input type="hidden" name="id"/>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">人员编号：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="rybh">
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
                              <label class="form-label">户口类别代码：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="hklbdm">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                        	<div class="Add_p_s">
                              <label class="form-label">户口类别名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="hklbmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">户口地区：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="hkdq">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">户口地区名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="hkdqmc">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">出生年月：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="csny">
                              </div>
                           </div>
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
                        </div>
                        <div class="clearfix cl">
                        	<div class="Add_p_s">
                              <label class="form-label">政治面貌代码：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zzmmdm">
                              </div>
                           </div>
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
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">婚姻状况名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="hyzkmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">家庭电话：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="jtdh">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">办公电话：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="bgdh">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">移动电话  ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="yddh">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">电子信箱：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="dzxx">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <label class="form-label col-2">家庭地址：</label>
                           <div class="formControls col-8">
                              <input type="text" class="input-text" name="jtdz">
                           </div>
                        </div>
                        <div class="dashed"></div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">家庭地址邮编：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="jtdzyb">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">最高学历代码：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zgxldm">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">最高学历名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zgxlmc">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">最高学位代码 ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zgxwdm">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">最高学历名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zgxwmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">毕业学校：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="byxx">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                        	<div class="Add_p_s">
                              <label class="form-label">毕业专业：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="byzy">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">最终职称代码：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zgxlmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">最终职称代码 ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zzzcdm">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">最终职称名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zzzcmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">拼音快速索引：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="pykssy">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">曾用名：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="zym">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                        	<div class="Add_p_s">
                              <label class="form-label">参加党派时间：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="cjdpsj">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">计划生育状况 ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="jhsyzk">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">计划生育状况：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="jhsyzkmc">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">一卡通唯一码：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="cardid">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">国籍/地区：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="gjdqdm">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">国籍/地区：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="gjdqmc">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">姓名拼音 ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="xmpy">
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
   <script type="text/javascript" src="plugins/assets/pages/ryjcxx_add.js"></script>
</body>
</html>
