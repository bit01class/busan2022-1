<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#dddddd">
<%
String myPath="..";
%>
<%@ include file="../template/header.jspf" %>
			<h1>DEPT List</h1>
			<table width="500" align="center" border="1">
				<tr>
					<th>deptno</th>
					<th>dname</th>
					<th>loc</th>
				</tr>
				<%@ page import="com.mongodb.MongoClient,com.mongodb.client.*,org.bson.Document" %>
				<%
				// default 정보의 경우만
				//Mongo mongo=new MongoClient();
				//DB db=mongo.getDB("testDB");
				//DBCollection coll =db.getCollection("dept02");
				//DBCursor cursor=coll.find();
			MongoClient client=null;
			int p=1;
			try{
			p=Integer.parseInt(request.getParameter("p"));
			}catch(NumberFormatException e){}
			try{
				client=new MongoClient();
				MongoDatabase db=null;
				db=client.getDatabase("testDB");
				MongoCollection<Document> coll=null;
				coll=db.getCollection("dept02");	
				System.out.println("총갯수1:"+coll.count());
				System.out.println("총갯수2:"+coll.countDocuments());
				FindIterable<Document> ite=coll.find();//.skip(5*(p-1)).limit(5);
				MongoCursor<Document> cursor=ite.iterator();
				while(cursor.hasNext()){
					Document obj= cursor.next();
				%>
				<tr>
					<td><a href="detail.jsp?deptno=<%=obj.getInteger("_id", 0) %>"><%=obj.getInteger("_id", 0) %></a></td>
					<td><a href="detail.jsp?deptno=<%=obj.getInteger("_id", 0) %>"><%=obj.getString("dname") %></a></td>
					<td><a href="detail.jsp?deptno=<%=obj.getInteger("_id", 0) %>"><%=obj.getString("loc") %></a></td>
				</tr>
				<%
				}
			}finally{
				client.close();
			}
				%>
			</table>
			<p align="center"><a href="add.jsp">[입 력]</a></p>
<%@ include file="../template/footer.jspf" %>
</body>
</html>










