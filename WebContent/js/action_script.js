function action_event(){
	$("#event").hide();
	$("#002").click(function() {
		$("#event").toggle();
	});
	$("#schedule td.Active").on("mouseover",function(){
		$(this).css( "background-color", "rgba(83,84,83,0.2)" );
	});
	$("#schedule td.Active").on("mouseleave",function(){
		$(this).css( "background-color", "rgba(192,192,192,0.2)" );
	});
	
	$('#datetimepicker6').datetimepicker({
		inline: true,
        sideBySide: true,
        format: 'DD/MM/YYYY',
        minDate: new Date()
	});
    $('#datetimepicker7').datetimepicker({
    	useCurrent: true, //Important! See issue #1075
        inline: true,
        sideBySide: true,
        format: 'DD/MM/YYYY',
        minDate: new Date()
    });
    
    //$("#datetimepicker7").data("DateTimePicker").hide();
    
    $("#datetimepicker6").on("dp.change", function (e) {
        $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
    });

}