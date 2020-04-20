package com.leetcode.challenge.week.three;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	/**
	 * Brute force - With using division
	 * 
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf_1(int[] nums) {
		int prod=1;
		for (int i = 0; i < nums.length; i++) {
			prod *= nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = prod/nums[i];
		}
		System.out.println(prod);
		return nums;
	}
	
	public int[] productExceptSelf_2(int[] nums) {
		int[] leftProducts = new int[nums.length];
		int[] rightProducts = new int[nums.length];
		leftProducts[0] =1;
		rightProducts[nums.length-1]=1;
		
		for (int i = 1; i < nums.length; i++) {
			leftProducts[i] = nums[i-1]*leftProducts[i-1];
		}
		for (int i = nums.length-2; i>=0; i--) {
			rightProducts[i] = nums[i+1]*rightProducts[i+1];
		}
		for (int i = 0; i < rightProducts.length; i++) {
			nums[i] = leftProducts[i] * rightProducts[i];
		}
		return nums;
	}
	
	public int[] productExceptSelf(int[] nums) {
		int[] output=new int[nums.length];
		output[0]=1;
		for (int i = 1; i < output.length; i++) {
			output[i]= nums[i-1]*output[i-1];
		}
		int r=1;
		for (int i = nums.length-1; i >= 0; i--) {
			output[i] = output[i] * r;
			r = r* nums[i];
		}
		return output;
	}
	

	public static void main(String[] args) {
		ProductOfArrayExceptSelf leet  = new ProductOfArrayExceptSelf();
		int[] nums = { 1, 2, 3, 4 };
		int[] result = leet.productExceptSelf(nums);
		System.out.println(Arrays.toString(result));
	}

}
