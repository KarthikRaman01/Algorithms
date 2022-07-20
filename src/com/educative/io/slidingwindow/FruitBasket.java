package com.educative.io.slidingwindow;

import java.util.HashMap;

public class FruitBasket {

	public static void main(String[] args) {
		char[] trees = { 'A', 'B', 'C', 'B', 'B', 'C' };
		System.out.println(fruitBasket(trees, 2));

	}

	private static int fruitBasket(char[] trees, int k) {
		if (trees == null || trees.length == 0) {
			return 0;
		}

		int windowStart = 0;
		int length = 0;

		HashMap<Character, Integer> count = new HashMap<>();

		for (int windowEnd = 0; windowEnd < trees.length; windowEnd++) {
			if (count.containsKey(trees[windowEnd])) {
				count.put(trees[windowEnd], count.get(trees[windowEnd]) + 1);
			} else {
				count.put(trees[windowEnd], 1);
			}

			while (count.size() > k) {
				char remove = trees[windowStart];
				count.put(remove, count.get(remove) - 1);
				if (count.get(remove) == 0) {
					count.remove(remove);
				}
				windowStart++;

			}

			length = Math.max(length, windowEnd - windowStart + 1);
			 
			

		}

		return length;

	}

}
