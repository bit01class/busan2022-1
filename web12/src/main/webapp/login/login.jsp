<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="login" class="com.bit.util.EmpDto" scope="session"></jsp:useBean>
<%@ page import="java.sql.*,com.bit.util.DBServer" %>
<%!
Connection conn;
Statement stmt;
ResultSet rs;
%>
<%
request.setCharacterEncoding("utf-8");
login.setEmpno(Integer.parseInt(request.getParameter("empno").trim()));
login.setEname(request.getParameter("ename").trim());

try{
	String sql="select count(*) from emp where empno="
			+login.getEmpno()+" and ename='"+login.getEname()+"'";
	conn=DBServer.getConnection();
	stmt=conn.createStatement();
	rs=stmt.executeQuery(sql);
	if(rs.next())
		login.setResult(rs.getInt(1)>0?true:false);
}finally{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
response.sendRedirect("../");
%>
</body>
</html>












