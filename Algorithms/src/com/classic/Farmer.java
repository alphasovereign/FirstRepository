package com.classic;

import java.text.DecimalFormat;

public class Farmer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "10,10,5,2,2,3,1,14,25";
		String input[] = s.split(",");
		
		double land = Double.valueOf(input[0]);
		double F =  Double.valueOf(input[1]);
		double P =  Double.valueOf(input[2]);
		
		double wF =  Double.valueOf(input[3]);
		double wP =  Double.valueOf(input[4]);
		
		double rF =  Double.valueOf(input[5]);
		double rP =  Double.valueOf(input[6]);
		
		double wC =  Double.valueOf(input[7]);
		double rC =  Double.valueOf(input[8]);

		Double wA =  Math.min((F/wF) , (P/wP) ) ;//* wC;
		Double rA =  Math.min((F/rF) , (P/rP) ) ;//* rC;

		Double maxProfit = Double.valueOf(0);
		
		StringBuffer st = new StringBuffer();
		if((wA*wC) == ( rA*rC) ){
			
			System.out.println("NO");
			return;
		}
		
		
		maxProfit = Math.max((wA*wC) , ( rA*rC) );
		if( (wA*wC) > ( rA*rC) ){
			rA = Double.valueOf(0);
		}else{
			wA = Double.valueOf(0);
		}
		
		
		
		
		DecimalFormat df = new DecimalFormat("#.##");      
		rA = Double.valueOf(df.format(rA));
		wA = Double.valueOf(df.format(wA));
		maxProfit = Double.valueOf(df.format(maxProfit));
		
		st.append(  get2Decimal(maxProfit)  ); st.append(',');
		st.append( get2Decimal( wA  ) );st.append(',');
		st.append( get2Decimal( rA  ) );
		System.out.println(  st.toString() );
	}
	
	
	public static String get2Decimal(Double d){
		
		String s = d.toString();
		s = s.substring(s.lastIndexOf("."), s.length());
		s = s.length() == 2 ?  d.toString()+"0": d.toString();
		
		return s;
	}

}
