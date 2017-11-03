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
			<div class="panel-heading"><h4>Approve</h4></div>
			<div class="panel-body" align="center">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Queue No.</th>
							<th>Room</th>
							<th>Firstname</th>
							<th>Lastname</th>
							<th>Start</th>
							<th>End</th>
							<th colspan="2"></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty queue_list}">
							<tr>
								<th colspan="6"><strong>ไม่มีการจอง</strong></th>
							</tr>
						</c:if>
						<c:if test="${not empty queue_list}">
							<c:forEach items="${queue_list}" var="queue_list">
								<tr>
									<th><c:out value="${queue_list.getQueueNo()}"></c:out></th>
									<th><c:out value="${queue_list.getRoomNum()}"></c:out></th>
									<th><c:out value="${queue_list.getFirstname()}"></c:out></th>
									<th><c:out value="${queue_list.getLastname()}"></c:out></th>
									<th><c:out value="${queue_list.getStartdate()}"></c:out> <c:out value="${queue_list.getStarttime()}"></c:out></th>
									<th><c:out value="${queue_list.getEnddate()}"></c:out> <c:out value="${queue_list.getEndtime()}"></c:out></th>
									<th width="100">
										<button type="button" class="btn btn-default btn-sm" onclick="ActionApprove('Approve','${queue_list.getBookingId()}','${queue_list.getG_BookingNo()}','${queue_list.getRoomNum()}','${queue_list.getQueueNo()}')">อนุมัติ</button>
									</th>
									<th width="100">
										<button type="button" class="btn btn-default btn-sm" onclick="ActionApprove('NonApprove','${queue_list.getBookingId()}','${queue_list.getG_BookingNo()}','${queue_list.getRoomNum()}','${queue_list.getQueueNo()}')">ยกเลิก</button>
									</th>
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