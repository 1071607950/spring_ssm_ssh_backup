<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>登录用户:${userid}</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
     
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">功能选择</li>
        <li class="treeview">
          <a href="../department/tomain.mvc">
            <i class="fa fa-dashboard"></i> <span>部门管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
         
        </li>
        <li class="treeview">
          <a href="../employee/main.jsp">
            <i class="fa fa-files-o"></i>
            <span>员工管理</span>
            <span class="pull-right-container">
              <span class="label label-primary pull-right">4</span>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../employee/tomain.mvc"><i class="fa fa-circle-o"></i>员工列表</a></li>
            <li><a href="../employee/toadd.mvc"><i class="fa fa-circle-o"></i>增加员工</a></li>
           
          </ul>
        </li>
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>爱好管理</span>
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../charts/chartjs.html"><i class="fa fa-circle-o"></i>爱好列表</a></li>
            <li><a href="../charts/morris.html"><i class="fa fa-circle-o"></i>增加爱好</a></li>
            
          </ul>
        </li>
        <li><a href="../home/main.jsp"><i class="fa fa-circle-o text-aqua"></i> <span>返回主页</span></a></li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>