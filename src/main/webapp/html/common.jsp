<%@ page language="java" contentType="text/html; charset=UTF-8"import="com.hiring.bean.obj.UserObj" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<title>招聘系统</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/css/jqueryUI/jquery-ui-1.11.0.min.css" />
	<link href="<%=request.getContextPath() %>/styles/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/styles/css/main.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript">
		$.ctx = "<%=request.getContextPath() %>";
	</script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/jquery/jqueryUI/jquery-ui-1.11.0.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/login.js"></script>
</head>
<%
	HttpSession Session = request.getSession();
	UserObj user = (UserObj)Session.getAttribute("SESSION_AUTHENTICATION");
	String userType = "请登录";
	String adminType = "";
	if(user != null){
		adminType = user.getUserType();
		if(user.getUserType().equalsIgnoreCase("APPLICANT")){
			userType ="管理员,"+user.getUserName();
%>
		<script type="text/javascript">
			$(function(){
// 				$("#myResBox,#resume").hide(); 
				$(".form-horizontal button").show();
				$("#announ a,#announIndex").html("公告管理");
				$("#myResBox h4,#resume a").html("简历管理");
				$("#recruit a,#recruitIndex").html("招聘管理");
				$(".form-horizontal .form-group input,.form-horizontal .form-group textarea,.form-horizontal .form-group select").removeAttr("disabled");
				$("#recSearchBtn,#announceSearchBtn,#bbsListSearchBtn").next().show();
				$("#resSearchList").next().hide();
			});
		</script>	
		<%}else{
			userType ="应聘者,"+user.getUserName() ;
		%>
		<script type="text/javascript">
			$(function(){
// 				$("#myResBox,#resume").show(); 
				$("#myResBox h4,#resume a").html("我的招聘");
				$(".form-horizontal button").hide();
				$("#recSearchBtn,#announceSearchBtn,#bbsListSearchBtn").next().hide();
				$("#resSearchList").next().show();
				$("#announ a,#announIndex").html("查看公告");
				$("#recruit a,#recruitIndex").html("查看招聘");
				$(".form-horizontal .form-group input,.form-horizontal .form-group textarea,.form-horizontal .form-group select").attr("disabled",true);
				$(".J_BBS .form-group textarea").removeAttr("disabled");
				$(".J_BBS .form-horizontal button").show();
			});
		</script>	
		<%}%>
<%}else{%>
	<script type="text/javascript">
		$(function(){
			$("#emptyLoginDialog").click(); 
		});
	</script>	
<%}%>
<body>
	<div class="header">
		<div class="header-top">
			<h3 class="sys-title">科信公司招聘管理系统</h3>
			<div class="user-info">
				<span>欢迎，<em id="userNameText" userType="<%=adminType%>"><%=userType%></em>，回来</span> 
				<%if(user == null){ %>
					<button type="button" class="btn btn-success" data-toggle="modal" data-target="#registerDialog"id="emptyRegisterDialog">注册</button>
					<button type="button" class="btn btn-success" data-toggle="modal" data-target="#loginDialog" id="emptyLoginDialog">登录</button>
				<%}else{%>
					<a href="javascript:logout() ;">退出</a>
				<%}%>
			</div>
		</div>
		<div class="nav">
			<ul class="nav-menu">
				<li class="active" id="index"><a href="/passport/index#index">首页</a></li>
				<li id="resume"><a href="/html/resumeList.jsp#resume">我的招聘</a></li>
				<li id="recruit"><a href="/html/recruitList.jsp#recruit">招聘管理</a></li>
				<li id="announ"><a href="/html/announ.jsp#announ">公告管理</a></li>
				<li id="bbs"><a href="/html/BBSList.jsp#bbs">论坛管理</a></li>
			</ul>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="loginDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">登录</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="loginForm">
						<div class="form-group">
							<label for="loginPassword" class="col-sm-2 control-label">登录账号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="loginName" placeholder="邮箱或手机号"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="loginPassword" placeholder="密码"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label> <input type="checkbox">记住我
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="button" class="btn btn-default" id="loginBtn" onclick="login();">登录</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="registerDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel1">注册</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" method="post" id="registerForm">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">登录账号</label>
							<div class="col-sm-10">
								<input type="email" name="userName" class="form-control" id="registerName" placeholder="邮箱或手机号">
							</div>
						</div>
						<div class="form-group">
							<label for="registerPassword" class="col-sm-2 control-label">登录密码</label>
							<div class="col-sm-10">
								<input type="password" name="passWord" class="form-control" id="registerPassword" placeholder="密码">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="registerPasswordAgain" placeholder="再次输入密码">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="button" class="btn btn-default" onclick="resigter();">注册</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>











