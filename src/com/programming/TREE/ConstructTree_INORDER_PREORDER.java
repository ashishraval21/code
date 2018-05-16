package com.programming.TREE;

public class ConstructTree_INORDER_PREORDER {
	static Node root;
	static int preCurrent =0;

	class Node {
		String data;
		Node left, right;

		Node(String data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public int searchElement(String[] in, int startIndex, int endIndex, String value) {
		int i;
		for (i = startIndex; i <= endIndex; i++) {
			if (in[i].equals(value)) {
				return i;
			}
		}
		return i;
	}

	public Node ConstructTree(String[] inOrder, String[] preOrder, int preIndex, int inIndex) {

		if (preIndex > inIndex)
			return null;

		Node node = new Node(preOrder[preCurrent++]);
		
		if (inIndex == preIndex) {
			return node;
		}

		int indexOfInOrderArray = searchElement(inOrder, preIndex, inIndex, node.data);
		this.printInorder(node);
		System.out.println();
		node.left = ConstructTree(inOrder, preOrder, preIndex, indexOfInOrderArray - 1);
		node.right = ConstructTree(inOrder, preOrder, indexOfInOrderArray + 1, inIndex);
		return node;

	}

	public void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + "  ");
		printInorder(root.right);

	}

	public static void main(String[] args) {
		String[] inOrder = { "D", "B", "E", "A", "F", "C" };
		String[] preOrder = { "A", "B", "D", "E", "C", "F" };

		root = new ConstructTree_INORDER_PREORDER().ConstructTree(inOrder, preOrder, 0, inOrder.length - 1);
		new ConstructTree_INORDER_PREORDER().printInorder(root);

	}

}
