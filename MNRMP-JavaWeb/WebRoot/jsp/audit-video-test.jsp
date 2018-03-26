<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>auditVideo-test</title>
</head>
<body>
	<p>需要注意，这里只是测试时使用，正常情况下审核记录会根据managerId加载出来，所以auditId等不是我们填写的</p>
	<form action="/MNRMP/resManager/auditVideo.do" method="post">
		审核id:<input type="text" name="auditId" /><br />
		视频id:<input type="text" name="videoId" /><br />
		审核状态:
		<select name="statusCode">
			<option value="ACCEPTED">接受</option>
			<option value="REFUSED">拒绝</option>
		</select><br />
		审核详情:<input type="text" name="description" /><br />
		<br /><input type="submit" value="提交" />
	</form>
</body>
</html>