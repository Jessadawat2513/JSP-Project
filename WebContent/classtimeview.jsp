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
			<div class="panel-heading"><h4>Classtime</h4></div>
			<div class="panel-body" align="center">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>วัน</th>
							<th>คาบ</th>
							<th>เวลาเริ่ม</th>
							<th>เวลาสิ้นสุด</th>
							<th colspan="2"></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty classtime_list}">
							<tr>
								<td colspan="6"><strong>ไม่มีผลัพธ์</strong></td>
							</tr>
						</c:if>
						<c:if test="${not empty classtime_list}">
							<c:forEach items="${classtime_list}" var="classtime_list">
								<tr>
									<td><c:out value="${classtime_list.getDayName()}"></c:out></td>
									<td><c:out value="${classtime_list.getClassName()}"></c:out></td>
									<td><c:out value="${classtime_list.getStartTime()}"></c:out></td>
									<td><c:out value="${classtime_list.getEndTime()}"></c:out></td>
									<td width="50">
										<button type="button" class="btn btn-default" onclick="ActionClasstime('Edit','${classtime_list.getDayId()}','${classtime_list.getClassId()}')">
											<span class="glyphicon glyphicon-pencil"></span>
										</button>
									</td>
									<td width="50">
										<button type="button" class="btn btn-default" onclick="ActionClasstime('Delete','${classtime_list.getDayId()}','${classtime_list.getClassId()}')">
											<span class="glyphicon glyphicon-trash"></span>
										</button>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
				<div class="btn-group">
					<button type="button" class="btn btn-default" onclick="ActionClasstime('AddView')">Add</button>
					<button type="button" class="btn btn-default" onclick="goto('home')">Back</button>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>