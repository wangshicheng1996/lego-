<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../base.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="${ctx}/echarts.min.js"></script>
    <script type="text/javascript">
     var p = ['鼠标','华为荣耀九','32gU盘']
     var m = [200,156,50]
    </script>
</head>

<body>
<h1 ></h1>

    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style=" margin:100px 400px;width:1000px;height:500px;"></div>
    <script type="text/javascript">
 	// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
		option = {
			title : {
		        text: '销售数量',
		        subtext: '销售数量',
		        x:'center'
		    },
		    color: ['#3398DB'],
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis : [
		        {            
			        name : '商品',
		            type : 'category',
		            data : p,
		            axisTick: {
		                alignWithLabel: true
		            }
		           
		        }
		    ],
		    yAxis : [
		        {
			        name : '销量/件',
		            type : 'value'
		            
		        }
		    ],
		    series : [
		        {
		            name:'销售数量',
		            type:'bar',
		            barWidth: '50%',
		            data:m
		        }
		    ]
		};



		// 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>