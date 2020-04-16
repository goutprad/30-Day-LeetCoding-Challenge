package com.leetcode.challenge.week.two;

public class PerformStringShift {
	public String stringShift(String s, int[][] shift) {
		int left = 0;
		int right = 0;
		System.out.println(s.length());
		String result = "";
		for (int i = 0; i < shift.length; i++) {
			if (shift[i][0] == 1) {
				right += shift[i][1];
			} else {
				left += shift[i][1];
			}
		}
		if (left > right) {
			left -= right;
			left %= s.length();
			result += s.substring(left,s.length());
			result += s.substring(0, left);
		} else {

			right -= left;
			right %= s.length();
			result += s.substring(s.length()-right,s.length());
			result += s.substring(0, s.length() - right);
		}
		return result;
	}

	public static void main(String[] args) {
		PerformStringShift leet = new PerformStringShift();
		String s = "abc";
		int[][] shift = { { 1, 1 }, { 0, 2 } };
		System.out.println(leet.stringShift(s, shift));
		
	}

}
