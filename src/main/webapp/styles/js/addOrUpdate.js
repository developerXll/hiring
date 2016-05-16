$(function(){
	getAnnounce();
	 getRecruit();
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
	if(window.location.href.split("?").length < 2 || window.location.hash.indexOf("announ") == -1){
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

//招聘管理
function getRecruit(){
	var theRequest = window.location.search;
	if(!theRequest || window.location.hash.indexOf("recruit") == -1){
		return;
	}
	var id = theRequest.split("#")[0].replace("?","");
	$.ajax({
		url:$.ctx+"/rec/get/"+id,
		data:{},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.status == 200){
				var data = result.data;
				$("#recName").val(data.possion).attr("recId",data.id);
				$("#recJobDesc").val(data.possionIntroduction);
				$("#recWorkContent").val(data.jobRequirement);
				$("#recMoney").val(data.pay);
				$("#recMonth").val(data.payMonths);
				$("#recStatus").val(data.recStatus);
			}else{
				alert("获取失败！");
			}
		}
	});
}
//add招聘
function saveOrUpdateRecruit(){
	var possion = $("#recName").val();
	if($.trim(possion).length==0){
		$("#recName").attr("placeholder","请输入岗位名称").parent().parent().addClass("has-error");
		return;
	}else{
		$("#recName").attr("placeholder","输入岗位名称").parent().parent().removeClass("has-error");
	}
	var recStatus = $("#recStatus").val()
	var id = $("#recName").attr("recId");
	var possionIntroduction =  $("#recJobDesc").val();
	var jobRequirement = $("#recWorkContent").val();
	var pay = $("#recMoney").val();
	var payMonths = $("#recMonth").val();
	var url = $.ctx+"/rec/add";
	if(id){
		url = $.ctx+"/rec/update";
	}
	$.ajax({
		url:url,
		data:{possion:possion,
			  id:id,
			  possionIntroduction:possionIntroduction,
			  jobRequirement:jobRequirement,
			  pay:pay,
			  payMonths:payMonths,
			  recStatus:recStatus},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.status == 200){
				alert("提交成功！");
				window.location.href = $.ctx + "/html/recruitList.jsp#recruit";
			}else{
				alert("提交失败！");
			}
		}
	});
	return false;
}

