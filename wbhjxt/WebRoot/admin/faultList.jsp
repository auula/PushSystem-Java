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
<title>故障管理</title>

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

					<h3>故障管理</h3>

				</div>
				<!-- /widget-header -->
				<div class="widget-content">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th width="20%">故障编号</th>
								<th width="20%">故障类型</th>
								<th width="20%">故障描述</th>
								
								<th width="20%" class="td-actions">操作
									<button class="btn btn-primary" onclick="showAddDia('myModal')">添加</button>
									
									<button class="btn btn-primary"
										onclick="showSearch('bookSearch')">查找</button> |<a
									href="/wbhjxt/fau/fau-queryAll">刷新</a>
								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="fauList" var="list">
								<tr>
									<td><s:property value="#list.fault_id" /></td>
									<td><s:property value="#list.fault_type" /></td>
									<td><s:property value="#list.fault_describe" /></td>
								
									<td><a href="" role="button" class="btn"
										data-toggle="modal"
										onclick="showDia('myModal','<s:property value="#list.fault_id"/>','<s:property value="#list.fault_id"/>','<s:property value="#list.fault_type"/>','<s:property value="#list.fault_describe" />')">修改</a>
										|<a href="" role="button" class="btn" data-toggle="modal"
										onclick="showAddBorrow('borrowModel','<s:property value="#list.bid"/>','<s:property value="#list.fault_id"/>')">呼叫</a>
										
										|<a
										href="<%=path %>/fau/fau-delete.action?fault.fault_id=<s:property value="#list.fault_id" />">
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
										<a href="<%=path %>/fau/queryByKey.action?pageNumber=1">首页</a>  |
					  					<a
											href="<%=path %>/fau/fau-queryByKey.action?pageNumber=${requestScope.pageNumber-1 }">上一页</a>
									</c:if> <c:if
										test="${requestScope.pageNumber==requestScope.totalPage || requestScope.totalPage==0 }">
					  					下一页|尾页
					  				</c:if> <c:if
										test="${requestScope.pageNumber!=requestScope.totalPage && requestScope.totalPage!=0 }">
										<a
											href="<%=path %>/fau/fau-queryByKey.action?pageNumber=${requestScope.pageNumber+1 }">下一页</a>  |
					  					<a
											href="<%=path %>/fau/fau-queryByKey.action?pageNumber=${requestScope.totalPage }">尾页</a>
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

				<form action="<%=path %>/fau/fau-update.action" method="post"
					id="updateForm">

					<table class="table table-striped table-bordered">

						<tr>
							<td>故障编号</td>
							<td><input type="text" id="bookISBN" name="fault.fault_id"
								value="" placeholder="Id" class="login" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>故障名字</td>
							<td><input type="text" id="bookBname"
								name="fault.fault_type" value="" placeholder="Name" /></td>
						</tr>
						
						<tr>
							<td>员工描述</td>
							<td><input type="text" id="bookCompile"
								name="fault.fault_describe" value="" placeholder="describe" /></td>
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

<div id="borrowModel" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3>增加故障订单</h3>
		</div>
		<div class="modal-body">

			<div class="content clearfix">

				<form action="<%=path %>/fau/fau-calls.action" method="post" id="addBorrowForm" >
					<input type="hidden" id="call_id" name="fault.fault_id"
								value="" placeholder="id"/>
					<table class="table table-striped table-bordered">
						<tr>
							<td>呼叫次数</td>
							<td>呼叫设备</td>
						</tr>
						<tr>
							<tr>
							<td><input type="text" id="aa" name="call.call_num"
								value="" placeholder="Desc" /></td>
						
							<td><s:select id="bb" list="equList" listKey="equ_id" listValue="equ_name" 
							value="" name="equ.equ_id" theme="simple"></s:select>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<!-- /content -->
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			<button class="btn btn-primary" onclick="submitForm('addBorrowForm')">呼叫</button>
		</div>
	</div>
	<div id="bookSearch" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3>查找</h3>
		</div>
		<div class="modal-body">
			<div class="content clearfix">

				<form action="<%=path %>/fau/fau-queryByKey.action" method="post"
					id="searchForm">

					<table class="table table-striped table-bordered">
						<tr>
							<td>故障名字</td>
							<td><input type="text" id="bookName" name="key" value=""
								placeholder="机组类型" class="login" /></td>
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
	function showDia(a, b, c, d, e, f, g, h, i) {
		$('#' + a).modal('show');
		$('#bookBid').val(b)
		$('#bookISBN').val(c);
		$('#bookBname').val(d);
		$('#bookCompile').val(e);
		$('#bookCount').val(f);
		$('#bookPress').val(g);
		
		$('#updateForm').attr("action", "<%=path %>/fau/fau-update.action");
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

		$('#updateForm').attr("action", "<%=path %>/fau/fau-add.action");
		$('#' + a).modal('show');
	}
	
	function showAddBorrow(a, b, c) {
		$('#' + a).modal('show');
		$('#b_bookBid').val(b)
		$('#call_id').val(c);
	}
	function showSearch(a) {
		$('#' + a).modal('show');
	}
	function validate(){
		
		return true;

}
</script>
</html>
