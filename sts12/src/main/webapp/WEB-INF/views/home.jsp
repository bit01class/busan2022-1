<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<c:forEach items="${list }" var="bean">
<P><a href="${bean.empno }">${bean}</a></P>
</c:forEach>
</body>
</html>
