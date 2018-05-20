package ds.algo.solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversalDemo {
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode("A");
		TreeNode b = new TreeNode("B");
		TreeNode c = new TreeNode("C");
		TreeNode d = new TreeNode("D");
		TreeNode e = new TreeNode("E");
		TreeNode f = new TreeNode("F");
		
		a.addLeft(b).addRight(f);
		b.addLeft(d).addRight(e);
		f.addLeft(c);
		
		TreeNode root = a;
		TreeTraversalDemo traversal = new TreeTraversalDemo();
		traversal.printTree(root, 0);
		
		System.out.println("in order");
		traversal.inOrder(root);
		
		System.out.println("pre order");
		traversal.preOrder(root);
	}
	
	private static int treeHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int l = treeHeight(node.left);
		int r = treeHeight(node.right);
		
		return Math.max(l, r) + 1;
	}

	public void levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode temp;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			System.out.println(temp);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}
	
	public void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node);
		inOrder(node.right);
	}
	
	public void inOrderNonRecursive(TreeNode node) {
		if (node == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		
		while (node != null) {
			stack.add(node);
			node = node.left;
		}
		
		TreeNode temp;
		while(!stack.isEmpty()) {
			temp = stack.pop();
			System.out.println(temp);
			
			if (temp.right != null) {
				temp = temp.right;
				while (temp != null) {
					stack.push(temp);
					temp = temp.left;
				}
			}
		}
	}
	
	public void preOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void preOrderNonRecursive(TreeNode node) {
		if (node == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.add(node);
		TreeNode temp;
		
		while(!stack.isEmpty()) {
			temp = stack.pop();
			System.out.println(temp);
			if (temp.right != null)
				stack.add(temp.right);
			if (temp.left != null)
				stack.add(temp.left);
		}
	}
	
	public void postOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node);
	}
	
	public void postOrderNonRecursive(TreeNode node) {
		if (node == null) {
			return;
		}
	}
	
	public void printTree(TreeNode node, int level) {
		if (node == null) {
			return;
		}
		for (int i = 0; i < level; i++) System.out.print("-");
		System.out.println(node);
		printTree(node.left, level + 1);
		printTree(node.right, level + 1);
	}
}

class TreeNode {
	
	String value;
	
	TreeNode left;
	
	TreeNode right;
	
	TreeNode(String val) {
		this.value = val;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode addLeft(TreeNode n) {
		this.left = n;
		return this;
	}
	
	public TreeNode addRight(TreeNode n) {
		this.right = n;
		return this;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
