package com.leetcode.challenge.week.two;

import java.util.HashMap;

public class ContiguousArray {
	public int findMaxLength(int[] nums) {
		HashMap<Integer, Integer> countsMap = new HashMap<Integer, Integer>();
		countsMap.put(0,-1);
		int maxLength = 0;
		int count=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0) {
				count += -1;
			} else {
				count += 1;
			}
			if(countsMap.containsKey(count)) {
				maxLength = Math.max(maxLength, i-countsMap.get(count));
			} else {
				countsMap.put(count, i);
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		ContiguousArray leetcode = new ContiguousArray();
		int[] nums = {0,1,1};
		System.out.println(leetcode.findMaxLength(nums));
	}

}
