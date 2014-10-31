<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>BRT Student App - Admin Console</title>
    <link href="${pageContext.request.contextPath}/css/pages/dashboard.css" rel="stylesheet">
    <%@include file="include/defaultstyle.jsp"%>
</head>
<body>
    <%@include file="include/navbar-top.jsp"%>
    <%@include file="include/subnavbar-menu.jsp"%>

<div class="main">
    <div class="main-inner">
        <div class="container">

            <div class="row">
                <div class="span6">
                    <!-- /widget -->
                    <div class="widget widget-nopad">
                        <div class="widget-header"> <i class="icon-list-alt"></i>
                            <h3> Recent News</h3>
                        </div>
                        <!-- /widget-header -->
                        <div class="widget-content">
                            <div id='calendar'></div>
                        </div>
                        <!-- /widget-content -->
                    </div>
                </div>

                <!-- /span6 -->
                <div class="span6">
                    <!-- /widget -->
                    <div class="widget">
                        <div class="widget-header"> <i class="icon-signal"></i>
                            <h3> Area Chart Example</h3>
                        </div>
                        <!-- /widget-header -->
                        <div class="widget-content">
                            <canvas id="area-chart" class="chart-holder" height="250" width="538"> </canvas>
                            <!-- /area-chart -->
                        </div>
                        <!-- /widget-content -->
                    </div>
                </div>
                <!-- /span6 -->
            </div>
        <!-- /row -->

        </div>
    <!-- /container -->
    </div>
<!-- /main-inner -->
</div>
<!-- /main -->

<%@include file="include/footer.jsp"%>

<script language="javascript" type="text/javascript" src="js/full-calendar/fullcalendar.min.js"></script>

<script>

    var lineChartData = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [
            {
                fillColor: "rgba(220,220,220,0.5)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                data: [65, 59, 90, 81, 56, 55, 40]
            },
            {
                fillColor: "rgba(151,187,205,0.5)",
                strokeColor: "rgba(151,187,205,1)",
                pointColor: "rgba(151,187,205,1)",
                pointStrokeColor: "#fff",
                data: [28, 48, 40, 19, 96, 27, 100]
            }
        ]

    }

    var myLine = new Chart(document.getElementById("area-chart").getContext("2d")).Line(lineChartData);


    var barChartData = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [
            {
                fillColor: "rgba(220,220,220,0.5)",
                strokeColor: "rgba(220,220,220,1)",
                data: [65, 59, 90, 81, 56, 55, 40]
            },
            {
                fillColor: "rgba(151,187,205,0.5)",
                strokeColor: "rgba(151,187,205,1)",
                data: [28, 48, 40, 19, 96, 27, 100]
            }
        ]

    }

    $(document).ready(function() {
        var date = new Date();
        var d = date.getDate();
        var m = date.getMonth();
        var y = date.getFullYear();
        var calendar = $('#calendar').fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            selectable: true,
            selectHelper: true,
            select: function(start, end, allDay) {
            	
                var title = prompt('Event Title:');
                if (title) {
                	alert(title+" " +start+" "+end+" "+allDay);
                    calendar.fullCalendar('renderEvent',
                            {
                                title: title,
                                start: start,
                                end: end,
                                allDay: allDay
                            },
                            true // make the event "stick"
                    );
                }
                calendar.fullCalendar('unselect');
            },
            editable: true,
            events: [
                {
                    title: 'All Day Event',
                    start: new Date(y, m, 1)
                },
                {
                    title: 'Long Event',
                    start: new Date(y, m, d+5),
                    end: new Date(y, m, d+7)
                },
                {
                    id: 999,
                    title: 'Repeating Event',
                    start: new Date(y, m, d-3, 16, 0),
                    allDay: false
                },
                {
                    id: 999,
                    title: 'Repeating Event',
                    start: new Date(y, m, d+4, 16, 0),
                    allDay: false
                },
                {
                    title: 'Meeting',
                    start: new Date(y, m, d, 10, 	30),
                    allDay: false
                },
                {
                    title: 'Lunch',
                    start: new Date(y, m, 29, 12, 0),
                    end: new Date(y, m, d, 14, 0),
                    allDay: false
                },
                {
                    title: 'Birthday Party',
                    start: new Date(y, m, d+1, 19, 0),
                    end: new Date(y, m, d+1, 22, 30),
                    allDay: false
                },
                {
                    title: 'EGrappler.com',
                    start: new Date(y, m, 28),
                    end: new Date(y, m, 29),
                    url: 'http://EGrappler.com/'
                }
            ]
        });
    });
</script><!-- /Calendar -->

</body>
</html>