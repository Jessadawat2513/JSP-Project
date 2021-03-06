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
							<select class="form-control" id="building" onchange="ScheduleChange('build_ch')">
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
				<table class="table table-responsive" id="table_room">
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
									<td class=""><c:out value="${room_No.count}"></c:out></td>
									<td class=""><c:out value="${room_list.getRoomNum()}"></c:out></td>
									<td class=""><c:out value="${room_list.getSeat()}"></c:out></td>
									<td class=""><c:out value="${room_list.getCatName()}"></c:out></td>
									<td class=""><c:out value="${room_list.getStatusRoomName()}"></c:out></td>
									<td width="50">
										<button type="button" class="btn btn-default" onclick="ActionBooking('ShowDetail','${login.getUserId()}','${room_list.getRoomNum()}')">
											<span class="glyphicon glyphicon glyphicon-list-alt"></span>
										</button>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
				<div class="row">
					<div class="form-group col-sm-2"></div>
					<div class="form-group col-sm-3">
						<label >ภาคการศึกษา</label>
						<select class="form-control" id="semester_td" onchange="ScheduleChange('ShowOn_T')">
							<option value="" selected="selected" hidden>เลือกภาคการศึกษา</option>
							<c:forEach items="${sem_list}" var="sem_list">
								<option value="${sem_list.getSemesterId()}${sem_list.getYear()}"><c:out value="${sem_list.getSemesterName()}/${sem_list.getYear()}"></c:out></option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-sm-3">
						<label >อาคาร</label>
						<select class="form-control" id="building_td" onchange="ScheduleChange('build_ch')">
							<option value="" selected="selected" hidden>เลือกอาคาร</option>
								<c:forEach items="${building_list}" var="building_list">
						    		<option value="${building_list.getBuildId()}"><c:out value="${building_list.getBuildName()}"></c:out></option>
						    	</c:forEach>
						</select>
					</div>
					<div class="form-group col-sm-3">
						<label >ห้อง</label>
						<select class="form-control" id="room_td" onchange="ScheduleChange('ShowOn_T')">
							<option value="" selected="selected" hidden>เลือกห้อง</option>
							<c:forEach items="${room_list}" var="room_list">
								<option value="${room_list.getRoomNum()}"><c:out value="${room_list.getRoomNum()}"></c:out></option>
							</c:forEach>
						</select>
					</div>
				</div>
				<table class="table table-bordered hover-table" id="schedule">
					<thead>
						<tr>
							<th></th>
							<th>คาบ 1</th>
							<th>คาบ 2</th>
							<th>คาบ 3</th>
							<th>คาบ 4</th>
							<th>คาบ 5</th>
						<tr>
					</thead>
					<tbody>
						<tr height="100px">
							<td width="100"><strong><h4>อาทิตย์</h4></strong></td>
							<td width="213px"><div id='sun001'></div></td>
							<td width="213px"><div id='sun002'></div></td>
							<td width="213px"><div id='sun003'></div></td>
							<td width="213px"><div id='sun004'></div></td>
							<td width="213px"><div id='sun005'></div></td>
						</tr>
						<tr height="100px">
							<td width="100"><strong><h4>จันทร์</h4></strong></td>
							<td width="213px"><div id='mon001'></div></td>
							<td width="213px"><div id='mon002'></div></td>
							<td width="213px"><div id='mon003'></div></td>
							<td width="213px"><div id='mon004'></div></td>
							<td width="213px"><div id='mon005'></div></td>
						</tr>
						<tr height="100px">
							<td width="100"><strong><h4>อังคาร</h4></strong></td>
							<td width="213px"><div id='tue001'></div></td>
							<td width="213px"><div id='tue002'></div></td>
							<td width="213px"><div id='tue003'></div></td>
							<td width="213px"><div id='tue004'></div></td>
							<td width="213px"><div id='tue005'></div></td>
						</tr>
						<tr height="100px">
							<td width="100"><strong><h4>พุธ</h4></strong></td>
							<td width="213px"><div id='wed001'></div></td>
							<td width="213px"><div id='wed002'></div></td>
							<td width="213px"><div id='wed003'></div></td>
							<td width="213px"><div id='wed004'></div></td>
							<td width="213px"><div id='wed005'></div></td>
						</tr>
						<tr height="100px">
							<td width="100"><strong><h4>พฤหัสบดี</h4></strong></td>
							<td width="213px"><div id='thu001'></div></td>
							<td width="213px"><div id='thu002'></div></td>
							<td width="213px"><div id='thu003'></div></td>
							<td width="213px"><div id='thu004'></div></td>
							<td width="213px"><div id='thu005'></div></td>
						</tr>
						<tr height="100px">
							<td width="100"><strong><h4>ศุกร์</h4></strong></td>
							<td width="213px"><div id='fri001'></div></td>
							<td  width="213px"><div id='fri002'></div></td>
							<td width="213px"><div id='fri003'></div></td>
							<td width="213px"><div id='fri004'></div></td>
							<td width="213px"><div id='fri005'></div></td>
						</tr>
						<tr height="100px">
							<td width="100"><strong><h4>เสาร์</h4></strong></td>
							<td width="213px"><div id='sat001'></div></td>
							<td width="213px"><div id='sat002'></div></td>
							<td width="213px"><div id='sat003'></div></td>
							<td width="213px"><div id='sat004'></div></td>
							<td width="213px"><div id='sat005'></div></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
				
	</div>
</div>
</body>
</html>