<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="${ctx}/css/pay.css" rel="stylesheet" type="text/css">

<script src="${ctx}/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<script src="${ctx}/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
</head>
<body>
	<!--头 -->
	<form >
	<header>

		<div class="payment_page" id="logodiv">
			<div class="logoBig" >
				<li><img src="${ctx}/images/logobig.png" /></li>
			</div>

		</div>


	</header>
	</form>
	<b class="line"></b>
	<form action="${ctx}/paymentAction_pay.action" method="post">
		<dl class="payment_page">
			<dt>
				<strong>订单号：</strong> <input class="idinp" name="orderid"
					readonly="readonly" type="text" value="0101001">
				<strong>支付金额：</strong> <input class="moneyinp" name="" type="text"
					readonly="readonly" type="text" value="0.01">元
			</dt>
			<dd class="payment_page_name">
				<strong>请您选择在线支付银行 :</strong>
			</dd>
			<dd class="banks">
				<ul>
					<li><input name="pd_FrpId" type="radio" value="ICBC-NET">
						<img src="${ctx}/img/pay/01gs.jpg" width="130" height="52">
					</li>
					<li><input name="pd_FrpId" type="radio"
						value="CMBCHINA-NET-B2C"> <img
						src="${ctx}/img/pay/02zs.jpg" width="130" height="52"></li>
					<li><input name="pd_FrpId" type="radio" value="CCB-NET">
						<img src="${ctx}/img/pay/03js.jpg" width="130" height="52">
					</li>
					<li><input name="pd_FrpId" type="radio" value=""> <img
						src="${ctx}/img/pay/04ny.jpg" width="130" height="52"></li>
					<li><input name="pd_FrpId" type="radio" value=""> <img
						src="${ctx}/img/pay/05zg.jpg" width="130" height="52"></li>
					<li><input name="pd_FrpId" type="radio" value=""> <img
						src="${ctx}/img/pay/06jt.jpg" width="130" height="52"></li>
					<li><input name="pd_FrpId" type="radio" value=""> <img
						src="${ctx}/img/pay/07hx.jpg" width="130" height="52"></li>

					<li><input name="pd_FrpId" type="radio" value=""> <img
						src="${ctx}/img/pay/08xy.jpg" width="130" height="52"></li>

					<li><input name="pd_FrpId" type="radio" value=""> <img
						src="${ctx}/img/pay/09gd.jpg" width="130" height="52"></li>

					<li><input name="pd_FrpId" type="radio" value=""> <img
						src="${ctx}/img/pay/10sz.jpg" width="130" height="52"></li>

					<li><input name="pd_FrpId" type="radio" value=""> <img
						src="${ctx}/img/pay/11ms.jpg" width="130" height="52"></li>

					<li><input name="pd_FrpId" type="radio" value=""> <img
						src="${ctx}/img/pay/12sh.jpg" width="130" height="52"></li>

					<li><input name="pd_FrpId" type="radio" value=""> <img
						src="${ctx}/img/pay/13zx.jpg" width="130" height="52"></li>

					<li><input name="pd_FrpId" type="radio" value=""> <img
						src="${ctx}/img/pay/14gd.jpg" width="130" height="52"></li>

					<li><input name="pd_FrpId" type="radio" value=""> <img
						src="${ctx}/img/pay/15cq.jpg" width="130" height="52"></li>

					<li><input name="pd_FrpId" type="radio" value=""> <img
						src="${ctx}/img/pay/16bh.jpg" width="130" height="52"></li>
				</ul>
			</dd>
			<div style="clear: both;"></div>
			<dd class="ok_dd">
				<input type="submit" class="ok_pay" value="确认支付">
			</dd>
		</dl>
	</form>
</body>
</html>

