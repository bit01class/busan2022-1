<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="won" value="10000"></c:set>
	<fmt:formatNumber var="money" value="${won }" pattern="###,###.##" ></fmt:formatNumber>
	<p>${money }</p>
	<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
	<p><fmt:formatDate value="${now }" pattern="yy/MM/dd hh:mm:ss"/> </p>
</body>
</html>