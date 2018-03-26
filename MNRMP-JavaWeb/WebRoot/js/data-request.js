
function postRequest(url,parameter,func)
{
var xmlhttp,data;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
     data=xmlhttp.responseText;
     // alert(data);
     //data=eval("("+data+")");
     func(data);
    }
  }
xmlhttp.open("POST",url,true);
xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xmlhttp.send(parameter);
}

//设置cookie
function setCookie(name,value){ 
	var exp = new Date(); 
	exp.setTime(exp.getTime() + 10*60*60*1000);//有效期1小时 
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();// + ";path=/MNRMP/"; 
}
//取cookies函数 方法 一
function getCookie(key){
  if(key==null)
	  return null;
  if(Object.prototype.toString.call(key)=='[object String]'|| Object.prototype.toString.call(key)=='[object Number]')
  {
	  var arrStr = document.cookie.split(";");
	  for(var i= 0;i<arrStr.length;i++){
		  var temp = arrStr[i].split("=");
		  if(temp[0]==key)
			  return unescape(temp[1]);
	  }
	  return null;
  }
  return null;
}
