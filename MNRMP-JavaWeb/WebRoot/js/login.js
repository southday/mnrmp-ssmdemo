   //ajax表单调用
    $(document).ready(function(){
		$('#loginform').bind('submit', function(){
			ajaxSubmit(this, function(data){ 
	    //登录结果处理
       // alert(data);   
       //登录成功 
       if (data==null) {
        alert("验证码错误!");
       }else {
        if (data.userId==null) {
         alert("用户名或密码错误!");
        }else{
         alert("登录成功");
         $('#myModal').modal('hide');
         window.location.reload();
        }
       }

 
			});
			return false;
		});
		
    });

//提交搜索框
function submitform(){
   document.serachform.submit();
  }