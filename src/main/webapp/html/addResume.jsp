<%@ page language="java" contentType="text/html; charset=UTF-8"import="com.hiring.bean.obj.UserObj" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<title>招聘系统</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="common.jsp"></jsp:include>
	</div>
	<div class="container-fluid recruit-manage-add"> 
		<h3 class="ui-user-info">
			<span>个人信息</span>
			<span class="glyphicon glyphicon-pencil ui-edit-icon"></span>
		</h3>
		<ul class="container-fluid ui-userInfo-content unEdit">
			<li class="row">
				<label class="col-md-2">姓名：</label>
				<span class="col-md-5">
					<input type="text" class="form-control" id="name" disabled placeholder="姓名"/>
				</span>
				<span class="col-md-5">
					<select class="form-control" disabled id="gender">
						<option value="M" selected>男</option>
						<option value="F">女</option>
					</select>
				</span>
			</li>
<!-- 			<li class="row"> -->
<!-- 				<label class="col-md-2">出生日期：</label> -->
<!-- 				<span class="col-md-10"> -->
<!-- 					<input type="date" class="form-control" id="" pattern="/yyyy-MM-dd/" disabled/> -->
<!-- 				</span> -->
<!-- 			</li> -->
			<li class="row">
				<label class="col-md-2">手机号码：</label>
				<span class="col-md-10">
					<input type="number" class="form-control" id="phone" maxlength="11" disabled placeholder="手机号"/>
				</span>
			</li>
			<li class="row">
				<label class="col-md-2">电子邮箱：</label>
				<span class="col-md-10">
					<input type="email" class="form-control" id="email" disabled placeholder="电子邮箱"/>
				</span>
			</li>
<!-- 			<li class="row"> -->
<!-- 				<label class="col-md-2">工作年限：</label> -->
<!-- 				<span class="col-md-10"> -->
<!-- 					<select class="form-control" disabled id="jobYear"> -->
<!-- 						<option value="1" selected>1年</option> -->
<!-- 						<option value="2">2年</option> -->
<!-- 						<option value="3">3年</option> -->
<!-- 						<option value="4">4年</option> -->
<!-- 						<option value="5-7">5-7年</option> -->
<!-- 					</select> -->
<!-- 				</span> -->
<!-- 			</li> -->
			<li class="row">
				<label class="col-md-2">居住-地：</label>
				<span class="col-md-10">
					<input type="text" class="form-control" id="homeAddr" disabled placeholder="居住地"/>
				</span>
			</li>
			<li class="row">
				<label class="col-md-2">户籍-地：</label>
				<span class="col-md-10">
					<input type="text" class="form-control" id="household" disabled placeholder="户籍地"/>
				</span>
			</li>
			<li class="row">
				<label class="col-md-2">证件号码：</label>
				<span class="col-md-5">
					<input type="text" class="form-control" id="identification" maxlength="18" disabled placeholder="证件号码"/>
				</span>
				<span class="col-md-5">
					<select class="form-control" disabled id="identificationType">
						<option value="身份证" selected>身份证</option>
						<option value="护照">护照</option>
					</select>
				</span>
			</li>
		</ul>
		<h3 class="ui-user-info ui-education-info">
			<span>教育信息</span>
			<span class="glyphicon glyphicon-pencil ui-edit-icon"></span>
		</h3>
		<div id="resumeEdus">
		</div>
		<h3 class="ui-user-info ui-education-info">
			<span>工作经验</span>
			<span class="glyphicon glyphicon-pencil ui-edit-icon"></span>
		</h3>
		<div id="jobExperience"></div>
		<div id="jobExperience"></div>
		<h3 class="ui-user-info ui-education-info">
			<span>求职意向</span> 
			<span class="glyphicon glyphicon-trash ui-edit-icon"></span>
			<span class="glyphicon glyphicon-pencil ui-edit-icon"></span>
		</h3>
		<ul class="container-fluid ui-objective-content unEdit">
			<li class="row">
			<span class="col-md-2 ui-job-title">自我评价</span>
				<span class="col-md-10">
					<textarea class="form-control" disabled id="selfIntroduction">本人乐观、开朗，热爱IT行业，喜欢从事软件开发工作。思维敏捷清晰，逻辑分析能力较强，有很好的学习、分析能力，参加过实习，能够承担较强的工作压力，做事有始终，敢于挑战！具备团队开发经验，规范的代码编写习惯。工作主动积极、团队协作、责任感强，具备良好团队合作精神！
					</textarea>
				</span> 
			</li>
			<li class="row">
				<label class="col-md-2 ui-job-title">期望职位：</label>
				<span class="col-md-10">
					<input type="text" class="form-control" id="jobIntension" disabled placeholder="期望职位"/>
				</span>
			</li>
			<li class="row">
				<span class="col-md-2 ui-job-title">期望薪资</span>
				<span class="col-md-10">
					<select class="form-control" disabled id="salaryExpectation">
						<option value="3000-5000">3000-5000</option>
						<option value="5000-8000">5000-8000</option>
						<option value="8000-10000">8000-10000</option>
						<option value="10000-15000">10000-15000</option> 
						<option value="15000-20000">15000-20000</option> 
						<option value="20000-25000">20000-25000</option> 
						<option value="25000以上">25000以上</option> 
					</select>
				</span> 
			</li>
		</ul>
		<h3 class="ui-user-info ui-education-info">
			<span>项目经验</span> 
			<span class="glyphicon glyphicon-trash ui-edit-icon"></span>
			<span class="glyphicon glyphicon-pencil ui-edit-icon"></span>
		</h3>
		<div id="resumePros"></div>
		
	</div>
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/addOrUpdate.js"></script>
</body>
</html>











