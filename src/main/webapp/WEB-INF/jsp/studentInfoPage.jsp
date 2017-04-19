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
        format: "yyyy-mm-dd hh:ii",
    });
</script>
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label for="stuno" class="col-sm-1 col-md-offset-2 control-label">学号</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="stuno" class="stuno" name="stuno" placeholder="请输入学号"/>
			</div>
			<label for="stuname" class="col-sm-1 col-md-offset-1 control-label">姓名</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="stuname" class="stuname" name="stuname" placeholder="请输入姓名"/>
			</div>
		</div>
		<div class="form-group">
			<label for="stunationality" class="col-sm-1 col-md-offset-2 control-label">民族</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="stunationality" class="stunationality" name="stunationality" placeholder="请输入民族"/>
			</div>
			<label for="stusex" class="col-sm-1 col-md-offset-1 control-label">性别</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="stusex" class="stusex" name="stusex" placeholder="请输入性别"/>
			</div>
		</div>
		<div class="form-group">
			<label for="stucollege" class="col-sm-1 col-md-offset-2 control-label">学院</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="stucollege" class="stucollege" name="stucollege" placeholder="请输入学院"/>
			</div>
			<label for="studepartment" class="col-sm-1 col-md-offset-1 control-label">专业</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="studepartment" class="studepartment" name="studepartment" placeholder="请输入专业"/>
			</div>
		</div>
		<div class="form-group">
			<label for="stuemail" class="col-sm-1 col-md-offset-2 control-label">邮箱</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="stuemail" class="stuemail" name="stuemail" placeholder="请输入邮箱"/>
			</div>
			<label for="stuclass" class="col-sm-1 col-md-offset-1 control-label">班级</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="stuclass" class="stuclass" name="stuclass" placeholder="请输入班级"/>
			</div>
		</div>
		<div class="form-group">
		  <div class="col-sm-4 col-md-offset-2">
			<label for="stubirth" class="col-sm-3 control-label">出生日期</label>
            <div class="input-group date form_datetime col-md-6">
	            <input type="text" class="form-control" id="stubirth" class="stubirth" name="stubirth" placeholder="请输入出生日期"/>
	            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
				<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
            </div>
          </div>
          <div class="col-sm-4">
			<label for="stuintime" class="col-sm-3 control-label">入学时间</label>
			<div class="input-group date form_datetime col-sm-6">
				<input type="text" class="form-control" id="stuintime" class="stuintime" name="stuintime" placeholder="请输入入学时间"/>
				<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
				<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			</div>
		  </div>
		</div>
		<div class="form-group">
			<label for="stupolitics" class="col-sm-1 col-md-offset-2 control-label">政治面貌</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="stupolitics" class="stupolitics" name="stupolitics" placeholder="请输入政治面貌"/>
			</div>
			<label for="stuIDnumber" class="col-sm-1 col-md-offset-1 control-label">身份证号</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="stuIDnumber" class="stuIDnumber" name="stuIDnumber"/>
			</div>
		</div>
		<div class="form-group">
			<label for="stucomefrom" class="col-sm-1 col-md-offset-2 control-label">生源地</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="stucomefrom" class="stucomefrom" name="stucomefrom" placeholder="请输入家庭地址"/>
			</div>
			<label for="stuhomeaddress" class="col-sm-1 col-md-offset-1 control-label">家庭地址</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="stuhomeaddress" class="stuhomeaddress" name="stuhomeaddress" placeholder="请输入生源地"/>
			</div>
		</div>
		<div class="form-group">
			<label for="stunote" class="col-sm-1 col-md-offset-2 control-label">其它</label>
			<div class="col-sm-6">
				<textarea class="form-control" id="stunote" class="stunote" name="stunote"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-1 col-md-offset-8">
				<button type="button" class="form-control btn btn-info" id="saveStuInfoBtn">保存</button>
			</div>
		</div>
	</form>
</body>
</html>