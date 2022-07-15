package com.educative.io.twopointers;

import java.util.Arrays;

public class SquaringASortedArray {

	public static void main(String[] args) {
		int[] arr = { -2, -1, 1, 2, 3 };
		int[] output = makeSquares(arr);
		System.out.println(Arrays.toString(output));
	}

	public static int[] makeSquares(int[] arr) {
		int[] squares = new int[arr.length];
		int outPutIndex = squares.length - 1;

		int startPointer = 0;
		int endPointer = squares.length - 1;

		while (startPointer <= endPointer) {
			int squareOfStart = arr[startPointer] * arr[startPointer];
			int squareOfEnd = arr[endPointer] * arr[endPointer];
			if (squareOfStart > squareOfEnd) {
				squares[outPutIndex] = squareOfStart;
				startPointer++;
			} else {
				squares[outPutIndex] = squareOfEnd;
				endPointer--;

			}
			outPutIndex--;

		}

		return squares;
	}

}
