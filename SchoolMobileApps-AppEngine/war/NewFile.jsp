var oTable;
	$('#Search')
			.click(
					function() {
						var row = 0;

						var searchText = $("#search-title").val();//textfield
													
							var str = $("#announcementList").serialize(); //nama form
							//alert(str);
							$("#LoadingImageDiv").show();
							$
									.ajax({
										//async: false,
										//contentType: "application/json; charset=utf-8",
										dataType : 'json',
										type : "POST",
										url : "announcementList?" //nama request mapping di controller
												+ Math
														.floor((Math.random() * 100000) + 1),
										data : str,										
										error : function(xhr, msg, thrownError) {

											//alert(xhr.status);

											if (xhr.status == "200") {
												alert("Your session time has expired. You will now be redirected to login page.")
												window.location = "../login?error=invalidsession";
											} else {
												window.location = "../deniedpage?error="
														+ thrownError;
											}
										},
										success : function(msg) {
											//leavePage();
											$("#LoadingImageDiv").hide();

											oTable = $('#table-list') //nama table
													.dataTable(
															{
																"sPaginationType" : "full_numbers",
																"iDisplayLength" : 50,
																"aaData" : msg,
																"bFilter" : false,
																"bLengthChange" : false,
																"bInfo" : false,
																"bDestroy" : true,
																"aoColumns" : [																		
																		{
																			"sTitle" : "Title",
																			"mData" : "title",
																		},
																		{
																			"sTitle" : "Content",
																			"mData" : "content",
																			sDefaultContent : "n/a"
																		},
																		{
																			"sTitle" : "",
																			"mData" : "destroyed",																			
																		}],
																"aoColumnDefs" : [ {
																	"fnRender" : function(
																			oObj,
																			val) {

																		return '<a href="'+ oObj.aData.id" id="delete-btn" class="btn btn-danger btn-small"><i class="btn-icon-only icon-remove"> </i></a>'
																		//ganti jadi image button id pake id announcement
																	},
																	"aTargets" : [ 0 ]
																}

																]
															}).css('width',
															'100%');
											
											scrollResult();
											$(function() {
												var oSettings = oTable
														.fnSettings();
												if (oSettings.fnRecordsTotal() <= 50) {
													$(
															"#table-List_paginate")
															.hide();
												}
											});

										}
									});
							return false;
						
					});