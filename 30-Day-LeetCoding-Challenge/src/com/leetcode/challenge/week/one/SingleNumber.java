package com.leetcode.challenge.week.one;

/**
 * https://leetcode.com/problems/single-number/
 * Input: [2,2,1]
 * Output: 1
 * 
 * @author Goutam
 *
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
		int s = 0;
		for (int i = 0; i < nums.length; i++) {
			s = s ^ nums[i];
		}
		return s;
	}

	public static void main(String[] args) {
		SingleNumber leetcode = new SingleNumber();
		int[] nums = { 2, 2, 1 };
		System.out.println(leetcode.singleNumber(nums));
	}
}
