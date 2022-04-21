<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.mongodb.MongoClient,com.mongodb.client.*,org.bson.*" %>
<%
if(request.getMethod().equals("GET")){
	response.sendRedirect("add.jsp");
	return;
}
request.setCharacterEncoding("utf-8");
String param1=request.getParameter("deptno");
String param2=request.getParameter("dname");
String param3=request.getParameter("loc");

int deptno=Integer.parseInt(param1.trim());
String dname=param2.trim();
String loc=param3.trim();
////
//Mongo client=null;
//try{
//	client=new MongoClient();
//	DBCollection coll=client.getDB("testDB").getCollection("dept02");
//	BasicDBObject doc=new BasicDBObject("_id",deptno);
//	doc.append("dname", dname);
//	doc.append("loc");
//	coll.insert(doc);
//}finally{
//	client.close();
//}

////
MongoClient client=null;
try{
	client=new MongoClient();
	MongoDatabase db=client.getDatabase("testDB");
	MongoCollection<Document> coll=db.getCollection("dept02");
	
	Document doc=new Document();
	doc.put("_id", deptno);
	doc.put("dname",dname);
	doc.put("loc",loc);
	coll.insertOne(doc);
	//Document doc2=new Document();
	//doc2.put("_id", deptno+1);
	//doc2.put("dname","re:"+dname);
	//doc2.put("loc","re:"+loc);
	//java.util.List<Document> documents =new java.util.ArrayList<Document>();
	//documents.add(doc);
	//documents.add(doc2);
	//coll.insertMany(documents);
}finally{
	client.close();
}
response.sendRedirect("list.jsp");
%>
</body>
</html>
















