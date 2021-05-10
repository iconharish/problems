package problems.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSConnected {
	
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
        
        System.out.println(
                "Following is Depth First Traversal "
                + "(starting from vertex 2)");
        g.DFS(2);
	}
	
	static class Graph {
		int V;
		LinkedList<Integer> adj[];
		
		
		@SuppressWarnings("unchecked")
		Graph(int V) {
			this.V = V;
			
			adj = new LinkedList[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int u, int v) {
			adj[u].add(v);
		}
		
		void DFS(int s) {
			boolean[] visited = new boolean[V];
			DFS(s, visited);
		}
		
		void DFS(int s, boolean[] visited) {
			
			System.out.println(s);
			visited[s] = true;
			
			Iterator<Integer> iter = adj[s].listIterator();
			while(iter.hasNext()) {
				int i = iter.next();
				if (!visited[i]) {
					DFS(i, visited);
				}
				
			}
		}
	}

}
