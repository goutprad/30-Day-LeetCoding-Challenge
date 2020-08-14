package com.leetcode.challenge.week.two;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinarySearchTreeFromPreorderTraversal {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		TreeNode root = null;
		for (int i : preorder) {
			root = buildBST(root, i);
		}
		return root;
	}

	public TreeNode buildBST(TreeNode root, int x) {
		TreeNode newNode = new TreeNode(x);
		if (root == null) {
			root = newNode;
			return root;
		}
		if (root.val > x) {
			root.left = buildBST(root.left, x);
		} else {
			root.right = buildBST(root.right, x);
		}
		return root;
	}

	public void levelorder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode presentNode = queue.remove();
			System.out.print(presentNode.val + "\t");
			if (presentNode.left != null) {
				queue.offer(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.offer(presentNode.right);
			}

		}
	}

	public static void main(String[] args) {
		ConstructBinarySearchTreeFromPreorderTraversal leet = new ConstructBinarySearchTreeFromPreorderTraversal();
		int[] preorder = { 8, 5, 1, 7, 10, 12 };
		TreeNode root = leet.bstFromPreorder(preorder);
		leet.levelorder(root);
	}

}
