<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String myPath=".."; %>
<%@ include file="../template/header.jspf" %>
<h1>DEPT ADD Page</h1>
<form action="insert.jsp" method="post">
	<table align="center">
		<tr>
			<td width="100" bgcolor="#cccccc" align="center">deptno</td>
			<td><input type="text" name="deptno"></td>
		</tr>
		<tr>
			<td bgcolor="#cccccc" align="center">dname</td>
			<td><input type="text" name="dname"></td>
		</tr>
		<tr>
			<td bgcolor="#cccccc" align="center">loc</td>
			<td><input type="text" name="loc"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="입 력">
				<input type="reset" value="취 소">
			</td>
		</tr>
	</table>
</form>
<%@ include file="../template/footer.jspf" %>
</body>
</html>