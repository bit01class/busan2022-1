<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bean" class="com.bit.util.EmpDto"></jsp:useBean>
<jsp:setProperty property="empno" name="bean"/>
<%@ page import="java.sql.*,com.bit.util.DBServer" %>
<%!
Connection conn;
Statement stmt;
%>
<%
if("POST".equals(request.getMethod())){
	String sql="delete from emp where empno="+bean.getEmpno();
	try{
		conn=DBServer.getConnection();
		stmt=conn.createStatement();
		stmt.executeUpdate(sql);
	}finally{
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
}
response.sendRedirect("./");
%>
</body>
</html>









