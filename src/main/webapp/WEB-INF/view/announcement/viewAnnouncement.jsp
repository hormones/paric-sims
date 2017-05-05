<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="panel panel-primary" style="margin-top: 15px;">
	<div class="panel-heading">
		<h1 class="panel-title text-center" style="font-size: 30px;">公 告</h1>
	</div>
	<div class="panel-body" style="margin-top: -20px;">
		<h3 class="text-center">${announcement.name }</h3>
		<div style="text-indent: 2em; height: 400px; font-size: 20px; overflow:auto;">
			${announcement.content }
		</div> 
	</div>
	<div class="panel-footer" style="height:40px;"><sapn class="pull-right">${announcement.modifyTime }</sapn></div>
</div>
