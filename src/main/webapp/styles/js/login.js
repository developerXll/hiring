$(function() {
	
});
function login() {
	var userName = $("#loginName").val();
	var passWord = $("#loginPassword").val();
	$.ajax({
		url:"/passport/loginUser",
		data:{userName:,passWord:passWord},
		dataType:"json",
		type:"post"
		success:function(result){
			
		}
	});
	
}