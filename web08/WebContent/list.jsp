<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
    <root>
    <% 
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/scott";
    String user="user01";
    String password="1234";
    Class.forName(driver);
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    
    String sql="select deptno,dname,loc from dept order by deptno";
try{
	conn=DriverManager.getConnection(url,user,password);
	stmt=conn.createStatement();
	rs=stmt.executeQuery(sql);
    while(rs.next()){
    %>
    	<row>
    		<deptno><%=rs.getInt("deptno") %></deptno>
    		<dname><%=rs.getString("dname") %></dname>
    		<loc><%=rs.getString("loc") %></loc>
    	</row>
    <%
    }
}finally{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
    if(conn!=null)conn.close();	
}
    %>	
    </root>