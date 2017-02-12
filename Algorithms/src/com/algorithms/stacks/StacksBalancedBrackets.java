package com.algorithms.stacks;

import java.util.Stack;

public class StacksBalancedBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static boolean hasBal(String expression){
		
		Stack<String> stack = new Stack();
		
		for( int i =0 ; i < expression.length() ; i++){
			if( expression.charAt(i) == '{' ){
				stack.push("}");
			}
			if( expression.charAt(i) == '[' ){
				stack.push("]");
			}
			if( expression.charAt(i) == '(' ){
				stack.push(")");
			}else{
				
				if( stack.isEmpty() || stack.pop().charAt(0) == expression.charAt(i) ){
					return false;
				}
			}

		}
		
		
		
		return true;
	}

}
