<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.mongodb.MongoClient" %>
<%@ page import="com.mongodb.client.*" %>
<%@ page import="org.bson.conversions.Bson" %>
<%@ page import="org.bson.Document" %>
<%@ page import="com.mongodb.client.model.Filters" %>
<%
if(request.getMethod().equals("POST")){
	int deptno=Integer.parseInt(request.getParameter("deptno"));
	MongoClient client=null;
	//Bson filter=new Document("_id",deptno);
	Bson filter=Filters.eq("_id", deptno);
	try{
		client=new MongoClient();
		client.getDatabase("testDB").getCollection("dept02").deleteOne(filter);
	}finally{
		client.close();
	}
}
response.sendRedirect("list.jsp");
%>
</body>
</html>
















