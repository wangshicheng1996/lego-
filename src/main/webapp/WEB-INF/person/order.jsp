<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../base.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

	<title>订单管理</title>

	<link href="${ctx}/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

  	<link href="${ctx}/css/order.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/css/personal.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/css/orstyle.css" rel="stylesheet" type="text/css">

	<script src="${ctx}/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
	<script src="${ctx}/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
</head>
<body>
	<!--头 -->
	<header>
		<article>
			<div class="mt-logo">
				<!--顶部导航条 -->
				<div class="am-container header">
					<ul class="message-l">
						<div class="topMessage">
							<div class="menu-hd">
								<!-- <a href="#" target="_top" class="h">亲，请登录</a>
								<a href="#" target="_top">免费注册</a> -->
								
								<!-- <span>欢迎&nbsp;&nbsp;回来</span> -->
								
							</div>
						</div>
					</ul>
					<ul class="message-r">
						
						<div class="topMessage home">
							<div class="menu-hd"><a href="${ctx}/home.action" target="_top" class="h">商城首页</a></div>
						</div>
						<div class="topMessage my-shangcheng">
							<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
						</div>
						<div class="topMessage mini-cart">
							<div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
						</div>
						<div class="topMessage favorite">
							<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
					</ul>
					</div>

					<!--悬浮搜索框-->

					<div class="nav white">
						<div class="logoBig">
							<li><img src="${ctx}/images/logobig.png" /></li>
						</div>

						<div class="search-bar pr">
							<a name="index_none_header_sysc" href="#"></a>
							<form>
								<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
								<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
							</form>
						</div>
					</div>

					<div class="clear"></div>
				</div>
			</div>
		</article>
	</header>
           <div class="nav-table">
				   <div class="long-title"><span class="all-goods">全部分类</span></div>
				   <div class="nav-cont">
						<ul>
							<li class="index"><a href="${ctx}/home">首页</a></li>
                               <li class="qc"><a href="#">闪购</a></li>
                               <li class="qc"><a href="#">限时抢</a></li>
                               <li class="qc"><a href="#">团购</a></li>
                               <li class="qc last"><a href="#">全部商品</a></li>
						</ul>
					    <div class="nav-extra">
					    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
					    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
					    </div>
					</div>
		</div>
		<b class="line"></b>
		
	<div class="warp">
		<!-- 标题信息 -->
	<div id="title">
		<input name="allC" type="checkbox" value="" onclick=""/>
		<span id="title_checkall_text">全选</span>
		<span id="title_name">商品</span>
		<span id="title_price">单价（元）</span>
		<span id="title_buynum">数量</span>
		<span id="title_money">合计（元）</span>
		<span id="title_state">交易状态</span>
		<span id="title_del">交易操作</span>
	</div>
	<!-- 购物信息 -->
<c:forEach items="${itemsList}" var="i">
	<div id="prods">
		<input name="prodC" type="checkbox" value="" onclick=""/>
		<img src="${ctx}/ProdImgServlet?imgurl=${i.product.image}" width="60" height="60" />
		<span id="prods_name">${i.product.name}</span>
		<span id="prods_price">${i.product.price}元</span>
		<span id="prods_buynum">${i.count}</span>
		<span id="prods_money">${i.product.price*i.count}</span>
		<span id="prods_state">
			<c:if test="${i.order.paystate==0}">未支付</c:if>
			<c:if test="${i.order.paystate==1}">已支付|
				<c:if test="${i.state==1}">未发货|
				<a href="${ctx}/map" target="_blank">查看详情</a>
				</c:if>
				<c:if test="${i.state==2}">已发货配送中|
				<a href="${ctx}/logistic" target="_blank">物流信息</a>
				</c:if>
				<c:if test="${i.state==3}">已签收|
				<a href="${ctx}/logistic" target="_blank">物流信息</a>
				</c:if>
			</c:if>
		</span>
		<c:if test="${i.state==3 || i.order.paystate==0}">
			<span id="prods_del">
				<a class="prodDel" href="javascript:void(0)"/>删除|
				<c:if test="${i.order.paystate==0}">
					<a class="prodDel" href="${ctx}/pay"/>支付
				</c:if>
			</span>
		</c:if>
	</div>
</c:forEach>


	</body>
</html>