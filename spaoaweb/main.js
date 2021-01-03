var apiroot = 'http://localhost:8080/oassm/api';
// var apiroot="http://localhost:8080/oassh/api";
var userLoginStatus='N';
var loginuser=null;
$(document).ready(function() {

	function loadHomePage() {
		$.get('home/main.html', function(resultData) {
			$('#maincontent').html(resultData);
		});
	}

	function loadUserLoginPage() {
		$.get('home/login.html', function(resultData) {
			$('#maincontent').html(resultData);

			$('form#LoginForm').attr('action', apiroot + '/employee/login.mvc');

			$('form#LoginForm').ajaxForm(function(resultData) {
				if (resultData.status == 'Y') {
					loginuser=resultData.result;
					loadLeftMenu();
					loadHomePage();
					$('span#LoginUserName').html(loginuser.name);
					$('span#loginstatus').html('已登录');
				}else{
					alert(resultData.message);
				}
			});

		});
	}
	
	function loadLeftMenu() {
		$.get('leftMenu.html', function(resultData) {
			$('div#LeftMenuArea').html(resultData);
			$('ul.vertical-nav-menu li a').on('click', function(event) {
				event.preventDefault();
				var href=$(this).attr('href');
				if(href!='#'){
					$.get(href, function(resultData) {
						$('#maincontent').html(resultData);
					});
				}
			});
		});
	}


	$('ul.vertical-nav-menu li a').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		if (href != '#') {
			$.get(href, function(resultData) {
				$('#maincontent').html(resultData);
			});
		}

	});

	$('button#HomeLink').on('click', function() {
		loadHomePage();
	});

	$('button#UserLoginLink').on('click', function() {
		loadUserLoginPage();
	});

	$('button#UserLoginoutLink').on('click', function() {

		$.getJSON(apiroot + '/logout.mvc', function() {
			$('span#LoginUserName').html('');
			$('span#loginstatus').html('未登录');
		});

		$('div#LeftMenuArea').html('');
		loadUserLoginPage();
	});

	$.getJSON(apiroot + '/checklogin.mvc', function() {
		if (resultData.result == 'N') {
			$('ul.vertical-nav-menu li a').attr('disabled', true);
			$('span#loginstatus').html('未登录');
			loadUserLoginPage();
		} else {
			loadLeftMenu();
			loadHomePage();
		}
	});


});
