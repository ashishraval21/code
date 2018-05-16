package com.programming.TREE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import javax.sound.midi.Soundbank;

public class BinaryTree {
	static Node root;

	public BinaryTree() {
		root = null;
	}

	public void insert(int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			Node temp = root;
			while (true) {
				if (temp.value < value) {

					if (temp.right == null) {
						temp.right = new Node(value);
						break;
					}
					temp = temp.right;

				} else {

					if (temp.left == null) {
						temp.left = new Node(value);
						break;
					}
					temp = temp.left;
				}
			}
		}
	}

	// DFS traversal
	public void displayTree(Node root, String order) {
		if (root != null) {
			switch (order) {
			case "pre":
				System.out.print(root.value + " ");
				displayTree(root.left, order);
				displayTree(root.right, order);
				break;
			case "post":
				displayTree(root.left, order);
				displayTree(root.right, order);
				System.out.print(root.value + " ");
				break;
			case "in":
				displayTree(root.left, order);
				System.out.print(root.value + " ");
				displayTree(root.right, order);
				break;
			}
		}
	}

	public int getSize(Node root) {
		if (root == null)
			return 0;

		return 1 + getSize(root.left) + getSize(root.right);
	}

	// BFS traversal
	public void displayTree(Node root) {
		if (root == null)
			System.out.println("No Element");
		else {
			java.util.Queue<Node> nodes = new LinkedList<Node>();
			nodes.add(root);
			while (!nodes.isEmpty()) {

				Node temp = nodes.poll();
				System.out.print(temp.value + " ");

				if (temp.left != null)
					nodes.add(temp.left);
				if (temp.right != null)
					nodes.add(temp.right);

			}

		}
		System.out.println();
	}

	public boolean findElement(int value, Node root) {
		if (root == null)
			return false;
		if (root.value == value)
			return true;
		else if (root.value > value)
			return findElement(value, root.left);
		else
			return findElement(value, root.right);

	}

	// this method used for find immediate successor of the deleting node
	public int findSmallest(Node root) {
		return root.left == null ? root.value : findSmallest(root.left);
	}

	public Node deleteElement(int value, Node root) {
		if (root == null)
			return null;

		if (root.value == value) {

			// no children exist
			if (root.left == null && root.right == null)
				return null;
			// any 1 child exist for deleted node
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;

			// 2 child exist
			int smallvalue = findSmallest(root.right); // find smallest from right subtree of deleting node.
			root.value = smallvalue; // value swapped
			root.right = deleteElement(smallvalue, root.right); // delete smallest value element in a tree
			return root;

		}

		if (root.value > value) {
			root.left = deleteElement(value, root.left);
			return root;
		}

		root.right = deleteElement(value, root.right);
		return root;

	}

	public int getHeight(Node root) {
		if (root == null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));

	}

	public void reverseLevelOrder(Node root) {
		Stack<Node> stack = new Stack<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			stack.push(node);

			// careful here
			// we added right here and left after that so we can fetch left before the right
			// one.

			if (node.right != null)
				queue.add(node.right);
			if (node.left != null)
				queue.add(node.left);
		}

		while (!stack.isEmpty()) {
			Node n = stack.peek();
			System.out.print(n.value + "  ");
			stack.pop();

		}
	}

	public Node insertRecursively(Node root, int data) {
		if (root == null) {
			return root = new Node(data);
		} else if (root.value > data) {
			root.left = insertRecursively(root.left, data);
		} else if (root.value < data) {
			root.right = insertRecursively(root.right, data);
		}
		return root;
	}

	public Node searchRecursively(Node root, int data) {
		if (root == null || root.value == data) {
			return root;
		} else if (root.value > data) {
			return searchRecursively(root.left, data);
		}

		return searchRecursively(root.right, data);
	}

	public void DiagonalPrintBST(HashMap<Integer, List<Integer>> map, int height, Node root) {
		if (root == null)
			return;
		List<Integer> i = map.get(height);
		if (i == null) {
			i = new ArrayList<>();
			i.add(root.value);
		} else {
			i.add(root.value);
		}

		// Store all nodes of same line together as a list
		map.put(height, i);
		DiagonalPrintBST(map, height + 1, root.right);
		DiagonalPrintBST(map, height, root.left);

	}

	public void verticalOrderBST(TreeMap<Integer, List<Integer>> map, int index, Node root) {

		if (root == null)
			return;

		List<Integer> list = map.get(index);

		if (list == null) {
			list = new ArrayList<>();
		}

		list.add(root.value);

		map.put(index, list);

		verticalOrderBST(map, index - 1, root.left);
		verticalOrderBST(map, index + 1, root.right);

	}

	public void BoundaryTraversal(Node root) {
		if (root != null) {
			System.out.print(root.value+" ");
			printLeft(root.left);
			
			printBoundaryLeaves(root.left);
			printBoundaryLeaves(root.right);
			
			printRight(root.right);
		}
	}

	public void printLeft(Node root) {
		if (root != null) {

			if (root.left != null) {
				System.out.print(root.value + " ");
				printLeft(root.left);
			} else if (root.right != null) {
				System.out.print(root.value + " ");
				printLeft(root.right);
			}

		}

	}

	public void printRight(Node root) {
		if (root != null) {

			if (root.right != null) {
				printRight(root.right);
				System.out.print(root.value + " ");

			} else if (root.left != null) {
				printRight(root.left);
				System.out.print(root.value + " ");
			}

		}

	}
	
	public void printBoundaryLeaves(Node root) {
		if(root != null) {
			printBoundaryLeaves(root.left);
				if(root.left == null  && root.right == null) {
					System.out.print(root.value+" ");
				}
			printBoundaryLeaves(root.right);
		}
		
	}
	
	
	static List<Integer> p1 = new ArrayList<>(), p2 = new ArrayList<>();

	static Node findLCA(Node root, int v1, int v2) {
		
		if(root == null)
			return null;
		
		System.out.print("\n"+ root.value +"  "+ v1+"  "+v2);
		if(root.value == v1 || root.value == v2) {
			return root;
		}
		
		Node LeftLCA = findLCA(root.left, v1, v2);
		Node RightLCA = findLCA(root.right, v1, v2);
	
		System.out.print("\n --"+ root.value +"  "+ v1+"  "+v2);
		
		if(LeftLCA != null && RightLCA != null)
			return root;
		
		
		return LeftLCA != null ? LeftLCA : RightLCA;
	}
	

	public void constructBST(int[] array, int root) {

	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		root = tree.insertRecursively(root, 5);
		// tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(1);
		tree.insert(4);
		tree.insert(7);
		tree.insert(9);
		// 5
		// 3 8
		// 1 4 7 9
		//
		//
		//
		//
		//
		//
		tree.displayTree(root, "pre");
		System.out.println();
		tree.displayTree(root, "post");
		System.out.println();
		tree.displayTree(root, "in");
		System.out.println();

		// BFS traversal or level order
		tree.displayTree(root);

		// size of the tree
		System.out.print("\nsize of the tree is : " + tree.getSize(root));

		// height of the tree
		System.out.println("\nheight of the tree is : " + tree.getHeight(root));

		// find element from the tree
		System.out.println("element present in the tree : " + tree.findElement(9, root));

		// tree.deleteElement(5, root);

		System.out.println("element present in the tree : " + tree.findElement(5, root));

		tree.displayTree(root);

		// display tree in reverse level order
		tree.reverseLevelOrder(root);
		System.out.println("\n  preorder traversal : ");

		tree.displayTree(root, "pre");

		HashMap<Integer, List<Integer>> map = new HashMap<>();
		tree.DiagonalPrintBST(map, 0, root);
		System.out.println();
		System.out.println(" Tree Diagonal Traversal : ");
		for (Integer value : map.keySet()) {
			ListIterator<Integer> itr = map.get(value).listIterator();
			while (itr.hasNext()) {
				System.out.print(itr.next() + "  ");
			}

		}

		map.clear();
		TreeMap<Integer, List<Integer>> treeMap = new TreeMap();

		tree.verticalOrderBST(treeMap, 0, root);
		System.out.println();
		System.out.println(" Tree Verical Traversal : ");

		for (Integer value : treeMap.keySet()) {
			ListIterator<Integer> itr = treeMap.get(value).listIterator();
			while (itr.hasNext()) {
				System.out.print(itr.next() + "  ");
			}
			System.out.println();
		}
		//		System.out.println();
		System.out.println("Boundary Tree Traversal :");
		tree.BoundaryTraversal(root);
		
		
		
		Node value = tree.findLCA(root, 8, 7);
		System.out.println("\nLCA VALUE : "+ value.value);

	}
	

	
	
	
	/**
	 * Remaining Task - height of tree - done - size of tree ( count present node in
	 * a tree ) - done - find element - done - delete element - done - print parent
	 * of each node - level order / BFS - done - reverse level order - done -
	 * inorder traversal without recursion and stack. - construct BST using array.
	 * 
	 * 
	 */

}
