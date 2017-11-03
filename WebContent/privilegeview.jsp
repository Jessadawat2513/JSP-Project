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
			<div class="panel-heading"><h4>Privilege</h4></div>
			<div class="panel-body" align="center">
				<table style="width: 25%;">
					<thead>
						<tr>
							<th>
								<div class="form-group">
									<label><h4><strong>Position</strong></h4></label>
									<select class="form-control" id="position" onchange="ActionPrivilege('PositionChange','PrivilegeChange')">
										<option value="000"><c:out value="-------------- Select Position --------------"></c:out></option>
										<c:forEach items="${positionview}" var="positionview" begin="1">
											<c:choose>
												<c:when test="${positionview.getStatusId() == 001}">
													<option value="${positionview.getPid()}"><c:out value="${positionview.getPname()}"></c:out></option>
												</c:when>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${privilegeview}" var="privilegeview" varStatus="privilegeNo">
						<tr>
							<th id="showdata")>
								<div class="checkbox" id="CheckboxShow" align="left">
									<label><input type="checkbox" name="privilege" id="${privilegeNo.count}" value="${privilegeview.getPrivilegeId()}"><c:out value="${privilegeview.getPrivilegeName()}"></c:out></label>
								</div>
							</th>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="btn-group">
					<button type="button" class="btn btn-default" onclick="ActionPrivilege('PrivilegeChange','PrivilegeUpdate')">OK</button>
					<button type="button" class="btn btn-default" onclick="goto('home')">Back</button>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>