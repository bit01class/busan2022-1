<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/mygrid.css">
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<style type="text/css">
body{
	margin: 0px;
}
nav{
	overflow: hidden;
	border-bottom: 1px solid gray;
	margin-bottom: 5px;
}
nav>h1{
	float: left;
	margin-left: 10px;
}
nav>h1>a{
	display: inline-block;
	width: 205px;
	height: 40px;
	background-image: url("/web12/imgs/logo.jpg");
	text-indent: -9999px;
}
nav>ul{
	list-style: none;
	padding: 0px;
	margin-left:100px;
	float: left;
}
nav>ul>li{
	float: left;
	width: 100px;
	border-right: 5px solid gray;
}
nav>ul>li>a{
	display: block;
	height: 40px;
	color: gray;
	text-decoration: none;
	font-size: 20pt;
	text-align: center;
}
.row img{
	width: 100%;
}
#footer{
	margin-top: 100px;
	background-image: url("/web12/imgs/logo.jpg");
	background-repeat:no-repeat;
	height: 80px;
	text-indent: 250px;
}
.table{
	width: 80%;
	margin: 2px auto;
}
.table>div{
	margin: 2px auto;
	border: 1px solid darkgray;
	border-radius: 5px;
	height: 50px;
}
.table>div>a{
	display: block;
	height: 50px;
	color: gray;
	text-decoration: none;
}
.table>div>a>span{
	display: block;
	float: left;
	width: 100px;
	line-height: 50px;
}

.table>div>a>span:nth-child(2){
	width: 80%;
	font-size: 20pt;
}
.table>div>a>span:first-child{
	text-align: center;
}
.table>div>a>span:last-child{
	width: 50px;
	float: right;
}
.btn{
	width: 100%;
	height: 50px;
	border: 1px solid gray;
	border-radius: 5px;
	text-align: center;
	line-height: 50px;
	text-decoration: none;
	color: gray;
	display: block;
	margin: 20px;
}
 .btn-primary{
 	color:white;
 	background-color: blue;
 }
 .form-control{
 	margin: 0px auto;
 	width: 80%;
 }
 .form-group{
 	margin-bottom: 50px;
 }
 .form-group>*{
 	display: block;
 	height: 50px;
 	width: 100%;
 }
</style>
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
	//int empno=Integer.parseInt(request.getParameter("empno").trim());
	//String ename=request.getParameter("ename").trim();
	//int sal=Integer.parseInt(request.getParameter("sal").trim());
	//EmpDto bean=new EmpDto();
	//bean.setEmpno(1111);
	//bean.setEname(ename);
	//bean.setSal(sal);
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










