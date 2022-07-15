package com.educative.io.twopointers;

public class TrappingRainWater {

	public static void main(String[] args) {
		int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(height));
	}

	public static int trap(int[] height) {
		int trapWater = 0;
		int low = 0;
		int high = height.length - 1;

		// first few zeroes skip
		for (int i = 0; i < height.length; i++) {
			if (height[i] != 0) {
				break;
			}
			low++;
		}

		// iterate over the array - low < high
		while (low < high) {

			// find the next big high --> equal or greater than low
			int i = low + 1;
			while (i <= height.length - 1) {
				if (height[i] >= height[low]) {
					break;
				}
				i++;
			}

			if (i == height.length) {
				break;
			}

			// calculate the area --> add it to global variable
			trapWater = trapWater + calculateArea(height, low, i);

			// low pointer --> high index + 1
			low = i;

		}

		return trapWater;

	}

	private static int calculateArea(int[] height1, int low, int high) {
		int maxSaveHeight = Math.min(height1[low], height1[high]);
		int area = maxSaveHeight * (high - low - 1);
		for (int i = low + 1; i < high; i++) {
			area = area - height1[i];
		}

		return area;
	}

}
