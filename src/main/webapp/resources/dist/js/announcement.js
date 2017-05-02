$(document).ready(function(){
	$('#myTabs a').click(function (e) {
		e.preventDefault();
		$(this).tab('show');
		var clickBtn = $(this).html();
		if("查看公告" == clickBtn){
			$("#annoumcementContent").load("content.do?dispatch=toViewAnnouncement");
		} else if("修改公告" == clickBtn){
			$("#annoumcementContent").load("content.do?dispatch=toModifyOrAddAnnouncement");
		} else if("新增公告" == clickBtn){
			$("#annoumcementContent").load("content.do?dispatch=toModifyOrAddAnnouncement");
		}
	});
});