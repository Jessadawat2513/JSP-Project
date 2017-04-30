<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bar Wrapper</title>
<link type="text/css" rel="stylesheet" href="css/main.css">
</head>
<body>
<div class="bar-wrapper">
	<div class="row">
    	<div class="col-md-6"></div>
        <div class="col-md-6" align="right">
            <form class="form-inline" action="loginController" method="post">
                <input type="text" class="form-control" name="username" placeholder="Username"/>
                <input type="text" class="form-control" name="password" placeholder="Password"/>
                <input type="submit" class="btn btn-default" value="Login"/>
            </form>
        </div>
	</div>
</div>
</body>
</html>