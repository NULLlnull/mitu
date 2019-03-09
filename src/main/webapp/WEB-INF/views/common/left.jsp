<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <title>控制台 - 基础信息管理平台</title>
   <!-- basic styles -->
   <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
   <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
   <link rel="stylesheet" href="assets/css/css.css?family=Open+Sans:400,300"/>
   <link rel="stylesheet" href="assets/css/ace.min.css"/>
   <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
   <link rel="stylesheet" href="assets/css/ace-skins.min.css"/>
   <script src="assets/js/ace-extra.min.js"></script>
</head>
<div>
   <div class="sidebar-shortcuts" id="sidebar-shortcuts">
      <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large"
           style="background-color: #62a8d1;color: #ffffff">
         基础信息管理平台
      </div>
   </div>
   <!-- #sidebar-shortcuts -->
   <ul class="nav nav-list">
      <c:forEach items="${parentMenu}" var="parent">
         <li>
            <a href="#" class="dropdown-toggle">
               <i class="${parent.icon} ${parent.color}"></i>
               <span class="menu-text"> ${parent.name} </span>
               <b class="arrow icon-angle-down"></b>
            </a>
            <ul class="submenu">
               <c:forEach items="${childMenu}" var="child">
                    <c:if test="${child.parentId==parent.id}">
                        <li class="home">
                           <a href="${child.resUrl}?resId=${child.id}" target="mainFrame" title="${child.name} " class="iframeurl">
                              <i class="icon-double-angle-right"></i>${child.name}
                           </a>
                        </li>
                     </c:if>
               </c:forEach>
           </ul>
         </li>
      </c:forEach>
   </ul>
</div>
<script src="assets/js/jquery-2.0.3.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>
<script src="assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="assets/js/jquery.slimscroll.min.js"></script>
<script src="assets/js/flot/jquery.flot.min.js"></script>
<script src="assets/js/flot/jquery.flot.resize.min.js"></script>
<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace.min.js"></script>
</html>
