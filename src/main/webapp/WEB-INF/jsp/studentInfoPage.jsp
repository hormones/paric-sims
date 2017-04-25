<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>学生信息检索</title>
</head>
<body>
<script type="text/javascript">
    $(".form_datetime").datetimepicker({
    	minView: "month",//设置只显示到月份
    	  format : "yyyy-mm-dd",//日期格式
    	  autoclose:true,//选中关闭
    	  language:  'zh-CN', 
    });
</script>
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label for="userno" class="col-sm-1 col-md-offset-1 control-label">学号</label>
			<div class="col-sm-3">
				<input type="text" id="userno" class="userno form-control" name="userno" placeholder="请输入学号" disabled/>
			</div>
			<label for="name" class="col-sm-1 col-md-offset-1 control-label">姓名</label>
			<div class="col-sm-3">
				<input type="text" id="name" class="name form-control" name="name" placeholder="请输入姓名"/>
			</div>
		</div>
		<div class="form-group">
			<label for="stunationality" class="col-sm-1 col-md-offset-1 control-label">民族</label>
			<div class="col-sm-3">
				<input type="text" id="stunationality" class="stunationality form-control" name="stunationality" placeholder="请输入民族"/>
			</div>
			<label for="stusex" class="col-sm-1 col-md-offset-1 control-label">性别</label>
			<div class="col-sm-3">
				<input type="text" id="stusex" class="stusex form-control" name="stusex" placeholder="请输入性别"/>
			</div>
		</div>
		<div class="form-group">
			<label for="college" class="col-sm-1 col-md-offset-1 control-label">学院</label>
			<div class="col-sm-3">
				<input type="text" id="college" class="college form-control" name="college" placeholder="请输入学院"/>
			</div>
			<label for="department" class="col-sm-1 col-md-offset-1 control-label">专业</label>
			<div class="col-sm-3">
				<input type="text" id="department" class="department form-control" name="department" placeholder="请输入专业"/>
			</div>
		</div>
		<div class="form-group">
			<label for="stuemail" class="col-sm-1 col-md-offset-1 control-label">邮箱</label>
			<div class="col-sm-3">
				<input type="text" id="stuemail" class="stuemail form-control" name="stuemail" placeholder="请输入邮箱"/>
			</div>
			<label for="klassName" class="col-sm-1 col-md-offset-1 control-label">班级</label>
			<div class="col-sm-3">
				<input type="text" id="klassName" class="klassName form-control" name="klassName" placeholder="请输入班级"/>
			</div>
		</div>
		<div class="form-group">
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
		<div class="form-group">
			<label for="stupolitics" class="col-sm-1 col-md-offset-1 control-label">政治面貌</label>
			<div class="col-sm-3">
				<input type="text" id="stupolitics" class="stupolitics form-control" name="stupolitics" placeholder="请输入政治面貌"/>
			</div>
			<label for="stuIDnumber" class="col-sm-1 col-md-offset-1 control-label">身份证号</label>
			<div class="col-sm-3">
				<input type="text" id="stuIDnumber" class="stuIDnumber form-control" name="stuIDnumber"/>
			</div>
		</div>
		<div class="form-group">
			<label for="stucomefrom" class="col-sm-1 col-md-offset-1 control-label">生源地</label>
			<div class="col-sm-3">
				<input type="text" id="stucomefrom" class="stucomefrom form-control" name="stucomefrom" placeholder="请输入家庭地址"/>
			</div>
			<label for="stuhomeaddress" class="col-sm-1 col-md-offset-1 control-label">家庭地址</label>
			<div class="col-sm-3">
				<input type="text" id="stuhomeaddress" class="stuhomeaddress form-control" name="stuhomeaddress" placeholder="请输入生源地"/>
			</div>
		</div>
		<div class="form-group">
			<label for="stunote" class="col-sm-1 col-md-offset-1 control-label">备注</label>
			<div class="col-sm-6">
				<textarea id="stunote" class="stunote form-control" name="stunote"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-1 col-md-offset-8">
				<button type="button" id="saveStuInfoBtn" class="form-control btn btn-info">保存</button>
			</div>
		</div>
	</form>
</body>
</html>