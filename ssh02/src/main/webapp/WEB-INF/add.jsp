<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>员工增加</h1>
<form action="add.do" method="post" autocomplete="off">
员工ID:<input type="text" name="id" required/><br/>
员工姓名:<input type="text" name="name" required/><br/>
性别:<input type="radio" name="sex" value="男"/>男
<input type="radio" name="sex" value="女"/>女
<br/>
生日:<input type="date" name="birthday" required/><br/>
年龄:<input type="text" name="age" required pattern="\d{1,2}" title="只能输入1或2位数字"/><br/>
工资:<input type="text" name="salary" required pattern="\d+(.\d+)?" title="只能输入数字和小数"/><br/>
<input type="submit" value="提交"/><br/>
</form>
</body>
</html>