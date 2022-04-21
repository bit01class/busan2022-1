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
<h1>삭제 페이지</h1>
<p>부서명 <%=new String(request.getParameter("dname").getBytes("iso-8859-1")) %>을(를) 삭제 하시겠습니까?</p>
<form action="delete.jsp">
	<input type="hidden" name="deptno" value="<%=request.getParameter("deptno")%>">
	<input type="submit" value="삭 제">
</form>

</body>
</html>