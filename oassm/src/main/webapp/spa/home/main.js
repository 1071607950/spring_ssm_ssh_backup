/**
 * 
 */
$(document).ready(function(){
	
	$("div#maincontent").load("home.html");
	
	$("ul.treeview-menu li a").on("click",function(event){
		var uri=$(this).attr("href");
		if(uri!="#"){
			$("div#maincontent").load(uri);
		}
		
		event.preventDefault();
		 
	});
	
	
});