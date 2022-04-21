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
<h1>부서 정보</h1>
<a href="deptAdd.jsp">[부서등록]</a>
<table width="500" border="1">
	<tr>
		<td width="100">부서번호</td>
		<td width="200">부서명</td>
		<td width="100">지역</td>
		<td width="50">삭제1</td>
		<td width="50">삭제2</td>
	</tr>
	<%@ page import="java.sql.*" %>
	<%
	String url="jdbc:mysql://localhost:3306/scott";
	String id="user01";
	String pw="1234";
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn=DriverManager.getConnection(url,id,pw);
	stmt=conn.createStatement();
	rs=stmt.executeQuery("select deptno,dname,loc from dept");
	while(rs.next()){
	%>
	<tr>
		<td><%=rs.getString(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><a href="deptDelChk.jsp?deptno=<%=rs.getString(1) %>&dname=<%=rs.getString(2) %>">삭제</a></td>
		<td>
			<form action="deptDelChk.jsp">
				<input type="hidden" name="deptno" value="<%=rs.getString(1) %>">
				<input type="hidden" name="dname" value="<%=rs.getString(2) %>">
				<input type="submit" value="삭제">
			</form>
		</td>
	</tr>
	<%
	} 
	
	}finally{
		if(conn!=null)conn.close();
	}
	%>
</table>
</body>
</html>









