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
			<div class="panel-heading"><h4>Course Detail Add</h4></div>
			<div class="panel-body" align="center">
				<form>
					<div class="form-group row">
						<label class="col-sm-5" style="text-align: right;"><h3>ภาคกาศึกษา : </h3></label>
						<div class="col-sm-3"><h3>
							<select class="form-control col-sm-2" id="semester" onchange="ActionCoursedetail('Changet_semester')">
								<option value="000">-----------------------</option>
								<c:forEach items="${sem_list}" var="sem_list">
									<option value="${sem_list.getSemesterId()}${sem_list.getYear()}">
										<c:out value="${sem_list.getSemesterName()}"></c:out>/
										<c:out value="${sem_list.getYear()}"></c:out>
									</option>
								</c:forEach>
							</select></h3>
						</div>
					</div>
					&nbsp;
					<div class="row">
						<div class="form-group col-sm-5">
							<select multiple="multiple" class="form-control" id="course" style="height: 200px;">
								<c:forEach items="${course_list}" var="course_list">
									<option value="${course_list.getCourseCode()}">
										<c:out value="${course_list.getCourseCode()}"></c:out>  
										<c:out value="${course_list.getCourseName()}"></c:out>
									</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group  col-sm-2">
							<div class="btn-group-vertical" role="group">
								 <button type="button" class="btn btn-default btn-lg" onclick="ActionCoursedetail('Addtolist')">
								 	<span class="glyphicon glyphicon-plus-sign"></span>
								 </button>
								  <button type="button" class="btn btn-default btn-lg" onclick="ActionCoursedetail('Deletefromlist')">
								 	<span class="glyphicon glyphicon-minus-sign"></span>
								 </button>
								  <button type="button" class="btn btn-default btn-lg" onclick="ActionCoursedetail('Clearlist')">
								 	<span class="glyphicon glyphicon-remove-sign"></span>
								 </button>
							</div>
						</div>
						<div class="form-group  col-sm-5">	
							<select multiple="multiple" class="form-control" id="coursedetail" style="height: 200px;">
							</select>
						</div>
					</div>
					&nbsp;
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-6">
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ActionCoursedetail('Add')">OK</button>
								<button type="button" class="btn btn-default" onclick="">Back</button>
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