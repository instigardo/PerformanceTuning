<!DOCTYPE html>
<%@page import="vz.parser.helper.SQLHelper"%>
<%@page import="vz.hackathon.logic.EmployeeInfo"%>
<%@page import="vz.parser.helper.Identifier"%>
<html lang="en">

<head>
<%@ page import="vz.DW.servlet.*" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Zepthy</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="../dist/css/timeline.css" rel="stylesheet">
    
        <!-- DataTables CSS -->
    <link href="../bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="../bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">
    

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif] -->
    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script>
    $(document).ready(
            function() {
                setInterval(function() {
                    var randomnumber = Math.floor(Math.random() * 100);
                    //populate();
                    //$('#morris-donut-chart').text;
                }, 3000);
            });
</script>

</head>

<body>

    <div id="wrapper" >

   
        <!-- Page Content -->
        <div id="page-wrapper" style="margin: 0 0 0 0">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"> Page Under Construction </h1>
                 </div>
                   
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
	</div>
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
    
    	<script type="text/javascript">

	function elevate(taskid,id,stat,create_date,deadline_date,priority,name,hour,manager)
		{
		
		$.ajax({
		    type: "GET",
		    url: "../ElevateServlet",
		    data:{
		    	server_task_id:taskid,
		    	server_emp_id:id,
		    	server_task_status:stat,
		    	server_create_date:create_date,
		    	server_deadline_date:deadline_date,
		    	server_priority:priority,
		    	server_task_name:name,
		    	server_hour:hour,
		    	server_manager:manager
		    },
		    success: function(data) {
		    	alert("Elevated");
		    	
		        $('#results').html(data);
		    }
		});
	}
	</script>

</body>

</html>

