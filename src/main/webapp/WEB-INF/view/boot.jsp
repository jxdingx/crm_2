<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-theme.min.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form role="form">
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label>
						<input class="form-control" id="exampleInputEmail1" type="email" />
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label>
						<input class="form-control" id="exampleInputPassword1" type="password" />
					</div>
					<div class="form-group">
						<label for="exampleInputFile">File input</label>
						<input id="exampleInputFile" type="file" />
						<p class="help-block">Example block-level help text here.</p>
					</div>
					<div class="checkbox">
						<label>
							<input type="checkbox" />
							Check me out
						</label>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<div class="btn-group">
					<button class="btn btn-default">Action</button>
					<button data-toggle="dropdown" class="btn btn-default dropdown-toggle">
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li>
							<a href="#">操作</a>
						</li>
						<li class="disabled">
							<a href="#">另一操作</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="#">其它</a>
						</li>
					</ul>
				</div>
				<button type="button" class="btn btn-primary btn-lg active">按钮</button>
				<ul class="pagination pagination-lg">
					<li>
						<a href="#">Prev</a>
					</li>
					<li>
						<a href="#">1</a>
					</li>
					<li>
						<a href="#">2</a>
					</li>
					<li>
						<a href="#">3</a>
					</li>
					<li>
						<a href="#">4</a>
					</li>
					<li>
						<a href="#">5</a>
					</li>
					<li>
						<a href="#">Next</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>