function initAnnouncementTable() {
	//先销毁表格
	$('#announcementTable').bootstrapTable('destroy');
	//初始化表格,动态从服务器加载数据  
	$("#announcementTable").bootstrapTable({
		method: "get", //使用get请求到服务器获取数据
		url: "announcement.do?dispatch=viewAnnouncementTable", //获取数据的Servlet地址
		striped: true, //是否表格显示条纹
		cache: false, //是否使用缓存，默认为true
		sortOrder: "asc", //排序方式
		uniqueId: "id", //每一行的唯一标识，一般为主键列
		pagination: true, //是否启动分页
		sidePagination: "server", //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
		paginationPreText: "上一页", //指定分页条中上一页按钮的图标或文字
		paginationNextText: "下一页", //指定分页条中下一页按钮的图标或文字
		showPaginationSwitch: false, //是否显示分页开关
		pageSize: 10, //每页显示的记录数
		pageNumber: 1, //当前第几页
		pageList: [10], //记录数可选列表
		search: false, //是否启用查询
		showColumns: true, //是否显示下拉框勾选要显示的列
		toolbar: "#toolbar", //一个jQuery选择器，指明自定义的工具栏
		showRefresh: false, //是否显示刷新按钮
		undefinedText: "未知", //	当数据为 undefined 时显示的字符
		//设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
		//设置为limit可以获取limit, offset, search, sort, order
		queryParamsType: "undefined",
		queryParams: function queryParams(params) { //设置查询参数
			var param = {
				pageNumber : params.pageNumber,
				pageSize : params.pageSize,
			};
			return param;
		},
		onLoadSuccess: function(data) { //加载成功时执行  
			console.log("加载成功");
		},
		onLoadError: function() { //加载失败时执行  
			console.log("加载数据失败", {
				time: 1500,
				icon: 2
			});
		}
	});
};

//为查看和删除按钮添加事件
window.operateEvents = {
	'click .viewAnnouncementDetail': function (e, value, row, index) {
		$('#myTabs a:first').tab('show');
		announcementId = row.id;
		$("#annoumcementContent").load("content.do?dispatch=toViewAnnouncement&id=" + announcementId);
	},
	'click .modifyAnnouncement': function (e, value, row, index) {
		$('#myTabs li:eq(1) a').tab('show')
		announcementId = row.id;
		$("#annoumcementContent").load("content.do?dispatch=toModifyOrAddAnnouncement&id=" + announcementId);
	},
	'click .deleteAnnouncement': function (e, value, row, index) {
		var statu = confirm("你确定要删除该公告吗?");
		if(statu){
			$.post("announcement.do?dispatch=deleteOneAnnouncement", {"id":row.id}, function(data){
				if(data.success){
					$(".showContent").load("content.do?dispatch=toAnnouncement");
				}
			},"json");
		}
	},
};