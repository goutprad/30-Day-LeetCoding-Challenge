package com.leetcode.challenge.week.three;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int noOfIslands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					visitIsland_DFS(grid, i, j);
					noOfIslands += 1;
				}
			}
		}
		return noOfIslands;
	}

	public void visitIsland_DFS(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
			return;
		}
		grid[i][j] = '2';
		visitIsland_DFS(grid, i - 1, j);
		visitIsland_DFS(grid, i + 1, j);
		visitIsland_DFS(grid, i, j - 1);
		visitIsland_DFS(grid, i, j + 1);
	}

	public static void main(String[] args) {
		NumberOfIslands leet = new NumberOfIslands();
		//char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
		//		{ '0', '0', '0', '0', '0' } };
		char[][] grid = {{'1'},{'1'}};
		System.out.println(leet.numIslands(grid));
	}

}
