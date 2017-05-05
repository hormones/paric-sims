<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
$(document).ready(function(){
	<%-- 初始化wangEditor.js --%>
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
    
    <%-- 修改和新增公告 --%>
	$("#saveAnnouncementBtn").click(function(){
		$.post("announcement.do?dispatch=modifyOrAddAnnouncement", $("#announcementForm").serialize(), function(data){
			if(data.success){
				$(".showContent").load("content.do?dispatch=toAnnouncement");
			}
		},"json");
	});
})
</script>

<form id="announcementForm" class="form-horizontal" role="form">
	<div class="form-group" style="margin-top: 10px;">
		<div class="col-sm-12 text-center">
			<h2>
				<c:if test="${empty announcement}">新增公告</c:if>
				<c:if test="${not empty announcement}">
					修改公告
					<input style="display: none;" type="text" id="id" class="id" name="id" value="${announcement.id }"/>
				</c:if>
			</h2>
		</div>
	</div>
	<div class="form-group" style="margin-top: 20px;">
		<label for="name" class="col-sm-1 control-label">标题</label>
		<div class="col-sm-11">
			<input type="text" id="name" class="name form-control" name="name" value="${announcement.name }" placeholder="请输入标题"/>
		</div>
	</div>
	<div class="form-group" style="margin-top: 40px;">
		<label for="content" class="col-sm-1 control-label">内容</label>
		<div class="col-sm-11">
			<textarea id="content" class="content form-control" name="content" rows="15">${announcement.content }</textarea>
		</div>
	</div>
	<div class="form-group" style="margin-top: 40px;">
		<div class="col-sm-2 col-md-offset-10">
			<button type="button" id="saveAnnouncementBtn" class="form-control btn btn-info">保存</button>
		</div>
	</div>
</form>