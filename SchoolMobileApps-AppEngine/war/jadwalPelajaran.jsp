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
	    				<div class="span6">
	    					<div class="widget wodget-nopad">
	    						<div class="widget-header"> <i class="icon-list-alt"></i>
                            		<h3>Jadwal Pelajaran</h3>
                        		</div>
                        		<div class="widget-content">
                        			<div class='navbar navbar-fixed-top'><div id="toolbar" align="center"></div></div>
                        			<form action="addJadwalPelajaran" method="post">
                        				<fieldset>                        					
                        					<div class="controls">
												<form:select path="form.matpel" items="${form.matpelMap}"/><br>
												<form:select path="form.kelas" items="${form.kelasMap}"/><br>
												<select name="jadwalHari">
													<option>Senin</option>
													<option>Selasa</option>
													<option>Rabu</option>
													<option>Kamis</option>
													<option>Jumat</option>
													<option>Sabtu</option>
													<option>Minggu</option>
												</select></br>
												<select	style="width: 50px" name="jadwalMulaiJam">
													<option>06</option>
													<option>07</option>
													<option>08</option>
													<option>09</option>
													<option>10</option>
													<option>11</option>
													<option>12</option>
													<option>13</option>
													<option>14</option>
													<option>15</option>
													<option>16</option>
												</select> - 
												<select	style="width: 50px" name="jadwalMulaiMenit">
													<option>00</option>
													<option>05</option>
													<option>10</option>
													<option>15</option>
													<option>20</option>
													<option>25</option>
													<option>30</option>
													<option>35</option>
													<option>40</option>
													<option>45</option>
													<option>50</option>
													<option>55</option>
												</select> (Jam Mulai)</br>
												<select	style="width: 50px" name="jadwalSelesaiJam">
													<option>06</option>
													<option>07</option>
													<option>08</option>
													<option>09</option>
													<option>10</option>
													<option>11</option>
													<option>12</option>
													<option>13</option>
													<option>14</option>
													<option>15</option>
													<option>16</option>
												</select> - 
												<select	style="width: 50px" name="jadwalSelesaiMenit">
													<option>00</option>
													<option>05</option>
													<option>10</option>
													<option>15</option>
													<option>20</option>
													<option>25</option>
													<option>30</option>
													<option>35</option>
													<option>40</option>
													<option>45</option>
													<option>50</option>
													<option>55</option>
												</select> (Jam Selesai)</br>
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
	
</script>
