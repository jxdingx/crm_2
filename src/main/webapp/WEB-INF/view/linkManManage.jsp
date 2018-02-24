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
<title>Insert title here</title>
<script type="text/javascript">
	var cusId = "";
	var selectrow = null;
	$(function() {
		cusId =
<%out.print(request.getParameter("id"));%>
	getcustomer(cusId);
		$('#dg').datagrid({
			url : 'cusLinkMan_find.action',
			queryParams : {
				cusId : cusId,
			},
			toolbar : "#tb",
			method : "post",
			rownumbers : true,
			singleSelect : true,
			fit : true,
			striped : true,
			onSelect : function(index, row) {
				selectrow = row;
			}
		});
		$('#win').window({
			title : '联系人信息',
			width : 380,
			height : 380,
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

	function getcustomer(cusId) {
		$.ajax({
			url : 'customer_find.action',
			type : 'POST',
			data : {
				id : cusId
			},
			dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
			success : function(data) {
				if (data) {
					cusId = data.cusId;
					$("#khno").textbox("setValue", data.khno);
					$("#name").textbox("setValue", data.name);
					$("#level").textbox("setValue", data.level);
					$("#phone").textbox("setValue", data.phone);
					$("#address").textbox("setValue", data.address);
				}
			},
		});
	}

	function addcusLinkMan() {
		$('#Form').form("clear");
		$('#win').window("open");
	}

	function updatecusLinkMan() {
		if (!selectrow) {
			$.messager.alert("操作提示", '请选择一条数据!', "info");
			return;
		}
		$('#Form').form("clear");
		$('#Form').form('load', selectrow);
		$('#win').window("open");
		selectrow = null;
	}

	function deletecusLinkMan() {
		if (!selectrow) {
			$.messager.alert("操作提示", "请选择一行数据!", "info");
			return;
		}
		$.messager.confirm("操作提示", "您确定要删除 编号: <span style='color:red'>"
				+ selectrow.id + "</span> 的数据?", function(data) {
			if (data) {
				$.ajax({
					url : 'cusLinkMan_delete.action',
					type : 'POST',
					data : {
						id : selectrow.id
					},
					dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
					success : function(data) {
						if (data) {
							$.messager.alert("提示", "删除成功!", "info");
						}
						$('#dg').datagrid("reload");
						WinClose();
					},
				});
			} else {
				return;
			}
		});
		selectrow = null;
	}

	function WinClose() {
		$('#win').window("close");
	}
	function FormSubmit() {
		$('#Form').form({
			url : "cusLinkMan_update.action",
			onSubmit : function() {
				var isValid = $(this).form('validate');
				if (!isValid) {
					$.messager.alert("操作提示", '请填写完整表单!', "info"); // 如果表单是无效的则隐藏进度条
				}
				return isValid; // 返回false终止表单提交
			},
			queryParams : {
				cusId : cusId,
			},
			success : function(data) {
				data = JSON.parse(data);
				var result = data.result;
				if (result == "insert") {
					result = "添加成功!";
				} else if (result == "update") {
					result = "修改成功!";
				}
				$.messager.alert("操作提示", result, "info");
				$('#dg').datagrid("reload");
				WinClose();
			}
		});
		// submit the form    
		$('#Form').submit();
	}
</script>
</head>
<body>
	<div class="easyui-panel" title="销售机会信息" style="width: 100%; height: 150px; padding: 20px;">
		<label style="margin-left: 40px;">客户编号:</label>
		&nbsp;&nbsp;&nbsp;
		<input id="khno" class="easyui-textbox" data-options="readonly:true" style="width: 200px">
		<label style="margin-left: 80px;">客户姓名:</label>
		&nbsp;&nbsp;&nbsp;
		<input id="name" class="easyui-textbox" data-options="readonly:true" style="width: 200px">
		<label style="margin-left: 80px;">客户等级:</label>
		&nbsp;&nbsp;&nbsp;
		<input id="level" class="easyui-textbox" data-options="readonly:true" style="width: 200px">
		<br>
		<br>
		<label style="margin-left: 40px;">联系电话:</label>
		&nbsp;&nbsp;&nbsp;
		<input id="phone" class="easyui-textbox" data-options="readonly:true" style="width: 200px">
		<label style="margin-left: 80px;">客户地址:</label>
		&nbsp;&nbsp;&nbsp;
		<input id="address" class="easyui-textbox" data-options="readonly:true" style="width: 300px">
	</div>
	<br>
	<div class="easyui-panel" title="联系人信息管理" style="width: 100%; height: 450px; padding: 0px;">
		<table id="dg" style="width: 100%; height: 600px;">
			<thead>
				<tr>
					<th data-options="field:'id',align:'center',width:'100'">编号</th>
					<th data-options="field:'linkName',align:'center',width:'100'">客户姓名</th>
					<th data-options="field:'sex',align:'center',width:'100'">性别</th>
					<th data-options="field:'zhiwei',align:'center',width:'100'">职位</th>
					<th data-options="field:'officePhone',align:'center',width:'100'">办公电话</th>
					<th data-options="field:'phone',align:'center',width:'100'">手机号</th>
				</tr>
			</thead>
		</table>
		<div id="tb">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addcusLinkMan()">添加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="updatecusLinkMan()">修改</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deletecusLinkMan()">删除</a>
		</div>
	</div>
	<div id="win">
		<form method="post" id="Form" enctype="multipart/form-data">
			<div hidden="true">
				<input name="id" class="easyui-textbox">
			</div>
			<br>
			<table style="margin: 0px 0px 0px 40px; border-collapse: separate; border-spacing: 7px;" cellpadding="7">
				<tr>
					<td>
						<label>姓名:</label>
					</td>
					<td>
						<input name="linkName" class="easyui-textbox" data-options="required:true" style="width: 130px; height: 30px;">
					</td>
				</tr>
				<tr>
					<td>
						<label>性别 :</label>
					</td>
					<td>
						<input name="sex" class="easyui-textbox" data-options="required:true" style="width: 130px; height: 30px;">
					</td>
				</tr>
				<tr>
					<td>
						<label>职位:</label>
					</td>
					<td>
						<input name="zhiwei" class="easyui-textbox" data-options="required:true" style="width: 130px; height: 30px;">
					</td>
				</tr>
				<tr>
					<td>
						<label>办公电话:</label>
					</td>
					<td>
						<input name="officePhone" class="easyui-textbox" data-options="required:true" style="width: 130px; height: 30px;">
					</td>
				</tr>
				<tr>
					<td>
						<label>手机:</label>
					</td>
					<td>
						<input name="phone" class="easyui-textbox" data-options="required:true" style="width: 130px; height: 30px;">
					</td>
				</tr>
			</table>
			<br>
			<a class="easyui-linkbutton" onclick="FormSubmit()" style="background: #F4F4F4; width: 100px; height: 34px; margin-left: 20%" data-options="plain:true">保存</a>
			<a href="#" class="easyui-linkbutton" onclick="WinClose()" style="background: #F4F4F4; width: 100px; height: 34px; margin-left: 40px;" data-options="plain:true">取消</a>
		</form>
	</div>
</body>
</html>