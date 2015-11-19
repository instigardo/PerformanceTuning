/**
 * 
 */
package vz.DW.Servlets_n_Main;

/**
 * @author SAXENHI
 *
 */
public class ScoreMain {
	int score=40;
	int mm=100;
	
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
												+ "</table>"
												+ "</div>"
												+ "</div>";
		return table;
	}
	public void scoreParameterCalc()
	{
		
	}
}
