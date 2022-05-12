<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.module01.mysql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/head.jspf" %>
<style type="text/css">
	body{
		margin: 0px;
		padding: 0px;
	}
	nav{
		background-color: gray;
		overflow: hidden;
	}
	nav>ul{
		list-style: none;
		padding: 0px;
		margin: 0px;
	}
	nav>ul>li{
		display: inline-block;
		width: 100px;
	}
	nav>ul>li>a{
		display: block;
		height: 40px;
		color: white;
		text-decoration: none;
		text-align: center;
		line-height: 40px;
	}
	
	.row img{
		width: 100%;
	}
	.btn{
		width: 30px;
		height: 30px;
		border: 1px solid white;
		border-radius: 4px;
		overflow: hidden;
		float: right;
		background-color: darkgray;
	}
	
	.table,.table tr>th,.table tr>td{
		border: 1px solid gray;
		border-collapse: collapse;
	}
	.table{
		width: 80%;
		margin: 100px auto;
	}
	.table tr>th,.table tr>td{
		height: 50px;
	}
	.table tr>td>a{
		display: block;
		height: 50px;
	}
	.table tr>td:first-child>a{
		text-align: center;
	}
	.table tr>td:last-child>a{
		text-align: right;
	}
	.button{
		display: block;
		width: 80%;
		margin: 50px auto;
		height: 40px;
		text-decoration: none;
		background-color: blue;
		border-radius: 5px;
		color:white;
		text-align: center;
		line-height: 40px;
	}
	form{
		margin: 100px auto;
	}
	form>div{}
	form>div>label{
		display: block;
		width: 80%;
		margin: 0px auto;
		height: 40px;
	}
	form>div>input{
		display: block;
		height: 40px;
		width: 80%;
		margin: 0px auto 30px auto;
	}
	.err{
		background-color: red;
		height: 50px;
		text-align: center;
		color:white;
	}
</style>
<script type="text/javascript">
	$(function(){
		$(document).on('click','form button:eq(2)',function(){
			history.back();
		});
		$('<div class="btn"/>')
				.append('<span></span>')
				.append('<span></span>')
				.append('<span></span>')
				.prependTo('nav')
				.click(function(){
					$('nav>ul>li').toggle();
				})
		;
		$(window).on('resize',function(){
			if($('nav').width()<600){
				$('.btn').show();
				$('nav>ul>li').css('display', 'block').hide();
			}else{
				$('.btn').hide();
				$('nav>ul>li').css('display', 'inline-block');
			}
		});
	});
	$(function(){
		if($('nav').width()<600){
			$('.btn').show();
			$('nav>ul>li').css('display', 'block').hide();
		}else{
			$('.btn').hide();
			$('nav>ul>li').css('display', 'inline-block');
		}
	});
</script>
</head>
<body>
<%
String[] param={
		request.getParameter("empno"),
		request.getParameter("ename"),
		request.getParameter("sal")
};
try{
if("POST".equals(request.getMethod())){
	int empno=Integer.parseInt(param[0].trim());
	String ename=param[1].trim();
	int sal=Integer.parseInt(param[2].trim());
	BitEmp emp=new BitEmp();
	if(emp.insertOne(empno,ename,sal))response.sendRedirect("list.jsp");
}
}catch(Exception e){
	out.print("<div class=\"err\">오류발생<div class=\"btn\">x</div></div>");	
}
%>
<nav>
	<ul>
		<li><a href="index.jsp">HOME</a></li>
		<li><a href="list.jsp">EMP</a></li>
		<li><a href="#">DEPT</a></li>
		<li><a href="#">ETC</a></li>
	</ul>
</nav>
	<div class="container">
		<div class="row">
			<div class="grid12">
				
				<h2>입력페이지</h2>
				<form method="post">
					<div>
						<label for="empno">empno</label>
						<input type="text" name="empno" id="empno" value="<%=param[0]==null?"":param[0]%>"/>
					</div>
					<div>
						<label for="ename">ename</label>
						<input type="text" name="ename" id="ename" value="<%=param[1]==null?"":param[1]%>"/>
					</div>
					<div>
						<label for="sal">sal</label>
						<input type="text" name="sal" id="sal"  value="<%=param[2]==null?"":param[2]%>"/>
					</div>
					<div>
						<button class="button">입력</button>
						<button class="button" type="reset">취소</button>
						<button class="button" type="button">뒤로</button>
					</div>
				</form>
				
			</div>
		</div>
		<div class="row" id="footer">
			<div class="grid12">
			&copy; by bitacademy co.ltd. All rights reserved
			</div>
		</div>
	</div>
</body>
</html>