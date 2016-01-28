<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/includes/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>功能菜单管理</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="${ctx}/views/default/assets/css/jquery-ui-1.10.3.full.min.css" />
		<link rel="stylesheet" href="${ctx}/views/default/assets/css/datepicker.css" />
		<link rel="stylesheet" href="${ctx}/views/default/assets/css/ui.jqgrid.css" />
	</head>
	<body>
						<div class="page-content">
						<div class="page-header">
							<h1>
								功能菜单管理
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

								<script type="text/javascript">
									var $path_base = "/";//this will be used in gritter alerts containing images
								</script>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				
		<%@include file="/views/default/include/script-import.jsp"%>
		<!-- page specific plugin scripts -->

		<script src="${ctx}/views/default/assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="${ctx}/views/default/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
		<script src="${ctx}/views/default/assets/js/jqGrid/i18n/grid.locale-en.js"></script>


		<!-- inline scripts related to this page -->
		<script src="${ctx}/views/default/js/system/func/query.js"></script>
	<!-- <div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div> -->
</body>
</html>
