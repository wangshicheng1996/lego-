<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
                    <li><a class="logout" href="login.jsp">Logout</a></li>
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
              		</br></br></br></br></br></br></br></br>
					 <p id="legoid" align="center">权限</p>
					 <p id="legoid" align="center">乐购欢迎你</p>
              </div><! --/row -->
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
