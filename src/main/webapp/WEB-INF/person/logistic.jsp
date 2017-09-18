<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>物流详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script>
function j() {
	var num = '<%=session.getAttribute("num")%>';
	var nu = "<%=session.getAttribute("nu")%>";
window.location.href= 
	//"http://www.baidu.com/";
	"https://www.kuaidi100.com/chaxun?com="+num+"&nu="+nu;
}
</script>
</head>
<body onload='j()'>
</body>