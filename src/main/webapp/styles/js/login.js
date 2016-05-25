$(function() {
	$("#emptyLoginDialog").click(function(){
		$("#loginName").val("");
		$("#loginPassword").val("");
	});
	$("#emptyRegisterDialog").click(function(){
		$("#registerForm input").val("");
	});
	$("#loginName").focus(function(){
		$("#loginName").attr("placeholder","邮箱或手机号").parent().parent().removeClass("has-error");
	});
	$("#loginPassword").focus(function(){
		$("#loginPassword").attr("placeholder","密码").parent().parent().removeClass("has-error");
	});
	$("#registerName").focus(function(){
		$("#registerName").attr("placeholder","邮箱或手机号").parent().parent().removeClass("has-error");
	});
	$("#registerPassword").focus(function(){
		$("#registerPassword").attr("placeholder","密码").parent().parent().removeClass("has-error");
	});
	$("#registerPasswordAgain").focus(function(){
		$("#registerPasswordAgain").attr("placeholder","密码").parent().parent().removeClass("has-error");
	});
	var href = window.location.hash;
	$(".active").removeClass("active");
	$(href).addClass("active");
	
});
/**
 *登录
 */
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
		url:$.ctx+"/passport/loginUser",
		data:{userName:userName,passWord:passWord},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.status === 200){
				window.location.reload() 
			}else{
				$("#loginName").val("").attr("placeholder","登录账号输入错误").parent().parent().addClass("has-error");
			}
		}
	});
	
}
/**
 *退出
 */
function logout() {
	$.ajax({
		url:$.ctx+"/passport/logout",
		data:{},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.status === 200){
				window.location.href = $.ctx + "/passport/index#index"; 
			}else{
				alert("系统出错！");
			}
		}
	});
	
}
/**
 * 注册
 */
function resigter(){
	var userName = $("#registerName").val();
	var passWord = $("#registerPassword").val();
	var passWordAgain = $("#registerPasswordAgain").val();
	if($.trim(userName).length==0){
		$("#registerName").attr("placeholder","登录账号输入错误").parent().parent().addClass("has-error");
		return;
	}else{
		$("#registerName").attr("placeholder","邮箱或手机号").parent().parent().removeClass("has-error");
	}
	if($.trim(passWord).length==0){
		$("#registerPassword").attr("placeholder","登录密码输入错误").parent().parent().addClass("has-error");
		return;
	}else{
		$("#registerPassword").attr("placeholder","密码").parent().parent().removeClass("has-error");
	}
	if($.trim(passWordAgain).length==0){
		$("#registerPasswordAgain").attr("placeholder","登录密码输入错误").parent().parent().addClass("has-error");
		return;
	}else{
		$("#registerPasswordAgain").attr("placeholder","密码").parent().parent().removeClass("has-error");
	}
	if(passWordAgain != passWord){
		$("#registerPasswordAgain").attr("placeholder","登录密码输入不一致").parent().parent().addClass("has-error");
		return;
	}else{
		$("#registerPasswordAgain").attr("placeholder","密码").parent().parent().removeClass("has-error");
	}
	$.ajax({
		url:$.ctx+"/passport/registerUser",
		data:{userName:userName,passWord:passWord},
		dataType:"json",
		type:"post",
		success:function(result){
//			console.log(result);
			if(result.status === 200){
				var user = result.user;
				if(user.userType && user.userType == "APPLICANT"){
					$("#userNameText").html("管理员,"+user.userName);
				}else if(user.userType && user.userType == "RECRUITER"){
					$("#userNameText").html("应聘者,"+user.userName);
				}
				$('#registerDialog').modal("hide");
			}else if(result.status === 403){
				$("#registerName").val("").attr("placeholder","您输入的账号已存在，请登录！").parent().parent().addClass("has-error");
			}
		}
	});
	
}

























