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
			<div class="panel-heading"><h4>Booking Edit</h4></div>
			<div class="panel-body" align="center">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-4">Room</label>
						<div class="col-sm-4">
							<select class="form-control" id="room">
						    	<c:forEach items="${room_list}" var="room_list">
						    		<c:choose>
						    			<c:when test="${room_list.getRoomNum() == g_booking_edit.getRoomNum()}">
						    				<option value="${room_list.getRoomNum()}" selected="selected"><c:out value="${room_list.getRoomNum()}"></c:out></option>
						    			</c:when>
						    			<c:otherwise>
						    				<option value="${room_list.getRoomNum()}"><c:out value="${room_list.getRoomNum()}"></c:out></option>
						    			</c:otherwise>
						    		</c:choose>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Start Date : </label>
						<div class="col-sm-4">
							<input type="date" class="form-control" id="st_date" value="${g_booking_edit.getStartDate()}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Start Time : </label>
						<div class="col-sm-4">
							<input type="time" class="form-control" id="st_time" value="${g_booking_edit.getStartTime()}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">End Date : </label>
						<div class="col-sm-4">
							<input type="date" class="form-control" id="ed_date" value="${g_booking_edit.getEndDate()}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">End Time : </label>
						<div class="col-sm-4">
							<input type="time" class="form-control" id="ed_time" value="${g_booking_edit.getEndTime()}">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-6">
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ActionBooking('UpdateBooking','${login.getUserId()}','','${g_booking_edit.getBookingId()}','${g_booking_edit.getG_BookingNo()}')">OK</button>
								<button type="button" class="btn btn-default" onclick="ActionHistory('View','${login.getUserId()}')">ยกเลิก</button>
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