package ds.algo.solution;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		TopoNode a = new TopoNode("a");
		TopoNode b = new TopoNode("b");
		TopoNode c = new TopoNode("c");
		TopoNode d = new TopoNode("d");
		TopoNode e = new TopoNode("e");
		TopoNode f = new TopoNode("f");
		TopoNode g = new TopoNode("g");
		TopoNode h = new TopoNode("h");
		
		a.addChild(c);
		b.addChild(c).addChild(d);
		c.addChild(e);
		d.addChild(f);
		e.addChild(f).addChild(h);
		f.addChild(g);
		
		Set<TopoNode> nodes = new HashSet<>();
		nodes.add(a);
		nodes.add(b);
		nodes.add(c);
		nodes.add(d);
		nodes.add(e);
		nodes.add(f);
		nodes.add(g);
		
		Stack<TopoNode> stack = new TopologicalSort().topoSort(nodes);
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	private Stack<TopoNode> topoSort(Set<TopoNode> nodes) {
		Stack<TopoNode> topoStack = new Stack<>();
		Set<TopoNode> visited = new HashSet<>();
		Set<TopoNode> allNodes = new HashSet<>(nodes);
		
		for (TopoNode topoNode : allNodes) {
			sort(topoNode, topoStack, visited);
		}
		
		return topoStack;
	}
	
	private void sort(TopoNode node, Stack<TopoNode> topoStack, Set<TopoNode> visited) {
		if (visited.contains(node)) {
			return;
		}
		visited.add(node);
		for (TopoNode childNode : node.getChildren()) {
			sort(childNode, topoStack, visited);
		}
		topoStack.add(node);
	}
}

class TopoNode {
	
	String value;
	
	Set<TopoNode> children;
	
	TopoNode(String val) {
		this.children = new HashSet<TopoNode>();
		this.value = val;
	}
	
	public TopoNode addChild(TopoNode n) {
		children.add(n);
		return this;
	}
	
	public Set<TopoNode> getChildren(){
		return children;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
