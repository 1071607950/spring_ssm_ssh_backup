<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>客户增加</h1>
<form action="process.do" method="post" autocomplete="off">
客户序号:<input type="text" name="no" /><br/>
客户编码:<input type="text" name="code" required pattern="\d+" title="只能输入数字"/><br/>
客户名称:<input type="text" name="name" required/><br/>
员工人数:<input type="text" name="num" required pattern="\d+" title="只能输入数字"/><br/>
成立日期:<input type="date" name="date" required/><br/>
年销售额:<input type="text" name="yearsales" required pattern="\d+(.\d+)?" title="只能输入数字和小数"/><br/>
注册地址:<input type="text" name="address" required/><br/>
公司电话:<input type="text" name="tel" required/><br/>

<input type="submit" name="action" value="添加" />
<input type="submit" name="action" value="修改" /><br/>
</form>
</body>
</html>