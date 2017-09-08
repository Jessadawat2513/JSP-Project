function Login(){
	var username = $("#username").val();
	var password = $("#password").val();
	
	if(username == '' || password == ''){
		alert("Please Enter Username and Password !!!");
		window.location.href="index.jsp";
	}else{
		$.post("loginController",{username:username ,password:password}).done(function() {
			window.location.href="home.jsp";
		});
	}
}

function Logout(){
	window.location.href="index.jsp";
}

function goto(page){
	window.location.href=page+'.jsp';
}

function gotoActive(page){
	$.ajax({
		method:"POST",
		url:page
	}).done(function(data){
		window.location.href=page+'.jsp';
	});
}

function Active(page,ids){
	var id = ids;
	if(page == 'bookingAdd'){
		var room = $("#room").val();
		var datestart = $("#date-start").val();
		var dateend = $("#date-end").val();
		var timestart = $("#time-start").val();
		var timeend = $("#time-end").val();
		
		$.ajax({
			method:"POST",
			url:page,
			data:{ID:id ,room:room ,datestart:datestart ,dateend:dateend ,timestart:timestart ,timeend:timeend}
		}).done(function() {
			window.location.href='home.jsp';
		});
	}else{
		$.ajax({
			method:"POST",
			url:page,
			data:{ID:id}
		}).done(function() {
			window.location.href=page+'.jsp';
		});
	}
}

function Back(page){
	window.location.href=page+'.jsp';
}

function menuEvent(){
	$("#option").hide();
	$("#002").click(function() {
		$("#option").toggle();
		$("#op01").click(function(){ $.post("positionView").done(function() {window.location.href="positionView.jsp"}) });
		$("#op02").click(function(){ $.post("statusView").done(function() {window.location.href="statusView.jsp"}) });
		$("#op03").click(function(){ $.post("facultyView").done(function() {window.location.href="facultyView.jsp"}) });
		$("#op04").click(function(){ $.post("branchView").done(function() {window.location.href="branchView.jsp"}) });
		$("#op05").click(function(){ $.post("governmentView").done(function() {window.location.href="governmentView.jsp"}) });
		$("#op06").click(function(){ $.post("categoryView").done(function() {window.location.href="categoryView.jsp"}) });
		$("#op07").click(function(){ $.post("buildView").done(function() {window.location.href="buildView.jsp"}) });
		$("#op08").click(function(){ $.post("termView").done(function() {window.location.href="termView.jsp"}) });
		$("#op09").click(function(){ $.post("yearView").done(function() {window.location.href="yearView.jsp"}) });
		$("#op10").click(function(){ $.post("courseView").done(function() {window.location.href="courseView.jsp"}) });
	});
	$("#001").click(function() {
		alert("Menu 001 Ready !!");
	});	
	$("#003").click(function() {
		$.ajax({
			method:"POST",
			url:"accountView"
		}).done(function() {
			window.location.href="accountView.jsp";
		});
	});	
	$("#004").click(function() {
		$.ajax({
			method:"POST",
			url:"roomView"
		}).done(function() {
			window.location.href="roomView.jsp";
		});
	});
	$("#005").click(function() {
		alert("Menu 005 Ready !!");
	});
	$("#006").click(function() {
		$.ajax({
			method:"POST",
			url:"bookingView"
		}).done(function() {
			window.location.href="bookingView.jsp";
		});
	});
	$("#007").click(function() {
		alert("Menu 007 Ready !!");
	});
	$("#008").click(function() {
		$.ajax({
			method:"POST",
			url:"approveView"
		}).done(function() {
			window.location.href="approveView.jsp";
		});
	});
}

function ActionAdd(page){
	if(page == "positionAdd"){
		var PositionName = $("#positionname").val();
		var LicenseId = [];
		var name1 = $("#st001").val();
		var name2 = $("#st002").val();
		var name3 = $("#st003").val();
		var name4 = $("#st004").val();
		var name5 = $("#st005").val();
		var name6 = $("#st006").val();
		var name7 = $("#st007").val();
		LicenseId[0] = name1;
		LicenseId[1] = name2;
		LicenseId[2] = name3;
		LicenseId[3] = name4;
		LicenseId[4] = name5;
		LicenseId[5] = name6;
		LicenseId[6] = name7;
		
		var LicenseStatus = [];
		var id1 = null;
		var id2 = null;
		var id3 = null;
		var id4 = null;
		var id5 = null;
		var id6 = null;
		var id7 = null;
		if($("#st001").is(':checked')){
			id1 = '001';
		}else{
			id1 = '002';
		}
		if($("#st002").is(':checked')){
			id2 = '001';
		}else{
			id2 = '002';
		}
		if($("#st003").is(':checked')){
			id3 = '001';
		}else{
			id3 = '002';
		}
		if($("#st004").is(':checked')){
			id4 = '001';
		}else{
			id4 = '002';
		}
		if($("#st005").is(':checked')){
			id5 = '001';
		}else{
			id5 = '002';
		}
		if($("#st006").is(':checked')){
			id6 = '001';
		}else{
			id6 = '002';
		}
		if($("#st007").is(':checked')){
			id7 = '001';
		}else{
			id7 = '002';
		}
		LicenseStatus[0] = id1;
		LicenseStatus[1] = id2;
		LicenseStatus[2] = id3;
		LicenseStatus[3] = id4;
		LicenseStatus[4] = id5;
		LicenseStatus[5] = id6;
		LicenseStatus[6] = id7;		
		
		$.ajax({
			method:"POST",
			url:page,
			data:{PositionName:PositionName ,LicenseId:LicenseId ,LicenseStatus:LicenseStatus}
		}).done(function(data) {
			$.post("positionView").done(function() {window.location.href="positionView.jsp"});
		});
	}
	if(page == "statusAdd"){
		var StatusName = $("#statusname").val();
		
		$.ajax({
			method:"POST",
			url:page,
			data:{StatusName:StatusName}
		}).done(function(data) {
			$.post("statusView").done(function() {window.location.href="statusView.jsp"});
		});
	}
	if(page == "facultyAdd"){
		var FacultyName = $("#facultyname").val();
		
		$.ajax({
			method:"POST",
			url:page,
			data:{FacultyName:FacultyName}
		}).done(function(data) {
			$.post("facultyView").done(function() {window.location.href="facultyView.jsp"});
		});
	}
	if(page == "governmentAdd"){
		var GovernmentName = $("#governmentname").val();
		
		$.ajax({
			method:"POST",
			url:page,
			data:{GovernmentName:GovernmentName}
		}).done(function(data) {
			$.post("governmentView").done(function() {window.location.href="governmentView.jsp"});
		});
	}
	if(page == "categoryAdd"){
		var CategoryName = $("#categoryname").val();
		
		$.ajax({
			method:"POST",
			url:page,
			data:{CategoryName:CategoryName}
		}).done(function(data) {
			$.post("categoryView").done(function() {window.location.href="categoryView.jsp"});
		});
	}
	if(page == "buildAdd"){
		var BuildName = $("#buildname").val();
		
		$.ajax({
			method:"POST",
			url:page,
			data:{BuildName:BuildName}
		}).done(function(data) {
			$.post("buildView").done(function() {window.location.href="buildView.jsp"});
		});
	}
	if(page == "courseAdd"){
		var CourseName = $("#coursename").val();
		var Credit = $("#credit").val();
		
		$.ajax({
			method:"POST",
			url:page,
			data:{CourseName:CourseName ,Credit:Credit}
		}).done(function(data) {
			$.post("courseView").done(function() {window.location.href="courseView.jsp"});
		});
	}
	if(page == "accountAdd"){
		var username = $("#username").val();
		var password = $("#password").val();
		var firstname = $("#firstname").val();
		var lastname = $("#lastname").val();
		var position = $("#positionView").val();
		var government = $("#governmentView").val();
		var faculty = $("#facultyView").val();
		var branch = $("#branchView").val();
		
		$.ajax({
			method:"POST",
			url:page,
			data:{
				username:username,
				password:password,
				firstname:firstname,
				lastname:lastname,
				position:position,
				government:government,
				faculty:faculty,
				branch:branch
			}
		}).done(function(data){
			$.post("accountView").done(function() {window.location.href="accountView.jsp"});
		});
	}
	if(page == "roomAdd"){
		var Roomname = $("#roomname").val();
		var Seats = $("#seats").val();
		var Category = $("#category").val();
		var Build = $("#build").val();
		var Floor = $("#floor").val();
		var Status = $("#status").val();
		
		$.ajax({
			method:"POST",
			url:page,
			data:{
				Roomname:Roomname, 
				Seats:Seats,
				Category:Category,
				Build:Build,
				Floor:Floor,
				Status:Status
			}
		}).done(function(data) {
			$.post("roomView").done(function() {window.location.href="roomView.jsp"});
		});
	}
	if(page == 'branchAdd'){
		var facultyid = $("#faculty").val();
		var branchname = $("#branchname").val();
		
		$.ajax({
			method:"POST",
			url:page,
			data:{facultyid:facultyid ,branchname:branchname}
		}).done(function(){
			$.post("branchView").done(function() {window.location.href="branchView.jsp"});
		});
	}
}

function ActionEdit(page,ids){
	var id = ids;
	if(page == "positionEdit"){
		$.ajax({
			method:"POST",
			url:page,
			data:{positionid:id}
		}).done(function(){
			window.location.href=page+'.jsp';
		});
	}
	if(page == "statusEdit"){
		$.ajax({
			method:"POST",
			url:page,
			data:{statusid:id}
		}).done(function(){
			window.location.href=page+'.jsp';
		});
	}
	if(page == "facultyEdit"){
		$.ajax({
			method:"POST",
			url:page,
			data:{facultyid:id}
		}).done(function(){
			window.location.href=page+'.jsp';
		});
	}
	if(page == "governmentEdit"){
		$.ajax({
			method:"POST",
			url:page,
			data:{governmentid:id}
		}).done(function(){
			window.location.href=page+'.jsp';
		});
	}
	if(page == "categoryEdit"){
		$.ajax({
			method:"POST",
			url:page,
			data:{categoryid:id}
		}).done(function(){
			window.location.href=page+'.jsp';
		});
	}
	if(page == "buildEdit"){
		$.ajax({
			method:"POST",
			url:page,
			data:{buildid:id}
		}).done(function(){
			window.location.href=page+'.jsp';
		});
	}
	if(page == "courseEdit"){
		$.ajax({
			method:"POST",
			url:page,
			data:{courseid:id}
		}).done(function(){
			window.location.href=page+'.jsp';
		});
	}
	if(page == "accountEdit"){
		$.ajax({
			method:"POST",
			url:page,
			data:{ID:id}
		}).done(function(){
			window.location.href=page+'.jsp';
		});
	}
	if(page == "roomEdit"){
		$.ajax({
			method:"POST",
			url:page,
			data:{ID:id}
		}).done(function(){
			window.location.href=page+'.jsp';
		});
	}
	if(page == "approveDetail"){
		$.ajax({
			method:"POST",
			url:page,
			data:{ID:id}
		}).done(function() {
			window.location.href=page+'.jsp';
		});
	}
	if(page == "approveDetailEdit"){
		$.ajax({
			method:"POST",
			url:page,
			data:{ID:id}
		}).done(function() {
			window.location.href=page+'.jsp';
		});
	}
}

function ActionUpdate(page,ids){
	var id = ids;
	if(page == "positionUpdate"){
		var PositionName = $("#positionname").val();
		var LicenseId = [];
		var name1 = $("#st001").val();
		var name2 = $("#st002").val();
		var name3 = $("#st003").val();
		var name4 = $("#st004").val();
		var name5 = $("#st005").val();
		var name6 = $("#st006").val();
		var name7 = $("#st007").val();
		LicenseId[0] = name1;
		LicenseId[1] = name2;
		LicenseId[2] = name3;
		LicenseId[3] = name4;
		LicenseId[4] = name5;
		LicenseId[5] = name6;
		LicenseId[6] = name7;
		
		var LicenseStatus = [];
		var id1 = null;
		var id2 = null;
		var id3 = null;
		var id4 = null;
		var id5 = null;
		var id6 = null;
		var id7 = null;
		if($("#st001").is(':checked')){
			id1 = '001';
		}else{
			id1 = '002';
		}
		if($("#st002").is(':checked')){
			id2 = '001';
		}else{
			id2 = '002';
		}
		if($("#st003").is(':checked')){
			id3 = '001';
		}else{
			id3 = '002';
		}
		if($("#st004").is(':checked')){
			id4 = '001';
		}else{
			id4 = '002';
		}
		if($("#st005").is(':checked')){
			id5 = '001';
		}else{
			id5 = '002';
		}
		if($("#st006").is(':checked')){
			id6 = '001';
		}else{
			id6 = '002';
		}
		if($("#st007").is(':checked')){
			id7 = '001';
		}else{
			id7 = '002';
		}
		LicenseStatus[0] = id1;
		LicenseStatus[1] = id2;
		LicenseStatus[2] = id3;
		LicenseStatus[3] = id4;
		LicenseStatus[4] = id5;
		LicenseStatus[5] = id6;
		LicenseStatus[6] = id7;		
		
		$.ajax({
			method:"POST",
			url:page,
			data:{ID:id ,PositionName:PositionName ,LicenseId:LicenseId ,LicenseStatus:LicenseStatus}
		}).done(function(data) {
			$.post("positionView").done(function() {window.location.href="positionView.jsp"});
		});
	}

	if(page == "statusUpdate"){
		var StatusName = $("#statusname").val();
		$.ajax({
			method:"POST",
			url:page,
			data:{ID:id ,Statusname:StatusName}
		}).done(function(data) {
			$.post("statusView").done(function() {window.location.href="statusView.jsp"});
		});
	}
	if(page == "facultyUpdate"){
		var FacultyName = $("#facultyname").val();
		$.ajax({
			method:"POST",
			url:page,
			data:{ID:id ,Facultyname:FacultyName}
		}).done(function(data) {
			$.post("facultyView").done(function() {window.location.href="facultyView.jsp"});
		});
	}
	if(page == "governmentUpdate"){
		var GovernmentName = $("#governmentname").val();
		$.ajax({
			method:"POST",
			url:page,
			data:{ID:id ,Governmentname:GovernmentName}
		}).done(function(data) {
			$.post("governmentView").done(function() {window.location.href="governmentView.jsp"});
		});
	}
	if(page == "categoryUpdate"){
		var CategoryName = $("#categoryname").val();
		$.ajax({
			method:"POST",
			url:page,
			data:{ID:id ,Categoryname:CategoryName}
		}).done(function(data) {
			$.post("categoryView").done(function() {window.location.href="categoryView.jsp"});
		});
	}
	if(page == "buildUpdate"){
		var BuildName = $("#buildname").val();
		var floor = $("#floor").val();
		$.ajax({
			method:"POST",
			url:page,
			data:{ID:id ,Buildname:BuildName ,Floor:floor}
		}).done(function(data) {
			$.post("buildView").done(function() {window.location.href="buildView.jsp"});
		});
	}
	if(page == "courseUpdate"){
		var CourseName = $("#coursename").val();
		var Credit = $("#credit").val();
		$.ajax({
			method:"POST",
			url:page,
			data:{ID:id ,Coursename:CourseName ,Credit:Credit}
		}).done(function(data) {
			$.post("courseView").done(function() {window.location.href="courseView.jsp"});
		});
	}
	if(page == "accountUpdate"){
		var username = $("#username").val();
		var password = $("#password").val();
		var firstname = $("#firstname").val();
		var lastname = $("#lastname").val();
		var position = $("#positionEdit").val();
		var government = $("#governmentEdit").val();
		var faculty = $("#facultyEdit").val();
		var branch = $("#branchEdit").val();
		var status = $("#statusEdit").val();
		
		$.ajax({
			method:"POST",
			url:page,
			data:{
				ID:id,
				username:username,
				password:password,
				firstname:firstname,
				lastname:lastname,
				position:position,
				government:government,
				faculty:faculty,
				branch:branch,
				status:status
			}
		}).done(function(data){
			$.post("accountView").done(function() {window.location.href="accountView.jsp"});

		});
	}
	if(page == "roomUpdate"){
		var Roomname = $("#roomname").val();
		var Seats = $("#seats").val();
		var Category = $("#category").val();
		var Build = $("#build").val();
		var Floor = $("#floor").val();
		var Status = $("#status").val();
		
		$.ajax({
			method:"POST",
			url:page,
			data:{
				ID:id,
				Roomname:Roomname, 
				Seats:Seats,
				Category:Category,
				Build:Build,
				Floor:Floor,
				Status:Status
			}
		}).done(function(data) {
			$.post("roomView").done(function() {window.location.href="roomView.jsp"});
		});
	}
}

function ActionDelete(page,ids){
	var id = ids;
	if(page == "positionDelete"){
		$("#myModalSm").modal();
		//$("#headermodel").html('Confirm Message !!!');
		$("#smbodymodel").html('<span class="alert alert-warning" role="alert"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Do you want to delete ? </span>');
		var btnsave = '<button type="button" class="btn btn-default" id="Save">Save</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
		$("#smfootermodel").html(btnsave+' '+btnclose);
		$("#Save").click(function() {
			$.ajax({
				method:"POST",
				url:page,
				data:{ID:id}
			}).done(function(data) {
				$.post("positionView").done(function() {window.location.href="positionView.jsp"});
			});
		});
	}
	if(page == "statusDelete"){
		$("#myModal").modal();
		$("#headermodel").html('<h4>Confirm Message !!!</h4>');
		$("#bodymodel").html('Do you want delete ?');
		var btnsave = '<button type="button" class="btn btn-default" id="Save">Save</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
		$("#footermodel").html(btnsave+' '+btnclose);
		$("#Save").click(function() {
			$.ajax({
				method:"POST",
				url:page,
				data:{ID:id}
			}).done(function(data) {
				$.post("statusView").done(function() {window.location.href="statusView.jsp"});
			});
		});
	}
	if(page == "facultyDelete"){
		$("#myModal").modal();
		$("#headermodel").html('<h4>Confirm Message !!!</h4>');
		$("#bodymodel").html('Do you want delete ?');
		var btnsave = '<button type="button" class="btn btn-default" id="Save">Save</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
		$("#footermodel").html(btnsave+' '+btnclose);
		$("#Save").click(function() {
			$.ajax({
				method:"POST",
				url:page,
				data:{ID:id}
			}).done(function(data) {
				$.post("facultyView").done(function() {window.location.href="facultyView.jsp"});
			});
		});
	}
	if(page == "governmentDelete"){
		$("#myModal").modal();
		$("#headermodel").html('<h4>Confirm Message !!!</h4>');
		$("#bodymodel").html('Do you want delete ?');
		var btnsave = '<button type="button" class="btn btn-default" id="Save">Save</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
		$("#footermodel").html(btnsave+' '+btnclose);
		$("#Save").click(function() {
			$.ajax({
				method:"POST",
				url:page,
				data:{ID:id}
			}).done(function(data) {
				$.post("governmentView").done(function() {window.location.href="governmentView.jsp"});
			});
		});
	}
	if(page == "categoryDelete"){
		$("#myModal").modal();
		$("#headermodel").html('<h4>Confirm Message !!!</h4>');
		$("#bodymodel").html('Do you want delete ?');
		var btnsave = '<button type="button" class="btn btn-default" id="Save">Save</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
		$("#footermodel").html(btnsave+' '+btnclose);
		$("#Save").click(function() {
			$.ajax({
				method:"POST",
				url:page,
				data:{ID:id}
			}).done(function(data) {
				$.post("categoryView").done(function() {window.location.href="categoryView.jsp"});
			});
		});
	}
	if(page == "buildDelete"){
		$("#myModal").modal();
		$("#headermodel").html('<h4>Confirm Message !!!</h4>');
		$("#bodymodel").html('Do you want delete ?');
		var btnsave = '<button type="button" class="btn btn-default" id="Save">Save</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
		$("#footermodel").html(btnsave+' '+btnclose);
		$("#Save").click(function() {
			$.ajax({
				method:"POST",
				url:page,
				data:{ID:id}
			}).done(function(data) {
				$.post("buildView").done(function() {window.location.href="buildView.jsp"});
			});
		});
	}
	if(page == "courseDelete"){
		$("#myModal").modal();
		$("#headermodel").html('<h4>Confirm Message !!!</h4>');
		$("#bodymodel").html('Do you want delete ?');
		var btnsave = '<button type="button" class="btn btn-default" id="Save">Save</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
		$("#footermodel").html(btnsave+' '+btnclose);
		$("#Save").click(function() {
			$.ajax({
				method:"POST",
				url:page,
				data:{ID:id}
			}).done(function(data) {
				$.post("courseView").done(function() {window.location.href="courseView.jsp"});
			});
		});
	}
	if(page == "accountDelete"){
		$("#myModalSm").modal();
		//$("#headermodel").html('Confirm Message !!!');
		$("#smbodymodel").html('<span class="alert alert-warning" role="alert"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Do you want to delete ? </span>');
		var btnsave = '<button type="button" class="btn btn-default" id="Save">Save</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
		$("#smfootermodel").html(btnsave+' '+btnclose);
		$("#Save").click(function() {
			$.ajax({
				method:"POST",
				url:page,
				data:{ID:id}
			}).done(function(data) {
				$.post("accountView").done(function() {window.location.href="accountView.jsp"});
			});
		});
	}
	if(page == "roomDelete"){
		$("#myModal").modal();
		$("#headermodel").html('<h4>Confirm Message !!!</h4>');
		$("#bodymodel").html('Do you want delete ?');
		var btnsave = '<button type="button" class="btn btn-default" id="Save">Save</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
		$("#footermodel").html(btnsave+' '+btnclose);
		$("#Save").click(function() {
			$.ajax({
				method:"POST",
				url:page,
				data:{ID:id}
			}).done(function(data) {
				$.post("roomView").done(function() {window.location.href="roomView.jsp"});
			});
		});
	}
}
var dataid = [];
var index = 1;
var rownum = 0;
function ApproveData(action,ids,name){
	var id = ids;
	var categoryname = name;
	if(action == 'ADD'){
		var positionid = $("select#positionlist option:selected").val();
		var positionname = $("#positionlist option:selected").text();
		$("select#positionlist").find("option:selected").attr('disabled', true);
		dataid[rownum] = positionid;
		$("#tdetail").append(
				'<tr>'+
					'<th>'+categoryname+'</th>'+
					'<th>'+positionname+'</th>'+
					'<th>'+index+'</th>'+
				'</tr>'
		);
		index++;
		rownum++;
	}
	if(action == 'SAVE'){
		$.ajax({
			method:"POST",
			url:"approveAdd",
			data:{ID:id ,positionid:dataid}
		}).done(function() {
			window.location.href="approveView.jsp";
		});
	}
}

function onChangeData(){
	var roomname = $("#roomname").text();
	var seats = $("#seats").text();
	var buildid = $("select#build option:selected").val();
	$.ajax({
		method:"POST",
		url:"roomAddView",
		data:{RoomName:roomname ,Seats:seats ,ID:buildid}
	}).done(function() {
		window.location.reload();
	});
}

function bookingAddData(){
	
}