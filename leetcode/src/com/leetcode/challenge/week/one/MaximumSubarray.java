package com.leetcode.challenge.week.one;

public class MaximumSubarray {

	int start = 0;
	int end = 0;

	/**
	 * Bruteforce 
	 * Time - O(n^2)
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray_bruteforce(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int currentWindow = 0;
			for (int j = i; j < nums.length; j++) {
				currentWindow = currentWindow + nums[j];
				if (max < currentWindow) {
					max = currentWindow;
					start = i;
					end = j;
				}
			}
		}
		System.out.print("[" + start + " " + end + "]: ");
		return max;
	}

	/**
	 * Dynamic Program approach 
	 * Time - O(n)
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int max_so_far = nums[0];
		int max_ending_here = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max_ending_here = max_ending_here + nums[i];
			max_ending_here = Math.max(max_ending_here, nums[i]);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		return max_so_far;
	}

	public static void main(String[] args) {
		MaximumSubarray leetcode = new MaximumSubarray();
		int[] input = { -2 };
		System.out.println(leetcode.maxSubArray(input));
	}
}
