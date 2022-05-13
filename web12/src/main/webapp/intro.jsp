<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mygrid.css">
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
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
	background-image: url("imgs/logo.jpg");
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
	background-image: url("imgs/logo.jpg");
	background-repeat:no-repeat;
	height: 80px;
	text-indent: 250px;
}
</style>
<script type="text/javascript">

</script>
</head>
<body>
<nav>
	<h1><a href="./">비트교육센터</a></h1>
	<ul>
		<li><a href="./">HOME</a></li>
		<li><a href="intro.jsp">INTRO</a></li>
		<li><a href="emp/">LIST</a></li>
		<li><a href="login/form.jsp">LOGIN</a></li>		
	</ul>
</nav>
<div class="container">
	<div class="row">
		<div class="grid12">
		<!-- content start -->
		<img alt="" src="https://www.bitacademy.com/img/main_bn_0414_1.png">
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










