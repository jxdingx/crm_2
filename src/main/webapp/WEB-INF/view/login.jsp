<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户关系管理系统登录</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>
<style type=text/css>
body {
	text-align: center;
	padding-bottom: 0px;
	background-color: #ddeef2;
	margin: 0px;
	padding-left: 0px;
	padding-right: 0px;
	padding-top: 0px
}

a:link {
	color: #000000;
	text-decoration: none
}

a:visited {
	color: #000000;
	text-decoration: none
}

a:hover {
	color: #ff0000;
	text-decoration: underline
}

a:active {
	text-decoration: none
}

.input1 {
	border-bottom: #ccc 1px solid;
	border-left: #ccc 1px solid;
	line-height: 20px;
	width: 120px;
	height: 20px;
	border-top: #ccc 1px solid;
	border-right: #ccc 1px solid;
}

.errorMessage li {
	list-style-type: none;
}

.errorMessage {
	padding: 0;
}
</style>
<script type="text/javascript">
	function FormSubmit() {
		$('#LoginForm').form({
			url : "login.action",
			onSubmit : function() {
				var isValid = $(this).form('validate');
				if (!isValid) {
					$.messager.alert("操作提示", '请填写完整!', "info"); // 如果表单是无效的则隐藏进度条
				}
				return isValid; // 返回false终止表单提交
			},
			success : function(data) {
				data = JSON.parse(data);
				var result = data.result;
				if (result == "ok") {
					window.location.href = "to_main.action";
				} else {
					$("#err_mes").text(data.result)
				}
			}
		});
		// submit the form    
		$('#LoginForm').submit();
	}

	function FormRest() {
		$('#LoginForm').form("clear");
	}
</script>
</head>
<body>
	<form id="LoginForm" method="post">
		<table style="margin: auto; width: 100%; height: 100%" border=0 cellspacing=0 cellpadding=0>
			<tbody>
				<tr>
					<td height=150>&nbsp;</td>
				</tr>
				<tr style="height: 254px">
					<td>
						<div style="margin: 0px auto; width: 936px">
							<img style="display: block" src="<%=request.getContextPath()%>/images/body_03.jpg">
						</div>
						<div style="background-color: #278296">
							<div style="margin: 0px auto; width: 936px">
								<div style="background: url(<%=request.getContextPath()%>/images/body_05.jpg) no-repeat; height: 155px">
									<div style="text-align: left; width: 265px; float: right; height: 125px; _height: 95px">
										<table border=0 cellspacing=0 cellpadding=0 width="100%">
											<tbody>
												<tr>
													<td style="height: 50px">
														<input class="easyui-textbox" name="userName" required="true" />

													</td>
												</tr>
												<tr>
													<td>
														<input class="easyui-passwordbox" name="password" required="true" />
													</td>
												</tr>
												<tr>
												<tr>
													<td>
														<div style="margin-top: 6px; vertical-align: middle;">
															<img style="margin-top: 10px; vertical-align: middle;" src="creatImgCode.action" onclick="this.src='creatImgCode.action?'+Math.random()" />
															<input class="easyui-textbox" name="code" style="vertical-align: middle; width: 88px; height: 25px; margin-top: 155px;" data-options="required:true,prompt:'验证码'" />
															<span id="err_mes" style="color: red; font-size: 12px; width: 20px;"> </span>
														</div>
													</td>
												</tr>
											</tbody>
										</table>

									</div>
									<div style="height: 1px; clear: both"></div>
								</div>
							</div>
						</div>
						<div style="margin: 0px auto; width: 936px; height: 80px;">
							<div style="background: url(<%=request.getContextPath()%>/images/body_07.jpg) no-repeat; height: 90px;margin-left: 1px;">
								<div style="width: 380px; float: right; clear: both">
									<table border='0' cellSpacing='0' cellPadding='0' width='300'>
										<tbody>
											<tr>
												<td width="100" align='right'>
													<a style="width: 100px; margin-left: 80px;" onclick="FormSubmit()" class="easyui-linkbutton">登陆</a>
												</td>
												<td width="100">
													<a style="width: 100px; margin-left: 30px;" onclick="FormRest()" class="easyui-linkbutton">重置</a>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<img src="<%=request.getContextPath()%>/images/body_06.jpg" style="margin-left: 4px;">
							</div>
						</div>
					</td>
				</tr>
				<tr style="height: 30%">
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>