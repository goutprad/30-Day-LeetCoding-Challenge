package com.leetcode.challenge.week.four;


public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0 || matrix ==null)
            return 0;
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
		int square = 0;
		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
				}
				if (square < dp[i][j]) {
					square = dp[i][j];
				}
			}
		}
		return square*square;
	}

	public static void main(String[] args) {
		MaximalSquare leet = new MaximalSquare();
		//char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
			//	{ '1', '0', '0', '1', '0' } };
		char[][] matrix = {{'0','1'}};
		System.out.println(leet.maximalSquare(matrix));
	}

}
