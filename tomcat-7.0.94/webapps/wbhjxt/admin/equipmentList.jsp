<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>设备管理</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
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
	<%@include file="head.jsp"%>
	<div>
		<div class="content clearfix">
			<div class="widget widget-table action-table">
				<div class="widget-header">
					<i class="icon-th-list"></i>

					<h3>设备管理</h3>

				</div>
				<!-- /widget-header -->
				<div class="widget-content">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th width="10%">设备编号</th>
								<th width="20%">设备名字</th>
								<th width="20%">设备状态</th>
								<th width="15%">设备类型</th>

								<th width="20%" class="td-actions">操作
									<button class="btn btn-primary" onclick="showAddDia('myModal')">添加设备</button>
									|
									<button class="btn btn-primary"
										onclick="showSearch('bookSearch')">查找设备</button> |<a
									href="/wbhjxt/equ/equ-queryAll">刷新</a>
								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="equList" var="list">
								<tr>
									<td><s:property value="#list.equ_id" /></td>
									<td><s:property value="#list.equ_name" /></td>
									<td><s:property value="#list.equ_sta" /></td>
									<td><s:property value="#list.equ_type" /></td>
									<td><a href="" role="button" class="btn"
										data-toggle="modal"
										onclick="showDia('myModal','<s:property value="#list.equ_id"/>','<s:property value="#list.equ_id"/>','<s:property value="#list.equ_name"/>','<s:property value="#list.equ_sta" />','<s:property value="#list.equ_type"/>')">修改</a>
										|<a
										href="<%=path %>/equ/equ-delete.action?equ.equ_id=<s:property value="#list.equ_id" />">
											删除</a>
								</tr>
								<span style="color: red">${msg}</span>
							</s:iterator>

							<tr>
								<td colspan="8">第${requestScope.pageNumber }页/共${requestScope.totalPage }页
									<c:if
										test="${requestScope.pageNumber==1 || requestScope.totalPage==0 }">
					  					首页|上一页
					  				</c:if> <c:if
										test="${requestScope.pageNumber!=1 && requestScope.totalPage!=0 }">
										<a
											href="<%=path %>/equ/equ-queryAll.action?pageNumber=1">首页</a>  |
					  					<a
											href="<%=path %>/equ/equ-queryAll.action?pageNumber=${requestScope.pageNumber-1 }">上一页</a>
									</c:if> <c:if
										test="${requestScope.pageNumber==requestScope.totalPage || requestScope.totalPage==0 }">
					  					下一页|尾页
					  				</c:if> <c:if
										test="${requestScope.pageNumber!=requestScope.totalPage && requestScope.totalPage!=0 }">
										<a
											href="<%=path %>/equ/equ-queryAll.action?pageNumber=${requestScope.pageNumber+1 }">下一页</a>  |
					  					<a
											href="<%=path %>/equ/equ-queryAll.action?pageNumber=${requestScope.totalPage }">尾页</a>
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
			<h3 id="myModalLabel">编辑</h3>
		</div>
		<div class="modal-body">

			<div class="content clearfix">

				<form action="<%=path %>/equ/equ-update.action"
					method="post" id="updateForm">

					<table class="table table-striped table-bordered">

						<tr>
							<td>设备编号</td>
							<td><input type="text" id="bookISBN" name="equ.equ_id"
								value="" placeholder="Id" class="login" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>客户名字</td>
							<td><input type="text" id="bookBname"
								name="equ.equ_name" value="" placeholder="Name" /></td>
						</tr>
						<tr>
							<td>客户地址</td>
							<td><input type="text" id="bookCompile"
								name="equ.equ_type" value="" placeholder="Password" /></td>
						</tr>
						<tr>
							<td>客户电话</td>
							<td><input type="text" id="bookCount"
								name="equ.equ_type" value="" placeholder="Telephone" /></td>
						</tr>
						<tr>
							<td>客户Email</td>
							<td><input type="text" id="bookPress"
								name="equ.equ_sta" value="" placeholder="Email" /></td>
						</tr>
					</table>
				</form>
			</div>
			<!-- /content -->
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			<button class="btn btn-primary" onclick="submitForm('updateForm')">保存</button>
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

				<form action="<s:url action="borrow" method="add"/>" method="post"
					id="addBorrowForm">

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
			<h3>查找设备</h3>
		</div>
		<div class="modal-body">
			<div class="content clearfix">

				<form action="<%=path %>/equ/equ-queryByKey.action"
					method="post" id="searchForm">

					<table class="table table-striped table-bordered">
						<tr>
							<td>设备名称</td>
							<td><input type="text" id="bookName" name="key" value=""
								placeholder="客户名字" class="login" /></td>
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



	<input type="hidden" id="resultMessage" value="${resultMessage}" />

	<!-- 借阅model结束 -->
	<script src="<%=path %>/js/jquery-1.7.2.min.js"></script>
	<script src="<%=path %>/js/bootstrap.js"></script>

	<script src="<%=path %>/js/signin.js"></script>

</body>
<script>
	$(document).ready(function() {
		if ($('#resultMessage').val() != "") {
			alert($('#resultMessage').val());
		}
	});
	//显示修改的对话框，传入两个参数，第一个是模态对话框的ID，另一个是书籍的ID
	function showDia(a, b, c, d, e, f, g) {
		$('#' + a).modal('show');
		$('#bookBid').val(b)
		$('#bookISBN').val(c);
		$('#bookBname').val(d);
		$('#bookCompile').val(e);
		$('#bookCount').val(f);
		$('#bookPress').val(g);
		$('#updateForm').attr("action", "<%=path %>/equ/equ-update.action");
	}

	function submitForm(a) {
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
		$('#updateForm').attr("action", "<%=path %>/equ/equ-add.action");
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
</script>
</html>
