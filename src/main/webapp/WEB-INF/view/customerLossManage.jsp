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
	$(function() {
		$('#dg').datagrid({
			toolbar : "#tb",
			method : "post",
			rownumbers : true,
			singleSelect : true,
			fit : true,
			striped : true,
			fitColumns : true,
			checkOnSelect : false,
			pagination : true,
			pageNumber : 1,
			pageSize : 15,
			pageList : [ 15, 20, 30 ],
		});
		var p = $('#dg').datagrid('getPager');
		$(p).pagination({
			onSelectPage : function(pageNumber, pageSize) {
				findallSaleChance(pageNumber, pageSize);
			}
		});
		$('#state').combobox({
			editable : false,
			valueField : 'state',
			textField : 'text',
			data : [ {
				"state" : '',
				"text" : "请选择..",
				"selected" : true
			}, {
				"state" : '1',
				"text" : "确认流失"
			}, {
				"state" : '0',
				"text" : "暂缓流失"
			} ]
		});
		findallcusLoss(1, 15);
	});
	function findallcusLoss(pageNumber, pageSize) {
		var cusName = $("#cusName").textbox("getValue");
		var cusManager = $("#cusManager").textbox("getValue");
		var state = $("#state").combobox("getValue");
		$('#dg').datagrid({
			url : "cusLoss_findall.action",
			queryParams : {
				cusName : cusName,
				cusManager : cusManager,
				state : state,
				page : pageNumber,
				rows : pageSize
			}
		});
	}
	var ff = function(value) {
		if (value == 1) {
			return "确认流失";
		}
		if (value == 0) {
			return "暂缓流失";
		}
	}
</script>
</head>
<body>
	<table id="dg">
		<thead>
			<tr>
				<th data-options="field:'id',width:60,align:'center'">编号</th>
				<th data-options="field:'cusNo'" hidden="true">客户编号</th>
				<th data-options="field:'cusName',width:150,align:'center'">客户名称</th>
				<th data-options="field:'cusManager',width:150,align:'center'">客户经理</th>
				<th data-options="field:'lastOrderTime',width:200,align:'center'">上次下单日期</th>
				<th data-options="field:'createMan',width:200,align:'center'">确认流失日期</th>
				<th data-options="field:'state',width:80,align:'center',formatter:ff">状态</th>
				<th data-options="field:'lossReason',width:200,align:'center'">流失原因</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="height: 55px;">
		<br>
		<label style="margin-left: 30px;">客户名称:</label>
		&nbsp;&nbsp;
		<input id="cusName" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width: 120px">
		<label style="margin-left: 30px;">客户经理:</label>
		&nbsp;&nbsp;
		<input id="cusManager" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width: 120px">
		<label style="margin-left: 30px;">分配状态:</label>
		&nbsp;&nbsp;
		<input id="state" style="width: 80px">
		<a href="#" class="easyui-linkbutton" onclick="findallcusLoss(1,15)" style="background: #E0ECFF; width: 100px; height: 31px; margin-left: 40px;" data-options="plain:true,iconCls:'icon-search'">
			<span class="crmbuttonfont">查询</span>
		</a>
	</div>
</body>
</html>