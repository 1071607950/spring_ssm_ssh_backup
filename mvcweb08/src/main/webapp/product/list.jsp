<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.city.oa.hr.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<jsp:include page="../include/head.jsp" />
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
	<jsp:include page="../include/header.jsp" />
  
  <!-- Left side column. contains the logo and sidebar -->
  <jsp:include page="../include/left.jsp" />

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>产品管理</h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">产品列表</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>编号</th>
                  <th>名称</th>
                  <th>单价</th>
                  <th>数量</th>
                </tr>
                </thead>
                <tbody>
            <c:forEach var="pm" items="${productList}"> 
			  <tr>
			     <td>${pm.no }</td>
			     <td>${pm.name }</td>
			     <td>${pm.price }</td>
			     <td>${pm.qty }</td>
			  </tr>
  			</c:forEach>
  
              </table>
              <a href="toadd.do" class="btn btn-default">增加产品</a>
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
  <jsp:include page="../include/footer.jsp" />

  <!-- Control Sidebar -->
  <jsp:include page="../include/aside02.jsp" />
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<jsp:include page="../include/script.jsp" />
</body>
</html>
    