<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/mygrid.css">
<link rel="stylesheet" type="text/css" href="../css/bit.css">
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">

</script>
</head>
<%@ page import="java.sql.*,com.bit.util.*" %>
<%!
Connection conn;
Statement stmt;
public void insertOne(int empno,String ename,int sal) throws SQLException{
	String sql="insert into emp (empno,ename,sal,hiredate) values ("+empno+",'"+ename+"',"+sal+",now())";
	try{
		conn=DBServer.getConnection();
		stmt=conn.createStatement();
		stmt.executeUpdate(sql);
	}finally{
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
}

public void insertOne(EmpDto bean) throws SQLException{
	String sql="insert into emp (empno,ename,sal,hiredate) values ("+bean.getEmpno()
				+",'"+bean.getEname()+"',"+bean.getSal()+",now())";
	try{
		conn=DBServer.getConnection();
		stmt=conn.createStatement();
		stmt.executeUpdate(sql);
	}finally{
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
}
%>
<jsp:useBean id="bean" class="com.bit.util.EmpDto"></jsp:useBean>
<jsp:setProperty property="empno" name="bean"/>
<jsp:setProperty property="ename" name="bean"/>
<jsp:setProperty property="sal" name="bean"/>
<%

request.setCharacterEncoding("utf-8");// servlet filter..에서 극복

if(request.getMethod().equals("POST")){
	insertOne(bean);
	response.sendRedirect("./");
}
%>
<body>
<nav>
	<h1><a href="./">비트교육센터</a></h1>
	<ul>
		<li><a href="../">HOME</a></li>
		<li><a href="../intro.jsp">INTRO</a></li>
		<li><a href="./">LIST</a></li>
		<li><a href="../login/form.jsp">LOGIN</a></li>		
	</ul>
</nav>
<div class="container">
	<div class="row">
		<div class="grid12">
		<!-- content start -->
		<h2>입력 페이지</h2>
		<form class="form-control" method="post">
			<div class="form-group">
				<label for="empno">empno</label>
				<input type="number" name="empno" id="empno" value='<jsp:getProperty property="empno" name="bean"/>' placeholder="사번을 입력"/>
			</div>
			<div class="form-group">
				<label for="ename">ename</label>
				<input type="text" name="ename" id="ename" value='<jsp:getProperty property="ename" name="bean"/>' placeholder="이름을 입력"/>
			</div>
			<div class="form-group">
				<label for="sal">sal</label>
				<input type="number" name="sal" id="sal" value='<jsp:getProperty property="sal" name="bean"/>' placeholder="금액을 입력"/>
			</div>
			<div class="form-group">
				<button class="btn btn-primary">입력</button>
				<button class="btn" type="reset">취소</button>
				<button class="btn" type="button">뒤로</button>
			</div>
		</form>
		<!-- content end -->
		</div>
	</div>
	<div class="row">
		<div id="footer" class="grid12">
		&copy; by bitacademy co.ltd. All rights reserved
		</div>
	</div>
</div>

</body>
</html>










