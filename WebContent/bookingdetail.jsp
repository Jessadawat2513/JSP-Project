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
			<div class="panel-heading"><h4>Booking Detail</h4></div>
			<div class="panel-body" align="center">
				<div class="form-group" style="text-align: left;">
					<div class="form-group col-sm-1"></div>
					<div class="form-group col-sm-6">
						<label><h4>ชื่อผู้จอง : </h4></label>
						<label><h4><c:out value="${user_view.getFirstname()}"></c:out></h4></label>
						<label><h4><c:out value="${user_view.getLastname()}"></c:out></h4></label>
					</div>
					<div class="form-group col-sm-5">
						<label><h4>ตำแหน่ง : </h4></label>
						<label><h4><c:out value="${user_view.getPosName()}"></c:out></h4></label>
					</div>
					<div class="form-group col-sm-1"></div>
					<div class="form-group col-sm-4">
						<label><h4>คณะ : </h4></label>
						<label><h4><c:out value="${user_view.getFacName()}"></c:out></h4></label>
					</div>
					<div class="form-group col-sm-4">
						<label><h4>สาขา : </h4></label>
						<label><h4><c:out value="${user_view.getBraName()}"></c:out></h4></label>
					</div>
					<div class="form-group col-sm-3">
						<label><h4>หน่วยงาน : </h4></label>
						<label><h4><c:out value="${user_view.getDepName()}"></c:out></h4></label>
					</div>
				</div>
				&nbsp;
				<div class="form-group">
					<div class="form-group col-sm-6">
						<label><h4>ชื่อห้อง : </h4></label>
						<label><h4><c:out value="${room_view.getRoomNum()}"></c:out></h4></label>
					</div>
					<div class="form-group col-sm-6">
						<label><h4>จำนวนที่นั่ง : </h4></label>
						<label><h4><c:out value="${room_view.getSeat()}"></c:out> ที่นั่ง</h4></label>
					</div>
					<div class="form-group col-sm-6">
						<label><h4>ประเภท : </h4></label>
						<label><h4><c:out value="${room_view.getCatName()}"></c:out></h4></label>
					</div>
					<div class="form-group col-sm-6">
						<label><h4>อาคาร : </h4></label>
						<label><h4><c:out value="${room_view.getBuildName()}"></c:out></h4></label>
					</div>
				</div>
				&nbsp;
				<div class="form-group row">
					<div class="col-sm-offset-3 col-sm-6">
						<div class="btn-group">
							<button type="button" class="btn btn-default" onclick="ActionBooking('AddView','','${room_view.getRoomNum()}')">จอง</button>
							<button type="button" class="btn btn-default" onclick="ActionView('BookingView')">กลับ</button>
						</div>
					</div>
				</div>
				&nbsp;
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>No.</th>
							<th>Firstname</th>
							<th>Lastname</th>
							<th>Start Date</th>
							<th>End Date</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty g_booking_list}">
							<tr>
								<th colspan="6"><c:out value="ไม่มีผลลัพธ์"></c:out></th>
							</tr>
						</c:if>
						<c:if test="${not empty g_booking_list}">
							<c:forEach items="${g_booking_list}" var="g_booking_list" varStatus="g_booking_No">
								<tr>
									<th><c:out value="${g_booking_No.count}"></c:out></th>
									<th><c:out value="${g_booking_list.getFirstname()}"></c:out></th>
									<th><c:out value="${g_booking_list.getLastname()}"></c:out></th>
									<th><c:out value="${g_booking_list.getStartDate()}"></c:out> <c:out value="${g_booking_list.getStartTime()}"></c:out></th>
									<th><c:out value="${g_booking_list.getEndDate()}"></c:out> <c:out value="${g_booking_list.getEndTime()}"></c:out></th>
									<th><c:out value="${g_booking_list.getStatusName()}"></c:out></th>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>