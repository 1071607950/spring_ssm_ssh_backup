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
	<table>
		<thead>
		<tr>
			<th>编号</th>
			<th>编码</th>
			<th>名称</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="dm" items="${departmentList}">
		 <tr>
		 	<td>${dm.no }</td><td>${dm.code }</td><td>${dm.name }</td>
		 	<td><a href="tomodify.do?no=${dm.no }">修改</a></td>
		 </tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="toadd.do">增加部门</a>
</body>
</html>