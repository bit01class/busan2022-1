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
<c:if test="${err ne null }">
<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong>${err.localizedMessage }</strong>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
</c:if>
<nav class="navbar" style="background-color: #cccccc;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
  </div>
  <p class="navbar-text">
  	<a href="../">HOME</a>
  	<a href="./">EMP</a>
  	<a href="./add">EMP_Add</a>
  	<a href="../login/">LOGIN</a>
  </p>
</nav>
<div class="container">
<form action="./" method="post">
  <div class="mb-3">
    <label for="empno" class="form-label">empno</label>
    <input type="text" class="form-control" id="empno" name="empno" value="${bean.empno }">
  </div>
  <div class="mb-3">
    <label for="ename" class="form-label">ename</label>
    <input type="text" class="form-control" id="ename" name="ename" value="${bean.ename }">
  </div>
  <div class="mb-3">
    <label for="sal" class="form-label">sal</label>
    <input type="text" class="form-control" id="sal" name="sal" value="${bean.sal }">
  </div>
  <div class="mb-3">
    <label for="job" class="form-label">job</label>
    <input type="text" class="form-control" id="job" name="job" value="${bean.job }">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  <button type="reset" class="btn btn-default">Reset</button>
  <button type="button" class="btn btn-default" onclick="history.back();">Back</button>
</form>
</div>
</body>
</html>

















