<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>呼叫管理</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">

<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css" />

<link href="<%=path %>/css/font-awesome.css" rel="stylesheet">
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
	rel="stylesheet">
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/pages/signin.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/toastr.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="head.jsp"%>
	<div>
		<div class="content clearfix">
			<div class="widget widget-table action-table">
				<div class="widget-header">
					<i class="icon-th-list"></i>

					<h3>呼叫管理</h3>

				</div>
				<!-- /widget-header -->
				<div class="widget-content">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th width="8%">接单员工</th>
								<th width="8%">故障信息</th>
								<th width="8%">设备名称</th>							
								<th width="8%">呼叫时间</th>
								<th width="8%">应答时间</th>
								<th width="8%">修复时间</th>
								<th width="10%">故障描述</th>
								<th width="8%">审核状态</th>
								<th width="8%">维修状态</th>
								<th width="30%" class="td-actions">操作
									<button class="btn btn-primary"
										onclick="showSearch('bookSearch')">关键字查找</button>
									
									| <a href="/wbhjxt/call/call-queryAll">查看全部</a>
								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="callList" var="list">
								<tr>
									<td><s:property value="#list.employee.emp_name" /></td>
									<td><s:property value="#list.fault.fault_type" /></td>
									<td><s:property value="#list.equ.equ_name" /></td>
									<td><fmt:formatDate value="${list.call_time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><fmt:formatDate value="${list.reply_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td><fmt:formatDate value="${list.end_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td><s:property value="#list.fault.fault_describe" /></td>
								
									<td><s:property value="#list.call_sta" /></td>
									<td><s:property value="#list.end_sta" /></td>
									<td><a href="" role="button" class="btn"
										data-toggle="modal"
										onclick="showDia('myModal','<s:property value="#list.call_id"/>','<s:property value="#list.call_id"/>','<s:property value="#list.fault.fault_type"/>','<s:property value="#list.equ.equ_name"/>','<s:property value="#list.fault.fault_describe"/>','<s:property value="#list.call_sta"/>','<s:property value="#list.call_time"/>')">审核</a>
										|<a href="" role="button" class="btn"
										data-toggle="modal"
										onclick="showDia2('myModal2','<s:property value="#list.call_id"/>','<s:property value="#list.call_id"/>','<s:property value="#list.call_sta"/>')">操作工确认</a>
										
										|<a href="" role="button" class="btn"
										data-toggle="modal"
										onclick="showDia3('myModal3','<s:property value="#list.call_id"/>','<s:property value="#list.call_id"/>','<s:property value="#list.call_sta"/>')">维修工确认</a>
										
										| <a href="<%=path %>/call/call-delete.action?call.call_id=<s:property value="#list.call_id" />"> 删除</a>
										
								</tr>
								<span style="color: red">${msg}</span>
							</s:iterator>

							<tr>
								<td colspan="8">第${requestScope.pageNumber }页/共${requestScope.totalPage }页
									<c:if test="${requestScope.pageNumber==1 || requestScope.totalPage==0 }">
					  					首页|上一页
					  				</c:if>
					  				<c:if test="${requestScope.pageNumber!=1 && requestScope.totalPage!=0 }">
					  					<a href="<%=path %>/call/call-queryByEmp.action?pageNumber=1">首页</a>  |
					  					<a href="<%=path %>/call/call-queryByEmp.action?pageNumber=${requestScope.pageNumber-1 }">上一页</a>
					  				</c:if>
					  				<c:if test="${requestScope.pageNumber==requestScope.totalPage || requestScope.totalPage==0 }">
					  					下一页|尾页
					  				</c:if>
					  				<c:if test="${requestScope.pageNumber!=requestScope.totalPage && requestScope.totalPage!=0 }">
					  					<a href="<%=path %>/call/call-queryByEmp.action?pageNumber=${requestScope.pageNumber+1 }">下一页</a>  |
					  					<a href="<%=path %>/call/call-queryByEmp.action?pageNumber=${requestScope.totalPage }">尾页</a>
					  				</c:if>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- /widget-content -->
			</div>
		</div>
		<!-- /content -->

	</div>
	<!-- Modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">呼叫订单审核</h3>
		</div>
		<div class="modal-body">

			<div class="content clearfix">

				<form action="<%=path %>/call/call-update.action" method="post" id="updateForm">
					<input type="hidden" value="" id="call_time" name="call.call_time">
					<table class="table table-striped table-bordered">

						<tr>
							<td>呼叫编号</td>
							<td><input type="text" id="bookISBN" name="call.call_id"
								value="" placeholder="Id" class="login" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>故障信息</td>
							<td><input type="text" id="bookBname" name="call.fault.fault_type"
								value="" placeholder="Name" readonly="readonly"/></td>
						</tr>
						<tr>
							<td>呼叫设备</td>
							<td><input type="text" id="bookCompile" name="call.equ.equ_name"
								value="" placeholder="Price" readonly="readonly"/></td>
						</tr>
						
						<tr>
							<td>故障描述</td>
							<td><input type="text" id="bookCount" name="call.equ.equ_describe"
								value="" placeholder="Num" readonly="readonly"/></td>
						</tr>
						<tr>
							<td>呼叫状态</td>
							<td><input type="text" id="bookPress" name="call.call_sta"
								value="" placeholder="call_sta" readonly="readonly"/></td>
							
								
						</tr>
						<tr>
							<td>呼叫时间</td>
							<td><input type="text" id="call_time" name="call.call_time"
								value="" placeholder="Num" readonly="readonly"/></td>
						</tr>
						
					</table>
				</form>
			</div>
			<!-- /content -->
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			<button class="btn btn-primary" onclick="submitForm('updateForm')">审核</button>
		</div>
	</div>
	
	
	<!-- Modal -->
	<div id="myModal2" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">故障维修确认</h3>
		</div>
		<div class="modal-body">

			<div class="content clearfix">

				<form action="<%=path %>/call/call-update2.action" method="post" id="updateForm">
					<input type="hidden" value="" id="call_id" name="call_id">
					<table class="table table-striped table-bordered">

						<tr>
							<td>呼叫编号</td>
							<td><input type="text" id="bookISBN" name="call.call_id"
								value="" placeholder="Id" class="login" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>呼叫状态</td>
						    <td><input type="text" id="call_sta" name="call.call_sta"
								value="" placeholder="call_sta" readonly="readonly"/></td>
						<tr>	
					</table>
				</form>
			</div>
			<!-- /content -->
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			<button class="btn btn-primary" onclick="submitForm('updateForm')">审核</button>
		</div>
	</div>
	
		<!-- Modal -->
	<div id="myModal3" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">维修确认</h3>
		</div>
		<div class="modal-body">

			<div class="content clearfix">

				<form action="<%=path %>/call/call-update3.action" method="post" id="updateForm">
					<input type="hidden" value="" id="call_id" name="call_id">
					<table class="table table-striped table-bordered">

						<tr>
							<td>呼叫编号</td>
							<td><input type="text" id="bookISBN" name="call.call_id"
								value="" placeholder="Id" class="login" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>呼叫状态</td>
						    <td><input type="text" id="call_sta" name="call.call_sta"
								value="" placeholder="call_sta" readonly="readonly"/></td>
						<tr>	
					</table>
				</form>
			</div>
			<!-- /content -->
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			<button class="btn btn-primary" onclick="submitForm('updateForm')">审核</button>
		</div>
	</div>
	<!-- 借阅model -->

	<div id="borrowModel" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3>增加借阅信息</h3>
		</div>
		<div class="modal-body">

			<div class="content clearfix">

				<form action="<s:url action="borrow" method="add"/>" method="post" id="addBorrowForm">

					<table class="table table-striped table-bordered">
						<tr>
							<td>书籍编号</td>
							<td>读者编号</td>
						</tr>
						<tr>
							<td><input type="text" id="b_bookISBN" name="borrow.isbn"
								value="" placeholder="ISBN" class="login" /></td>
							<td><input type="text" id="b_userID" name="borrow.snumber"
								value="" placeholder="读者编号" class="login" /></td>
						</tr>
					</table>
				</form>
			</div>
			<!-- /content -->
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			<button class="btn btn-primary" onclick="submitForm('addBorrowForm')">增加</button>
		</div>
	</div>


<!-- 查找书籍Model -->
	<div id="bookSearch" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3>查找呼叫订单</h3>
		</div>
		<div class="modal-body">
			<div class="content clearfix">

				<form action="<%=path %>/call/call-queryByKey.action" method="post" id="searchForm">

					<table class="table table-striped table-bordered">
						<tr>
							<td>设备名称</td>
							<td><input type="text" id="bookName" name="key"
								value="" placeholder="1-1" class="login" /></td>
						</tr>
						<tr>
							 <td>订单状态</td>
							<td><s:select id="nn" list="{'待审核','已审核'}" name="status" theme="simple"></s:select>
							</td>
						</tr>
						
					</table>
				</form>
			</div>
			<!-- /content -->
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			<button class="btn btn-primary" onclick="submitForm('searchForm')">搜索</button>
		</div>
	</div>
	<!-- 查找书籍Model -->
	<div id="bookSearch1" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3>查找呼叫订单</h3>
		</div>
		<div class="modal-body">
			<div class="content clearfix">

				<form action="<%=path %>/call/call-queryByEmp.action" method="post" id="searchForm1">

					<table class="table table-striped table-bordered">
						<tr>
							<td>经办人姓名</td>
							<td><input type="text" id="bookName" name="truename"
								value="" placeholder="经办人姓名" class="login" /></td>
						</tr>
						<tr>
							 <td>订单状态</td>
							<td><s:select id="nn" list="{'待审核','已审核'}" name="status" theme="simple"></s:select>
							</td>
						</tr>
						
					</table>
				</form>
			</div>
			<!-- /content -->
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			<button class="btn btn-primary" onclick="submitForm1('searchForm1')">搜索</button>
		</div>
	</div>

<!-- 查找书籍Model -->
	<div id="bookSearch2" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3>查找呼叫订单</h3>
		</div>
		<div class="modal-body">
			<div class="content clearfix">

				<form action="<%=path %>/call/call-queryByEqu.action" method="post" id="searchForm2">

					<table class="table table-striped table-bordered">
						<tr>
							<td>设备名称</td>
							<td><input type="text" id="bookName" name="trueequ"
								value="" placeholder="1-1" class="login" /></td>
						</tr>
				<tr>
							 <td>订单状态</td>
							<td><s:select id="nn" list="{'待审核','已审核'}" name="status" theme="simple"></s:select>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<!-- /content -->
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			<button class="btn btn-primary" onclick="submitForm2('searchForm2')">搜索</button>
		</div>
	</div>

	<input type="hidden" id="resultMessage" value="${resultMessage}" />

	<!-- 借阅model结束 -->
	<script src="<%=path %>/js/jquery-1.7.2.min.js"></script>
	<script src="<%=path %>/js/bootstrap.js"></script>

	<script src="<%=path %>/js/signin.js"></script>
	<script src="<%=path %>/js/toastr.min.js"></script>
	
</body>
<script>
	$(document).ready(function() {
		if ($('#resultMessage').val() != "") {
			alert($('#resultMessage').val());
		}
	});
	//显示修改的对话框，传入两个参数，第一个是模态对话框的ID，另一个是书籍的ID
	function showDia(a, b, c, d, e, f, g, i) {
		$('#' + a).modal('show');
		$('#bookBid').val(b)
		$('#bookISBN').val(c);
		$('#bookBname').val(d);
		$('#bookCompile').val(e);
		$('#bookCount').val(f);
		$('#bookPress').val(g);
		
		$('#call_time').val(i);
		$('#updateForm').attr("action", "<%=path %>/call/call-update.action");
	}
	function showDia2(a, b, c,d) {
		$('#' + a).modal('show');
		$('#bookBid').val(b);
		$('#bookISBN').val(c);
		$('#end_sta').val(d);
		$('#updateForm').attr("action", "<%=path %>/call/call-update2.action");
	}
	
	function showDia3(a, b, c,d) {
		$('#' + a).modal('show');
		$('#bookBid').val(b);
		$('#bookISBN').val(c);
		$('#end_sta').val(d);
		$('#updateForm').attr("action", "<%=path %>/call/call-update3.action");
	}

	function submitForm(a) {
		$('#' + a).submit();
	}
	function submitForm1(a) {
		$('#' + a).submit();
	}
	function submitForm2(a) {
		$('#' + a).submit();
	}
	//显示添加的对话框，传入对话框的ID
	function showAddDia(a) {
		var b = "";
		$('#bookBid').val(b)
		$('#bookISBN').val(b);
		$('#bookBname').val(b);
		$('#bookCompile').val(b);
		$('#bookCount').val(b);
		$('#bookPress').val(b);
		$('#call_sta').val(b);

		$('#updateForm').attr("action", "<%=path %>/fau/fau-add.action");
		$('#' + a).modal('show');
	}
	function showAddBorrow(a, b, c) {
		$('#' + a).modal('show');
		$('#b_bookBid').val(b)
		$('#b_bookISBN').val(c);
	}
	function showSearch(a) {
		$('#' + a).modal('show');
	}
	function showSearch1(a) {
		$('#' + a).modal('show');
	}
	function showSearch2(a) {
		$('#' + a).modal('show');
	}
	
	toastr.options = {
			"closeButton" : true,
			"debug" : false,
			"progressBar" : true,
			"positionClass" : "toast-top-right",
			"onclick" : null,
			"showDuration" : "400",
			"hideDuration" : "1000",
			"timeOut" : "7000",
			"extendedTimeOut" : "1000",
			"showEasing" : "swing",
			"hideEasing" : "linear",
			"showMethod" : "fadeIn",
			"hideMethod" : "fadeOut"
		};
		
		$(function() {
			
			var t2 = window.setInterval("getPull()", 3000);
		})
		function getPull() {
			$.get('<%=basePath%>fau/fau-pull.action',function (result) {
		        if (result.status == 2000) {
		        	var audio = new Audio();
		        	toastr.success(result.message);
		        	audio.src ='<%=basePath%>MP3/ting.mp3?'+new Date().getTime();
		        	audio.load();
		            audio.play();
		        } else if(result.status == 2001) {
		            toastr.info(result.message);
		        }else{
		        	console.log(result.message);
		        }
		    });
		}
</script>
</html>
