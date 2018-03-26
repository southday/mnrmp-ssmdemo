$(function(){
	var i1=1;
	$("#showDisplay1").click(function(){
		i1++;
		$("#display1").slideToggle(500);
		if(i1%2==0)
		{
		$("#display1").children(".left_row_img_arrow").attr("src","/MNRMP/images/rightarrow.png");
		$("#display1").children(".left_row_img_arrow").css({width:"8px",height:"12px"});
		}else{
		$("#display1").children(".left_row_img_arrow").attr("src","/MNRMP/images/downarrow.png");
		$("#display1").children(".left_row_img_arrow").css({width:"12px",height:"8px"});
		}
	});
	var i2=1;
	$("#showDisplay2").click(function(){
		i2++;
		$("#display2").slideToggle(500);
		if(i2%2==0)
		{
		$("#showDisplay2").children(".left_row_img_arrow").attr("src","/MNRMP/images/rightarrow.png");
		$("#showDisplay2").children(".left_row_img_arrow").css({width:"8px",height:"12px"});
		}else{
		$("#showDisplay2").children(".left_row_img_arrow").attr("src","/MNRMP/images/downarrow.png");
		$("#showDisplay2").children(".left_row_img_arrow").css({width:"12px",height:"8px"});
		}
	});
	var i3=1;
	$("#showDisplay3").click(function(){
		i3++;
		$("#display3").slideToggle(500);
		if(i3%2==0)
		{
		$("#display3").children(".left_row_img_arrow").attr("src","/MNRMP/images/rightarrow.png");
		$("#display3").children(".left_row_img_arrow").css({width:"8px",height:"12px"});
		}else{
		$("#display3").children(".left_row_img_arrow").attr("src","/MNRMP/images/downarrow.png");
		$("#display3").children(".left_row_img_arrow").css({width:"12px",height:"8px"});
		}
	});
	var i4=1;
	$("#showDisplay4").click(function(){
		i4++;
		$("#display4").slideToggle(500);
		if(i4%2==0)
		{
		$("#display4").children(".left_row_img_arrow").attr("src","/MNRMP/images/rightarrow.png");
		$("#display4").children(".left_row_img_arrow").css({width:"8px",height:"12px"});
		}else{
		$("#display4").children(".left_row_img_arrow").attr("src","/MNRMP/images/downarrow.png");
		$("#display4").children(".left_row_img_arrow").css({width:"12px",height:"8px"});
		}
	})
	
	
	
	
});


