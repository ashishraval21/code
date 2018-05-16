package com.programming.SLL;

public class SLL {
	
	Node head;
	
	
	SLL(){
		head = null;
		
	}
	
	public void InsertAtEnd(int data) {
		
		Node node = new Node(data);
		if(isEmpty()) {
			head = node;
		}else {
			Node temp = head ;
			
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next= node;
			
		}
			
		
	}
	
	public void InsertAtPosition(int data, int position) {
		
			Node node = new Node(data);
			Node temp = head;
			int t=1;
			while(t < position - 1) {
				temp = temp.next;
				t++;
			}
			node.next = temp.next;
			temp.next = node;
			
	}
	
	public boolean deleteAtPosition(int position) {
	
		if(position == 1) {
			head = head.next;
			return true;
			
		}else {
			Node temp = head;
			Node prev = null;
			int t = 1;
			while( t < position) {
				t++;
				prev = temp;
				temp = temp.next;
				
			}
			
			prev.next = temp.next;
			return true;
		}
		
	}
	
	public void display() {
		Node temp = head ;
		 while(temp != null) {
			 System.out.print(temp.data+ "   ");
			 temp = temp.getNext();
		 }
	}
	
	public boolean search(int data ) {
		Node temp = head ;
		 while(temp.getNext() != null) {
			 if(temp.getData() == data)
				 return true;
			 
			 temp = temp.getNext();
			 
		 }
		 
		 return false;
		
	}
	
	
	public void reverseList() {
		
		Node prev = null;
		Node current = head;
		Node next;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev =current;
			 current = next; 
		}
		
		head = prev;
		
	}
	
	
	public void removeDuplicate() {
		
		Node current = head;
		Node next;
		
		
		
		while(current != null) {
			next = current.next;
			
			while(next != null && next.data == current.data) {
				next = next.next;
				current.next = next;
			}
			current = next;
		}
	}
	
	
	public boolean isEmpty() {
		return head ==null;
	}

}
