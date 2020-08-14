package com.leetcode.challenge.week.two;

import java.util.Stack;

public class BackSpaceStringCompare {
	/**
	 * Time - O(M+N) Space - O(M+N)
	 * 
	 * @param S
	 * @param T
	 * @return
	 */
	public boolean backspaceCompare_bruteforce(String S, String T) {
		Stack<Character> st1 = new Stack<Character>();
		Stack<Character> st2 = new Stack<Character>();

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '#' && !st1.isEmpty()) {
				st1.pop();
			} else if (S.charAt(i) != '#') {
				st1.push(S.charAt(i));
			}
		}
		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) == '#' && !st2.isEmpty()) {
				st2.pop();
			} else if (T.charAt(i) != '#') {
				st2.push(T.charAt(i));
			}
		}
		System.out.println(st1);
		System.out.println(st2);
		return String.valueOf(st1).equals(String.valueOf(st2));
	}

	/**
	 * Time - O(M+N) Space - O()
	 * 
	 * @param S
	 * @param T
	 * @return
	 */
	public boolean backspaceCompare(String S, String T) {
		S = removeBackSpace(S);
		T = removeBackSpace(T);
		return S.equals(T);
	}

	public String removeBackSpace(String S) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '#') {
				if (sb.length() > 0)
					sb.deleteCharAt(sb.length() - 1);
			} else {
				sb.append(S.charAt(i));
			}
		}
		return sb.toString();
	}

	public boolean backspaceCompare_2(String s1, String s2) {
		int p1 = s1.length() - 1;
		int p2 = s2.length() - 1;

		int backCount1 = 0;
		int backCount2 = 0;
		while (p1 >= 0 || p2 >= 0) {
			while (p1 >= 0 && (backCount1 > 0 || s1.charAt(p1) == '#')) {
				if (s1.charAt(p1) == '#') {
					backCount1++;
				} else {
					backCount1--;
				}

				p1--;
			}

			while (p2 >= 0 && (backCount2 > 0 || s2.charAt(p2) == '#')) {
				if (s2.charAt(p2) == '#') {
					backCount2++;
				} else {
					backCount2--;
				}

				p2--;
			}

			if (p1 >= 0 && p2 >= 0) {
				if (s1.charAt(p1) != s2.charAt(p2))
					return false;
				p1--;
				p2--;
			} else if (p1 < 0 && p2 >= 0) {
				return false;
			} else if (p2 < 0 && p1 >= 0) {
				return false;
			} else {
				return true;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		BackSpaceStringCompare leetcode = new BackSpaceStringCompare();
		String S = "a##c", T = "#a#c";
		System.out.println(leetcode.backspaceCompare(S, T));
		System.out.println(leetcode.backspaceCompare_2(S, T));
	}

}
