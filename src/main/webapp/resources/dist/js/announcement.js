/*announcement.jsp*/
$(document).ready(function(){
	
	//初始化查看公告
	$("#annoumcementContent").load("content.do?dispatch=toViewAnnouncement&id=" + announcementId);
	
	//点击滚动公告栏展示内容
	$(".announcementList").on("click",".viewAnnouncementBtn",function(e){
		e.preventDefault();
		$('#myTabs a:first').tab('show');
		announcementId = $(this).children("input").val();
		$("#annoumcementContent").load("content.do?dispatch=toViewAnnouncement&id=" + announcementId);
	});
	
	//公告栏菜单
	$('#myTabs a').click(function (e) {
		e.preventDefault();
		$(this).tab('show');
		var clickBtn = $(this).html();
		if("查看公告" == clickBtn) {
			$("#annoumcementContent").load("content.do?dispatch=toViewAnnouncement&id=" + announcementId);
		} else if("修改公告" == clickBtn) {
			$("#annoumcementContent").load("content.do?dispatch=toModifyOrAddAnnouncement&id=" + announcementId);
		} else if("新增公告" == clickBtn) {
			$("#annoumcementContent").load("content.do?dispatch=toModifyOrAddAnnouncement");
		}
	});
	
});

/*viewAnnouncement.jsp*/

/*modifyOrAddAnnouncement.jsp*/
