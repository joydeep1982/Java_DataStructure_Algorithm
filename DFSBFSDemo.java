package ds.algo.solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DFSBFSDemo {

	private static GraphNode buildGraph() {
		
		GraphNode c = new GraphNode().setChar("C");
		GraphNode b = new GraphNode().setChar("B");
		GraphNode a = new GraphNode().setChar("A");
		GraphNode d = new GraphNode().setChar("D");
		GraphNode e = new GraphNode().setChar("E");
		GraphNode h = new GraphNode().setChar("H");
		GraphNode g = new GraphNode().setChar("G");
		GraphNode f = new GraphNode().setChar("F");
		
		a.addChild(b);
		b.addChild(a).addChild(c).addChild(h);
		c.addChild(b).addChild(e).addChild(d);
		d.addChild(c);
		e.addChild(c).addChild(f).addChild(g).addChild(h);
		f.addChild(e);
		g.addChild(e);
		h.addChild(e).addChild(b);
		
		return a;
	}
	
	public static void main(String[] args) {
		GraphNode start = buildGraph();
		
		DFSBFSDemo gd = new DFSBFSDemo();

		System.out.println("depth first search");
		gd.dfs(start);
		System.out.println("");
		System.out.println("");
		System.out.println("bredth first search");
		gd.bfs(start);
	}
	
	private void bfs(GraphNode n) {
		Set<GraphNode> visited = new HashSet<>();
		LinkedList<GraphNode> queue = new LinkedList<>();
		queue.add(n);
		
		GraphNode temp;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (visited.contains(temp)) {
				continue;
			}
			System.out.print(temp + " ");
			visited.add(temp);
			queue.addAll(temp.getChildren());
		}
	}
	
	private void dfsUtil(GraphNode n, Set<GraphNode> visited) {
		System.out.print(n + " ");
		visited.add(n);
		
		for (GraphNode child : n.getChildren()) {
			if (visited.contains(child)) {
				continue;
			}
			dfsUtil(child, visited);
		}
	}
	
	private void dfs(GraphNode n) {
		Set<GraphNode> visited = new HashSet<>();
 		dfsUtil(n, visited);
	}
	
}

class GraphNode {
	
	String data;
	
	Set<GraphNode> children;
	
	public GraphNode() {
		this.children = new HashSet<>();
	}
	
	public GraphNode setChar(String word) {
		this.data = word;
		return this;
	}
	
	public GraphNode addChild(GraphNode childGraphNode) {
		children.add(childGraphNode);
		return this;
	}
	
	public Set<GraphNode> getChildren() {
		return this.children;
	}
	
	@Override
	public String toString() {
		return this.data;
	}
}