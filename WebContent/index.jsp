<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<div class="viewport">
	<div class="contrainermain">
	<jsp:include page="header-wrapper.jsp"></jsp:include>
	<div class="bar-wrapper">
		<div class="row">
	    	<div class="col-md-6"></div>
	        <div class="col-md-6" align="right">
	            <form class="form-inline" action="loginController" method="post">
	                <input type="text" class="form-control" name="username" id="username" placeholder="Username"/>
	                <input type="text" class="form-control" name="password" id="password" placeholder="Password"/>
	                <input type="button" class="btn btn-default" value="Login" onclick="Login()"/>
	            </form>
	        </div>
		</div>
	</div>
	</div>
</div>
</body>
</html>