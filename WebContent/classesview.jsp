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
			<div class="panel-heading"><h4></h4></div>
			<div class="panel-body" align="center">
					<table class="table table-bordered">
					<thead>
						<tr>
							<th><h4><strong>No.</strong></h4></th>
							<th><h4><strong>ชื่อคาบ</strong></h4></th>
							<th colspan="2"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${classesview}" var="classesview" varStatus="classesNo">
						<tr>
						<c:choose>
							<c:when test="${classesview.getStatusId() == 001}">
								<th width="70"><c:out value="${classesNo.count}"></c:out></th>
								<th class="bg-active"><c:out value="${classesview.getClassName()}"></c:out></th>
								<th width="60">
									<button type="button" class="btn btn-default" onclick="ActionEdit('ClassesEdit','${classesview.getClassId()}')">
										<span class="glyphicon glyphicon-pencil"></span>
									</button>
								</th>
								<th width="60">
									<button type="button" class="btn btn-default" onclick="ActionDelete('ClassesDelete','${classesview.getClassId()}','${classesview.getStatusId()}')">
										<span class="glyphicon glyphicon-trash"></span>
									</button>
								</th>
							</c:when>
							<c:when test="${classesview.getStatusId() == 002}">
								<th width="70"><c:out value="${classesNo.count}"></c:out></th>
								<th class="bg-nonactive"><c:out value="${classesview.getClassName()}"></c:out></th>
								<th width="60">
									<button type="button" class="btn btn-default" onclick="ActionEdit('ClassesEdit','${classesview.getClassId()}')">
										<span class="glyphicon glyphicon-pencil"></span>
									</button>
								</th>
								<th width="60">
									<button type="button" class="btn btn-default" onclick="ActionDelete('ClassesDelete','${classesview.getClassId()}','${classesview.getStatusId()}')">
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
						<button type="button" class="btn btn-default" onclick="goto('classesadd')">Add</button>
						<button type="button" class="btn btn-default" onclick="goto('home')">Back</button>
					</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>