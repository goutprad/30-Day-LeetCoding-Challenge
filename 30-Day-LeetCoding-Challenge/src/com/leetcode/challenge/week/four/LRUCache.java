package com.leetcode.challenge.week.four;

import java.util.LinkedHashMap;

public class LRUCache {
	private LinkedHashMap<Integer, Integer> cache;
	private int capacity;

	public LRUCache(int capacity) {
		cache = new LinkedHashMap<Integer, Integer>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			int val = cache.get(key);
			cache.remove(key);
			cache.put(key, val);
			return val;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			cache.remove(key);
		} else if (cache.size() == capacity) {
			cache.remove(cache.keySet().iterator().next());
		}
		cache.put(key, value);
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(2, 3);
		cache.put(2, 2);
		System.out.println(cache.get(2));
		cache.put(1, 1);
		cache.put(4, 1);
		System.out.println(cache.get(2));

	}

}
