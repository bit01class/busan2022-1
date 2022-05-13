<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="obj" class="com.bit.util.EmpDto" scope="request"></jsp:useBean>
<%
obj.setEname("아무개");
%>
<jsp:forward page="index.jsp"></jsp:forward>
</body>
</html>