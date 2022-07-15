package com.educative.io.twopointers;

public class ContainerWithMostWater {

	public static void main(String[] args) {

		int[] height = { 1, 1 };
		System.out.println(maxArea1(height));

	}

	public static int maxArea(int[] height) {
		int sum = Integer.MIN_VALUE;

		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {

				int min = Math.min(height[i], height[j]);

				int area = (j - i) * min;
				if (area > sum) {
					sum = area;
				}
			}
		}

		return sum;

	}

	public static int maxArea1(int[] height) {
		int sum = Integer.MIN_VALUE;

		int low = 0;
		int high = height.length - 1;
		while (low < high) {
             int baseHeight = Math.min(height[low], height[high]);
             int area = baseHeight * (high - low);
             if(area > sum) {
            	 sum = area;
             }
             
             if(height[low] < height[high]) {
            	 low++;
             }else if(height[low] == height[high]) {
            	 low++;
            	 high--;
             }else {
            	 high--;
             }
             
		}

		return sum;

	}

}
