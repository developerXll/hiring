$(function() {
	$("#emptyLoginDialog").click(function(){
		$("#loginName").val("");
		$("#loginPassword").val("");
	});
	$("#loginName").focus(function(){
		$("#loginName").attr("placeholder","邮箱或手机号").parent().parent().removeClass("has-error");
	});
	$("#loginPassword").focus(function(){
		$("#loginPassword").attr("placeholder","密码").parent().parent().removeClass("has-error");
	});
	if(user.userType == "APPLICANT"){
		$("#userNameText").html("管理员,"+user.userName);
	}else{
		$("#userNameText").html("应聘者,"+user.userName);
	}
});
function login() {
	var userName = $("#loginName").val();
	var passWord = $("#loginPassword").val();
	if($.trim(userName).length==0){
		$("#loginName").attr("placeholder","登录账号输入错误").parent().parent().addClass("has-error");
		return;
	}else{
		$("#loginName").attr("placeholder","邮箱或手机号").parent().parent().removeClass("has-error");
	}
	if($.trim(passWord).length==0){
		$("#loginPassword").attr("placeholder","登录密码输入错误").parent().parent().addClass("has-error");
		return;
	}else{
		$("#loginPassword").attr("placeholder","密码").parent().parent().removeClass("has-error");
	}
	$.ajax({
		url:"/passport/loginUser",
		data:{userName:userName,passWord:passWord},
		dataType:"json",
		type:"post",
		success:function(result){
//			console.log(result);
			if(result.status === 200){
				var user = result.user;
				if(user.userType == "APPLICANT"){
					$("#userNameText").html("管理员,"+user.userName);
				}else{
					$("#userNameText").html("应聘者,"+user.userName);
				}
				$('#loginDialog').modal("hide");
			}
		}
	});
	
}