package com.recursion.medium.leetcode;

/**
 * still needs work
 * @author Karthik
 *
 */
public class CountGoodNumbers {

	public static void main(String[] args) {
		System.out.println(countGoodNumbers(4));
	}

	public static int countGoodNumbers(long n) {
		int count = 0;
		long start = (long) getFirstNumberForIterationEnd(n);
		long end = (long) getLastNumberForIterationEnd(n);
		for (long i = start; i < end; i++) {
			if (isGoodNumber(i)) {
				count++;
			}
		}

		return count;
	}

	public static boolean isGoodNumber(long num) {
		int count = 1;
		while (num > 0) {
			long lastNumber = num % 10;
			if ((count & 1) == 0) {
				if (!((lastNumber & 1) == 0)) {
					return false;
				}

			} else {
				if (!isPrime(lastNumber)) {
					return false;
				}
			}
			num = num / 10;
			count++;
		}
		return true;
	}

	public static boolean isPrime(double num) {
		if (num == 0 || num == 1) {
			return false;
		}

		if (num == 2) {
			return true;
		}

		int finalCount = (int) Math.sqrt(num);
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;

	}

	public static double getLastNumberForIterationEnd(long n) {
		return Math.pow(10, n);
	}

	public static double getFirstNumberForIterationEnd(long n) {
		if (n == 1) {
			return 0;
		}
		return Math.pow(10, n - 1);
	}

}
