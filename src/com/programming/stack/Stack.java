package com.programming.stack;

import java.util.Arrays;
import java.util.Scanner;

public class Stack {
	int top = -1;
	static int a[];
	static int max;
	
	
	
	
 private boolean push(int data) {
	 if(isFull()) {
		 System.out.println("Overflow Error");
		 return false;
		}
	 else {
		 a[++top] = data;
		 return true;
	 }
		 
 }

 private int pop() {
	 if(isEmpty() )
	 {
		 System.out.println("Underflow error");
		 return 0;
	 }else
		 return a[top--];

	
 }
 
 private boolean isEmpty() {
	 
	 return top==-1;
 }
 
 private boolean isFull() {
	 return top==(max-1);
 }
 
 
 private String display() {
	return  Arrays.toString(Arrays.copyOfRange(a, 0, top+1));
 }
 
  public static void main(String args[]) {
	 System.out.println("Enter max value : ");
	 Scanner sc = new Scanner(System.in);
	  max = sc.nextInt();
	  a = new int[max];
	  Stack s = new Stack();
	  System.out.println(s.pop());
	  System.out.println(s.push(12));
	  System.out.println(s.push(15));
	  System.out.println(s.push(20));
	  System.out.println(s.pop());
	  System.out.println(s.display());
	  System.out.println(s.push(30));
	  System.out.println(s.push(50));
	  System.out.println(s.display());
	  System.out.println(s.pop());
	  System.out.println(s.pop());
	  System.out.println(s.display());

	  sc.close();
	  
	  
	  
	  
	 
	 
  }
}
