<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<link rel="stylesheet" href="/css/head.css"/>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
<style type="text/css"> #tianqi{float: right;} #fancybox-frame{float: left;}</style> 
<div id="common_head">
	<div id="line1">
		<div id="content">
			<!-- 如果用户没有登陆, 应该提示登陆或注册 -->
			<c:if test="${ sessionScope.user == null }">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="/login.jsp">
				登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="/regist.jsp">注册</a>
			</c:if>
			<!-- 如果用户已经登陆, 应该提示欢迎xxx回来 -->
			<c:if test="${ sessionScope.user != null }">
			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				欢迎 ${ user.username } 回来
				&nbsp;|&nbsp;
				<a href="/servlet/LogoutServlet">退出</a>
			</c:if>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/myInfo.jsp">个人中心</a>
		
		</div>
	</div>
	<div id="line2" style="width: 100%;" align="center">
		<img id="logo" src="/img/head/logo1.jpg"/>
		<input type="text" name="letgo"/>
		
		<!--无法显示搜索这个文字  -->
		<input type="button" value="搜 索"/>
		<!--++++++++++++++++++++++++++++++ -->

		<span id="goto" style="width: auto;%" >
			<a id="goto_order" href="/OrderListServlet">我的订单</a>
			<a id="goto_cart" href="/cart.jsp">我的购物车</a>
			
			
		<!--显示位置待修改  -->
		<div id="tianqi" style="display: inline-block;" >
		<iframe id="fancybox-frame" style="display: inline-block;width: 239px;height: 70px" 
		 src="http://i.tianqi.com/index.php?c=code&a=getcode&id=42&h=54&w=214" ></iframe>
		 </div>
		<!--++++++++++++++++++++++++++++++ -->
		 
		</span>
		<%-- <img id="erwm" src="${ app }/img/head/qr.jpg"/> --%>
	</div>
	<div id="line3">
		<div id="content">
			<ul>
				<li><a href="#">首页</a></li>
				<li><a href="#">全部商品</a></li>
				<li><a href="#">手机数码</a></li>
				<li><a href="#">电脑平板</a></li>
				<li><a href="#">家用电器</a></li>
				<li><a href="#">汽车用品</a></li>
				<li><a href="#">食品饮料</a></li>
				<li><a href="#">图书杂志</a></li>
				<li><a href="#">服装服饰</a></li>
				<li><a href="#">理财产品</a></li>
			</ul>
		</div>
	</div>
</div>