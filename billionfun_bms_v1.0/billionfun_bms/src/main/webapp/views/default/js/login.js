/**
 * 
 */
$().ready(function(){
	$("#login-button").click(function(){
		if(!$('#login-form').valid()){
			return false;
		}
		alert("");
	//	$("#login-form").submit();
		
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
            		bootbox.alert("注册成功。", function(result) {
						alert(result);
					});
            	}else if(retCode=="901"){
            		bootbox.alert("注册失败。<p>原因:"+retMsg+"</p>", function(result) {
						alert(result);
					});
            	}
            },
	        error: function(e) {
	        	 alert("error"); 
	        }
        });
	});
	$('#login-form').validate({
		rules: {
			j_username: {
				required: true,
				email:true
			},
			j_password: {
				required: true,
				minlength: 5
			}
			
		},

		messages: {
			email: {
				required: "Please provide a valid email.",
				email: "Please provide a valid email."
			},
			password: {
				required: "Please specify a password.",
				minlength: "Please specify a secure password."
			}
			
		}
	});
});
