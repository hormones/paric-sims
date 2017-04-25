function initTable(college, department, klassName) {
	//先销毁表格  
	$('#studentTable').bootstrapTable('destroy');
	//初始化表格,动态从服务器加载数据  
	$("#studentTable").bootstrapTable({
		method: "get", //使用get请求到服务器获取数据  
		url: "student.do?dispatch=viewStudentTable", //获取数据的Servlet地址  
		striped: true, //是否表格显示条纹 
		cache: false, //是否使用缓存，默认为true
		sortOrder: "asc", //排序方式
		uniqueId: "userno", //每一行的唯一标识，一般为主键列
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
				college : college,
				department : department,
				klassName : klassName,
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

//操作一列增加2个按钮：查看和删除
function operateFormatter(value, row, index) {
    return [
        '<button type="button" class="viewStudentDetail btn btn-default  btn-sm" style="margin-left:15px;">查 看</button>',
        '<button type="button" class="deleteStudent btn btn-default  btn-sm" style="margin-left:15px;">删 除</button>',
   ].join('');
};

//为查看和删除按钮添加事件
window.operateEvents = {
	'click .viewStudentDetail': function (e, value, row, index) {
		viewOneStuInfo(row.userno);
	},
	'click .deleteStudent': function (e, value, row, index) {
		viewOneStuInfo(row.userno);
	},
};