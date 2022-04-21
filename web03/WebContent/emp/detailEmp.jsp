<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" width="800">
	<tr>
		<td colspan="6">
			<img alt="logo" src="../imgs/logo.jpg">
		</td>
	</tr>
	<tr>
		<td bgcolor="gray"></td>
		<td bgcolor="gray" width="100" align="center"><a href="../index.jsp"><font color="white">[홈으로]</font></a></td>
		<td bgcolor="gray" width="100" align="center"><a href="../intro.jsp"><font color="white">[인트로]</font></a></td>
		<td bgcolor="gray" width="100" align="center"><a href="./list.jsp"><font color="white">[사원정보]</font></a></td>
		<td bgcolor="gray" width="100" align="center"><a href="#"><font color="white">[로그인]</font></a></td>
		<td bgcolor="gray"></td>
	</tr>
	<tr>
		<td colspan="6">
			<h1>사원 정보</h1>
			<table width="600" border="1" align="center" cellspacing="0">
<%@ page import="java.sql.*" %>
<%
int empno=Integer.parseInt(request.getParameter("empno"));
String sql="select empno,ename,job,(select ename from emp C where A.mgr=C.empno),dname,loc,sal,comm from emp A inner join dept B using (deptno) where empno="+empno;
String driver="com.mysql.cj.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/scott";
String user="user01";
String password="1234";

Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
try{
	Class.forName(driver);
	conn=DriverManager.getConnection(url,user,password);
	stmt=conn.createStatement();
	rs=stmt.executeQuery(sql);
	if(rs.next()){
%>
				<tr>
					<td>empno</td>
					<td><%=rs.getInt(1) %></td>
					<td>ename</td>
					<td><%=rs.getString(2) %></td>
				</tr>
				<tr>
					<td>job</td>
					<td><%=rs.getString(3) %></td>
					<td>mgr</td>
					<td><%
					String msg=rs.getString(4);
					if(msg==null)out.print("-");
					else out.print(msg);
					%></td>
				</tr>
				<tr>
					<td>dname</td>
					<td><%=rs.getString(5) %></td>
					<td>location</td>
					<td><%=rs.getString(6) %></td>
				</tr>
				<tr>
					<td>sal</td>
					<td><%=rs.getString(7) %></td>
					<td>comm</td>
					<td><%=rs.getInt(8) %></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
<%
	}
}finally{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
%>
			</table>
		</td>
	</tr>
	<tr>
		<td></td>
		<td colspan="4">Copyright by bitacademy co.ltd. All rights reserved.</td>
		<td></td>
	</tr>
</table>
</body>
</html>