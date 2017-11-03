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
			<div class="panel-heading"><h4>Booking History</h4></div>
			<div class="panel-body" align="center">
				<table class="table table-bordered">
					<thead>
						<th>หมายเลขการจอง</th>
						<th>ชื่อห้อง</th>
						<th colspan="2">วัน เวลา ที่จอง</th>
						<th>สถานะการจอง</th>
						<th colspan="2"></th>
					</thead>
					<tbody>
						<c:if test="${empty g_booking_list}">
							<tr>
								<th colspan="5"><strong>ไม่มีรายการจอง</strong></th>
							</tr>
						</c:if>
						<c:if test="${not empty g_booking_list}">
							<c:forEach items="${g_booking_list}" var="g_booking_list">
								<tr>
									<th><c:out value="${g_booking_list.getBookingId()}"></c:out></th>
									<th><c:out value="${g_booking_list.getRoomNum()}"></c:out></th>
									<th><c:out value="${g_booking_list.getStartDate()}"></c:out> <c:out value="${g_booking_list.getStartTime()}"></c:out></th>
									<th><c:out value="${g_booking_list.getEndDate()}"></c:out> <c:out value="${g_booking_list.getEndTime()}"></c:out></th>
									<th><c:out value="${g_booking_list.getStatusName()}"></c:out></th>
									<th width="60">
										<button type="button" class="btn btn-default" onclick="ActionBooking('EditBooking','${login.getUserId()}','${g_booking_list.getRoomNum()}','${g_booking_list.getBookingId()}','${g_booking_list.getG_BookingNo()}')">
											<span class="glyphicon glyphicon-pencil"></span>
										</button>
									</th>
									<th width="60">
										<button type="button" class="btn btn-default" onclick="ActionHistory('Cancel','${login.getUserId()}','${g_booking_list.getBookingId()}','${g_booking_list.getG_BookingNo()}')">
											<span class="glyphicon glyphicon-remove"></span>
										</button>
									</th>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
				<div class="btn-group">
					<button type="button" class="btn btn-default" onclick="goto('home')">Back</button>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>