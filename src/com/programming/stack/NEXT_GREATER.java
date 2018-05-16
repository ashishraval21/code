package com.programming.stack;

public class NEXT_GREATER {

	static class stack{
		int top;
		int items[] = new int[100];
		
		void push(int data) {
			if(top == items.length) {
				System.out.println("Stack Overflow");
				return ;
			}
			items[++top] = data;
			
		}
		int pop() {
			if(top == -1) {
				System.out.println("Stack Underflow");
				return 0;
			}
			
			return items[top--];
		}
		boolean isEmpty() {
			return  (top == -1);
		}
	}
	
	static void NextGreaterElement(int[] arr) {
		int n = arr.length;
		stack s = new stack();
		s.top = -1;
		s.push(arr[0]);
		int element, next;
		
		for(int i = 1; i < n; i++) {
			next = arr[i];
			
			if(!s.isEmpty()) {
				element = s.pop();
				
				while( next > element) {
					System.out.println(element+" - -- - - > "+next);
					if(s.isEmpty())
						break;
					element = s.pop();
				}
				if(element > next) {
					s.push(element);
				}
				
			}
			
			s.push(next);
		}
		
		while (!s.isEmpty()) {
			element = s.pop();
			System.out.println(element+" - -- - - > "+-1);
			
			
		}
		
	}
	
	
	public static void main(String[] args) {
		int arr[] = { 11, 10, 9, 8 , 5, 12, 3, 4, 15 };
        int n = arr.length;
        NextGreaterElement(arr);

	}

}

