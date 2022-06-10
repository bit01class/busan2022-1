<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/header.jspf" %>
</head>
<body>
<%@ include file="template/menu.jspf" %>
<div class="page-header">
  <h1>DEPT Detail Page <small>Detail Data</small></h1>
</div>
<form action="./${bean.deptno }" method="post">
	<input type="hidden" name="_method" value="delete">
  <div class="form-group">
    <label for="deptno">deptno</label>
    <input type="text" class="form-control" id="deptno" value="${bean.deptno }" name="deptno">
  </div>
  <div class="form-group">
    <label for="dname">dname</label>
    <input type="text" class="form-control" id="dname" value="${bean.dname }">
  </div>
  <div class="form-group">
    <label for="loc">loc</label>
    <input type="text" class="form-control" id="loc" value="${bean.loc }">
  </div>
  <a href="./${bean.deptno }/edit" class="btn btn-primary" role="button">수정</a>
  <button type="submit" class="btn btn-danger">삭제</a>
  <button type="button" class="btn btn-default" onclick="history.back();">Back</button>
</form>
</body>
</html>









