<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav>
	<a href="${pageContext.servletContext.contextPath }/index.bit">HOME</a>
	<a href="${pageContext.servletContext.contextPath }/list.bit">EMP</a>
	<a href="${pageContext.servletContext.contextPath }/login.bit">LOGIN</a>
</nav>
<h1>list page</h1>
<a href="add.bit">입력</a>
<%@ page import="com.bit.frame.model.entity.*,java.util.List" %>
<%for(EmpVo bean: (List<EmpVo>)request.getAttribute("list")){ %>
<div><%=bean %></div>
<%} %>

</body>
</html>