<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="navbar navbar-fixed-top">

	<div class="navbar-inner">

		<div class="container">

			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a> <a class="brand" href="/wbhjxt/admin/main.jsp">全流程维保呼叫系统 </a>


			<div class="nav-collapse">
				<ul class="nav pull-right">

					<li class=""><a href="#" class=""> <i class="icon-user"></i>
							<s:if test="#session.emp!=null">
								<s:property value="#session.emp.emp_name" />,欢迎你
					</s:if>
					</a></li>
					<li class=""><a href="/wbhjxt/admin/index.jsp" class=""> 退出
					</a></li>

				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!-- /container -->
	</div>
	<!-- /navbar-inner -->
</div>
<!-- /navbar -->

<!-- /navbar -->
<div class="subnavbar">
	<div class="subnavbar-inner">
		<div class="container">
			<ul class="mainnav">
				<li><a href="/wbhjxt/admin/main.jsp"><i
						class="icon-dashboard"></i><span>首页</span> </a></li>

				<li><a href="/wbhjxt/call/call-queryByEmp"><i
						class="icon-bar-chart"></i><span>呼叫管理</span> </a></li>
				<li><a href="/wbhjxt/fau/fau-queryAll"><i
						class="icon-bar-chart"></i><span>故障管理</span> </a></li>
	           
				<s:if test="#session.emp.emp_role == '管理员'">
					<li><a href="/wbhjxt/emp/emp-queryAll"><i
							class="icon-user-md"></i><span>员工管理</span> </a></li>
					<li><a href="/wbhjxt/equ/equ-queryAll"><i
							class="icon-bar-chart"></i><span>设备管理</span> </a></li>
					<li><a href="/wbhjxt/part/part-queryByKey1"><i
							class="icon-bar-chart"></i><span>班次管理</span> </a></li>		
				</s:if>
                        <li><a href="/wbhjxt/punch/punch-queryAll"><i
						class="icon-user-md"></i><span>到岗登记</span> </a></li>
						
			</ul>
		</div>
		<!-- /container -->
	</div>
	<!-- /subnavbar-inner -->
</div>