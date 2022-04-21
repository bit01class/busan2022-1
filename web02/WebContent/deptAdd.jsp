<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
	<a href="index.jsp">[HOME]</a>
	<a href="dept.jsp">[DEPT]</a>
	<a href="emp.jsp">][E M P]</a>
</p>
<h1>부서 등록 페이지</h1>
<form action="deptInsert.jsp">
	<p>부서번호:<input type="text" name="deptno"></p>
	<p>부서명:<input type="text" name="dname"></p>
	<p>지역명:<select name="loc">
		<option value="1">서울</option>
		<option value="2">대전</option>
		<option value="3">대구</option>
		<option value="4">부산</option>
		<option value="5">광주</option>
	</select></p>
	<p><input type="submit"></p>	
</form>
</body>
</html>