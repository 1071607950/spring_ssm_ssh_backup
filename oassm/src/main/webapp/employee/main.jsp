<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.city.oa.hr.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<jsp:include page="../include/head.jsp" />
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
  <jsp:include page="../include/header.jsp"></jsp:include>
  
  <!-- Left side column. contains the logo and sidebar -->
  <jsp:include page="../include/left.jsp"></jsp:include>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>员工管理</h1>      
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">员工列表</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>序号</th>
                  <th>账户</th>
                  <th>姓名</th>
                  <th>性别</th>
                  <th>年龄</th>
                  <th>工资</th>
                  <th>生日</th>
                  <th>状态</th>
                  <th>照片</th>
                  <th>操作</th>
                </tr>
                </thead>
                <tbody>
               <c:forEach items="${emplist}" var="em" varStatus="st">
                <tr>
                  <td>${st.count}</td>
                  <td>${em.id }</td>
                  <td>${em.name}</td>
                  <td>${em.sex}</td>
                  <td>${em.age }</td>
                  <td><fmt:formatNumber value="${em.salary }" pattern="###,###.##"></fmt:formatNumber> </td>
                  <td><fmt:formatDate value="${em.birthday }" />  </td>
                  <td>
                    <c:if test="${em.age<18}"> 少年</c:if> 
                    <c:if test="${em.age>=18 and em.age<=35}"> 青年 </c:if>
					<c:if test="${em.age>35 }">壮年</c:if>                    
                  </td>
                  <td>
                    <c:if test="${em.photoContentType!=null }">有</c:if>
                    <c:if test="${em.photoContentType==null }">无</c:if>
                  </td>
                  <td>
                    <a href="tomodify.mvc?id=${em.id}" class="btn btn-default">修改</a>
                    <a href="todelete.mvc?id=${em.id}" class="btn btn-default">删除</a>
                    <a href="toview.mvc?id=${em.id}" class="btn btn-default">查看</a>
                  </td>
                </tr>
                </c:forEach>
               
              
              </table>
              <a href="toadd.mvc" class="btn btn-default">增加</a>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

          
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <jsp:include page="../include/footer.jsp"></jsp:include>

  <!-- Control Sidebar -->
  <jsp:include page="../include/aside.jsp"></jsp:include>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<jsp:include page="../include/script.jsp"></jsp:include>
</body>
</html>
