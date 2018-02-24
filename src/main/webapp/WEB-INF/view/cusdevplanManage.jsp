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
		$('#devResult').combobox({
			editable : false,
			valueField : 'state',
			textField : 'text',
			data : [ {
				"state" : '',
				"text" : "请选择..",
				"selected" : true
			}, {
				"state" : '0',
				"text" : "未开发"
			}, {
				"state" : '1',
				"text" : "开发中"
			}, {
				"state" : '2',
				"text" : "开发成功"
			}, {
				"state" : '3',
				"text" : "开发失败"
			} ]
		});
		findallSaleChance(1, 15);
		$('#win').window({
			title : '添加计划详细信息',
			width : 380,
			height : 250,
			closed : true,//初始时是关闭状态
			cache : false,
			modal : true,//模态
			doSize : true,
			border : 'thin',
			yIndex : 300,
			onClose : function() {
				$('#planForm').form("clear");
			}
		});
		$('#plandg').datagrid({
			method : "post",
			toolbar : "#plantb",
			rownumbers : true,
			singleSelect : true,
			fitColumns : true,
			striped : true,
		});
	});
	function findallSaleChance(pageNumber, pageSize) {
		var customerName = $("#customerName").textbox("getValue");
		var overView = $("#overView").textbox("getValue");
		var devResult = $("#devResult").combobox("getValue");
		$('#dg').datagrid({
			url : "saleChance_findall.action",
			queryParams : {
				customerName : customerName,
				overView : overView,
				devResult : devResult,
				state : 1,
				page : pageNumber,
				rows : pageSize
			},
			onLoadSuccess : function() {
				// 				devplan(1)
			}
		});
	}

	function plandetils(index) {
		var row = $('#dg').datagrid('getData').rows[index];
		$('#plantb').hide();
		$('#Form').form('load', row);
		$('#win1').prop("hidden", true);
		$('#win2').prop("hidden", false);
		$('#plandg').datagrid({
			url : "cusDevPlan_findall.action",
			queryParams : {
				saleChanceId : row.id,
			},
		});
		$('#plantb').hide();
	}

	function devplan(index) {
		var row = $('#dg').datagrid('getData').rows[index];
		$('#plantb').show();
		$('#Form').form("clear");
		$('#Form').form('load', row);
		$('#win1').prop("hidden", true);
		$('#win2').prop("hidden", false);
		$('#plandg').datagrid({
			url : "cusDevPlan_findall.action",
			queryParams : {
				saleChanceId : row.id,
			},
		});
		$('#plantb').show();
	}

	function returncusdevplan() {
		$('#Form').form("clear");
		$('#win1').prop("hidden", false);
		$('#win2').prop("hidden", true);
		$('#dg').datagrid("reload");
	}

	function addcusdevplan() {
		$('#win').window("open");
	}

	function WinClose() {
		$('#win').window("close");
	}
	function FormSubmit() {
		$('#planForm').form({
			url : "cusDevPlan_update.action",
			onSubmit : function() {
				var isValid = $(this).form('validate');
				if (!isValid) {
					$.messager.alert("操作提示", '请填写完整表单!', "info"); // 如果表单是无效的则隐藏进度条
				}
				return isValid; // 返回false终止表单提交
			},
			queryParams : {
				saleChanceId : $("#saleChanceId").textbox("getValue"),
			},
			success : function(data) {
				if (data) {
					$.messager.alert("操作提示", "添加成功!", "info");
				}
				$('#plandg').datagrid("reload");
				WinClose();
			}
		});
		// submit the form    
		$('#planForm').submit();
	}

	function deletecusdevplan() {
		var row = $('#plandg').datagrid("getSelected");
		if (!row) {
			$.messager.alert("操作提示", "请选择一行数据!", "info");
			return;
		}
		$.messager.confirm("操作提示", "您确定要删除 编号: <span style='color:red'>"
				+ row.id + "</span> 的数据?", function(data) {
			if (data) {
				$.ajax({
					url : 'cusDevPlan_delete.action',
					type : 'POST',
					data : {
						id : row.id
					},
					dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
					success : function(data) {
						if (data) {
							$.messager.alert("提示", "删除成功!", "info");
						}
						$('#plandg').datagrid("reload");
						WinClose();
					},
				});
			} else {
				return;
			}
		});
	}

	function updateSaleChanceDevResult(devResult, statu) {
		$.messager.confirm("操作提示", "您确定该计划执行结果为:   <span style='color:red'>"
				+ statu + "</span> ?", function(data) {
			if (data) {
				$.ajax({
					url : 'saleChance_updateDevResult.action',
					type : 'POST',
					data : {
						id : $("#saleChanceId").textbox("getValue"),
						devResult : devResult
					},
					dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
					success : function(data) {
						if (data) {
							$.messager.alert("提示", "修改成功!", "info");
						}
						returncusdevplan();
					},
				});
			} else {
				return;
			}
		});
	}

	var ff = function(value) {
		if (value == 0) {
			return "未开发";
		}
		if (value == 1) {
			return "开发中";
		}
		if (value == 2) {
			return "开发成功";
		}
		if (value == 3) {
			return "开发失败";
		}
	}

	var actionff = function(value, row, index) {
		var devResult = row.devResult;
		if (devResult == 1 || devResult == 0) {
			return "<a onclick='devplan(" + index
					+ ")'><span style='color:blue'>开发</span></a>";
		} else {
			return "<a onclick='plandetils(" + index
					+ ")'><span style='color:blue'>查看详细信息</span></a>";
		}
	}
</script>
</head>
<body>
	<div id="win1" style="height: 570px; width: 100%">
		<table id="dg">
			<thead>
				<tr>
					<th data-options="field:'id'" hidden="true"></th>
					<th data-options="field:'chanceSource'" hidden="true">机会来源</th>
					<th data-options="field:'customerName',width:80,align:'center'">客户名称</th>
					<th data-options="field:'cgjl'" hidden="true">成功几率</th>
					<th data-options="field:'overView',width:150,align:'center'">概要</th>
					<th data-options="field:'linkMan',width:80,align:'center'">联系人</th>
					<th data-options="field:'linkPhone'" hidden="true">联系电话</th>
					<th data-options="field:'description'" hidden="true">机会描述</th>
					<th data-options="field:'createMan',width:60,align:'center'">创建人</th>
					<th data-options="field:'createTime',width:120,align:'center'">创建时间</th>
					<th data-options="field:'assignMan',width:60,align:'center'">指派人</th>
					<th data-options="field:'assignTime',width:120,align:'center'">指派时间</th>
					<th data-options="field:'state'" hidden="true">分配状态</th>
					<th data-options="field:'devResult',width:150,align:'center',formatter:ff">开发状态</th>
					<th data-options="field:'s',width:80,align:'center',formatter:actionff">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="tb" style="height: 55px;">
		<br>
		<label style="margin-left: 30px;">客户名称:</label>
		&nbsp;&nbsp;
		<input id="customerName" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width: 120px">
		<label style="margin-left: 30px;">概要:</label>
		&nbsp;&nbsp;
		<input id="overView" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width: 120px">
		<label style="margin-left: 30px;">客户开发状态:</label>
		&nbsp;&nbsp;
		<input id="devResult" style="width: 80px">

		<a href="#" class="easyui-linkbutton" onclick="findallSaleChance(1,15)" style="background: #E0ECFF; width: 100px; height: 31px; margin-left: 40px;" data-options="plain:true,iconCls:'icon-search'">
			<span class="crmbuttonfont">查询</span>
		</a>
		<a href="#" class="easyui-linkbutton" onclick="addSaleChance()" style="background: #E0ECFF; width: 100px; height: 31px; margin-right: 40px; float: right;"
			data-options="plain:true,iconCls:'icon-search'">
			<span class="crmbuttonfont">添加</span>
		</a>
	</div>
	<div id="win2" hidden="true" style="width: 100%">
		<div class="easyui-panel" title="销售机会信息" style="width: 100%; height: 250px; padding: 5px;">
			<div style="margin-left: 40px;">
				<form method="post" id="Form" enctype="multipart/form-data">
					<div hidden="true">
						<input name="id" id="saleChanceId" class="easyui-textbox">
					</div>
					<table style="margin: 0px 0px 0px 20px; border-collapse: separate; border-spacing: 7px;" cellpadding="5">
						<tr>
							<td>
								<label>客户名称:</label>
							</td>
							<td>
								<input name="customerName" class="easyui-textbox" data-options="editable:false,readonly:true" style="width: 130px; height: 30px;">
							</td>
							<td>
								<label>联系人:</label>
							</td>
							<td>
								<input name="linkMan" class="easyui-textbox" data-options="editable:false,readonly:true" style="width: 130px; height: 30px;">
							</td>
							<td>
								<label>联系电话 :</label>
							</td>
							<td>
								<input name="linkPhone" class="easyui-textbox" data-options="editable:false,readonly:true" style="width: 130px; height: 30px;">
							</td>
							<td>
								<label>机会来源:</label>
							</td>
							<td>
								<input name="chanceSource" class="easyui-textbox" data-options="editable:false,readonly:true" style="width: 130px; height: 30px;">
							</td>
							<td rowspan="2" colspan="2">
								<a href="#" class="easyui-linkbutton" onclick="returncusdevplan()" style="background: #E0ECFF; width: 200px; height: 40px; margin-left: 40px;" data-options="plain:true">
									<span class="crmbuttonfont" style="color: red;">返回客户开发计划</span>
								</a>
							</td>
						</tr>
						<tr>
							<td>
								<label>成功几率:</label>
							</td>
							<td>
								<input name="cgjl" class="easyui-numberspinner" data-options="editable:false,readonly:true" style="width: 130px; height: 30px;">
							</td>
							<td>
								<label>概要:</label>
							</td>
							<td colspan="3">
								<input name="overView" class="easyui-textbox" data-options="editable:false,readonly:true" style="width: 350px; height: 30px;">
							</td>
						</tr>
						<tr>
							<td>
								<label>机会描述:</label>
							</td>
							<td colspan="5">
								<input name="description" class="easyui-textbox" data-options="multiline:true,editable:false,readonly:true" style="width: 560px; height: 50px;">
							</td>
						</tr>
						<tr>
							<td>
								<label>创建人:</label>
							</td>
							<td>
								<input name="createMan" class="easyui-textbox" data-options="editable:false,readonly:true" style="width: 130px; height: 30px;">
							</td>
							<td>
								<label>创建时间:</label>
							</td>
							<td>
								<input name="createTime" class="easyui-datebox" data-options="editable:false,readonly:true" style="width: 130px; height: 30px;">
							</td>
							<td>
								<label>指派给:</label>
							</td>
							<td>
								<input name="assignMan" class="easyui-combobox" data-options="editable:false,readonly:true" style="width: 130px; height: 30px;">
							</td>
							<td>
								<label>指派时间 :</label>
							</td>
							<td>
								<input name="assignTime" class="easyui-datebox" data-options="editable:false,readonly:true" style="width: 130px; height: 30px;">
							</td>
						</tr>
					</table>
				</form>

			</div>
		</div>
		<br>
		<div class="easyui-panel" title="开发计划项" style="width: 100%; height: 300px; padding: 0px;">
			<table id="plandg" style="width: 1000px;">
				<thead>
					<tr>
						<th data-options="field:'id',width:80,align:'center'">编号</th>
						<th data-options="field:'saleChanceId'" hidden="true"></th>
						<th data-options="field:'planItem',width:200,align:'center'">计划项</th>
						<th data-options="field:'planDate',width:200,align:'center'">计划日期</th>
						<th data-options="field:'exeAffect',width:200,align:'center'">执行效果</th>
					</tr>
				</thead>
			</table>
		</div>
		<div id="plantb">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add', plain:'true'" onclick="addcusdevplan()">添加计划</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove', plain:'true'" onclick="deletecusdevplan()">删除计划</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok', plain:'true'" onclick="updateSaleChanceDevResult(2,'开发成功')">开发成功</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:'true'" onclick="updateSaleChanceDevResult(3,'开发失败')">开发失败</a>
		</div>
		<div id="win">
			<form method="post" id="planForm" enctype="multipart/form-data">
				<table style="margin: 0px 0px 0px 34px; border-collapse: separate; border-spacing: 7px;" cellpadding="5">
					<tr>
						<td>
							<label>计划项:</label>
						</td>
						<td>
							<input name="planItem" class="easyui-textbox" data-options="required:true" style="width: 180px; height: 30px;">
						</td>
					</tr>
					<tr>
						<td>
							<label>计划日期:</label>
						</td>
						<td>
							<input name="planDate" class="easyui-datebox" data-options="editable:false,required:true" style="width: 130px; height: 30px;">
						</td>
					<tr>
						<td>
							<label>执行效果:</label>
						</td>
						<td>
							<input name="exeAffect" class="easyui-textbox" data-options="required:true" style="width: 180px; height: 30px;">
						</td>
					</tr>
				</table>
				<br>
				<a class="easyui-linkbutton" onclick="FormSubmit()" style="width: 100px; height: 34px; margin-left: 18%">保存</a>
				<a href="#" class="easyui-linkbutton" onclick="WinClose()" style="width: 100px; height: 34px; margin-left: 40px;">取消</a>
			</form>
		</div>
	</div>
</body>
</html>