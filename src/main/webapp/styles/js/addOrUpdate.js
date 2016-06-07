$(function(){
	getAnnounce();
	getRecruit();
	getResume();
	loadThemeFloorList(1);
	$("#showbbsNext").on("click",function(){
		var currentPage = parseInt($("#currentPage").html()) + 1;
		loadThemeFloorList(currentPage);
	});
	$("#showbbsPrcv").on("click",function(){
		var currentPage = parseInt($("#currentPage").html()) -1;
		loadThemeFloorList(currentPage);
	});
	$("#noticeName").focus(function(){
		$("#noticeName").attr("placeholder","输入公告名称").parent().parent().removeClass("has-error");
		$(".ui-error").remove();
	});
	$("#noticeContent").focus(function(){
		$("#noticeContent").attr("placeholder","输入公告内容").parent().parent().removeClass("has-error");
		$(".ui-error").remove();
	});
	$(".ui-edit-icon").on("click",function(){
		$(this).parent().next().removeClass("unEdit");
		$(this).parent().next().find(".unEdit").removeClass("unEdit");
		$(this).parent().next().find("input,select,textarea").removeAttr("disabled");
	});
	$(".ui-userInfo-content input,.ui-objective-content input").focus(function(){
		$(this).attr("placeholder","请输入").parent().parent().removeClass("has-error");
	});
	$(document).on("click",".J_del_resumeEdus",function(){
		if(!confirm("确定删除？")){
			return;
		}
		$(this).parent().parent().remove();
	});
	$(document).on("click",".J_del_resumeOccs,.J_del_resumePros",function(){
		if(!confirm("确定删除？")){
			return;
		}
		$(this).parent().parent().parent().remove();
	});
	$("#resumeEdusBtn").click(function(){
		var html = '<ul  class="container-fluid ui-education-content"><li class="row">'+
		'<span class="col-md-6">'+
		'<input type="month" class="form-control ui-date-stylle eduStartTime" placeholder="入学时间">'+
		'<input type="month" class="form-control ui-date-stylle eduEndTime" placeholder="毕业时间">'+
		'</span>'+
		'<span class="col-md-2">'+
			'<input type="text" class="form-control graduate" placeholder="毕业学校">'+
		'</span>'+
		'<span class="col-md-2">'+
		'<select class="form-control educationName">'+
			'<option value="本科" selected>本科</option>'+
			'<option value="专科">专科</option>'+
			'<option value="本科同等学力">本科同等学力</option>'+
			'<option value="专科同等学力">专科同等学力</option>'+
		'</select>'+
		'</span><span class="col-md-2"><span class="glyphicon glyphicon-minus J_del_resumeEdus"></span></span></li></ul>';
		$("#resumeEdus").append(html);
	});
	$("#jobExperienceBtn").click(function(){
		var resumeOccsHtml = '<ul class="container-fluid ui-experience-content">'+
			'<li class="row">'+
				'<span class="col-md-3"> '+
					'<input type="month" name="jobstratTime" class="form-control jobstratTime" placeholder="开始时间"/>'+
				'</span> '+
				'<span class="col-md-1 ui-experience-line">&nbsp;-&nbsp; </span>'+
				'<span class="col-md-3"> '+
					'<input type="month" name="jobendTime" class="form-control jobendTime" placeholder="结束时间"/>'+
				'</span> '+
				'<span class="col-md-5"> '+
					'<input type="text" name="companyName" class="form-control companyName"placeholder="公司名称"/>'+
				'</span> '+
			'</li> '+
			'<li class="row">'+
				'<span class="col-md-2 ui-job-title">职位名称</span>'+
				'<span class="col-md-10">'+
					'<input type="text" name="jobName" class="form-control possion"placeholder="职位名称"/>'+
				'</span></span>'+
			'</li>'+
			'<li class="row">'+
				'<span class="col-md-2 ui-job-title">所在行业</span>'+
				'<span class="col-md-10">'+
					'<select class="form-control companyType">'+
						'<option value="互联网">互联网</option>'+
						'<option value="计算机软件">计算机软件</option>'+
						'<option value="电子商务">电子商务</option>'+
						'<option value="医药/医院">医药/医院</option>'+
						'<option value="房地产/建筑">房地产/建筑</option>'+
						'<option value="服务业">服务业</option>'+
						'<option value="政府/教育">政府/教育</option>'+
						'<option value="广告/媒体">广告/媒体</option>'+
						'<option value="金融/银行">金融/银行</option>'+
					'</select>'+
				'</span>'+
			'</li>'+
			'<li class="row">'+
				'<span class="col-md-2 ui-job-title">工作描述</span>'+
				'<span class="col-md-9">'+
					'<textarea class="form-control jobDesc" row="4" placeholder="工作描述"></textarea>'+
				'</span><span class="col-md-1"><span class="glyphicon glyphicon-minus J_del_resumeOccs"></span>'+
			'</li>'+
		'</ul>';
		$("#jobExperience").append(resumeOccsHtml);
	});
	$("#resumeProsBtn").click(function(){
		var resumeProsHtml ='<ul class="container-fluid ui-objective-content">'+
			'<li class="row">'+
				'<span class="col-md-2 ui-job-title">项目时间</span>'+
				'<span class="col-md-3">' +
					'<input type="month" name="stratCompanyTime" class="form-control stratCompanyTime" placeholder="开始时间">'+
				'</span>'+
				'<span class="col-md-1"> - </span>'+
				'<span class="col-md-3">' +
					'<input type="month" name="endCompanyTime" class="form-control endCompanyTime" placeholder="结束时间">'+
				'</span>'+
			'</li>' +
			'<li class="row">'+
				'<span class="col-md-2 ui-job-title">项目名称</span>'+
				'<span class="col-md-10">'+
					'<input type="text" name="name" class="form-control projectName" placeholder="项目名称"/>'+
				'</span>' +
			'</li>'+
			'<li class="row">'+
				'<span class="col-md-2 ui-job-title">项目职位</span>'+
				'<span class="col-md-10">'+
					'<input type="text" name="name" class="form-control resumeProsName" placeholder="项目职位"/>'+
				'</span>'+
			'</li>'+
			'<li class="row">'+
			'<span class="col-md-2 ui-job-title">项目描述</span>'+
				'<span class="col-md-9">'+
					'<textarea class="form-control projectIntroduction" placeholder="项目描述">'+
					'</textarea>'+
				'</span><span class="col-md-1"><span class="glyphicon glyphicon-minus J_del_resumePros"></span>' +
			'</li>' +
		'</ul>';
		$("#resumePros").append(resumeProsHtml);
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

//我的招聘
function getResume(){
	var theRequest = window.location.search;
	if(!theRequest || window.location.hash.indexOf("resume") == -1){
		return;
	}
	var id = theRequest.split("#")[0].replace("?","");
	$.ajax({
		url:$.ctx+"/res/get/"+id,
		data:{},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.status == 200){
				var data = result.data;
				$("#name").val(data.name).attr("resId",data.id);
				$("#gender").val(data.gender);
				$("#age").val(data.age);
				$("#phone").val(data.tel);
				$("#email").val(data.email);
				$("#homeAddr").val(data.domicile);
				$("#household").val(data.residence);
				$("#identification").val(data.identification);
				$("#identificationType").val(data.identificationType);
				$("#selfIntroduction").val(data.selfIntroduction);
				$("#jobIntension").val(data.jobIntension);
				$("#salaryExpectation").val(data.expectSalary);
				var resumeEdus = data.resumeEdus;
				$("#resumeEdus,#jobExperience,#resumePros").empty();
				for(var i = 0 ,len = resumeEdus.length;i<len ;i++){
					if(!resumeEdus[i]){
						continue;
					}
					var resumeEdusHtml = '<ul  class="container-fluid ui-education-content unEdit"><li class="row">'+
					'<span class="col-md-6">'+
						'<input type="month" class="form-control ui-date-stylle eduStartTime" value="'+new Date(resumeEdus[i].startTime).pattern("yyyy-MM")+'" disabled placeholder="入学时间">'+
						'<input type="month" class="form-control ui-date-stylle eduEndTime" value="'+new Date(resumeEdus[i].endTime).pattern("yyyy-MM")+'" disabled placeholder="毕业时间">'+
					'</span>'+
					'<span class="col-md-2">'+
						'<input type="text" class="form-control graduate"  disabled="" value="'+resumeEdus[i].schoolName+'" placeholder="毕业学校">'+
					'</span>'+
					'<span class="col-md-2">'+
					'<select class="form-control educationName" disabled resumeEdusId="'+resumeEdus[i].id+'">'+
						'<option value="本科">本科</option>'+
						'<option value="专科">专科</option>'+
						'<option value="本科同等学力">本科同等学力</option>'+
						'<option value="专科同等学力">专科同等学力</option>'+
					'</select>'+
					'</span><span class="col-md-2"><span class="glyphicon glyphicon-minus J_del_resumeEdus" resumeEdusId="'+resumeEdus[i].id+'"></span></span></li></ul>';
					$("#resumeEdus").append(resumeEdusHtml);
					$('.educationName[resumeEdusId="'+resumeEdus[i].id+'"]').val(resumeEdus[i].education);
				}
				var resumeOccs = data.resumeOccs;
				for(var i = 0 ,len = resumeOccs.length;i<len ;i++){
					if(!resumeOccs[i]){
						continue;
					}
					var resumeOccsHtml = '<ul class="container-fluid ui-experience-content unEdit">'+
						'<li class="row">'+
							'<span class="col-md-3"> '+
								'<input type="month" name="jobstratTime" class="form-control jobstratTime" disabled value="'+new Date(resumeOccs[i].startTime).pattern("yyyy-MM")+'"/>'+
							'</span> '+
							'<span class="col-md-1 ui-experience-line">&nbsp;-&nbsp; </span>'+
							'<span class="col-md-3"> '+
								'<input type="month" name="jobendTime" class="form-control jobendTime" disabled value="'+new Date(resumeOccs[i].endTime).pattern("yyyy-MM")+'"/>'+
							'</span> '+
							'<span class="col-md-5"> '+
								'<input type="text" name="companyName" class="form-control companyName" disabled value="'+resumeOccs[i].companyName+'"/>'+
							'</span> '+
						'</li> '+
						'<li class="row">'+
							'<span class="col-md-2 ui-job-title">职位名称</span>'+
							'<span class="col-md-10">'+
								'<input type="text" name="jobName" class="form-control possion" disabled value="'+resumeOccs[i].possion+' "/>'+
							'</span>'+
						'</li>'+
						'<li class="row">'+
							'<span class="col-md-2 ui-job-title">所在行业</span>'+
							'<span class="col-md-10">'+
								'<select class="form-control companyType" disabled resumeOccsId ="'+resumeOccs[i].id+'" >'+
									'<option value="互联网">互联网</option>'+
									'<option value="计算机软件">计算机软件</option>'+
									'<option value="电子商务">电子商务</option>'+
									'<option value="医药/医院">医药/医院</option>'+
									'<option value="房地产/建筑">房地产/建筑</option>'+
									'<option value="服务业">服务业</option>'+
									'<option value="政府/教育">政府/教育</option>'+
									'<option value="广告/媒体">广告/媒体</option>'+
									'<option value="金融/银行">金融/银行</option>'+
								'</select>'+
							'</span>'+
						'</li>'+
						'<li class="row">'+
							'<span class="col-md-2 ui-job-title">工作描述</span>'+
							'<span class="col-md-9">'+
								'<textarea class="form-control jobDesc" disabled row="4">'+resumeOccs[i].workIntroduction+'</textarea>'+
							'</span><span class="col-md-1"><span class="glyphicon glyphicon-minus J_del_resumeOccs"></span></span>'+
						'</li>'+
					'</ul>';
					$("#jobExperience").append(resumeOccsHtml);
					$('.companyType[resumeOccsId ="'+resumeOccs[i].id+'"]').val(resumeOccs[i].companyType);
				}
				var resumePros = data.resumePros;
				for(var i = 0 ,len = resumePros.length;i<len ;i++){
					if(!resumePros[i]){
						continue;
					}
					var resumeProsHtml ='<ul class="container-fluid ui-objective-content unEdit">'+
						'<li class="row">'+
							'<span class="col-md-2 ui-job-title">项目时间</span>'+
							'<span class="col-md-3">' +
								'<input type="month" name="stratCompanyTime" class="form-control stratCompanyTime" disabled value="'+new Date(resumePros[i].startTime).pattern("yyyy-MM")+'">'+
							'</span>'+
							'<span class="col-md-1"> - </span>'+
							'<span class="col-md-3">' +
								'<input type="month" name="endCompanyTime" class="form-control endCompanyTime" disabled value="'+new Date(resumePros[i].endTime).pattern("yyyy-MM")+'">'+
							'</span>'+
						'</li>' +
						'<li class="row">'+
							'<span class="col-md-2 ui-job-title">项目名称</span>'+
							'<span class="col-md-10">'+
								'<input type="text" name="name" class="form-control projectName" resumeProsId="'+resumePros[i].id+'"  disabled value="'+resumePros[i].projectName+'"/>'+
							'</span>' +
						'</li>'+
						'<li class="row">'+
							'<span class="col-md-2 ui-job-title">项目职位</span>'+
							'<span class="col-md-10">'+
								'<input type="text" name="name" class="form-control resumeProsName" disabled value="'+resumePros[i].possion+'"/>'+
							'</span>'+
						'</li>'+
						'<li class="row">'+
						'<span class="col-md-2 ui-job-title">项目描述</span>'+
							'<span class="col-md-9">'+
								'<textarea class="form-control projectIntroduction" disabled>'+ resumePros[i].projectIntroduction +
								'</textarea>'+
							'</span><span class="col-md-1"><span class="glyphicon glyphicon-minus J_del_resumePros"></span></span>' +
						'</li>' +
					'</ul>';
					$("#resumePros").append(resumeProsHtml);
				}
				loadRecList();
			}else{
				alert("获取失败！");
			}
		}
	});
}
 function saveOrUpdateResume(){
	var id = $("#name").attr("resId");
	var name = $("#name").val();
	if($.trim(name).length==0){
		$("#name").attr("placeholder","请输入名称").parent().parent().addClass("has-error");
		return;
	}else{
		$("#name").attr("placeholder","姓名").parent().parent().removeClass("has-error");
	}
	var age = $("#age").val();
	if($.trim(age).length==0){
		$("#age").attr("placeholder","请输入年龄").parent().parent().addClass("has-error");
		return;
	}else{
		$("#name").attr("placeholder","年龄").parent().parent().removeClass("has-error");
	}
	var gender = $("#gender").val();
	var tel = $("#phone").val();
	if($.trim(tel).length==0){
		$("#phone").attr("placeholder","请输入电话").parent().parent().addClass("has-error");
		return;
	}else{
		$("#phone").attr("placeholder","电话").parent().parent().removeClass("has-error");
	}
	var email = $("#email").val();
	if($.trim(email).length==0){
		$("#email").attr("placeholder","请输入邮箱").parent().parent().addClass("has-error");
		return;
	}else{
		$("#email").attr("placeholder","邮箱").parent().parent().removeClass("has-error");
	}
	var domicile = $("#homeAddr").val();
	if($.trim(domicile).length==0){
		$("#homeAddr").attr("placeholder","请输入住址").parent().parent().addClass("has-error");
		return;
	}else{
		$("#homeAddr").attr("placeholder","住址").parent().parent().removeClass("has-error");
	}
	var residence = $("#household").val();
	if($.trim(residence).length==0){
		$("#household").attr("placeholder","请输入户籍").parent().parent().addClass("has-error");
		return;
	}else{
		$("#household").attr("placeholder","户籍").parent().parent().removeClass("has-error");
	}
	var identification = $("#identification").val();
	if($.trim(identification).length==0){
		$("#identification").attr("placeholder","请输入证件号码").parent().parent().addClass("has-error");
		return;
	}else{
		$("#identification").attr("placeholder","证件号码").parent().parent().removeClass("has-error");
	}
	var identificationType = $("#identificationType").val();
	var selfIntroduction = $("#selfIntroduction").val();
	var jobIntension = $("#jobIntension").val();
	if($.trim(jobIntension).length==0){
		$("#jobIntension").attr("placeholder","请输入工作意向").parent().parent().addClass("has-error");
		return;
	}else{
		$("#jobIntension").attr("placeholder","工作意向").parent().parent().removeClass("has-error");
	}
	var expectSalary = $("#salaryExpectation").val();
	var eduList = $("#resumeEdus ul.ui-education-content");
	var resumeEdus = "[";
	for(var i = 0,len=eduList.length;i<len;i++){
		var eduStartTime = $(eduList[i]).find(".eduStartTime").val();
		var eduEndTime =  $(eduList[i]).find(".eduEndTime").val();
		var graduate =  $(eduList[i]).find(".graduate").val();
		var educationName =  $(eduList[i]).find(".educationName").val();
		var resumeEdusId =  $(eduList[i]).find(".educationName").attr("resumeEdusId");
		var data = "{'id':"+resumeEdusId+",'startTime':'"+eduStartTime+"','endTime':'"+eduEndTime+"','schoolName':'"+graduate+"','education':'"+educationName+"'},";
		resumeEdus +=data;
//		resumeEdus.push({
//			"startTime":eduStartTime,
//			"endTime":eduEndTime,
//			"schoolName":graduate,
//			"education":educationName
//		});
	}
	resumeEdus += "]";
	var occsList = $("#jobExperience ul.ui-experience-content");
	var resumeOccs ="[";
	for(var i = 0,len=occsList.length;i<len;i++){
		var companyName = $(occsList[i]).find(".companyName").val();
		var endTime = $(occsList[i]).find(".jobendTime").val();
		var stratTime = $(occsList[i]).find(".jobstratTime").val();
		var possion = $(occsList[i]).find(".possion").val();
		var companyType = $(occsList[i]).find(".companyType").val();
		var resumeOccsId = $(occsList[i]).find(".companyType").attr("resumeOccsId");
		var workIntroduction = $(occsList[i]).find(".jobDesc").val();
//		resumeOccs.push({
//			"companyName":companyName,
//			"endTime":endTime,
//			"stratTime":stratTime,
//			"possion":possion,
//			"companyType":companyType,
//			"workIntroduction":workIntroduction
//		});
		var data = "{'id':"+resumeOccsId+",'companyName':'"+companyName+"','endTime':'"+endTime+"','startTime':'"+stratTime+"','possion':'"+possion+"','companyType':'"+companyType+"','workIntroduction':'"+workIntroduction+"'},";
		resumeOccs +=data;
	}
	resumeOccs += "]";
	var prosList = $("#resumePros ul.ui-objective-content");
	var resumePros ="[";
	for(var i = 0,len=prosList.length;i<len;i++){
		var stratTime = $(prosList[i]).find(".stratCompanyTime").val();
		var endTime = $(prosList[i]).find(".endCompanyTime").val();
		var projectName = $(prosList[i]).find(".projectName").val();
		var resumeProsId = $(prosList[i]).find(".projectName").attr("resumeProsId");
		var possion = $(prosList[i]).find(".resumeProsName").val();
		var projectIntroduction = $(prosList[i]).find(".projectIntroduction").val();
//		var obj = {
//				"endTime":endTime,
//				"stratTime":stratTime,
//				"possion":possion,
//				"projectIntroduction":projectIntroduction,
//				"projectName":projectName
//			};
//		resumePros.push(obj);
		var data = "{'id':"+resumeProsId+",'endTime':'"+endTime+"','startTime':'"+stratTime+"','possion':'"+possion+"','projectIntroduction':'"+projectIntroduction+"','projectName':'"+projectName+"'},";
		resumePros+=data;
	}
	resumePros += "]";
	var url = $.ctx+"/res/add";
	if(id){
		url = $.ctx+"/res/update";
	}
	$.ajax({
		url:url,
		data:{
			'age':age,
			'domicile':domicile,
			'education':"",
			'email':email,
			'expectSalary':expectSalary,
			'gender':gender,
			'graduateSchool':"",
			'id':id,
			'identification':identification,
			'identificationType':identificationType,
			'jobIntension':jobIntension,
			'name':name,
			'residence':residence,
			'resumeEdus':resumeEdus,
			'resumeOccs':resumeOccs,
			'resumePros':resumePros,
			'selfIntroduction':selfIntroduction,
			'tel':tel
		},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.status == 200){
				window.location.href = "/html/resumeList.jsp#resume";
			}else{
				alert("提交失败！");
			}
		}
	});
	 
 }
//add论坛
 function addOrUpdateBBS(){
 	var bbsName = $("#bbsName").val();
 	if($.trim(bbsName).length==0){
 		$("#bbsName").attr("placeholder","请输入主题").parent().parent().addClass("has-error");
 		return;
 	}else{
 		$("#bbsName").attr("placeholder","请输入").parent().parent().removeClass("has-error");
 	}
 	var bbsContent = $("#bbsContent").val();
 	if($.trim(bbsContent).length==0){
 		$("#bbsContent").attr("placeholder","请输入内容").parent().parent().addClass("has-error");
 		return;
 	}else{
 		$("#bbsContent").attr("placeholder","请输入").parent().parent().removeClass("has-error");
 	}
 	$.ajax({
 		url:$.ctx + "/theme/addTheme",
 		data:{
 			  title:bbsName,
 			  info:bbsContent
 		},
 		dataType:"json",
 		type:"post",
 		success:function(result){
 			if(result.status == 200){
 				alert("提交成功！");
 				window.location.href = $.ctx + "/html/BBSList.jsp#bbs";
 			}else{
 				alert("提交失败！");
 			}
 		}
 	});
 	return false;
 }
//发表评论
function addThemeFloor(){
	 var bbsContent = $("#bbsContent").val();
	 if($.trim(bbsContent).length==0){
		 $("#bbsContent").attr("placeholder","请输入内容").parent().parent().addClass("has-error");
		 return;
	 }else{
		 $("#bbsContent").attr("placeholder","请输入").parent().parent().removeClass("has-error");
	 }
	 var id = $("#showBBSName").attr("bbsId");
	 $.ajax({
		 url:$.ctx + "/theme/addThemeFloor",
		 data:{
			 themeId:id,
			 info:bbsContent
		 },
		 dataType:"json",
		 type:"post",
		 success:function(result){
			 if(result.status == 200){
				 loadThemeFloorList($("#currentPage").html());
				 $("#bbsContent").val("");
			 }else{
				 alert("提交失败！");
			 }
		 }
	 });
	 return false;
 }
//load评论list
function loadThemeFloorList(pageNo){
	var theRequest = window.location.search;
	if(!theRequest || window.location.hash.indexOf("bbs") == -1){
		return;
	}
	var id = theRequest.split("#")[0].replace("?","");
	$.ajax({
		url:$.ctx + "/theme/getTheme/"+id,
		data:{pageNo:pageNo},
		dataType:"json",
		type:"post",
		success:function(result){
			var bbsHtml = "";
			var floors = result.obj.floors;
			var bbs = result.obj;
			$("#showBBSName").html(bbs.title).attr("bbsId",bbs.id)
			for(var i=0,len = floors.length;i<len;i++){
				bbsHtml += '<li class="row ui-bbs-li" id="'+floors[i].id+'">'+
			  		'<label for="bbsContent" class="col-sm-2 control-label">'+floors[i].userObj.userName+'</label>'+
			  		'<div class="col-sm-7 ui-bbs-content">'+floors[i].info+
			  		'</div>'+
					'<div class="col-sm-2 ui-bbs-content">'+floors[i].insertDate+
					'</div>';
					if($("#userNameText").attr("userType") == "APPLICANT"){
						bbsHtml +='<div class="col-sm-1 ui-bbs-content"><button type="button" class="btn btn-defaul" onclick="delShowBBS('+floors[i].id+')">删除</button></div>';
					} 
					bbsHtml +='</li>';
			}
			$("#showBBSContet").html(bbsHtml);
			var pager = result.page;
			$("#currentPage").html(pager.pageNo);
			$("#totalPage").html(pager.totalPageNumber);
			if(pager.pageNo == 1){
				$("#showbbsPrcv").parent().addClass("disabled");
				$("#showbbsPrcv").off("click");
			}else{
				$("#showbbsPrcv").parent().removeClass("disabled");
				$("#showbbsPrcv").on("click",function(){
					var currentPage = parseInt($("#currentPage").html()) -1;
					loadThemeFloorList(currentPage);
				});
			}
			if(pager.pageNo == pager.totalPageNumber){
				$("#showbbsNext").parent().addClass("disabled");
				$("#showbbsNext").off("click");
			}else if(pager.pageNo != pager.totalPageNumber){
				$("#showbbsNext").parent().removeClass("disabled");
				$("#showbbsNext").on("click",function(){
					var currentPage = parseInt($("#currentPage").html()) + 1;
					loadThemeFloorList(currentPage);
				});
			}
			$(".ui-page-num").show();
		
		}
	});
	return false;
}
//发表评论
function delShowBBS(id){
	if(!confirm("确定删除？")){
		return;
	}
	 $.ajax({
		 url:$.ctx + "/theme/delThemeFloor/"+id,
		 data:{},
		 dataType:"json",
		 type:"post",
		 success:function(result){
			 if(result.status == 200){
				 loadThemeFloorList($("#currentPage").html());
				 $("#bbsContent").val("");
			 }else{
				 alert("提交失败！");
			 }
		 }
	 });
	 return false;
 }
//获取职位名称
function loadRecList(){
	$.ajax({
		url:$.ctx+"/rec/list",
		data:{pageNo:1},
		dataType:"json",
		type:"post",
		success:function(result){
			var data = result.list;
			var trHTml = "";
			if(data && data.length>0){
				for(var i=0,len=data.length;i<len;i++){
					trHTml += '<option id="'+data[i].id+'">'+data[i].possion+'</option>';
				}
				$("#jobIntension").html(trHTml);
			}
		}
	});
}

/**       
 * 对Date的扩展，将 Date 转化为指定格式的String       
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符       
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)       
 * eg:       
 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423       
 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04       
 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04       
 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04       
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18       
 */          
Date.prototype.pattern=function(fmt) {           
    var o = {           
    "M+" : this.getMonth()+1, //月份           
    "d+" : this.getDate(), //日           
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时           
    "H+" : this.getHours(), //小时           
    "m+" : this.getMinutes(), //分           
    "s+" : this.getSeconds(), //秒           
    "q+" : Math.floor((this.getMonth()+3)/3), //季度           
    "S" : this.getMilliseconds() //毫秒           
    };           
    var week = {           
    "0" : "/u65e5",           
    "1" : "/u4e00",           
    "2" : "/u4e8c",           
    "3" : "/u4e09",           
    "4" : "/u56db",           
    "5" : "/u4e94",           
    "6" : "/u516d"          
    };           
    if(/(y+)/.test(fmt)){           
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));           
    }           
    if(/(E+)/.test(fmt)){           
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);           
    }           
    for(var k in o){           
        if(new RegExp("("+ k +")").test(fmt)){           
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));           
        }           
    }           
    return fmt;           
}         



















































