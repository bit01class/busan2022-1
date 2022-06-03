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
	<h1>조건문</h1>
	<h2>if조건문</h2>
	<c:set value="3" var="su"></c:set>
	<c:if test="${su>1}">
		<p>1보다 크거나</p>
		<c:if test="${su<5 }">
			<p>5보다 작다</p>
		</c:if>
	</c:if>
	<h2>when조건문</h2>
	<c:choose>
		<c:when test="${su<1 }">
			<p>1보다 작다</p>
		</c:when>
		<c:when test="${su<2 }">
			<p>2보다 작다</p>
		</c:when>
		<c:when test="${su<3 }">
			<p>3보다 작다</p>
		</c:when>
		<c:otherwise>
			<p>3이상</p>
		</c:otherwise>
	</c:choose>
</body>
</html>








