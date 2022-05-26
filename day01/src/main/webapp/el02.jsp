<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>값의 전달</h1>
	<%
	// scope 
	// page > request > session >application
	//java.util.Date msg1=new java.util.Date();
	
	String[] arr1={"item1","item2","item3"};
	java.util.List<String> arr2=new java.util.ArrayList<String>();
	arr2.add("list1");
	arr2.add("list2");
	arr2.add("list3");

	java.util.Set<String> arr3=new java.util.HashSet<String>(); // JSTL
	arr3.add("Set1");
	arr3.add("Set2");
	arr3.add("Set3");
	session.setAttribute("msg2",arr2);
	pageContext.setAttribute("msg2", arr2);
	request.setAttribute("msg2", arr3);
	application.setAttribute("msg2", arr1);
	
	java.util.Map<String,String> map=new java.util.HashMap<String,String>();
	map.put("key1", "val1");
	map.put("key2", "val2");
	map.put("key3", "val3");
	pageContext.setAttribute("map", map);
	
	com.bit.frame.controller.DeptVo bean=new com.bit.frame.controller.DeptVo();
	bean.setDeptno(1111);
	bean.setDname("test1");
	bean.setLoc("test2");
	pageContext.setAttribute("bean", bean);
	%>
	<p>msg1= <%=arr1 %></p>
	<p>msg1= ${msg1 }</p>
	<p>pageContext= <%=pageContext.getAttribute("msg2") %></p>
	<p>pageContext= ${pageScope.msg2 }</p>
	<p>pageContext= ${pageScope.msg2.get(0) }</p>
	<p>pageContext= ${pageScope.msg2.get(1) }</p>
	<p>pageContext= ${pageScope.msg2.get(2) }</p>
	<p>request= <%=request.getAttribute("msg2") %></p>
	<p>request= ${requestScope.msg2 }</p>
	<p>session= <%=session.getAttribute("msg2") %></p>
	<p>session= ${sessionScope.msg2 }</p>
	<p>session= ${sessionScope.msg2[0] }</p>
	<p>session= ${sessionScope.msg2[1] }</p>
	<p>session= ${sessionScope.msg2[2] }</p>
	<p>session= ${sessionScope.msg2[3] }</p>
	<p>application= <%=application.getAttribute("msg2") %></p>
	<p>application= ${applicationScope.msg2 }</p>
	<p>application= ${applicationScope.msg2[0] }</p>
	<p>application= ${applicationScope.msg2[1] }</p>
	<p>application= ${applicationScope.msg2[2] }</p>
	<p>map= ${map }</p>
	<p>map= ${map.get("key1") }</p>
	<p>map= ${map.get("key2") }</p>
	<p>map= ${map.get("key3") }</p>
	<p>map= ${map }</p>
	<p>map= ${map.key1 }</p>
	<p>map= ${map.key2 }</p>
	<p>map= ${map.key3 }</p>
	<p>map= ${obj.obj }</p>
	<p>bean= ${bean }
	<p>bean= ${bean.deptno }
	<p>bean= ${bean.dname }
	<p>bean= ${bean.loc }
</body>
</html>














