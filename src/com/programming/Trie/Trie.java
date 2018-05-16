package com.programming.Trie;

public class Trie {
	static final int ALPHABET_SIZE = 26;
	static TrieNode root;

	static class TrieNode {

		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		boolean isEndOfWord;

		public TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++) {
				children[i] = null;
			}
		}
	}

	public static void insert(String key) {
		int length = key.length();
		TrieNode head = root;
		for (int i = 0; i < length; i++) {
			int index = key.charAt(i) - 'a';
			if (head.children[index] == null) {
				head.children[index] = new TrieNode();
			}

			head = head.children[index];

		}

		head.isEndOfWord = true;
	}

	public static boolean search(String key) {
		int length = key.length();
		TrieNode head = root;
		for (int i = 0; i < length; i++) {
			int index = key.charAt(i) - 'a';
			if (head.children[index] == null)
				return false;
			head = head.children[index];

		}

		return head!=null && head.isEndOfWord;
	}

	public static void main(String[] args) {
		String[] keys = { "the", "there", "many", "any", "by", "their", "them", "bye" };
		String output[] = {"Not present in trie", "Present in trie"};
	      
		root = new TrieNode();
		for (String key : keys) {
			insert(key);
		}
		
		
		if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);
         
        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
         
        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);
         
        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

	}

}
