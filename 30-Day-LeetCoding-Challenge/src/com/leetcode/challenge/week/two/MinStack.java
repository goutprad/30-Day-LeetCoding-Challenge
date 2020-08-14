package com.leetcode.challenge.week.two;

import java.util.Stack;

/**
 * Min Stack 
 * Time - O(1)
 * Space - O(N)
 * 
 * @author Goutam
 *
 */
public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> minStack;

	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int x) {
		if (minStack.isEmpty()) {
			minStack.push(x);
		} else if (minStack.peek() >= x) {
			minStack.push(x);
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.peek().equals(minStack.peek())) {
			stack.pop();
			minStack.pop();
		} else {
			stack.pop();
		}
	}

	public int getMin() {
		return minStack.peek();
	}

	public int top() {
		return stack.peek();
	}

	public static void main(String[] args) {
		MinStack leetcode = new MinStack();
		leetcode.push(-2);
		leetcode.push(0);
		leetcode.push(-3);
		System.out.println("min: "+leetcode.getMin());
		leetcode.pop();
		System.out.println("top: "+leetcode.top());
		System.out.println("min: "+leetcode.getMin());
	}

}
