<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>activate-test</title>
</head>
<body>
	<form action="http://113.55.26.101:8080/MNRMP/common/activate.do" method="get">
		用户id:<input type="text" name="user_id" value="0" /><br />
		激活码:<input type="text" name="activate_code" value="0" /><br />
		<input type="submit" value="激活" />
	</form>
</body>
</html>