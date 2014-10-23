<%--
  Created by IntelliJ IDEA.
  User: Ahmadi
  Date: 9/24/2014
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>404 - BRT Student App - Admin Console</title>
    <%@include file="include/defaultstyle.jsp"%>
</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <a class="brand" href="index">
                BRT Student App - Admin Console
            </a>

            <div class="nav-collapse">
                <ul class="nav pull-right">

                    <li class="">
                        <a href="index" class="">
                            <i class="icon-chevron-left"></i>
                            Back to Dashboard
                        </a>

                    </li>
                </ul>

            </div><!--/.nav-collapse -->

        </div> <!-- /container -->

    </div> <!-- /navbar-inner -->

</div> <!-- /navbar -->



<div class="container">

    <div class="row">

        <div class="span12">

            <div class="error-container">
                <h1>404</h1>

                <h2>Who! bad trip man. No more pixesl for you.</h2>

                <div class="error-details">
                    Sorry, an error has occured! Why not try going back to the <a href="index.html">home page</a> or perhaps try following!

                </div> <!-- /error-details -->

                <div class="error-actions">
                    <a href="index.html" class="btn btn-large btn-primary">
                        <i class="icon-chevron-left"></i>
                        &nbsp;
                        Back to Dashboard
                    </a>



                </div> <!-- /error-actions -->

            </div> <!-- /error-container -->

        </div> <!-- /span12 -->

    </div> <!-- /row -->

</div> <!-- /container -->


<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/bootstrap.js"></script>

</body>

</html>

