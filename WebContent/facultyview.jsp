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
			<div class="panel-heading"><h4>Faculty</h4></div>
			<div class="panel-body" align="center">
					<table class="table table-bordered">
					<thead>
						<tr>
							<th><h4><strong>No.</strong></h4></th>
							<th><h4><strong>Facultyname</strong></h4></th>
							<th colspan="3"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${facultyview}" var="facultyview" varStatus="facultyNo" begin="1">
						<tr>
						<c:choose>
							<c:when test="${facultyview.getStatusId() == 001}">
								<th width="50"><c:out value="${facultyNo.count}"></c:out></th>
								<th class="bg-active"><c:out value="${facultyview.getFacName()}"></c:out></th>
								<th width="50">
									<button type="button" class="btn btn-default" onclick="BranchAction('BranchView','${facultyview.getFacId()}')">
										<span class="glyphicon glyphicon glyphicon-list-alt"></span>
									</button>
								</th>
								<th width="50">
									<button type="button" class="btn btn-default" onclick="ActionEdit('FacultyEdit','${facultyview.getFacId()}')">
										<span class="glyphicon glyphicon-pencil"></span>
									</button>
								</th>
								<th width="50">
									<button type="button" class="btn btn-default" onclick="ActionDelete('FacultyDelete','${facultyview.getFacId()}','${facultyview.getStatusId()}')">
										<span class="glyphicon glyphicon-trash"></span>
									</button>
								</th>
							</c:when>
							<c:when test="${facultyview.getStatusId() == 002}">
								<th width="50"><c:out value="${facultyNo.count}"></c:out></th>
								<th class="bg-nonactive"><c:out value="${facultyview.getFacName()}"></c:out></th>
								<th width="50">
									<button type="button" class="btn btn-default" onclick="BranchAction('BranchView','${facultyview.getFacId()}')">
										<span class="glyphicon glyphicon glyphicon-list-alt"></span>
									</button>
								</th>
								<th width="50">
									<button type="button" class="btn btn-default" onclick="ActionEdit('FacultyEdit','${facultyview.getFacId()}')">
										<span class="glyphicon glyphicon-pencil"></span>
									</button>
								</th>
								<th width="50">
									<button type="button" class="btn btn-default" onclick="ActionDelete('FacultyDelete','${facultyview.getFacId()}','${facultyview.getStatusId()}')">
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
						<button type="button" class="btn btn-default" onclick="goto('facultyadd')">Add</button>
						<button type="button" class="btn btn-default" onclick="goto('home')">Back</button>
					</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>