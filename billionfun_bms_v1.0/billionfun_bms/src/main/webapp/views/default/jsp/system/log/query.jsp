<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/includes/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>日志管理</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	</head>
	<body>
						<div class="page-content">
						<div class="page-header">
							<h1>
								日志管理
								<small>
									<i class="icon-double-angle-right"></i>
									查看
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<table id="grid-table"></table>

								<div id="grid-pager"></div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				
		<%@include file="/views/default/include/script-import.jsp"%>
		<!-- inline scripts related to this page -->
		<script src="${ctx}/views/default/js/system/log/query.js"></script>
	<!-- <div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div> -->
</body>
</html>
