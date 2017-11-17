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
			<div class="panel-heading"><h4>Booking Add</h4></div>
			<div class="panel-body" align="center">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-3">ภาคการศึกษา</label>
						<div class="col-sm-3">
							<select class="form-control" id="semester">
								<option value="" selected="selected" hidden>เลือกภาคการศึกษา</option>
						    	<c:forEach items="${sem_list}" var="sem_list">
						    		<option value="${sem_list.getSemesterId()}${sem_list.getYear()}"><c:out value="${sem_list.getSemesterName()} / ${sem_list.getYear()}"></c:out></option>
								</c:forEach>
						    </select>
						</div>
						
						<label class="control-label col-sm-1">ห้อง</label>
						<div class="col-sm-3">
							<select class="form-control" id="room" onchange="DetailRoomTime()">
								<option value="" selected="selected" hidden>เลือกห้อง</option>
						    	<c:forEach items="${room_list}" var="room_list">
						    		<c:choose>
						    			<c:when test="${room_list.getRoomNum() == room_select}">
						    				<option value="${room_list.getRoomNum()}" selected="selected" hidden><c:out value="${room_list.getRoomNum()}"></c:out></option>
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
						<div class="row">
							<div class="col-md-3"></div>
							<div style="overflow:hidden;">
								<div class="col-md-4">
									<label class="control-label">Start Date : </label>
									<div id="datetimepicker6"></div>
								</div>
							<div class="col-md-1"></div>
								<div class="col-md-4">
									<label class="control-label">End Date : </label>
									<div id="datetimepicker7"></div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="row">
							<label class="control-label col-sm-4">Start Time : </label>
							<div class="col-sm-2">
								<select class="form-control" id="st_time" onchange="EventTime('H:M')">
							    	<option value="" hidden>เวลาเริ่ม</option>
							    </select>
							</div>
							<label class="control-label col-sm-2">End Time : </label>
							<div class="col-sm-2">
								<select class="form-control" id="ed_time">
							    	<option value="" hidden>เวลาสิ้นสุด</option>
							    </select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-6">
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ActionBooking('AddBooking','${login.getUserId()}','${room_view.getRoomNum()}')">จอง</button>
								<button type="button" class="btn btn-default" onclick="ActionView('BookingView')">ยกเลิก</button>
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