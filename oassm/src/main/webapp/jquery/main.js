/*
 * jQquery 调用REST API测试  
 */
$(function(){
	
	//测试ajax
	$.ajax({
		url:"http://localhost:8080/oassm/api/department/get.mvc",
		data:{no:1},
		method:"GET",
		dataType:"json",
		
	}).done(function(resultData,textStatus, jqXHR){
		
		var viewdata="<div>部门名称："+resultData.result.name+"<td>";
		viewdata+="<div>状态："+resultData.status+"<td>";
		viewdata+="<div>操作信息："+resultData.message+"<td>";
		
		$("div#area01").html(viewdata);
		
	}).fail(function(jqXHR, textStatus, errorThrown ) {
		alert("ERROR01");
		alert(textStatus);
	});
	
	//测试getJSON
	$.getJSON("../api/department/get.mvc",{no:1},function(resultData){
		var viewdata="<div>部门名称："+resultData.result.name+"<td>";
		viewdata+="<div>状态："+resultData.status+"<td>";
		viewdata+="<div>操作信息："+resultData.message+"<td>";
		$("div#area02").html(viewdata);		
	});
	//测试get
	$.get("../api/department/get.mvc",{no:1},function(resultData){
		var viewdata="<div>部门名称："+resultData.result.name+"<td>";
		viewdata+="<div>状态："+resultData.status+"<td>";
		viewdata+="<div>操作信息："+resultData.message+"<td>";
		$("div#area03").html(viewdata);		
	},"json");
	
	//测试post
	$.post("../api/department/add.mvc",{code:"DD99",name:"军工部"},function(resultData){
		var viewdata="<div>状态："+resultData.status+"<td>";
		viewdata+="<div>操作信息："+resultData.message+"<td>";
		$("div#area04").html(viewdata);		
	},"json");
	//使用$.get函数替代$.load函数
	$.get("subfunction.html",{no:1},function(resultData){
		$("div#area05").html(resultData);
	});
	
	//使用jquery form拦截表单提交
	$('form#departmentAddForm').ajaxForm(function(resultData) {
        alert(resultData.message);
    });
	
	
});
