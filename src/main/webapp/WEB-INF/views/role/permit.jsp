<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
         + path + "/";
%>
<!DOCTYPE HTML>
<html>
<base href=" <%=basePath%>">
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/plugins/assets/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/plugins/assets/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/plugins/assets/lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/plugins/assets/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/plugins/assets/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/plugins/assets/lib/icheck/icheck.css" />
</head>
<body>
   <article class="page-container">
      <form action="" class="form form-horizontal" id="form-admin-role-add" method="post">
         <input name="roleId" value="${roleId}" type="hidden">
         <div class="row cl">
            <div class="formControls col-xs-12 col-sm-8 col-sm-offset-2">
               <c:forEach items="${parentMenu}" var="parent">
                  <dl class="permission-list">
                     <dt>
                        <label> 
                           <input type="checkbox" data-menu="parent${parent.id}" name="parents" id="parent${parent.id}" value="${parent.id}" onclick="firstSelectAll(this.checked,${parent.id})">
                           &nbsp;&nbsp;${parent.name}
                           <div style="float: right;color: red">
                              <c:if test="${parent.sysId == 1}">
                                 (基础数据平台)
                              </c:if>
                              <c:if test="${parent.sysId == 2}">
                                 (教师资料平台)
                              </c:if>
                           </div>
                        </label>
                     </dt>
                     <dd>
                        <c:forEach items="${childMenu}" var="child">
                           <c:if test="${child.parentId==parent.id}">
                              <dl class="cl permission-list2">
                                 <dt class="spacing_two">
                                    <label> <input data-menu="${child.parentId}" type="checkbox" name="children" id="child${child.id}" value="${child.id}" onclick="secondSelectAll(this.checked,${child.id},${child.parentId})">&nbsp;&nbsp;${child.name}
                                    </label>
                                 </dt>
                                 <dd style="padding-left: 50px">
                                    <label class="spacing_two"> <input onclick="selectSingle(this.checked,${child.id},${child.parentId})" type="checkbox" value="${child.id}" name="selectFlag${child.id}" id="selectFlag${child.id}" class="${child.id}">&nbsp;&nbsp;查看 </label>
                                    <label class="spacing_two"> <input onclick="selectSingle(this.checked,${child.id},${child.parentId})" type="checkbox" value="${child.id}" name="addFlag${child.id}" id="addFlag${child.id}" class="${child.id}">&nbsp;&nbsp;添加</label>
                                    <label class="spacing_two"> <input onclick="selectSingle(this.checked,${child.id},${child.parentId})" type="checkbox" value="${child.id}" name="updateFlag${child.id}" id="updateFlag${child.id}" class="${child.id}">&nbsp;&nbsp;修改 </label>
                                    <label class="spacing_two"> <input onclick="selectSingle(this.checked,${child.id},${child.parentId})" type="checkbox" value="${child.id}" name="deleteFlag${child.id}" id="deleteFlag${child.id}" class="${child.id}">&nbsp;&nbsp;删除 </label>
                                 </dd>
                              </dl>
                           </c:if>
                        </c:forEach>
                     </dd>
                  </dl>
               </c:forEach>
            </div>
         </div>
         <div class="row cl">
            <div class="col-xs-12 col-sm-4 col-sm-offset-4">
               <button type="button" class="btn btn-primary radius" id="admin-role-save" name="admin-role-save">
                  <i class="icon-ok"></i> 确定
               </button>
               <button onClick="window.history.back(-1);" class="btn btn-default radius" type="button" style="margin-left: 50px" id="backBtn">返回</button>
            </div>
         </div>
      </form>
   </article>
   <!--请在下方写此页面业务相关的脚本-->
   <script type="text/javascript"> var contextPath = "${pageContext.request.contextPath}"; </script>
   <script type="text/javascript" src="plugins/assets/lib/jquery/1.9.1/jquery.min.js"></script>
   <script type="text/javascript" src="plugins/assets/lib/layer/2.1/layer.js"></script>
   <script type="text/javascript" src="plugins/assets/lib/icheck/icheck.min.js"></script>
   <script type="text/javascript" src="plugins/assets/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
   <script type="text/javascript" src="plugins/assets/lib/jquery.validation/1.14.0/jquery.validate.min.js"></script>
   <script type="text/javascript" src="plugins/assets/lib/jquery.validation/1.14.0/messages_zh.min.js"></script>
   <script type="text/javascript" src="plugins/assets/static/h-ui/js/H-ui.js"></script>
   <script type="text/javascript" src="plugins/assets/static/h-ui.admin/js/H-ui.admin.js"></script>
   <script type="text/javascript" src="plugins/assets/pages/commandScript.js"></script>
   <script type="text/javascript" src="plugins/assets/pages/role_permit.js"></script>
</body>
</html>