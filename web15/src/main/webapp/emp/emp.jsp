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
$(function(){
	$('button[type="button"]').click(function(){
		history.back();
	});
});
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
		  <h2>EMP Detail Page <small>상세보기</small></h2>
		</div>
		<%
		com.bit.model.EmpDto bean=(com.bit.model.EmpDto)request.getAttribute("emp");
		%>
		<form method="post">
		  <div class="form-group">
		    <label for="empno">empno</label>
		    <input type="text" name="empno" value="<%=bean.getEmpno() %>" class="form-control" id="empno" placeholder="empno" readonly/>
		  </div>
		  <div class="form-group">
		    <label for="ename">ename</label>
		    <input type="text" name="ename" value="<%=bean.getEname() %>" class="form-control" id="ename" placeholder="ename" readonly/>
		  </div>
		  <div class="form-group">
		    <label for="sal">sal</label>
		    <input type="text" name="sal" value="<%=bean.getSal() %>" class="form-control" id="sal" placeholder="sal" readonly/>
		  </div>
		  <div class="form-group">
		    <label for="hiredate">hiredate</label>
		    <input type="text" name="hiredate" value="<%=bean.getHiredate() %>" class="form-control" id="hiredate" placeholder="hiredate" readonly/>
		  </div>
		  <div class="form-group">
		    <label for="job">job</label>
		    <input type="text" name="job" value="<%=bean.getJob() %>" class="form-control" id="job" placeholder="job" readonly/>
		  </div>
		  <a href="edit.html?idx=" role="button" class="btn btn-primary btn-block">수정</a>
		  <a href="delete.html?idx=" role="button" class="btn btn-danger btn-block">삭제</a>
		  <button type="button" class="btn btn-default btn-block">뒤로</button>
		</form>
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