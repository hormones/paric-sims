$(document).ready(function(){
	
	var announcementId;
	
	initAnnouncement();
	
	$(".viewAnnouncementBtn").click(function (e) {
		e.preventDefault();
		announcementId = $(this).children("input").val();
		$("#annoumcementContent").load("content.do?dispatch=toViewAnnouncement&announcementId=" + announcementId);
	});
	
	$('#myTabs a').click(function (e) {
		e.preventDefault();
		$(this).tab('show');
		var clickBtn = $(this).html();
		if("查看公告" == clickBtn){
			$("#annoumcementContent").load("content.do?dispatch=toViewAnnouncement&announcementId=" + announcementId);
		} else if("修改公告" == clickBtn){
			$("#annoumcementContent").load("content.do?dispatch=toModifyOrAddAnnouncement");
		} else if("新增公告" == clickBtn){
			$("#annoumcementContent").load("content.do?dispatch=toModifyOrAddAnnouncement");
		}
	});
	
	
});

//初始化announcement的Content
function initAnnouncement(){
	$("#annoumcementContent").load("content.do?dispatch=toViewAnnouncement&announcementId=" + announcementId);
}