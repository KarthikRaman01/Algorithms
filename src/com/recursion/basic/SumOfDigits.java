package com.recursion.basic;

/**
 * Recurrence relation --> f(n) = n%10 + f(n/10)
 * 
 * @author Karthik
 *
 */
public class SumOfDigits {

	public static void main(String[] args) {
		System.out.println(sumOfDigits(1342));
		System.out.println(sumOfDigitsRecursive(1342));
	}

	public static int sumOfDigits(int n) {
		int sum = 0;
		while (n > 0) {
			int remainder = n % 10;
			n = n / 10;
			sum = sum + remainder;
		}
		return sum;

	}

	public static int sumOfDigitsRecursive(int n) {
		if (n == 0) {
			return 0;
		}

		int sum = n % 10 + sumOfDigitsRecursive(n / 10);
		return sum;

	}

}
