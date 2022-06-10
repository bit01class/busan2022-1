<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/header.jspf" %>
</head>
<body>
<%@ include file="template/menu.jspf" %>
<div class="page-header">
  <h1>DEPT List <small>dept</small></h1>
</div>
<a href="./add" class="btn btn-primary btn-block" role="button">입력</a>
<table class="table">
	<thead>
		<tr>
			<th>deptno</th>
			<th>dname</th>
			<th>loc</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="bean">
		<tr>
			<td><a href="./${bean.deptno }">${bean.deptno }</a></td>
			<td><a href="./${bean.deptno }">${bean.dname }</a></td>
			<td><a href="./${bean.deptno }">${bean.loc }</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>