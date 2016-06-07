$(function() {
	loadAnnounIndexList();
	loadResIndexList();
	loadRecIndexList();
}); 
//获取首页公告列表
function loadAnnounIndexList(){
	$.ajax({
		url:$.ctx+"/announ/list",
		data:{},
		dataType:"json",
		type:"post",
		success:function(result){
			result = result.list;
			var liHTml = "";
			if(result && result.length>0){
				for(var i=0,len=result.length;i<len;i++){
					liHTml += '<li class="list-group-item" id="'+result[i].id+'">'+result[i].title+'</li>';
				}
				$("#announIndexList").html(liHTml);
			}else{
				$("#announIndexList").html('<li class="list-group-item">暂无数据</li>');
			}
		}
	});
	
}

//获取首页简历列表
function loadResIndexList(){
	$.ajax({
		url:$.ctx+"/res/list",
		data:{},
		dataType:"json",
		type:"post",
		success:function(result){
			result = result.list;
			var liHTml = "";
			if(result && result.length>0){
				for(var i=0,len=result.length;i<len;i++){
					liHTml += '<li class="list-group-item" id="'+result[i].id+'">'+result[i].name+'</li>';
				}
				$("#myResList").html(liHTml);
			}else{
				$("#myResList").html('<li class="list-group-item">暂无数据</li>');
			}
		}
	});
	
}
//获取首页 招聘信息列表
function loadRecIndexList(){
	$.ajax({
		url:$.ctx+"/rec/list ",
		data:{},
		dataType:"json",
		type:"post",
		success:function(result){
			result = result.list;
			var liHTml = "";
			if(result && result.length>0){
				for(var i=0,len=result.length;i<len;i++){
					liHTml += '<li class="list-group-item" id="'+result[i].id+'">'+result[i].possion+'</li>';
				}
				$("#myRecList").html(liHTml);
			}else{
				$("#myRecList").html('<li class="list-group-item">暂无数据</li>');
			}
		}
	});
	
}





















