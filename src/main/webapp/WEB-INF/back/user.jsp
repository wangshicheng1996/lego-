<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../base.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>乐购后台管理</title>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="${ctx}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/lineicons/style.css">    
    
    <!-- 分页 -->
    <link href="/try/bootstrap/twitter-bootstrap-v2/docs/assets/css/bootstrap.css" rel="stylesheet">	
    <!-- Custom styles for this template -->
    <link href="${ctx}/assets/css/style.css" rel="stylesheet">
    <link href="${ctx}/assets/css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="${ctx}/assets/js/chart-master/Chart.js"></script>
    
    <style type="text/css">  
		#legoid {		
		    font-family: verdana, sans-serif;
			color: #E39A07;
			font-size: 70px;
			letter-spacing: 8.2pt;
		}
   
    </style> 
    
    
    <!-- 表格 -->
    
    <style type="text/css">	
		table {
			text-align: center;
			margin: 0px auto;
		}
		th {
			background-color: silver;
		}
		</style>
		<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>
		<script type="text/javascript">
		$(function(){
			$(".del").click(function(){
				//获取用户id
				var id = $(this).parent().prev().prev().
					children("input[type='text']").attr("id");
				//判断是否确认删除
				if(confirm("您确定删除吗？")){
					window.location.href="${app}/BackUserDelete?userId="+id;
				}
			});
		});
		</script>
    
    
    <!-- +++++++++++++++++++ -->
    
  </head>

  <body>

  <section id="container" >
      <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="index.jsp" class="logo"><b>乐购商城后台管理</b></a>
            <!--logo end-->
     
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="login.jsp">用户管理</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!--sidebar start-->
      <aside>
              <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.jsp"><img src="${ctx}/assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">欢迎 &nbsp;&nbsp;  使用</h5>
              	  	
              	  <li class="sub-menu">
                      <a href="/back/index" >
                          <span style="font-size: 17px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          									商城首页</span>
                      </a>
                  </li>
           
                  
                  <li class="sub-menu">
                      <a href="/back/product" >
                          <i class="fa fa-th"></i>
                          <span>商品管理</span>
                      </a>
                  </li>


                  <li class="sub-menu">
                      <a href="/back/user" >
                          <i class="fa fa-desktop"></i>
                          <span>用户管理</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a href="/back/permissions" >
                          <i class="fa fa-cogs"></i>
                          <span>权限管理</span>
                      </a>
                  </li>
                  <li class="sub-menu">
                      <a href="/back/sale" >
                          <i class="fa fa-book"></i>
                          <span>销售榜单</span>
                      </a>
                  
                  </li>
                  
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">

              <div class="row">
              		<h1 align="center">用户管理</h1>
				<hr>
				<table bordercolor="black" border="1" width="95%" cellspacing="0px" cellpadding="5px">
					<tr >
						<th>用户名</th>
						<th>用户id</th>
						<th>用户级别</th>
						<th>Email</th>
						<th>证件号</th>
						<th>生日</th>
						<th>联系方式</th>
						<th>操作</th>
					</tr>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.username }</td>
						<td>${user.userId }</td>
						<td>${user.permission.permissionName }</td>
						<td>${user.userInfo.email}</td>
						<td>${user.userInfo.cardNo}</td>
						<td><input id="${user.userId}" name="birthday" type="text" value="${user.userInfo.birthday }" readonly="readonly"/>
							<input type="hidden" /> 
						</td>
						<td>${user.userInfo.telephone}</td>
						<td><a href="javascript:void(0)" class="del">删除</a></td>
					</tr>
				</c:forEach>
				</table>
				<!--分页  -->
				    <ul class="pager">
						<li>
							<c:if test="${m==0}"><a href="/back/user?m=${m}&n=${n}">Previous</a></c:if>
							<c:if test="${m!=0}"><a href="/back/user?m=${m-20}&n=${n-20}">Previous</a></c:if>
						</li>
						<li>
							<a href="/back/user?m=${m+20}&n=${n+20}">Next</a>
						</li>
					</ul>        
              </div>
          </section>
      </section>

      <!--main content end-->
    
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="${ctx}/assets/js/jquery.js"></script>
    <script src="${ctx}/assets/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="${ctx}/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="${ctx}/assets/js/jquery.scrollTo.min.js"></script>
    <script src="${ctx}/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${ctx}/assets/js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="${ctx}/assets/js/common-scripts.js"></script>
    
    <script type="text/javascript" src="${ctx}/assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="${ctx}/assets/js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="${ctx}/assets/js/sparkline-chart.js"></script>    
	<script src="${ctx}/assets/js/zabuto_calendar.js"></script>	
	
	
	
	<script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>
  

  </body>
</html>
