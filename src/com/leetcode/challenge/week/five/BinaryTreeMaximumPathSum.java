package com.leetcode.challenge.week.five;

public class BinaryTreeMaximumPathSum {
	static TreeNode root;
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}
	int max_path_sum;
	public int maxPathSum(TreeNode root) {
		max_path_sum = Integer.MIN_VALUE;
		pathSum(root);
		return max_path_sum;
	}

	public int pathSum(TreeNode node) {
		if (node == null)
			return 0;
		int left = Math.max(0, pathSum(node.left));
		int right = Math.max(0, pathSum(node.right));
		max_path_sum = Math.max(max_path_sum, left + right + node.val);
		return Math.max(left, right) + node.val;
	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum leet = new BinaryTreeMaximumPathSum();
		root= new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(leet.maxPathSum(root));
	}

}
