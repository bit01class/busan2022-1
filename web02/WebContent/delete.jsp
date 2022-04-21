<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="1;url=dept.jsp"> 
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%
String deptno=request.getParameter("deptno");
String sql="delete from dept where deptno="+deptno;
String driver="com.mysql.cj.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/scott";
String user="user01";
String password="1234";

System.setProperty("mysql.user", user);
System.setProperty("mysql.password",password);

Connection conn=null;
Statement stmt=null;
try{
	Class.forName(driver);
	conn=DriverManager.getConnection(url,System.getProperty("mysql.user"),System.getProperty("mysql.password"));
	stmt=conn.createStatement();
	stmt.executeUpdate(sql);
}catch(Exception e){
	e.printStackTrace();
}finally{
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
%>
</body>
</html>