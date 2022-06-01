package com.recursion.basic;

public class ProductOfDigits {

	public static void main(String[] args) {
		System.out.println(productOfDigits(1342));
		System.out.println(productOfDigitsRecursive(0134));
	}

	public static int productOfDigits(int n) {
		int product = 1;
		while (n > 0) {
			int remainder = n % 10;
			n = n / 10;
			product = product * remainder;
		}
		return product;

	}

	public static int productOfDigitsRecursive(int n) {
		// if the last number is one digit, just return the number
		if (n % 10 == n) {
			return n;
		}

		int product = n % 10 * productOfDigitsRecursive(n / 10);
		return product;

	}

}
