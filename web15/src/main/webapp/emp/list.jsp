<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<style type="text/css">
	.navbar-header{
		overflow: hidden;
	}
</style>
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
</head> 
<body>
<div class="container">
	<div id="menu" class="row">
	  <div class="col-md-12">
	  	<nav class="navbar navbar-default ">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="../">
		        <img alt="Brand" src="../imgs/logo.jpg" />
		      </a>
		    </div>
		    <p class="navbar-text">
		    	<a href="../emp/list.html" class="btn btn-default">EMP</a>
		    	<a href="../dept/list.html" class="btn btn-default">DEPT</a>
		    </p>
		    <p class="navbar-text navbar-right">
		    	<a href="../login/index.html">LOGIN</a>
		    </p>
		  </div>
		</nav>
	  </div>
	</div>
	<div id="content" class="row">
	  <div class="col-md-12">
	  	<div class="page-header">
		  <h2>EMP LIST Page <small>EMP table의 리스트</small></h2>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>empno</th>
					<th>ename</th>
					<th>hiredate</th>
					<th>sal</th>
				</tr>
			</thead>
			<tbody>
			<%
			java.util.List<com.bit.model.EmpDto> list=null;
			list=(java.util.List<com.bit.model.EmpDto>)request.getAttribute("list");
			for(com.bit.model.EmpDto bean:list){
			%>
				<tr>
					<td><a href="#"><%=bean.getEmpno() %></a></td>
					<td><a href="#"><%=bean.getEname() %></a></td>
					<td><a href="#"><%=bean.getHiredate() %></a></td>
					<td><a href="#"><%=bean.getSal() %></a></td>
				</tr>
			<%} %>
			</tbody>
		</table>
	  </div>
	</div>
	<div id="footer" class="row">
	  <div class="col-md-12">
	  	<address>
		  <strong>&copy; by bitacademy co.ltd. All rights reserved.</strong><br>
		  서울특별시 서초구 서초대로74길33 비트빌 3층<br>
		  <abbr title="Phone">P:</abbr> 02-3486-3456
		</address>
	  </div>
	</div>
</div>
</body>
</html>