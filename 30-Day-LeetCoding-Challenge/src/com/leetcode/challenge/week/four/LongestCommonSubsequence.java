package com.leetcode.challenge.week.four;


public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String text1, String text2) {
		int[][] lcs = new int[text1.length()+1][text2.length()+1];
		for (int i = 1; i <= text1.length(); i++) {
			for (int j = 1; j <= text2.length(); j++) {
				if(text1.charAt(i-1) == text2.charAt(j-1)) {
					lcs[i][j] = 1+ lcs[i-1][j-1];
				} else {
					lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
				}
			}
		}
		return lcs[text1.length()][text2.length()];
	}

	public static void main(String[] args) {
		LongestCommonSubsequence leet = new LongestCommonSubsequence();
		String text1 = "abcde"; 
		String text2 = "ace";
		System.out.println(leet.longestCommonSubsequence(text1, text2));
	}

}
