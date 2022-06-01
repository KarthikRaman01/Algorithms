package com.recursion.basic;

/**
 * F(N) = last digit(N%10) * 10 power (digit-1) + F(N/10)
 * 
 * 
 * @author Karthik
 *
 */
public class ReverseANumber {

	public static void main(String[] args) {
		System.out.println(reverseANumber(532));
		System.out.println(reverseANumberRecursive(53252));
		System.out.println(reverseANumberRecursive2(53252));

	}

	public static int reverseANumber(int n) {
		if (n <= 0) {
			return n;
		}

		int digits = numberOfDigits(n);
		int ans = 0;
		while (n > 0) {
			int remainder = n % 10;
			ans = (int) (ans + remainder * Math.pow(10, digits - 1));
			n = n / 10;
			digits = digits - 1;
		}

		return ans;
	}

	public static int reverseANumberRecursive(int n) {
		if (n % 10 == n) {
			return n;
		}

		int digits = numberOfDigits(n);
		int remainder = n % 10;
		int ans = (int) (remainder * Math.pow(10, digits - 1) + reverseANumberRecursive(n / 10));

		return ans;
	}

	/**
	 * can also do Math.log10(n) for the number of digits
	 * @param n
	 * @return
	 */
	public static int numberOfDigits(int n) {
		int count = 0;
		while (n > 0) {
			n = n / 10;
			count++;
		}
		return count;
	}

	static int sum = 0;
	public static int reverseANumberRecursive2(int n) {
		if (n <= 0) {
			return sum;
		}
		int rem = n % 10;
		sum = (sum * 10) + rem;
		return reverseANumberRecursive2(n / 10);
	}

}
