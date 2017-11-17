function ScheduleOnButton(){
	/*var text_td = $("#"+id+"").text();
	if(text_td==''){
		alert("empty");
	}else{
		alert(text_td);
	}*/
	var action = "ShowView";
	var semester_val = $("#semester_td option:selected").val();
	var room_val = $("#room_td option:selected").val();
	$.ajax({
		method : "POST",
		url : "ScheduleAddView",
		data : {action:action}
	}).done(function(data){
		var data1 = data[0];
		var data2 = data[1];
		var data3 = data[2];
		$("#myModalLg").modal();
		$("#lgheadermodel").html('<h3>จองห้องสอน</h3>');
		var start_form = '<form class="form-inline" style="text-align: right;">';
		var end_form = '</form>';
		var semester_select = '<div class="row col-sm-offset-3"><label class="col-sm-3">ภาคการศึกษา :</label><select class="form-control col-sm-4" id="semester" onchange="ScheduleChangeList(1)"></select></div>';
		var room_select = '<div class="row col-sm-offset-3"><label class="col-sm-3">ห้อง :</label><select class="form-control col-sm-4" id="room"></select></div>';
		var course_select = '<div class="row col-sm-offset-3"><label class="col-sm-3">รายวิชา :</label><select class="form-control col-sm-4" id="course" style="width: 60%;"></select></div>';
		var day_select = '<div class="row col-sm-offset-3"><label class="col-sm-3">วัน :</label><select class="form-control col-sm-4" id="day" onchange="ScheduleChangeList(2)"></select></div>';
		var class_select = '<div class="row col-sm-offset-3"><label class="col-sm-3">คาบเรียน :</label><select class="form-control col-sm-4" id="class"></select></div>';
		var teach_style = '<div class="row col-sm-offset-3"><label class="col-sm-3">ประเภทการสอน :</label>'+
		'<div class="form-check" style="text-align: left;"><input class="form-check-input" type="checkbox" id="t_style" value="002"> Lec </div>'+
		'<div class="form-check" style="text-align: left;"><input class="form-check-input" type="checkbox" id="t_style" value="003"> Lab </div>'+
		'</div>';
		$("#lgbodymodel").html(start_form+semester_select+"&nbsp;"+room_select+"&nbsp;"+course_select+"&nbsp;"+day_select+"&nbsp;"+class_select+"&nbsp;"+teach_style+end_form);
		var $room = $("#room");
		var $semester = $("#semester");
		$("<option hidden>").val("").text('เลือกห้อง').appendTo($room);
		$("<option hidden>").val("").text('เลือกภาคการศึกษา').appendTo($semester);
		$("#course").append('<option value="" hidden selected="selected">เลือกรายวิชา</option>');
		$("#class").append('<option value="" hidden selected="selected">เลือกคาบเรียน</option>');
		$("#day").append('<option value="" hidden selected="selected">เลือกวัน</option>');
		$.each(data1,function(index,value){
			if(semester_val==value.sem_id+value.year){
				$("<option>").val(value.sem_id+value.year).text(value.sem_name+"/"+value.year).appendTo($semester).prop('selected','selected');
			}else{
				$("<option>").val(value.sem_id+value.year).text(value.sem_name+"/"+value.year).appendTo($semester);
			}
		});
		$.each(data2,function(index,value){
			if(room_val==value.rm_num){
				$("<option>").val(value.rm_num).text(value.rm_num).appendTo($room).prop('selected','selected');
			}else{
				$("<option>").val(value.rm_num).text(value.rm_num).appendTo($room);
			}
		});
		$.each(data3,function(index,value){
			$("#day").append('<option value='+value.day_id+'>'+value.day_name+'</option>');
		});
		var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">OK</button>';
		var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">NO</button>';
		$("#lgfootermodel").html(btnsave+' '+btnclose);
		$("#OK").click(function(){
			var i = 0;
			var ck_list = [];
			var room = $("#room option:selected").val();
			var course = $("#course option:selected").val();
			var day = $("#day option:selected").val();
			var classes = $("#class option:selected").val();
			var semester = $("#semester option:selected").val();
			ck_list[0] = '001';
			$("#t_style:checked").each(function(){
				ck_list[i] = $(this).val();
				i++;
			});
			$.ajax({
				method : "POST",
				url : "ScheduleAdd",
				data : {
					semester:semester,
					room:room,
					course:course,
					day:day,
					classes:classes,
					ck_list:ck_list
				}
			}).done(function(status){
				if(status=="success"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>เพิ่มข้อมูลการสอนสำเร็จ</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						location.reload();
					});
				}else if(status=="more"){
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>มีการจองแล้วในช่วงเวลานี้</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						location.reload();
					});
				}else{
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>กรอกข้อมูลไม่ครบถ้วน</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
					$("#close").click(function(){
						location.reload();
					});
				}
			});
		});
	});
}

function ScheduleChange(action){
	var status = false;
	var day_show = []
	var code_show = [];
	var cname_show = [];
	var tname_show = [];
	var text1,text2,textid;
	if(action=="build_ch"){
		var $room = $("#room_td");
		var b_val = $("#building_td option:selected").val();
		$.ajax({
			method : "POST",
			url : "ScheduleChange",
			data : {action:action,building:b_val}
		}).done(function(data){
			$room.find("option").remove();
			$("<option hidden>").val('').text('เลือกห้อง').prop('selected','selected').appendTo($room);
			$.each(data,function(index,value){
				$("<option>").val(value.rm_num).text(value.rm_num).appendTo($room);
				status = true;
			});
			if(!(status)){
				$("<option>").val('').text('ไม่มี').appendTo($room);
			}
		});
	}
	if(action=="ShowOn_T"){
		var semester = $("#semester_td option:selected").val();
		var room = $("#room_td option:selected").val();
		if((semester!='')&&(room!='')){
			$.ajax({
				method : "POST",
				url : "ScheduleChange",
				data : {
					action:action,
					semester:semester,
					room:room
				}
			}).done(function(data){
				var data1 = data[0];
				var data2 = data[1];
				var data3 = data[2];
				$("#schedule td div").text('');
				$.each(data1,function(index,value){
					text1 = '<div>'+value.c_code+'</div>'+'<div>'+value.c_name+'</div>';
				});
				$.each(data2,function(index,value){
					text2 = '<div>'+value.teach_name+'</div>';
				});
				$.each(data3,function(index,value){
					text3 = value;
					$("#"+text3+"").append(text1+text2);
				});
			});
		}
	}
}

function ScheduleChangeList(status){
	var action;
	var semester = $("#semester option:selected").val();
	var day = $("#day option:selected").val();
	var c_code = [];
	var c_name = [];
	var class_id = [];
	var class_name = [];
	var status_1 = false;
	if(status=='1'){
		action = "ChangeCourse";
		$.ajax({
			method : "POST",
			url : "ScheduleAddView",
			data : {action:action,semester:semester}
		}).done(function(data){
			$("#course").find("option").remove();
			$("#course").append('<option value="" hidden selected="selected">เลือกรายวิชา</option>');
			$.each(data,function(index,value){
				$("#course").append('<option value='+value.c_code+'>'+value.c_code+" | "+value.c_name+'</option>');
				status_1 = true;
			});
			if(!(status_1)){
				$("#course").append('<option value=""> ไม่มี </option>');
			}
		});
	}else{
		action = "ChangeDay";
		$.ajax({
			method : "POST",
			url : "ScheduleAddView",
			data : {action:action,day:day}
		}).done(function(data){
			$("#class").find("option").remove();
			$("#class").append('<option value="" hidden selected="selected">เลือกคาบเรียน</option>');
			$.each(data,function(index,value){
				$("#class").append('<option value='+value.classid+'>'+value.classname+'</option>');
				status_1 = true;
			});
			if(!(status_1)){
				$("#class").append('<option value=""> ไม่มี </option>');
			}
		});
	}
}

function ScheduleOnTd(ids){
	var action;
	var text = $("#"+ids+"").text();
	var semester_val = $("#semester_td option:selected").val();
	var room_val = $("#room_td option:selected").val();
	var sem_id = semester_val.substring(0,3);
	var year = semester_val.substring(3,7);
	var day_name = ids.substring(0,3);
	var cl_id = ids.substring(3,6);
	var day_id;
	var status;
	var i=0,j=0,k=0,l=0;
	var sem_id = [],sem_name = [],sem_year = [];
	var c_code = [],c_name = [];
	var d_id = [],d_name = [];
	var cls_id = [],cls_name = [];
	switch(day_name){
		case 'sun' : day_id = '001';break;
		case 'mon' : day_id = '002';break;
		case 'tue' : day_id = '003';break;
		case 'wed' : day_id = '004';break;
		case 'thu' : day_id = '005';break;
		case 'fri' : day_id = '006';break;
		case 'sat' : day_id = '007';break;
	}
	if(text!=''){
		action = "ShowEdit";
		alert(action);
		var course_val = text.substring(0,8);
		$.ajax({
			method : "POST",
			url : "ScheduleEdit",
			data : {action:action,semester:semester_val,day_id:day_id,cl_id:cl_id,course:course_val}
		}).done(function(data){
			$("#myModalLg").modal();
			$("#lgheadermodel").html('<h3>จองห้องสอน</h3>');
			var start_form = '<form class="form-inline" style="text-align: right;">';
			var end_form = '</form>';
			var semester_select = '<div class="row col-sm-offset-3"><label class="col-sm-3">ภาคการศึกษา :</label><select class="form-control col-sm-4" id="semester" onchange="ScheduleChangeList(1)"></select></div>';
			var room_select = '<div class="row col-sm-offset-3"><label class="col-sm-3">ห้อง :</label><select class="form-control col-sm-4" id="room"></select></div>';
			var course_select = '<div class="row col-sm-offset-3"><label class="col-sm-3">รายวิชา :</label><select class="form-control col-sm-4" id="course" style="width: 60%;"></select></div>';
			var day_select = '<div class="row col-sm-offset-3"><label class="col-sm-3">วัน :</label><select class="form-control col-sm-4" id="day" onchange="ScheduleChangeList(2)"></select></div>';
			var class_select = '<div class="row col-sm-offset-3"><label class="col-sm-3">คาบเรียน :</label><select class="form-control col-sm-4" id="class"></select></div>';
			var teach_style = '<div class="row col-sm-offset-3"><label class="col-sm-3">ประเภทการสอน :</label>'+
			'<div class="form-check" style="text-align: left;"><input class="form-check-input" type="checkbox" id="t_style" value="002"> Lec </div>'+
			'<div class="form-check" style="text-align: left;"><input class="form-check-input" type="checkbox" id="t_style" value="003"> Lab </div>'+
			'</div>';
			$("#lgbodymodel").html(start_form+semester_select+"&nbsp;"+room_select+"&nbsp;"+course_select+"&nbsp;"+day_select+"&nbsp;"+class_select+"&nbsp;"+teach_style+end_form);
			$room = $("#room");
			$semester = $("#semester");
			$course = $("#course");
			$day = $("#day");
			$class = $("#class");
			$teach_style = $("#t_style");
			$("<option hidden>").val('').text('เลือกภาคการศึกษา').appendTo($semester);
			$("<option hidden>").val('').text('เลือกห้อง').appendTo($room);
			$("<option hidden>").val('').text('เลือกรายวิชา').appendTo($course);
			$("<option hidden>").val('').text('เลือกวัน').appendTo($day);
			$("<option hidden>").val('').text('เลือกคาบเรียน').appendTo($class);
			$.each(data,function(key,value){
				if(key.indexOf('semester')>-1){
					if(key.indexOf('Id')>-1){
						sem_id[i] = value;
					}else if(key.indexOf('Name')>-1){
						sem_name[i] = value;
					}else{
						sem_year[i] = value;
						i++;
					}
				}
				if(key.indexOf('room')>-1){
					if(room_val==value){
						$("<option>").val(value).text(value).appendTo($room).prop('selected','selected');
					}else{
						$("<option>").val(value).text(value).appendTo($room);
					}
				}
				if(key.indexOf('course')>-1){
					if(key.indexOf('Code')>-1){
						c_code[j] = value;
					}else{
						c_name[j] = value;
						j++;
					}
				}
				if(key.indexOf('day')>-1){
					if(key.indexOf('Id')>-1){
						d_id[k] = value;
					}else{
						d_name[k] = value;
						k++;
					}
				}
				if(key.indexOf('class')>-1){
					if(key.indexOf('Id')>-1){
						cls_id[l] = value;
					}else{
						cls_name[l] = value;
						l++;
					}
				}
				if(key.indexOf('teach')>-1){
					
				}
			})
			for(var a=0;a<i;a++){
				if(semester_val==sem_id[a]+sem_year[a]){
					$("<option>").val(sem_id[a]+sem_year[a]).text(sem_name[a]+"/"+sem_year[a]).appendTo($semester).prop('selected','selected');
				}else{
					$("<option>").val(sem_id[a]+sem_year[a]).text(sem_name[a]+"/"+sem_year[a]).appendTo($semester);
				}
			}
			for(var a=0;a<j;a++){
				if(course_val==c_code[a]){
					$("<option>").val(c_code[a]).text(c_code[a]+" | "+c_name[a]).appendTo($course).prop('selected','selected');
				}else{
					$("<option>").val(c_code[a]).text(c_code[a]+" | "+c_name[a]).appendTo($course);
				}
			}
			for(var a=0;a<k;a++){
				if(day_id==d_id[a]){
					$("<option>").val(d_id[a]).text(d_name[a]).appendTo($day).prop('selected','selected');
				}else{
					$("<option>").val(d_id[a]).text(d_name[a]).appendTo($day);
				}
			}
			for(var a=0;a<l;a++){
				if(cl_id==cls_id[a]){
					$("<option>").val(cls_id[a]).text(cls_name[a]).appendTo($class).prop('selected','selected');
				}else{
					$("<option>").val(cls_id[a]).text(cls_name[a]).appendTo($class);
				}
			}
			var btntrach = '<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span></button>';
			var btnsave = '<button type="button" class="btn btn-default" id="OK" data-dismiss="modal">Save</button>';
			var btnclose = '<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>';
			$("#lgfootermodel").html(btntrach+' '+btnsave+' '+btnclose);
		});
	}else{
		action = "ShowView";
		alert(action);
		$.ajax({
			method : "POST",
			url : "ScheduleEdit",
			data : {action:action,semester:semester_val,day_id:day_id,cl_id:cl_id}
		}).done(function(data){
			$.each(data,function(key,value){
				if(key.indexOf('Status')>-1){
					status = value;
				}
				if(status=='true'){
					alert("OK");
				}else{
					alert("Fail");
					$("#myModalLg").modal();
					$("#lgheadermodel").html('<h3>Confirm Message !!!</h3>')
					$("#lgbodymodel").html('<h4><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>ไม่มีข้อมูลคาบเรียน</h4>');
					var btnclose = '<button type="button" class="btn btn-default" id="close" data-dismiss="modal">OK</button>';
					$("#lgfootermodel").html(btnclose);
				}
			})
		});
	}
}