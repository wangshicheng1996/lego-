<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../base.jsp"%>
<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="UTF-8">
<title>注册</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />


<link rel="stylesheet"
	href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="../css/dlstyle.css" rel="stylesheet" type="text/css">
<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<script src="../AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
<script type="text/javascript"
	src="../AmazeUI-2.4.2/assets/js/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="../AmazeUI-2.4.2/assets/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="../AmazeUI-2.4.2/assets/js/additional-methods.js"></script>
<script type="text/javascript"
	src="../AmazeUI-2.4.2/assets/js/jquery.validate.extend.js"></script>

<script type="text/javascript">
	$(function() {

		//让当前表单调用validate方法，实现表单验证功能
		$("#ff").validate({
			//debug : true, //调试模式，即使验证成功也不会跳转到目标页面
			rules : { //配置验证规则，key就是被验证的dom对象，value就是调用验证的方法(也是json格式)
				semail : {
					required : true,
					email : true
				},
				password : {
					required : true,
					rangelength : [ 6, 16 ]
				},
				password2 : {
					required : true,
					equalTo : '#password' //表示和id="password"的值相同
				}

			},
			messages : {
				semail : {
					required : "请填写邮件",
					email : "邮箱格式不正确"
				},
				password : {
					required : "请输入密码",
					rangelength : $.validator.format("密码长度为{0}-{1}个字符")
				},
				password2 : {
					required : "请再次输入密码",
					equalTo : "两次密码必须一致" //表示和id="password"的值相同
				}

			}
		});
	});
</script>



</head>

<body>


	<div class="login-boxtitle">
		<a href="home/demo.html"><img alt=""
			src="${ctx}/images/logobig.png" /></a>
	</div>

	<div class="res-banner">
		<div class="res-main">
			<div class="login-banner-bg">
				<span></span><img src="${ctx}/images/big.jpg" />
			</div>
			<div class="login-box">

				<div class="am-tabs" id="doc-my-tabs">
					<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
						<li class="am-active"><a href="">邮箱注册</a></li>
					</ul>

					<div class="am-tabs-bd">
						<div class="am-tab-panel am-active">
						<form action="${ctx }/saveUser.action" id="ff" method="post">
							<div class="user-email">
									<label for="email"><i class="am-icon-envelope-o"></i></label> <input
										type="email" name="semail" id="email" placeholder="输入邮箱账号"
										tip="请输入邮箱账号">
								</div>
								<div class="user-pass">
									<label for="password"><i class="am-icon-lock"></i></label> <input
										type="password" name="password" id="password" placeholder="设置密码"
										tip="请设置密码">
								</div>
								<div class="user-pass">
									<label for="passwordRepeat"><i class="am-icon-lock"></i></label>
									<input type="password" name="password2" id="passwordRepeat"
										placeholder="确认密码" tip="请设置确认密码">
								</div>
							
							<div class="login-links">
								 <input id="reader-me"
									type="checkbox" name="checkbox"><i class="ii"> &nbsp;&nbsp;&nbsp;&nbsp;点击表示您同意商城《服务协议》</i>
								</input>
							</div>
							<div class="am-cf">
								<input type="submit" name="submit" value="注册"
									class="am-btn am-btn-primary am-btn-sm am-fl" />
							</div>
						</form>
						</div>




						

					</div>
				</div>

			</div>
		</div>
	</div>

	<div class="footer ">
		<div class="footer-hd ">
			<p>
				<a href="# ">恒望科技</a> <b>|</b> <a href="# ">商城首页</a> <b>|</b> <a
					href="# ">支付宝</a> <b>|</b> <a href="# ">物流</a>
			</p>
		</div>
		<div class="footer-bd ">
			<p>
				<a href="# ">关于恒望</a> <a href="# ">合作伙伴</a> <a href="# ">联系我们</a> <a
					href="# ">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a
					href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
					- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
					target="_blank">网页模板</a></em>
			</p>
		</div>
	</div>
</body>

</html>
</html>