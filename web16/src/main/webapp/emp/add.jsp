<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<body>
<%if(request.getAttribute("err")!=null){ %>
<div class="alert alert-danger alert-dismissible" role="alert">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>ERROR!</strong> <%=request.getAttribute("err") %></div>
<%} %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home.html">비트교육센터</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="home.html">HOME</a></li>
        <li class="active"><a href="emp.html">EMP <span class="sr-only">(current)</span></a></li>
        <li><a href="dept.html">DEPT</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="container-fluid">
	<div class="jumbotron">
	  <h1>Hello, world!</h1>
	</div>
</div>
<div class="container">
	<div class="row">
	  <div id="content" class="col-xs-12 col-md-10">
	  <!--  -->
	    <div class="page-header">
		  <h1>입력 페이지 <small>EMP Insert</small></h1>
		</div>
		<form class="form-horizontal" method="post">
		  <div class="form-group">
		    <label for="empno" class="col-sm-2 control-label">empno</label>
		    <div class="col-sm-10">
		      <input type="text" name="empno" class="form-control" id="empno" placeholder="empno" value="<%=request.getParameter("empno")==null?"":request.getParameter("empno")%>">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="ename" class="col-sm-2 control-label">ename</label>
		    <div class="col-sm-10">
		      <input type="text" name="ename" class="form-control" id="ename" placeholder="ename"  value="<%=request.getParameter("ename")==null?"":request.getParameter("ename")%>">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="sal" class="col-sm-2 control-label">sal</label>
		    <div class="col-sm-10">
		      <input type="text" name="sal" class="form-control" id="sal" placeholder="sal"  value="<%=request.getParameter("sal")==null?"":request.getParameter("sal")%>">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <div class="btn-group btn-group-justified" role="group" aria-label="...">
		    	<div class="btn-group btn-group-lg" role="group" aria-label="...">
		      		<button type="submit" class="btn btn-primary">입력</button>
		      	</div>
		    	<div class="btn-group btn-group-lg" role="group" aria-label="...">
		      		<button type="reset" class="btn btn-default">취소</button>
		      	</div>
		    	<div class="btn-group btn-group-lg" role="group" aria-label="...">
		      		<button type="button" class="btn btn-default" onclick="history.back();">뒤로</button>
		      	</div>
		      </div>
		    </div>
		  </div>
		</form>
	  <!--  -->
	  </div>
	  <div class="col-xs-12 col-md-2 aside">
	  	<a href="https://getbootstrap.com/docs/3.4/">bootstrap</a>
	  </div>
	</div>
	<div id="footer" class="row">
	  <div class="col-xs-12 col-md-12">
	  	<address>
		  <strong>(주)비트컴퓨터</strong><br>
		  서울특별시 서초구 서초대로74길33 비트빌 3층 <br>
		  <abbr title="Phone">P:</abbr> 02-3486-3456
		</address>
		
		<address>
		  <strong>&copy; by bitacademy co.ltd. All rights reserved. </strong><br>
		  <a href="mailto:#">webmaster@bit.com</a>
		</address>
	  </div>
	</div>
</div>	
</body>
</html>