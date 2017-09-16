<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="echarts.min.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
     option = {
		    title: {
		        text: '2017年盈利折线图',
		        left: 'center'
		    },
		    tooltip: {
		        trigger: 'item',
		        formatter: '{a} <br/>{b} : {c}'
		    },
		    xAxis: {
		        type: 'category',
		        name: '月份',
		        splitLine: {show: false},
		        data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月','十月','十一月','十二月']
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    yAxis: {
		        type: 'log',
		        name: '盈利/万元'
		    },
		    series: [
		        {
		            name: '1/2的指数',
		            type: 'line',
		            data: [5.8,4.4,5,5.2,6.8,6,7,6.5,6,9.5,8]
		        }
		    ]
		};

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>