<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="link.jsp"%>
<%@ include file="checksession.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
<div class="viewport">
	<div class="contrainermain">
	<jsp:include page="header-wrapper.jsp"></jsp:include>
	<jsp:include page="bar-wrapper.jsp"></jsp:include>
	<jsp:include page="menu-wrapper.jsp"></jsp:include>
	<div class="body-wrapper">
		<div class="panel panel-primary">
			<div class="panel-heading"><h4>Home</h4></div>
			<div class="panel-body" align="center">
				<div class="jumbotron">
					<h1>Reservation</h1>      
					<p><h3>ระบบการจองห้อง</h3></p>
				</div>
		</div>
	</div>
	
	 <form method="POST" action="UploadFile" enctype="multipart/form-data" >
        File:
        <input type="file" name="file"  id="file"> <br/>
        <input type="submit" value="Upload" name="upload" >
    </form>
    
	</div>
</div>

</body>
</html>