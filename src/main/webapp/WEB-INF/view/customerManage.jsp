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
	var selectrow;
	$(function() {
		$('#dg').datagrid({
			toolbar : "#tb",
			method : "post",
			rownumbers : true,
			singleSelect : true,
			fit : true,
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
			title : '客户信息详情',
			width : 700,
			height : 450,
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
		findallcustomer(1, 15);
	});

	function findallcustomer(pageNumber, pageSize) {
		var khno = $("#khno").textbox("getValue");
		var name = $("#name").textbox("getValue");
		$('#dg').datagrid({
			url : 'customer_findall.action',
			queryParams : {
				khno : khno,
				name : name,
				page : pageNumber,
				rows : pageSize
			}
		});
	}

	function addcustomer() {
		$('#Form').form("clear");
		$('#win').window("open");
	}
	function updatecustomer() {
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

	function FormSubmit() {
		$('#Form').form({
			url : "customer_update.action",
			onSubmit : function() {
				var isValid = $(this).form('validate');
				if (!isValid) {
					$.messager.alert("操作提示", '请填写完整表单!', "info"); // 如果表单是无效的则隐藏进度条
				}
				return isValid; // 返回false终止表单提交
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

	function openpage(topage, pagename) {
		if (!selectrow) {
			$.messager.alert("操作提示", '请选择一条数据!', "info");
			return;
		}
		var id = selectrow.id;
		var khno = selectrow.khno;
		var name = selectrow.name;
		var parm = "toparm_" + topage + "_id_" + id;
		window.parent.add(name + pagename, parm);
		$('#dg').datagrid("reload");
		selectrow = null;
	}

	var ff = function(value, row, index) {
		return "<a onclick='updateit(" + index + ")'>修改</a>";
	}
</script>
</head>
<body>
	<table id="dg">
		<thead data-options="frozen:true">
			<tr>
				<th data-options="field:'id'" hidden="true">编号</th>
				<th data-options="field:'khno',align:'center',width:'150'">客户编号</th>
				<th data-options="field:'name',align:'center',width:'100'">客户名称</th>
				<th data-options="field:'cusManager',align:'center',width:'100'">客户经理</th>
				<th data-options="field:'level',align:'center',width:'100'">客户等级</th>
				<th data-options="field:'phone',align:'center',width:'100'">联系电话</th>
			</tr>
		</thead>
		<thead>
			<tr>
				<th data-options="field:'area',align:'center',width:'100'">客户地区</th>
				<th data-options="field:'myd',align:'center',width:'100'">客户满意度</th>
				<th data-options="field:'xyd',align:'center',width:'100'">客户信用度</th>
				<th data-options="field:'address',align:'center',width:'150'">客户地址</th>
				<th data-options="field:'postCode',align:'center',width:'100'">邮政编码</th>
				<th data-options="field:'fax',align:'center',width:'100'">传真</th>
				<th data-options="field:'webSite',align:'center',width:'100'">网址</th>
				<th data-options="field:'yyzzzch',align:'center',width:'150'">营业执照注册号</th>
				<th data-options="field:'fr',align:'center',width:'100'">法人</th>
				<th data-options="field:'zczj',align:'center',width:'100'">注册资金(万元)</th>
				<th data-options="field:'nyye',align:'center',width:'100'">年营业额(万元)</th>
				<th data-options="field:'khyh',align:'center',width:'100'">开户银行</th>
				<th data-options="field:'khzh',align:'center',width:'100'">开户帐号</th>
				<th data-options="field:'dsdjh',align:'center',width:'100'">地税登记号</th>
				<th data-options="field:'gsdjh',align:'center',width:'100'">国税登记号</th>
				<th data-options="field:'state'" hidden="true">编号</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="height: 55px;">
		<br>
		<label style="margin-left: 40px;">客户编号:</label>
		&nbsp;&nbsp;&nbsp;
		<input id="khno" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width: 160px">

		<label style="margin-left: 20px;">客户名称:</label>
		&nbsp;&nbsp;&nbsp;
		<input id="name" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width: 100px">
		<a href="#" class="easyui-linkbutton" onclick="findallcustomer(1,15)" style="background: #E0ECFF; width: 100px; height: 31px; margin-left: 40px;" data-options="plain:true,iconCls:'icon-search'">
			<span class="crmbuttonfont">查询</span>
		</a>
		<a href="javascript:addcustomer()" class="easyui-linkbutton" data-options="iconCls:'icon-add', plain:'true'" style="margin-left: 150px;">创建</a>
		<a href="javascript:updatecustomer()" class="easyui-linkbutton" data-options="iconCls:'icon-edit', plain:'true'">修改</a>
		<a href="javascript:deleteCustomer()" class="easyui-linkbutton" data-options="iconCls:'icon-remove', plain:'true'">删除</a>
		<a href="javascript:openpage('linkManManage','客户联系人管理')" class="easyui-linkbutton" data-options="iconCls:'icon-lxr', plain:'true'">联系人管理</a>
		<a href="javascript:openpage('contactManage','交往记录管理')" class="easyui-linkbutton" data-options="iconCls:'icon-jwjl', plain:'true'">交往记录管理</a>
		<a href="javascript:openpage('orderManage','历史订单查看')" class="easyui-linkbutton" data-options="iconCls:'icon-lsdd', plain:'true'">历史订单查看</a>
	</div>


	<div id="win">
		<form method="post" id="Form" enctype="multipart/form-data">
			<div hidden="true">
				<input name="id" class="easyui-textbox">
				<input name="state" class="easyui-textbox">
				<input name="khno" class="easyui-textbox">
			</div>
			<table cellspacing="8px" style="margin-left: 40px;">
				<tr>
					<td>客户名称：</td>
					<td>
						<input name="name" class="easyui-textbox" data-options="required:true" style="width: 155px; height: 23px;">
						&nbsp;
						<font color="red">*</font>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>地区：</td>
					<td>
						<select class="easyui-combobox" id="area" name="area" data-options="required:true,editable:false" style="width: 155px;">
							<option value="北京">北京</option>
							<option value="南京">南京</option>
							<option value="上海">上海</option>
							<option value="广州">广州</option>
							<option value="天津">天津</option>
						</select>
						&nbsp;
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>客户经理：</td>
					<td>
						<input class="easyui-combobox" name="cusManager" data-options="required:true,panelHeight:'auto',editable:false,valueField:'trueName',textField:'trueName',url:'user_getManager.action'"
							style="width: 155px;" />
						&nbsp;
						<font color="red">*</font>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>客户等级：</td>
					<td>
						<input class="easyui-combobox" name="level" data-options="required:true,panelHeight:'auto',editable:false,valueField:'dataDicValue',textField:'dataDicValue',url:'dataDic_getlevel.action'"
							style="width: 155px;" />
						&nbsp;
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>客户满意度：</td>
					<td>
						<select class="easyui-combobox" name="myd" style="width: 155px;" data-options="required:true,editable:false">
							<option value="☆">☆</option>
							<option value="☆☆">☆☆</option>
							<option value="☆☆☆">☆☆☆</option>
							<option value="☆☆☆☆">☆☆☆☆</option>
							<option value="☆☆☆☆☆">☆☆☆☆☆</option>
						</select>
						&nbsp;
						<font color="red">*</font>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>客户信用度：</td>
					<td>
						<select class="easyui-combobox" name="xyd" style="width: 155px;" data-options="required:true,editable:false">
							<option value="☆">☆</option>
							<option value="☆☆">☆☆</option>
							<option value="☆☆☆">☆☆☆</option>
							<option value="☆☆☆☆">☆☆☆☆</option>
							<option value="☆☆☆☆☆">☆☆☆☆☆</option>
						</select>
						&nbsp;
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>邮政编码：</td>
					<td>
						<input name="postCode" class="easyui-textbox" data-options="required:true" style="width: 155px;" />
						&nbsp;
						<font color="red">*</font>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>联系电话：</td>
					<td>
						<input name="phone" class="easyui-textbox" data-options="required:true" style="width: 155px;" />
						&nbsp;
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>传真：</td>
					<td>
						<input name="fax" class="easyui-textbox" data-options="required:true" style="width: 155px;" />
						&nbsp;
						<font color="red">*</font>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>网址：</td>
					<td>
						<input name="webSite" class="easyui-textbox" data-options="required:true" style="width: 155px;" />
						&nbsp;
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td valign="top">客户地址：</td>
					<td colspan="4">
						<input name="address" style="width: 400px" class="easyui-textbox" data-options="required:true" style="width: 155px;" />
						&nbsp;
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>营业执照注册号：</td>
					<td>
						<input name="yyzzzch" class="easyui-textbox" style="width: 155px;" />
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>法人：</td>
					<td>
						<input name="fr" class="easyui-textbox" data-options="required:true" style="width: 155px;" />
						&nbsp;
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>注册资金(万元)：</td>
					<td>
						<input name="zczj" class="easyui-textbox" style="width: 155px;" />
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>年营业额(万元)：</td>
					<td>
						<input name="nyye" class="easyui-textbox" data-options="required:true" style="width: 155px;" />
						&nbsp;
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>开户银行：</td>
					<td>
						<input name="khyh" class="easyui-textbox" data-options="required:true" style="width: 155px;" />
						&nbsp;
						<font color="red">*</font>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>开户帐号：</td>
					<td>
						<input name="khzh" class="easyui-textbox" data-options="required:true" style="width: 155px;" />
						&nbsp;
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>地税登记号：</td>
					<td>
						<input name="dsdjh" class="easyui-textbox" style="width: 155px;" />
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>国税登记号：</td>
					<td>
						<input name="gsdjh" class="easyui-textbox" style="width: 155px;" />
					</td>
				</tr>
			</table>
		</form>
		<br>
		<a class="easyui-linkbutton" onclick="FormSubmit()" style="background: #F4F4F4; width: 100px; height: 34px; margin-left: 30%" data-options="plain:true">保存</a>
		<a href="#" class="easyui-linkbutton" onclick="WinClose()" style="background: #F4F4F4; width: 100px; height: 34px; margin-left: 40px;" data-options="plain:true">取消</a>
	</div>
</body>
</html>