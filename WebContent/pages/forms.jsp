<!DOCTYPE html>
<%@page import="vz.parser.helper.SQLHelper"%>
<%@page import="vz.DW.servlet.*"%>
<%@page import="java.sql.*"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Zepthy</title>

<!-- Popup -->
<link href="../dist/css/popup.css" rel="stylesheet">
    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

<link href="../date/htmlDatePicker.css" rel="stylesheet" />

    <!-- Timeline CSS -->
    <link href="../dist/css/timeline.css" rel="stylesheet">

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

</head>

<body>
<% //taskCreate tc=new taskCreate(); 
String emp_id=(session.getAttribute("emp_id").toString());
  	%>
    <div id="wrapper" >

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Intelligent Task Management System</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
  
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
  		        <li class="divider"></li>
                        <li><a href="index.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

<% int num=0; 
	SQLHelper help=new SQLHelper();
	
	ResultSet rs=help.SELECT("reassign", "count(*)", "manager_id="+session.getAttribute("emp_id").toString());
	if(rs.next())
	num=rs.getInt("count(*)");
%>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="dashboard.jsp"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="team.jsp"><i class="fa fa-dashboard fa-fw"></i> Team View</a>
                        </li>
                        <li>
                            <a href="reassign.jsp"><i class="fa fa-edit fa-fw"></i> Reassign Tasks [<% out.print(num); %>]</p></a>
                        </li>
                        <li>
                            <a href="forms.jsp"><i class="fa fa-edit fa-fw"></i> Create Task</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
           </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Create Task</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="../taskServlet" method="post" id="tasker">
                                        <div class="form-group">
                                            <label>Task Name</label>
                                            <input class="form-control" placeholder="Task Name" name="taskName">
                                        </div>
                                        <div class="form-group">
                                            <label>Task Description</label>
                                            <textarea class="form-control" rows="3" name="taskDesc"></textarea>
                                        </div>

                                        <div class="form-group">
                                            <label>Task Deadline</label>
                                            <input type="text" name="SelectedDate" id="SelectedDate" readonly onClick="GetDate(this);" />

                                        </div>
                                        <div class="form-group">
                                            <label>Concerns</label>
                                            <textarea class="form-control" rows="3" name="concerns" placeholder="Input E-mail ids seperated by commas"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Assignment</label>
                                            <select class="form-control" name="assignment" id="assign" onblur="checkAssignment()">
                                                <option></option>
                                                <option value="automatic">Automatic</option>
                                                <option value="manual">Manual</option>
                                            </select>
                                        </div>

                                        <div class="form-group" id="assignee">
<!-- Assignee -->							
                                        </div>


                                        <div class="form-group" id="skillset">
<!--  Skill Set  -->
                                        </div>
                                        
                                        
                                        <div class="form-group">
                                            <label>Hours Recommended per Week</label>
                                            <input class="form-control" placeholder="Recommended hours" name="hours">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Priority Level</label>
                                            <select class="form-control" name="priority">
                                                <option></option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>


                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form>
                                </div>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    
<script type="text/javascript">
function checkAssignment(){
	var x=document.getElementById("tasker").assignment.value;
	  var divTag = document.getElementById('assignee');
	  var divTag2 = document.getElementById('skillset');
	  var divContent='';
	  var divContent2=''; 
	  
	if(x=="manual"){
		divContent='<%= null %>';

}
	
else if(x=="automatic")
{
	divContent='';
	divContent2='<label>Skillset Required</label>'
+        '<div class="checkbox">'
 +   '<label>'
  +      '<input type="checkbox" name="skill1" value="Mobile">Mobile'
  +  '</label>'
+'</div>'
+'<div class="checkbox">'
 +   '<label>'
 +    '   <input type="checkbox" name="skill2" value="FIOS">FIOS TV'
 +   '</label>'
+'</div>'
+'<div class="checkbox">'
 +'   <label>'
 + '      <input type="checkbox" name="skill3" value="4G">4G'
 + '  </label>'
+'</div>'+
'<div class="checkbox">'
+   '<label>'
 +      '<input type="checkbox" name="skill4" value="Mobile">Devops'
 +  '</label>'
+'</div>'+
'<div class="checkbox">'
+   '<label>'
 +      '<input type="checkbox" name="skill5" value="Mobile">Javascript'
 +  '</label>'
+'</div>'+
'<div class="checkbox">'
+   '<label>'
 +      '<input type="checkbox" name="skill6" value="Java">Java'
 +  '</label>'
+'</div>'+
'<div class="checkbox">'
+   '<label>'
 +      '<input type="checkbox" name="skill7" value="Teradata">Teradata'
 +  '</label>'
+'</div>'+
'<div class="checkbox">'
+   '<label>'
 +      '<input type="checkbox" name="skill8" value="ASP.NET">ASP.NET'
 +  '</label>'
+'</div>'+
'<div class="checkbox">'
+   '<label>'
 +      '<input type="checkbox" name="skill9" value="HTML">HTML'
 +  '</label>'
+'</div>'+
'<div class="checkbox">'
+   '<label>'
 +      '<input type="checkbox" name="skill10" value="CSS">CSS'
 +  '</label>'
+'</div>'




;
}
divTag.innerHTML=divContent;
divTag2.innerHTML=divContent2;

}
</script>
    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

	<!-- Date Picker -->
<script language="JavaScript" src="../date/htmlDatePicker.js" type="text/javascript"></script>

	<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>-->
	<script src="../js/jquery.popup.js"></script>
	<script>
		$(function(){

			/*-------------------------------

				GENERAL EXAMPLES

			-------------------------------*/

			// Default usage
			$('.default_popup').popup();



		});

		/*---------------------

			JQUERY EASING

		*/

		$.extend($.easing, {
			easeOutBack: function (x, t, b, c, d, s) {
				if (s == undefined) s = 1.70158;
				return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
			},
			easeInBack: function (x, t, b, c, d, s) {
				if (s == undefined) s = 1.70158;
				return c*(t/=d)*t*((s+1)*t - s) + b;
			}
		});



	</script>

</body>

</html>
