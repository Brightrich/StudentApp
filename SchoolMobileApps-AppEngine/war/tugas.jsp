<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
	<head>
		<title>BRT Student App - Admin Console</title>
		
		<!-- link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" /-->>
		<link href="${pageContext.request.contextPath}/css/pages/dashboard.css" rel="stylesheet">
   		<link href="${pageContext.request.contextPath}/css/pages/signin.css" rel="stylesheet">
		<%@include file="include/defaultstyle.jsp"%>
		<!-- style type="text/css">
			#content-editor {
				margin: 50px 10px 10px 10px;
			}
			#toolbar {
				margin:10px;
			}
		</style-->
	</head>

	<body onload="init();">
		<%@include file="include/navbar-top.jsp"%>
	    <%@include file="include/subnavbar-menu.jsp"%>
	    
	    <div class="main">
	    	<div class="main-inner">
	    		<div class="container">
	    			<div class="row">
	    				<div class="span12">
	    					<div class="widget wodget-nopad">
	    						<div class="widget-header"> <i class="icon-list-alt"></i>
                            		<h3>Tugas</h3>
                        		</div>
                        		<div class="widget-content">
                        			<div class='navbar navbar-fixed-top'><div id="toolbar" align="center"></div></div>
                        			<form action="addTugas" method="post" enctype="multipart/form-data">
                        				<fieldset>                        					
                        					<div class="controls">
												<form:select path="form.Matpel" items="${form.matpelMap}"/><br>
												<form:select path="form.TugasClass" items="${form.kelasMap}"/><br>												
												<input style="height:30;" type="text" class="span4" id="tugas" name="TugasTitle" value="" placeholder="Title" class="login"><br>
												<input type="file" id="tugasFile" name="tugas">
												<input type="hidden" id="fileExt" name="Extension">
											</div>		                        						                        					
                        					<div class="form-actions" align="left">
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
	    	</div>
	    </div>
	    
	    
	    <%@include file="include/footer.jsp"%>
	</body>

</html>

<script src="${pageContext.request.contextPath}/js/shortcut.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#content-editor').freshereditor({toolbar_selector: "#toolbar", excludes: ['removeFormat', 'insertheading4']});
		$("#content-editor").freshereditor("edit", true);
	});
	
	function saveOnClick(){
		var isi = $("#pageContent").val($("#content-editor").html());
		alert(isi);
	}
	
	$('#tugasFile').change(function(){
	    var value = this.value;
	    val = value.split("\\");
	    var file = (val[val.length - 1]).split('.');
	    var ext = file[file.length - 1];	    
	    $("#fileExt").val(ext);
	})
	
	function getFileExtension(){
		alert("called");
		alert($('#tugasFile').val());
		var extension = $('#tugasFile').val().match(/[^.]+$/).toLowerCase();
		alert(extension);
		return false;
	}
	
</script>
