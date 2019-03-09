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
<link rel="stylesheet" href="css/style.css" />
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
            <div class="page-content">
               <div class="row">
					<c:forEach items="${parentMenu}" var="parent">
						<dl class="permission-list" id="parentIsHide${parent.id}">
							<dt>
								<label> 
									<input type="checkbox"
									name="parent${parent.id}" id="parent${parent.id}" value="${parent.id}"
									onclick="firstSelectAll(this.checked,${parent.id})">&nbsp;&nbsp;${parent.name}
								</label>
							</dt>
							<dd>
								<c:forEach items="${childMenu}" var="child">
									<c:if test="${child.parentId==parent.id}">
										<dl class="cl permission-list2" id="childIsHide${child.id}">
											<dt class="spacing_two">
												<label> 
													<input type="checkbox" name="child${child.parentId}" id="child${child.id}"
													value="${child.id}"	onclick="secondSelectAll(this.checked,${child.id},${child.parentId})">&nbsp;&nbsp;${child.name}
												</label>
											</dt>
											<dd style="padding: 5px">
												<label class="spacing_two">
												    <input onclick="selectSingle(this.checked,${child.id},${child.parentId})"
													type="checkbox" value="${child.id}"	name="selectFlag${child.id}" class="${child.id}">&nbsp;&nbsp;查看
												</label> 
												<label class="spacing_two">
												    <input onclick="selectSingle(this.checked,${child.id},${child.parentId})" type="checkbox" value="${child.id}"
													name="addFlag${child.id}" class="${child.id}">&nbsp;&nbsp;添加
												</label> 
												<label class="spacing_two"> 
												    <input onclick="selectSingle(this.checked,${child.id},${child.parentId})" type="checkbox" value="${child.id}"
													name="updateFlag${child.id}" class="${child.id}">&nbsp;&nbsp;修改
												</label>
												<label class="spacing_two"> 
												    <input onclick="selectSingle(this.checked,${child.id},${child.parentId})" type="checkbox" value="${child.id}"
													name="deleteFlag${child.id}" class="${child.id}">&nbsp;&nbsp;删除
												</label>
											</dd>
										</dl>
									</c:if>
								</c:forEach>
							</dd>
						</dl>
					</c:forEach>
               </div>
            </div>
         </div>
      </div>
   </div>
   <script src="assets/js/jquery-2.0.3.min.js"></script>
   <script src="assets/js/jquery.mobile.custom.min.js"></script>
   <script src="assets/js/bootstrap.min.js"></script>
   <script src="assets/js/typeahead-bs2.min.js"></script>
   <script src="assets/js/jquery.dataTables.min.js"></script>
   <script src="assets/js/jquery.dataTables.bootstrap.js"></script>
   <script src="assets/js/ace-elements.min.js"></script>
   <script src="assets/js/ace.min.js"></script>
   <script type="text/javascript">
	   /**
	    * 一级全选
	    * @param flag
	    */
	   function firstSelectAll(flag,id){
	       //一级下面最左边的复选框
	    var child=document.getElementsByName("child"+id);
	   	for(var i=0;i<child.length;i++){
	           var secondChildVal=child[i].value;
	           var secondChild=document.getElementsByClassName(""+secondChildVal);
	   		if(flag){
	               child[i].checked=true;
	               for(var j=0;j<secondChild.length;j++){
	                   secondChild[j].checked=true;
	               }
	   		}else{
	               child[i].checked=false;
	               for(var j=0;j<secondChild.length;j++){
	                   secondChild[j].checked=false;
	               }
	   		}
	   	}
	   }
	
	   /**
	    * 二级全选
	    * @param flag
	    */
	   function secondSelectAll(flag,id,parentId){
	       //二级下面的增删改查复选框
	       var secondChild=document.getElementsByClassName(""+id);
	       for(var i=0;i<secondChild.length;i++){
	           if(flag){
	               secondChild[i].checked=true;
	           }else{
	               secondChild[i].checked=false;
	           }
	       }
	       judgeFirst(parentId);
	   }
	
	   /**
	    * 单个复选框操作相关
	    * @param flag
	    */
	   function selectSingle(flag,id,parentId){
	       var thirdChild=document.getElementsByClassName(""+id);
	       //目前只有增删改查4个，如果后期增加其它的需要改此代码
	       if(thirdChild[0].checked&&thirdChild[1].checked&&thirdChild[2].checked&&thirdChild[3].checked){
	           document.getElementById("child"+id).checked=true;
	       }else {
	           document.getElementById("child"+id).checked=false;
	       }
	       judgeFirst(parentId);
	   }
	
	   /**
	    * 判断一级复选框是否选中
	    * @param parentId
	    */
	   function judgeFirst(parentId){
	       var child=document.getElementsByName("child"+parentId);
	       //二级分类目前最多七个、如果超过七个需要修改此处代码
	       switch (child.length){
	           case 1:
	               if(child[0].checked){
	                   document.getElementById("parent"+parentId).checked=true;
	               }else {
	                   document.getElementById("parent"+parentId).checked=false;
	               }
	               break;
	           case 2:
	               if(child[0].checked&&child[1].checked){
	                   document.getElementById("parent"+parentId).checked=true;
	               }else {
	                   document.getElementById("parent"+parentId).checked=false;
	               }
	               break;
	           case 3:
	               if(child[0].checked&&child[1].checked&&child[2].checked){
	                   document.getElementById("parent"+parentId).checked=true;
	               }else {
	                   document.getElementById("parent"+parentId).checked=false;
	               }
	               break;
	           case 4:
	               if(child[0].checked&&child[1].checked&&child[2].checked&&child[3].checked){
	                   document.getElementById("parent"+parentId).checked=true;
	               }else {
	                   document.getElementById("parent"+parentId).checked=false;
	               }
	               break;
	           case 5:
	               if(child[0].checked&&child[1].checked&&child[2].checked&&child[3].checked&&child[4].checked){
	                   document.getElementById("parent"+parentId).checked=true;
	               }else {
	                   document.getElementById("parent"+parentId).checked=false;
	               }
	               break;
	           case 6:
	               if(child[0].checked&&child[1].checked&&child[2].checked&&child[3].checked&&child[4].checked&&child[5].checked){
	                   document.getElementById("parent"+parentId).checked=true;
	               }else {
	                   document.getElementById("parent"+parentId).checked=false;
	               }
	               break;
	           case 7:
	               if(child[0].checked&&child[1].checked&&child[2].checked&&child[3].checked&&child[4].checked&&child[5].checked&&child[6].checked){
	                   document.getElementById("parent"+parentId).checked=true;
	               }else {
	                   document.getElementById("parent"+parentId).checked=false;
	               }
	               break;
	           default:
	               break;
	       }
	   }
   </script>
</body>
</html>
