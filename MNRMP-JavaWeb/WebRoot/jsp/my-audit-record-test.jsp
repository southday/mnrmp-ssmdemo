<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>my-audit-record-test</title>
</head>
<body>
	<form action="/MNRMP/resManager/myAudits.do" method="get">
		审核状态:
		<select name="statusCode">
			<option value="REVIEWING" selected="true">未审核</option>
			<option value="ACCEPTED">已接受</option>
			<option value="REFUSED">已拒绝</option>
		</select><br />
		当前页面：
		<input type="radio" name="curPageNo" value="1" />第1页 
		<input type="radio" name="curPageNo" value="2" />第2页 
		<input type="radio" name="curPageNo" value="3" />第3页 
		<input type="radio" name="curPageNo" value="4" />第4页 
		<input type="radio" name="curPageNo" value="5" />第5页<br />
		搜索关键字：<input type="text" name="searchKeyword" value="" /><br />
		<br /><input type="submit" value="获取审核记录" />
	</form>
</body>
</html>