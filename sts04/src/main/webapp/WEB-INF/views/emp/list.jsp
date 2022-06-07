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
<ol class="breadcrumb">
  <li><a href="${root }">Home</a></li>
  <li class="active">EMP</li>
</ol>
<div class="page-header">
  <h1>List Page <small>EMP</small></h1>
</div>
<table class="table">
	<thead>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>hiredate</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list }" var="bean">
		<tr>
			<td><a href="#">${bean.empno }</a></td>
			<td><a href="#">${bean.ename }</a></td>
			<td><a href="#">${bean.hiredate }</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<%@ include file="../template/footer.jspf" %>
</body>
</html>












