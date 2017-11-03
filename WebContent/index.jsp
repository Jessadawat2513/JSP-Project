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
<div class="viewport">
	<div class="contrainermain">
	<jsp:include page="header-wrapper.jsp"></jsp:include>
	<div class="bar-wrapper">
		<div class="row">
	    	<div class="col-md-6"></div>
	        <div class="col-md-6" align="right">
	            <form class="form-inline" method="get">
	                <input type="text" class="form-control" name="username" id="username" placeholder="Username" value="5711850028"/>
	                <input type="password" class="form-control" name="password" id="password" placeholder="Password" value="Aa10000011"/>
	                <input type="button" class="btn btn-default" value="Login" onclick="Login('home')"/>
	            </form>
	        </div>
		</div>
	</div>
	</div>
</div>
</body>
</html>