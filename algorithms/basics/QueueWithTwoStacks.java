/**
  Implement a queue with two stacks
**/

import java.util.Stack;

public class QueueWithTwoStacks {

	
	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public QueueWithTwoStacks() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();

	}

	public void enqueue(Integer value) {
		stack1.push(value);
	}

	public Integer dequeue() {
		while (!stack1.empty()) {
			stack2.push(stack1.pop());
		}
		Integer ele = null;		
		if (!stack2.empty()) {
			ele = stack2.pop();
		}
		while (!stack2.empty()) {
			stack1.push(stack2.pop());

		}
		return ele;
	}
	public boolean empty() {
		return stack1.empty();
	}

	public int size() {
		return stack1.size();
	}

}

