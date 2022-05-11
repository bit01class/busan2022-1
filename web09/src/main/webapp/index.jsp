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
	#list-group{
		width: 80%;
		margin: 0px auto;
		border-radius: 10px;
		border: 1px solid gray;
	}
	#list-group>*{
		padding: 20px;
	} 
	
	#list-group>*:not(:last-child){
		border-bottom: 1px solid gray;
	} 
	
	#list-group>*:first-child{
		background-color:aqua;
		border-radius: 10px 10px 0px 0px;
	}
	
	#list-group>*:last-child{
	
		border-radius: 0px 0px 10px 10px;
	}
	
	#popup{
		position: absolute;
		left: 0px;
		top:0px;
		width: 100%;
		height: 100%;
		background-color: rgba(0,0,0,0.5);
	}
	#popup>div{
		background-color: white;
		width:400px;
		height: 400px;
		margin: 100px auto;
		padding: 50px;
		box-sizing: border-box;
		border-radius: 20px;
	}
	#popup>div>form{}
	#popup>div>form>div{
		margin-bottom: 10px;
		text-align: center;
	}
	#popup>div>form>div>label{
		display: inline-block;
		width: 40%;
		background-color: darkgray;
	}
	#popup>div>form>div>input{
		width: 50%;
	}
	#popup>div>form>div>button{
		
	}
	#popup>div>.err{
	background-color: red;
	color: white;
	text-align: center;
	font-style: italic;
	}
	</style>
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/jquery.bxslider.min.js"></script>
	<script type="text/javascript">
	$(function(){
		// 이벤트 callback
		var delEvent=function(e){
			e.preventDefault();
			delOne($(e.target).parent().parent().find('[type=number]').val());
		};
		var addEvent=function(e){
			var param=$(e.target).serialize();
			addList(param);
			return false;
		};
		var editEvent=function(e){
			var param=$(e.target).serialize();
			editOne(param);
			$(e.target).off('submit',editEvent).on('submit',detailEvent);
			return false;
		};
		var detailEvent=function(e){
			$(e.target).prev().text('수정페이지');
			$(e.target).find('button').eq(1).text('취소').off('click',delEvent);
			$(e.target).find('input').each(function(idx,ele){
				if(idx!=0) $(ele).removeProp('readonly');
			});
			$(e.target).off('submit',detailEvent).on('submit',editEvent);
			return false;
		}
		var menu1Click=function(){
			$('#content>.row').hide().eq(0).show();
			return false;
		};
		var menu2Click=function(){
			$('#content>.row').hide().eq(1).show();
			return false;
		};
		var menu3Click=function(){
			$('#content>.row').hide().eq(2).show();
			getList();
			return false;
		};
		
		// ajax
		var delOne=function(param){
			$.post('bbs/delete.jsp','empno='+param,function(){
				$('#menu a').eq(2).click();
				$('#popup').click();
			});
		}
		var editOne=function(param){
			$.ajax({
				type:'post',
				url:'bbs/update.jsp',
				data:param,
				error:function(a,b,c){
					console.log(b,c);
				},
				success:function(){
					$('#menu a').eq(2).click();
					$('#popup').click();
				}
			});
		};
		var getOne=function(empno){
			$('#popup').find('h2').text('상세페이지');
			$('#popup').find('button')
							.first().text('수정')
							.next().text('삭제').on('click',delEvent);
			$('#popup').find('input').prop('readonly',true);
			$.getJSON('bbs/detail.jsp','empno='+empno,function(data){
				$('#popup').find('input').eq(0).val(data.root[0].empno);
				$('#popup').find('input').eq(1).val(data.root[0].ename);
				$('#popup').find('input').eq(2).val(data.root[0].sal);
			});
			$('#popup form').off('submit',addEvent);
			$('#popup form').on('submit',detailEvent);
			$('#popup').show();
		};
		
		var getList=function(){
			$('#list-group').html('<div><span>ename</span></div>');
			$.getJSON('bbs/list.jsp',function(data){
				data.root.forEach(function(ele,idx){
					var alink=$('<a/>').text(ele.ename).attr('href','#');
					alink.click(function(){
						getOne(ele.empno);
						return false;
					});
					$('<div/>')
						.append(alink)
						.appendTo('#list-group');
				});
			});
		};
		var addList=function(param){
			$.ajax({
				url:'bbs/insert.jsp',
				data:param,
				type:'post',
				error:function(xhr,a,b){
					console.log('err 발생');
					$('#popup h2').before('<div class="err">에러발생('+b+')</div>');
				},
				success:function(){
							$('#menu a').eq(2).click();
							$('#popup').click();
						}
			});
		};
		// 이벤트 등록
		$('#menu a')
			.first()
			.click(menu1Click)
			.end().eq(1)
			.click(menu2Click)
			.end().eq(2)
			.click(menu3Click)
		;
		$('#popup>div').click(function(e){
			e.stopPropagation();
		});
		$('#popup').add('#popup form button:eq(2)').click(function(){
			$('#popup form input').val('');
			$('#popup .err').remove();
			$('#popup').find('h2').text('입력페이지');
			$('#popup').find('button')
							.first().text('입력')
							.next().text('취소').off('click',delEvent);
			$('#popup').find('input').removeProp('readonly');
			$('#popup form').off('submit',detailEvent).on('submit',addEvent);
			$('#popup').hide();
		});
		$('#p3>a').click(function(){
			$('#popup').show();
			return false;
		});
		$('#popup form').on('submit',addEvent);

		// init
		$('#popup').hide();
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
		$('#menu a').first().click();
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
		<div id="content">
			<div id="p1" class="row">
				<div id="bx">
					<ul>
						<li><img src="https://www.bitacademy.com/img/main_bn_0503.png"/></li>
						<li><img src="https://www.bitacademy.com/img/main_bn_0414_1.png"/></li>
						<li><img src="https://www.bitacademy.com/img/main_bn_0414_2.png"/></li>
						<li><img src="https://www.bitacademy.com/img/main_bn_0414_3.png"/></li>
					</ul>
				</div>
			</div>
			<div id="p2" class="row">
				<dl>
					<dt>국가안전보장회의의 </dt>
					<dd>공개하지 아니한 회의내용의 공표에 관하여는 법률이 정하는 바에 의한다. 국회의원의 수는 법률로 정하되, 200인 이상으로 한다. 공무원인 근로자는 법률이 정하는 자에 한하여 단결권·단체교섭권 및 단체행동권을 가진다.</dd>
					<dt>모든 국민은 언론·출</dt>
					<dd>형사피고인은 유죄의 판결이 확정될 때까지는 무죄로 추정된다. 국가는 재해를 예방하고 그 위험으로부터 국민을 보호하기 위하여 노력하여야 한다. 국무회의는 정부의 권한에 속하는 중요한 정책을 심의한다.</dd>
					<dt>대법원과 각급법원의 </dt>
					<dd>지방의회의 조직·권한·의원선거와 지방자치단체의 장의 선임방법 기타 지방자치단체의 조직과 운영에 관한 사항은 법률로 정한다. 대통령은 조약을 체결·비준하고, 외교사절을 신임·접수 또는 파견하며, 선전포고와 강화를 한다.</dd>
					<dt>누구든지 체포 또는 </dt>
					<dd>제안된 헌법개정안은 대통령이 20일 이상의 기간 이를 공고하여야 한다. 대법원장은 국회의 동의를 얻어 대통령이 임명한다. 대통령의 임기연장 또는 중임변경을 위한 헌법개정은 그 헌법개정 제안 당시의 대통령에 대하여는 효력이 없다.</dd>
				</dl>
			</div>
			<div id="p3" class="row">
				<h2>리스트</h2>
				<a href="#">입력</a>
				<div id="list-group">
					<div><span>ename</span></div>
				</div>
			</div>
		</div>
		<div id="footer" class="row">
			<address>
			서울특별시 서초구 서초대로74길33 비트빌 3층 
			</address>
			&copy; bitacademy co.ltd. All rights reserved. 
		</div>
	</div>
	
	<div id="popup">
		<div>
		<h2>입력 페이지</h2>
		<form action="#" method="post">
			<div>
				<label for="empno">empno</label>
				<input type="number" name="empno" id="empno"/>
			</div>
			<div>
				<label for="ename">ename</label>
				<input type="text" name="ename" id="ename"/>
			</div>
			<div>
				<label for="sal">sal</label>
				<input type="text" name="sal" id="sal"/>
			</div>
			<div>
				<button>입력</button>
				<button type="reset">취소</button>
				<button type="button">뒤로</button>
			</div>
		</form>
		</div>
	</div>
</body>
</html>











