/**
 * 部门主管理JS
 */
$(document).ready(function(){
	var page=1;
	var rows=10;
	var count=0;
	var pageCount=0;
	var departmentNo=0;
	
	//取得并显示员工列表
	function showList(){
		$.getJSON("../../api/department/list/all/page.mvc",{page:page,rows:rows},function(result){
			if(result){
				page=result.page;
				count=result.count;
				pageCount=result.pageCount;
				$("span#Count").html(count);
				$("span#Page").html(page);
				$("span#PageCount").html(pageCount);
				//显示列表
				$.each(result.list,function(i,dm){
					var tr="<tr id='"+dm.no+"'><td>"+dm.no+"</td><td>"+dm.code+"</td><td>"+dm.name+"</td></tr>"
					$("table#DepartmentTable tbody").append(tr);
				});
				//设置行选中事件
				$("table#DepartmentTable tbody tr").on("click",function(){
					departmentNo=$(this).attr("id");
					$("table#DepartmentTable tbody tr").css("background-color","#FFFFFF");
					$(this).css("background-color","#DFDFDF");
				});
				
			}
		});
	}
	//点击增加处理
	
	
	//点击修改处理
	
	
	//点击删除处理
	
	
	//点击查看处理
	
	
	
	//调用部门列表显示
	showList();
	
});