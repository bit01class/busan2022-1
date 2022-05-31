<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
</head>
<body>
<%@ include file="../template/menu.jspf" %>
<div class="jumbotron">
  <h1>EMP List page</h1>
  <p><a class="btn btn-primary btn-lg" href="add.bit" role="button">입력</a></p>
</div>
<div class="container">
	<table class="table">
		<thead>
			<tr>
				<th>empno</th>
				<th>ename</th>
				<th>sal</th>
				<th>job</th>
			</tr>
		</thead>
		<tbody>
		<%@ page import="java.util.List,com.bit.model.EmpVo" %>
		<%for(EmpVo bean:(List<EmpVo>)request.getAttribute("list")) {%>
			<tr>
				<td><a href="detail.bit?empno=<%=bean.getEmpno() %>"><%=bean.getEmpno() %></a></td>
				<td><a href="detail.bit?empno=<%=bean.getEmpno() %>"><%=bean.getEname() %></a></td>
				<td><a href="detail.bit?empno=<%=bean.getEmpno() %>"><%=bean.getSal() %></a></td>
				<td><a href="detail.bit?empno=<%=bean.getEmpno() %>"><%=bean.getJob() %></a></td>
			</tr>
		<%} %>
		</tbody>
	</table>
</div>
</body>
</html>