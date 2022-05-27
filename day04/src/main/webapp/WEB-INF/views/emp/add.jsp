<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav>
	<a href="${pageContext.servletContext.contextPath }/index.bit">HOME</a>
	<a href="${pageContext.servletContext.contextPath }/list.bit">EMP</a>
	<a href="${pageContext.servletContext.contextPath }/login.bit">LOGIN</a>
</nav>
<h1>insert page</h1>
<form method="post">
	<div>
		empno<input name="empno"/>
	</div>
	<div>
		ename<input name="ename"/>
	</div>
	<div>
		sal<input name="sal"/>
	</div>
	<div>
		job<input name="job"/>
	</div>
	<div>
		<input type="submit" value="입력"/>
	</div>
</form>
</body>
</html>