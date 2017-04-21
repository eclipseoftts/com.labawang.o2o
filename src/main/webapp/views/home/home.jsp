<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
	<%@ include file="head.jsp"%>
</head>
<body>
	<div id="main-wrapper">
    	<%@ include file="top.jsp"%>
    </div>
    <div class="template-page-wrapper">
    	<!-- 左侧导航栏 -->
      <%@ include file="left.jsp"%>

	  <!-- 中间内容部分 -->
	  <%@ include file="right.jsp"%>
      <!-- Modal -->
      <!-- 底部；链接 -->
	  <%@ include file="bottom.jsp"%>
    </div>
  </body>
</html>