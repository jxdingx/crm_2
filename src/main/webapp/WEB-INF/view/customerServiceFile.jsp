<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var selectrow;
	$(function() {
		$('#dg').datagrid({
			toolbar : "#tb",
			method : "post",
			rownumbers : true,
			singleSelect : true,
			fit : true,
			fitColumns : true,
			striped : true,
			pagination : true,
			pageNumber : 1,
			pageSize : 15,
			pageList : [ 15, 20, 30 ],
			onSelect : function(index, row) {
				selectrow = row;
			}
		});
		var p = $('#dg').datagrid('getPager');
		$(p).pagination({
			onSelectPage : function(pageNumber, pageSize) {
				findallcustomer(pageNumber, pageSize);
			}
		});
		$('#win').window({
			title : '服务反馈详情',
			width : 560,
			height : 530,
			closed : true,//初始时是关闭状态
			cache : false,
			modal : true,//模态
			doSize : true,
			border : 'thin',
			yIndex : 300,
			onClose : function() {
				$('#Form').form("clear");
			}
		});
		findallcusService(1, 15);
	});

	function findallcusService(pageNumber, pageSize) {
		$('#dg').datagrid({
			url : 'cusService_find.action',
			queryParams : {
				state : '已归档',
				page : pageNumber,
				rows : pageSize
			}
		});
	}

	function proceService() {
		if (!selectrow) {
			$.messager.alert("操作提示", '请选择一条数据!', "info");
			return;
		}
		$('#Form').form("clear");
		$('#Form').form('load', selectrow);
		$('#win').window("open");
		selectrow = null;
	}

	function WinClose() {
		$('#win').window("close");
	}
</script>
</head>
<body style="margin: 1px;">
	<table id="dg">
		<thead>
			<tr>
				<th data-options="field:'cb',align:'center',checkbox:true"></th>
				<th data-options="field:'id',align:'center',width:'50'">编号</th>
				<th data-options="field:'customer',align:'center',width:'100'">客户</th>
				<th data-options="field:'overview',align:'center',width:'200'">概要</th>
				<th data-options="field:'serveType',align:'center',width:'100'">服务类型</th>
				<th data-options="field:'createPeople',align:'center',width:'100'">创建人</th>
				<th data-options="field:'createTime',align:'center',width:'100'">创建日期</th>
				<th data-options="field:'assigner'" hidden="true">分配人</th>
				<th data-options="field:'assignTime'" hidden="true">分配日期</th>
				<th data-options="field:'serviceProce'" hidden="true">服务处理</th>
				<th data-options="field:'serviceProcePeople'" hidden="true">服务处理人</th>
				<th data-options="field:'serviceProceResult'" hidden="true">服务处理结果</th>
				<th data-options="field:'myd'" hidden="true">客户满意度</th>
			</tr>
		</thead>
	</table>

	<div id="tb">
		<div>
			<a href="javascript:proceService()" class="easyui-linkbutton" data-options="iconCls:'icon-fwgd', plain:'true'">查看客户服务详情</a>
		</div>
	</div>
	<div id="win">
		<form method="post" id="Form" enctype="multipart/form-data">
			<div hidden="true">
				<input name="id" class="easyui-textbox">
			</div>
			<table style="margin: 0px 0px 0px 20px; border-collapse: separate; border-spacing: 5px;" cellpadding="5">
				<tr>
					<td>
						<label>服务类型:</label>
					</td>
					<td>
						<input name="serveType" class="easyui-textbox" data-options="required:true,editable:false,readonly:true" style="width: 130px; height: 30px;">
					</td>
					<td>
						<label>客户:</label>
					</td>
					<td>
						<input name="customer" class="easyui-textbox" data-options="required:true,editable:false,readonly:true" style="width: 130px; height: 30px;">
					</td>
				</tr>
				<tr>
					<td>
						<label>概要:</label>
					</td>
					<td colspan="4">
						<input name="overview" class="easyui-textbox" data-options="required:true,readonly:true" style="width: 370px; height: 30px;">
					</td>
				</tr>
				<tr>
					<td>
						<label>服务请求:</label>
					</td>
					<td colspan="4">
						<input name="servicerequest" class="easyui-textbox" data-options="required:true,multiline:true,readonly:true" style="width: 370px; height: 60px;">
					</td>
				</tr>

				<tr>
					<td>
						<label>创建人:</label>
					</td>
					<td>
						<input name="createPeople" class="easyui-textbox" data-options="required:true,readonly:true" style="width: 130px; height: 30px;">
					</td>
					<td>
						<label>创建时间:</label>
					</td>
					<td>
						<input name="createTime" class="easyui-datebox" data-options="required:true,editable:false,readonly:true" style="width: 130px; height: 30px;">
					</td>
				</tr>

				<tr>
					<td>
						<label>分配人:</label>
					</td>
					<td>
						<input name="assigner" class="easyui-textbox" data-options="required:true,readonly:true" style="width: 130px; height: 30px;">
					</td>
					<td>
						<label>分配时间:</label>
					</td>
					<td>
						<input name="assignTime" class="easyui-datebox" data-options="required:true,editable:false,readonly:true" style="width: 130px; height: 30px;">
					</td>
				</tr>

				<tr>
					<td>
						<label>服务处理:</label>
					</td>
					<td colspan="4">
						<input name="serviceProce" class="easyui-textbox" data-options="required:true,multiline:true,readonly:true" style="width: 370px; height: 60px;">
					</td>
				</tr>
				<tr>
					<td>
						<label>服务处理人:</label>
					</td>
					<td>
						<input name="serviceProcePeople" class="easyui-textbox" data-options="required:true,panelHeight:'auto',editable:false,readonly:true" style="width: 130px; height: 30px;">
					</td>
					<td>
						<label>服务处理日期:</label>
					</td>
					<td>
						<input name="serviceProceTime" class="easyui-datebox" data-options="required:true,editable:false,readonly:true" style="width: 130px; height: 30px;">
					</td>
				</tr>
				<tr>
					<td>
						<label>处理结果:</label>
					</td>
					<td>
						<input name="serviceProceResult" class="easyui-textbox" data-options="required:true,panelHeight:'auto',readonly:true" style="width: 130px; height: 30px;">
					</td>
					<td>
						<label>客户满意度:</label>
					</td>
					<td>
						<select name="myd" class="easyui-combobox" data-options="required:true,editable:false,readonly:true" style="width: 130px; height: 30px;">
							<option value="☆">☆</option>
							<option value="☆☆">☆☆</option>
							<option value="☆☆☆">☆☆☆</option>
							<option value="☆☆☆☆">☆☆☆☆</option>
							<option value="☆☆☆☆☆">☆☆☆☆☆</option>
						</select>
					</td>
				</tr>
			</table>
		</form>
		<br>
		<a href="#" class="easyui-linkbutton" onclick="WinClose()" style="background: #F4F4F4; width: 100px; height: 34px; margin-left: 350px;" data-options="plain:true">取消</a>
	</div>
</body>
</html>