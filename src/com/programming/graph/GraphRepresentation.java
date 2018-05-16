package com.programming.graph;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.InternalFrameFocusTraversalPolicy;

// AdjancyList graph representation
public class GraphRepresentation {

	static class graph {
		int v;
		LinkedList<Integer> adjArray[];

		public graph(int v) {
			this.v = v;
			adjArray = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adjArray[i] = new LinkedList<>();
			}
		}

	}

	static void addEdge(graph g, int src, int dsrt) {
		g.adjArray[src].add(dsrt);
		// g.adjArray[dsrt].add(src);
	}

	static void printgraph(graph g) {
		for (int i = 0; i < g.v; i++) {
			System.out.println("Adjacency list of vertex " + i);
			System.out.print("head");

			for (Integer t : g.adjArray[i]) {
				System.out.print(" -> " + t);
			}
			System.out.println();
		}
	}

	static void BFSTraversal(graph g, int startVertex) {
		boolean[] visitedArray = new boolean[g.v];

		LinkedList<Integer> queue = new LinkedList<>();
		visitedArray[startVertex] = true;
		queue.add(startVertex);

		while (queue.size() != 0) {
			startVertex = queue.poll();
			System.out.print(startVertex + "  ");

			Iterator<Integer> i = g.adjArray[startVertex].listIterator();

			while (i.hasNext()) {
				int n = i.next();
				if (!visitedArray[n]) {
					visitedArray[n] = true;
					queue.add(n);
				}

			}
		}

	}

	static void DFSTraversal(graph g, int startVertex, boolean[] visitedArray) {

		visitedArray[startVertex] = true;

		System.out.print(startVertex + "  ");

		Iterator<Integer> i = g.adjArray[startVertex].listIterator();

		while (i.hasNext()) {
			startVertex = i.next();
			if (!visitedArray[startVertex]) {
				DFSTraversal(g, startVertex, visitedArray);

			}

		}
	}

	static void DFS(graph g, int startIndex) {
		boolean[] vArray = new boolean[g.v];
		DFSTraversal(g, startIndex, vArray);

	}

	static void DFSIterative(graph g, int start) {
		boolean[] visitedArray = new boolean[g.v];
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		while (!stack.isEmpty()) {
			int s = stack.peek();
			stack.pop();

			if (!visitedArray[s]) {
				visitedArray[s] = true;
				System.out.print(s + "  ");

			}

			Iterator<Integer> itr = g.adjArray[s].descendingIterator();
			while (itr.hasNext()) {
				int v = itr.next();
				if (!visitedArray[v])
					stack.push(v);
			}

		}
	}

	static void recursionDFS(graph g, int start, boolean[] visited) {

		System.out.print(start + "  ");
		visited[start] = true;

		Iterator<Integer> itr = g.adjArray[start].iterator();

		while (itr.hasNext()) {
			int v = itr.next();
			if (!visited[v])
				recursionDFS(g, v, visited);

		}

	}

	static void topologicalSortingGraph(graph g, boolean[] visited, int start, Stack<Integer> stack) {
		visited[start] = true;

		Iterator<Integer> itr = g.adjArray[start].iterator();
		while (itr.hasNext()) {

			int v = itr.next();
			if (!visited[v])
				topologicalSortingGraph(g, visited, v, stack);

		}

		stack.push(start);

	}
	
	
	static int find(int[] parent, int i ) {
		if(parent[i] == -1) {
			return i;
		}
		return find(parent, parent[i]);
	}

	static void Union(int[] parent, int x, int y) {
		int xset = find(parent , x);
		int yset = find(parent, y );
		parent[xset] = yset;
	}
	
	
	static boolean isCycleFound(graph g) {
		int[] parent = new int[g.v];

		for (int i = 0; i < g.v; i++) {
			parent[i] = -1;
		}
		
		for(int i =0 ; i < g.adjArray.length; i++) {
			for(int j =0; j < g.adjArray[i].size(); j++) {
			int x = find(parent, i );
			int y = find(parent , g.adjArray[i].get(j));
			
			if(x == y ) {
				System.out.println(Arrays.toString(parent));
				System.out.println(x +"   "+y);
				return true;
			}
			
			Union(parent, x, y);
			
			}
		}
		
		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int V = 5;
		graph graphh = new graph(V);
		addEdge(graphh, 0, 1);
		addEdge(graphh, 0, 4);
		addEdge(graphh, 1, 2);
		addEdge(graphh, 1, 3);
		addEdge(graphh, 1, 4);
		addEdge(graphh, 2, 3);
		addEdge(graphh, 3, 4);
		/*
		 * addEdge(graphh,5, 2); addEdge(graphh,5, 0); addEdge(graphh,4, 0);
		 * addEdge(graphh,4, 1); addEdge(graphh,2, 3); addEdge(graphh,3, 1);
		 */

		// print the adjacency list representation of
		// the above graph
		printgraph(graphh);
		BFSTraversal(graphh, 2);
		System.out.println();

		DFS(graphh, 2);

		System.out.println();
		DFSIterative(graphh, 2);

		System.out.println();
		boolean visited[] = new boolean[graphh.v];
		recursionDFS(graphh, 2, visited);

		// ================================= TOPOLOGICAL SORTING
		// ====================================
		System.out.println(
				"\n =============================================   TOPOLOGICAL SORTING ====================================================");
		Stack<Integer> s = new Stack<Integer>();
		boolean visitedArray[] = new boolean[graphh.v];
		for (int i = 0; i < graphh.v; i++) {
			if (!visitedArray[i])
				topologicalSortingGraph(graphh, visitedArray, i, s);
		}

		while (!s.isEmpty()) {
			System.out.print(s.pop() + "  ");
		}

		System.out.println(
				"\n =============================================   Graph Cycle  ====================================================");
		
		System.out.println("Cycle Contains : "+ isCycleFound(graphh));
		
		

	}

}
