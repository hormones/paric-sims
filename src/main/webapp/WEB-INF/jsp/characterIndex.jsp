<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="resources/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">

<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="resources/bootstrap-datetimepicker/js/bootstrap-datetimepicker.zh-CN.js"></script>

<link rel="stylesheet" type="text/css" href="resources/dist/css/common.css">
<script type="text/javascript" src="resources/dist/js/common.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<title>管理员</title>
</head>
<body id="mainBody">
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
	      <a id="showAnnouncementPage" class="navbar-brand" href="#">公告</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	      	<c:if test="${identity == 'Administrator'}">
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
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown">学生信息 <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		          	<li><a class="viewStudentTable" href="#">查看全部</a></li>
		            <li class="divider"></li>
		            <li class="dropdown-submenu instituteName">
		            	<a tabindex="-1" href="javascript:;">电气与信息工程学院</a>  
	                    <ul class="dropdown-menu">  
	                        <li class="dropdown-submenu majorName">  
	                            <a href="javascript:;">电子信息工程</a>  
	                            <ul class="dropdown-menu"> 
	                            	<li><a class="klassName" href="javascript:;">全部</a></li>
	                            	<li class="divider"></li>  
	                                <li><a class="klassName" href="javascript:;">一班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">二班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">三班</a></li>  
	                            </ul>  
	                        </li>
	                        <li class="divider"></li>  
	                        <li class="dropdown-submenu majorName">  
	                            <a href="javascript:;">电气工程及其自动化</a>  
	                            <ul class="dropdown-menu">  
	                            	<li><a class="klassName" href="javascript:;">全部</a></li>
	                            	<li class="divider"></li>  
	                                <li><a class="klassName" href="javascript:;">一班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">二班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">三班</a></li>  
	                            </ul>  
	                        </li>
	                    </ul>
		            </li>
		            <li class="divider"></li>
		            <li class="dropdown-submenu instituteName">
		            	<a tabindex="-1" href="javascript:;">建筑工程学院</a>  
	                    <ul class="dropdown-menu">  
	                        <li class="dropdown-submenu majorName">  
	                            <a href="javascript:;">城市规划</a>  
	                            <ul class="dropdown-menu">
	                            	<li><a class="klassName" href="javascript:;">全部</a></li>
	                            	<li class="divider"></li>    
	                                <li><a class="klassName" href="javascript:;">一班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">二班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">三班</a></li>  
	                            </ul>  
	                        </li>
	                        <li class="divider"></li>  
	                        <li class="dropdown-submenu majorName">  
	                            <a href="javascript:;">土木工程</a>  
	                            <ul class="dropdown-menu">
	                            	<li><a class="klassName" href="javascript:;">全部</a></li>
	                            	<li class="divider"></li>    
	                                <li><a class="klassName" href="javascript:;">一班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">二班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">三班</a></li>  
	                            </ul>  
	                        </li>
	                    </ul>
		            </li>
		            <li class="divider"></li>
		            <li><a href="#">计算机科学与工程学院</a></li>
		          </ul>
		        </li>
	        </c:if>
	        <c:if test="${identity == 'Teacher'}">
	        	<li><a href="#">个人信息</a></li>
	        	<li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown">学生信息 <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		          	<li><a class="viewStudentTable" href="#">查看全部</a></li>
		            <li class="divider"></li>
		            <li class="dropdown-submenu instituteName">
		            	<a tabindex="-1" href="javascript:;">电气与信息工程学院</a>  
	                    <ul class="dropdown-menu">  
	                        <li class="dropdown-submenu majorName">  
	                            <a href="javascript:;">电子信息工程</a>  
	                            <ul class="dropdown-menu"> 
	                            	<li><a class="klassName" href="javascript:;">全部</a></li>
	                            	<li class="divider"></li>  
	                                <li><a class="klassName" href="javascript:;">一班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">二班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">三班</a></li>  
	                            </ul>  
	                        </li>
	                        <li class="divider"></li>  
	                        <li class="dropdown-submenu majorName">  
	                            <a href="javascript:;">电气工程及其自动化</a>  
	                            <ul class="dropdown-menu">  
	                            	<li><a class="klassName" href="javascript:;">全部</a></li>
	                            	<li class="divider"></li>  
	                                <li><a class="klassName" href="javascript:;">一班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">二班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">三班</a></li>  
	                            </ul>  
	                        </li>
	                    </ul>
		            </li>
		            <li class="divider"></li>
		            <li class="dropdown-submenu instituteName">
		            	<a tabindex="-1" href="javascript:;">建筑工程学院</a>  
	                    <ul class="dropdown-menu">  
	                        <li class="dropdown-submenu majorName">  
	                            <a href="javascript:;">城市规划</a>  
	                            <ul class="dropdown-menu">
	                            	<li><a class="klassName" href="javascript:;">全部</a></li>
	                            	<li class="divider"></li>    
	                                <li><a class="klassName" href="javascript:;">一班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">二班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">三班</a></li>  
	                            </ul>  
	                        </li>
	                        <li class="divider"></li>  
	                        <li class="dropdown-submenu majorName">  
	                            <a href="javascript:;">土木工程</a>  
	                            <ul class="dropdown-menu">
	                            	<li><a class="klassName" href="javascript:;">全部</a></li>
	                            	<li class="divider"></li>    
	                                <li><a class="klassName" href="javascript:;">一班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">二班</a></li>
	                                <li class="divider"></li> 
	                                <li><a class="klassName" href="javascript:;">三班</a></li>  
	                            </ul>  
	                        </li>
	                    </ul>
		            </li>
		            <li class="divider"></li>
		            <li><a href="#">计算机科学与工程学院</a></li>
		          </ul>
		        </li>
		        <li><a href="#">课程信息管理</a></li>	 
		        <li><a href="#">成绩信息管理</a></li>
	        </c:if>
	      </ul>
	      <c:if test="${(identity == 'Administrator') or (identity == 'Teacher')}">
		      <form class="navbar-form navbar-left" role="search">
		        <div class="form-group">
		          <input id="stuSearch" class="form-control" name="stuSearch" type="text" placeholder="请输入学生学号或姓名">
		        </div>
		        <button type="button" id="stuSearchBtn" class="btn btn-default">搜索</button>
		      </form>
	      </c:if>
	      <ul class="nav navbar-nav navbar-right">
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown">${loginUser.name} <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a id="showRevisePwdPage" href="javascript:void(0)">更改密码</a></li>
	            <li class="divider"></li>
	            <li><a href="character.do?dispatch=loginOut">退出</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	<div class="showContent">
	</div>
	<div class="showModal">
	</div>
</body>
</html>