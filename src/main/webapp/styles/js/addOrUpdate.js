$(function(){
	getAnnounce();
	$("#noticeName").focus(function(){
		$("#noticeName").attr("placeholder","输入公告名称").parent().parent().removeClass("has-error");
		$(".ui-error").remove();
	});
	$("#noticeContent").focus(function(){
		$("#noticeContent").attr("placeholder","输入公告内容").parent().parent().removeClass("has-error");
		$(".ui-error").remove();
	});
});
function getAnnounce(){
	if(window.location.href.split("?").length < 2){
		return;
	}
	var url = window.location.href.split("?")[1];
	var id = url.split("#")[0].split("=")[1];
	$.ajax({
		url:$.ctx+"/announ/get/"+id,
		data:{},
		dataType:"json",
		type:"post",
		success:function(result){
			var data = result.data;
			$("#noticeName").val(data.title).attr("announceId",data.id);
			$("#noticeContent").val(data.annInfo);
		}
	});
}
function addOrUpdateAnnounce(obj){
	var title = $("#noticeName").val();
	var announceId = $("#noticeName").attr("announceId")
	var annInfo = $("#noticeContent").val();
	if($.trim(title).length==0){
		$("#noticeName").attr("placeholder","请输入名称").parent().parent().addClass("has-error");
		return;
	}else{
		$("#noticeName").attr("placeholder","输入公告名称").parent().parent().removeClass("has-error");
	}
	if($.trim(annInfo).length==0){
		$("#noticeContent").attr("placeholder","请输入内容").parent().parent().addClass("has-error");
		return;
	}else{
		$("#noticeContent").attr("placeholder","输入公告名称").parent().parent().removeClass("has-error");
	}
	var url = $.ctx+"/announ/add";
	var data = {"title":title,"annInfo":annInfo};
	if(announceId){
		data["id"] = announceId;
		url = $.ctx+"/announ/update";
	}
	$.ajax({
		url:url,
		data:data,
		dataType:"json",
		type:"post",
		success:function(result){
			console.log(result);
			if(result.status == 200){
				window.location.href = $.ctx + "/html/announ.jsp#announ";
			}else{
				$(obj).after('<span class="ui-error">提交失败</span>');
			}
		}
	});
}