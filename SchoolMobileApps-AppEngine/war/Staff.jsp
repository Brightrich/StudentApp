<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
	<head>
		<title>BRT Student App - Admin Console</title>
		
		<!-- link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" /-->
<%-- 		<link href="${pageContext.request.contextPath}/css/farbtastic.css" rel="stylesheet" type="text/css" /> --%>
<%-- 		<link href="${pageContext.request.contextPath}/css/freshereditor.css" rel="stylesheet" type="text/css" /> --%>
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
	    				<div class="span6">
	    					<div class="widget wodget-nopad">
	    						<div class="widget-header"> <i class="icon-list-alt"></i>
                            		<h3>Staff</h3>
                        		</div>
                        		<div class="widget-content">
                        			<div class='navbar navbar-fixed-top'><div id="toolbar" align="center"></div></div>
                        			<form action="addStaff" method="post"  enctype="multipart/form-data">
                        				<fieldset>                        					
                        					<div class="controls">
												<input style="height:30;" type="text" class="span4" id="staff" name="StaffNIK" value="" placeholder="NIK" class="login" autofocus><br>
												<input style="height:30;" type="text" class="span4" id="staff" name="StaffName" value="" placeholder="Name" class="login" autofocus><br>
												<input style="height:30;" type="text" class="span4" id="staff" name="StaffRole" value="" placeholder="Role" class="login" autofocus><br>
												Foto &nbsp; <input type="file" name="staffPhoto">
											</div>		                        						                        					
                        					<div class="form-actions" align="left">
												<button onclick="javascript:$('#pageContent').val($('#content-editor').html());return true;" type="submit" class="btn btn-primary">Save</button> 
												<button class="btn">Cancel</button>
											</div>
                        				</fieldset>
                        			</form>
                        		</div>
	    					</div>
	    				</div>
	    				<div class="span6">
	    					<div class="widget wodget-nopad">
	    						<div class="widget-header"> <i class="icon-list-alt"></i>
                            		<h3>Murid</h3>
                        		</div>
                        		<div class="widget-content">
                        			<div class='navbar navbar-fixed-top'><div id="toolbar" align="center"></div></div>
                        			<form action="addStudent" method="post"  enctype="multipart/form-data">
                        				<fieldset>                        					
                        					<div class="controls">
												<input style="height:30;" type="text" class="span4" name="StudentNIS" value="" placeholder="Nomor Induk Siswa" class="login" autofocus><br>
												<input style="height:30;" type="text" class="span4" name="StudentFirstName" value="" placeholder="Nama Depan" class="login" autofocus><br>
												<input style="height:30;" type="text" class="span4" name="StudentLastName" value="" placeholder="Nama Belakang" class="login" autofocus><br>
												<input style="height:30;" type="text" class="span4" name="StudentPhone" value="" placeholder="No. Telepon" class="login" autofocus><br>
												<input style="height:30;" type="text" class="span4" name="StudentEmail" value="" placeholder="Email" class="login" autofocus><br>
												<input style="height:30;" type="text" class="span4" name="StudentIMSI" value="" placeholder="IMSI" class="login" autofocus><br>
												<form:select path="form.Kelas" items="${form.kelasMap}"/>&nbsp;(Kelas)<br>
												Foto &nbsp; <input type="file" name="studentPhoto">
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
<%-- <script src="${pageContext.request.contextPath}/js/farbtastic.js" type="text/javascript"></script>	 --%>
<%-- <script src="${pageContext.request.contextPath}/js/freshereditor.min.js" type="text/javascript"></script> --%>
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
