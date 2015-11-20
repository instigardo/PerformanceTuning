/**
 * 
 */
package vz.DW.Rules;

import java.io.IOException;

import vz.parser.parse.Parse;

/**
 * @author SAXENHI
 *
 */

public class Rules {
	boolean rule5=false;
	static String rule5rslt="";
	Parse parse=new Parse();
	public boolean rule_5_FunctionsInConditions(String sqlText) throws IOException
	{
		int count=0;
		String subStr="";
		String subStrArr[]=new String[50000];
		sqlText=parse.formatter(sqlText);
		String keywords[]=parse.getKeywords();
		String[] sqlWords=parse.sqlWordExtractor(sqlText);
		String extractedKeywords[]=parse.extractKeywords(sqlText,keywords);
		int ids[]=parse.getIds();
		//sqlText=parse.resolver(sqlText);
		System.out.println(sqlText);
		for (int i = 0; i < ids.length; i++) {
			if(extractedKeywords[i]!=null)
			{
				if(extractedKeywords[i].equals("ON")){
					int endId=ids[i+1];
					for (int j = 0; j < extractedKeywords.length-i; j++) {
						if(extractedKeywords[i+j].equals("JOIN")||extractedKeywords[i+j].equals("WHERE")){
							//System.out.println(extractedKeywords[i+j]);
							endId=ids[i+j];
							break;
						}
					}
						
					for (int j = ids[i]+1; j < endId; j++) {
						subStr+=sqlWords[j]+" ";
					}
					//System.out.println(extractedKeywords[i]);
					//System.out.println(subStr.trim());
					
				}
				subStrArr[count]=subStr.trim();
				if(!subStr.equals(""))
				rule5rslt+=subStr+"... ";
				subStr="";
				count++;
			}
		}
		for (int i = 0; i < subStrArr.length; i++) {
			if(subStrArr[i]!=null){
				
			if(subStrArr[i].contains("COALESCE")||subStrArr[i].contains("TRIM")){
				rule5=false;
				break;
			}
			else
				rule5=true;
		}
		}
		return rule5;
	}
	
	public static String getRule5rslt() {
		return rule5rslt;
	}

	static String sqlText="INSERT INTO EDW_SUM_VW.VOL_CRNT_BILLED_CNT  (  CUST_ACCT_SK, SUB_SEG_CODE, CIR_TYPE_GRP, CUSTID_TYPE, CUST_NAME, PROD_YR_MTH, SRC_SYS_NBR, CIR_ID, CIR_CHRG_CAT, BAN_CUST_ACCT_NBR, LVL_4_PRD_ID, ISO_CNTRY_CODE, CRCTP, CIR_SPEED, CUST_ACCT_GRP_CODE, VGE_CNV_VAL, INSTL_FLG, RCURG_FLG, DCNCT_FLG, RECNCT_FLG, MGRTN_FLG, TOT_CNT, NET_ADDS, CRNT_MRC_AMT, FUTR_MRC_AMT, PRIOR1_MRC_AMT, PRIOR2_MRC_AMT, ALL_PRIOR_MRC_AMT, NON_CRNT_MRC_AMT, TOT_MRC_AMT, CRNT_NRC_AMT, FUTR_NRC_AMT, PRIOR1_NRC_AMT, PRIOR2_NRC_AMT, ALL_PRIOR_NRC_AMT, NON_CRNT_NRC_AMT, TOT_NRC_AMT, TOT_AMT, BNDL_ID, SLTN_NAME, INSERT_TMS, UPDATE_TMS, E2EI_IND, SRC_IND  )  SEL CUST_ACCT_SK, SUB_SEG_CODE, CIR_TYPE_GRP, CUSTID_TYPE, CUST_NAME, PROD_YR_MTH, SRC_SYS_NBR, CIR_ID, COALESCE ( CIR_CHRG_CAT,'NA' ) , CUST_ACCT_NBR, L4_PROD_ID, 840 AS ISO_CNTRY_CODE, COALESCE ( CRCTP,'NA' ) , COALESCE ( CIR_SPEED,0 ) , CUST_ACCT_GRP_CODE, COALESCE ( VGE_CNV_VLU,0 ) , 0 AS INSTL_FLG, 0 AS RCURG_FLG, 0 AS DCNCT_FLG, 0 AS RECNCT_FLG, 0 AS MGRTN_FLG, 0 AS TOT_CNT, 0 AS NET_ADDS, CRNT_MRC_AMT, FUTR_MRC_AMT, PRIOR1_MRC_AMT, PRIOR2_MRC_AMT, PRIOR1_MRC_AMT+PRIOR2_MRC_AMT AS ALL_PRIOR_MRC_AMT,  ( FUTR_MRC_AMT+PRIOR1_MRC_AMT+PRIOR2_MRC_AMT )  AS NON_CRNT_MRC_AMT,  ( FUTR_MRC_AMT+CRNT_MRC_AMT+PRIOR1_MRC_AMT+PRIOR2_MRC_AMT )  AS TOT_MRC_AMT, CRNT_NRC_AMT, FUTR_NRC_AMT, PRIOR1_NRC_AMT, PRIOR2_NRC_AMT,  ( PRIOR1_NRC_AMT+PRIOR2_NRC_AMT )  AS ALL_PRIOR_NRC_AMT,  ( FUTR_NRC_AMT+PRIOR1_NRC_AMT+PRIOR2_NRC_AMT )  AS NON_CRNT_NRC_AMT,  ( FUTR_NRC_AMT+CRNT_NRC_AMT+PRIOR1_NRC_AMT+PRIOR2_NRC_AMT )  AS TOT_NRC_AMT,  ( FUTR_MRC_AMT+CRNT_MRC_AMT+PRIOR1_MRC_AMT+PRIOR2_MRC_AMT+FUTR_NRC_AMT+CRNT_NRC_AMT+PRIOR1_NRC_AMT+PRIOR2_NRC_AMT )  AS TOT_AMT, BNDL_ID, SLTN_NAME, CURRENT_TIMESTAMP ( 0 ) , CURRENT_TIMESTAMP ( 0 ) , E2EI_IND, SRC_IND FROM  (  SEL A.CUST_ACCT_SK, NULL AS SUB_SEG_CODE, NULL AS CIR_TYPE_GRP, NULL AS CUSTID_TYPE, NULL AS CUST_NAME, A.PROD_YR_MTH, A.SRC_SYS_NBR, A.CIR_ID, A.CIR_CHRG_CAT, A.CUST_ACCT_NBR, D.L4_PROD_ID, A.CRCTP, A.CIR_SPEED, A.CUST_ACCT_GRP_CODE, F.VGE_CNV_VLU, SUM (  CASE WHEN  (   (  EXTRACT  (  MONTH FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  -  ( EXTRACT  ( MONTH FROM A.CHRG_FROM_DT  )   )  + 12 *  (  EXTRACT  (  YEAR FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  - EXTRACT  (  YEAR FROM A.CHRG_FROM_DT  )   )   )   )  = 0 AND CHRG_BASIS_CODE <> 'N' THEN COALESCE ( NET_AMT,0 )  ELSE 0 END  ) AS CRNT_MRC_AMT, SUM ( CASE WHEN  (   (  EXTRACT  (  MONTH FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  -  ( EXTRACT  ( MONTH FROM A.CHRG_FROM_DT  )   )  + 12 *  (  EXTRACT  (  YEAR FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  - EXTRACT  (  YEAR FROM A.CHRG_FROM_DT  )   )   )   )  <=-1 AND CHRG_BASIS_CODE <> 'N' THEN COALESCE ( NET_AMT,0 )  ELSE 0 END  )  AS FUTR_MRC_AMT, SUM ( CASE WHEN  (   (  EXTRACT  (  MONTH FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  -  ( EXTRACT  ( MONTH FROM A.CHRG_FROM_DT  )   )  + 12 *  (  EXTRACT  (  YEAR FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  - EXTRACT  (  YEAR FROM A.CHRG_FROM_DT  )   )   )   )  =1 AND CHRG_BASIS_CODE <> 'N' THEN COALESCE ( NET_AMT,0 )  ELSE 0 END  )  AS PRIOR1_MRC_AMT, SUM ( CASE WHEN  (   (  EXTRACT  (  MONTH FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  -  ( EXTRACT  ( MONTH FROM A.CHRG_FROM_DT  )   )  + 12 *  (  EXTRACT  (  YEAR FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  - EXTRACT  (  YEAR FROM A.CHRG_FROM_DT  )   )   )   )  >1 AND CHRG_BASIS_CODE <> 'N' THEN COALESCE ( NET_AMT,0 )  ELSE 0 END  )  AS PRIOR2_MRC_AMT, SUM (  CASE WHEN  (   (  EXTRACT  (  MONTH FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  -  ( EXTRACT  ( MONTH FROM A.CHRG_FROM_DT  )   )  + 12 *  (  EXTRACT  (  YEAR FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  - EXTRACT  (  YEAR FROM A.CHRG_FROM_DT  )   )   )   )  = 0 AND CHRG_BASIS_CODE = 'N' THEN COALESCE ( NET_AMT,0 )  ELSE 0 END  ) AS CRNT_NRC_AMT, SUM ( CASE WHEN  (   (  EXTRACT  (  MONTH FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  -  ( EXTRACT  ( MONTH FROM A.CHRG_FROM_DT  )   )  + 12 *  (  EXTRACT  (  YEAR FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  - EXTRACT  (  YEAR FROM A.CHRG_FROM_DT  )   )   )   )  <=-1 AND CHRG_BASIS_CODE = 'N' THEN COALESCE ( NET_AMT,0 )  ELSE 0 END  )  AS FUTR_NRC_AMT, SUM ( CASE WHEN  (   (  EXTRACT  (  MONTH FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  -  ( EXTRACT  ( MONTH FROM A.CHRG_FROM_DT  )   )  + 12 *  (  EXTRACT  (  YEAR FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  - EXTRACT  (  YEAR FROM A.CHRG_FROM_DT  )   )   )   )  =1 AND CHRG_BASIS_CODE = 'N' THEN COALESCE ( NET_AMT,0 )  ELSE 0 END  )  AS PRIOR1_NRC_AMT, SUM ( CASE WHEN  (   (  EXTRACT  (  MONTH FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  -  ( EXTRACT  ( MONTH FROM A.CHRG_FROM_DT  )   )  + 12 *  (  EXTRACT  (  YEAR FROM CAST ( CAST (   ( A.PROD_YR_MTH * 100 + 01 )  AS CHAR ( 8 )   )  AS DATE FORMAT 'YYYYMMDD'  )   )  - EXTRACT  (  YEAR FROM A.CHRG_FROM_DT  )   )   )   )  >1 AND CHRG_BASIS_CODE = 'N' THEN COALESCE ( NET_AMT,0 )  ELSE 0 END  )  AS PRIOR2_NRC_AMT, A.BNDL_ID, A.SLTN_NAME , A.E2EI_IND, 'VZB' AS SRC_IND FROM EDW_TEMP.VOL_CRNT_BILLED_CIR A JOIN EDW_BASE_VW.BILL_IND_SET_HIST C ON C.BILL_IND_SET_ID= A.BILL_IND_SET_ID AND C.END_REV_YM IS NULL AND C.END_DATE IS NULL JOIN EDW_SUM_VW.PROD_HIER_LVL_HIST D ON D.L8_PROD_ID =C.PROD_ID JOIN EDW_SUM_VW.INT_RPTG_MTH RM ON RM.CLOSE_YR_MTH=D.PROD_YEAR_MONTH AND RM.CURR_MTH_IND = 'Y' JOIN EDW_METADATA_VW.CIR_PRD G ON D.L4_PROD_ID=G.LVL_4_PRD_ID AND A.CIR_CHRG_CAT<>G.CIR_PRD LEFT OUTER JOIN EDW_METADATA_VW.VGE_CNV F ON A.CRCTP=F.RPTG_CIR_TYPE AND  ( A.CIR_SPEED>=F.MIN_SPEED AND A.CIR_SPEED<=F.MAX_SPEED )  WHERE A.PROD_YR_MTH= (  SEL CAST ( CAST ( CAST ( ADD_MONTHS ( CAST  ( CAST ( MAX ( CLOSE_YR_MTH )  AS VARCHAR ( 15 )  ) ||'01' AS DATE FORMAT 'YYYYMMDD' ) ,-04 )  AS DATE FORMAT 'YYYYMM' )  AS VARCHAR ( 10 )  )  AS INTEGER )  AS PROD_YR_MNTH FROM EDW_SUM_VW.INT_RPTG_MTH WHERE CURR_MTH_IND='Y'  )  AND A.NET_AMT<>0 GROUP BY CUST_ACCT_SK, SUB_SEG_CODE, CIR_TYPE_GRP, CUSTID_TYPE, CUST_NAME, A.PROD_YR_MTH, A.SRC_SYS_NBR, A.CIR_ID, A.CIR_CHRG_CAT, A.CUST_ACCT_NBR, D.L4_PROD_ID, A.CRCTP, A.CIR_SPEED, A.CUST_ACCT_GRP_CODE, F.VGE_CNV_VLU, A.BNDL_ID, A.SLTN_NAME, A.E2EI_IND, SRC_IND  )  AA ;  ";
	public static void main(String[] args) throws IOException {
		Rules rule=new Rules();
		//System.out.println(rule.rule_5_FunctionsInConditions(sqlText));
		
	}
}
