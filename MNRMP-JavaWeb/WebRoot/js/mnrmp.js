//ajax 表单

function ajaxSubmit(frm, fn) {
		var dataPara = getFormJson(frm);
		$.ajax({
			url: frm.action,
			type: frm.method,
			data: dataPara,
			success: fn
		});
	}

	//将form中的值转换为键值对。
	function getFormJson(frm) {
		var o = {};
		var a = $(frm).serializeArray();
		$.each(a, function () {
			if (o[this.name] !== undefined) {
				if (!o[this.name].push) {
					o[this.name] = [o[this.name]];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	}

	//弹出层提示

    $(function () { 
	$("[data-toggle='popover']").popover();
 });
// 更改验证码
     function changeVerifyCode(){
    	$('#verifyCodeImg').attr("src","/MNRMP/jcaptcha.jpg?r="+(Math.random()));
    }

//检查登录状态
var loginStatus=false;


function checkLoginStatus(){

var url="/MNRMP/user/getLoginedUser.do";
postRequest(url,null,fl);
//已经登录
return sessionStorage.getItem("loginStatus");
}
 

var fl=function LoginStatus(data){
	var userNameLocal="";
	data=eval("("+data+")");
	loginStatus=data.hasLogined;
	sessionStorage.setItem("loginStatus", loginStatus);
	sessionStorage.setItem("userInfo",JSON.stringify(data));
	setCookie("loginStatus", loginStatus);
	if (data.userTypeCode=="COMMON_USER") {
		userNameLocal=data.userName;
	}else if (data.userTypeCode=="RES_MANAGER") {
		userNameLocal=data.managerName;
	}else{
		userNameLocal=data.adminName;
	}
	if (loginStatus) {   
           var navbar=document.getElementById("navbar");
           sessionStorage.setItem("userName", userNameLocal);
           navbar.innerHTML='<li><a href="/MNRMP/htmlfiles/user/personal.html">'+userNameLocal+'</a></li>'
           +'<li><a href="/MNRMP/htmlfiles/user/upload.html">上传视频</a></li>'
           +'<li><a onclick="logout()">退出</a></li>';
           return true;
		}else{
			return false;
		}
}

//退出登录
function logout(){
	var url="/MNRMP/common/logout.do";
	
	postRequest(url,null,f);
	sessionStorage.removeItem("loginStatus");
	window.location.reload(); 
}
//登录退出结果
var f=function logoutResult(data){
	if (data=="true") {
	sessionStorage.removeItem("loginStatus");
	setCookie("loginStatus", false);
	window.location.reload();
	}
   
}

// 时间格式转换器
Date.prototype.format = function (format) {  
    var o = {  
        "M+": this.getMonth() + 1,  
        "d+": this.getDate(),  
        "h+": this.getHours(),  
        "m+": this.getMinutes(),  
        "s+": this.getSeconds(),  
        "q+": Math.floor((this.getMonth() + 3) / 3),  
        "S": this.getMilliseconds()  
    }  
    if (/(y+)/.test(format)) {  
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
    }  
    for (var k in o) {  
        if (new RegExp("(" + k + ")").test(format)) {  
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
        }  
    }  
    return format;
}  


function getDateByLong(longDate) {
    if (longDate == undefined) {  
        longDate = new Date();  
    }  
        longDate=new Date(longDate);
        pattern = "yyyy-MM-dd";  
     
    return longDate.format(pattern).toString();  
}