package com.programming.stack;

import java.util.Stack;

/*
 * Design a stack that supports getMin() in O(1) time and O(1) extra space
 */
public class GET_MIN_USING_STACK {

	
	
	Stack<Integer> stack;
	int min;
	
	public GET_MIN_USING_STACK() {
		stack = new Stack<>();
	}
	
	
	void getMin() {
		if(stack.isEmpty())
			System.out.println("stack is  Empty");
		else
			System.out.println("Mimimum values is "+min);
		
	}
	
	void push(int data) {
		if(stack.isEmpty()) {
			stack.push(data);
			min = data;
			System.out.println("Inserted Element is :" + data);
			return;
		}
		if (data < min) {
			stack.push((2*data) - min);
			min = data;
		} else 
			stack.push(data);
		System.out.println("Inserted Element is :" + data);
	}
	
	void pop() {
		if(stack.isEmpty()) {
			System.out.println(" stack is underflow");
			 return;
			 
		}
		int data = stack.pop();
		
		if(data < min) {
			// minimum will change as the minimum 
			// element  of the stack is being removed. 
			System.out.println("pop element " + min);
			min = (2*min - data);
		}
		else 
			System.out.println("pop element " +data);
	}
	
	void peek() {
		
	}

	
	
	
	public static void main(String[] args) {
		GET_MIN_USING_STACK s = new GET_MIN_USING_STACK() ;
		s.push(10);
		s.push(20);
		s.push(9);
		s.getMin();
		s.pop();
		s.getMin();
		s.push(5);
		s.getMin();
		s.push(2);
		s.getMin();
		s.pop();s.getMin();
	}

	
}
