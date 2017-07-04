$(document).ready(function(){
	$(".form_datetime").datetimepicker({
		minView: "month",//设置只显示到月份
		  format : "yyyy-mm-dd",//日期格式
		  autoclose:true,//选中关闭
		  language:  'zh-CN', 
	});
	

});

$("#saveStuInfoBtn").click(function(){
	$.post("student.do?dispatch=modifyOrAddStudent",$("#studentInfoForm").serialize(),function(data){
		if(data.success){
			alert("修改成功！");
		}
	},"json");
})