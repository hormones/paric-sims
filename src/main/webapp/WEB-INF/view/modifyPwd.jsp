<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript" src="resources/jquery-validation-1.16.0/dist/jquery.validate.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#reviseBtn").click(function(){
		if(formValidation.form()){
			$.post("character.do?dispatch=modifyPwd",$("#modifyPwdForm").serialize(),function(data){
				if(data.success){
					if(data.result==1){
						$('#modifyPwdForm')[0].reset();
						alert("密码修改成功！");
					} else {
						$('#modifyPwdForm')[0].reset();
						alert("密码修改失败！");
					}
				}
			},"json");
		}
	});
	
	var formValidation = $( "#modifyPwdForm" ).validate({
		rules: {
			oldPwd: {
				required: true,
				rangelength:[6,20],
				remote: {
				    url: "character.do?dispatch=oldPwdBlur",
				    type: "post",
				    dataType: "json",
				},
			},
			newPwd: {
				required: true,
				rangelength:[6,20],
			},
			confirmPwd: {
				required: true,
				rangelength:[6,20],
				equalTo: "#newPwd"
			},
		},
		messages: {
			oldPwd: {
				required: "请输入旧密码",
				rangelength: "密码长度在6-20之间",
				remote:"密码输入错误，请重新输入",
			},
			newPwd: {
				required: "请输入新密码",
				rangelength: "密码长度在6-20之间",
			},
			confirmPwd: {
				required: "请确认密码",
				rangelength: "密码长度在6-20之间",
				equalTo: "两次输入不一致,请重新输入",
			},
		},
		//errorElement: "em",
		errorPlacement: function ( error, element ) {
			error.addClass( "help-block" );

			element.parents( ".col-sm-2" ).addClass( "has-feedback" );
			
			error.insertAfter( element );

			if ( !element.next( "span" )[ 0 ] ) {
				$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
			}
		},
		success: function ( label, element ) {
			if ( !$( element ).next( "span" )[ 0 ] ) {
				$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
			}
		},
		highlight: function ( element, errorClass, validClass ) {
			$( element ).parents( ".col-sm-2" ).addClass( "has-error" ).removeClass( "has-success" );
			$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
		},
		unhighlight: function ( element, errorClass, validClass ) {
			$( element ).parents( ".col-sm-2" ).addClass( "has-success" ).removeClass( "has-error" );
			$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
		}
	});

});
</script>

<div>
	<form id="modifyPwdForm" class="form-horizontal" role="form">
		<div class="form-group">
			<label for="oldPwd" class="col-sm-2 col-md-offset-2 control-label">请输入旧密码：</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="oldPwd" name="oldPwd" placeholder="请输入旧密码"/>
			</div>
		</div>
		<div class="form-group">
			<label for="newPwd" class="col-sm-2 col-md-offset-2 control-label">请输入新密码：</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="newPwd" name="newPwd" placeholder="请输入新密码">
			</div>
		</div>
		<div class="form-group">
			<label for="confirmPwd" class="col-sm-2 col-md-offset-2 control-label">请确认新密码：</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="confirmPwd" name="confirmPwd" placeholder="请确认新密码">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-8">
				<button id="reviseBtn" type="button" class="btn btn-primary">修改</button>
			</div>
		</div>
	</form>
</div>