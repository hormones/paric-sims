<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--初始化wangEditor.js-->
<script type="text/javascript">
    var editor = new wangEditor('content');
 	editor.config.menus = $.map(wangEditor.config.menus, function(item, key) {
 		/* if (item === 'source') {
            return null;
        } */
        if (item === 'video') {
            return null;
        }
        if (item === 'insertcode') {
            return null;
        }
        if (item === 'location') {
            return null;
        }
        return item;
    });
    editor.create();
</script>

<form class="form-horizontal" role="form">
	<div class="form-group" style="margin-top: 10px;">
		<div class="col-sm-12 text-center">
			<h2>新增公告</h2>
		</div>
	</div>
	<div class="form-group" style="margin-top: 20px;">
		<label for="title" class="col-sm-1 control-label">标题</label>
		<div class="col-sm-11">
			<input type="text" id="title" class="title form-control" name="title" placeholder="请输入标题"/>
		</div>
	</div>
		<div class="form-group" style="margin-top: 40px;">
		<label for="content" class="col-sm-1 control-label">内容</label>
		<div class="col-sm-11">
			<textarea id="content" class="content form-control" name="content" rows="15"></textarea>
		</div>
	</div>
	<div class="form-group" style="margin-top: 40px;">
		<div class="col-sm-2 col-md-offset-10">
			<button type="button" id="saveAnnouncementBtn" class="form-control btn btn-info">保存</button>
		</div>
	</div>
</form>