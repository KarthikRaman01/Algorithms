package com.educative.io.dfs;

import java.util.ArrayList;
import java.util.List;

public class PathWithGivenSequence {

	public static void main(String[] args) {
		TreeN root = new TreeN(1);
		root.left = new TreeN(0);
		root.right = new TreeN(1);
		root.left.left = new TreeN(1);
		root.right.left = new TreeN(6);
		root.right.right = new TreeN(5);

		int[] sequence = { 1, 1, 6 };
		String seq = new String();
		for (Integer val : sequence) {
			seq = seq + val.toString();
		}
		System.out.println(PathWithGivenSequence(root, "", seq));
		System.out.println(findPath(root, sequence, new ArrayList<Integer>()));

	}

	public static boolean PathWithGivenSequence(TreeN root, String processed, String seq) {
		// null check
		if (root == null) {
			return false;
		}

		Integer value = root.val;
		String currentPath = processed + value.toString();
		// leaf node check
		if (root.left == null && root.right == null) {
			if (currentPath.equalsIgnoreCase(seq)) {
				System.out.println(seq);
				return true;
			}
			return false;
		}

		// left paths
		Boolean leftPath = PathWithGivenSequence(root.left, currentPath, seq);

		// rightPath
		Boolean rightPath = PathWithGivenSequence(root.right, currentPath, seq);

		return leftPath || rightPath;

	}

	public static boolean findPath(TreeN root, int[] sequence, List<Integer> pathValues) {
		if (root == null) {
			return false;
		}

		pathValues.add(root.val);

		// leaf node check
		if (root.left == null && root.right == null) {
			if (isIdentical(sequence, pathValues)) {
				System.out.println(pathValues);
				pathValues.remove(pathValues.size() - 1);
				return true;
			}
			pathValues.remove(pathValues.size() - 1);
			return false;
		}

		if (pathValues != null && pathValues.size() > 0) {
			if (!isIdentical(sequence, pathValues)) {
				System.out.println(pathValues);
				pathValues.remove(pathValues.size() - 1);
				return false;
			}
		}

		boolean leftPath = findPath(root.left, sequence, pathValues);
		boolean rightPath = findPath(root.right, sequence, pathValues);
		pathValues.remove(pathValues.size() - 1);

		return leftPath || rightPath;
	}

	public static boolean isIdentical(int[] sequence, List<Integer> pathValues) {
		for (int start = 0; start < pathValues.size(); start++) {
			if (pathValues.get(start) != sequence[start]) {
				return false;
			}
		}
		return true;

	}
}

class TreeN {
	TreeN left;
	TreeN right;
	int val;

	public TreeN(int val) {
		this.val = val;
	}
}
