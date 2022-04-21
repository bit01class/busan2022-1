<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*" %>
<%
Map<String,String>  info= System.getenv();
Set<Map.Entry<String,String>> set=info.entrySet();
Iterator<Map.Entry<String,String>> ite=set.iterator();
while(ite.hasNext()){
	Map.Entry<String,String> entry=ite.next();
	System.out.println(entry.getKey()+" -> "+entry.getValue());
}
	System.out.println(info.get("MYSQL_USER"));
%>
<p>
	<a href="index.jsp">[HOME]</a>
	<a href="dept.jsp">[DEPT]</a>
	<a href="emp.jsp">][E M P]</a>
</p>
<h1>사원관리 프로그램(ver 0.1.0)</h1>
<p>사원 등록과 부서배정을 할 수 있는 프로그램입니다</p>
</body>
</html>