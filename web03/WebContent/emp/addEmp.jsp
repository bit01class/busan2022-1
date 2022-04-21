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
			<h1>사원추가</h1>
			<form action="insertEmp.jsp">
				<table>
					<tr>
						<td>empno</td>
						<td><input type="text" name="empno"></td>
					</tr>
					
					<tr>
						<td>ename</td>
						<td><input type="text" name="ename"></td>
					</tr>
					
					<tr>
						<td>job</td>
						<td>
							<select name="job">
								<option>CLERK</option>
								<option>SALESMAN</option>
								<option>MANAGER</option>
								<option>ANALYST</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>mgr</td>
						<td>
							<select name="mgr">
							<%@ page import="java.sql.*" %>
							<%
							String sql="select empno,ename from emp order by deptno";
							String url="jdbc:mysql://localhost:3306/scott";
							String driver="com.mysql.cj.jdbc.Driver";
							Connection conn=null;
							Statement stmt=null;
							ResultSet rs=null;
							try{
								Class.forName(driver);
								conn=DriverManager.getConnection(url
										,System.getenv().get("MYSQL_USER"),System.getenv().get("MYSQL_PASSWORD"));
								stmt=conn.createStatement();
								rs=stmt.executeQuery(sql);
								while(rs.next()){
							%>
								<option value="<%=rs.getInt(1)%>"><%=rs.getString(2) %></option>
							<%
								}
							}finally{
								if(rs!=null)rs.close();
								if(stmt!=null)stmt.close();
								if(conn!=null)conn.close();
							}
							%>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>dname</td>
						<td>
							<select name="deptno">
							<%
							sql="select deptno, dname from dept order by deptno";
							try{
								conn=DriverManager.getConnection(url,"user01","1234");
								stmt=conn.createStatement();
								rs=stmt.executeQuery(sql);
								while(rs.next()){
									out.println("<option value=\""+rs.getInt(1)+"\">"+rs.getString(2)+"</option>");
								}
							}finally{
								if(rs!=null)rs.close();
								if(stmt!=null)stmt.close();
								if(conn!=null)conn.close();
							}
							%>		
							</select>
						</td>
					</tr>
					
					<tr>
						<td colspan="2">
							<input type="submit" value="사원등록">
						</td>
					</tr>
				</table>
			</form>
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













