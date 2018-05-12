package ds.algo.solution;

import java.util.Stack;

public class TreeTraversalDemo {

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
}

class TreeNode {
	
	int value;
	
	TreeNode left;
	
	TreeNode right;
	
	TreeNode(int val) {
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
		return String.valueOf(this.value);
	}
}
