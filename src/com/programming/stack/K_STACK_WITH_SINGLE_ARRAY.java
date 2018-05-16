package com.programming.stack;

/*
 * How to efficiently implement k stacks in a single array
 */
public class K_STACK_WITH_SINGLE_ARRAY {
	
	static class KStack{
		int arr[], next[], top[], n, k, free;
		
		public KStack(int k, int n) {
			arr= new int[n];
			next = arr;
			top = new int[k];
			this.n = n;
			this.k = k;
			free= 0;
			
			for(int i=0; i <k; i++) {
				top[i] = -1;
			}
			
			for(int i=0; i<n; i++) {
				next[i] = i+1;
			}
			
			next[n-1] = -1; // indicate end of free list;
			
			
		}
		
		boolean isFull() {
			return (free == -1);
		}
		
		
		void push (int stackNo, int data) {
			
			if(isFull()) {
				System.out.println( " Stack Overflow "); return;
			}
			
			int  i = free;
			
			free = next[i];
			
			next[i] = top[stackNo];
			top[stackNo] = i;
			
			arr[i] = data;
		}
		
		
		int pop (int stackNo) {
			
			if(isEmpty(stackNo))
			{
				System.out.println("Stack Underflow");
				return 0;
			}
			
			int i = top[stackNo];
			top[stackNo] = next[i];
			
			next[i] = free;
			free = i;
			return arr[i];
			
			
		}

		boolean isEmpty(int stackNo) {
			return (top[stackNo] == -1);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
