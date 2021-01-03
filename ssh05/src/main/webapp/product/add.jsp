<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>产品增加</title>
</head>
<body>
<h1>产品增加</h1>
<form action="add.do" method="post" autocomplete="off">
产品名称:<input type="text" name="name" required/><br/>
生产日期:<input type="date" name="date" required><br/>
产品单价:<input type="text" name="price" required pattern="\d+(.\d+)?" title="只能输入数字和小数"/><br/>
库存数量:<input type="text" name="qty" required pattern="\d+" title="只能输入数字"/><br/>
包装类型:<input type="text" name="type" required/><br/>
包装尺寸:<input type="text" name="size" required pattern="\d+" title="只能输入数字"/>(单位:m³)<br/>
销售区域:
<c:forEach items="${AreaList}" var="area">
	<input type="checkbox" name="areas" value=${area.no }>${area.name }
</c:forEach>
<br/>
<input type="submit" value="添加"/><br/>
</form>
</body>
</html>