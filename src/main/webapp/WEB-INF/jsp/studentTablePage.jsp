<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="resources/bootstrap-table-v1.11.1/dist/bootstrap-table.min.css">

<script type="text/javascript" src="resources/bootstrap-table-v1.11.1/dist/bootstrap-table.min.js"></script>
<script type="text/javascript" src="resources/bootstrap-table-v1.11.1/dist/locale/bootstrap-table-zh-CN.min.js"></script>

<script type="text/javascript" src="resources/dist/js/studentTablePage.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$(".showModal").load("content.do?dispatch=toAddStudentModal");
	var college = "${college}";
	var department = "${department}";
	var klassName = "${klass}";
	initTable(college, department, klassName);
});
</script> 
<div>
	<ul class="breadcrumb" style="font-size: 18px;">
		<c:if test="${college != 'null'}">
			<li id="college" class="active">${college}</li>
		</c:if>
		<c:if test="${department != 'null'}">
			<li id="department" class="active">${department}</li>
		</c:if>
		<c:if test="${klass != 'null'}">
			<li id="klassName" class="active">${klass}</li>
		</c:if>
	</ul>
</div>
<c:if test="${identity == 'Administrator' }">
	<div id="toolbar" style="margin-left:15px;">
	    <a id="toAddStudentModalBtn" class="btn btn-default" data-toggle="modal" data-target="#myModal">新 增</a>
	</div>
</c:if>
<table id="studentTable">
	<thead>
		<tr>
			<th data-field="userno">学号</th>
			<th data-field="name">姓名</th>
			<th data-field="klassName">班级</th>
			<th data-field="stusex">性别</th>
			<th data-field="operate" data-formatter="operateFormatter" data-events="operateEvents" data-width="20%">操作</th>
		</tr>
	</thead>
</table>