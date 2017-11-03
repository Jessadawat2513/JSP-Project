<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="link.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    session=request.getSession(false);
	if(session.getAttribute("login")==null)
	{
	    response.sendRedirect("index.jsp");
	}
%>
<div class="viewport">
	<div class="contrainermain">
	<jsp:include page="header-wrapper.jsp"></jsp:include>
	<jsp:include page="bar-wrapper.jsp"></jsp:include>
	<jsp:include page="menu-wrapper.jsp"></jsp:include>
	<div class="body-wrapper">
		<div class="panel panel-primary">
			<div class="panel-heading"><h4>Course Add Data</h4></div>
			<div class="panel-body" align="center">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-4">Course Code</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="code" placeholder="Course Code">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Course Name</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="c_name" placeholder="Course Name">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Credit</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="credit" placeholder="Credit">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ActionAdd('CourseAdd')">Add</button>
								<button type="button" class="btn btn-default" onclick="ActionView('CourseView')">Back</button>
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