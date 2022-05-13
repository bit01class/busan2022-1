<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path=request.getParameter("root");
path=path!=null?path:".";
%>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/mygrid.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/bit.css">
<script type="text/javascript" src="<%=path %>/js/jquery-1.12.4.min.js"></script>