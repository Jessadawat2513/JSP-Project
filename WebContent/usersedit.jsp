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
			<div class="panel-heading"><h4>Users Edit Data</h4></div>
			<div class="panel-body" align="center">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-4">Username</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="username" value="${usersedit.getUsername()}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Password</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="password" value="${usersedit.getPassword()}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Firstname</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="firstname" value="${usersedit.getFirstname()}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Lastname</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="lastname" value="${usersedit.getLastname()}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Position</label>
						<div class="col-sm-4">
							<select class="form-control" id="position">
						    	<c:forEach items="${user_position}" var="user_position">
						    		<c:choose>
						    			<c:when test="${usersedit.getPosId() == user_position.getPid()}">
						    				<option value="${user_position.getPid()}" selected="selected"><c:out value="${user_position.getPname()}"></c:out></option>
						    			</c:when>
						    			<c:otherwise>
						    				<option value="${user_position.getPid()}"><c:out value="${user_position.getPname()}"></c:out></option>
						    			</c:otherwise>
						    		</c:choose>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Faculty</label>
						<div class="col-sm-4">
							<select class="form-control" id="faculty" onchange="ActionUsers('UsersAddUpdate')">
								<c:forEach items="${user_faculty}" var="user_faculty">
									<c:choose>
										<c:when test="${usersedit.getFacId() == user_faculty.getFacId()}">
											<option value="${user_faculty.getFacId()}" selected="selected"><c:out value="${user_faculty.getFacName()}"></c:out></option>
										</c:when>
										<c:otherwise>
											<option value="${user_faculty.getFacId()}"><c:out value="${user_faculty.getFacName()}"></c:out></option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Branch</label>
						<div class="col-sm-4">
							<select class="form-control" id="branch">
								<c:forEach items="${user_branch}" var="user_branch">
									<c:choose>
										<c:when test="${usersedit.getBraName() == user_branch.getBranchName()}">
											<option value="${user_branch.getBranchName()}" selected="selected"><c:out value="${user_branch.getBranchName()}"></c:out></option>
										</c:when>
										<c:otherwise>
											<option value="${user_branch.getBranchName()}"><c:out value="${user_branch.getBranchName()}"></c:out></option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Department</label>
						<div class="col-sm-4">
							<select class="form-control" id="department">
						    	<c:forEach items="${user_department}" var="user_department">
									<c:choose>
										<c:when test="${usersedit.getDepId() == user_department.getDepId()}">
											<option value="${user_department.getDepId()}" selected="selected"><c:out value="${user_department.getDepName()}"></c:out></option>
										</c:when>
										<c:otherwise>
											<option value="${user_department.getDepId()}"><c:out value="${user_department.getDepName()}"></c:out></option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Status</label>
						<c:choose>
						<c:when test="${usersedit.getStatus() == 001}">
							<div class="col-sm-2">
								<label class="radio-inline"><input type="radio" name="optradio" value="001" checked="checked">ศึกษา/ทำงานอยู่</label>
							</div>
							<div class="col-sm-1">
								<label class="radio-inline"><input type="radio" name="optradio" value="002">ลาออก</label>
							</div>
						</c:when>
						<c:when test="${usersedit.getStatus() == 002}">
							<div class="col-sm-2">
								<label class="radio-inline"><input type="radio" name="optradio" value="001">ศึกษา/ทำงานอยู่</label>
							</div>
							<div class="col-sm-1">
								<label class="radio-inline"><input type="radio" name="optradio" value="002" checked="checked">ลาออก</label>
							</div>
						</c:when>
						</c:choose>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ActionUsers('UsersUpdate','${usersedit.getUserId()}')">Add</button>
								<button type="button" class="btn btn-default" onclick="ActionView('UsersView')">Back</button>
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