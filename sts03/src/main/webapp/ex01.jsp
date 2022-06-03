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
	<h1>jstl</h1>
	<h2>out</h2>
	<ul>
		<li><c:out value="1234"></c:out></li>
		<li><c:out value="3.14"></c:out></li>
		<li><c:out value="문자열"></c:out> </li>
		<li><c:out value="값1">값2</c:out></li>
		<li><c:out value="${null }">값</c:out></li>
		<li><c:out value="null">비였음</c:out></li>
		<li><c:out default="초기값" value=""></c:out> </li>
		<li><c:out default="초기값" value="${null }"></c:out> </li>
		<li>${"출력" }</li>
		<c:set value="abc" var="a1" scope="page"></c:set>
		<li>${a1 }</li>
		<li><c:out value="${a1 }"></c:out></li>
		<li><c:set var="a2" scope="page">1234</c:set></li>
		<li>${pageScope.a2 }</li>
		<c:set var="a2" scope="request">4321</c:set>
		<li>${requestScope.a2 }</li>
		<jsp:useBean id="bean" class="com.bit.frame.service.UserService"></jsp:useBean>
		<c:set target="${bean}" value="2222" property="su"></c:set>
		<li>${bean.su }</li>
	</ul>
</body>
</html>










