<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/crm.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$('#dg').datagrid({
			url : 'user_findAll.action',
			rownumbers : true,
			singleSelect : true,
			fit : true,
			striped : true,
			fitColumns : true,
			method : "post",
			toolbar : "#tb",
		});
		$('#win').window({
			title : '用户信息修改',
			width : 535,
			height : 320,
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
	});

	function findUser() {
		var finduserName = $("#finduserName").textbox("getValue");
		$('#dg').datagrid('load', {
			userName : finduserName
		});
	}
	function addUser() {
		$('#Form').form("clear");
		$('#win').window("open");
	}
	
	function updateit(index) {
		var row = $('#dg').datagrid('getData').rows[index];
		$('#Form').form('load', row);
		$('#win').window("open");
	}
	function WinClose() {
		$('#win').window("close");
	}
	function FormSubmit() {
		$('#Form').form({
			url : "user_update.action",
			onSubmit : function() {
				var isValid = $(this).form('validate');
				if (!isValid) {
					$.messager.alert('请填写完整表单!'); // 如果表单是无效的则隐藏进度条
				}
				return isValid; // 返回false终止表单提交
			},
			success : function(data) {
				data = JSON.parse(data);
				var result = data.result;
				if (result == "ok") {
					$('#dg').datagrid("reload");
				}
				WinClose();
			}
		});
		// submit the form    
		$('#Form').submit();
	}

	var ff = function(value, row, index) {
		return "<a onclick='updateit(" + index + ")'>修改</a>";
	}
</script>
</head>
<body>
	<table id="dg">
		<thead>
			<tr>
				<th data-options="field:'id'" hidden="true"></th>
				<th data-options="field:'userName',width:80">用户名</th>
				<th data-options="field:'password',width:100">密码</th>
				<th data-options="field:'trueName',width:80,align:'right'">姓名</th>
				<th data-options="field:'email',width:80,align:'right'">邮箱</th>
				<th data-options="field:'phone',width:80,align:'right'">电话</th>
				<th data-options="field:'a',width:80,align:'center',formatter:ff">操作</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="height: 55px;">
		<br>
		<label style="margin-left: 40px;">用户名:</label>
		&nbsp;&nbsp;&nbsp;
		<input id="finduserName" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width: 150px">
		<a href="#" class="easyui-linkbutton" onclick="findUser()" style="background: #E0ECFF; width: 100px; height: 31px; margin-left: 40px;" data-options="plain:true,iconCls:'icon-search'">
			<span class="crmbuttonfont">查询</span>
		</a>
		<a href="#" class="easyui-linkbutton" onclick="addUser()" style="background: #E0ECFF; width: 100px; height: 31px; margin-right: 40px; float: right;" data-options="plain:true,iconCls:'icon-search'">
			<span class="crmbuttonfont">添加</span>
		</a>
	</div>
	<div id="win">
		<form method="post" id="Form" enctype="multipart/form-data">
			<div hidden="true">
				<input name="id" class="easyui-textbox">
			</div>
			<br>
			<table style="margin: 0px 0px 0px 40px; border-collapse: separate; border-spacing: 10px;" cellpadding="10">
				<tr>
					<td>
						<label>用户名:</label>
					</td>
					<td>
						<input name="userName" class="easyui-textbox" data-options="required:true" style="width: 130px; height: 30px;">
					</td>
					<td>
						<label>密码:</label>
					</td>
					<td>
						<input name="password" class="easyui-textbox" data-options="required:true" style="width: 130px; height: 30px;">
					</td>
				</tr>
				<tr>
					<td>
						<label>姓名:</label>
					</td>
					<td>
						<input name="trueName" class="easyui-textbox" data-options="required:true" style="width: 130px; height: 30px;">
					</td>
					<td>
						<label>邮箱:</label>
					</td>
					<td>
						<input name="email" class="easyui-textbox" data-options="required:true" style="width: 130px; height: 30px;">
					</td>
				</tr>
				<tr>
					<td>
						<label>电话:</label>
					</td>
					<td>
						<input name="phone" class="easyui-textbox" data-options="required:true" style="width: 130px; height: 30px;">
					</td>
					<td></td>
				</tr>
			</table>
			<br>
			<a class="easyui-linkbutton" onclick="FormSubmit()" style="background: #F4F4F4; width: 100px; height: 34px; margin-left: 30%" data-options="plain:true">保存</a>
			<a href="#" class="easyui-linkbutton" onclick="WinClose()" style="background: #F4F4F4; width: 100px; height: 34px; margin-left: 40px;" data-options="plain:true">取消</a>
		</form>
	</div>
</body>
</html>