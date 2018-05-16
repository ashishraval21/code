package com.programming.queue;

import java.util.Scanner;

public class Queue {

	int front, rear, size, length;
	int max;
	int[] queue;
	 
	
	Queue(int n ){
		front = 0;
		rear = -1;
		size = n;
		queue = new int[size];
		length = 0;
		max = n;
		
		
	}
	
	int peek() {
		return queue[front];
	}
	
	
	boolean isFull() {
		return rear == (max - 1);
	}
	
	
	boolean isEmpty() {
		return front < 0 || front > rear ;
	}
	
	boolean enQueue(int data)
	{
		
		if(isFull())
			return false;
		
		rear+=1;
		queue[rear]=data;
		return true;
		
	}
	
	int deQueue() {
		if(isEmpty())
			return 0;
		int data = queue[front];
		front+=1;
		return data;
		
	}
	
	
	public static void main(String[] args) {
		System.out.print("Enter Queue Size :");
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Queue queue2 = new Queue(t)	;
		System.out.println("deque " +queue2.deQueue());
		System.out.println("enque " +queue2.enQueue(10));
		System.out.println("enque " +queue2.enQueue(20));
		System.out.println("enque " +queue2.enQueue(30));
		System.out.println("deque " +queue2.deQueue());
		System.out.println("deque " +queue2.deQueue());
		System.out.println("deque " +queue2.deQueue());
		System.out.println("deque " +queue2.deQueue());
		
		
		
		
		
		
	}
	
	
}
