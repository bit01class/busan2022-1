<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>list</h1>
	<%
	java.util.List<String> list=new java.util.ArrayList<String>();
	list.add("item1");
	list.add("item2");
	list.add("item3");
	list.add("item4");
	list.add("item5");
	pageContext.setAttribute("list", list);
	%>
	
	<ul>
	<c:forEach items="${list }" var="msg" varStatus="status">
		<li>${msg } - ${status.index }, ${status.count }</li>
	</c:forEach>
	</ul>
</body>
</html>