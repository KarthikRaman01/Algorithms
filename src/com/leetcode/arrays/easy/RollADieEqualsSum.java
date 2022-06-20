package com.leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class RollADieEqualsSum {

	public static void main(String[] args) {
		Integer sum = 4;
		rollDieEqualsSum(sum);
		rollDieEqualsSum2(sum);
		rollDieEqualsSum3Recursive("", "123456", sum);
		rollDieEqualsSum4Recursive("", "123456", sum);
		System.out.println("----------");
		rollDieEqualsSum5Recursive("", 4);

	}

	public static void rollDieEqualsSum(int sum) {
		List<List<Integer>> dieRolls = new ArrayList<>();

		int iterationCount = sum < 7 ? sum : 7;
		for (int i = 1; i < iterationCount; i++) {
			for (int j = 1; j < 7; j++) {
				if (i + j == sum) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					list.add(j);
					dieRolls.add(list);
				}
			}
		}

		System.out.println(dieRolls);
	}

	public static void rollDieEqualsSum2(int sum) {
		List<List<Integer>> dieRolls = new ArrayList<>();

		int iterationCount = sum < 7 ? sum : 7;
		for (int i = 1; i < iterationCount; i++) {
			int otherDie = sum - i;
			if (!(otherDie > 6)) {
				List<Integer> ans = new ArrayList<>();
				ans.add(otherDie);
				ans.add(i);
				dieRolls.add(ans);

			}

		}

		System.out.println(dieRolls);
	}

	public static void rollDieEqualsSum3Recursive(String p, String up, int sum) {
		if (up.isEmpty()) {
			int tempSum = 0;
			for (int i = 0; i < p.length(); i++) {
				Character ch = p.charAt(i);
				tempSum = tempSum + Integer.parseInt(ch.toString());
			}

			if (tempSum == sum) {
				System.out.println(p);
			}

			return;
		}

		for (Integer i = 1; i < 7; i++) {
			rollDieEqualsSum3Recursive(i.toString() + up.substring(i - 1, i), "", sum);
		}

	}

	public static void rollDieEqualsSum4Recursive(String p, String up, int sum) {
		if (!p.isEmpty()) {
			int tempSum = 0;
			for (int i = 0; i < p.length(); i++) {
				Character ch = p.charAt(i);
				tempSum = tempSum + Integer.parseInt(ch.toString());
			}

			if (tempSum == sum) {
				System.out.println(p);
			}

		}

		if (p.length() > 6) {
			return;
		}

		for (Integer i = 1; i < 7; i++) {
			rollDieEqualsSum4Recursive(p + i.toString(), up, sum);
		}

	}

	public static void rollDieEqualsSum5Recursive(String p, Integer up) {
		if (up == 0) {
			System.out.println(p);
			return;
		}

		for (Integer i = 1; i <= up; i++) {
			rollDieEqualsSum5Recursive(p + i.toString(), up - i);
		}
	}

}
