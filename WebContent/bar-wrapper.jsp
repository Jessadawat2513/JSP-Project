<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="link.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bar Wrapper</title>
</head>
<body>
<div class="bar-wrapper">
	<div class="row">
    	<div class="col-md-8"></div>
        <div class="col-md-4" align="right">
        	<c:out value="${login.getFirstname()}"></c:out>
        	<c:out value="${login.getLastname()}"></c:out>
        	<c:out value="${login.getPname()}"></c:out>
        	<input type="button" class="btn btn-default" value="Log out" onclick="Logout('LogoutController')">
        </div>
	</div>
</div>
</body>
</html>