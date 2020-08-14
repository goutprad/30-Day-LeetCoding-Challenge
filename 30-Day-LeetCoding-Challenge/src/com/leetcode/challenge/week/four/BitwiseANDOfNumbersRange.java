package com.leetcode.challenge.week.four;

public class BitwiseANDOfNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		int count=0;
		while(m!=n) {
			m = m>>1;
			n=n>>1;
			count++;
		}
		return m<<=count;
	}

	public static void main(String[] args) {
		BitwiseANDOfNumbersRange leet = new BitwiseANDOfNumbersRange();
		System.out.println(leet.rangeBitwiseAnd(5, 7));
	}
}
