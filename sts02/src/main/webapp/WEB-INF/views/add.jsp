<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/header.jspf" %>
</head>
<body>
<%@ include file="template/menu.jspf" %>
<ol class="breadcrumb">
  <li><a href="${pageContext.request.contextPath }/index.bit">Home</a></li>
  <li><a href="${pageContext.request.contextPath }/emp/list.bit">EMP</a></li>
  <li class="active">Add</li>
</ol>
<h3 class="page-header">EMP Insert</h3>
<form class="form-horizontal" action="insert.bit" method="post">
  <div class="form-group">
    <label for="empno" class="col-sm-2 control-label">empno</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="empno" id="empno" placeholder="empno">
    </div>
  </div>
  <div class="form-group">
    <label for="ename" class="col-sm-2 control-label">ename</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="ename" id="ename" placeholder="ename" value="test">
    </div>
  </div>
  <div class="form-group">
    <label for="sal" class="col-sm-2 control-label">sal</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="sal" id="sal" placeholder="sal" value="1000">
    </div>
  </div>
  <div class="form-group">
    <label for="job" class="col-sm-2 control-label">job</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="job" id="job" placeholder="job" value="tester">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">입력</button>
      <button type="reset" class="btn btn-default">취소</button>
      <button type="button" class="btn btn-default" onclick="history.back();">뒤로</button>
    </div>
  </div>
</form>
<%@include file="template/footer.jspf" %>
</body>
</html>