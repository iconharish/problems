package problems.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSDisconnected {
	
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
        
        System.out.println("Following is Depth First Traversal");
        g.DFS();
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
		
		void DFS() {
			boolean[] visited = new boolean[V];
			for (int i = 0; i < V; i++) {
				if (!visited[i]) {
					DFS(i, visited);
				}
			}
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
