package com.algorithms.Collections.linkedList;

public class DetectCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node b = new Node();
		
		Node a = new Node();
		a.data = 1;
		b.next = a;
		a.next = b;
		b.data = 2;
		
		
		DetectCycle c = new DetectCycle();
		
		System.out.println(  c.hasCycle(a) );

	}
	
	/*
	Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

	A Node is defined as: 
	    class Node {
	        int data;
	        Node next;
	    }
	*/

	boolean hasCycle(Node head) {

	    if( head.next == null){
	        return false;
	    }else{
	        
	        Node slow = head.next;
	        Node fast = head.next.next;
	        
	        if(fast == null ){
	        	return false;
	        }
	        
	        
	        while(true){
	        	
	        	if( slow!=null && fast!= null && slow == fast ){
	        		return true;
	        	}
	        	
	        	if( fast == null ){
	        		return false;
	        	}

	        	slow = slow.next;
	        	fast = fast.next.next;
	        }
	        
	        
	    }
	    
	    //return false;
	    
	}



}


class Node {
    int data;
    Node next;
}
