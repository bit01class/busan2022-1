{"root":[
<%
int empno=Integer.parseInt(request.getParameter("empno"));
String sql="select ename,sal from emp where empno="+empno;
String driver="com.mysql.cj.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/scott";
String user="user01";
String password="1234";
Class.forName(driver);
Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
try{
	conn=DriverManager.getConnection(url,user,password);
	stmt=conn.createStatement();
	rs=stmt.executeQuery(sql);
	if(rs.next()){
%>
{"empno":<%=empno %>,"ename":"<%=rs.getString("ename") %>","sal":<%=rs.getInt("sal") %>}
<%
	}
}finally{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
]}