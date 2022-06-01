package com.recursion.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Leetcode - https://leetcode.com/problems/fibonacci-number/
 * @author Karthik
 *
 */

//Recurrence relation
//fib(n) = fib(n-1) + fib(n-2);
public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(num + " th fibonacci number is: " + fibonacci(num - 1));

		System.out.println(num + " th fibonacci number separate process is: " + fibonacciSeparate(num - 1));

		System.out.println("Printing all the fibonacci numbers: ");
		printFibonacci(num);
		System.out.println("");
		System.out.println(num + " th fibonacci number through iterative process is: " + fibonacciIterative(num));

	}

	public static int fibonacci(int number) {
		if (number <= 0 || number == 1) {
			return number;
		}
		int fibNumber = fibonacci(number - 1) + fibonacci(number - 2);
		return fibNumber;
	}

	public static int fibonacciSeparate(int number) {
		if (number <= 0 || number == 1) {
			return number;
		}
		int fibNumber1 = fibonacci(number - 1);
		int fibNumber2 = fibonacci(number - 2);
		return fibNumber1 + fibNumber2;
	}

	public static void printFibonacci(int num) {
		for (int i = 0; i < num; i++) {
			if (i == 0 || i == 1) {
				System.out.print(i);
			} else {
				System.out.print(fibonacci(i));
			}
		}
	}

	public static int fibonacciIterative(int number) {
		if (number <= 0 || number == 1) {
			return number;
		}

		List<Integer> fibNumbers = new ArrayList<Integer>();
		fibNumbers.add(0, 0);
		fibNumbers.add(1, 1);

		for (int i = 2; i <= number; i++) {
			int value = fibNumbers.get(i - 1) + fibNumbers.get(i - 2);
			fibNumbers.add(i, value);
		}

		return fibNumbers.get(number);
	}

}
