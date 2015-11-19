/**
 * 
 */
package vz.DW.Rules;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vz.parser.helper.ReadExcel;
import vz.parser.helper.SQLHelper;
import vz.parser.parse.Parse;
import vz.parser.parse.SQLResolver;

/**
 * @author SAXENHI
 *
 */
public class GetSql {
/**
 * Global Variables with Setters and Getters	
 */
	
	String sqlText="";
	ArrayList<String> sqlList=new ArrayList<String>();

	
public ArrayList<String> getSqlList() {
		return sqlList;
	}

	public void setSqlList(ArrayList<String> sqlList) {
		this.sqlList = sqlList;
	}

public String getSqlText() {
	return sqlText;
}

public void setSqlText(String sqlText) {
	this.sqlText = sqlText;
}

/**
 * 	Object Creation of Required Classes
 */
	ReadExcel rx=new ReadExcel();
	Parse parse=new Parse();
	SQLResolver resolver=new SQLResolver();
	SQLHelper help=new SQLHelper();
	
	public boolean sqlFromDB() throws SQLException
	{
		ResultSet rs=help.SELECTNW("edw_offshore_metadata_vw.sql_tmp", "sql_text");
		ArrayList<String> a1=new ArrayList<String>();
		ArrayList<String> sql=new ArrayList<String>();
		while(rs.next()){
			a1.add(rs.getString("sql_text"));
		}
		for (String string : a1) {
			sql.add(string);
		}
		setSqlList(sql);
		return true;
	}
	
	public boolean sqlFromExcel()
	{
		rx.excel();
		ArrayList<String> sql=new ArrayList<String>();
		String[] id=rx.getSqlId();		
		for (int i = 0; i < id.length; i++) 
		{
			sql.add(rx.getSql()[i]);
		}
		setSqlList(sql);
		return true;
	}
	
	public boolean sqlFromServlet(String sqlTxt)
	{
		setSqlText(sqlTxt);
		return true;
	}
	
	
}
