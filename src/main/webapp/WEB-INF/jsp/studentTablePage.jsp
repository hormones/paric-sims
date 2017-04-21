<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="resources/bootstrap-table-v1.11.1/dist/bootstrap-table.min.css">
<link rel="stylesheet" type="text/css" href="resources/bootstrap-table-v1.11.1/dist/locale/bootstrap-table-zh-CN.min.js">

<script type="text/javascript" src="resources/bootstrap-table-v1.11.1/dist/bootstrap-table.min.js"></script>

<script type="text/javascript" src="resources/dist/js/studentTablePage.js"></script>

<script>
$(document).ready(function(){
	//初始化表格
	initStudentTable();
	
	$("#studentTable").delegate(".studentTableBtn","click",function(){
		var userno = $(this).parent().parent().children(0).html();
		alert(userno);
	});
});

function initStudentTable(){
	$('#studentTable').bootstrapTable({
	    columns: [{
	        field: 'userno',
	        title: '学号'
	    }, {
	        field: 'name',
	        title: '姓名'
	    }, {
	        field: 'class',
	        title: '班级'
	    }, {
	        field: 'gender',
	        title: '性别'
	    }, {
	        field: 'view',
	        title: '查看'
	    }],
	    data: [{
	    	userno: 2017001,
	        name: 'name1',
	        class: '1班',
	        gender: '男',
	        view: '<button type="button" class="studentTableBtn btn btn-default btn-sm">查看</button>',
	    }, {
	    	userno: 2017002,
	        name: 'name2',
	        class: '2班',
	        gender: '女',
	        view: '<button type="button" class="studentTableBtn btn btn-default btn-sm">查看</button>',
	    }]
	});
	loadStudentData(1,"all");
}

function loadStudentData(page,klass){
	$.post("student.do?dispatch=initStudentTable",{"page":page,"klass":klass},function(data){
		var datas = [];
		for(var i=0; i<10; i++) {
            datas.push({
            	userno: 2017001+i,
    	        name: 'name',
    	        class: '2班',
    	        gender: '女',
    	        view: '<button type="button" class="studentTableBtn btn btn-default btn-sm">查看</button>',
//            	userno: data[i].userno,
//    	        name: data[i].name,
//    	        class: data[i].class.name,
//    	        gender: data[i].gender,
//    	        view: '<button type="button" class="btn btn-default btn-sm">查看</button>',
        	});
        }
		$('#studentTable').bootstrapTable('load', datas);
	},"json");
}
</script>

<div>
	<h3>一班</h3>
	<table id="studentTable">
	</table>
	<table class="table">
	<tr><td>
	<!-- 	分页导航 -->
	<div class="box-footer clearfix">
		<nav aria-label="Page navigation">
		  <ul id="dayTableNav" class="pagination pull-right" style="margin:0;">
		    <li>
		      <a class="prePageNavbar" href="javascript:void(0)" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li id="fixPageNavLi">
		      <a  class="fixPageNavbar" href="javascript:void(0)" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		    <span>&nbsp;&nbsp;当前第
			    <select id="getPageBySelect">
				</select>页
			</span>
		    <span id="showTableInfo" style="line-height:30px;">&nbsp;&nbsp;共12页&nbsp;&nbsp;122条数据</span>
		  </ul>
		</nav>
	</div>
	</td></tr>
	</table>
</div>