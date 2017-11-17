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
			<div class="panel-heading"><h4>Schedule Class</h4></div>
			<div class="panel-body" align="center">
				<div class="row">
					<div class="form-group col-sm-1"></div>
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
							<c:forEach items="${b_list}" var="b_list">
								<option value="${b_list.getBuildId()}"><c:out value="${b_list.getBuildName()}"></c:out></option>
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
					<div class="form-group col-sm-2">
						&nbsp;
						<div class="col-sm-offset-3">
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ScheduleOnButton()">จอง</button>
								<button type="button" class="btn btn-default" onclick="">กลับ</button>
							</div>
						</div>
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
							<td onclick="ScheduleOnTd('sun001')" class="Active" width="213px"><div id='sun001'></div></td>
							<td onclick="ScheduleOnTd('sun002')" class="Active" width="213px"><div id='sun002'></div></td>
							<td onclick="ScheduleOnTd('sun003')" class="Active" width="213px"><div id='sun003'></div></td>
							<td onclick="ScheduleOnTd('sun004')" class="Active" width="213px"><div id='sun004'></div></td>
							<td onclick="ScheduleOnTd('sun005')" class="Active" width="213px"><div id='sun005'></div></td>
						</tr>
						<tr height="100px">
							<td width="100"><strong><h4>จันทร์</h4></strong></td>
							<td onclick="ScheduleOnTd('mon001')" class="Active" width="213px"><div id='mon001'></div></td>
							<td onclick="ScheduleOnTd('mon002')" class="Active" width="213px"><div id='mon002'></div></td>
							<td onclick="ScheduleOnTd('mon003')" class="Active" width="213px"><div id='mon003'></div></td>
							<td onclick="ScheduleOnTd('mon004')" class="Active" width="213px"><div id='mon004'></div></td>
							<td onclick="ScheduleOnTd('mon005')" class="Active" width="213px"><div id='mon005'></div></td>
						</tr>
						<tr height="100px">
							<td width="100"><strong><h4>อังคาร</h4></strong></td>
							<td onclick="ScheduleOnTd('tue001')" class="Active" width="213px"><div id='tue001'></div></td>
							<td onclick="ScheduleOnTd('tue002')" class="Active" width="213px"><div id='tue002'></div></td>
							<td onclick="ScheduleOnTd('tue003')" class="Active" width="213px"><div id='tue003'></div></td>
							<td onclick="ScheduleOnTd('tue004')" class="Active" width="213px"><div id='tue004'></div></td>
							<td onclick="ScheduleOnTd('tue005')" class="Active" width="213px"><div id='tue005'></div></td>
						</tr>
						<tr height="100px">
							<td width="100"><strong><h4>พุธ</h4></strong></td>
							<td onclick="ScheduleOnTd('wed001')" class="Active" width="213px"><div id='wed001'></div></td>
							<td onclick="ScheduleOnTd('wed002')" class="Active" width="213px"><div id='wed002'></div></td>
							<td onclick="ScheduleOnTd('wed003')" class="Active" width="213px"><div id='wed003'></div></td>
							<td onclick="ScheduleOnTd('wed004')" class="Active" width="213px"><div id='wed004'></div></td>
							<td onclick="ScheduleOnTd('wed005')" class="Active" width="213px"><div id='wed005'></div></td>
						</tr>
						<tr height="100px">
							<td width="100"><strong><h4>พฤหัสบดี</h4></strong></td>
							<td onclick="ScheduleOnTd('thu001')" class="Active" width="213px"><div id='thu001'></div></td>
							<td onclick="ScheduleOnTd('thu002')" class="Active" width="213px"><div id='thu002'></div></td>
							<td onclick="ScheduleOnTd('thu003')" class="Active" width="213px"><div id='thu003'></div></td>
							<td onclick="ScheduleOnTd('thu004')" class="Active" width="213px"><div id='thu004'></div></td>
							<td onclick="ScheduleOnTd('thu005')" class="Active" width="213px"><div id='thu005'></div></td>
						</tr>
						<tr height="100px">
							<td width="100"><strong><h4>ศุกร์</h4></strong></td>
							<td onclick="ScheduleOnTd('fri001')" class="Active" width="213px"><div id='fri001'></div></td>
							<td onclick="ScheduleOnTd('fri002')" class="Active" width="213px"><div id='fri002'></div></td>
							<td onclick="ScheduleOnTd('fri003')" class="Active" width="213px"><div id='fri003'></div></td>
							<td onclick="ScheduleOnTd('fri004')" class="Active" width="213px"><div id='fri004'></div></td>
							<td onclick="ScheduleOnTd('fri005')" class="Active" width="213px"><div id='fri005'></div></td>
						</tr>
						<tr height="100px">
							<td width="100"><strong><h4>เสาร์</h4></strong></td>
							<td onclick="ScheduleOnTd('sat001')" class="Active" width="213px"><div id='sat001'></div></td>
							<td onclick="ScheduleOnTd('sat002')" class="Active" width="213px"><div id='sat002'></div></td>
							<td onclick="ScheduleOnTd('sat003')" class="Active" width="213px"><div id='sat003'></div></td>
							<td onclick="ScheduleOnTd('sat004')" class="Active" width="213px"><div id='sat004'></div></td>
							<td onclick="ScheduleOnTd('sat005')" class="Active" width="213px"><div id='sat005'></div></td>
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