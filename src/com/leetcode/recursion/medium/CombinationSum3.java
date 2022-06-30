package com.leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {

	static List<List<Integer>> ans = new LinkedList<List<Integer>>();

	public static void main(String[] args) {
		int k = 2, n = 18;
		Long start = System.currentTimeMillis();
		System.out.println(combinationSum3(k, n));
		System.out.println(combinationSum3LC(k, n));
		Long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		return helper(k, new ArrayList<Integer>(), n, 1);
	}

	public static List<List<Integer>> helper(int k, List<Integer> processed, Integer unProcessed, Integer nextStart) {
		// base condition to return
		if (unProcessed == 0 && processed.size() == k) {
			Collections.sort(processed);
			if (!ans.contains(processed)) {
				ans.add(processed);
			}
			return ans;
		}

		for (Integer i = nextStart; i <= 9; i++) {
			if (!(processed.contains(i))) {
				List<Integer> tempList = getNewList(processed, i);
				helper(k, tempList, unProcessed - i, i + 1);
			}

		}
		return ans;
	}

	public static List<Integer> getNewList(List<Integer> processed, Integer addNum) {
		List<Integer> newList = new ArrayList<>(processed);
		newList.add(addNum);
		return newList;
	}

	public static void backtrack(int remain, int k, LinkedList<Integer> comb, int next_start,
			List<List<Integer>> results) {

		if (remain == 0 && comb.size() == k) {
			// Note: it's important to make a deep copy here,
			// Otherwise the combination would be reverted in other branch of backtracking.
			results.add(new ArrayList<Integer>(comb));
			return;
		} else if (remain < 0 || comb.size() == k) {
			// Exceed the scope, no need to explore further.
			return;
		}

		// Iterate through the reduced list of candidates.
		for (int i = next_start; i < 9; ++i) {
			comb.add(i + 1);
			backtrack(remain - i - 1, k, comb, i + 1, results);
			comb.removeLast();
		}
	}

	public static List<List<Integer>> combinationSum3LC(int k, int n) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		LinkedList<Integer> comb = new LinkedList<Integer>();

		backtrack(n, k, comb, 0, results);
		return results;
	}

}
