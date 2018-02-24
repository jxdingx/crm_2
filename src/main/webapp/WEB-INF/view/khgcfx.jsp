<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/highcharts4/js/highcharts.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		var chart = new Highcharts.Chart({
			chart : {
				type : 'column',
				renderTo : 'container',
				events : {
					load : function(event) {
						// ajax请求后台数据
						$.get("customer_findCustomerGc.action", {}, function(
								data) {
							var xArr = new Array();
							var yArr = new Array();
							for (var i = 0; i < data.length; i++) {
								xArr.push(data[i].level);
								yArr.push(data[i].state);
							}
							chart.xAxis[0].categories = xArr;
							chart.series[0].setData(yArr);
						}, "json");
					}
				}
			},
			title : {
				text : '客户构成分析'
			},
			xAxis : {
				title : '客户等级',
				categories : [ 'A', "B", "C" ]
			},
			yAxis : {
				title : {
					text : '客户数量' //指定y轴的标题
				}
			},
			series : [ {
				name : '客户',
				data : [ 1, 2, 3 ]
			} ]
		});

	});
</script>
</head>
<body style="margin: 1px;">
	<div id="container" style="min-width: 800px; height: 400px;"></div>

</body>
</html>