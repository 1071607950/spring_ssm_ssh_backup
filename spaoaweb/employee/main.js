// 部门的主管理页面
$(document).ready(function() {
	var page = 1;
	var rows = 3;
	var count = 0;
	var pageCount = 0;
	var employeeId=null;
	//取得部门的列表并显示
	function loadAndShowList() {
		$.getJSON(apiroot + '/employee/list/all/page.mvc', {
			page: page,
			rows: rows
		}, function(resultData) {
			if (resultData != null) {
				count = resultData.count;
				$('span#Count').html(count);
				pageCount = resultData.pageCount;
				$('span#Page').html(page);
				$('span#PageCount').html(pageCount);
				$('table#EmployeeTable tbody').html('');
				$.each(resultData.list, function(index, dm) {
					var tr = '<tr id=\'' + dm.no + '\'><td>' + dm.no + '</td><td>' + dm.code + '</td><td>' + dm.name +
						'</td></tr>';
					$('table#EmployeeTable tbody').append(tr);
				});
				//设置行tr的点击事件
				$('table#EmployeeTable tbody tr').on('click', function() {
					departmentNo = parseInt($(this).attr('id'));
					$('table#EmployeeTable tbody tr').removeAttr('style');
					$(this).css('background-color', '#aaffff');
				});

			}
		});
	}
	//分页导航控制
	$('ul.pagination li a').on('click', function(event) {
		var action = $(this).html();
		$(this).parent().parent().children().removeClass('disabled');
		if (action == '首页') {
			page = 1;
		} else if (action == '上页') {
			if (page > 1) {
				page = page - 1;
			}
		} else if (action == '下页') {
			if (page < pageCount) {
				page = page + 1;
			}
		} else {
			page = pageCount;
		}
		loadAndShowList();

	});

	//点击增加处理
	$('a#departmentAddLink').on('click', function() {
		$.get('department/add.html', function(resultData) {
			$('div#DepartmentDialog').html(resultData);
			/*
			$("form#DepartmentAddForm").on("submit", function(event) {
				event.preventDefault();
				var code = $("form#DepartmentAddForm input[name='code']").val();
				var name = $("form#DepartmentAddForm input[name='name']").val();
				$.post(apiroot+"/department/add.mvc",{code:code,name:name},function(resultData){
					if(resultData.status=="OK"){
						loadAndShowList();
					}
					alert(resultData.message);
					$("div#DepartmentDialog").dialog("close");
					$("div#DepartmentDialog").dialog("destroy");
					$("div#DepartmentDialog").html("");
				});
			});
			*/
			$('form#DepartmentAddForm').attr('action', apiroot + '/department/add.mvc');
			$('form#DepartmentAddForm').ajaxForm(function(resultData) {
				if (resultData.status == 'OK') {
					loadAndShowList();
				}
				alert(resultData.message);
				$('div#DepartmentDialog').dialog('close');
				$('div#DepartmentDialog').dialog('destroy');
				$('div#DepartmentDialog').html('');
			});

			$('div#DepartmentDialog').dialog({
				title: '添加部门',
				width: 500,
				modal: true
			});

			$('button#CancelButton').on('click', function() {
				$('div#DepartmentDialog').dialog('close');
				$('div#DepartmentDialog').dialog('destroy');
				$('div#DepartmentDialog').html('');
			});

		});
	});

	//点击修改连接处理
	$('a#departmentModidyLink').on('click', function() {
		if (departmentNo == 0) {
			alert('请选择要修改的部门');
		} else {
			$.get('department/modify.html', function(resultData) {
				$('div#DepartmentDialog').html(resultData);
				$('form#DepartmentModifyForm').attr('action', apiroot + '/department/modify.mvc');
				//取得选中的部门信息
				$.getJSON(apiroot + '/department/get.mvc', {
					no: departmentNo
				}, function(resultData) {
					if (resultData.status == 'OK') {
						$('form#DepartmentModifyForm input[name=\'no\']').val(resultData.result.no);
						$('form#DepartmentModifyForm input[name=\'code\']').val(resultData.result.code);
						$('form#DepartmentModifyForm input[name=\'name\']').val(resultData.result.name);
					} else {
						alert(resultData.message);
					}
				});
				$('form#DepartmentModifyForm').ajaxForm(function(resultData) {
					if (resultData.status == 'OK') {
						loadAndShowList();
					}
					alert(resultData.message);
					$('div#DepartmentDialog').dialog('close');
					$('div#DepartmentDialog').dialog('destroy');
					$('div#DepartmentDialog').html('');
				});

				$('div#DepartmentDialog').dialog({
					title: '修改部门',
					width: 500,
					modal: true
				});

				$('button#CancelButton').on('click', function() {
					$('div#DepartmentDialog').dialog('close');
					$('div#DepartmentDialog').dialog('destroy');
					$('div#DepartmentDialog').html('');
				});

			});
		}

	});
	//点击删除链接处理
	$('a#departmentDeleteLink').on('click', function() {
		if (departmentNo == 0) {
			alert('请选择要删除的部门');
		} else {
			//删除确认
			var checkresult = confirm('您确认要删除此部门么?');
			if (checkresult) {
				$.post(apiroot + '/department/delete.mvc', {
					no: departmentNo
				}, function(resultData) {
					if (resultData.status == 'OK') {
						departmentNo = 0;
						loadAndShowList();
					} else {
						alert(resultData.message);
					}
				});
			}
		}
	});

	//点击查看链接处理
	$('a#departmentViewLink').on('click', function() {
		if (departmentNo == 0) {
			alert('请选择要查看的部门');
		} else {
			$.get('department/view.html', function(resultData) {
				$('div#DepartmentDialog').html(resultData);

				$.getJSON(apiroot + '/department/get.mvc', {
					no: departmentNo
				}, function(resultData) {
					if (resultData.status == 'OK') {
						$('span#departmentcode').html(resultData.result.code);
						$('span#departmentname').html(resultData.result.name);
					} else {
						alert(resultData.message);
					}
				});


				$('div#DepartmentDialog').dialog({
					title: '查看部门',
					width: 500,
					modal: true
				});

				$('button#CancelButton').on('click', function() {
					$('div#DepartmentDialog').dialog('close');
					$('div#DepartmentDialog').dialog('destroy');
					$('div#DepartmentDialog').html('');
				});
			});
		}
	});

	loadAndShowList();
});
