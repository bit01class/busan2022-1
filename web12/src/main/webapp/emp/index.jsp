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
}
 .btn-primary{
 	color:white;
 	background-color: blue;
 }
</style>
<script type="text/javascript">

</script>
</head>
<%@page import="java.sql.*,com.bit.util.*,java.util.*" %>
<%!
Connection conn;
Statement stmt;
ResultSet rs;

public List<EmpDto> getList() throws SQLException{
	String sql="select * from emp order by empno";
	List<EmpDto> list=new ArrayList<EmpDto>();
	
	try{
		conn=DBServer.getConnection();
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		while(rs.next()){
			EmpDto bean1=new EmpDto();
			bean1.setEmpno(rs.getInt("empno"));
			bean1.setEname(rs.getString("ename"));
			bean1.setSal(rs.getInt("sal"));
			list.add(bean1);
		}
	}finally{
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
	
	return list;
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
		<h2>리스트 페이지</h2>
		<div class="table">
		<%for(EmpDto bean : getList()){ %>
			<div>
				<a href="#">
					<span><%=bean.getEmpno() %></span>
					<%-- 
					<span><%=bean.getEname().length()>3?bean.getEname().substring(0,3)+"..": bean.getEname()%></span>
					 --%>
					<%if(bean.getEname().length()>10){ %>
					<span><%=bean.getEname().substring(0,10)+".."%></span>
					<%}else{ %>
					<span><%=bean.getEname()%></span>
					<%} %>
					<span><%=bean.getSal() %></span>
				</a>
			</div>
		<%} %>	
		</div>
		<p><a class="btn btn-primary" href="add.jsp">입력</a></p>
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










