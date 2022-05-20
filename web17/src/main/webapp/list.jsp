<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/head.jspf" %>
</head>
<body>
<%@ include file="template/menu.jspf" %>
<div class="jumbotron">
  <h1>EMP!</h1>
  <p><a class="btn btn-primary btn-lg" href="./add.html" role="button">입력</a></p>
</div>
<div class="page-header">
  <h1>리스트페이지 <small>EMP List</small></h1>
</div>
<div class="list-group">
  <span href="#" class="list-group-item active">
    <h4 class="list-group-item-heading">List group item heading</h4>
    <p class="list-group-item-text">...</p>
  </span>
  <%
  for(java.util.Map<String,Object> bean:(java.util.List<java.util.Map<String,Object>>)request.getAttribute("list")){
  %>
  <a href="detail.html?idx=<%=bean.get("_id") %>" class="list-group-item">
    <h4 class="list-group-item-heading"><%=bean.get("ename") %></h4>
    <p class="list-group-item-text"><%=bean.get("empno") %></p>
  </a>
  <%} %>
</div>
<%@ include file="template/footer.jspf" %>
</body>
</html>