$(function(){
	loadRecList(1);
	loadAnnounList(1);
	loadResumeList(1);
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
	$("#announceSearchBtn").on("click",function(){
		loadAnnounList($("#currentPage").html());
	});
});
function loadRecList(pageNo){
	$.ajax({
		url:$.ctx+"/rec/list",
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
								'<td width="14%" class="color-yellow">'+
									'<button class="btn btn-defaul">修改</button>'+
									'<button class="btn btn-defaul">删除</button>'+
								'</td>'+
							'</tr>';
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
					'<td width="12%">'+(data[i].user.userType == "RECRUITER" ? "管理员":"应聘者")+'</td>'+
					'<td width="12%">'+data[i].insertTime+'</td>'+
					'<td width="14%" class="color-yellow">'+
					'<a class="btn btn-default" href="/html/addOrUpdateAnnounce.jsp?id='+data[i].id+'#announ">修改</a>'+
					'<button class="btn btn-default" onclick="delAnnounce('+data[i].id+')">删除</button>'+
					'</td>'+
					'</tr>';
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
	$.ajax({
		url:$.ctx+"/res/list",
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
					'<td width="13%">'+data[i].name+'</td>'+
					'<td width="23%">'+(data[i].gender == "M"?"男":"女")+'</td>'+
					'<td width="21%">'+data[i].education+'</td>'+
					'<td width="12%">'+data[i].graduateSchool+'</td>'+
					'<td width="12%">'+data[i].age+'</td>'+
					'<td width="14%" class="color-yellow">'+
					'<button class="btn btn-defaul">修改</button>'+
					'<button class="btn btn-defaul">删除</button>'+
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