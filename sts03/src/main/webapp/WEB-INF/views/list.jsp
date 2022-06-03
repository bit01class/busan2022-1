<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="add">입력</a>
<table>
	<thead>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>hiredate</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list }" var="bean">
		<c:url value="/detail" var="detail">
			<c:param name="empno" value="${bean.empno }"/>
		</c:url>
		<tr>
			<td><a href="${detail}">${bean.empno }</a></td>
			<td><a href="${detail}">${bean.ename }</a></td>
			<td><a href="${detail}"><fmt:formatDate value="${bean.hiredate }" pattern="MM/dd hh:mm"/></a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>