package com.leetcode.challenge.week.two;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class DiameterOfBinaryTree {
	public int diameterOfBinaryTree(TreeNode root) {
		if(root != null) {
			int lHeight = getHeight(root.left);
			int rHeight = getHeight(root.right);
			
			int lDiameter = diameterOfBinaryTree(root.left);
			int rDiameter = diameterOfBinaryTree(root.right);
			return Math.max(lHeight+rHeight, Math.max(lDiameter, rDiameter));
		}
		return 0;
	}
	
	public int getHeight(TreeNode root) {
		if(root != null) {
			return 1+Math.max(getHeight(root.left), getHeight(root.right));
		}
		return 0;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.left.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);

		DiameterOfBinaryTree diameter = new DiameterOfBinaryTree();
		System.out.println(diameter.getHeight(root));
		System.out.println(diameter.diameterOfBinaryTree(root));
	}

}
