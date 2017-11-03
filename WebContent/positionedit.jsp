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
			<div class="panel-heading"><h4>Position Edit Data</h4></div>
			<div class="panel-body" align="center">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-4">Position Name</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="pos_name" value="${positionedit.getPname()}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Status</label>
						<c:choose>
						<c:when test="${positionedit.getStatusId() == 001}">
							<div class="col-sm-1">
								<label class="radio-inline"><input type="radio" name="optradio" value="001" checked="checked">ใช้งาน</label>
							</div>
							<div class="col-sm-1">
								<label class="radio-inline"><input type="radio" name="optradio" value="002">ไม่ใช้งาน</label>
							</div>
						</c:when>
						<c:when test="${positionedit.getStatusId() == 002}">
							<div class="col-sm-1">
								<label class="radio-inline"><input type="radio" name="optradio" value="001">ใช้งาน</label>
							</div>
							<div class="col-sm-1">
								<label class="radio-inline"><input type="radio" name="optradio" value="002" checked="checked">ไม่ใช้งาน</label>
							</div>
						</c:when>
						</c:choose>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ActionUpdate('PositionUpdate','${positionedit.getPid()}')">OK</button>
								<button type="button" class="btn btn-default" onclick="ActionView('PositionView')">Back</button>
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