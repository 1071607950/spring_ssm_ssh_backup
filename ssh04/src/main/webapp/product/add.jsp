<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>产品增加</h1>
<form action="add.do" method="post" autocomplete="off">
产品名称:<input type="text" name="name" required/><br/>
产品单价:<input type="text" name="price" required/><br/>
库存数量:<input type="text" name="qty" required pattern="\d+" title="只能输入数字"/><br/>
产品类别:
<select name="gno">
	<c:forEach items="${CategoryList}" var="category">
		<option value=${category.no }>${category.name }</option>
	</c:forEach>
</select>
<br/>
<input type="submit" value="提交"/><br/>
</form>
</body>
</html>