<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String param1=request.getParameter("deptno");
String param2=request.getParameter("dname");
String param3=request.getParameter("loc");

int deptno=Integer.parseInt(param1);
String dname=param2.trim();
String loc=param3.trim();

//////////////////////////////////////

if(request.getMethod().equals("GET")){
	response.sendRedirect("edit.jsp?deptno="+param1);
	return;
}
MongoClient client=null;
try{
	client=new MongoClient();
	client.getDatabase("testDB")
		.getCollection("dept02")
			.updateOne(
					Filters.eq("_id",deptno)
					,new Document("$set",new Document("dname",dname).append("loc", loc)));
//mongodb - updateOne API
//https://www.mongodb.com/docs/drivers/java/sync/current/usage-examples/updateOne/
					//new Document().append("_id",deptno)
					//,Updates.combine(
		            //        Updates.set("dname", dname),
		            //        Updates.set("loc", loc)
		            //        )
					//,new UpdateOptions().upsert(true)
					//);
}finally{
	client.close();
}

response.sendRedirect("list.jsp");
%>
<%@ page import="com.mongodb.MongoClient" %>
<%@ page import="com.mongodb.client.*" %>
<%@ page import="com.mongodb.client.model.Filters" %>
<%@ page import="com.mongodb.client.model.Updates" %>
<%@ page import="com.mongodb.client.model.UpdateOptions" %>
<%@ page import="org.bson.*" %>
<%@ page import="org.bson.conversions.*" %>
</body>
</html>










