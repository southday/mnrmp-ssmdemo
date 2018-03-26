
var pageCount=1;
var pageIndex=1;
sessionStorage.setItem("pageCount",pageCount);
function search(){
        checkLoginStatus();
	    getList(1);
}
function getList(pageIndex){
 
 if (pageIndex<1) {
   alert("已经没有上一页了");
  }
  if (pageIndex>(parseInt(sessionStorage.getItem("pageCount")))) {
    alert("已经没有下一页了");
  }
  if (pageIndex>0&&pageIndex<=(parseInt(sessionStorage.getItem("pageCount")))) {
	 var searchKeyword=getParameter();
     var url="/MNRMP/common/loadHomePageVideos.do";
     var parameter=searchKeyword+'&curPageNo='+pageIndex;
   postRequest(url,parameter,f);
  }
}

var f=function getData(data){
  data = eval("("+data+")");
  var searchResult="";
  pageCount=data.totalRecordNum;
  sessionStorage.setItem("pageCount",pageCount);
  pageIndex=parseInt(sessionStorage.getItem("pageIndex"));
  var videoList=data.videoList;
  		 if (data.totalRecordNum > 0) {
			for (var i = 0; i <videoList.length; i++) {
				searchResult+='<div class="col-sm-4" >'
					//图片
	      +'<div class="row-fluid">'
	      +'<a href="/MNRMP/htmlfiles/user/player.html?videoId='+videoList[i].videoId+'&isCommon=1">'
	      +'<img src="/MNRMP/videopic/pics/'+videoList[i].miniatureName+'" class="img-thumbnail" style="height:300px">'
	      +'</a>'
	      +'</div>'
	      +'<div class="row-fluid" >'
	      +'<p id="title" style="height:10px;font-size:16px;"><strong>'+videoList[i].videoTitle+'</strong></p>'
	      +'<div style="height:100px;">'
	      +'<p class="text-warning"><em>详细介绍:</em></p>'
	      +'<div id="detail">'+videoList[i].intro+'</div>'
	      +'</div>'
	      +'</div>'
	      +'</div>'
			}
		} else {
			searchResult = "没有搜索到相关结果";
		}

  
  document.getElementById("searchResult").innerHTML=searchResult;
  NavBar(pageIndex,pageCount);
}

function NavBar(pageIndex,pageCount){
  var Navbar="";
     Navbar += ' <ul class="pager"><li><a onclick="getList(' + (pageIndex - 1) + ')">上一页</a></li>'
                        
             + '<li><a onclick="getList(' + (pageIndex + 1) + ')">下一页</a></li></ul>'

           
    document.getElementById("pageNum").innerHTML=Navbar;
}


function getParameter(){
	var word=decodeURI(document.URL).split("?")[1];
    var keyword=word.split("=")[1]; 
	  var parm=word.split("=")[0];
	  var parameter="";
	  if (parm=="categoryCode") {
	      parameter="categoryCode="+keyword;
	  }else{
	      parameter="searchKeyword="+keyword;
	  }
        switch(keyword){
         case 'FILM':
              keyword="电影";
         break;
         case 'TV_PLAY':
              keyword="电视剧";
         break;
         case 'SPORTS':
              keyword="体育";
         break;
         case 'CARTOON':
              keyword="动漫";
         break;
         case 'SCIENCE_TECHNOLOGY':
              keyword="科技";
         break;
         case 'LIFE':
              keyword="生活";
         break;
         case 'GAME':
              keyword="游戏";
         break;
         case 'ENTERTAINMENT':
              keyword="娱乐";
         break;
          case 'ORIGINAL':
              keyword="原创";
         break;
         case 'DOCUMENTARY':
              keyword="纪实";
         break;
         case 'OTHER':
              keyword="其他";
         break;
        }
          document.title=keyword;
          return parameter;
}