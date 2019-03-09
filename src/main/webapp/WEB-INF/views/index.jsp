<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>控制台 - 基础信息平台</title>
</head>
<frameset border=0 frameSpacing=0 rows=70,* frameBorder=0 id="mainparent">
   <frame name=topFrame src="${pageContext.request.contextPath }/head.do" noResize scrolling=no>
   <frameset id="main" border="0" frameSpacing="0" frameBorder="0" cols="190px,*">
      <frame name="leftFrame" src="${pageContext.request.contextPath }/left.do" noResize>
      <frame name="mainFrame" src="${pageContext.request.contextPath }/main.do">
   </frameset>
</frameset>
</html>