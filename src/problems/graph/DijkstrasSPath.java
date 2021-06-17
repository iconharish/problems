package problems.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DijkstrasSPath {
	
	private static class Graph {
		int V;
		LinkedList<Node> adj[];
		
		@SuppressWarnings("unchecked")
		Graph(int V) {
			this.V = V;
			
			adj = new LinkedList[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int u, Node v) {
			adj[u].add(v);
		}
		
		private LinkedList<Node> findShortestPath(int s, int d) {
			boolean[] visited = new boolean[V];
			
			visited[s] = true;
			LinkedList<Node> connectedNodes = adj[s];
			int initilCost = 0;
			while(true) {
				Iterator<Node> iter = connectedNodes.listIterator();
				while(iter.hasNext()) {
					Node node = iter.next();
					if (visited[node.id]) {
						continue;
					}
					node.cost = Math.min(node.cost, initilCost + node.cost);
					if (d == node.id) {
						break;
					}
					// add to some structure to compare the cost
				}
				
				// connectedNodes = adj[min cost node.id];
				// initialCost = mincostnode.cost;
			}
			
			
			//return null;
		}
	}
	
	private static class Node implements Comparable<Node>{
		int id;
		int cost;
		@Override
		public int compareTo(Node arg0) {
			if (this.cost < arg0.cost) {
				return -1;
			}
			if (this.cost > arg0.cost) {
				return 1;
			}
			return 0;
		}
	}

}
