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
<c:set var="arr">java,web,db,framework,</c:set>
<c:forTokens items="${arr }" delims="," var="msg">
	<p>${msg }</p>
</c:forTokens>
</body>
</html>