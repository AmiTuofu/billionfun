$().ready(function(){
		/* initialize the external events
		-----------------------------------------------------------------*/
		$('#external-events div.external-event').each(function() {
	//		alert("111");
			// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
			// it doesn't need to have a start or end
			var eventObject = {
				title: $.trim($(this).text()) // use the element's text as the event title
			};
			// store the Event Object in the DOM element so we can get to it later
			$(this).data('eventObject', eventObject);
			// make the event draggable using jQuery UI
			$(this).draggable({
				zIndex: 999,
				revert: true,      // will cause the event to go back to its
				revertDuration: 0  //  original position after the drag
			});
		});
		/* initialize the calendar
		-----------------------------------------------------------------*/
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		var calendar = $('#calendar').fullCalendar({
			 buttonText: {
				prev: '<i class="icon-chevron-left"></i>',
				next: '<i class="icon-chevron-right"></i>',
				today:'返回今天',
				month:'月',
				week:'周',
				day:'日'
			},
			monthNames: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
			monthNamesShort: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
			dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
			dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			events: function(start, end, callback) {
				var events =[];
				$.ajax({
		            type: "POST",
		            url: ctx+"/system/event/query.json",
		            data: {start: start.getTime(), end: end.getTime()},
		            beforeSend:function(XMLHttpRequest){
//		            	bootbox.alert("加载中...", function (result) {
		//
//		                });
		            },
		            success: function (data) {
		            	$.each(data.list, function(i, item) {
							events.push({
								id:$(this).attr('id'),
		                        title:$(this).attr('name'),
		                        start:$(this).attr('startDate'), // will be parsed
		                        end:$(this).attr('endDate')
		                    });
				        });
						callback(events);
	                },
	                error: function (e) {
	                    alert("error");
	                }
		        });
				
			},
			editable: true,
			droppable: true, // this allows things to be dropped onto the calendar !!!
			drop: function(date, allDay) { // this function is called when something is dropped
				// retrieve the dropped element's stored Event Object
				
				var originalEventObject = $(this).data('eventObject');
				var id = addEvent(originalEventObject.title,date,date);
				var $extraEventClass = $(this).attr('data-class');
				// we need to copy it, so that multiple events don't have a reference to the same object
				var copiedEventObject = $.extend({}, originalEventObject);
				// assign it the date that was reported
				copiedEventObject.start = date;
				copiedEventObject.allDay = allDay;
				copiedEventObject.id = id
				if($extraEventClass) copiedEventObject['className'] = [$extraEventClass];
				// render the event on the calendar
				// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
				$('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
				// is the "remove after drop" checkbox checked?
				if ($('#drop-remove').is(':checked')) {
					// if so, remove the element from the "Draggable Events" list
					$(this).remove();
				}
				
			},
			selectable: true,
			selectHelper: true,
			select: function(start, end, allDay) {
				
				bootbox.prompt("新建事件:", function(title) {
					
					if (title !== null) {
						var id = addEvent(title,start,end);
						calendar.fullCalendar('renderEvent',
							{
								id:id,
								title: title,
								start: start,
								end: end,
								allDay: allDay
							},
							true // make the event "stick"
						);
					}
				});
				$(".modal-title").html("新建事件:");
				var bootbox_form_html = "<form class=\"form-horizontal\" role=\"form\">";
				bootbox_form_html = bootbox_form_html + "<div class=\"form-group\"><label class=\"col-sm-2 control-label no-padding-right\" for=\"form-field-1\"> 名称: </label>";
				bootbox_form_html = bootbox_form_html + "<div class=\"col-sm-9\"><input type=\"text\" id=\"form-field-1\" name=\"name\" placeholder=\"\" class=\"col-xs-11 col-sm-8\"></div></div>";
				bootbox_form_html = bootbox_form_html + "<div class=\"space-4\"></div>";
				
				bootbox_form_html = bootbox_form_html + "<div class=\"form-group\"><label class=\"col-sm-2 control-label no-padding-right\" for=\"form-field-1\"> 开始: </label>";
				bootbox_form_html = bootbox_form_html + "<div class=\"col-sm-9\"><input type=\"text\" id=\"form-field-1\" name=\"startDate\" placeholder=\"\" class=\"col-xs-10 col-sm-5\"></div></div>";
				bootbox_form_html = bootbox_form_html + "<div class=\"space-4\"></div>";
				
				bootbox_form_html = bootbox_form_html + "<div class=\"form-group\"><label class=\"col-sm-2 control-label no-padding-right\" for=\"form-field-1\"> 结束: </label>";
				bootbox_form_html = bootbox_form_html + "<div class=\"col-sm-9\"><input type=\"text\" id=\"form-field-1\" name=\"endDate\" placeholder=\"\" class=\"col-xs-10 col-sm-5\"></div></div>";
				bootbox_form_html = bootbox_form_html + "<div class=\"space-4\"></div>";
				
				bootbox_form_html = bootbox_form_html + "<div class=\"form-group\"><label class=\"col-sm-2 control-label no-padding-right\" for=\"form-field-1\"> 重复: </label>";
				bootbox_form_html = bootbox_form_html + "<div class=\"col-sm-9\"><input type=\"text\" id=\"form-field-1\" name=\"repeats\" placeholder=\"\" class=\"col-xs-4 col-sm-4\"><lable class=\"col-xs-2 col-sm-2\" style=\"padding-top:4px;margin-bottom:4px\">直到:</lable><input type=\"text\" id=\"form-field-1\" name=\"repeatsEndDate\" placeholder=\"\" class=\"col-xs-6 col-sm-6\"></div></div>";
				bootbox_form_html = bootbox_form_html + "<div class=\"space-4\"></div>";
				
				bootbox_form_html = bootbox_form_html + "<div class=\"form-group\"><label class=\"col-sm-2 control-label no-padding-right\" for=\"form-field-1\"> 提醒: </label>";
				bootbox_form_html = bootbox_form_html + "<div class=\"col-sm-9\"><input type=\"text\" id=\"form-field-1\" placeholder=\"\" name=\"remind\" class=\"col-xs-10 col-sm-5\"></div></div>";
				bootbox_form_html = bootbox_form_html + "<div class=\"space-4\"></div>";
				
				bootbox_form_html = bootbox_form_html + "<div class=\"form-group\"><label class=\"col-sm-2 control-label no-padding-right\" for=\"form-field-1\"> 地点: </label>";
				bootbox_form_html = bootbox_form_html + "<div class=\"col-sm-9\"><input type=\"text\" id=\"form-field-1\" placeholder=\"\" name=\"place\" class=\"col-xs-10 col-sm-5\"></div></div>";
				bootbox_form_html = bootbox_form_html + "<div class=\"space-4\"></div>";
				
				
				bootbox_form_html = bootbox_form_html + "</form>";
				$(".bootbox-body").html(bootbox_form_html);
				calendar.fullCalendar('unselect');
			},
			eventClick: function(calEvent, jsEvent, view) {
				var form = $("<form class='form-inline'><label>编辑事件名称： &nbsp;</label></form>");
				form.append("<input class='middle' autocomplete=off type=text value='" + calEvent.title + "' /> ");
				form.append("<button type='submit' class='btn btn-sm btn-success'><i class='icon-ok'></i> 保存</button>");
				var div = bootbox.dialog({
					title:"编辑事件",
					message: form,
					buttons: {
						"delete" : {
							"label" : "<i class='icon-trash'></i> 删除事件",
							"className" : "btn-sm btn-danger",
							"callback": function() {
								delEvent(calEvent);
								calendar.fullCalendar('removeEvents' , function(ev){
									return (ev._id == calEvent._id);
								})
							}
						} ,
						"close" : {
							"label" : "<i class='icon-remove'></i> 关闭",
							"className" : "btn-sm"
						} 
					}
				});
				form.on('submit', function(){
					
					calEvent.title = form.find("input[type=text]").val();
					calendar.fullCalendar('updateEvent', calEvent);
					modifyEvent(calEvent);
					div.modal("hide");
					return false;
				});
				//console.log(calEvent.id);
				//console.log(jsEvent);
				//console.log(view);
				// change the border color just for fun
				//$(this).css('border-color', 'red');
			},
			eventDragStart:function(calEvent, jsEvent, ui, view){
				
			},
			eventDragStop:function(calEvent, jsEvent, ui, view){
				
			},
			eventDrop: function(calEvent, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view){
				modifyEvent(calEvent);
			},
			eventResizeStart:function(calEvent, jsEvent, ui, view){
				
			},
			eventResizeStop:function(calEvent, jsEvent, ui, view){
				
			},
			eventResize: function(calEvent, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view){
				modifyEvent(calEvent);
				
			}
		});
		function addEvent(title,start,end){
			var id = "";
			if(end==""||end==null){
				var date = new Date();
				end = date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate()+" 23:59:59";
			}
			var params = {
					"startDate":start,
					"endDate":end,
					"name":title
			};
			$.ajax({
		            type: "POST",
		            url: ctx + "/system/event/add.json",
		            data: params,
		            async: false,
		            beforeSend:function(XMLHttpRequest){
//		            	bootbox.alert("加载中...", function (result) {
		//
//		                });
		            },
		            success: function (data) {
		            		id = data.id
		                },
		            error: function (e) {
		                    alert("error");
		                }
		        });
			return id;
		}
		function modifyEvent(calEvent){
			if(calEvent.end==""||calEvent.end==null){
				var date = calEvent.start;
				calEvent.end = new Date(date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate()+" 23:59:59");
			}
			var params = {
					"id":calEvent._id,
					"startDate":calEvent.start,
					"endDate":calEvent.end,
					"name":calEvent.title
			};
			$.ajax({
		            type: "POST",
		            url: ctx + "/system/event/modify.json",
		            data: params,
		            beforeSend:function(XMLHttpRequest){
//		            	bootbox.alert("加载中...", function (result) {
		//
//		                });
		            },
		            success: function (data) {
		            	
		                },
		            error: function (e) {
		                    alert("error");
		                }
		        });
		}
		function delEvent(calEvent){
			var params = {
					"id":calEvent._id,
			};
			$.ajax({
		            type: "POST",
		            url: ctx + "/system/event/delete.json",
		            data: params,
		            beforeSend:function(XMLHttpRequest){
//		            	bootbox.alert("加载中...", function (result) {
		//
//		                });
		            },
		            success: function (data) {
		            	
		                },
		            error: function (e) {
		                    alert("error");
		                }
		        });
		}
});