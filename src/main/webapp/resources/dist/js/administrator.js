$(document).ready(function() {
/*	$(function() {
		loginlog();
	});*/

/*	$(".showLoginlog").click(function() {
		$(".showContent").empty();
		loginlog();
	});*/

	function loginlog() {
		$.post("dist/txt/loginlog.txt", function(data) {
			$(".showContent").append("<table class='table table-hover'><tbody><caption>登陆日志</caption>"+data+"</tbody></table>");
		});
	};
});