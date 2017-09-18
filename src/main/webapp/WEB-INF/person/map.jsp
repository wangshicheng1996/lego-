<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Fh0gyHcZs0GdSkTpR6h9V18oFhXEtMGy"></script>
	<title>测距</title>
</head>
<body>
	<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	// 获取地图地址解析器
	var myGeo = new BMap.Geocoder();
	// 将地址解析结果显示在地图上,并调整地图视野
	var pointA="";
	var pointB="";
	
	// 本公司地址
	myGeo.getPoint("北京亦庄经济技术开发区经开壹中心达内教育大厦", function(point){
		map.centerAndZoom(point, 10);
		map.addOverlay(new BMap.Marker(point));
		pointA = new BMap.Point(point.lng,point.lat);
		var marker = new BMap.Marker(pointA);  // 创建标注
		map.addOverlay(marker);              // 将标注添加到地图中
		var label = new BMap.Label("亲，您的宝贝从这里发货哦！",{offset:new BMap.Size(20,-10)});
		marker.setLabel(label);
	}, "北京市");
	
	// 获取送货地址
	var receiveadd = "<%=session.getAttribute("receiveadd")%>";
	// 收货的省份
	var province = "<%=session.getAttribute("province")%>";
	
	myGeo.getPoint(receiveadd, function(point){
		if (point) {
			map.addOverlay(new BMap.Marker(point));
			pointB = new BMap.Point(point.lng,point.lat);
			var marker = new BMap.Marker(pointB);  // 创建标注
			map.addOverlay(marker);              // 将标注添加到地图中
			var label = new BMap.Label("亲，您的宝贝将到达这里哦！",{offset:new BMap.Size(20,-10)});
			marker.setLabel(label);
			
			//alert('您的宝贝距您还有'+((map.getDistance(pointA,pointB))/1000).toFixed(2)+' 千米，请耐心等候发货。');  //获取两点距离,保留小数点后两位
			var polyline = new BMap.Polyline([pointA,pointB], {strokeColor:"blue", strokeWeight:6, strokeOpacity:0.5});  //定义折线
			map.addOverlay(polyline);     //添加折线到地图上
			
			var pointC = new BMap.Point((pointA.lng+pointB.lng)/2,(pointA.lat+pointB.lat)/2);
			var opts = {
					  position : pointC,    // 指定文本标注所在的地理位置
					  offset   : new BMap.Size(30, -30)    //设置文本偏移量
					}
			
			var distance = ((map.getDistance(pointA,pointB))/1000).toFixed(2);
			var msg = "您的宝贝距您" + distance + "千米，请耐心等候发货。";
			var label = new BMap.Label(msg, opts);  // 创建文本标注对象
			label.setStyle({
				 color : "red",
				 fontSize : "12px",
				 height : "20px",
				 lineHeight : "20px",
				 fontFamily:"微软雅黑"
			 });
			map.addOverlay(label); 
			
		}else{
			alert("您的收获地址没有解析到结果!");
		}
	}, province);
	map.enableScrollWheelZoom(true);
</script>