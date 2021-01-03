<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.city.oa.hr.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
      <h1>员工修改</h1>      
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">修改员工信息</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <!-- form start -->
            <form class="form-horizontal" action="modify.do" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">账号</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="id" id="inputEmail3" placeholder="">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">密码</label>

                  <div class="col-sm-10">
                    <input type="password" class="form-control" name="password" id="inputPassword3" placeholder="">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" placeholder="">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">性别</label>

                  <div class="col-sm-10">
                    <div class="form-group">
                <label>
                  <input type="radio" name="sex" value="男" class="minimal" checked>男
                </label>
                <label>
                  <input type="radio" name="sex" value="女" class="minimal">女
                </label>                
              </div>
                    
                    
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">年龄</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="age" id="inputEmail3" placeholder="">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">工资</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="salary" id="inputEmail3" placeholder="">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">生日</label>

                  <div class="col-sm-10">
                    <input type="date" class="form-control" name="birthday" id="inputEmail3" placeholder="">
                  </div>
                  </div>
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">部门</label>

                  <div class="col-sm-10">
                     <select class="form-control" name="department">
                    <option>教学部</option>
                    <option>财务部</option>
                    <option>招生部</option>
                    <option>后勤部</option>
                    
                  </select>
                  </div>
                 
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">照片</label>

                  <div class="col-sm-10">
                    <input type="file" class="form-control" name="photo" id="inputEmail3" placeholder="">
                  </div>
                </div>
                
                
                
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="submit" class="btn btn-default">Cancel</button>
                <button type="submit" class="btn btn-info pull-right">Sign in</button>
              </div>
              <!-- /.box-footer -->
            </form>
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
