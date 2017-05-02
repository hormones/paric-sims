$(document).ready(function() {
	
	//初始化加载公告
	$(".showContent").load("content.do?dispatch=toAnnouncement");
	
	//菜单：点击公告
	$("#showAnnouncementPage").click(function() {
		$(".showContent").load("content.do?dispatch=toAnnouncement");
	});
	
	//菜单：点击修改密码
	$("#showRevisePwdPage").click(function() {
		$(".showContent").load("content.do?dispatch=toModifyPwd");
	});
	
	$(".viewStudentTable").click(function(){
		$(".showContent").load("content.do?dispatch=toStudentTable&klassName="+$(this).html());
	});
	
	//菜单：学生管理
	$(".klassName").click(function(){
		var klassName = $(this).html();
		var majorName = $(this).parents(".majorName").children(0).html();
		var instituteName = $(this).parents(".instituteName").children(0).html();
		$(".showContent").load("content.do?dispatch=toStudentTable&instituteName="+instituteName+"&majorName="+majorName+"&klassName="+klassName);
	});
	
	//菜单搜索框：检索学生信息
	$("#stuSearchBtn").click(function(){
		var keyword = $.trim($("#stuSearch").val());
		if(0!=keyword.length){
			viewOneStuInfo(keyword);
		} else {
			alert("请输入学号或姓名！");
		}
	});
	
});

//根据学号或姓名发送ajax请求返回学生详细信息
function viewOneStuInfo(keyword){
	$.post("student.do?dispatch=stuInfoData",{"keyword": keyword},function(data){
		if(undefined != data.userno){
			$(".showContent").load("content.do?dispatch=toStudentInfo",function(){
				$("#userno").val(data.userno);
				$("#name").val(data.name);
				$("#stunationality").val(data.nationality);
				$("#stusex").val(data.gender);
				$("#instituteId").val(data.instituteId);
				$("#majorId").val(data.majorId);
				$("#stuemail").val(data.email);
				$("#klassId").val(data.klassId);
				$("#stubirth").val(data.birthday);
				$("#stuintime").val(data.stuintime);
				$("#stupolitics").val(data.politics);
				$("#stucomefrom").val(data.stucomefrom);
				$("#stuhomeaddress").val(data.homeaddress);
				$("#stuIDnumber").val(data.idNumber);
				$("#stunote").val(data.note);
			});
		} else {
			alert("未检索到学生信息！");
		}
	},"json");
};

//简单登陆校验
function loginCheck(){
	if($("#userno").val()=="" || $("#userpwd").val()==""){
		alert("账号或密码不能为空！");
		return false;
	}
};

//简单搜索框输入校验
function searchCheck(){
	if($("#stuSearch").val()==""){
		alert("输入信息不能为空！");
		return false;
	}
};