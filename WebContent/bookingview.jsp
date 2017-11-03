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
			<div class="panel-heading"><h4>Booking</h4></div>
			<div class="panel-body" align="center">
				<div class="form-row align-items-center">
					<div class="col-sm-3"></div>
					<div class="col-auto">
						<label class="control-label col-sm-1">ประเภทห้อง</label>
						<div class="col-sm-2">
							<select class="form-control" id="category">
						    	<option value="000">-------------------------</option>
						    	<c:forEach items="${category_list}" var="category_list">
						    		<option value="${category_list.getCatId()}"><c:out value="${category_list.getCatName()}"></c:out></option>
						    	</c:forEach>
						    </select>
						</div>
					</div>
					<div class="col-auto">
						<label class="control-label col-sm-1">อาคาร</label>
						<div class="col-sm-2">
							<select class="form-control" id="building">
						    	<option value="000">-------------------------</option>
						    	<c:forEach items="${building_list}" var="building_list">
						    		<option value="${building_list.getBuildId()}"><c:out value="${building_list.getBuildName()}"></c:out></option>
						    	</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group col-sm-2">
						<div class="btn-group">
							<button type="button" class="btn btn-default" onclick="ActionBooking('Search')">ค้นหา</button>
							<button type="button" class="btn btn-default" onclick="ActionBooking('AddView')">จอง</button>
						</div>
					</div>
				</div>
				&nbsp;
				<table class="table table-responsive" id="table">
					<thead>
						<tr>
							<th class="">No.</th>
							<th class="">ชื่อห้อง</th>
							<th class="">จำนวนที่นั่ง</th>
							<th class="">ประเภท</th>
							<th class="">สถานะ</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty room_list}">
							<tr>
								<th colspan="6"><strong>ไม่มีข้อมูลห้อง</strong></th>
							</tr>
						</c:if>
						<c:if test="${not empty room_list}">
							<c:forEach items="${room_list}" var="room_list" varStatus="room_No">
								<tr>
									<th class=""><c:out value="${room_No.count}"></c:out></th>
									<th class=""><c:out value="${room_list.getRoomNum()}"></c:out></th>
									<th class=""><c:out value="${room_list.getSeat()}"></c:out></th>
									<th class=""><c:out value="${room_list.getCatName()}"></c:out></th>
									<th class=""><c:out value="${room_list.getStatusRoomName()}"></c:out></th>
									<th width="50">
										<button type="button" class="btn btn-default" onclick="ActionBooking('ShowDetail','${login.getUserId()}','${room_list.getRoomNum()}')">
											<span class="glyphicon glyphicon glyphicon-list-alt"></span>
										</button>
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