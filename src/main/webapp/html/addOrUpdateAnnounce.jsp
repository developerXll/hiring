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
				<label for="noticeName" class="col-sm-2 control-label">公告名称</label>
				<div class="col-sm-10">
				  <input type="email" class="form-control" id="noticeName" placeholder="输入公告名称">
				</div>
			  </div>
			  <div class="form-group">
				<label for="noticeContent" class="col-sm-2 control-label">公告内容</label>
				<div class="col-sm-10">
				  <textarea class="form-control" rows="3"id="noticeContent" placeholder="输入公告内容"></textarea>
				</div>
			  </div> 
			  <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				  <button type="button" class="btn btn-primary" onclick="addOrUpdateAnnounce();">提交</button>
				</div>
			  </div>
			</form>
		</div>
	</div>
<%-- 	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/loadList.js"></script> --%>
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/addOrUpdate.js"></script>
</body>
</html>











