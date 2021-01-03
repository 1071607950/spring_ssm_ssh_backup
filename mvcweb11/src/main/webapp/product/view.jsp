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
      <h1>产品管理</h1>      
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">产品详细信息</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
            	<div class="form-group row">
                	<label for="inputEmail3" class="col-sm-2 control-label">序号</label>
                	<div class="col-sm-10">${pm.no }</div>
				</div>
             	<div class="form-group row">
             		<label for="inputEmail3" class="col-sm-2 control-label">名称</label>
             		<div class="col-sm-10">${pm.name }</div>
              	</div>
                <div class="form-group row">
                	<label for="inputEmail3" class="col-sm-2 control-label">单价</label>
                	<div class="col-sm-10">${pm.price }</div>
                </div>
                <div class="form-group row">
                	<label for="inputEmail3" class="col-sm-2 control-label">数量</label>
                 	<div class="col-sm-10">${pm.qty }  </div>
                </div>
                <div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 control-label">照片</label>
	                <div class="col-sm-10">
	                  <c:if test="${pm.photoContentType!=null}">
		                  <c:if test='${pm.photoIsImage=="Y"}'>
		                   <img src="showphoto.do?no=${pm.no}" width="400px" height="100%" />
		                  </c:if>
		                  <c:if test='${pm.photoIsImage=="N"}'>
		                  <a href="showphoto.do?no=${pm.no}">下载</a>
		                  </c:if>
	                  </c:if> 
	                  <c:if test="${pm.photoContentType==null}">
	                   	无照片
	                  </c:if>
                  </div>
                </div>
                <a href="tolist.do" class="btn btn-default">返回</a>
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
