<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#target{}
#target>div{}
#target>div>span{
	display: inline-block;
	width: 200px;
	height: 50px;
}
#target>div>span:first-child{}
</style>
<script type="text/javascript" src="webjars/jquery/1.12.4/dist/jquery.min.js"></script>

</head>
<body>

<div id="target"></div>
<script type="text/javascript">
$.get('api/emp/',function(data){
	var arr=data.root;
	arr.forEach(function(ele,idx){
		$('<div/>')
		.append('<span>'+ele.empno+'</span>')
		.append('<span>'+ele.ename+'</span>')
		.append('<span>'+Date(ele.hiredate)+'</span>')
		.appendTo('#target');
	});
	
});
</script>
</body>
</html>