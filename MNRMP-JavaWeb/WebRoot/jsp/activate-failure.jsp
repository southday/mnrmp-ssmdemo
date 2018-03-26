<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv= "Refresh" content="5;url=http://localhost:8080/MNRMP/index.html">  
<title>激活失败</title>
<script language="javascript">  
var times=6;  
clock();  
function clock() {  
    window.setTimeout('clock()',1000);  
    times = times-1;  
    time.innerHTML = times;  
}  
</script>
</head>
<body>
	<p>
        <span style="color:#7D26CD;font-size:20px">激活失败！激活码错误！将在 </span>  
        <span id= "time" style="color:#FF0000;font-size:30px"> 5 </span>
        <span style="color:#7D26CD;font-size:20px">秒后自动跳转到首页...</span>  
    </p>
</body>
</html>