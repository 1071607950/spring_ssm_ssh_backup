<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <c:if test="${sessionScope.userid!=null }"> 
          <p>登录用户:${sessionScope.userid}</p>
          <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
          </c:if>
          <c:if test="${sessionScope.userid==null }">
          <p>登录用户:未登录</p>
          <a href="../login.jsp"><i class="fa fa-circle text-success"></i>登录</a>
          </c:if>
        </div>
      </div>
     
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header"><b>功能选择</b></li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>产品管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../product/tolist.do"><i class="fa fa-circle-o"></i>产品列表</a></li>
            <li><a href="../product/toadd.do"><i class="fa fa-circle-o"></i>增加产品</a></li>
          </ul>
        </li>
      <li class="treeview">
          <a href="../home/tomain.mvc">
            <i class="fa fa-pie-chart"></i>
            <span>返回主页</span>
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
          </a>
         
        </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>