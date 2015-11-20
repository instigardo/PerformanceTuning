/**
 * 
 */
package vz.DW.Servlets_n_Main;

import java.io.IOException;

import vz.DW.Rules.Rules;

/**
 * @author SAXENHI
 *
 */
public class ScoreMain {
	static int score=0;
	int mm=1;
	
	static String tbContent="";
	
	public String getTbContent() {
		return tbContent;
	}
	public void setTbContent(String tbContent) {
		this.tbContent = tbContent;
	}
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	public int getScoreMM() {
		return mm;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	public String getTable()
	{
		
		String table="<div class=\"panel panel-default\">"
				+ "<div class=\"panel-heading\">"
						+ "<i class=\"fa fa-sign-out  fa-fw\"></i> Sql Performance Report"
								+ "<div id=\"show\">"
										+ "</div>"
										+ "</div>"
										+ "<div class=\"panel-body\">"
										+"<table class=\"table table-striped table-bordered table-hover\" id=\"dataTables-example\">"
										+ "<th>"
										+ "Rule"
										+ "</th>"
										+ "<th>"
										+ "Code Snipet"
										+ "</th>"
										+ "<th>"
										+ "Score"
										+ "</th>"
										+ getTbContent()
												+ "</table>"
												+ "</div>"
												+ "</div>";
		return table;
	}
	Rules rule=new Rules();

	public void scoreParameterCalc(String sql) throws IOException
	{

		score=0;
		mm=1;
		if(rule.rule_5_FunctionsInConditions(sql));
		score++;
		
		//System.out.println(rule.getRule5rslt());
		
		tbContent="<tr>"
				+ "<td>"
				+ "Rule 5"
				+ "</td>"
				+ "<td>"
				+ rule.getRule5rslt()
				+ "</td>"
				+ "<td>"
				+ score
				+"</td>"
				+ "</tr>";
		tbContent=tbContent.replace("'", "\"");
		setTbContent(tbContent);
		setScore(score);
	}
}
