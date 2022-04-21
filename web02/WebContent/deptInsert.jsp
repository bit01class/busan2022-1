<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="5;url=dept.jsp">
<title>Insert title here</title>
</head>
<body>
<p>
	<a href="index.jsp">[HOME]</a>
	<a href="dept.jsp">[DEPT]</a>
	<a href="emp.jsp">][E M P]</a>
</p>
<%
// get방식 한글처리
// server.xml 수정
//  <Connector URIEncoding="UTF-8" connectionTimeout="20000" port="8080" 
String deptno=request.getParameter("deptno");
String dname=request.getParameter("dname");
dname=new String(dname.getBytes("iso-8859-1"));
String param3=request.getParameter("loc");
String loc=null;
if(param3.equals("1")) loc="서울";
if(param3.equals("2")) loc="대전";
if(param3.equals("3")) loc="대구";
if(param3.equals("4")) loc="부산";
if(param3.equals("5")) loc="광주";

String sql="insert into dept values ("+deptno+",'"+dname+"','"+loc+"')";
System.out.println(sql);
String driver="com.mysql.cj.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/scott";
String user="user01";
String password="1234";

Connection conn=null;
Statement stmt=null;
int result=0;
try{
	Class.forName(driver);
	conn=DriverManager.getConnection(url,user,password);
	stmt=conn.createStatement();
	result=stmt.executeUpdate(sql);
}catch(Exception e){
	e.printStackTrace();
}finally{
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
if(result>0){
%>
<h1>등록 성공</h1>
<%}else{ %>
<h1>등록 실패</h1>
<%} %>
<%@ page import="java.sql.*" %>
</body>
</html>











