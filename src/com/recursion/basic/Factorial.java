package com.recursion.basic;

/**
 * Recurrence relation - f(n) = n * f(n-1)
 * @author Karthik
 *
 */
public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(factorialRecursive(5, 1));
		System.out.println(factorialRecursive(5));
	}

	public static int factorial(int n) {
		if (n < 1) {
			return 0;
		}
		int product = 1;
		while (n > 1) {
			product = product * n;
			n = n - 1;
		}
		return product;

	}

	public static int factorialRecursive(int n, int product) {
		if (n == 1) {
			return product;
		} else {
			product = product * n;
			return factorialRecursive(n - 1, product);
		}
	}

	public static int factorialRecursive(int n) {
		if (n == 1) {
			return 1;
		}
		int fact = n * factorialRecursive(n - 1);
		return fact;
	}

}
