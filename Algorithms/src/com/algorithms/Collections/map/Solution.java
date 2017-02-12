package com.algorithms.Collections.map;

import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public Solution(String magazine, String note) {
        
    	magazineMap = new HashMap<String, Integer>();
    	noteMap = new HashMap<String, Integer>();
         System.out.println(magazine +": "+note);
         Integer i ;
          for(  String s :  magazine.split(" ") ){
              
        	  if( (i = magazineMap.get(s)) == null )
              magazineMap.put( s, 0 );
        	  else
        		  magazineMap.put( s, ++i );
        	  
          }
        System.out.println( magazineMap );
           for(  String s :  note.split(" ") ){
        	  
        	   if( (i = noteMap.get(s)) == null )
        		   noteMap.put( s, 0 );
             	  else
             		 noteMap.put( s, ++i );
          }
        
        System.out.println( noteMap );
    }
    
    public boolean solve() {
    	
    	 for(  String s :  noteMap.keySet() ){
    		 
    		   if (noteMap.get(s).intValue() <=     magazineMap.get(s).intValue()  )
    			   continue;
    		   return false;
    	 }
    	
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}


