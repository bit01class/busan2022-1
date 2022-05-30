<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
	<div class="navbar-header">
	  <a class="navbar-brand" href="../index.bit">비트교육센터</a>
	</div>
	<p class="navbar-text">
		<a href="../index.bit">HOME</a>
		<a href="../emp/index.bit">EMP</a>
		<a href="../DEPT/index.bit">DEPT</a>
	</p>
  </div>
</nav>
<div class="container">
	<div class="page-header">
	  <h1>List Page <small>emp list</small></h1>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th>empno</th>
				<th>ename</th>
				<th>sal</th>
			</tr>
		</thead>
		<tbody>
		<%@ page import="com.bit.emp.model.*,java.util.List" %>
		<% for(EmpVo bean:(List<EmpVo>)request.getAttribute("list")){%>
			<tr>
				<td><a href="#"><%=bean.getEmpno() %></a></td>
				<td><a href="#"><%=bean.getEname() %></a></td>
				<td><a href="#"><%=bean.getSal() %></a></td>
			</tr>
		<%} %>
		</tbody>
	</table>
</div>
</body>
</html>








