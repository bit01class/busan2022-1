<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="template/head.jsp"></jsp:include>
<script type="text/javascript">

</script>
</head>
<body>
<nav>
	<h1><a href="./">비트교육센터</a></h1>
	<jsp:useBean id="login" class="com.bit.util.EmpDto" scope="session"></jsp:useBean>
	<ul>
		<li><a href="./">HOME</a></li>
		<li><a href="intro.jsp">INTRO</a></li>
		<li><a href="emp/">LIST</a></li>
	<%if(login.isResult()){ %>
		<li><a href="login/logout.jsp">LOGOUT</a></li>
	<%}else{ %>
		<li><a href="login/form.jsp">LOGIN</a></li>	
	<%} %>	
	</ul>
	<%if(login.isResult()){ %>
	<span><jsp:getProperty property="ename" name="login"/>님 로그인 중..</span>
	<%} %>
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










