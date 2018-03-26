<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>checkAccount-test</title>
<script type="text/javascript">
function changeCheck() {
	var checkAccount = document.getElementById("myform");
	var mybutton = document.getElementById("mybutton");
	var show = document.getElementById("show");
	var myinput = document.getElementById("myinput");
	if (mybutton.innerHTML == "检测用户账号") {
		mybutton.innerHTML = "检测用户电子邮箱";
		show.innerHTML = "用户电子邮箱：";
		checkAccount.action = "/MNRMP/common/checkEmail.do";
		myinput.name = "email";
	} else if (mybutton.innerHTML == "检测用户电子邮箱") {
		mybutton.innerHTML = "检测用户账号";
		show.innerHTML = "用户账号：";
		checkAccount.action = "/MNRMP/common/checkAccount.do";
		myinput.name = "account";
	}
}
</script>
</head>
<body>
	<button id="mybutton" onclick="changeCheck()">检测用户账号</button>
	<p id="show">用户账号：
	<form id="myform" action="/MNRMP/common/checkAccount.do" method="post">
		<input id="myinput" type="text" name="account" value="" />
		<br /><input type="submit" value="检测" />
	</form>
</body>
</html>