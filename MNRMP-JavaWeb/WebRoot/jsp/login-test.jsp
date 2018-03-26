<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login-test</title>
<script type="text/javascript" src="/MNRMP/js/jquery-2.0.0.min.js"></script>

<script type="text/javascript">
function changeVerifyCode() {
	$('#verifyCodeImg').attr("src", "/MNRMP/jcaptcha.jpg?r=" + (Math.random()));
}

function changeForm(loginType) {
	var myform = document.getElementById("myform");
	switch (loginType) {
	case 1:
		myform.action = "/MNRMP/user/login.do";
	break;
	case 2:
		myform.action = "/MNRMP/resManager/login.do";
	break;
	case 3:
		myform.action = "/MNRMP/sysAdmin/login.do";
	break;
	}
}
</script>
</head>
<body onload="postRequest('/MNRMP/common/getLoginedUser.do', null)">
	<button onclick="changeForm(1)">用户登录</button>
	<button onclick="changeForm(2)">资源管理员登录</button>
	<button onclick="changeForm(3)">系统管理员登录</button>
	<form id="myform" action="/MNRMP/user/login.do" method="post">
		用户名：<input type="text" name="account" /><br />
		密码：<input type="text" name="password" value="" /><br />
		验证码：<input type="text" name="jcaptcha" value="" /><br />
		<input id="rememberMe" type="checkbox" name="rememberMe" value="true" /> <label for="rememberMe">10天内自动登录</label>
		<img id="verifyCodeImg" src="/MNRMP/jcaptcha.jpg" onclick="changeVerifyCode()"/> 
		<br /><input type="submit" value="提交" />
	</form>
	<br />
	<form action="/MNRMP/user/getLoginedUser.do" method="get">
		<input type="submit" value="getLoginedUser" />
	</form>
</body>
</html>