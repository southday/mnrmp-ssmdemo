<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/MNRMP/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript">
function changeVerifyCode() {
	$('#verifyCodeImg').attr("src", "/MNRMP/jcaptcha.jpg?r=" + (Math.random()));
}
</script>

<link rel="stylesheet" href="/MNRMP/css/bootstrap.min.css"> 
<script type="text/javascript" src="/MNRMP/js/bootstrap.min.js"></script>
	<title id="title">用户注册</title>
</head>
<body>
	<hr>
<div class="container-fluid">
<div class="row-fluid">
	<div class="col-md-4" >
	</div>
	<div class="col-md-4" >
	<form class="form-horizontal" role="form" action="/MNRMP/common/register.do"> 
    <div class="form-group"> 
        <label for="user_name"  class="col-sm-4 control-label">用户昵称</label> 
        <div class="col-sm-8"> 
            <input type="text" required="required" class="form-control" name="userName" placeholder="用户昵称"> 
        </div> 
    </div> 
    <div class="form-group"> 
        <label for="account"  class="col-sm-4 control-label">用户账号</label> 
        <div class="col-sm-8"> 
            <input type="text" required="required" class="form-control" name="account" placeholder="用户账号">
        </div> 
    </div> 
    <div class="form-group"> 
        <label for="password"  class="col-sm-4 control-label">密码</label> 
        <div class="col-sm-8"> 
            <input type="text" required="required" class="form-control" name="password" placeholder="密码">
        </div> 
    </div> 
    <div class="form-group"> 
        <label for="birthday"  class="col-sm-4 control-label">生日</label> 
        <div class="col-sm-8"> 
            <input type="date" required="required" class="form-control" name="birthday" placeholder="生日">
        </div> 
    </div> 
      <div class="form-group"> 
        <label for="sex"  class="col-sm-4 control-label">性别</label> 
        <div class="col-sm-8"> 
        <label class="radio-inline">
        	<input type="radio" name="sex" id="optionsRadios1" value="1"> 男
        </label>
        <label class="radio-inline">
        	<input type="radio" name="sex" id="optionsRadios2" value="0"> 女
        </label>
        </div> 
    </div> 
    <div class="form-group"> 
        <label for="email"  class="col-sm-4 control-label">E-mail</label> 
        <div class="col-sm-8"> 
            <input type="email" required="required" class="form-control" name="email" placeholder="E-mail">
        </div> 
    </div> 
    <div class="form-group"> 
        <label for="phone"  class="col-sm-4 control-label">手机号</label> 
        <div class="col-sm-8"> 
            <input type="tel" required="required" class="form-control" name="phone" placeholder="手机号码">
        </div> 
    </div> 
    <div class="form-group"> 
         <label class="col-sm-2 control-label"></label>
    	<div class="col-sm-10">
    		<input class="form-control" type="submit">
    	</div>
    </div>
    验证码：<input type="text" name="jcaptcha" value="" /><br />
		<img id="verifyCodeImg" src="/MNRMP/jcaptcha.jpg" onclick="changeVerifyCode()"/> 
</form>
	</div>
<div class="col-md-4" >
	</div>
	</div>
	</div>
</body>
</html>