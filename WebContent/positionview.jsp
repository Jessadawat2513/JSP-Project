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
			<div class="panel-heading"><h4>Position</h4></div>
			<div class="panel-body" align="center">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th><h4><strong>No.</strong></h4></th>
							<th><h4><strong>PositionName</strong></h4></th>
							<th colspan="2"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${positionview}" var="position" varStatus="positionNo" begin="1">
						<tr>
						<c:choose>
						<c:when test="${position.getStatusId() == 001}">
							<th width="70"><c:out value="${positionNo.count}"></c:out></th>
							<th class="bg-active"><c:out value="${position.getPname()}"></c:out></th>
							<th width="60">
								<button type="button" class="btn btn-default" onclick="ActionEdit('PositionEdit','${position.getPid()}')">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>
							</th>
							<th width="60">
								<button type="button" class="btn btn-default" onclick="ActionDelete('PositionDelete','${position.getPid()}')">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</th>
						</c:when>
						<c:when test="${position.getStatusId() == 002}">
							<th width="70"><c:out value="${positionNo.count}"></c:out></th>
							<th class="bg-nonactive"><c:out value="${position.getPname()}"></c:out></th>
							<th width="60">
								<button type="button" class="btn btn-default" onclick="ActionEdit('PositionEdit','${position.getPid()}')">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>
							</th>
							<th width="60">
								<button type="button" class="btn btn-default" onclick="ActionDelete('PositionDelete','${position.getPid()}','${position.getStatusId()}')">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</th>
						</c:when>
						</c:choose>
						</tr>
						</c:forEach>
					</tbody>
					</table>
					<div class="btn-group">
						<button type="button" class="btn btn-default" onclick="goto('positionadd')">Add</button>
						<button type="button" class="btn btn-default" onclick="goto('home')">Back</button>
					</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>