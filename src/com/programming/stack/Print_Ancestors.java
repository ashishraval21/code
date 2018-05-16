package com.programming.stack;

import java.util.Stack;

public class Print_Ancestors {
	 static class Node
	    {
	        int data;
	        Node left,right;
	         
	        // constructor to create Node
	        // left and right are by default null
	        Node(int data)
	        {
	            this.data = data;
	        }
	    }
	     
	 static void printAncestors(Node root, int key) {
		 Stack<Node> st = new Stack<>();
		 
		while(true) {
			
			while(root != null && root.data !=key) {
				st.push(root);
				root= root.left;
			}
			
			if(root!=null && root.data == key )
				break;
			
			if(st.peek().right == null) {
				 
				root = st.peek();
				st.pop();
				
				while(!st.empty() && st.peek().right == root ) {
					root = st.peek();
					st.pop();
				}
				
			}
			
			root = st.empty() ? null : st.peek().right;
			
		}
		 
		 
		while(!st.empty()) {
			System.out.print(st.peek().data+" ");
            st.pop();
		}
		 
		 
		 
	 }

public static void main(String[] args) {
	
	 Node root = new Node(1);
     root.left = new Node(2);
     root.right = new Node(3);
     root.left.left = new Node(4);
     root.left.right = new Node(5);
     root.right.left = new Node(6);
     root.right.right = new Node(7);
     root.left.left.left = new Node(8);
     root.left.right.right = new Node(9);
     root.right.right.left = new Node(10);
      
     System.out.println("Following are all keys and their ancestors");
     for(int key = 1;key <= 10;key++)
     {
         System.out.print(key+": ");
         printAncestors(root, key);
         System.out.println();
     }
	
	
}

}


