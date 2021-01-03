<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.city.oa.hr.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            
           	<form class="form-horizontal" action="tolist.do" method="post">
          		<div class="form-group">
                  <label for="inputEmail3" class="col-sm-1 control-label">最低价</label>

                  <div class="col-sm-2">
                    <input type="text" name="low" class="form-control" id="inputEmail3" autocomplete="off" value="${low }">
                  </div>
                  
                  <label for="inputEmail3" class="col-sm-1 control-label">最高价</label>

                  <div class="col-sm-2">
                    <input type="text" name="high" class="form-control" id="inputEmail3" autocomplete="off" value="${high }">
                  </div>
                  <button type="submit" class="col-sm-1 btn btn-info ">提交</button>
                </div>
                
           	</form>
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>产品编号</th>
                  <th>产品名称</th>
                  <th>产品单价</th>
                  <th>产品数量</th>
                  <th>照片</th>
                  <th>操作</th>
                </tr>
                </thead>
                <tbody>
		            <c:forEach var="pm" items="${productList}"> 
					  <tr>
					  	<td>${pm.no }</td>
					    <td>${pm.name }</td>
					    <td>${pm.price }</td>
					    <td>${pm.qty }</td>
						<td>
		                	<c:if test="${pm.photoContentType!=null }">有</c:if>
		                	<c:if test="${pm.photoContentType==null }">无</c:if>
	                 	</td>
	                  	<td>
		                    <a href="toview.do?no=${pm.no}" class="btn btn-primary">查看</a>
	                  	</td>
					  </tr>
		  			</c:forEach>
				</table>
				<div class="row">
			    	<div class="col-sm-12">
						<nav>
						  <ul class="pagination justify-content-end">
						  
						  	<li class="page-item"><span id="Count">个数:${count }</span>	<span id="Page">页数:${page }</span><span>/</span><span id="PageCount">${pagecount }</span></li>
						    <li class="page-item"><a class="page-link" href="tolist.do?page=1&low=${low }&high=${high }">首页</a></li>
						    <li class="page-item"><a class="page-link" href="tolist.do?page=${page-1<=0?1:page-1 }&low=${low }&high=${high }">上页</a></li>
						    <li class="page-item"><a class="page-link" href="tolist.do?page=${page+1>=pagecount+1?1:page+1 }&low=${low }&high=${high }">下页</a></li>
						    <li class="page-item"><a class="page-link" href="tolist.do?page=${pagecount }&low=${low }&high=${high }">末页</a></li>
						  </ul>
						</nav>
				    </div>
				</div>
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
    