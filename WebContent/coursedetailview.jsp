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
			<div class="panel-heading"><h4>Course Detail</h4></div>
			<div class="panel-body" align="center">
				<table class="table table-bordered">
					<thead>
						<th>รหัสวิชา</th>
						<th>ชื่อวิชา</th>
						<th>เทอม/ปีการศึกษา</th>
						<th colspan="2"></th>
					</thead>
					<tbody>
						<c:if test="${empty coursedetail_view}">
							<tr>
								<td colspan="5">ไม่มีข้อมูล</td>
							</tr>
						</c:if>
						<c:if test="${not empty coursedetail_view}">
							<c:forEach items="${coursedetail_view}" var="coursedetail_view">
								<tr>
									<td><c:out value="${coursedetail_view.getC_code()}"></c:out></td>
									<td><c:out value="${coursedetail_view.getC_name()}"></c:out></td>
									<td><c:out value="${coursedetail_view.getSemName()}"></c:out> / <c:out value="${coursedetail_view.getYear()}"></c:out></td>
									<td width="60">
										<button type="button" class="btn btn-default" onclick="testClick()">
											<span class="glyphicon glyphicon-pencil"></span>
										</button>
									</td>
									<td width="60">
										<button type="button" class="btn btn-default" onclick="testClick()">
											<span class="glyphicon glyphicon-trash"></span>
										</button>
									</td>
								<tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
				<div class="btn-group">
					<button type="button" class="btn btn-default" onclick="ActionCoursedetail('AddView')">Add</button>
					<button type="button" class="btn btn-default" onclick="goto('home')">Back</button>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>