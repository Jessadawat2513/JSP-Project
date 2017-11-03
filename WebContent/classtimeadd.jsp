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
			<div class="panel-heading"><h4>Classtime Add</h4></div>
			<div class="panel-body" align="center">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-4">Day</label>
						<div class="col-sm-4">
							<select class="form-control" id="day">
						    	<c:forEach items="${day_list}" var="day_list">
									<option value="${day_list.getDayId()}"><c:out value="${day_list.getDayName()}"></c:out></option>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Class</label>
						<div class="col-sm-4">
							<select class="form-control" id="class">
								<c:forEach items="${classes_list}" var="classes_list">
									<option value="${classes_list.getClassId()}"><c:out value="${classes_list.getClassName()}"></c:out></option>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Start Time : </label>
						<div class="col-sm-4">
							<input type="time" class="form-control" id="st_time">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">End Time : </label>
						<div class="col-sm-4">
							<input type="time" class="form-control" id="ed_time">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ActionClasstime('Add')">Add</button>
								<button type="button" class="btn btn-default" onclick="">Back</button>
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