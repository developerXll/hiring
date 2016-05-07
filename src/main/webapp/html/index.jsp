<%@ page language="java" contentType="text/html; charset=UTF-8"import="com.hiring.bean.obj.UserObj" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<title>招聘系统</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
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
	<div class="container-fluid">
		<jsp:include page="common.jsp"></jsp:include>
		<div class="row container-fluid">
			<div class="col-md-4">
				<div class="modal-box">
					<div class="modal-header">
						<h4>我的招聘</h4>
						<a href="#">进入<em class="glyphicon glyphicon-menu-right"></em></a>
					</div>
					<ul class="list-group">
						<li class="list-group-item">Cras justo odio</li>
						<li class="list-group-item">Dapibus ac facilisis in</li>
						<li class="list-group-item">Morbi leo risus</li>
						<li class="list-group-item">Porta ac consectetur ac</li>
						<li class="list-group-item">Vestibulum at eros</li>
					</ul>
				</div>
			</div>
			<div class="col-md-4">
				<div class="modal-box">
					<div class="modal-header">
						<h4>公告管理</h4>
						<a href="#">进入<em class="glyphicon glyphicon-menu-right"></em></a>
					</div>
					<ul class="list-group">
						<li class="list-group-item">Cras justo odio</li>
						<li class="list-group-item">Dapibus ac facilisis in</li>
						<li class="list-group-item">Morbi leo risus</li>
						<li class="list-group-item">Porta ac consectetur ac</li>
						<li class="list-group-item">Vestibulum at eros</li>
					</ul>
				</div>
			</div>
			<div class="col-md-4">
				<div class="modal-box">
					<div class="modal-header">
						<h4>招聘管理</h4>
						<a href="#">进入<em class="glyphicon glyphicon-menu-right"></em></a>
					</div>
					<ul class="list-group">
						<li class="list-group-item">Cras justo odio</li>
						<li class="list-group-item">Dapibus ac facilisis in</li>
						<li class="list-group-item">Morbi leo risus</li>
						<li class="list-group-item">Porta ac consectetur ac</li>
						<li class="list-group-item">Vestibulum at eros</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row container-fluid">
			<div class="col-md-4">
				<div class="modal-box">
					<div class="modal-header">
						<h4>我的招聘</h4>
						<a href="#">进入<em class="glyphicon glyphicon-menu-right"></em></a>
					</div>
					<ul class="list-group">
						<li class="list-group-item">Cras justo odio</li>
						<li class="list-group-item">Dapibus ac facilisis in</li>
						<li class="list-group-item">Morbi leo risus</li>
						<li class="list-group-item">Porta ac consectetur ac</li>
						<li class="list-group-item">Vestibulum at eros</li>
					</ul>
				</div>
			</div>
			<div class="col-md-4">
				<div class="modal-box">
					<div class="modal-header">
						<h4>公告管理</h4>
						<a href="#">进入<em class="glyphicon glyphicon-menu-right"></em></a>
					</div>
					<ul class="list-group">
						<li class="list-group-item">Cras justo odio</li>
						<li class="list-group-item">Dapibus ac facilisis in</li>
						<li class="list-group-item">Morbi leo risus</li>
						<li class="list-group-item">Porta ac consectetur ac</li>
						<li class="list-group-item">Vestibulum at eros</li>
					</ul>
				</div>
			</div>
			<div class="col-md-4">
				<div class="modal-box">
					<div class="modal-header">
						<h4>招聘管理</h4>
						<a href="#">进入<em class="glyphicon glyphicon-menu-right"></em></a>
					</div>
					<ul class="list-group">
						<li class="list-group-item">Cras justo odio</li>
						<li class="list-group-item">Dapibus ac facilisis in</li>
						<li class="list-group-item">Morbi leo risus</li>
						<li class="list-group-item">Porta ac consectetur ac</li>
						<li class="list-group-item">Vestibulum at eros</li>
					</ul>
				</div>
			</div>
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
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/index.js"></script>
</body>
</html>











