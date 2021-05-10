package problems.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSDisconnected {
	
	static class Graph {
		int V;
		LinkedList<Integer>[] adj;
		
		@SuppressWarnings("unchecked")
		public Graph(int V) {
			this.V = V;
			adj = new LinkedList[V];
			
			for (int i = 0; i < V; i++) {
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int u, int v) {
			adj[u].add(v);
		}
		
		void BFS(int s, boolean[] visited) {
			LinkedList<Integer> queue = new LinkedList<>();
			
			visited[s] = true;
			queue.add(s);
			
			while (queue.size() != 0) {
				s = queue.poll();
				System.out.println(s);
				
				Iterator<Integer> iter = adj[s].listIterator();
				while(iter.hasNext()) {
					int i = iter.next();
					if (!visited[i]) {
						visited[i] = true;
						queue.add(i);
					}
				}
				
			}
			
			
		}
		
		void BFS() {
			boolean[] visited = new boolean[V];
			for (int i = 0; i < V; i++) {
				if (!visited[i]) {
					BFS(i, visited);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
        
        System.out.println(
                "Following is Breadth First Traversal");
        g.BFS();
	}

}
