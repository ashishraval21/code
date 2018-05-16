package com.programming.stack;

import java.util.Stack;

public class Reverse_Stack {

static Stack<Integer>  stack = new Stack<>();
 
	static void insertAtBottom(int value) {
	
		if(stack.isEmpty()) {
			stack.push(value);
		}else {
			int x = stack.pop();
			insertAtBottom(value);
			stack.push(x);
		}
		
	}
	
	
	static void reverse() {
		if(stack.size() > 0 ) {
			
			int value = stack.peek();
			stack.pop();
			reverse();
			insertAtBottom(value);
		}
		
		
	}
	
	public static void main(String[] args) {
		 stack.push(1);
	        stack.push(2);
	        stack.push(3);
	        stack.push(4);
	         
	        System.out.println("Original Stack" + stack.peek());
	         
	        System.out.println(stack);
	         
	        //function to reverse the stack
	        reverse();
	         
	        System.out.println("Reversed Stack"+stack.peek());
	         
	        System.out.println(stack);
		
		
	}
}

