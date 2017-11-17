<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="link.jsp"%>
<%@ include file="checksession.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="viewport">
	<div class="contrainermain">
	<jsp:include page="header-wrapper.jsp"></jsp:include>
	<jsp:include page="bar-wrapper.jsp"></jsp:include>
	<jsp:include page="menu-wrapper.jsp"></jsp:include>
	<div class="body-wrapper">
		<div class="panel panel-primary">
			<div class="panel-heading"><h4>Room Add Data</h4></div>
			<div class="panel-body" align="center">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-4">หมายเลขห้อง</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="room_name" placeholder="หมายเลขห้อง">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">จำนวนแถว</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="line" placeholder="จำนวนแถว">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">จำนวนที่นั่งต่อแถว</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="lps" placeholder="จำนวนที่นั่งต่อแถว">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Building</label>
						<div class="col-sm-4">
							<select class="form-control" id="building">
						    	<c:forEach items="${building_list}" var="building_list">
									<option value="${building_list.getBuildId()}"><c:out value="${building_list.getBuildName()}"></c:out></option>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Category</label>
						<div class="col-sm-4">
							<select class="form-control" id="category">
						    	<c:forEach items="${category_list}" var="category_list">
									<option value="${category_list.getCatId()}"><c:out value="${category_list.getCatName()}"></c:out></option>
								</c:forEach>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">เวลาที่อนุญาติ</label>
						<div class="col-sm-4">
							<select class="form-control" id="st_time" onchange="EventTime('Hours')">
						    	<option value="" hidden>เวลาเริ่ม</option>
						    	<%
						    		int i = 0;
						    		for(i=0;i<24;i++){
						    			if(i<10){
						    				%><option value="<%="0"+i+":00"%>"><%="0"+i+":00"%></option><%
						    			}else{
						    				%><option value="<%=i+":00"%>"><%=i+":00"%></option><%
						    			}
						    		}
						    	%>
						    </select>
						    &nbsp;
						    <select class="form-control" id="ed_time">
						    	<option value="" hidden>เวลาสิ้นสุด</option>
						    </select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<div class="btn-group">
								<button type="button" class="btn btn-default" onclick="ActionRoom('RoomAdd')">Add</button>
								<button type="button" class="btn btn-default" onclick="ActionView('RoomView')">Back</button>
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