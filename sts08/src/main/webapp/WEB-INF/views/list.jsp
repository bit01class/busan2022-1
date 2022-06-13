<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../webjars/bootstrap/5.1.3/css/bootstrap.min.css">
<script type="text/javascript" src="../webjars/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="../webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar" style="background-color: #cccccc;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
  </div>
  <p class="navbar-text">
  	<a href="../">HOME</a>
  	<a href="./">EMP</a>
  	<a href="./add">EMP_Add</a>
  	<c:if test="${sessionScope.result eq true }">
  	<a href="../logout/">LOGOUT</a>
  	</c:if>
  	<c:if test="${sessionScope.result eq null }">
  	<a href="../login/">LOGIN</a>
  	</c:if>
  </p>
  <c:if test="${sessionScope.result }">
  <p class="navbar-text">${sessionScope.user }님 로그인 중...</p>
  </c:if>
</nav>
<div class="container">
	<c:forEach items="${list }" var="bean">
	<div class="card card bg-primary mb-3">
	  <div class="card-header">
	    <p class="card-text">${bean.empno }</p>
	  </div>
	  <div class="card-body">
	    <h5 class="card-title">${bean.ename }</h5>
	    <p class="card-text">${bean.hiredate }</p>
	    <a href="${bean.empno }" class="btn btn-primary">Go Detail</a>
	  </div>
	</div>
	</c:forEach>
</div>
</body>
</html>