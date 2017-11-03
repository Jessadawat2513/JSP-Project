<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="link.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu Wrapper</title>
</head>
<body onload="menuEvent()">
<div class="menu-wrapper">
	<c:forEach items="${privilege}" var="privilege">
		<c:choose>
			<c:when test="${privilege.getPrivilegeId() == 001}">
				<c:if test="${privilege.getStatus() == 001}">
					<div onclick="ActionView('PrivilegeView')"><c:out value="${privilege.getPrivilegeName()}"></c:out></div>
				</c:if>
			</c:when>
			<c:when test="${privilege.getPrivilegeId() == 002}">
				<c:if test="${privilege.getStatus() == 001}">
					<div id="002"><c:out value="${privilege.getPrivilegeName()}"></c:out></div>
					<div id="event">
						<!--<div onclick="ActionView('PrivilegeView')">ข้อมูลสิทธิ์การใช้งาน</div>-->
						<div onclick="ActionView('PositionView')">ข้อมูลตำแหน่ง</div>
						<div onclick="ActionView('FacultyView')">ข้อมูลคณะและสาขา</div>
						<div onclick="ActionView('DepartmentView')">ข้อมูลหน่วยงาน</div>
						<div onclick="ActionView('CategoryView')">ข้อมูลประเภทห้อง</div>
						<div onclick="ActionView('SemesterView')">ข้อมูลเทอมการศึกษา</div>
						<div onclick="ActionView('CourseView')">ข้อมูลรายวิชา</div>
						<div onclick="ActionView('BuildingView')">ข้อมูลอาคาร</div>
						<div onclick="ActionView('ClassesView')">ข้อมูลคาบ</div>
						<div onclick="ActionView('ClasstimeView')">ข้อมูลคาบเรียน</div>
						<div onclick="ActionView('CoursedetailView')">รายละเอียดวิชา</div>
					</div>
				</c:if>
			</c:when>
			<c:when test="${privilege.getPrivilegeId() == 003}">
				<c:if test="${privilege.getStatus() == 001}">
					<div onclick="ActionView('UsersView')"><c:out value="${privilege.getPrivilegeName()}"></c:out></div>
				</c:if>
			</c:when>
			<c:when test="${privilege.getPrivilegeId() == 004}">
				<c:if test="${privilege.getStatus() == 001}">
					<div onclick="ActionView('RoomView')"><c:out value="${privilege.getPrivilegeName()}"></c:out></div>
				</c:if>
			</c:when>
			<c:when test="${privilege.getPrivilegeId() == 005}">
				<c:if test="${privilege.getStatus() == 001}">
					<div onclick="testClick()"><c:out value="${privilege.getPrivilegeName()}"></c:out></div>
				</c:if>
			</c:when>
			<c:when test="${privilege.getPrivilegeId() == 006}">
				<c:if test="${privilege.getStatus() == 001}">
					<div onclick="ActionView('BookingView')"><c:out value="${privilege.getPrivilegeName()}"></c:out></div>
				</c:if>
			</c:when>
			<c:when test="${privilege.getPrivilegeId() == 007}">
				<c:if test="${privilege.getStatus() == 001}">
					<div onclick="ActionView('ApproveView')"><c:out value="${privilege.getPrivilegeName()}"></c:out></div>
				</c:if>
			</c:when>
			<c:when test="${privilege.getPrivilegeId() == 008}">
				<c:if test="${privilege.getStatus() == 001}">
					<div onclick="ActionView('ApprovelineView')"><c:out value="${privilege.getPrivilegeName()}"></c:out></div>
				</c:if>
			</c:when>
		</c:choose>
	</c:forEach>
	<div onclick="ActionHistory('View','${login.getUserId()}')">ประวัติการจอง</div>
	<div onclick="Test()">ทดสอบสิ่งที่ต้องการ</div>
</div>
</body>
</html>