$(function(){
	loadRecList(1);
	loadAnnounList(1);
	loadResumeList(1);
	loadBBSList(1);
	$("#recNext").on("click",function(){
		var currentPage = parseInt($("#currentPage").html()) + 1;
		loadRecList(currentPage);
	});
	$("#recPrcv").on("click",function(){
		var currentPage = parseInt($("#currentPage").html()) -1;
		loadRecList(currentPage);
	});
	$("#announNext").on("click",function(){
		var currentPage = parseInt($("#currentPage").html()) + 1;
		loadAnnounList(currentPage);
	});
	$("#announPrcv").on("click",function(){
		var currentPage = parseInt($("#currentPage").html()) -1;
		loadAnnounList(currentPage);
	});
	$("#resumeNext").on("click",function(){
		var currentPage = parseInt($("#currentPage").html()) + 1;
		loadResumeList(currentPage);
	});
	$("#resumePrcv").on("click",function(){
		var currentPage = parseInt($("#currentPage").html()) -1;
		loadResumeList(currentPage);
	});
	$("#bbsNext").on("click",function(){
		var currentPage = parseInt($("#currentPage").html()) + 1;
		loadBBSList(currentPage);
	});
	$("#bbsPrcv").on("click",function(){
		var currentPage = parseInt($("#currentPage").html()) -1;
		loadBBSList(currentPage);
	});
	$("#announceSearchBtn").on("click",function(){
		loadAnnounList($("#currentPage").html());
	});
	$("#recSearchBtn").on("click",function(){
		loadRecList($("#currentPage").html());
	});
	$("#resSearchList").on("click",function(){
		loadResumeList($("#currentPage").html());
	});
	$("#bbsListSearchBtn").on("click",function(){
		loadBBSList($("#currentPage").html());
	});
});
function loadRecList(pageNo){
	var name = $("#recName").val();
	$.ajax({
		url:$.ctx+"/rec/list/"+name,
		data:{pageNo:pageNo},
		dataType:"json",
		type:"post",
		success:function(result){
//			console.log(result);
			var data = result.list;
			var pager = result.page;
			var trHTml = "";
			if(data && data.length>0){
				for(var i=0,len=data.length;i<len;i++){
					trHTml += '<tr class="customer-tbody">'+
								'<td width="5%">'+(i+1)+'</td>'+
								'<td width="13%">'+data[i].possion+'</td>'+
								'<td width="23%">'+data[i].possionIntroduction+'</td>'+
								'<td width="21%">'+data[i].jobRequirement+'</td>'+
								'<td width="12%">'+data[i].insertTime+'</td>'+
								'<td width="12%">'+(data[i].recStatus == "RECRUTING"?"招聘中":"招聘结束")+'</td>'+
								'<td width="14%" class="color-yellow">';
								if($("#userNameText").attr("userType") == "APPLICANT"){
									trHTml += '<a class="btn btn-defaul" href="/html/addOrUpdateRecruit.jsp?'+data[i].id+'#recruit">修改</a>'+
									'<button class="btn btn-defaul"onclick="delRecruit('+data[i].id+')">删除</button>';
								}else if($("#userNameText").attr("userType") == "RECRUITER"){
									trHTml += '<a class="btn btn-defaul" href="/html/addOrUpdateRecruit.jsp?'+data[i].id+'#recruit">查看</a>';
//									if(data[i].recStatus == "RECRUTING"){
//										trHTml += '<button class="btn btn-defaul" resumeId ="" recruitId ="'+data[i].id+'">投递简历</button>';
//									}
								}
								trHTml += '</td></tr>';
				}
				$("#recTbody").html(trHTml);
				$("#currentPage").html(pager.pageNo);
				$("#totalPage").html(pager.totalPageNumber);
				if(pager.pageNo == 1){
					$("#recPrcv").parent().addClass("disabled");
					$("#recPrcv").off("click");
				}else{
					$("#recPrcv").parent().removeClass("disabled");
					$("#recPrcv").on("click",function(){
						var currentPage = parseInt($("#currentPage").html()) -1;
						loadRecList(currentPage);
					});
				}
				if(pager.pageNo == pager.totalPageNumber){
					$("#recNext").parent().addClass("disabled");
					$("#recNext").off("click");
				}else if(pager.pageNo != pager.totalPageNumber){
					$("#recNext").parent().removeClass("disabled");
					$("#recNext").on("click",function(){
						var currentPage = parseInt($("#currentPage").html()) + 1;
						loadRecList(currentPage);
					});
				}
				$(".ui-page-num").show();
			}else{
				$("#recTbody").html('<tr class="customer-tbody text-center"><td colspan="7">暂无数据</td></tr>');
				$("#recPrcv").parent().addClass("disabled");
				$("#recNext").parent().addClass("disabled");
				$(".ui-page-num").hide();
			}
		}
	});
}
function loadAnnounList(pageNo){
	var name = $("#announceSearchName").val();
	$.ajax({
		url:$.ctx+"/announ/list/" + name,
		data:{pageNo:pageNo},
		dataType:"json",
		type:"post",
		success:function(result){
//			console.log(result);return;
			var data = result.list;
			var pager = result.page;
			var trHTml = "";
			if(data && data.length>0){
				for(var i=0,len=data.length;i<len;i++){
					trHTml += '<tr class="customer-tbody">'+
					'<td width="5%">'+(i+1)+'</td>'+
					'<td width="13%">'+data[i].title+'</td>'+
					'<td width="23%">'+data[i].annInfo+'</td>'+
					'<td width="21%">'+data[i].user.userName+'</td>'+
					'<td width="12%">'+(data[i].user.userType != "RECRUITER" ? "管理员":"应聘者")+'</td>'+
					'<td width="12%">'+data[i].insertTime+'</td>'+
					'<td width="14%" class="color-yellow">';
					if($("#userNameText").attr("userType") == "APPLICANT"){
						trHTml += '<a class="btn btn-default" href="/html/addOrUpdateAnnounce.jsp?id='+data[i].id+'#announ">修改</a>'+
						'<button class="btn btn-default" onclick="delAnnounce('+data[i].id+')">删除</button>';
					}else if($("#userNameText").attr("userType") == "RECRUITER"){
						trHTml += '<a class="btn btn-default" href="/html/addOrUpdateAnnounce.jsp?id='+data[i].id+'#announ">查看</a>';
					}
					trHTml += '</td></tr>';
				}
				$("#announTbody").html(trHTml);
				$("#currentPage").html(pager.pageNo);
				$("#totalPage").html(pager.totalPageNumber);
				if(pager.pageNo == 1){
					$("#announPrcv").parent().addClass("disabled");
					$("#announPrcv").off("click");
				}else{
					$("#announPrcv").parent().removeClass("disabled");
					$("#announPrcv").on("click",function(){
						var currentPage = parseInt($("#currentPage").html()) -1;
						loadAnnounList(currentPage);
					});
				}
				if(pager.pageNo == pager.totalPageNumber){
					$("#announNext").parent().addClass("disabled");
					$("#announNext").off("click");
				}else if(pager.pageNo != pager.totalPageNumber){
					$("#announNext").parent().removeClass("disabled");
					$("#announNext").on("click",function(){
						var currentPage = parseInt($("#currentPage").html()) + 1;
						loadAnnounList(currentPage);
					});
				}
				$(".ui-page-num").show();
			}else{
				$("#announTbody").html('<tr class="customer-tbody text-center"><td colspan="7">暂无数据</td></tr>');
				$("#announPrcv").parent().addClass("disabled");
				$("#announNext").parent().addClass("disabled");
				$(".ui-page-num").hide();
			}
		}
	});
}
function loadResumeList(pageNo){
	var name = $("#resNameSearch").val();
	$.ajax({
		url:$.ctx+"/res/list/"+name,
		data:{pageNo:pageNo},
		dataType:"json",
		type:"post",
		success:function(result){
			var data = result.list;
			var pager = result.page;
			var trHTml = "";
			if(data && data.length>0){
				for(var i=0,len=data.length;i<len;i++){
					trHTml += '<tr class="customer-tbody">'+
					'<td width="5%">'+(i+1)+'</td>'+
					'<td width="13%">'+data[i].name+'</td>'+
					'<td width="13%">'+(data[i].gender == "M"?"男":"女")+'</td>'+
					'<td width="12%">'+data[i].resumeEdus[0].education+'</td>'+
					'<td width="12%">'+data[i].resumeEdus[0].schoolName+'</td>'+
					'<td width="10%">'+data[i].age+'</td>'+
					'<td width="12%">'+data[i].status+'</td>'+
					'<td width="23%" class="color-yellow">';
					if($("#userNameText").attr("userType") == "APPLICANT"){
						trHTml += '<a class="btn btn-defaul" href="/html/addResume.jsp?'+data[i].id+'#resume">查看</a>';
					}else if($("#userNameText").attr("userType") == "RECRUITER"){
						trHTml += '<a class="btn btn-defaul" href="/html/addResume.jsp?'+data[i].id+'#resume">修改</a>';
					}
					trHTml += '<a class="btn btn-defaul" href="javascript:void();">通过</a>';
					trHTml += '<a class="btn btn-defaul" href="javascript:void();">不通过</a>';
					trHTml += '<button class="btn btn-defaul" onclick="delRes('+data[i].id+')">删除</button>'+
					'</td>'+
					'</tr>';
				}
				$("#resumeTbody").html(trHTml);
				$("#currentPage").html(pager.pageNo);
				$("#totalPage").html(pager.totalPageNumber);
				if(pager.pageNo == 1){
					$("#resumePrcv").parent().addClass("disabled");
					$("#resumePrcv").off("click");
				}else{
					$("#resumePrcv").parent().removeClass("disabled");
					$("#resumePrcv").on("click",function(){
						var currentPage = parseInt($("#currentPage").html()) -1;
						loadResumeList(currentPage);
					});
				}
				if(pager.pageNo == pager.totalPageNumber){
					$("#resumeNext").parent().addClass("disabled");
					$("#resumeNext").off("click");
				}else if(pager.pageNo != pager.totalPageNumber){
					$("#resumeNext").parent().removeClass("disabled");
					$("#resumeNext").on("click",function(){
						var currentPage = parseInt($("#currentPage").html()) + 1;
						loadResumeList(currentPage);
					});
				}
				$(".ui-page-num").show();
			}else{
				$("#resumeTbody").html('<tr class="customer-tbody text-center"><td colspan="7">暂无数据</td></tr>');
				$("#resumePrcv").parent().addClass("disabled");
				$("#resumeNext").parent().addClass("disabled");
				$(".ui-page-num").hide();
			}
		}
	});
}
//删除公告
function delAnnounce(id){
	if(!confirm("确定删除？")){
		return;
	}
	$.ajax({
		url:$.ctx+"/announ/delete/"+id,
		data:{id:id},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.status == 200){
				alert("删除成功！");
				loadAnnounList($("#currentPage").html());
			}else{
				alert("删除错误！");
			}
		}
	});
}
//del招聘 
function delRecruit(id){
	if(!confirm("确定删除？")){
		return;
	}
	$.ajax({
		url:$.ctx+"/rec/delete/"+id,
		data:{},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.status == 200){
				loadRecList($("#currentPage").html());
			}else{
				alert("删除失败！");
			}
		}
	});
}
//del简历
function delRes(id){
	if(!confirm("确定删除？")){
		return;
	}
	$.ajax({
		url:$.ctx+"/res/delete/"+id,
		data:{},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.status == 200){
				loadResumeList($("#currentPage").html());
			}else{
				alert("删除失败！");
			}
		}
	});
}
//加载论坛主题
function loadBBSList(pageNo){
	var name = $("#bbsListName").val();
	$.ajax({
		url:$.ctx+"/theme/listTheme/"+name,
		data:{pageNo:pageNo},
		dataType:"json",
		type:"post",
		success:function(result){
			var data = result.list;
			var pager = result.page;
			var trHTml = "";
			if(data && data.length>0){
				for(var i=0,len=data.length;i<len;i++){
					trHTml += '<tr class="customer-tbody">'+
					'<td width="5%">'+(i+1)+'</td>'+
					'<td width="60%">'+data[i].title+'</td>'+
					'<td width="15%">'+data[i].insertDate+'</td>'+
					'<td width="20%" class="color-yellow">';
					if($("#userNameText").attr("userType") == "APPLICANT"){
						trHTml += '<button class="btn btn-defaul" onclick="delBBS('+data[i].id+')">删除</button>';
					} 
					trHTml += '<a class="btn btn-defaul" href="/html/showBBS.jsp?'+data[i].id+'#bbs">查看</a>'+
					'</td>'+
					'</tr>';
				}
				$("#bbsListTbody").html(trHTml);
				$("#currentPage").html(pager.pageNo);
				$("#totalPage").html(pager.totalPageNumber);
				if(pager.pageNo == 1){
					$("#bbsPrcv").parent().addClass("disabled");
					$("#bbsPrcv").off("click");
				}else{
					$("#bbsPrcv").parent().removeClass("disabled");
					$("#bbsPrcv").on("click",function(){
						var currentPage = parseInt($("#currentPage").html()) -1;
						loadBBSList(currentPage);
					});
				}
				if(pager.pageNo == pager.totalPageNumber){
					$("#bbsNext").parent().addClass("disabled");
					$("#bbsNext").off("click");
				}else if(pager.pageNo != pager.totalPageNumber){
					$("#bbsNext").parent().removeClass("disabled");
					$("#bbsNext").on("click",function(){
						var currentPage = parseInt($("#currentPage").html()) + 1;
						loadBBSList(currentPage);
					});
				}
				$(".ui-page-num").show();
			}else{
				$("#bbsListTbody").html('<tr class="customer-tbody text-center"><td colspan="4">暂无数据</td></tr>');
				$("#bbsPrcv").parent().addClass("disabled");
				$("#bbsNext").parent().addClass("disabled");
				$(".ui-page-num").hide();
			}
		}
	});
}
function delBBS(id){
	if(!confirm("确定删除？")){
		return;
	}
	$.ajax({
		url:$.ctx+"/theme/delTheme/"+id,
		data:{},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.status == 200){
				loadBBSList($("#currentPage").html());
			}else{
				alert("删除失败！");
			}
		}
	});
}
