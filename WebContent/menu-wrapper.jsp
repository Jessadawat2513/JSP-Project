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
	<c:forEach items="${login}" var="login">
		<c:choose>
			<c:when test="${login.getLicenseId() == 001}">
			<c:choose>
				<c:when test="${login.getStatusId() == 001}">
					<div id="001"><c:out value="${login.getLicenseName()}"></c:out></div>
				</c:when>
			</c:choose>
			</c:when>
			<c:when test="${login.getLicenseId() == 002}">
			<c:choose>
				<c:when test="${login.getStatusId() == 001}">
					<div id="002"><c:out value="${login.getLicenseName()}"></c:out></div>
					<div id="option">
						<div id="op01"> - ข้อมูลตำแหน่ง</div>
						<div id="op02"> - ข้อมูลสถานะ</div>
						<div id="op03"> - ข้อมูลคณะ</div>
						<div id="op04"> - ข้อมูลสาขา</div>
						<div id="op05"> - ข้อมูลหน่วยงาน</div>
						<div id="op06"> - ข้อมูลประเภท</div>
						<div id="op07"> - ข้อมูลอาคาร</div>
						<div id="op08"> - ข้อมูลชั้น</div>
						<div id="op09"> - ข้อมูลเทอม</div>
						<div id="op10"> - ข้อมูลปีการศึกษา</div>
						<div id="op11"> - ข้อมูลรายวิชา</div>
					</div>
				</c:when>
			</c:choose>
			</c:when>
			<c:when test="${login.getLicenseId() == 003}">
			<c:choose>
				<c:when test="${login.getStatusId() == 001}">
					<div id="003"><c:out value="${login.getLicenseName()}"></c:out></div>
				</c:when>
			</c:choose>
			</c:when>
			<c:when test="${login.getLicenseId() == 004}">
			<c:choose>
				<c:when test="${login.getStatusId() == 001}">
					<div id="004"><c:out value="${login.getLicenseName()}"></c:out></div>
				</c:when>
			</c:choose>
			</c:when>
			<c:when test="${login.getLicenseId() == 005}">
			<c:choose>
				<c:when test="${login.getStatusId() == 001}">
					<div id="005"><c:out value="${login.getLicenseName()}"></c:out></div>
				</c:when>
			</c:choose>
			</c:when>
			<c:when test="${login.getLicenseId() == 006}">
			<c:choose>
				<c:when test="${login.getStatusId() == 001}">
					<div id="006"><c:out value="${login.getLicenseName()}"></c:out></div>
				</c:when>
			</c:choose>
			</c:when>
			<c:when test="${login.getLicenseId() == 007}">
			<c:choose>
				<c:when test="${login.getStatusId() == 001}">
					<div id="007"><c:out value="${login.getLicenseName()}"></c:out></div>
				</c:when>
			</c:choose>
			</c:when>
		</c:choose>
	</c:forEach>
	<div id="008"><c:out value="การอนุมัติจองห้อง"></c:out></div>
</div>
</body>
</html>