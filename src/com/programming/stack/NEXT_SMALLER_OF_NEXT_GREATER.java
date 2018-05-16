package com.programming.stack;

import java.util.Stack;

public class NEXT_SMALLER_OF_NEXT_GREATER {

	static void nextGreater(int[] value , int n , int next[], char order){
		Stack<Integer> st = new Stack<>();
		
		// {5, 1, 9, 2, 5, 1, 7};
		for (int i = n -1  ; i >= 0 ; i--) {
			
			
			while(!st.empty() && ((order == 'G' )? value[st.peek()] <= value[i]
					:  value[st.peek()] >= value[i]))
			{
				st.pop();
				
			}
				
			if(!st.empty()) {
				
				next[i] = st.peek();
				
			}else {
				next[i] = -1;
			}
				
			
			st.push(i);
				// st   : 5
				// next : -1,-1
		}
		
		
		
		st.clear();
	}
	
	
	
	
	static void nextSmallerOfNextGreater(int[] value ,int n ) {
		int[] NS = new int[n];
		int[] NG =  new int[n];
		
	
		
		nextGreater(value, n, NG, 'G');
		nextGreater(value, n, NS, 'S');
		
		for(int i = 0; i < n ;i++) {
			if(NG[i] != -1 && NS[NG[i]] != -1) {
				System.out.println(value[i]+"  --- > "+NG[i]+"     "+value[NS[NG[i]]] );
			}else {
				System.out.println(value[i]+"-------------------->  -1");
			}
		}
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		int arr[] = {5, 1, 9, 2, 5, 1, 7};
	    int n =arr.length;
	    nextSmallerOfNextGreater(arr, n);
	   

	}

}
