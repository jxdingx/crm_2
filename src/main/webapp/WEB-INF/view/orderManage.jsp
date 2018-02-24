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
			url : 'cusOrder_find.action',
			queryParams : {
				cusId : cusId,
			},
			method : "post",
			rownumbers : true,
			singleSelect : true,
			fit : true,
			fitColumns : true,
			striped : true,
			onSelect : function(index, row) {
				selectrow = row;
			}
		});
		$('#win').window({
			title : '订单详情信息',
			width : 650,
			height : 500,
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

	function WinClose() {
		$('#win').window("close");
	}

	function formatState(val, row) {
		if (val == 1) {
			return "已回款";
		} else {
			return "未回款";
		}
	}

	function formatAction(val, row, index) {
		return "<a href='javascript:openOrderDetail(" + row.id + "," + index
				+ ")'>查看订单明细</a>";
	}

	function openOrderDetail(id, index) {
		$('#win').window("open");
		$('#Form').form("load", $("#dg").datagrid("getRows")[index]);
		$('#orderdetailsdg').datagrid({
			url : 'orderDetails_find.action',
			queryParams : {
				orderId : id,
			},
			method : "post",
			rownumbers : true,
			singleSelect : true,
			fit : true,
			fitColumns : true,
			striped : true,
			onLoadSuccess : function(data) {
				var prices = 0;
				var length = data.rows.length;
				for (var i = 0; i < length; i++) {
					prices += data.rows[i].sum;
				}
				$("#prices").textbox("setValue", prices);
			}
		});
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
	<div class="easyui-panel" title="交往记录信息管理" style="width: 100%; height: 450px; padding: 0px;">
		<table id="dg" style="width: 100%; height: 600px;">
			<thead>
				<tr>
					<th data-options="field:'id',align:'center',width:'100'">编号</th>
					<th data-options="field:'orderNo',align:'center',width:'100'">订单号</th>
					<th data-options="field:'orderDate',align:'center',width:'150'">订购日期</th>
					<th data-options="field:'address',align:'center',width:'200'">送货地址</th>
					<th data-options="field:'state',align:'center',width:'100',formatter:formatState">状态</th>
					<th data-options="field:'s',align:'center',width:'100',formatter:formatAction">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="win">
		<form method="post" id="Form" enctype="multipart/form-data">
			<table style="margin: 0px 0px 0px 10px; border-collapse: separate; border-spacing: 10px;" cellpadding="5">
				<tr>
					<td>
						<label style="margin-left: 40px;">订单号:</label>
					</td>
					<td>
						<input name="orderNo" class="easyui-textbox" data-options="readonly:true" style="width: 150px">
					</td>
					<td>
						<label style="margin-left: 40px;">订购日期:</label>
					</td>
					<td>
						<input name="orderDate" class="easyui-textbox" data-options="readonly:true" style="width: 150px">
					</td>
				</tr>
				<tr>
					<td>
						<label style="margin-left: 40px;">送货地址:</label>
					</td>
					<td>
						<input name="address" class="easyui-textbox" data-options="readonly:true" style="width: 150px">
					</td>
					<td>
						<label style="margin-left: 40px;">总金额:</label>
					</td>
					<td>
						<input id="prices" class="easyui-textbox" data-options="readonly:true" style="width: 150px">
					</td>
				</tr>
				<tr>
					<td>
						<label style="margin-left: 40px;">状态:</label>
					</td>
					<td>
						<input name="state" class="easyui-textbox" data-options="readonly:true" style="width: 150px">
					</td>
				</tr>
			</table>
		</form>
		<br>
		<br>
		<table id="orderdetailsdg" style="width: 100%; height: 600px;">
			<thead>
				<tr>
					<th data-options="field:'id',align:'center',width:'100'">编号</th>
					<th data-options="field:'goodsName',align:'center',width:'100'">商品名称</th>
					<th data-options="field:'goodsNum',align:'center',width:'150'">商品数量</th>
					<th data-options="field:'unit',align:'center',width:'200'">单位</th>
					<th data-options="field:'price',align:'center',width:'100'">价格</th>
					<th data-options="field:'sum',align:'center',width:'100'">金额</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>