<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>购物车页面</title>

		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="../css/optstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="../js/jquery.js"></script>
		<script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
		<script type="text/javascript">
			$(function(){
				/* $(".delete").click(function(){
					if(confirm("您确定删除吗？")){
						//获取商品id
						var id = $(this).parent().parent().prev().prev().children()
							.children().children().children("input[type='text']").attr("id");
						location.href="#";
					}
				}); */
				
				$(".text_box").blur(function(){
					//获取商品id 
					var id = $(this).attr("id");
					//获取用户id
					var uid = $(this).prev().attr("id");
					//获取修改购买数量：当前输入框的值
					var newPnum = $(this).val();
					//获取修改前的数量
					var oldPnum =$("#hid_"+id).val();
					if(newPnum==0){//执行删除
						location.href="/deleteShop?productId="+id+"&userId="+uid;
					}else if(newPnum!=oldPnum){//不同
						//验证数据的合法性
						var reg = /^[1-9][0-9]*$/;
						if(!reg.test(newPnum)){
							alert("请您输入正整数！");
							$(this).val(oldPnum);
						}else{
							location.href="/updateNum.action?productId="+id+"&userId="+uid+"&pnum="+newPnum;
						}
					}
				});
				//为"-"绑定点击事件
				$(".min").click(function(){
					
					//获取商品id
					var id = $(this).next().next().attr("id");
					//获取用户id
					var uid = $(this).next().attr("id");
					//获取当前商品对应输入框中的值
					var pnum = $(this).next().next().val();
					//在当前的基础上减一
					pnum = pnum - 1;
					//判断修改还是删除
					if(pnum>0){//执行修改
						location.href="/updateNum.action?productId="+id+"&userId="+uid+"&pnum="+pnum;
					}else{//执行删除
						location.href="/deleteShop?productId="+id+"&userId="+uid;
					}
				});
				//为"+"绑定点击事件 "${app}/CartEditServlet?id="+id+"&pnum="+pnum
				$(".add").click(function(){
					
					var id = $(this).prev().attr("id");
					//获取用户id
					var uid = $(this).prev().prev().attr("id");
					var pnum =$(this).prev().val();
					pnum = parseInt(pnum)+1;
					location.href="/updateNum.action?productId="+id+"&userId="+uid+"&pnum="+pnum;
				});
			});
			</script>
	</head>

	<body>

		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="#" target="_top" class="h">亲，请登录</a>
						<a href="#" target="_top">免费注册</a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd"><a href="/home.action" target="_top" class="h">商城首页</a></div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd"><a href="/collection.action" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
			</ul>
			</div>

			<!--悬浮搜索框-->

			<div class="nav white">
				<div class="logo"><img src="../images/logo.png" /></div>
				<div class="logoBig">
					<li><img src="../images/logobig.png" /></li>
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
			<c:set var="money" value="0"/>
			<c:set var="sum" value="0"/>
			<!--购物车 -->
			<div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div id="J_SelectAll1" class="select-all J_SelectAll">

								</div>
							</div>
							<div class="th th-item">
								<div class="td-inner">商品信息</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">单价</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">数量</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">金额</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
 					
 					<c:forEach items="${cacList }" var="cac">
					<tr class="item-list">
						
						<div class="bundle  bundle-last ">
							<div class="bundle-hd">
								<div class="bd-promos">
									<div class="bd-has-promo">以下产品没有优惠项目:<span class="bd-has-promo-content">或许您还需要多买点!</span>&nbsp;&nbsp;</div>
									<!-- <div class="act-promo">
										<a href="#" target="_blank">第二支半价，第三支免费<span class="gt">&gt;&gt;</span></a>
									</div>
									<span class="list-change theme-login">编辑</span> -->
								</div>
							</div>
							<div class="clear"></div>
							<div class="bundle-main">
								<ul class="item-content clearfix">
									<li class="td td-chk">
										<div class="cart-checkbox ">
											<input class="check" id="J_CheckBox_170037950254" name="items[]" value="170037950254" type="checkbox">
											<label for="J_CheckBox_170037950254"></label>
										</div>
									</li>
									<li class="td td-item">
										<div class="item-pic">
											<a href="#" target="_blank" data-title="商品名" class="J_MakePoint" data-point="tbcart.8.12">
												<img src="../images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
											<div class="item-basic-info">
												<a href="#" target="_blank" title="商品名" class="item-title J_MakePoint" data-point="tbcart.8.11">${cac.product.name }</a>
											</div>
										</div>
									</li>
									<li class="td td-info">
										<div class="item-props item-props-can">
											<span class="sku-line">${cac.product.remark }</span>
											<!-- <span tabindex="0" class="btn-edit-sku theme-login">修改</span>
											<i class="theme-login am-icon-sort-desc"></i> -->
										</div>
									</li>
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="price-original">${cac.product.price+30 }</em>
												</div>
												<div class="price-line">
													<em class="J_Price price-now" tabindex="0">${cac.product.price }</em>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl">
													<input id="hid_${cac.product.productId }" type="hidden" value="${cac.number }"/>
													<input class="min am-btn" name="" type="button" value="-" />
													<input id="${cac.user.userId }" type="hidden" value="${cac.user.userId }"/>
													<input id="${cac.product.productId }" class="text_box" name="" type="text" value="${cac.number }" style="width:30px;" />
													<c:set var="sum" value="${sum+cac.number  }"/>
													<input class="add am-btn" name="" type="button" value="+" />
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
											<em tabindex="0" class="J_ItemSum number">${cac.number*cac.product.price }</em>
											<c:set var="money" value="${money+cac.number*cac.product.price }"/>
										</div>
									</li>
									<li class="td td-op">
										<div class="td-inner">
											<a title="移入收藏夹" class="btn-fav" href="/addCollection.action?productId=${cac.product.productId }&userId=${cac.user.userId}">移入收藏夹</a>
											<a href="/deleteShop.action?productId=${cac.product.productId }&userId=${cac.user.userId}" data-point-url="#" class="delete">删除</a>
										</div>
									</li>
								</ul>
								
							</div>
						</div>
					</tr>
					</c:forEach>
					<div class="clear"></div>

					
				<div class="clear"></div>

				<div class="float-bar-wrapper">
					<div id="J_SelectAll2" class="select-all J_SelectAll">
						<div class="cart-checkbox">
							<input class="check-all check" id="J_SelectAllCbx2" name="select-all" value="true" type="checkbox">
							<label for="J_SelectAllCbx2"></label>
						</div>
						<span>全选</span>
					</div>
					<div class="operations">
						<a href="#" hidefocus="true" class="deleteAll">删除</a>
					
					</div>
					<div class="float-bar-right">
						<div class="amount-sum">
							<span class="txt">已选商品</span>
							<em id="J_SelectedItemsCount">${sum }</em><span class="txt">件</span>
							<div class="arrow-box">
								<span class="selected-items-arrow"></span>
								<span class="arrow"></span>
							</div>
						</div>
						<div class="price-sum">
							<span class="txt">合计:</span>
							<strong class="price">¥<em id="J_Total">${money }</em></strong>
						</div>
						<div class="btn-area">
							<a href="/pay.action" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
								<span>结&nbsp;算</span></a>
						</div>
					</div>

				</div>

				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">乐购我最帅科技</a>
							<b>|</b>
							<a href="/home.action">商城首页</a>
							<b>|</b>
							<a href="#">支付宝</a>
							<b>|</b>
							<a href="#">物流</a>
						</p>
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于乐购</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
							<em>© 2015-2025 lego.com 版权所有.</em>
						</p>
					</div>
				</div>

			</div>

	</body>

</html>