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
			<div class="panel-heading"><h4>Semester Add Data</h4></div>
			<div class="panel-body" align="center">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-4">Semester</label>
						<div class="col-sm-4">
							<select class="form-control" id="semester">
								<c:forEach items="${d_sem_list}" var="d_sem_list">
									<c:if test="${empty d_sem_list}">
										<option>ไม่มี</option>
									</c:if>
									<c:if test="${not empty d_sem_list}">
										<option value="${d_sem_list.getSemesterId()}"><c:out value="${d_sem_list.getSemesterName()}"></c:out></option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Year</label>
						<div class="col-sm-4">
							<select class="form-control" id="year">
								<c:forEach items="${year_list}" var="year_list">
									<c:choose>
										<c:when test="${year_list.getYear() == year.getYear()}">
											<option value="${year_list.getYear()}" selected="selected"><c:out value="${year_list.getYear()}"></c:out></option>
										</c:when>
										<c:otherwise>
											<option value="${year_list.getYear()}"><c:out value="${year_list.getYear()}"></c:out></option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Start date</label>
						<div class="col-sm-4">
							<input type="date" class="form-control" id="stdate" placeholder="Start Date">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">End date</label>
						<div class="col-sm-4">
							<input type="date" class="form-control" id="eddate" placeholder="End Date">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ActionSemester('SemesterAdd')">Add</button>
								<button type="button" class="btn btn-default" onclick="ActionView('SemesterView')">Back</button>
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