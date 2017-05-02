<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="resources/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">

<script type="text/javascript" src="resources/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="resources/bootstrap-datetimepicker/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="resources/dist/js/studentInfo.js"></script>

<form class="form-horizontal" role="form">
	<div class="form-group" style="margin-top: 5px;">
		<div class="col-sm-12 text-center">
			<h2>学生个人信息管理</h2>
		</div>
	</div>
	<div class="form-group" style="margin-top: 30px;">
		<label for="userno" class="col-sm-1 col-md-offset-1 control-label">学号</label>
		<div class="col-sm-3">
			<input type="text" id="userno" class="userno form-control" name="userno" placeholder="请输入学号" disabled/>
		</div>
		<label for="name" class="col-sm-1 col-md-offset-1 control-label">姓名</label>
		<div class="col-sm-3">
			<input type="text" id="name" class="name form-control" name="name" placeholder="请输入姓名"/>
		</div>
	</div>
	<div class="form-group" style="margin-top: 30px;">
		<label for="instituteId" class="col-sm-1 col-md-offset-1 control-label">学院</label>
		<div class="col-sm-3">
			<select id="instituteId" class="instituteId form-control" name="instituteId">
				<c:forEach var="institute" items="${instituteList }">
					<option value="${institute.id }">${institute.name }</option>
				</c:forEach>
			</select>
		</div>
		<label for="stusex" class="col-sm-1 col-md-offset-1 control-label">性别</label>
		<div class="col-sm-3">
			<select id="stusex" class="stusex form-control" name="stusex">
				<option value="男">男</option>
				<option value="女">女</option>
			</select>
		</div>
	</div>
	<div class="form-group" style="margin-top: 30px;">
		<label for="majorId" class="col-sm-1 col-md-offset-1 control-label">专业</label>
		<div class="col-sm-3">
			<select id="majorId" class="majorId form-control" name="majorId">
				<c:forEach var="major" items="${majorList }">
					<option value="${major.id }">${major.name }</option>
				</c:forEach>
			</select>
		</div>
		<label for="stunationality" class="col-sm-1 col-md-offset-1 control-label">民族</label>
		<div class="col-sm-3">
			<input type="text" id="stunationality" class="stunationality form-control" name="stunationality" placeholder="请输入民族"/>
		</div>
	</div>
	<div class="form-group" style="margin-top: 30px;">
		<label for="klassId" class="col-sm-1 col-md-offset-1 control-label">班级</label>
		<div class="col-sm-3">
			<select id="klassId" class="klassId form-control" name="klassId">
				<c:forEach var="klass" items="${klassList }">
					<option value="${klass.id }">${klass.name }</option>
				</c:forEach>
			</select>
		</div>
		<label for="stuemail" class="col-sm-1 col-md-offset-1 control-label">邮箱</label>
		<div class="col-sm-3">
			<input type="text" id="stuemail" class="stuemail form-control" name="stuemail" placeholder="请输入邮箱"/>
		</div>
	</div>
	<div class="form-group" style="margin-top: 30px;">
		<label for="stubirth" class="col-sm-1 col-md-offset-1 control-label">出生日期</label>
	    <div class="col-sm-3">
            <div class="input-group date form_datetime">
	            <input type="text" id="stubirth" class="stubirth form-control" name="stubirth" placeholder="请输入出生日期"/>
	            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
				<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
            </div>
           </div>
		<label for="stuintime" class="col-sm-1 col-md-offset-1 control-label">入学时间</label>
           <div class="col-sm-3">
			<div class="input-group date form_datetime">
				<input type="text" id="stuintime" class="stuintime form-control" name="stuintime" placeholder="请输入入学时间"/>
				<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
				<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			</div>
	    </div>
	</div>
	<div class="form-group" style="margin-top: 30px;">
		<label for="stupolitics" class="col-sm-1 col-md-offset-1 control-label">政治面貌</label>
		<div class="col-sm-3">
			<select id="stupolitics" class="stupolitics form-control" name="stupolitics">
				<option value="中共党员">中共党员</option>
				<option value="中共预备党员">中共预备党员</option>
				<option value="共青团员">共青团员</option>
				<option value="无党派人士">无党派人士</option>
				<option value="群众">群众</option>
			</select>
		</div>
		<label for="stuIDnumber" class="col-sm-1 col-md-offset-1 control-label">身份证号</label>
		<div class="col-sm-3">
			<input type="text" id="stuIDnumber" class="stuIDnumber form-control" name="stuIDnumber"/>
		</div>
	</div>
	<div class="form-group" style="margin-top: 30px;">
		<label for="stucomefrom" class="col-sm-1 col-md-offset-1 control-label">生源地</label>
		<div class="col-sm-3">
			<input type="text" id="stucomefrom" class="stucomefrom form-control" name="stucomefrom" placeholder="请输入家庭地址"/>
		</div>
		<label for="stuhomeaddress" class="col-sm-1 col-md-offset-1 control-label">家庭地址</label>
		<div class="col-sm-3">
			<input type="text" id="stuhomeaddress" class="stuhomeaddress form-control" name="stuhomeaddress" placeholder="请输入生源地"/>
		</div>
	</div>
	<div class="form-group" style="margin-top: 30px;">
		<label for="stunote" class="col-sm-1 col-md-offset-1 control-label">备注</label>
		<div class="col-sm-8">
			<textarea id="stunote" class="stunote form-control" name="stunote" rows="4"></textarea>
		</div>
	</div>
	<div class="form-group" style="margin-top: 30px;">
		<div class="col-sm-1 col-md-offset-9">
			<button type="button" id="saveStuInfoBtn" class="form-control btn btn-info">保存</button>
		</div>
	</div>
</form>