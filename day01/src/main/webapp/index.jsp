<%@ page contentType="text/html; charset=euc-kr" %>
<html>
<body>
<h2>Hello World!</h2>
<p>param:<%=request.getParameter("id") %></p>
<form method="post"><input type="text" name="id"><button>전송</button></form>
</body>
</html>
