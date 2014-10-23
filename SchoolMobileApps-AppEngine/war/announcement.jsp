<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <title>BRT Student App - Admin Console</title>
    <link href="${pageContext.request.contextPath}/css/pages/dashboard.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/pages/signin.css" rel="stylesheet">
    <%@include file="include/defaultstyle.jsp"%>
</head>
<body>
    <%@include file="include/navbar-top.jsp"%>
    <%@include file="include/subnavbar-menu.jsp"%>

<div class="main">
    <div class="main-inner">
        <div class="container">

			<div class="row">
				<div class="span12">
					<div class="widget widget-nopad">
                        <div class="widget-header"> <i class="icon-list-alt"></i>
                            <h3>Recent Announcements</h3>
                        </div>
                        <!-- /widget-header -->
                        <div class="widget-content">
							<div class="control-group">								
								<div class="controls" id="accordionDiv">
                                     <div class="accordion" id="accordion2">
                                      <c:forEach items="${form.newsList}" var="el"> 
                                     	<div class="accordion-group">
                                          <div class="accordion-heading">
	                                           <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse${el.id}">
	                                              ${el.title}
	                                           </a>
                                          </div>
                                          <div id="collapse${el.id}" class="accordion-body collapse">
                                               <div class="accordion-inner">
                                               	${el.content}            
                                               </div>
                                          </div>
                                     </div>
                                     </c:forEach>
                                     
                                     
                                    
                                     </div>
								</div> <!-- /controls -->	
							</div> <!-- /control-group -->
						</div>
					</div>
				</div>
				</div>

            <div class="row">
                <div class="span6">
                	
                	<!-- /table start -->
                	<div class="widget	">
                        <div class="widget-header"> <i class="icon-th-list"></i>
                            <h3>Announcement List</h3>
                        </div>
                        
                        <div class="widget-content">
                        	<form id="announcementList">
                        		<input id="search-title" name="title_search" type="text" style="height:30;" placeholder="Title"> 
                        		<input id="Search" type="submit" value="Search" style="height:30;" placeholder="Title">
                        	 	<div id="LoadingImageDiv"
									style="display: none; text-align: center;">
									<img id="loading-image" src="${pageContext.request.contextPath}/img/ajax-loader.gif" />
								</div>
                            	<table id="tablelist" class="table table-striped table-bordered">
                           		</table>
                        	</form>                            
                        </div>
                        
                    </div>
                		<!-- /table end-->
                
                
                </div>
                
                <div class="span6">
                    <div class="widget">
                		<div class="widget-header"> <i class="icon-bookmark"></i>
                            <h3>Create New Announcement</h3>
                        </div>
                        <div class="widget-content">
                        	
                        	<form action="addNewAnnouncement" method="post">
                        	<fieldset>
                        		<div class="control-group">																		
										<div class="controls">
											<input style="height:30;" type="text" class="span4" id="title" name="title" value="" placeholder="Title" class="login">
										</div>				
								</div>
                        		<div class="control-group">																				
										<div class="controls">
											<textarea class="span4" id="content" name="content" placeholder="Content" class="login"></textarea>
										</div>
								</div>
                        	                        																		
								<div class="form-actions">
									<button type="submit" class="btn btn-primary">Save</button> 
									<button class="btn">Cancel</button>
								</div>
								
								</fieldset>
							</form>							
                        </div>
                    </div>
                </div>        
            </div>                 
        </div>
    <!-- /container -->
    </div>
<!-- /main-inner -->
</div>
<!-- /main -->

<form id="hiddenForm">
<input name="deleteId"  type="hidden" id="keyTemp"/>
</form>

<%@include file="include/footer.jsp"%>
</body>
</html>

<script type="text/javascript">

$('#delete-btn').live("click", 
		function(e){
			e.preventDefault();
		$("#keyTemp").val($(this).attr("href"));	
		var str = $("#hiddenForm").serialize();
		
		$.ajax({
			dataType : 'json',
			type: "POST",
			url: "announcementDelete?" //nama request mapping di controller
				+ Math
				.floor((Math.random() * 100000) + 1),				
				data:str,
				success: function(response){
					$('#Search').click();
					
					jQuery('#accordionDiv div').html('');
					
					$.ajax({
						dataType : 'json',
						type: "POST",
						url: "getRecentNews?" //nama request mapping di controller
							+ Math
							.floor((Math.random() * 100000) + 1),				
							data:str,
							success: function(result){
								
								$("#accordionDiv").append("<div class='accordion' id='accordion2'>");
								
								$.each(result, function(index,jsonObject){
								        
								   var temp = "<div class='accordion-group'> <div class='accordion-heading'> <a class='accordion-toggle' data-toggle='collapse' data-parent='#accordion2' href='#collapse" 
								        + jsonObject.id + "'>" + jsonObject.title
	                                    + "</a> </div> <div id='collapse" + jsonObject.id +"' class='accordion-body collapse'><div class='accordion-inner'>" +
	                                    jsonObject.content + " </div> </div> </div>"
								        
	                                    $("#accordionDiv").append(temp);    
								});			
								
								$("#accordionDiv").append("</div>");
								
							},
							error: function(xhr, status, error) {
								alert(xhr.responseText);
							}
					});
					
				},
				error: function(xhr, status, error) {
					alert(xhr.responseText);
				}
				
		});
		
		
		return false;		
});

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
									
											oTable = $('#tablelist')
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
																			sDefaultContent : "n/a"
																		},
																		{
																			"sTitle" : "Content",
																			"mData" : "content",
																			sDefaultContent : "n/a"
																		},
																		{
																			"sTitle" : "",
																			"mData" : "destroyed",
																			sDefaultContent : "n/a"
																		}],
																"aoColumnDefs" : [ {
																	"fnRender" : function(
																			oObj,
																			val) {

																		return '<a href="'+ oObj.aData.id+'" id="delete-btn" class="btn btn-danger btn-small"><i class="btn-icon-only icon-remove"> </i></a>'
																		//ganti jadi image button id pake id announcement
																	},
																	"aTargets" : [ 2 ]
																}

																]
															}).css('width',
															'100%');
									
											//scrollResult();
											$(function() {
												var oSettings = oTable
														.fnSettings();
												if (oSettings.fnRecordsTotal() <= 50) {
													$(
															"#tablelist_paginate")
															.hide();
												}
											});

										}
									});
							return false;
						
					});
					</script>