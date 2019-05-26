<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>全流程维保呼叫系统</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!-- /视窗大小 -->
<meta name="apple-mobile-web-app-capable" content="yes">

<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path %>/css/bootstrap-responsive.min.css"
	rel="stylesheet" type="text/css" />

<link href="<%=path %>/css/font-awesome.css" rel="stylesheet">
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
	rel="stylesheet">

<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/pages/signin.css" rel="stylesheet"
	type="text/css">

</head>

<body>

	<div class="navbar navbar-fixed-top">

		<div class="navbar-inner">

			<div class="container">

				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#"> 全流程维保呼叫系统 </a>

			</div>
			<!-- /container -->

		</div>
		<!-- /navbar-inner -->

	</div>
	<!-- /navbar -->



	<div class="account-container">

		<div class="content clearfix">

			<form action="<%=path %>/emp/emp-login" method="post">

				<h1>员工登录</h1>

				<div class="login-fields">

					<p>请输入信息</p>

					<div class="field">
						<label for="username">用户名：</label> <input type="text"
							id="username" name="emp.emp_name" value="" placeholder="员工账号"
							class="login username-field" />
					</div>
					<!-- /field -->

					<div class="field">
						<label for="password">密码：</label> <input type="password"
							id="password" name="emp.emp_pass" value="" placeholder="员工密码"
							class="login password-field" />
					</div>
					<!-- /password -->
					<p style="color: red;">${resultMessage}</p>

				</div>
				<!-- /login-fields -->

				<div class="login-actions">

					<!--<span class="login-checkbox">
					<input id="Field" name="Field" type="checkbox" class="field login-checkbox" value="First Choice" tabindex="4" />
					<label class="choice" for="Field">记住本次登录</label>
				</span>-->

					<button class="button btn btn-success btn-large">登录</button>

				</div>
				<!-- .actions -->



			</form>

		</div>
		<!-- /content -->

	</div>
	<!-- /account-container -->

	<script src="<%=path %>/js/jquery-1.7.2.min.js"></script>
	<script src="<%=path %>/js/bootstrap.js"></script>

	<script src="<%=path %>/js/signin.js"></script>

</body>

</html>
