package ds.algo.solutions;

import java.util.Stack;

public class RecursiveStackReverse {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);
		
		new RecursiveStackReverse().reverse(stack);
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	private void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) 
			return;
		
		Integer i = stack.pop();
		reverse(stack);
		insert(stack, i);
	}

	private void insert(Stack<Integer> stack, Integer i) {
		if (stack.isEmpty())
			stack.push(i);
		else {
			// move all the items to the call stack until
			// the stack is empty
			Integer temp = stack.pop();
			insert(stack, i);
			stack.push(temp);
		}
	}
}
