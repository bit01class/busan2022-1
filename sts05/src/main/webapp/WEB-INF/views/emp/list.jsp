<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
</head>
<body>
<%@ include file="../template/menu.jspf" %>
<div class="page-header">
  <h1>List Page <small>EMP list</small></h1>
</div>
<p><a href="add" class="btn btn-primary btn-block" role="button">입력</a></p>
<div class="list-group">
  <div class="list-group-item active">
  	<h4 class="list-group-item-heading">ename</h4>
    <p class="list-group-item-text">hiredate</p>
  </div>
	<c:forEach items="${list }" var="bean">
  <a href="#" class="list-group-item">
    <h4 class="list-group-item-heading">${bean.ename }(${bean.empno })</h4>
    <p class="list-group-item-text">${bean.hiredate }</p>
  </a>
	</c:forEach>  
</div>
<%@ include file="../template/footer.jspf" %>
</body>
</html>