package com.programming.queue;

public class QueueUsingList {
	Node front, rear;
	
	
	class Node{
		Node next;
		int value;
		
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	
	public void enqueue(int value) {
		Node node = new Node(value);
		
		if(this.rear == null) {
			this.rear = this.front = node;
			return;
		}
		// set next node to newNode
		this.rear.next = node;
		// set rear pointer to newNode
		this.rear = node;
		
		
	}
	
	public Node dequeue() {
		if(this.front == null)
			return null;
		// get front node 
		Node  removed = this.front;
		// update front pointer to next node.
		this.front = this.front.next;
		
		// If front becomes NULL, then change rear also as NULL
        if (this.front == null)
           this.rear = null;
   
		
		return removed;
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		QueueUsingList qul = new QueueUsingList();
		qul.enqueue(12);
		qul.enqueue(123);
		qul.enqueue(1);
		qul.enqueue(2);
		qul.enqueue(3);
		qul.enqueue(12345);
		
		System.out.println("Dequeued item is "+ qul.dequeue().value);
		System.out.println("Dequeued item is "+ qul.dequeue().value);
		System.out.println("Dequeued item is "+ qul.dequeue().value);
		
	}

}
