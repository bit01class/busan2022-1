<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int empno=Integer.parseInt(request.getParameter("empno"));
	String sql="delete from emp where empno="+empno;
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/scott";
	String user="user01";
	String password="1234";
	
	Class.forName(driver);
	Connection conn=null;
	Statement stmt=null;
	try{
		if(request.getMethod().equals("POST")){
			conn=DriverManager.getConnection(url,user,password);
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
		}
	}finally{
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
	%>
</body>
</html>