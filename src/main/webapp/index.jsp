<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
	<title>欢迎光临乐购商城</title>
	<link rel="stylesheet" href="/css/index.css" />
	<link rel="stylesheet"	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<!--返回顶部  -->
	<script type="text/javascript" src="http://hovertree.com/ziyuan/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="http://hovertree.com/texiao/yestop/inc/jquery.yestop.js"></script>
	
<!--鼠标放置在图片上会放大  -->	
	<style type="text/css">  
	/* 放大过度时间 */
            div img{  
                cursor: pointer;  
                transition: all 0.6s;  
            }  
     /* 选择图片 ,按类*/
            div .isimg:hover{  
                transform: scale(1.4);  
            }  
        </style> 
</head>


<body>
	<!-- 引入头部 -->
	<%@include file="/_head.jsp"%>

	<div id="index">
		<div id="line1">
			<div id="myCarousel" class="carousel slide">
				<!-- 轮播（Carousel）指标 -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
				</ol>
				<!-- 轮播（Carousel）项目 -->
				<div class="carousel-inner">
					<div class="item active">
						<a href="#"><img src="/img/index/big_1.jpg"  alt="First slide"></a>
					</div>
					<div class="item">
						<a href="#"><img src="/img/index/big_2.jpg" alt="Second slide"></a>
					</div>
					<div class="item">
						<a href="#"><img src="/img/index/big_3.jpg" alt="Third slide"></a>
					</div>
					<div class="item">
						<a href="#"><img src="/img/index/big_4.jpg" alt="Four slide"></a>
					</div>
				</div>
				<!-- 轮播（Carousel）导航 -->
				<a class="carousel-control left" href="#myCarousel"
					data-slide="prev">&lsaquo;</a> <a class="carousel-control right"
					href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
		</div>


		<div id="line2">
			<a href="#"><img id="line2_1" src="img/index/adv1.jpg" class="isimg"/></a> 
			<a href="#"><img id="line2_2" src="img/index/adv2.jpg" class="isimg"/></a>
			<a href="#"><img id="line2_3" src="img/index/adv_l1.jpg" class="isimg"/></a>
		</div>
		<div id="line3">
			<a href="#"><img id="line3_1" src="img/index/adv3.jpg" class="isimg"/> </a>
			<a href="#"><img id="line3_2" src="img/index/adv4.jpg" class="isimg"/></a>
			<div id="line3_right">
				<a href="#"><img id="line3_3" src="img/index/adv_l2.jpg" /></a>
				<a href="#"><img id="line3_4" src="img/index/adv_l3.jpg" /></a>
			</div>
		</div>
		
		
		<div id="line4">
			<a href="#"><img src="img/index/217.jpg" /></a>
		</div>
		
		
		
		<div id="line5">
			<span id="line5_1"> <img src="img/index/icon_g1.png" />&nbsp;&nbsp;500强企业
				品质保证 </span> <span id="line5_2"> <img src="img/index/icon_g2.png" />&nbsp;&nbsp;7天退货
				15天换货 </span> <span id="line5_3"> <img src="img/index/icon_g3.png" />&nbsp;&nbsp;100元起免运费
			</span> <span id="line5_4"> <img src="img/index/icon_g4.png" />&nbsp;&nbsp;448家维修网点
				全国联保 </span>
		</div>


	</div>
	
	<!--返回顶部  -->
<script type="text/javascript">
	$.fn.yestop();
</script>

	<!-- 引入尾部 -->
	<%@include file="/_foot.jsp"%>
</body>
</html>
