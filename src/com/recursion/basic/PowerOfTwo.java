package com.recursion.basic;

import java.util.Scanner;

/**
 * Leetcode - https://leetcode.com/problems/power-of-two/
 * @author Karthik
 *
 */
public class PowerOfTwo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int upToNumber = scanner.nextInt();
		System.out.println(isPowerOfTwoRecursive(upToNumber));

	}

	public static boolean isPowerOfTwo(int n) {
		boolean isPowerOfTwo = false;

		if (n < 1) {
			return isPowerOfTwo;
		}
		while (n % 2 == 0) {
			n = n / 2;
		}

		if (n == 1) {
			isPowerOfTwo = true;
		}

		return isPowerOfTwo;

	}

	public static boolean isPowerOfTwoRecursive(int n) {
		if (n < 1) {
			return false;
		}
		if (n == 1) {
			return true;
		}

		if (n % 2 == 0) {
			return isPowerOfTwoRecursive(n / 2);
		}
		return false;

	}

}
