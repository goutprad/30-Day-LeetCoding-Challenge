package com.leetcode.challenge.week.two;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); //Max Heap
		for (int i = 0; i < stones.length; i++) {
			pq.add(stones[i]);
		}
		
		while(pq.size() > 1) {
			pq.add(pq.poll() - pq.poll());
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		int[] stones = { 2, 7, 4, 1, 8, 1 };
		LastStoneWeight leet = new LastStoneWeight();
		System.out.println(leet.lastStoneWeight(stones));
	}

}
