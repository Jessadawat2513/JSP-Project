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
			<div class="panel-heading"><h4>Users Add Data</h4></div>
			<div class="panel-body" align="center">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-4">Username</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="username" placeholder="USERNAME">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Password</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="password" placeholder="PASSWORD">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Firstname</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="firstname" placeholder="FIRSTNAME">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Lastname</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="lastname" placeholder="LASTNAME">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Position</label>
						<div class="col-sm-4">
							<select class="form-control" id="position">
						    	<c:forEach items="${user_position}" var="user_position">
									<option value="${user_position.getPid()}"><c:out value="${user_position.getPname()}"></c:out></option>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Faculty</label>
						<div class="col-sm-4">
							<select class="form-control" id="faculty" onchange="ActionUsers('UsersAddUpdate')">
								<c:forEach items="${user_faculty}" var="user_faculty">
									<option value="${user_faculty.getFacId()}"><c:out value="${user_faculty.getFacName()}"></c:out></option>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Branch</label>
						<div class="col-sm-4">
							<select class="form-control" id="branch">
						    	<option value="ไม่มี">ไม่มี</option>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Department</label>
						<div class="col-sm-4">
							<select class="form-control" id="department">
						    	<c:forEach items="${user_department}" var="user_department">
									<option value="${user_department.getDepId()}"><c:out value="${user_department.getDepName()}"></c:out></option>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ActionUsers('UsersAdd')">Add</button>
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