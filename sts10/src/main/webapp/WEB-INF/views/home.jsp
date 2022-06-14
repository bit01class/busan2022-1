<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
</head>
<body>
<h1>
	file upload page
</h1>
<form action="./upload" method="post" enctype="multipart/form-data">
	<div>
		<label>msg</label>
		<input type="text" name="msg"/>
	</div>
	<div>
		<label>file</label>
		<input type="file" name="file"/>
	</div>
	<div>
		<button>전송</button>
	</div>
</form>

</body>
</html>
