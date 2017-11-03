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
			<div class="panel-heading"><h4>Home</h4></div>
			<div class="panel-body" align="center">
				<div class="form-group">
					<label class="col-sm-2"><h3>ประเภทห้อง : </h3></label>
					<label class="col-sm-4" style="text-align: left;"><h3><c:out value="${category_name.getCatName()}"></c:out></h3></label>
					<label class="col-sm-2"><h3>สายการอนุมัติ : </h3></label>
					<div class="col-sm-2"><h3>
						<select class="form-control col-sm-2" id="approveline" onchange="ActionApproveline('Ap_change')">
							<option value="000">---------------</option>
								<c:if test="${not empty ap_list}">
									<c:forEach items="${ap_list}" var="ap_list" varStatus="ap_No">
										<option value="${ap_list.getApdId()}"><c:out value="${ap_list.getApdName()}"></c:out></option>
									</c:forEach>
								</c:if>
								<c:if test="${empty ap_list}">
									<option value="000">ไม่มี</option>
								</c:if>
						</select></h3>
					</div>
					<div class="col-sm-2">
						<h3>
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ActionApproveline('Ap_line_No_Add','${category_name.getCatId()}')">
									<span class="glyphicon glyphicon-plus-sign"></span>
								</button>
								<button type="button" class="btn btn-default" onclick="ActionApproveline('Ap_line_No_Delete','${category_name.getCatId()}')">
									<span class="glyphicon glyphicon-minus-sign"></span>
								</button>
							</div>
						</h3>
					</div>
				</div>
				&nbsp;
				<div class="row">
					<div class="form-group col-sm-5">
						<select multiple="multiple" class="form-control" id="position" style="height: 200px;">
							<c:forEach items="${position_list}" var="position_list">
								<option value="${position_list.getPid()}"><c:out value="${position_list.getPname()}"></c:out></option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group  col-sm-2">
						<div class="btn-group-vertical" role="group">
							 <button type="button" class="btn btn-default" onclick="ActionApproveline('Ap_add')">
							 	<span class="glyphicon glyphicon-plus-sign"></span>
							 </button>
							  <button type="button" class="btn btn-default" onclick="ActionApproveline('Ap_delete')">
							 	<span class="glyphicon glyphicon-minus-sign"></span>
							 </button>
							  <button type="button" class="btn btn-default" onclick="ActionApproveline('Ap_clear')">
							 	<span class="glyphicon glyphicon-remove-sign"></span>
							 </button>
						</div>
					</div>
					<div class="form-group  col-sm-5">
						<select multiple="multiple" class="form-control" id="ap_line" style="height: 200px;">
						</select>
					</div>
				</div>
				&nbsp;
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-6">
						<div class="btn-group">
							<button type="button" class="btn btn-default" onclick="ActionApproveline('Add_Ap')">OK</button>
							<button type="button" class="btn btn-default" onclick="ActionView('ApprovelineView')">Back</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>