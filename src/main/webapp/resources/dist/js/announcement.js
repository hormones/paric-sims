$(document).ready(function(){
	$("#toAddAnouncement").click(function(){
		$("#annoumcementContent").load("content.do?dispatch=toModifyOrAddAnnouncement");
	});
	
	$('#myTabs a').click(function (e) {
		e.preventDefault();
		$(this).tab('show');
	});
});