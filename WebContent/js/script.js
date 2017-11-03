function Login(page){
	var username = $("#username").val();
	var password = $("#password").val();
	var filterpassword = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?!.*?[#?!@$%^&*-]).{10,}$/g;
	if($.trim(username).length == 0 || $.trim(password).length == 0){
		alert("Please Enter Username or Password !!!");
	}else{
		if(filterpassword.test(password)){
			$.ajax({
				method : "GET",
				url : "LoginController",
				data : {username:username ,password:password}
			}).done(function(data){
				if(data=="true"){
					window.location.href=page+".jsp";
				}else{
					alert("Username And Password Invalid !!!");
					$("#username").val("");
					$("#password").val("");
				}
			});
		}else{
			alert("Username And Password Invalid !!!");
			$("#username").val("");
			$("#password").val("");
		}
	}
}

function Logout(page){
	$.post(page).done(function(page){
		window.location.href=page;
	});
}

function menuEvent(){
	$("#event").hide();
	$("#002").click(function() {
		$("#event").toggle();
	});
}

function goto(page){
	window.location.href=page+".jsp";
}

function ActionView(page){
	$.post(page).done(function(page){
		window.location.href=page;
	});
}

function ActionAdd(page){
	if(page == "PositionAdd"){
		var posname = $("#pos_name").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "PositionAdd",
				data : {posname:posname}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "PositionView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "PositionView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(page == "FacultyAdd"){
		var facname = $("#fac_name").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "FacultyAdd",
				data : {facname:facname}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "FacultyView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "FacultyView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(page == "DepartmentAdd"){
		var depname = $("#dep_name").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "DepartmentAdd",
				data : {depname:depname}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "DepartmentView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "DepartmentView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(page == "CategoryAdd"){
		var catname = $("#cat_name").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "CategoryAdd",
				data : {catname:catname}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "CategoryView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "CategoryView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(page == "BuildingAdd"){
		var bname = $("#b_name").val();
		var position = $("#position").val();
		var note = $("#note").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "BuildingAdd",
				data : {bname:bname,position:position,note:note}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "BuildingView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "BuildingView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(page == "CourseAdd"){
		var code = $("#code").val();
		var cname = $("#c_name").val();
		var credit = $("#credit").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "CourseAdd",
				data : {code:code,cname:cname,credit:credit}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "CourseView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "CourseView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(page == "ClassesAdd"){
		var classname = $("#class_name").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "ClassesAdd",
				data : {classname:classname}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "ClassesView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "ClassesView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
}

function ActionEdit(page,ids){
	$.post(page,{ids:ids}).done(function(page){
		window.location.href=page;
	});
}

function ActionUpdate(page,ids){
	var status = $("input:radio:checked").val();
	if(page == "PositionUpdate"){
		var posname = $("#pos_name").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "PositionUpdate",
				data : {ids:ids,posname:posname,status:status}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave+' '+btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "PositionView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "PositionView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(page == "FacultyUpdate"){
		var facname = $("#fac_name").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "FacultyUpdate",
				data : {ids:ids,facname:facname,status:status}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave+' '+btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "FacultyView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "FacultyView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(page == "DepartmentUpdate"){
		var depname = $("#dep_name").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "DepartmentUpdate",
				data : {ids:ids,depname:depname,status:status}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave+' '+btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "DepartmentView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "DepartmentView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(page == "CategoryUpdate"){
		var catname = $("#cat_name").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "CategoryUpdate",
				data : {ids:ids,catname:catname,status:status}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave+' '+btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "CategoryView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "CategoryView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(page == "BuildingUpdate"){
		var bname = $("#b_name").val();
		var position = $("#position").val();
		var note = $("#note").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "BuildingUpdate",
				data : {ids:ids,bname:bname,position:position,note:note,status:status}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave+' '+btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "BuildingView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "BuildingView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(page == "CourseUpdate"){
		var code = $("#code").val();
		var cname = $("#c_name").val();
		var credit = $("#credit").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "CourseUpdate",
				data : {ids:ids,code:code,cname:cname,credit:credit,status:status}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave+' '+btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "CourseView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "CourseView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(page == "ClassesUpdate"){
		var classname = $("#class_name").val();
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "ClassesUpdate",
				data : {ids:ids,classname:classname,status:status}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave+' '+btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "ClassesView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "ClassesView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
}

function ActionDelete(page,ids,status){
	if(status == 002){
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Do you want to delete ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="Save">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#Save").click(function() {
			$.ajax({
				method : "POST",
				url : page,
				data : {ids:ids}
			}).done(function(page){
				$.post(page).done(function(page){
					window.location.href=page;
				});
			});
		});
	}else{
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>ไม่สามารถลบข้อมูลได้</h4>');
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
		$("#lgfootermodel").html(btnclose);
	}
}

function BranchAction(page,ids,name,statuss){
	var braname = $("#bra_name").val();
	var status = $("input:radio:checked").val();
	if(page == "BranchView"){
		$.post(page,{ids:ids}).done(function(page){
			window.location.href=page;
		});
	}
	if(page == "BranchAdd"){
		$.ajax({
			method : "POST",
			url : page,
			data : {ids:ids,braname:braname}
		}).done(function(page){
			$.post(page,{ids:ids}).done(function(page){
				window.location.href=page;
			});
		});
	}
	if(page == "BranchUpdate"){
		$.ajax({
			method : "POST",
			url : page,
			data : {ids:ids,braname:braname,name:name,status:status}
		}).done(function(page){
			$.post(page,{ids:ids}).done(function(page){
				window.location.href=page;
			});
		});
	}
	if(page == "BranchDelete"){
		if(statuss == 002){
			$("#myModalLg").modal();
			$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
			$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Do you want to delete ?</h4>');
			var btnsave = '<button type="button" class="btn btn-default" id="Save">Yes</button>';
			var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
			$("#lgfootermodel").html(btnsave+' '+btnclose);
			$("#Save").click(function() {
				$.ajax({
					method : "POST",
					url : page,
					data : {name:name}
				}).done(function(page){
					$.post(page,{ids:ids}).done(function(page){
							window.location.href=page;
					});
				});
			});
		}else{
			$("#myModalLg").modal();
			$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
			$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>ไม่สามารถลบข้อมูลได้</h4>');
			var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
			$("#lgfootermodel").html(btnclose);
		}
	}
}

function ActionSemester(page,semesters,years,statuss){
	var semester = $("#semester").val();
	var year = $("#year").val();
	var stdate = $("#stdate").val();
	var eddate = $("#eddate").val();
	var status = $("input:radio:checked").val();
	var filter_year = /^[0-9]{4}$/gm;
	if(page == "SemesterAddView"){
		$.ajax({
			method : "POST",
			url : page
		}).done(function(){
			window.location.href="semesteradd.jsp";
		});
	}
	if(page == "SemesterAdd"){
		if(filter_year.test(year)){
			if($.trim(stdate).length == 0 || $.trim(eddate).length == 0){
				$("#myModalLg").modal();
				$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
				$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>กรุณาใส่วันที่ให้ครบถ้วน</h4>');
				var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
				$("#lgfootermodel").html(btnclose);
			}else{
				$.ajax({
					method : "POST",
					url : page,
					data : {semester:semester,year:year,stdate:stdate,eddate:eddate}
				}).done(function(status){
					if(status == "success"){
						$("#myModalLg").modal();
						$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
						$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลสำเร็จ</h4>');
						var btnclose = '<button type="button" class="btn btn-default" id="OK">OK</button>';
						$("#lgfootermodel").html(btnclose);
						$("#OK").click(function(){
							$.ajax({
								method : "POST",
								url : "SemesterView",
							}).done(function(page){
								window.location.href="semesterview.jsp";
							});
						});
					}else{
						$("#myModalLg").modal();
						$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
						$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลไม่สำเร็จ</h4>');
						var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
						$("#lgfootermodel").html(btnclose);
					}
				});
			}
		}else{
			$("#myModalLg").modal();
			$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
			$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>กรุณาปีให้ถูกต้อง</h4>');
			var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
			$("#lgfootermodel").html(btnclose);
		}
	}
	if(page == "SemesterEdit"){
		$.post(page,{semesters:semesters,years:years}).done(function(page){
			window.location.href=page;
		});
	}
	if(page == "SemesterUpdate"){
		$.ajax({
			method : "POST",
			url : page,
			data : {semesters:semesters,years:years,semester:semester,year:year,stdate:stdate,eddate:eddate,status:status}
		}).done(function(page){
			$.post(page).done(function(page){
				window.location.href=page;
			});
		});
	}
	if(page == "SemesterDelete"){
		if(statuss == 002){
			$("#myModalLg").modal();
			$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
			$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Do you want to delete ?</h4>');
			var btnsave = '<button type="button" class="btn btn-default" id="Save">Yes</button>';
			var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
			$("#lgfootermodel").html(btnsave+' '+btnclose);
			$("#Save").click(function() {
				$.ajax({
					method : "POST",
					url : page,
					data : {semesters:semesters,years:years}
				}).done(function(page){
					$.post(page).done(function(page){
						window.location.href=page;
					});
				});
			});
		}else{
			$("#myModalLg").modal();
			$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
			$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>ไม่สามารถลบข้อมูลได้</h4>');
			var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
			$("#lgfootermodel").html(btnclose);
		}
	}
}

function ActionUsers(page,user_id,user_status){
	var username = $("#username").val();
	var password = $("#password").val();
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var pos_id = $("#position").val();
	var fac_id = $("#faculty").val();
	var bra_name = $("#branch").val();
	var dep_id = $("#department").val();
	var status = $("input:radio:checked").val();
	var filterpassword = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?!.*?[#?!@$%^&*-]).{10,}$/g;
	if(page == "UsersAddView"){
		$.post(page).done(function(page){
			window.location.href=page;
		});
	}
	if(page == "UsersAddUpdate"){
		var fac_id = $("#faculty").val();
		$.post(page,{fac_id:fac_id}).done(function(data){
			var $select = $("#branch");
			$select.find("option").remove();
			$.each(data,function(key, value){
				$("<option>").val(key).text(value).appendTo($select);
			});
		});
	}
	if(page == "UsersAdd"){
		if($.trim(username).length == 0 || $.trim(password).length == 0 || $.trim(firstname).length == 0 || $.trim(lastname).length == 0){
			$("#myModalLg").modal();
			$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
			$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>กรุณากรอกข้อมูลให้ครบถ้วน</h4>');
			var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
			$("#lgfootermodel").html(btnclose);
		}else{
			if(filterpassword.test(password)){
				$.ajax({
					method : "POST",
					url : page,
					data : {
						username : username,
						password : password,
						firstname : firstname,
						lastname : lastname,
						pos_id : pos_id,
						fac_id : fac_id,
						bra_name : bra_name,
						dep_id : dep_id
					}
				}).done(function(status){
					if(status == "success"){
						$("#myModalLg").modal();
						$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
						$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลสำเร็จ</h4>');
						var btnclose = '<button type="button" class="btn btn-default" id="OK">OK</button>';
						$("#lgfootermodel").html(btnclose);
						$("#OK").click(function(){
							$.ajax({
								method : "POST",
								url : "UsersView",
							}).done(function(page){
								window.location.href=page;
							});
						});
					}else{
						$("#myModalLg").modal();
						$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
						$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>การลบข้อมูลผิดพลาด</h4>');
						var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
						$("#lgfootermodel").html(btnclose);
					}
				});
			}else{
				$("#myModalLg").modal();
				$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
				$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>รหัสผ่านไม่ถูกต้อง รหัสต้องมี 10 หลัก ประกอบด้วย ตัวพิมพ์เล็ก ตัวพิมพ์ใหญ่ และ ตัวเลข</h4>');
				var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
				$("#lgfootermodel").html(btnclose);
			}
		}
	}
	if(page == "UsersEdit"){
		$.ajax({
			method : "POST",
			url : page,
			data : {user_id:user_id}
		}).done(function(page){
			window.location.href=page;
		});
	}
	if(page == "UsersUpdate"){
		$.ajax({
			method : "POST",
			url : page,
			data : {
				user_id : user_id,
				username : username,
				password : password,
				firstname : firstname,
				lastname : lastname,
				pos_id : pos_id,
				fac_id : fac_id,
				bra_name : bra_name,
				dep_id : dep_id,
				status : status
			}
		}).done(function(status){
			if(status == 'success'){
				$("#myModalLg").modal();
				$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
				$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลสำเร็จ</h4>');
				var btnclose = '<button type="button" class="btn btn-default" id="OK">OK</button>';
				$("#lgfootermodel").html(btnclose);
				$("#OK").click(function(){
					$.ajax({
						method : "POST",
						url : "UsersView",
					}).done(function(page){
						window.location.href=page;
					});
				});
			}else{
				$("#myModalLg").modal();
				$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
				$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลผิดพลาด</h4>');
				var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
				$("#lgfootermodel").html(btnclose);
			}
		});
	}
	if(page == "UsersDelete"){
		if(user_status == 002){
			$.ajax({
				method : "POST",
				url : page,
				data : {user_id:user_id}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลสำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="OK">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "UsersView",
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>การลบข้อมูลผิดพลาด</h4>');
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
				}
			});
		}else{
			$("#myModalLg").modal();
			$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
			$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>ไม่สามารถลบข้อมูลได้</h4>');
			var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
			$("#lgfootermodel").html(btnclose);
		}
	}
}

function ActionPrivilege(action,page,pri_id){
	var Privilege = [];
	var Status = [];
	var pos_select = $("#position").val();
	var lenghts = $('input:checkbox').length;
	if(action == "PositionChange"){
		if(pos_select == '000'){
			$( "input[type='checkbox']" ).prop({ checked: false});
		}else{
			$.ajax({
				method : "POST",
				url : page,
				data : {pos_select:pos_select}
			}).done(function(data){
				$.each(data,function(key, value){
					for(var i = 1; i <= lenghts; i++){
						var values = $("#"+(i)).val();
						if(key == values){
							if(value == "001"){
								$("#"+i).prop({checked:true});
							}else{
								$("#"+i).prop({checked:false});
							}
						}
					}
				})
			});
		}
	}
	if(action == "PrivilegeChange"){
		for(var i = 0; i < lenghts; i++){
			var num = i+1;
			var value = $("#"+(i+1)).val();
			var status = $("#"+(i+1)).is(':checked');
			Privilege[i] = value;
			Status[i] = status;
			if(status==true){
				Status[i] = '001';
			}else{
				Status[i] = '002';
			}
		}
		$.ajax({
			method : "POST",
			url : page,
			data : {pos_select:pos_select,Privilege:Privilege,Status:Status}
		}).done(function(status){
			if(status == 'success'){
				$("#myModalLg").modal();
				$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
				$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลสิทธิ์สำเร็จ</h4>');
				var btnclose = '<button type="button" class="btn btn-default" id="OK">OK</button>';
				$("#lgfootermodel").html(btnclose);
				$("#OK").click(function(){
					$.ajax({
						method : "POST",
						url : "PrivilegeView",
					}).done(function(page){
						window.location.href=page;
					});
				});
			}else{
				$("#myModalLg").modal();
				$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
				$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลสิทธิ์ไม่สำเร็จ</h4>');
				var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
				$("#lgfootermodel").html(btnclose);
			}
		});
	}
}

function ActionRoom(page,room_num,status){
	var roomnum = $("#room_name").val();
	var line = $("#line").val();
	var lps = $("#lps").val();
	var building = $("#building").val();
	var category = $("#category").val();
	var seat = line*lps;
	var room_st = $("input:radio:checked").val();
	if(page == 'RoomAddView'){
		$.post(page).done(function(page){
			window.location.href=page;
		});
	}
	if(page == 'RoomAdd'){
		$.ajax({
			method : "POST",
			url : page,
			data : {roomnum:roomnum,line:line,lps:lps,seat:seat,building:building,category:category}
		}).done(function(status){
			if(status == 'success'){
				$("#myModalLg").modal();
				$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
				$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลสำเร็จ</h4>');
				var btnclose = '<button type="button" class="btn btn-default" id="OK">OK</button>';
				$("#lgfootermodel").html(btnclose);
				$("#OK").click(function(){
					$.ajax({
						method : "POST",
						url : "RoomView",
					}).done(function(page){
						window.location.href=page;
					});
				});
			}else{
				$("#myModalLg").modal();
				$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
				$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>ชื่อห้องซ้ำ</h4>');
				var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
				$("#lgfootermodel").html(btnclose);
			}
		});
	}
	if(page == "RoomEdit"){
		$.ajax({
			method : "POST",
			url : page,
			data : {room_num:room_num}
		}).done(function(){
			window.location.href="roomedit.jsp";
		});
	}
	if(page == "RoomUpdate"){
		$.ajax({
			method : "POST",
			url : page,
			data : {room_num:room_num,roomnum:roomnum,line:line,lps:lps,seat:seat,building:building,category:category,room_st:room_st}
		}).done(function(status){
			if(status == 'success'){
				$("#myModalLg").modal();
				$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
				$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลสำเร็จ</h4>');
				var btnclose = '<button type="button" class="btn btn-default" id="OK">OK</button>';
				$("#lgfootermodel").html(btnclose);
				$("#OK").click(function(){
					$.ajax({
						method : "POST",
						url : "RoomView",
					}).done(function(page){
						window.location.href=page;
					});
				});
			}else{
				$("#myModalLg").modal();
				$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
				$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลผิดพลาด</h4>');
				var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
				$("#lgfootermodel").html(btnclose);
			}
		})
	}
	if(page == "RoomDelete"){
		if(status == '005'){
			$("#myModalLg").modal();
			$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
			$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Do you want to delete ?</h4>');
			var btnsave = '<button type="button" class="btn btn-default" id="Save">Yes</button>';
			var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
			$("#lgfootermodel").html(btnsave+' '+btnclose);
			$("#Save").click(function() {
				$.ajax({
					method : "POST",
					url : page,
					data : {room_num:room_num}
				}).done(function(status){
					if(status == "success"){
						$.post("RoomView").done(function(page){
							window.location.href=page;
						});
					}else{
						$("#myModalLg").modal();
						$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
						$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>การลบข้อมูลผิดพลาด</h4>');
						var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
						$("#lgfootermodel").html(btnclose);
					}
				});
			});
		}else{
			$("#myModalLg").modal();
			$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
			$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>ไม่สามารถลบข้อมูลได้</h4>');
			var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
			$("#lgfootermodel").html(btnclose);
		}
	}
}

function ActionBooking(action,user_id,room_id,booking_id,g_booking_no){
	var category = $("#category").val();
	var building = $("#building").val();
	var roomid = $("#room").val();
	var st_date = $("#st_date").val();
	var ed_date = $("#ed_date").val();
	var st_time = $("#st_time").val();
	var ed_time = $("#ed_time").val();
	if(action == "ShowDetail"){
		$.ajax({
			method : "POST",
			url : "BookingDetail",
			data : {user_id:user_id,room_id:room_id}
		}).done(function(page){
			window.location.href="bookingdetail.jsp";
		});
	}
	if(action == "Search"){
		$.ajax({
			method : "POST",
			url : "BookingSearch",
			data : {category:category,building:building}
		}).done(function(data){
			var i = 1;
			var $table = $('table tbody');
			$('#category option[value="000"]').prop('selected','selected');
			$('#building option[value="000"]').prop('selected','selected');
			$table.empty();
			$.each(data,function(index,room){
				$('<tr>').appendTo($table)
				.append($("<th>").text(i))
                .append($("<th>").text(room.rm_num))
                .append($("<th>").text(room.seat))
                .append($("<th>").text(room.cat_name))
                .append($("<th>").text(room.s_rm_name));
				i++;
			});
		});
	}
	if(action == "AddView"){
		$.ajax({
			method : "POST",
			url : "BookingAddView"
		}).done(function(){
			window.location.href="bookingadd.jsp";
		});
	}
	if(action == "AddBooking"){
		$.ajax({
			method : "POST",
			url : "BookingAdd",
			data : {
				user_id:user_id,
				roomid:roomid,
				st_date:st_date,
				ed_date:ed_date,
				st_time:st_time,
				ed_time:ed_time
				}
		}).done(function(status){
			if(status == "success"){
				$.ajax({
					method : "POST",
					url : "BookingView",
					data : {user_id:user_id,room_id:room_id}
				}).done(function(){
					window.location.href="bookingview.jsp";
				});
			}else{
				$("#myModalLg").modal();
				$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
				$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> จองห้องไม่สำเร็จ !!! </h4>');
				var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
				$("#lgfootermodel").html(btnclose);
			}
		});
	}
	if(action == "EditBooking"){
		$.ajax({
			method : "POST",
			url : "BookingEdit",
			data : {user_id:user_id,room_id:room_id,booking_id:booking_id,g_booking_no:g_booking_no}
		}).done(function(){
			window.location.href="bookingedit.jsp";
		});
	}
	if(action == "UpdateBooking"){
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "BookingUpdate",
				data : {booking_id:booking_id,g_booking_no:g_booking_no,roomid:roomid,st_date:st_date,ed_date:ed_date,st_time:st_time,ed_time:ed_time}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave+' '+btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "BookingHistory",
							data : {user_id:user_id}
						}).done(function(page){
							window.location.href="bookinghistory.jsp";
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "BookingHistory",
							data : {user_id:user_id}
						}).done(function(page){
							window.location.href="bookinghistory.jsp";
						});
					});
				}
			});
		});
	}
}

function ActionApproveline(action,ids){
	var Select = [];
	var $select = $("#approveline");
	var ap_value = $("#approveline").val();
	var $ap_line = $("#ap_line");
	var $position = $("#position");
	var position = $("#position option:selected").val();
	var pos_name = $("#position option:selected").text();
	var ap_line = $("#ap_line option:selected").val();
	var ap_line_text = $("#ap_line option:selected").text();
	if(action == "Ap_detail"){
		$.ajax({
			method : "POST",
			url : "ApprovelineDetail",
			data : {action:action,ids:ids}
		}).done(function(data){
			window.location.href="approvelinedetail.jsp";
		});
	}
	if(action == "Ap_change"){
		if(ap_value == "000"){
			$("#ap_line option").each(function(){
				$("<option>").val($(this).val()).text($(this).text()).appendTo($position);
			});
			$ap_line.find("option").remove();
		}else{
			$.ajax({
				method : "POST",
				url : "ApprovelineChange",
				data : {action:action,ap_value:ap_value,position:position}
			}).done(function(data){
				$("#ap_line option").each(function(){
					$("<option>").val($(this).val()).text($(this).text()).appendTo($position);
				});
				$ap_line.find("option").remove();
				$.each(data,function(key,value){
					$("#position option").each(function(){
						if($(this).val() == key){
							$position.find("option[value='"+key+"']").remove();
						}
					});
					$("<option>").val(key).text(value).appendTo($ap_line);
				});
			});
		}
	}
	if(action == "Ap_add"){
		if(position != null){
			$position.find("option:selected").remove();
			$("<option>").val(position).text(pos_name).appendTo($ap_line);
		}
	}
	if(action == "Ap_delete"){
		if(ap_line != null){
			$ap_line.find("option:selected").remove();
			$("<option>").val(ap_line).text(ap_line_text).appendTo($position);
		}
	}
	if(action == "Ap_clear"){
		$("#ap_line option").each(function(){
			$("<option>").val($(this).val()).text($(this).text()).appendTo($position);
		});
		$ap_line.find("option").remove();
	}
	if(action == "Add_Ap"){
		if(ap_value == "000"){
			$("#myModalLg").modal();
			$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
			$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>ไม่ได้เลือกสาย</h4>');
			var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
			$("#lgfootermodel").html(btnclose);
		}else{
			var i = 0;
			$("#ap_line option").each(function(){
				Select[i] = $(this).val();
				i++;
			});
			$.ajax({
				method : "POST",
				url : "ApprovelineAdd",
				data : {ap_value:ap_value,Select:Select}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>แก้ไขข้อมูลสายการอนุมัติสำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="OK">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "ApprovelineView",
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>แก้ไขข้อมูลสายการอนุมัติผิดพลาด</h4>');
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
				}
			});
		}
	}
	if(action == "Ap_line_No_Add"){
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>ต้องการเพิ่มสายการอนุมัติหรือไม่</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "ApprovelineDetail",
				data : {action:action,ids:ids}
			}).done(function(data){
				$select.find("option").remove();
				$("<option>").val("000").text("---------------").appendTo($select);
				$.each(data,function(key,value){
					$("<option>").val(key).text(value).appendTo($select);
				});
			});
		});
	}
	if(action == "Ap_line_No_Delete"){
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>ต้องการลบสายการอนุมัติหรือไม่</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "ApprovelineDetail",
				data : {action:action,ids:ids,ap_value:ap_value}
			}).done(function(data){
				$select.find("option").remove();
				$ap_line.find("option").remove();
				$("<option>").val("000").text("---------------").appendTo($select);
				$.each(data,function(key,value){
					$("<option>").val(key).text(value).appendTo($select);
				});
			});
		});
	}
}

function ActionApprove(action,bk_id,g_bk_no,rm_num,queue_no){
	$.ajax({
		method : "POST",
		url : "ApproveManagement",
		data : {action:action,bk_id:bk_id,g_bk_no:g_bk_no,rm_num:rm_num,queue_no:queue_no}
	}).done(function(){
		$.post("ApproveView").done(function(page){
			window.location.href=page;
		});
	});
}

function ActionHistory(action,user_id,bk_id,g_bk_no){
	if(action == "View"){
		$.ajax({
			method : "POST",
			url : "BookingHistory",
			data : {user_id:user_id}
		}).done(function(){
			window.location.href="bookinghistory.jsp";
		});
	}
	if(action == "Cancel"){
		$.ajax({
			method : "POST",
			url : "ApproveManagement",
			data : {action:action,bk_id:bk_id,g_bk_no:g_bk_no}
		}).done(function(){
			$.post("BookingHistory",{user_id:user_id}).done(function(page){
				window.location.href="bookinghistory.jsp";
			});
		});
	}
}

function ActionClasstime(action,day_id,class_id){
	var day = $("#day").val();
	var classes = $("#class").val();
	var st_time = $("#st_time").val();
	var ed_time = $("#ed_time").val();
	if(action == "AddView"){
		$.ajax({
			method : "POST",
			url : "ClasstimeAddView"
		}).done(function(){
			window.location.href="classtimeadd.jsp";
		});
	}
	if(action == "Add"){
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "ClasstimeAdd",
				data : {day:day,classes:classes,st_time:st_time,ed_time:ed_time}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave+' '+btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "ClasstimeView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id=close data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "ClasstimeView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(action == "Edit"){
		$.ajax({
			method : "POST",
			url : "ClasstimeEdit",
			data : {day_id:day_id,class_id:class_id}
		}).done(function(){
			window.location.href="classtimeedit.jsp";
		});
	}
	if(action == "Update"){
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to save ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "ClasstimeUpdate",
				data : {day_id:day_id,class_id:class_id,day:day,classes:classes,st_time:st_time,ed_time:ed_time}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave+' '+btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "ClasstimeView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>อัปเดตข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "ClasstimeView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
	if(action == "Delete"){
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
		$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Do you want to Delete ?</h4>');
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Yes</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">No</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			$.ajax({
				method : "POST",
				url : "ClasstimeDelete",
				data : {day_id:day_id,class_id}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>ลบข้อมูลสำเร็จแล้ว</h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave+' '+btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "ClasstimeView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>ลบข้อมูลไม่สำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						$.ajax({
							method : "POST",
							url : "ClasstimeView"
						}).done(function(page){
							window.location.href=page;
						});
					});
				}
			});
		});
	}
}

function ActionCoursedetail(action){
	var Select = [];
	var $course = $("#course");
	var $coursedetail = $("#coursedetail");
	var course_value = $("#course option:selected").val();
	var coursedetail_value = $("#coursedetail option:selected").val();
	var course_text = $("#course option:selected").text();
	var coursedetail_text = $("#coursedetail option:selected").text();
	var semester = $("#semester").val();
	if(action == "AddView"){
		$.ajax({
			method : "POST",
			url : "CoursedetailAddView"
		}).done(function(){
			window.location.href="coursedetailadd.jsp";
		});
	}
	if(action == "Changet_semester"){
		if(semester == "000"){
				
		}else{
			$.ajax({
				method : "POST",
				url : "CoursedetailChange",
				data : {semester:semester}
			}).done(function(data){
				
			});
		}
	}
	if(action == "Addtolist"){
		if(course_value != null){
			$course.find("option:selected").remove();
			$("<option>").val(course_value).text(course_text).appendTo($coursedetail);
		}
	}
	if(action == "Deletefromlist"){
		if(coursedetail_value != null){
			$coursedetail.find("option:selected").remove();
			$("<option>").val(coursedetail_value).text(coursedetail_text).appendTo($course);
		}
	}
	if(action == "Clearlist"){
		$("#coursedetail option").each(function(){
			$("<option>").val($(this).val()).text($(this).text()).appendTo($course);
		});
		$coursedetail.find("option").remove();
	}
	if(action == "Add"){
		if(semester != "000"){
			var i = 0;
			$("#coursedetail option").each(function(){
				Select[i] = $(this).val();
				i++;
			});
			$.ajax({
				method : "POST",
				url : "CoursedetailAdd",
				data : {semester:semester,Select:Select}
			}).done(function(status){
				if(status == "success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true">เพิ่มข้อมูลสำเร็จแล้ว</span></h4>');
					var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
					var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
					$("#lgfootermodel").html(btnsave+' '+btnclose);
					$("#OK").click(function(){
						$.ajax({
							method : "POST",
							url : "CoursedetailAddView"
						}).done(function(){
							window.location.href="coursedetailadd.jsp";
						});
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true">เพิ่มข้อมูลไม่สำเร็จ</span></h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
				}
			});
		}else{
			$("#myModalLg").modal();
			$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
			$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>ไม่ได้เลือกข้อมูลเทอม หรือ ปีการศึกษา</h4>');
			var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
			$("#lgfootermodel").html(btnclose);
		}
	}
}

function testClick(){
	alert("Click Ok");
}

function TestValue(){
	alert("Change : "+id);
}