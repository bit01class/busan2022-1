<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>request</h1>
<p>method:<%=request.getMethod() %></p>
<p>contextPath:<%=request.getContextPath() %></p>
<p>param:<%=request.getQueryString() %></p>
</body>
</html>