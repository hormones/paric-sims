$(document).ready(function() {
	
	//初始化加载公告
	$(".showContent").load("content.do?dispatch=announcementPage");
	
	//菜单：点击公告
	$("#showAnnouncementPage").click(function() {
		$(".showContent").load("content.do?dispatch=announcementPage");
	});
	
	//菜单：点击修改密码
	$("#showRevisePwdPage").click(function() {
		$(".showContent").load("content.do?dispatch=revisePwdPage");
	});
	
	$(".viewStudentTable").click(function(){
		$(".showContent").load("content.do?dispatch=studentTablePage&klass="+$(this).html());
	});
	
	//菜单：学生管理
	$(".klass").click(function(){
		var klass = $(this).html();
		var department = $(this).parents(".department").children(0).html();
		var college = $(this).parents(".college").children(0).html();
		$(".showContent").load("content.do?dispatch=studentTablePage&college="+college+"&department="+department+"&klass="+klass);
	});
	
	//菜单搜索框：检索学生信息
	$("#stuSearchBtn").click(function(){
		var userno = $("#stuSearch").val();
		viewOneStuInfo(userno);
	});
	
});

//根据学号发送ajax请求返回学生详细信息
function viewOneStuInfo(userno){
	$.post("student.do?dispatch=stuInfoData",{"userno": userno},function(data){
		if(data!=null){
			$(".showContent").load("content.do?dispatch=studentInfoPage",function(e){
				$("#userno").val(data.userno);
				$("#name").val(data.name);
				$("#stunationality").val(data.stunationality);
				$("#stusex").val(data.stusex);
				$("#college").val(data.college);
				$("#department").val(data.department);
				$("#stuemail").val(data.stuemail);
				$("#klassName").val(data.klassName);
				$("#stubirth").val(data.stubirth);
				$("#stuintime").val(data.stuintime);
				$("#stupolitics").val(data.stupolitics);
				$("#stucomefrom").val(data.stucomefrom);
				$("#stuhomeaddress").val(data.stuhomeaddress);
				$("#stuIDnumber").val(data.stuIDnumber);
				$("#stunote").val(data.stunote);
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
