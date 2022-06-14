<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link type="text/css" rel="stylesheet" href="resources/css/home.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
<c:forEach items="${list }" var="bean">
<P>${bean }</P>
</c:forEach>
</body>
</html>
