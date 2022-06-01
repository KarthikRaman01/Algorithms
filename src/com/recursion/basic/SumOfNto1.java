package com.recursion.basic;

/*
 * Recurrence relation --> f(n) = n + f(n-1)
 */
public class SumOfNto1 {

	public static void main(String[] args) {
		System.out.println(sumOf1ToN(5));

	}

	public static int sumOf1ToN(int n) {
		if (n == 1) {
			return 1;
		}
		int sum = n + sumOf1ToN(n - 1);
		return sum;
	}

}
