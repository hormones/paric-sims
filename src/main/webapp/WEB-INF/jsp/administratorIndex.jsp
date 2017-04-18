<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-datetimepicker.min.css">

<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="resources/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="resources/dist/js/administrator.js"></script>
<script type="text/javascript" src="resources/dist/js/common.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<title>管理员</title>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="showLoginlog navbar-brand" href="#">管理员</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown">教师 <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	          	<li><a href="#">查看全部</a></li>
	            <li class="divider"></li>
	            <li><a href="#">电气与信息工程学院</a></li>
	            <li class="divider"></li>
	            <li><a href="#">土木建筑学院</a></li>
	            <li class="divider"></li>
	            <li><a href="#">计算机科学与工程学院</a></li>
			  </ul>
	        </li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown">学生 <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	          	<li><a href="#">查看全部</a></li>
	            <li class="divider"></li>
	            <li><a href="#">电气与信息工程学院</a></li>
	            <li class="divider"></li>
	            <li><a href="#">土木建筑学院</a></li>
	            <li class="divider"></li>
	            <li><a href="#">计算机科学与工程学院</a></li>
	          </ul>
	        </li>
	      </ul>
	      <form class="navbar-form navbar-left" role="search">
	        <div class="form-group">
	          <input id="stuSearch" class="form-control" name="stuSearch" type="text" placeholder="请输入学生学号或姓名">
	        </div>
	        <button type="button" id="stuSearchBtn" class="btn btn-default">搜索</button>
	      </form>
	      <ul class="nav navbar-nav navbar-right">
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=session.getAttribute("user") %> <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a id="revisePwdLink" href="javascript:void(0)">更改密码</a></li>
	            <li class="divider"></li>
	            <li><a href="loginOut">退出</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	
	<div class="showContent" style="margin-top:-10px">
	</div>
</body>
</html>