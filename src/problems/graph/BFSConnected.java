package problems.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSConnected {
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
        
        System.out.println(
                "Following is Bredth First Traversal "
                + "(starting from vertex 2)");
        g.BFS(2);
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
		
		void BFS(int s) {
			LinkedList<Integer> bfsQueue = new LinkedList<>();
			boolean[] visited = new boolean[V];
			
			visited[s] = true;
			bfsQueue.add(s);
			
			while(bfsQueue.size() != 0) {
				s = bfsQueue.poll();
				System.out.println(s);
				
				Iterator<Integer> iter = adj[s].listIterator();
				while(iter.hasNext()) {
					int i = iter.next();
					if (!visited[i]) {
						visited[i] = true;
						bfsQueue.add(i);
					}
					
				}
			}
		}
	}
}
