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
			<div class="panel-heading"><h4>Users View</h4></div>
			<div class="panel-body" align="center">
					<table class="table table-bordered">
					<thead>
						<tr>
							<th><h4><strong>No.</strong></h4></th>
							<th><h4><strong>Username</strong></h4></th>
							<th><h4><strong>Password</strong></h4></th>
							<th><h4><strong>ชื่อ</strong></h4></th>
							<th><h4><strong>นามสกุล</strong></h4></th>
							<th><h4><strong>ตำแหน่ง</strong></h4></th>
							<th><h4><strong>คณะ</strong></h4></th>
							<th><h4><strong>สาขา</strong></h4></th>
							<th><h4><strong>หน่วยงาน</strong></h4></th>
							<th><h4><strong>สถานะ</strong></h4></th>
							<th colspan="2"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${usersview}" var="usersview" varStatus="usersNo" begin="1">
						<tr>
							<th width="50"><c:out value="${usersNo.count}"></c:out></th>
							<th><c:out value="${usersview.getUsername()}"></c:out></th>
							<th><c:out value="${usersview.getPassword()}"></c:out></th>
							<th><c:out value="${usersview.getFirstname()}"></c:out></th>
							<th><c:out value="${usersview.getLastname()}"></c:out></th>
							<th><c:out value="${usersview.getPosName()}"></c:out></th>
							<th><c:out value="${usersview.getFacName()}"></c:out></th>
							<th><c:out value="${usersview.getBraName()}"></c:out></th>
							<th><c:out value="${usersview.getDepName()}"></c:out></th>
							<th width="50">
								<button type="button" class="btn btn-default" onclick="ActionUsers('UsersEdit','${usersview.getUserId()}')">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>
							</th>
							<th width="50">
								<button type="button" class="btn btn-default" onclick="ActionUsers('UsersDelete','${usersview.getUserId()}','${usersview.getStatus()}')">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</th>
						</tr>
						</c:forEach>
					</tbody>
					</table>
					<div class="btn-group">
						<button type="button" class="btn btn-default" onclick="ActionUsers('UsersAddView')">Add</button>
						<button type="button" class="btn btn-default" onclick="goto('home')">Back</button>
					</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>