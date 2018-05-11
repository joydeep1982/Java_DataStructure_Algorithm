package ds.algo.solution;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleInDirectedGraph {

	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		
		one.addChild(two).addChild(three).addChild(four);
		two.addChild(three);
		four.addChild(five);
		five.addChild(six);
		six.addChild(four);// this creates the cycle in the graph
		
		Set<Node> nodes = new HashSet<>();
		nodes.add(one);
		nodes.add(two);
		nodes.add(three);
		nodes.add(four);
		nodes.add(five);
		nodes.add(six);
		
		System.out.println(new DetectCycleInDirectedGraph().isCyclePresent(nodes));
	}
	
	public boolean isCyclePresent(Set<Node> nodes) {
		
		Set<Node> whiteSet = new HashSet<>(nodes);
		Set<Node> greySet = new HashSet<>();
		Set<Node> blackSet = new HashSet<>();
		
		while (!whiteSet.isEmpty()) {
			if(inspectNode(whiteSet.iterator().next(), whiteSet, greySet, blackSet)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean inspectNode(Node n, Set<Node> whiteSet, Set<Node> greaySet, Set<Node> blackSet) {
		
		move(n, whiteSet, greaySet);
		
		for (Node node : n.getChildren()) {
			if (blackSet.contains(node)) {
				continue;
			}
			if (greaySet.contains(node)) {
				return true;
			}
			if (inspectNode(node, whiteSet, greaySet, blackSet)) {
				return true;
			}
		}
		move(n, greaySet, blackSet);
		
		return false;
	}
	
	private void move(Node n, Set<Node> source, Set<Node> destination) {
		source.remove(n);
		destination.add(n);
	}
}

class Node {
	
	int value;
	
	Set<Node> children;
	
	Node(int val) {
		this.children = new HashSet<Node>();
		this.value = val;
	}
	
	public Node addChild(Node n) {
		children.add(n);
		return this;
	}
	
	public Set<Node> getChildren(){
		return children;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
}
