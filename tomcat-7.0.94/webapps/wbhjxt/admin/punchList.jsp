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
<title>到岗登记</title>

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

					<h3>到岗登记</h3>

				</div>
				<!-- /widget-header -->
				<div class="widget-content">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
							    <th width="20%">员工姓名</th>
								<th width="20%">班组名称</th>
								<th width="20%">班组类别</th>
								<th width="20%">到岗时间</th>
								
								
								<th width="20%" class="td-actions">操作
									<button class="btn btn-primary" onclick="showAddDia('myModal')">添加</button>
									
									<button class="btn btn-primary"
										onclick="showSearch('bookSearch')">查找</button> |<a
									href="/wbhjxt/punch/punch-queryAll">刷新</a>
								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="punchList" var="list">
								<tr>
								    <td><s:property value="#list.employee。emp_name" /></td>
									<td><s:property value="#list.part.part_name" /></td>
									<td><s:property value="#list.part.part_type" /></td>
									<td><fmt:formatDate value="${list.punch_time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>	
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
										<a href="<%=path %>/punch/punch-queryAll.action?pageNumber=1">首页</a>  |
					  					<a
											href="<%=path %>/punch/punch-queryAll.action?pageNumber=${requestScope.pageNumber-1 }">上一页</a>
									</c:if> <c:if
										test="${requestScope.pageNumber==requestScope.totalPage || requestScope.totalPage==0 }">
					  					下一页|尾页
					  				</c:if> <c:if
										test="${requestScope.pageNumber!=requestScope.totalPage && requestScope.totalPage!=0 }">
										<a
											href="<%=path %>/punch/punch-queryAll.action?pageNumber=${requestScope.pageNumber+1 }">下一页</a>  |
					  					<a
											href="<%=path %>/punch/punch-queryAll.action?pageNumber=${requestScope.totalPage }">尾页</a>
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

				<form action="<%=path %>/punch/punch-queryAll.action" method="post"
					id="updateForm">

					<table class="table table-striped table-bordered">

						<tr>
							<td>员工姓名</td>
							<td><input type="text" id="bookISBN" 
							name="employee.emp_name"
								value="" placeholder="Name"  /></td>
						</tr>
						<tr>
							<td>班组名称</td>
							<td>
								<!-- <input type="text" id="bookCount" name="emp.emp_role"
								value="" placeholder="Role" /> --> <select id="bookCount"
								name="part.part_name">
									<option value="甲">甲</option>
									<option value="乙">乙</option>
									<option value="丙">丙</option>
							</select>
							</td>
						
						<tr>
							<td>班组类别</td>
							<td><select id="bookBname"
								name="part.part_type">
									<option value="早班">早班</option>
									<option value="中班">中班</option>
							    </select>
							</td>
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
		
		$('#updateForm').attr("action", "<%=path %>/punch/punch-punchs.action");
	}

	function submitForm(a) {
		$('#' + a).submit();
	}
	//显示添加的对话框，传入对话框的ID
	function showAddDia(a) {
		var b = "";
		$('#bookBid').val(b)
		$('#bookISBN').val(b);
		$('#bookCount').val(b);
		$('#bookBname').val(b);
		$('#updateForm').attr("action", "<%=path %>/punch/punch-.action");
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
