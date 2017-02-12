package com.classic;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelMaxProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Entry e = new Entry("6AM#8AM");
		Entry e1 = new Entry("7AM#3PM");
		Entry e2 = new Entry("8AM#9AM");
		Entry e3 = new Entry("7AM#10AM");
		Entry e4 = new Entry("10AM#12PM");
		Entry e5 = new Entry("11AM#1PM");
		Entry e6 = new Entry("2PM#4PM");
		Entry e7 = new Entry("1PM#4PM");
		e.toString();
		
	List<Entry> list = new ArrayList<>();
	list.add(e1);
	list.add(e);
	list.add(e3);
	list.add(e2);
	list.add(e4);
	list.add(e5);
	list.add(e6);
	list.add(e7);
	
	System.out.println( list );	
	Collections.sort(list);
	
	
	Entry pivot = list.get(0);
	Entry current= null;
	int result = 0;
	for( int i =1 ; i < list.size()  ; i++  ){
		
		current = list.get(i);
		// Check is there is any collision
		if(   pivot.starttime <= current.starttime &&  current.starttime < pivot.endtime ){
			if( pivot.duration < current.duration){
				current.duration = 0;
			}else{
				pivot.duration = 0;
				pivot = current;
			}
			continue;
			
		}
		
		pivot = current;
		
		
	}
	
	System.out.println(list);
	
	for( Entry e0 : list){
		result+= e0.duration!=0? 500: 0;
	}
	
	System.out.println( result );
	
	}

}

class Entry implements Comparable<Entry>{
	
	int duration;
	int starttime;
	int endtime;
	
	public Entry(String entry) {
		
		String timings[] = entry.split("#");
		starttime = timings[0].contains("PM") ? 
				Integer.valueOf(timings[0].substring(0, timings[0].indexOf("PM") ) ) + 12:
					Integer.valueOf(timings[0].substring(0, timings[0].indexOf("AM") ) );
		endtime = timings[1].contains("PM") ? 
				Integer.valueOf(timings[1].substring(0, timings[1].indexOf("PM") ) ) + 12:
					Integer.valueOf(timings[1].substring(0, timings[1].indexOf("AM") ) );
		
		starttime = starttime == 24? 12: starttime;
		endtime = endtime == 24? 12: endtime;	
		
		
		this.duration = endtime - starttime;
	}

	@Override
	public int compareTo(Entry o) {	
		return  this.starttime - o.starttime ;
	}

}
