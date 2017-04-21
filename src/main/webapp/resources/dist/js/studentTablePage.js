var totalPages=1,currentPage=1;

$(document).ready(function(){
	initPage(20);
})

//click分页
function dataTableNav(){
	console.log("dataTableNav()");
	//click数字
	$("#dayTableNav").delegate(".pageNumber","click",function(){
		if(currentPage != parseInt($(this).children().html())){
			currentPage = parseInt($(this).children().html());
			//initStoreOutData($(this).children().html(),"10",currentDate);
			showPage(currentPage, totalPages);
		}
	});
	//向前一页
	$(".prePageNavbar").click(function(){
		if(currentPage==1){
			alert("已经是第一页了");
		} else {
			currentPage = currentPage-1;
			//initStoreOutData(currentPage,"10",currentDate);
			showPage(currentPage, totalPages);
		}
	});
	//向后一页
	$(".fixPageNavbar").click(function(){
		if(currentPage==totalPages){
			alert("已经是最后一页了");
		} else {
			currentPage = parseInt(currentPage)+1;
			//initStoreOutData(currentPage,"10",currentDate);
			showPage(currentPage, totalPages);
		}
	});
	//click下拉框
	$("#getPageBySelect").change(function(){
		currentPage=$(this).val();
		//initStoreOutData(currentPage,"10",currentDate);
		showPage(currentPage, totalPages);
	});
}

//初始化分页
function initPage(getTotalPages){
	console.log("initPage(getTotalPages)---getTotalPages:"+getTotalPages);
	$(".pageNumber").remove();
	if(getTotalPages<5){
		for(var i=1;i<=getTotalPages;i++){
			$('<li class="pageNumber"><span>'+i+'</span></li>').insertBefore("#fixPageNavLi");
		}
	} else {
		for(var i=1;i<=5;i++){
			$('<li class="pageNumber"><span>'+i+'</span></li>').insertBefore("#fixPageNavLi");
		}
	}
	$(".pageNumber").each(function(index){
		if($(this).children().html()=="1"){
			$(this).addClass("active");
		}
	});
	$("#getPageBySelect").empty();
	for(var i=getTotalPages;i>=1;i--){
		$("#getPageBySelect").append('<option value="'+i+'">'+i+'</option>');
		$("#getPageBySelect").val(1);
	} 
}

//分页展示
function showPage(presentPage,getTotalPages){
	console.log("showPage(presentPage,getTotalPages)---presentPage:"+presentPage+" getTotalPages:"+getTotalPages);
	if(getTotalPages>5){
		if(presentPage>2 && presentPage<getTotalPages-2){
			$(".pageNumber").each(function(index){$(this).children().html(parseInt(presentPage)+index-2);});
		} else if(presentPage<=2){
			$(".pageNumber").each(function(index){$(this).children().html(index+1);});
		} else if(presentPage>=getTotalPages-2){
			$(".pageNumber").each(function(index){$(this).children().html(getTotalPages+index-4);});
		}
	}
	$(".pageNumber").removeClass("active");
	$(".pageNumber").each(function(index){
		if($(this).children().html()==currentPage){
			$(this).addClass("active");
		}
	});
	$("#getPageBySelect").val(presentPage);
}
