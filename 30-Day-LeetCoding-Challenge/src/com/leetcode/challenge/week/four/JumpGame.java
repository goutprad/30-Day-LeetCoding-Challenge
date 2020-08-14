package com.leetcode.challenge.week.four;

public class JumpGame {
	public boolean canJump(int[] nums) {
		int reachedSofar = 0;
		for (int i = 0; i < nums.length; i++) {
			if(reachedSofar < i) {
				return false;
			}
			reachedSofar = Math.max(reachedSofar, nums[i]+i);
		}
		return true;
	}
	
	public boolean canJump_02(int[] nums) {
		int reachedSofar = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]+i > reachedSofar) {
				reachedSofar = nums[i] + i;
			}
			if(reachedSofar == i)
				break;
		}
		return reachedSofar >= nums.length-1;
	}

	public static void main(String[] args) {
		JumpGame leet = new JumpGame();
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(leet.canJump(nums));
	}
}
