<%@ page language="java" contentType="text/html; charset=UTF-8"import="com.hiring.bean.obj.UserObj" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<title>招聘系统</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
<body>
	<div class="container-fluid J_BBS">
		<jsp:include page="common.jsp"></jsp:include>
		<div class="container-fluid recruit-manage-add">
			<form class="form-horizontal">
			  <div class="form-group">
				<div class="col-sm-12 ui-bbs-box">
				   <h4 id="showBBSName" class="ui-bbs-title">关于招聘那些事儿</h4>
				</div>
			  </div>
			  <ul class="container-fluid" id="showBBSContet">
			  	<li class="row ui-bbs-li">
			  		<label for="bbsContent" class="col-sm-2 control-label">王玉</label>
					<div class="col-sm-10 ui-bbs-content">
					 	收到货股份是好烦好是飞洒发的烦沙发大幅度收到货股份是好烦好是飞洒发的烦沙发大幅度收到货
					 	股份是好烦好是飞洒发的烦沙发大幅度收到货股份是好烦好是飞洒发的烦沙发大幅度收到货股份是
					 	好烦好是飞洒发的烦沙发大幅度
					</div>
			  	</li>
			  	<li class="row ui-bbs-li">
			  		<label for="bbsContent" class="col-sm-2 control-label">王玉</label>
					<div class="col-sm-10 ui-bbs-content">
					 	收到货股份是好烦好是飞洒发的烦沙发大幅度收到货股份是好烦好是飞洒发的烦沙发大幅度收到货
					 	股份是好烦好是飞洒发的烦沙发大幅度收到货股份是好烦好是飞洒发的烦沙发大幅度收到货股份是
					 	好烦好是飞洒发的烦沙发大幅度
					</div>
			  	</li>
			  </ul>
			  <nav class="nav-right">
				<div class="ui-page-num">当前第<span id="currentPage">1</span>页,共<span id="totalPage"></span>页</div>
				<ul class="pagination">
					<li class="disabled">
					  <a href="javascript:void(0);" aria-label="Previous" id="showbbsPrcv">
						<span aria-hidden="true">上一页</span>
					  </a>
					</li>
					<li>
					  <a href="javascript:void(0);" aria-label="Next" id="showbbsNext">
						<span aria-hidden="true">下一页</span>
					  </a>
					</li>
				</ul>
			   </nav>
			  <div class="form-group">
				<label for="bbsContent" class="col-sm-1 control-label">内容</label>
				<div class="col-sm-11">
				  <textarea class="form-control" rows="3"id="bbsContent" placeholder="请输入"></textarea>
				</div>
			  </div> 
			  <div class="form-group">
				<div class="col-sm-12">
				  <button type="button" class="btn btn-primary" onclick="addThemeFloor()">发表</button>
				</div>
			  </div>
			</form>
		</div>
	</div>
<%-- 	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/loadList.js"></script> --%>
	<script type="text/javascript" src="<%=request.getContextPath() %>/styles/js/addOrUpdate.js"></script>
</body>
</html>











