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
			<div class="panel-heading"><h4>Course</h4></div>
			<div class="panel-body" align="center">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th><h4><strong>ชื่อห้อง</strong></h4></th>
							<th><h4><strong>จำนวนที่นั่ง</strong></h4></th>
							<th><h4><strong>ประเภท</strong></h4></th>
							<th><h4><strong>อาคาร</strong></h4></th>
							<th colspan="2"><h4><strong>เวลาที่อนุญาติใช้งาน</strong></h4></th>
							<th><h4><strong>สถานะ</strong></h4></th>
							<th colspan="2"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${roomview}" var="roomview">
						<tr>
							<th><c:out value="${roomview.getRoomNum()}"></c:out></th>
							<th><c:out value="${roomview.getSeat()}"></c:out></th>
							<th><c:out value="${roomview.getCatName()}"></c:out></th>
							<th><c:out value="${roomview.getBuildName()}"></c:out></th>
							<th><c:out value="${roomview.getStartTime()}"></c:out></th>
							<th><c:out value="${roomview.getEndTime()}"></c:out></th>
							<th><c:out value="${roomview.getStatusRoomName()}"></c:out></th>
							<th width="50">
								<button type="button" class="btn btn-default" onclick="ActionRoom('RoomEdit','${roomview.getRoomNum()}')">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>
							</th>
							<th width="50">
								<button type="button" class="btn btn-default" onclick="ActionRoom('RoomDelete','${roomview.getRoomNum()}','${roomview.getStatusRoomId()}')">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</th>
						</tr>
						</c:forEach>
					</tbody>
					</table>
					<div class="btn-group">
						<button type="button" class="btn btn-default" onclick="ActionRoom('RoomAddView')">Add</button>
						<button type="button" class="btn btn-default" onclick="testClick()">Back</button>
					</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>