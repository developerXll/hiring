$(function(){
	getAnnounce();
	getRecruit();
	getResume();
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
				$("#name").val(data.name);
				$("#gender").val(data.gender);
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
					var resumeEdusHtml = '<ul  class="container-fluid ui-education-content unEdit"><li class="row">'+
					'<span class="col-md-6">'+
						'<input type="month" class="form-control ui-date-stylle" id="startTime" value="'+new Date(resumeEdus[i].startTime).pattern("yyyy-MM")+'" disabled placeholder="入学时间">'+
						'<input type="month" class="form-control ui-date-stylle" id="endTime" value="'+new Date(resumeEdus[i].endTime).pattern("yyyy-MM")+'" disabled placeholder="毕业时间">'+
					'</span>'+
					'<span class="col-md-2">'+
						'<input type="text" class="form-control" id="graduate" disabled="" value="'+resumeEdus[i].schoolName+'" placeholder="毕业学校">'+
					'</span>'+
					'<span class="col-md-2">'+
					'<select class="form-control educationName" disabled=""   resumeEdusId="'+resumeEdus[i].id+'">'+
						'<option value="本科">本科</option>'+
						'<option value="专科">专科</option>'+
						'<option value="本科同等学力">本科同等学力</option>'+
						'<option value="专科同等学力">专科同等学力</option>'+
					'</select>'+
					'</span><span class="col-md-2"><span class="glyphicon glyphicon-plus"></span><span class="glyphicon glyphicon-minus" resumeEdusId="'+resumeEdus[i].id+'"></span></span></li></ul>';
					$("#resumeEdus").append(resumeEdusHtml);
					$('.educationName[resumeEdusId="'+resumeEdus[i].id+'"]').val(resumeEdus[i].education);
					var resumeOccs = data.resumeOccs;
					for(var i = 0 ,len = resumeOccs.length;i<len ;i++){
						var resumeOccsHtml = '<ul class="container-fluid ui-experience-content unEdit">'+
							'<li class="row">'+
								'<span class="col-md-3"> '+
									'<input type="month" name="jobstratTime" class="form-control" disabled value="'+new Date(resumeOccs[i].startTime).pattern("yyyy-MM")+'"/>'+
								'</span> '+
								'<span class="col-md-1 ui-experience-line">&nbsp;-&nbsp; </span>'+
								'<span class="col-md-3"> '+
									'<input type="month" name="jobendTime" class="form-control" disabled value="'+new Date(resumeOccs[i].endTime).pattern("yyyy-MM")+'"/>'+
								'</span> '+
								'<span class="col-md-5"> '+
									'<input type="text" name="companyName" class="form-control" disabled value="'+resumeOccs[i].companyName+'"/>'+
								'</span> '+
							'</li> '+
							'<li class="row">'+
								'<span class="col-md-2 ui-job-title">职位名称</span>'+
								'<span class="col-md-10">'+
									'<input type="text" name="jobName" class="form-control" disabled value="'+resumeOccs[i].possion+' "/>'+
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
								'<span class="col-md-10">'+
									'<textarea class="form-control" disabled row="4" id="jobDesc">'+resumeOccs[i].workIntroduction+'</textarea>'+
								'</span>'+
							'</li>'+
							'<li class="row"> '+
								'<span class="col-md-12">'+
									'<button type="button" class="btn btn-success">继续添加</button>'+
								'</span>'+
							'</li>'+
						'</ul>';
						$("#jobExperience").append(resumeOccsHtml);
						$('.companyType[resumeOccsId ="'+resumeOccs[i].id+'"]').val(resumeOccs[i].companyType);
						var resumePros = data.resumePros;
						for(var i = 0 ,len = resumePros.length;i<len ;i++){
							var resumeProsHtml ='<ul class="container-fluid ui-objective-content unEdit">'+
								'<li class="row">'+
									'<span class="col-md-2 ui-job-title">项目时间</span>'+
									'<span class="col-md-3">' +
										'<input type="month" name="stratCompanyTime" class="form-control" disabled value="'+new Date(resumePros[i].startTime).pattern("yyyy-MM")+'">'+
									'</span>'+
									'<span class="col-md-1"> - </span>'+
									'<span class="col-md-3">' +
										'<input type="month" name="endCompanyTime" class="form-control" disabled value="'+new Date(resumePros[i].endTime).pattern("yyyy-MM")+'">'+
									'</span>'+
								'</li>' +
								'<li class="row">'+
									'<span class="col-md-2 ui-job-title">项目名称</span>'+
									'<span class="col-md-10">'+
										'<input type="text" name="name" class="form-control" disabled value="'+resumePros[i].projectName+'"/>'+
									'</span>' +
								'</li>'+
								'<li class="row">'+
									'<span class="col-md-2 ui-job-title">项目职位</span>'+
									'<span class="col-md-10">'+
										'<input type="text" name="name" class="form-control" disabled value="'+resumePros[i].possion+'"/>'+
									'</span>'+
								'</li>'+
								'<li class="row">'+
								'<span class="col-md-2 ui-job-title">项目描述</span>'+
									'<span class="col-md-10">'+
										'<textarea class="form-control" disabled>'+ resumePros[i].projectIntroduction +
										'</textarea>'+
									'</span>' +
								'</li>' +
								'<li class="row">'+
									'<button type="button" class="btn btn-primary ui-btn">提交</button>'+
								'</li>' +
							'</ul>';
							$("#resumePros").append(resumeProsHtml);
						}
					}
				}
				
			}else{
				alert("获取失败！");
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



















































