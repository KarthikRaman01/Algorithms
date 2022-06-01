package com.recursion.basic;

public class CountZeroes {

	public static void main(String[] args) {
		System.out.println(numberOfZeroes(3021));
		System.out.println(numberOfZeroesRecursive(30204));
		System.out.println(numberOfZeroesRecursive(30204, 0));

	}

	public static int numberOfZeroes(int n) {
		int count = 0;
		while (n > 0) {
			if (n % 10 == 0) {
				count = count + 1;
			}
			n = n / 10;
		}
		return count;
	}

	public static int numberOfZeroesRecursive(int n) {
		if (n == 0) {
			return 0;
		}

		int count = 0;
		if (n % 10 == 0) {
			count = 1;
		}

		count = count + numberOfZeroesRecursive(n / 10);
		return count;
	}

	public static int numberOfZeroesRecursive(int n, int count) {
		if (n == 0) {
			return count;
		}

		if (n % 10 == 0) {
			count = count + 1;
		}

		return numberOfZeroesRecursive(n / 10, count);
	}

}
