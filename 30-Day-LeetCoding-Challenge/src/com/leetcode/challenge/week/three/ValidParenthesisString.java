package com.leetcode.challenge.week.three;

import java.util.Stack;

public class ValidParenthesisString {
	public boolean checkValidString(String s) {
		Stack<Integer> openBracket = new Stack<Integer>();
		Stack<Integer> starStack = new Stack<Integer>();
	
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				openBracket.push(i);
			} else if(s.charAt(i) == '*') {
				starStack.push(i);
			} else {
				if(!openBracket.isEmpty()) {
					openBracket.pop();
				} else if(!starStack.isEmpty()) {
					starStack.pop();
				} else {
					return false;
				}
				
			}
		}
		while(!openBracket.isEmpty()) {
			if(starStack.isEmpty()) {
				return false;
			}else if(openBracket.peek() < starStack.peek()) {
				openBracket.pop();
				starStack.pop();
			} else {
				return false;
			}
				
		}
		return true;
	}

	public static void main(String[] args) {
		ValidParenthesisString leet = new ValidParenthesisString();
		String s = "(*()";
		System.out.println(leet.checkValidString(s));
	}
}
