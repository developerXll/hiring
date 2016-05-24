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
		<div class="container-fluid recruit-manage">
			<div class="row container-fluid ui-search-box">
				<form class="form-inline">
				   <div class="form-group">
				     <label for="name">名称</label>
				     <input type="text" class="form-control" id="bbsListName" placeholder="输入查询名称">
				   </div>
				   <button type="button" class="btn btn-primary" id="bbsListSearchBtn">查询</button>
				   <a type="button" class="btn btn-success nav-right" href="/html/addOrUpdateBBS.jsp#bbs">新建</a>
				</form>
			</div>
			<table class="table table-striped table-hover"> 
				<tr class="customer-thead">
					<th width="5%">序号</th>
					<th width="60%">主题</th>
					<th width="15%">创建时间</th>
					<th width="20%">操作</th> 
				</tr>
				<tbody id="bbsListTbody">
				
				</tbody>
			</table>
			<nav class="nav-right">
				<div class="ui-page-num">当前第<span id="currentPage">1</span>页,共<span id="totalPage"></span>页</div>
				<ul class="pagination">
					<li class="disabled">
					  <a href="javascript:void(0);" aria-label="Previous" id="bbsPrcv">
						<span aria-hidden="true">上一页</span>
					  </a>
					</li>
					<li>
					  <a href="javascript:void(0);" aria-label="Next" id="bbsNext">
						<span aria-hidden="true">下一页</span>
					  </a>
					</li>
				</ul>
			</nav>
		</div>
	</div>
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/loadList.js"></script>
</body>
</html>











