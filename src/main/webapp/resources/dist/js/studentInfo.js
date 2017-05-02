$(document).ready(function(){
	$(".form_datetime").datetimepicker({
		minView: "month",//设置只显示到月份
		  format : "yyyy-mm-dd",//日期格式
		  autoclose:true,//选中关闭
		  language:  'zh-CN', 
	});
});