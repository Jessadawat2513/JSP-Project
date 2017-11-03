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
			<div class="panel-heading"><h4>Approve</h4></div>
			<div class="panel-body" align="center">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ประเภทห้อง</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${category_list}" var="category_list">
							<tr>
								<th><c:out value="${category_list.getCatName()}"></c:out></th>
								<th width="150">
									<button type="button" class="btn btn-default" onclick="ActionApproveline('Ap_detail','${category_list.getCatId()}')">
										<span class="glyphicon glyphicon glyphicon-list-alt"></span>
									</button>
								</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>