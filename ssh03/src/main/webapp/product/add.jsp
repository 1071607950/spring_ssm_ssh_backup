<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>增加产品</h1>
<form action="add.do" method="post" autocomplete="off">
产品编码:<input type="text" name="code" required/><br/>
产品名称:<input type="text" name="name" required/><br/>
生产日期:<input type="datetime-local" name="date" required/><br/>
成本单价:<input type="text" name="price" required pattern="\d+(.\d+)?" title="只能输入数字和小数"/><br/>
库存数量:<input type="text" name="qty" required pattern="\d+(.\d+)?" title="只能输入数字和小数"/><br/>
<input type="submit" value="提交"/><br/>
</form>
</body>
</html>