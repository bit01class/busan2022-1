<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>내장객체</h1>
<%
// 내장객체(참조변수)의 지원은 스크립트릿
String addr=request.getRemoteAddr();
String host=request.getRemoteHost();
int port=request.getRemotePort();
String url=request.getRequestURI();
StringBuffer url2=request.getRequestURL();
out.println(addr);
out.println("<br>");
out.println(host);
out.println("<br>");
out.println(port);
out.println("<br>");
out.println(url);
out.println("<br>");
out.println(url2);
out.println("<br>");
%>
</body>
</html>