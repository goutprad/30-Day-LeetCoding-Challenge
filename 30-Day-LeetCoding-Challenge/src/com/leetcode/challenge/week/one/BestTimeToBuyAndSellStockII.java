package com.leetcode.challenge.week.one;

public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				max += prices[i] - prices[i - 1];
			}
		}
		return max;
	}

	public int maxProfit_02(int[] prices) {
		int max = 0;
		int low = 0;
		int high = 0;
		for (int i = 0; i < prices.length; i++) {
			while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
				i++;
			}
			low = prices[i];

			while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
				i++;
			}
			high = prices[i];
			max += high - low;
		}
		return max;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStockII leetcode = new BestTimeToBuyAndSellStockII();
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(leetcode.maxProfit(prices));
		System.out.println(leetcode.maxProfit_02(prices));
	}

}
