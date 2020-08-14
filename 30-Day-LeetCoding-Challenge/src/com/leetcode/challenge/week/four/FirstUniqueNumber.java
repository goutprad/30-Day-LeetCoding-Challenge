package com.leetcode.challenge.week.four;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueNumber {
	private HashMap<Integer, Integer> map;
	private Queue<Integer> queue;

	public FirstUniqueNumber(int[] nums) {
		map = new HashMap<Integer, Integer>();
		queue = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
			queue.offer(nums[i]);
		}
	}

	public void add(int value) {
		if (map.containsKey(value)) {
			map.put(value, map.get(value) + 1);
		} else {
			map.put(value, 1);
			queue.offer(value);
		}
	}

	public int showFirstUnique() {
		while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
			queue.poll();
		}
		if (queue.isEmpty()) {
			return -1;
		}
		return queue.peek();
	}

	public void print() {
		System.out.println(map);
		System.out.println(queue);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3, 2, 4 };
		FirstUniqueNumber leet = new FirstUniqueNumber(nums);
		System.out.println(leet.showFirstUnique());
		leet.add(5);
		leet.add(1);
		System.out.println(leet.showFirstUnique());
		leet.add(4);
		leet.print();
	}

}
