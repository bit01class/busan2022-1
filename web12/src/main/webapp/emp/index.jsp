<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../template/head.jsp">
	<jsp:param value=".." name="root"/>
</jsp:include>
<script type="text/javascript">

</script>
</head>
<%@page import="java.sql.*,com.bit.util.*,java.util.*" %>
<%!
Connection conn;
Statement stmt;
ResultSet rs;

public List<EmpDto> getList() throws SQLException{
	String sql="select * from emp order by empno";
	List<EmpDto> list=new ArrayList<EmpDto>();
	
	try{
		conn=DBServer.getConnection();
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		while(rs.next()){
			EmpDto bean1=new EmpDto();
			bean1.setEmpno(rs.getInt("empno"));
			bean1.setEname(rs.getString("ename"));
			bean1.setSal(rs.getInt("sal"));
			list.add(bean1);
		}
	}finally{
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
	
	return list;
}

%>
<body>
<nav>
	<h1><a href="./">비트교육센터</a></h1>
	<ul>
		<li><a href="../">HOME</a></li>
		<li><a href="../intro.jsp">INTRO</a></li>
		<li><a href="./">LIST</a></li>
		<li><a href="../login/form.jsp">LOGIN</a></li>		
	</ul>
</nav>
<div class="container">
	<div class="row">
		<div class="grid12">
		<!-- content start -->
		<h2>리스트 페이지</h2>
		<div class="table">
		<%for(EmpDto bean : getList()){ %>
			<div>
				<a href="detail.jsp?empno=<%=bean.getEmpno() %>">
					<span><%=bean.getEmpno() %></span>
					<span><%=bean.getEname().length()>10?bean.getEname().substring(0,10)+"..": bean.getEname()%></span>
					<span><%=bean.getSal() %></span>
				</a>
			</div>
		<%} %>	
		</div>
		<p><a class="btn btn-primary" href="add.jsp">입력</a></p>
		<!-- content end -->
		</div>
	</div>
	<div class="row">
		<div id="footer" class="grid12">
		&copy; by bitacademy co.ltd. All rights reserved
		</div>
	</div>
</div>

</body>
</html>










