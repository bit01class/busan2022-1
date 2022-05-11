<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/mygrid.css">
	<style rel="stylesheet" type="text/css">
	#header{
	}
	#header h1{
		height:42px;
		background-image: url("imgs/logo.jpg");
		background-repeat: no-repeat;
		text-indent: -9999px;
	}
	#menu{
		text-align: center;
		background-color: gray;
	}
	#menu a{
		color: white;
		text-decoration: none;
		display: block;
		height: 35px;
		line-height: 30px;
	}
	#menu a:hover{
		border-bottom: 5px solid black;
		border-top: 5px solid black;
		box-sizing: border-box;
	}
	#bx{
		width: 800px;
		margin: 10px auto;
		position: relative;
	}
	#bx img{
		width: 800px;
	}
	#bx a{
		display:inline-block;
		position: absolute;
		top: 17px;
		height: 220px;
		width:100px;
		background-color: black;
		opacity: 0.4;
		color: white;
		line-height: 200px;
		text-decoration: none;
		font-weight: bold;
		font-size: 100px;
		text-align: center;
	}
	#bx a:last-child{
		left: 700px;
	}
	#footer{
		padding-top:100px;
		padding-left: 200px;
	}
	</style>
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/jquery.bxslider.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$('#bx>ul').bxSlider({
			slideWidth:800,
			minSlides:1,
			maxSlides:1,
			moveSlides:1,
			auto:true,
			pager:false,
			nextText:'>',
			prevText:'<'
		});
	});
	</script>
</head>
<body>
	<div class="container">
		<div id="header" class="row">
			<div class="grid12">
				<h1>비트교육센터</h1>
			</div>
		</div>
		<div id="menu" class="row">
			<div class="grid2">&nbsp;</div>
			<div class="grid2"><a href="#">HOME</a></div>
			<div class="grid2"><a href="#">INTRO</a></div>
			<div class="grid2"><a href="#">BBS</a></div>
			<div class="grid2"><a href="#">LOGIN</a></div>
			<div class="grid2">&nbsp;</div>
		</div>
		<div id="content" class="row">
			<div id="bx">
				<ul>
					<li><img src="https://www.bitacademy.com/img/main_bn_0503.png"/></li>
					<li><img src="https://www.bitacademy.com/img/main_bn_0414_1.png"/></li>
					<li><img src="https://www.bitacademy.com/img/main_bn_0414_2.png"/></li>
					<li><img src="https://www.bitacademy.com/img/main_bn_0414_3.png"/></li>
				</ul>
			</div>
		</div>
		<div id="footer" class="row">
			<address>
			서울특별시 서초구 서초대로74길33 비트빌 3층 
			</address>
			&copy; bitacademy co.ltd. All rights reserved. 
		</div>
	</div>
</body>
</html>











