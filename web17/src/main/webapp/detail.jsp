<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/head.jspf" %>

</head>
<body>
<%@ include file="template/menu.jspf" %>
<%
com.bit.model.EmpDto bean=(com.bit.model.EmpDto)request.getAttribute("bean");
%>
<div class="page-header">
  <h1>상세페이지 <small>EMP Detail</small></h1>
</div>
<form class="form-horizontal" method="post">
  <div class="form-group">
    <label for="empno" class="col-sm-2 control-label">empno</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="empno" id="empno" value="<%=bean.getEmpno() %>" readonly/>
    </div>
  </div>
  <div class="form-group">
    <label for="ename" class="col-sm-2 control-label">ename</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="ename" id="ename" value="<%=bean.getEname() %>" readonly/>
    </div>
  </div>
  <%
  	for(String item: (java.util.List<String>)bean.getItem()){
  %>
  <div class="form-group">
	  <div class="col-sm-offset-2 col-sm-10">
	  	<input type="text" class="form-control" name="item" id="ename" value="<%=item %>" readonly/>
	  </div>
  </div>
  <%} %>
  <input type="hidden" name="_id" value="<%=bean.getId()%>">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="btn-group" role="group" aria-label="...">
      <button type="submit" class="btn btn-primary">수정</button>
      <button type="reset" class="btn btn-default">취소</button>
      <button type="button" class="btn btn-danger">삭제</button>
      <button type="button" onclick="history.back();" class="btn btn-default">뒤로</button>
      </div>
    </div>
  </div>
</form>
<%@ include file="template/footer.jspf" %>
<script type="text/javascript">
	$('button[type="reset"]').hide();
	$('form').one('submit',function(e){
		$(e.target).find('input').removeProp('readonly');
		$('.page-header>h1').html('<h1>수정페이지 <small>EMP Update</small></h1>');
		$('button[type="reset"]').show();
		$('.btn.btn-danger').hide();
		return false;
	});
	$('.btn.btn-danger').click(function(e){
		$.ajax({
			url:'detail.html',
			type:'delete',
			data:'{_id:ObjectId("<%=bean.getId()%>")}',
			success:function(data){
				location.href='list.html';				
			}
		});
	});
</script>
</body>
</html>