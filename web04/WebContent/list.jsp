<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mongodb.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="800" align="center" cellspacing="0">
	<tr>
		<td colspan="5"><img src="imgs/logo.jpg"></td>
	</tr>
	<tr>
		<td bgcolor="gray"></td>
		<td bgcolor="gray" width="100" align="center"><a href="index.jsp">[HOME]</a></td>
		<td bgcolor="gray" width="100" align="center"><a href="list.jsp">[DEPT]</a></td>
		<td bgcolor="gray" width="100" align="center"><a href="list2.jsp">[DEPT2]</a></td>
		<td bgcolor="gray"></td>
	</tr>
	<tr>
		<td colspan="5">
			<!-- content start -->
			<h1>List Page</h1>
			<table border="1" width="80%" align="center">
				<tr>
					<td width="100" bgcolor="gray"><a href="list.jsp?by=_id">deptno</a></td>
					<td width="50%" bgcolor="gray"><a href="list.jsp?by=dname">dname</a></td>
					<td bgcolor="gray"><a href="list.jsp?by=loc">loc</a></td>
				</tr>
<%
	String ip="127.0.0.1";
	int port=27017;

	MongoClient client=new MongoClient(new ServerAddress(ip,port));
	//java.util.List<String> names = client.getDatabaseNames();
	//for(int i=0; i<names.size(); i++){
	//	System.out.println(names.get(i));
	//}
	DB db=client.getDB("testDB");
	//java.util.Set<String> colls=db.getCollectionNames();
	//java.util.Iterator<String> ite= colls.iterator();
	//while(ite.hasNext()){
	//	System.out.println(ite.next());
	//}
	DBCollection coll=db.getCollection("dept02");
	String keyword=request.getParameter("keyword");
	if(keyword==null) keyword="";
	String by=request.getParameter("by");
	if(by==null) by="_id";
	BasicDBObject orderBy=new BasicDBObject(by,1);
	
	BasicDBObject doc=new BasicDBObject("dname",new BasicDBObject("$regex",keyword));
	
	DBCursor cursor=coll.find(doc).sort(orderBy);
	while(cursor.hasNext()){
		DBObject obj=cursor.next();
			out.println("<tr>");
			out.print("<td><a href=\"dept.jsp?deptno="+obj.get("_id")
									+"\">"+obj.get("_id")+"</a></td>");
			out.print("<td><a href=\"dept.jsp?deptno="+obj.get("_id")
									+"\">"+obj.get("dname")+"</a></td>");
			out.println("<td><a href=\"dept.jsp?deptno="+obj.get("_id")
									+"\">"+obj.get("loc")+"</a></td>");
			out.println("</tr>");
	}
	client.close();	
%>
			</table>
			<p>
				<form>
					<input type="text" name="keyword">
					<input type="submit" value="검색">
				</form>
			</p>
			<p align="center">
				<a href="add.jsp">[입 력]</a>
			</p>
<!-- content end -->
		</td>
	</tr>
	<tr>
		<td colspan="5" align="center" bgcolor="gray">
		Copyright by bitacademy co.ltd. All rights reserved.
		</td>
	</tr>
</table>
</body>
</html>












