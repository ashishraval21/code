package com.programming.stack;

import java.util.ListIterator;
import java.util.Stack;

public class Sorted_Stack {
	static java.util.Stack<Integer> stack = new Stack<>();
	
	
	static void SortedStack(int value) {
		if(stack.isEmpty() || value > stack.peek()) {
			stack.push(value);
			 return;
		}
		
		int temp = stack.pop();
		SortedStack(value);
		stack.push(temp);
		
	}
	
	
	
	static void sortStack() {
		if(stack.size() > 0 ) {
			int x = stack.pop();
			sortStack();
			SortedStack(x);
		}
		
	}
	
	
	static void printStack() {
		
		ListIterator<Integer> li = stack.listIterator();
		while(li.hasNext())
			li.next();
		
		while(li.hasPrevious())
			System.out.print(li.previous()+" ");
	
	}
	
	
	
	
	public static void main(String[] args) {
	
		stack.push(25);
		stack.push(5);
		stack.push(2);
		stack.push(-25);
		stack.push(-5);
		
		
		System.out.print("Original Stack -- > ");printStack();
		sortStack();
		System.out.print("\n Sorted Stack -- > ");
		printStack();
		
	}

}
