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
			<div class="panel-heading"><h4>Room Edit Data</h4></div>
			<div class="panel-body" align="center">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-4">หมายเลขห้อง</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="room_name" value="${roomedit.getRoomNum()}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">จำนวนแถว</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="line" value="${roomedit.getLine()}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">จำนวนที่นั่งต่อแถว</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="lps" value="${roomedit.getLPS()}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Building</label>
						<div class="col-sm-4">
							<select class="form-control" id="building">
							<option value="${roomedit.getBuildId()}"><c:out value="${roomedit.getBuildName()}"></c:out></option>
						    	<c:forEach items="${building_list}" var="building_list">
									<option value="${building_list.getBuildId()}"><c:out value="${building_list.getBuildName()}"></c:out></option>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Category</label>
						<div class="col-sm-4">
							<select class="form-control" id="category">
							<option value="${roomedit.getCatId()}"><c:out value="${roomedit.getCatName()}"></c:out></option>
						    	<c:forEach items="${category_list}" var="category_list">
									<option value="${category_list.getCatId()}"><c:out value="${category_list.getCatName()}"></c:out></option>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Status</label>
						<c:choose>
						<c:when test="${roomedit.getStatusRoomId() == 001}">
							<div class="col-sm-2">
								<label class="radio"><input type="radio" name="optradio" value="001" checked="checked">ใช้งาน</label>
							</div>
								<div class="col-sm-2">
								<label class="radio"><input type="radio" name="optradio" value="004">ไม่พร้อมใช้งาน</label>
							</div>
							<div class="col-sm-2">
								<label class="radio"><input type="radio" name="optradio" value="005">ปิดห้อง</label>
							</div>
						</c:when>
						<c:when test="${roomedit.getStatusRoomId() == 004}">
							<div class="col-sm-2">
								<label class="radio"><input type="radio" name="optradio" value="001">ใช้งาน</label>
							</div>
								<div class="col-sm-2">
								<label class="radio"><input type="radio" name="optradio" value="004" checked="checked">ไม่พร้อมใช้งาน</label>
							</div>
							<div class="col-sm-2">
								<label class="radio"><input type="radio" name="optradio" value="005">ปิดห้อง</label>
							</div>
						</c:when>
						<c:when test="${roomedit.getStatusRoomId() == 005}">
							<div class="col-sm-2">
								<label class="radio"><input type="radio" name="optradio" value="001">ใช้งาน</label>
							</div>
								<div class="col-sm-2">
								<label class="radio"><input type="radio" name="optradio" value="004">ไม่พร้อมใช้งาน</label>
							</div>
							<div class="col-sm-2">
								<label class="radio"><input type="radio" name="optradio" value="005" checked="checked">ปิดห้อง</label>
							</div>
						</c:when>
						</c:choose>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ActionRoom('RoomUpdate','${roomedit.getRoomNum()}')">OK</button>
								<button type="button" class="btn btn-default" onclick="ActionView('RoomView')">Back</button>
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