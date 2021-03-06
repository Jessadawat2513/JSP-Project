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
			<div class="panel-heading"><h4>Course Detail</h4></div>
			<div class="panel-body" align="center">
				<form class="form-horizontal">
					<div class="form-group row">
						<label class="col-sm-5" style="text-align: right;"><h4>ภาคกาศึกษา :</h4></label>
						<div class="col-sm-3">
							<select class="form-control col-sm-2" id="semester" onchange="ActionCoursedetail('Change_semester_view')">
								<option value="000" selected="selected">-----------------------</option>
								<c:forEach items="${sem_list}" var="sem_list">
									<option value="${sem_list.getSemesterId()}${sem_list.getYear()}">
										<c:out value="${sem_list.getSemesterName()}"></c:out>/
										<c:out value="${sem_list.getYear()}"></c:out>
									</option>
								</c:forEach>
							</select>
						</div>
						<div class="btn-group col-sm-2">
							<button type="button" class="btn btn-default" onclick="ActionCoursedetail('Edit')">
								<span class="glyphicon glyphicon-pencil"></span>
							</button>
							<button type="button" class="btn btn-default" onclick="ActionCoursedetail('Delete')">
									<span class="glyphicon glyphicon-trash"></span>
							</button>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-12">ข้อมูลรายวิชา</label>
						<div class="col-sm-3"></div>
						<textarea class="form-control col-sm-6" rows="10" cols="1" id="courseview" style="width: 50%;" disabled="disabled"></textarea>
					</div>
				</form>
				<div class="btn-group">
					<button type="button" class="btn btn-default" onclick="ActionCoursedetail('AddView')">Add</button>
					<button type="button" class="btn btn-default" onclick="goto('home')">Back</button>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>