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
			<form class="form-horizontal">
			  <div class="form-group">
				<label for="noticeName" class="col-sm-2 control-label">岗位名称</label>
				<div class="col-sm-10">
				  <input type="text" class="form-control" id="recName" placeholder="输入岗位名称">
				</div>
			  </div>
			  <div class="form-group">
				<label for="noticeName" class="col-sm-2 control-label">招聘状态</label>
				<div class="col-sm-10">
				  <select class="form-control" id="recStatus" />
					<option value = "RECRUTING">招聘中</option>
					<option value = "RECRUTED">已结束</option>
				  </select>
				</div>
			  </div>
			  <div class="form-group">
				<label for="" class="col-sm-2 control-label">薪资待遇</label>
				<div class="col-sm-5">
				  <select class="form-control" id="recMoney" />
				  	<option value = "">面议</option>
					<option value = "5000-8000">5000-8000</option>
					<option value = "8000-10000">8000-10000</option>
					<option value = "10000-15000">10000-15000</option>
					<option value = "15000-25000">15000-25000</option>
					<option value = "25000+">25000以上</option>
				  </select>
				</div>
				<div class="col-sm-1">
				  X
				</div>
				<div class="col-sm-4">
				  <select class="form-control" id="recMonth" />
					<option value = "">面议</option>
					<option value = "12">12薪</option>
					<option value = "13">13薪</option>
					<option value = "14">14薪</option>
					<option value = "15">15薪</option>
					<option value = "16">16薪</option>
					<option value = "17">17薪</option>
				  </select>
				</div>
			  </div>
			  <div class="form-group">
				<label for="noticeContent" class="col-sm-2 control-label" >岗位描述</label>
				<div class="col-sm-10">
				  <textarea class="form-control" rows="3"id="recJobDesc" placeholder="输入岗位描述"></textarea>
				</div>
			  </div> 
			  <div class="form-group">
				<label for="noticeContent" class="col-sm-2 control-label">工作描述</label>
				<div class="col-sm-10">
				  <textarea class="form-control" rows="3"id="recWorkContent" placeholder="输入工作描述"></textarea>
				</div>
			  </div> 
			  <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				  <button type="button" class="btn btn-primary" onclick="saveOrUpdateRecruit();">提交</button>
				</div>
			  </div>
			</form>
		</div>
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/addOrUpdate.js"></script>
</body>
</html>











