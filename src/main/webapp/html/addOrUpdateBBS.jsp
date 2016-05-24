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
		<div class="container-fluid recruit-manage-add">
			<form class="form-horizontal">
			  <div class="form-group">
				<label for="bbsName" class="col-sm-2 control-label">主题</label>
				<div class="col-sm-10">
				  <input type="email" class="form-control" id="bbsName" placeholder="请输入">
				</div>
			  </div>
			  <div class="form-group">
				<label for="bbsContent" class="col-sm-2 control-label">内容</label>
				<div class="col-sm-10">
				  <textarea class="form-control" rows="3"id="bbsContent" placeholder="请输入"></textarea>
				</div>
			  </div> 
			  <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				  <button type="button" class="btn btn-primary" onclick="addOrUpdateBBS();">提交</button>
				</div>
			  </div>
			</form>
		</div>
	</div>
<%-- 	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/loadList.js"></script> --%>
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/addOrUpdate.js"></script>
</body>
</html>











