<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/includes/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>日历管理</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="${ctx}/views/default/assets/css/fullcalendar.min.css" />
<%-- <link rel="stylesheet" href="${ctx}/views/default/assets/css/fullcalendar.print.css" /> --%>
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<h1>
				Full Calendar <small> <i class="icon-double-angle-right"></i>
					with draggable and editable events
				</small>
			</h1>
		</div>
		<!-- /.page-header -->

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->

				<div class="row">
					<div class="col-sm-9">
						<div class="space"></div>

						<div id="calendar"></div>
					</div>

					<div class="col-sm-3">
						<div class="widget-box transparent">
							<div class="widget-header">
								<h4>Draggable events</h4>
							</div>

							<div class="widget-body">
								<div class="widget-main no-padding">
									<div id="external-events">
										<div class="external-event label-grey" data-class="label-grey">
											<i class="icon-move"></i> My Event 1
										</div>

										<div class="external-event label-success"
											data-class="label-success">
											<i class="icon-move"></i> My Event 2
										</div>

										<div class="external-event label-danger"
											data-class="label-danger">
											<i class="icon-move"></i> My Event 3
										</div>

										<div class="external-event label-purple"
											data-class="label-purple">
											<i class="icon-move"></i> My Event 4
										</div>

										<div class="external-event label-yellow"
											data-class="label-yellow">
											<i class="icon-move"></i> My Event 5
										</div>

										<div class="external-event label-pink" data-class="label-pink">
											<i class="icon-move"></i> My Event 6
										</div>

										<div class="external-event label-info" data-class="label-info">
											<i class="icon-move"></i> My Event 7
										</div>

										<label> <input type="checkbox"
											class="ace ace-checkbox" id="drop-remove" /> <span
											class="lbl"> Remove after drop</span>
										</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.page-content -->

	<%@include file="/views/default/include/script-import.jsp"%>
	<script src="${ctx}/views/default/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="${ctx}/views/default/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="${ctx}/views/default/assets/js/fullcalendar.min.js"></script>
	<script src="${ctx}/views/default/assets/js/bootbox.min.js"></script>
	<!-- inline scripts related to this page -->
	<script src="${ctx}/views/default/js/system/event/query.js"></script>-->
</body>
</html>
