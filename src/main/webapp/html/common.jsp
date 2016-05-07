<%@ page language="java" contentType="text/html; charset=UTF-8"import="com.hiring.bean.obj.UserObj" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<title>招聘系统</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/css/jqueryUI/jquery-ui-1.11.0.min.css" />
	<link href="<%=request.getContextPath() %>/styles/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/styles/css/main.css" rel="stylesheet" type="text/css" />
</head>
<%
	HttpSession Session = request.getSession();
	UserObj user = (UserObj)Session.getAttribute("SESSION_AUTHENTICATION");
	String userType = "请登录";
	if(user != null){
		if(user.getUserType().equalsIgnoreCase("APPLICANT")){
			userType ="管理员,"+user.getUserName() ;
		}else{
			userType ="应聘者,"+user.getUserName() ;
		}
	}
%>
<body>
	<div class="header">
		<div class="header-top">
			<h3 class="sys-title">小七的招聘管理系统</h3>
			<div class="user-info">
				<span>欢迎，<em id="userNameText"><%=userType%></em>，回来
				</span> <a href="javascript:void(0);">退出</a>
				<button type="button" class="btn btn-success" data-toggle="modal" data-target="#registerDialog"id="emptyRegisterDialog">注册</button>
				<button type="button" class="btn btn-success" data-toggle="modal" data-target="#loginDialog" id="emptyLoginDialog">登录</button>
			</div>
		</div>
		<div class="nav">
			<ul class="nav-menu">
				<li class="active"><a href="#">首页</a></li>
				<li><a href="#">我的招聘</a></li>
				<li><a href="#">招聘管理</a></li>
				<li><a href="#">公告管理</a></li>
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
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript">
		$.ctx = "<%=request.getContextPath() %>";
	</script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/jquery/jqueryUI/jquery-ui-1.11.0.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/login.js"></script>
</body>
</html>











