<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="resources/bootstrap-table-v1.11.1/dist/bootstrap-table.min.css">

<script type="text/javascript" src="resources/bootstrap-table-v1.11.1/dist/bootstrap-table.min.js"></script>
<script type="text/javascript" src="resources/bootstrap-table-v1.11.1/dist/locale/bootstrap-table-zh-CN.min.js"></script>

<script type="text/javascript" src="resources/dist/js/announcementTable.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	initAnnouncementTable();
});

//操作一列增加3个按钮：查看、修改和删除(不能放在$(document).ready()中...)
function operateFormatter(value, row, index) {
	if("Administrator" == "${identity }"){
		return [
		        '<button type="button" class="viewAnnouncementDetail btn btn-default  btn-sm" style="margin-left:15px;">查 看</button>',
		        '<button type="button" class="modifyAnnouncement btn btn-default  btn-sm" style="margin-left:15px;">修 改</button>',
		        '<button type="button" class="deleteAnnouncement btn btn-default  btn-sm" style="margin-left:15px;">删 除</button>',
		     ].join('');
	} else {
		return [
	         	'<button type="button" class="viewAnnouncementDetail btn btn-default  btn-sm" style="margin-left:5%;">查 看</button>',
	         ].join('');
	}
};
</script>

<table id="announcementTable">
	<thead>
		<tr>
			<th data-field="name">标题</th>
			<th data-field="administratorName">管理员</th>
			<th data-field="modifyTime">修改时间</th>
			<th data-field="operate" data-formatter="operateFormatter" data-events="operateEvents" data-width="27%">操作</th>
		</tr>
	</thead>
</table>