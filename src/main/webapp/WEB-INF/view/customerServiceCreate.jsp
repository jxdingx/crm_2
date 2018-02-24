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
	function FormSubmit() {
		$('#Form').form({
			url : "cusService_update.action",
			onSubmit : function() {
				var isValid = $(this).form('validate');
				if (!isValid) {
					$.messager.alert("操作提示", '请填写完整表单!', "info"); // 如果表单是无效的则隐藏进度条
				}
				return isValid; // 返回false终止表单提交
			},
			success : function(data) {
				if (data) {
					$.messager.alert("操作提示", "添加成功!", "info");
					FormReset();
				}
			}
		});
		// submit the form    
		$('#Form').submit();
	}

	function FormReset() {
		$('#Form').form("clear");
	}
</script>
</head>
<body style="margin: 15px;">
	<div class="easyui-panel" title="客户服务创建" style="width: 600px; height: 400px; padding: 10px;">
		<form method="post" id="Form" enctype="multipart/form-data">
			<table style="margin: 0px 0px 0px 40px; border-collapse: separate; border-spacing: 10px;" cellpadding="10">
				<tr>
					<td>
						<label>服务类型:</label>
					</td>
					<td>
						<input name="serveType" class="easyui-combobox" data-options="required:true,editable:false,valueField:'dataDicValue',textField:'dataDicValue',url:'dataDic_getserveType.action'"
							style="width: 130px; height: 30px;">
					</td>
					<td>
						<label>客户:</label>
					</td>
					<td>
						<input name="customer" class="easyui-textbox" data-options="required:true" style="width: 130px; height: 30px;">
					</td>
				</tr>
				<tr>
					<td>
						<label>概要:</label>
					</td>
					<td colspan="4">
						<input name="overview" class="easyui-textbox" data-options="required:true" style="width: 370px; height: 30px;">
					</td>
				</tr>
				<tr>
					<td>
						<label>服务请求:</label>
					</td>
					<td colspan="4">
						<input name="servicerequest" class="easyui-textbox" data-options="required:true,multiline:true" style="width: 370px; height: 60px;">
					</td>
				</tr>

				<tr>
					<td>
						<label>创建人:</label>
					</td>
					<td>
						<input name="createPeople" class="easyui-textbox" data-options="required:true" style="width: 130px; height: 30px;">
					</td>
					<td>
						<label>创建时间:</label>
					</td>
					<td>
						<input name="createTime" class="easyui-datebox" value="now()" data-options="required:true,editable:false,readonly:true" style="width: 130px; height: 30px;">
					</td>
				</tr>
			</table>
			<br>
			<a class="easyui-linkbutton" onclick="FormSubmit()" style="background: #F4F4F4; width: 100px; height: 34px; margin-left: 30%" data-options="plain:true">保存</a>
			<a href="#" class="easyui-linkbutton" onclick="FormReset()" style="background: #F4F4F4; width: 100px; height: 34px; margin-left: 40px;" data-options="plain:true">重置</a>
		</form>
	</div>

</body>
</html>