<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<c:forEach items="${list }" var="bean">
<div class="card">
  <div class="card-header">
    ${bean.empno }
  </div>
  <div class="card-body">
    <h5 class="card-title">${bean.ename }</h5>
    <p class="card-text">${bean.hiredate }</p>
    <a href="${bean.empno }" class="btn btn-primary">Go Detail</a>
  </div>
</div>
</c:forEach>

</body>
</html>