<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登陆</title>

<script type="text/javascript">
//ajax验证旧密码
$("#oldPassword").blur(function(){
	if($("#oldPassword").val()!=""){
		$.post("oldPasswordBlur",{oldPassword:$("#oldPassword").val()},function(data){
			if(data.success){
				if(data.result==1){
					$("#forIcon_A").removeClass();
					$("#forIcon_A").addClass("glyphicon glyphicon-ok form-control-feedback");
					$("#forIcon_A").css("color","green");
				} else {
					$("#forIcon_A").removeClass();
					$("#forIcon_A").addClass("glyphicon glyphicon-remove form-control-feedback");
					$("#forIcon_A").css("color","red");
				}
			}
		},"json");
	} else {
		$("#forIcon_A").removeClass();
	}
});

//确认密码输入是否一致
$("#comfirmPassword").blur(function(){
	if($("#comfirmPassword").val()!=""){
		if($("#comfirmPassword").val() == $("#newPassword").val()){
			$("#forIcon_B").removeClass();
			$("#forIcon_B").addClass("glyphicon glyphicon-ok form-control-feedback");
			$("#forIcon_B").css("color","green");
		} else {
			$("#forIcon_B").removeClass();
			$("#forIcon_B").addClass("glyphicon glyphicon-remove form-control-feedback");
			$("#forIcon_B").css("color","red");
		}
	} else {
		$("#forIcon_B").removeClass();
	}
});

//修改密码
$("#reviseBtn").click(function(){
	$.post("pwdRevision",$("#pwdRevisionForm").serialize(),function(data){
		if(data.success){
			if(data.result==1){
				alert("密码修改成功！");
			} else {
				alert("密码修改失败！");
			}
		}
},"json");
});
</script>

</head>
<body>
	<form id="pwdRevisionForm" action="" class="form-horizontal" role="form">
		<div class="form-group has-feedback">
			<label for="oldPassword" class="col-sm-2 col-md-offset-2 control-label">请输入旧密码：</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="oldPassword" name="oldPassword" placeholder="请输入旧密码"/>
				<span id="forIcon_A"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="newPassword" class="col-sm-2 col-md-offset-2 control-label">请输入新密码：</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="请输入新密码">
			</div>
		</div>
		<div class="form-group has-feedback">
			<label for="comfirmPassword" class="col-sm-2 col-md-offset-2 control-label">请确认新密码：</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="comfirmPassword" name="comfirmPassword" placeholder="请确认新密码">
				<span id="forIcon_B"></span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-8">
				<button id="reviseBtn" type="button" class="btn btn-default">修改</button>
			</div>
		</div>
	</form>
</body>
</html>