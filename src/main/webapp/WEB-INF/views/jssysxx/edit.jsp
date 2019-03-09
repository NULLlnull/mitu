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
                     <a href="#">基础数据</a>
                  </li>
                  <li class="active">教室管理</li>
               </ul>
            </div>
            <div class="page-content">
               <div class="row">
                  <div class="col-xs-12">
                     <form action="" method="post" class="form form-horizontal" id="form-article-add">
                        <input type="hidden" name="id"/>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">类别：</label>
                              <div class="formControls">
                                 <span class="select-box">
                                    <select class="select" name="lb">
                                       <option value="1">校内</option>
                                       <option value="2">校外</option>
                                    </select>
                                 </span>
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">类型：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="lx">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">编码：</label>
                              <div class="formControls">
                                <input type="text" class="input-text" name="jssysdm">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="jssysdm">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">简称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="jssysjc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">所属学院：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="ssxy">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">所属校区：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="ssxq">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">校区名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="ssxqmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">所属建筑楼：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="ssjzl">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">建筑楼名称：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="ssjzlmc">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">层号：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="ch">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">门牌号 ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="mph">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">学生容量：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="xsrl">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">班级容量：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="bjrl">
                              </div>
                           </div>
                        </div>
                        <div class="dashed"></div>
                        <div class="clearfix cl">
                           <div>
                              <label class="form-label" style="width: 200px">是否有多媒体设备(电脑)：</label>
                              <div class="formControls">
                                 <span class="select-box">
                                    <select class="select" name="sfydmtsb" style="width: 100px">
                                       <option value="1">是</option>
                                       <option value="0">否</option>
                                    </select>
                                 </span>
                              </div>
                           </div>
                           <div>
                              <label class="form-label" style="width: 200px">是否有投影设备：</label>
                              <div class="formControls">
                                 <span class="select-box">
                                    <select class="select" name="sfytyysb" style="width: 100px">
                                       <option value="1">是</option>
                                       <option value="0">否</option>
                                    </select>
                                 </span>
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div>
                              <label class="form-label" style="width: 200px">是否有空调设备：</label>
                              <div class="formControls">
                                 <span class="select-box">
                                    <select class="select" name="sfyktsb" style="width: 100px">
                                       <option value="1">是</option>
                                       <option value="0">否</option>
                                    </select>
                                 </span>
                              </div>
                           </div>
                           <div>
                              <label class="form-label" style="width: 200px">是否有录制设备：</label>
                              <div class="formControls">
                                 <span class="select-box">
                                    <select class="select" name="sfylzsb" style="width: 100px">
                                       <option value="1">是</option>
                                       <option value="0">否</option>
                                    </select>
                                 </span>
                              </div>
                           </div>
                           <div>
                              <label class="form-label" style="width: 200px">是否有远程视频设备：</label>
                              <div class="formControls">
                                 <span class="select-box">
                                    <select class="select" name="sfyycspsb" style="width: 100px">
                                       <option value="1">是</option>
                                       <option value="0">否</option>
                                    </select>
                                 </span>
                              </div>
                           </div>
                        </div>
                        <div class="dashed"></div>
                        <div class="clearfix cl">
                           <div	 class="Add_p_s">
                              <label class="form-label">管辖机构：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="gxjgdm">
                              </div>
                           </div>
                           <div>
                              <label class="form-label">管辖机构 ：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="gxjgmc" style="width: 380px">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">操作人员：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="oprybh">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">开放自选：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="kfzxbz">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">学生管理员：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="cdxsgly">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label">学生管理员：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="cdxsglyxm">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">管理员工号：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="cdglygh">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label">管理员姓名：</label>
                              <div class="formControls">
                                <input type="text" class="input-text"  name="cdglyxm">
                              </div>
                           </div>
                        </div>
                        <div class="clearfix cl">
                           <div class="Add_p_s">
                              <label class="form-label" style="width: 120px">分配班级代码：</label>
                              <div class="formControls" style="left:100px">
                                <input type="text" class="input-text"  name="fbbjdm">
                              </div>
                           </div>
                           <div class="Add_p_s">
                              <label class="form-label" style="width: 120px">分配班级名称：</label>
                              <div class="formControls" style="left:100px">
                                <input type="text" class="input-text"  name="fbbjmc">
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
   <script type="text/javascript" src="plugins/assets/pages/jssysxx_add.js"></script>
</body>
</html>
