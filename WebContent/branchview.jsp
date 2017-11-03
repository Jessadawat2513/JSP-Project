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
			<div class="panel-heading"><h4>Branch</h4></div>
			<div class="panel-body" align="center">
				<p class="h2">คณะ</p>
				<p class="h2"><c:out value="${facultyname.getFacName()}"></c:out></p>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th><h4><strong>No.</strong></h4></th>
							<th><h4><strong>Branch</strong></h4></th>
							<th colspan="2"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${branchview}" var="branchview" varStatus="branchNo">
						<tr>
						<c:choose>
							<c:when test="${branchview.getStatusId() == 001}">
								<th width="50"><c:out value="${branchNo.count}"></c:out></th>
								<th class="bg-active"><c:out value="${branchview.getBranchName()}"></c:out></th>
								<th width="50">
									<button type="button" class="btn btn-default" onclick="ActionEdit('BranchEdit','${branchview.getBranchName()}')">
										<span class="glyphicon glyphicon-pencil"></span>
									</button>
								</th>
								<th width="50">
									<button type="button" class="btn btn-default" onclick="BranchAction('BranchDelete','${facultyname.getFacId()}','${branchview.getBranchName()}','${branchview.getStatusId()}')">
										<span class="glyphicon glyphicon-trash"></span>
									</button>
								</th>
							</c:when>
							<c:when test="${branchview.getStatusId() == 002}">
								<th width="50"><c:out value="${branchNo.count}"></c:out></th>
								<th class="bg-nonactive"><c:out value="${branchview.getBranchName()}"></c:out></th>
								<th width="50">
									<button type="button" class="btn btn-default" onclick="ActionEdit('BranchEdit','${branchview.getBranchName()}')">
										<span class="glyphicon glyphicon-pencil"></span>
									</button>
								</th>
								<th width="50">
									<button type="button" class="btn btn-default" onclick="BranchAction('BranchDelete','${facultyname.getFacId()}','${branchview.getBranchName()}','${branchview.getStatusId()}')">
										<span class="glyphicon glyphicon-trash"></span>
									</button>
								</th>
							</c:when>
						</c:choose>
						</tr>
						</c:forEach>
					</tbody>
					</table>
					<div class="btn-group">
						<button type="button" class="btn btn-default" onclick="goto('branchadd')">Add</button>
						<button type="button" class="btn btn-default" onclick="ActionView('FacultyView')">Back</button>
					</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>