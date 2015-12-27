/**
 * 
 */
$().ready(function(){
	$("#login-button").click(function(){
		$("#login-form").submit();
		
	});
	$("#register-button").click(function(){
		var register_data = $("#register-form").serialize();
		$.ajax({
            type: "POST",
            url: ctx+"/register.json",
            data: register_data,
//            dataType: "json",
            success: function(data){
            	var retCode = data.retCode;
            	var retMsg = data.retMsg;
            	if(retCode=="1"){
            		$( "#dialog-msg" ).html(getSucDialog("注册成功"));
					$( "#dialog-msg" ).removeClass('hide').dialog({
//						show:"blind",//打开时的效果
//						hide:"explode",//关闭时的效果
						closeOnEscape:true, //false 是否采用esc键退出对 话框 如果true 采用esc
						resizable: false,
						modal: true,
						title: "提示信息",
						title_html: true,
						buttons: [
							{
								text: "确定",
								"class" : "btn btn-primary btn-xs",
								click: function() {
									$( this ).dialog( "close" ); 
									show_box('login-box');
									$("button[type=\"reset\"]").trigger("click");
								} 
							}
						]
					});
            	}else if(retCode=="901"){
            		$( "#dialog-msg" ).html(getErrDialog("注册失败.<p>原因:"+retMsg+"</p>"));
            		$( "#dialog-msg" ).removeClass('hide').dialog({
						closeOnEscape:true, //false 是否采用esc键退出对 话框 如果true 采用esc
						resizable: false,
						modal: true,
						title: "提示信息",
						title_html: true,
						buttons: [
							{
								text: "确定",
								"class" : "btn btn-primary btn-xs",
								click: function() {
									$( this ).dialog( "close" ); 
									$("button[type=\"reset\"]").trigger("click");
								} 
							}
						]
					});
            	}
            },
	        error: function(e) {
	        	 alert("error"); 
	        }
        });
	});
});
