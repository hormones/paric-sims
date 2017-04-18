$(document).ready(function() {
	$("#revisePwdLink").click(function() {
		$(".showContent").load("revisePwd");
	});
	
	//检索学生信息
	$("#stuSearchBtn").click(function(){
		$.post("stuSearch",{"stuno":$("#stuSearch").val()},function(data){
			if(data.success){
				if(data.result[0]!=null){
					$(".showContent").load("studentInfo",function(e){
						$("#stuno").val(data.result[0].stuno);
						$("#stuname").val(data.result[0].stuname);
						$("#stunationality").val(data.result[0].stunationality);
						$("#stusex").val(data.result[0].stusex);
						$("#stucollege").val(data.result[0].stucollege);
						$("#studepartment").val(data.result[0].studepartment);
						$("#stuemail").val(data.result[0].stuemail);
						$("#stuclass").val(data.result[0].stuclass);
						$("#stubirth").val(data.result[0].stubirth);
						$("#stuintime").val(data.result[0].stuintime);
						$("#stupolitics").val(data.result[0].stupolitics);
						$("#stucomefrom").val(data.result[0].stucomefrom);
						$("#stuhomeaddress").val(data.result[0].stuhomeaddress);
						$("#stuIDnumber").val(data.result[0].stuIDnumber);
						$("#stunote").val(data.result[0].stunote);
					});
				} else {
					alert("未检索到学生信息！");
				}
			}
	},"json");
	});
});

function loginCheck(){
	if($("#user").val()=="" || $("#password").val()==""){
		alert("账号或密码不能为空！");
		return false;
	}
};

function searchCheck(){
	if($("#stuSearch").val()==""){
		alert("输入信息不能为空！");
		return false;
	}
};
