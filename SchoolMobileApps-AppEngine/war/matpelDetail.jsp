<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
	<head>
		<title>BRT Student App - Admin Console</title>
		
		<!-- link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" /-->
		<link href="${pageContext.request.contextPath}/css/farbtastic.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/freshereditor.css" rel="stylesheet" type="text/css" />
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
                            		<h3>Detail Mata Pelajaran</h3>
                        		</div>
                        		<div class="widget-content">
                        			
                        			<form action="addMatpelDetail" method="post">
                        				<fieldset>                        					
                        					<div class="controls">
												<form:select path="form.matpel" items="${form.matpelMap}" /><br>
												<form:select path="form.matpelDetailClass" items="${form.kelasMap}" /><br>												
												<input style="height:30;" type="text" class="span4" id="matmepDetail" name="matpelDetailTitle" value="" placeholder="Title" class="login" autofocus><br>
												<div class='navbar navbar-fixed-top'><div id="toolbar" align="center"></div><div id="content-editor" style="width: 100%;border: 2px solid black;">
												&nbsp;</div></div>
												
											</div>                        						                        					
                        					<div class="form-actions" align="left">
												<button onclick="javascript:$('#pageContent').val($('#content-editor').html());return true;" type="submit" class="btn btn-primary">Save</button> 
												<button class="btn">Cancel</button>
											</div>
                        				</fieldset>
                        				<input type="hidden" id="pageContent" name="matpelDetailContent"/>
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
<script src="${pageContext.request.contextPath}/js/farbtastic.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/freshereditor.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#content-editor').freshereditor({toolbar_selector: "#toolbar", excludes: ['removeFormat', 'insertheading4']});
		$("#content-editor").freshereditor("edit", true);
	});
	
	function saveOnClick(){
		var isi = $("#pageContent").val($("#content-editor").html());
		alert(isi);
	}
	
</script>
