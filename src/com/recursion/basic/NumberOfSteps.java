package com.recursion.basic;

/**
 * Leetcode -
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * 
 * @author Karthik
 *
 */
public class NumberOfSteps {

	public static void main(String[] args) {
		System.out.println(numberOfSteps(14));
		System.out.println(numberOfStepsRec(14));

	}

	public static int numberOfSteps(int num) {
		int count = 0;
		while (num > 0) {
			if ((num & 1) == 0) {
				num = num / 2;
			} else {
				num = num - 1;
			}
			count++;
		}
		return count;
	}

	public static int numberOfStepsRec(int num) {
		return helper(num, 0);
	}

	public static int helper(int num, int count) {
		if (num == 0) {
			return count;
		}

		if ((num & 1) == 0) {
			num = num / 2;
		} else {
			num = num - 1;
		}

		return helper(num, count + 1);
	}

}
