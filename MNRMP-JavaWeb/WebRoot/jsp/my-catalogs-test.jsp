<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>my-catalogs-test</title>
<script type="text/javascript">
function changeForm(type) {
	var myform = document.getElementById("myform");
	if (type == 1) {
		myform.action = "/MNRMP/user/myAllCatalogs.do";
	} else {
		myform.action = "/MNRMP/user/myCatalogs.do";
	}
}
</script>
</head>
<body>
	<button onclick="changeForm(1)">加载全部目录</button>
	<button onclick="changeForm(2)">加载特定目录</button>
	<form id="myform" action="/MNRMP/user/myAllCatalogs.do" method="get">
		目录id:<input type="text" name="catalogId" value="" /><br />
		<input type="submit" value="获取用户的视频目录" />
	</form>
</body>
</html>