package com.educative.io.TopKElements;

import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPointsToTheOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] kClosest(int[][] points, int k) {
		 PriorityQueue<int[][]> maxHeap = new PriorityQueue<>((points[0][0], points[1][0]) -> squares(points[1][0]) - squares(points[0][0]));
		 for(int i=0; i<k; i++) {
			
		}

	}

	public int squares(int[] x) {
		return x[0] * x[0] + x[1] * x[1];

	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
