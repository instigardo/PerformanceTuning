package vz.hackathon.logic;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import vz.parser.helper.SQLHelper;

public class Reassign {
	public String reassign(String id) throws SQLException{
			String taskId="";
			String name="";
			String created;
			String deadline;
			String hoursReq;
			String priority;
			String stat;
			int sta=0;
			String status="";
			String ret="";
String con="";
	    	SQLHelper help=new SQLHelper();
	    	ResultSet rsbucket=help.SELECT("reassign a, bucket b", "a.*,b.manager_id", "a.task_id=b.task_id and b.manager_id="+id);
	    	while(rsbucket.next()){
	    		taskId=rsbucket.getString("task_id");
	    		stat=rsbucket.getString("status");
	    		switch(sta)
	    		{
	    		case 1:status="In Progress";
	    		break;
	    		case 2:status="Completed";
	    		break;
	    		case 3:status="Reassigned";
	    		break;
	    		case 4:status="Failed";
	    		break;
	    		case 5:status="Elevated";
	    		break;
	    			
	    		}   		
	    				
	    		
	    			name=rsbucket.getString("name");
	    			created=rsbucket.getString("create_date");
	    			deadline=rsbucket.getString("deadline_date");
	    			hoursReq=rsbucket.getString("hours");
	    			priority=rsbucket.getString("priority");
	    			
	                ret+="<tr>"
	                +"<td>"+name+"</td>"
	                +"<td>"+taskId+"</td>"
	                +"<td>"+created+"</td>"
	                +"<td>"+deadline+"</td>"
	                +"<td>"+priority+"</td>"
	                +"<td>"+hoursReq+"</td>"
	                +"<td>"+stat+"</td>";
	                
	                if(stat.equals("E")){
                        con="<td style=\"text-align: center;\"> &nbsp;<button type=\"button\" class=\"btn btn-primary btn btn-success\" id=\""+taskId+"\" onclick=\"reassign("+taskId+") \">Reassign</i></button></td>";
                        }
                	else{
                        con="<td style=\"text-align: center;\"> &nbsp;<button type=\"button\" class=\"btn btn-primary btn btn-success disabled\" id=\""+taskId+"\" onclick=\"reassign("+taskId+") \">Reassign</i></button></td>";

                                    	}
	                
	                  ret+=con+"</tr>";
	    	}
	    	
	    		
		
	    	return ret;
		}
	}

