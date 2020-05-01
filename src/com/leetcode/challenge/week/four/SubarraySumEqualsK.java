package com.leetcode.challenge.week.four;

import java.util.Arrays;
import java.util.HashMap;

public class SubarraySumEqualsK {
	/*
	 * Time Complexity - O(n3) Space - o(1)
	 */
	public int subarraySum_bruteforce(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j <= nums.length; j++) {
				int sum = 0;
				for (int l = i; l < j; l++) {
					sum += nums[l];
				}
				if (sum == k)
					count++;
			}
		}
		return count;
	}

	public int subarraySum_CumulativeSum(int[] nums, int k) {
		int count = 0;
		int[] sum = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j <= nums.length; j++) {
				if (sum[j] - sum[i] == k)
					count++;
			}
		}
		return count;
	}

	public int subarraySum_Approach3(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == k)
					count++;
			}
		}
		return count;
	}
	public int subarraySum(int[] nums, int k) {
		int count=0;
        int sum =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
		for (int i = 0; i < nums.length; i++) {
           sum += nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum, 0)+1);
		}
		return count;
	}

	public static void main(String[] args) {
		SubarraySumEqualsK leetcode = new SubarraySumEqualsK();
		int[] nums = { 1, 1, 1 };
		int k = 2;
		System.out.println(leetcode.subarraySum_bruteforce(nums, k));
		System.out.println(leetcode.subarraySum_CumulativeSum(nums, k));
		System.out.println(leetcode.subarraySum(nums, k));
	}

}
