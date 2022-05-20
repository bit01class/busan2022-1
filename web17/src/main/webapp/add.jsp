<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/head.jspf" %>
<script type="text/javascript">
var ele= $(`
		<div class="form-group">
	    <label for="ename" class="col-sm-2 control-label">item</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="item" id="ename" placeholder="ename">
	    </div>
	  </div>
		`);
var cnt=0;
$(function(){
	$('button').click(function(e){
		if(e.target.innerHTML=='입력추가'){
			cnt++;
			var obj=ele.clone();
			obj.find('label').attr('for','item'+cnt).text('item'+cnt);
			obj.find('input').attr('id','item'+cnt).attr('placeholder','item'+cnt);
			$(e.target).parent().parent().before(obj);
		}
	});
	
});
</script>
</head>
<body>
<%@ include file="template/menu.jspf" %>
<div class="page-header">
  <h1>입력페이지 <small>EMP Insert</small></h1>
</div>
<form class="form-horizontal" method="post">
  <div class="form-group">
    <label for="empno" class="col-sm-2 control-label">empno</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="empno" id="empno" placeholder="empno">
    </div>
  </div>
  <div class="form-group">
    <label for="ename" class="col-sm-2 control-label">ename</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="ename" id="ename" placeholder="ename">
    </div>
  </div>
  <div class="form-group">
	  <div class="col-sm-offset-2 col-sm-10">
	  	<button type="button" class="btn btn-default btn-block">입력추가</button>
	  </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="btn-group" role="group" aria-label="...">
      <button type="submit" class="btn btn-primary">입력</button>
      <button type="reset" class="btn btn-default">취소</button>
      <button type="button" onclick="history.back();" class="btn btn-default">뒤로</button>
      </div>
    </div>
  </div>
</form>
<%@ include file="template/footer.jspf" %>
</body>
</html>