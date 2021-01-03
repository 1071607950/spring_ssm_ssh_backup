<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*" 
    errorPage="error.jsp"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>城市OA系统</title>
</head>
<%
  // int m=10/0;
%>
<body>
<%@ include file="include/header.jsp" %>
<%
   String userid=null; //Cookie中
   String userid01=null; //Session中
   //取得Session中保存的登录账号
   userid01=(String)session.getAttribute("userid");
  
	   Cookie[] cs=request.getCookies();
	   for(Cookie c:cs){
		   out.println(c.getName()+"="+c.getValue()+"<br/>");
			if(c.getName().equals("userid")){
				userid=c.getValue();
			}
	   }
    

   
      
   //取得请求对象中保存的ID
   String userid02=(String)request.getAttribute("userid");
   String uri="department/main.jsp";
%>
登录用户:<%=userid %> <br/>
登录用户:<%=userid01 %> <br/>
登录用户:<%=userid02 %> <br/>
登录用户人数:${usercount } <br/> 
点击次数:${clickcount } <br/> 
<a href="<%=uri %>">部门管理</a><br/>
<a href="">员工管理</a><br/>
<a href="logout.do">注销</a><br/>

<%-- JSP注释 --%>
<!--  HTML注释 -->

</body>
</html>