<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="link.jsp"%>
<%@ include file="checksession.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="viewport">
	<div class="contrainermain">
	<jsp:include page="header-wrapper.jsp"></jsp:include>
	<jsp:include page="bar-wrapper.jsp"></jsp:include>
	<jsp:include page="menu-wrapper.jsp"></jsp:include>
	<div class="body-wrapper">
		<div class="panel panel-primary">
			<div class="panel-heading"><h4>Building Add Data</h4></div>
			<div class="panel-body" align="center">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-4">Building Name</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="b_name" placeholder="Building Name">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Position</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="position" placeholder="Building Position">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Note</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="note" placeholder="">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ActionAdd('BuildingAdd')">Add</button>
								<button type="button" class="btn btn-default" onclick="ActionView('BuildingView')">Back</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>