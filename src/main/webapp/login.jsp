<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">

<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/dist/js/common.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<title>登陆</title>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" role="form" action="character.do?dispatch=login" method="post" >
			<div class="form-group">
				<div class="col-sm-8 col-sm-offset-2">
					<h1 align="center">登录</h1>
				</div>
			</div>
			<div class="form-group">
				<label for="userno" class="col-sm-offset-2 col-sm-2 control-label">账号：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="userno" name="userno"
						placeholder="请输入账号">
				</div>
			</div>
			<div class="form-group">
				<label for="userpwd" class="col-sm-offset-2 col-sm-2 control-label">密码：</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="userpwd" name="userpwd"
						placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<label class="radio-inline"> <input type="radio"
						name="identity" checked="checked" value="Student">
						学生
					</label> <label class="radio-inline"> <input type="radio"
						name="identity" value="Teacher">
						教师
					</label> <label class="radio-inline"> <input type="radio"
						name="identity" value="Administrator">
						管理员
					</label>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<button type="submit" class="btn btn-default" onclick="return loginCheck()">登陆</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>