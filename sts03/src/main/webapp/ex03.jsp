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
	<h1>반복</h1>
	
	<ul>
	<c:forEach begin="10" end="20" var="i" step="2" varStatus="status">
		<li>item${i } - ${status.index }, ${status.count }, ${status.first }, ${status.last }</li>
	</c:forEach>
	</ul>
</body>
</html>