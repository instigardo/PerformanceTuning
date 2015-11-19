/**
 * 
 */
package vz.DW.Rules;

import vz.parser.parse.Parse;

/**
 * @author SAXENHI
 *
 */
public class Rules {
	Parse parse=new Parse();
	public void rule_5_FunctionsInConditions(String sqlText)
	{
		sqlText=parse.formatter(sqlText);
		//sqlText=parse.resolver(sqlText);
		System.out.println(sqlText);
		
	}
}
