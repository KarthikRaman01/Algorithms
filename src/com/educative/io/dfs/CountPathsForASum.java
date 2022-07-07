package com.educative.io.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CountPathsForASum {

	public static void main(String[] args) {
		TreeKR kr = new TreeKR(12);
		/*
		 * kr.left = new TreeKR(7); kr.right = new TreeKR(9); kr.left.left = new
		 * TreeKR(6); kr.left.right = new TreeKR(5);
		 * 
		 * kr.right.left = new TreeKR(2); kr.right.right = new TreeKR(3);
		 */

		kr.left = new TreeKR(7);
		kr.right = new TreeKR(1);
		kr.left.left = new TreeKR(4);

		kr.right.left = new TreeKR(10);
		kr.right.right = new TreeKR(5);

		System.out.println(CountPathsForASum(kr, 11));

	}

	private static int CountPathsForASum(TreeKR root, int sum) {
		return helper(root, sum, new ArrayList<Integer>());
	}

	private static int helper1(TreeKR node, int count, int sum, List<Integer> maintainList) {
		if (node == null) {
			return 0;
		}

		maintainList.add(node.val);

		if (maintainList.size() > 1) {
			int tempSum = getSumOfPath(maintainList);
			if (tempSum == sum) {
				count = count + 1;
			}
		}

		// leaf node
		if (node.left == null && node.right == null) {
			count = count + getCountMatch(maintainList, sum);
			maintainList.remove(maintainList.size() - 1);
			return count;
		}

		int leftCount = helper1(node.left, count, sum, maintainList);
		int rightCount = helper1(node.right, count, sum, maintainList);
		maintainList.remove(maintainList.size() - 1);
		return leftCount + rightCount;

	}

	private static int getCountMatch(List<Integer> list, int sum) {
		int count = 0;

		for (int i = 1; i < list.size() - 1; i++) {

			int tempSum = 0;
			for (int start = i; start < list.size(); start++) {
				tempSum = tempSum + list.get(start);
			}

			if (tempSum == sum) {
				count++;
			}

		}

		return count;
	}

	private static int getSumOfPath(List<Integer> list) {
		int sum = 0;
		for (Integer val : list) {
			sum = sum + val;
		}
		return sum;
	}

	private static int helper(TreeKR node, int sum, List<Integer> maintainList) {
		if (node == null) {
			return 0;
		}

		maintainList.add(node.val);

		int tempSum = 0, count = 0;
		for (int i = maintainList.size() - 1; i >= 0; i--) {
			tempSum = tempSum + maintainList.get(i);
			if (tempSum == sum) {
				count = count + 1;
			}
		}

		count = count + helper(node.left, sum, maintainList);
		count = count + helper(node.right, sum, maintainList);
		maintainList.remove(maintainList.size() - 1);
		return count;

	}
	
	private static int countPathsRecursive(TreeKR currentNode, int S, List<Integer> currentPath) {
	    if (currentNode == null)
	      return 0;

	    // add the current node to the path
	    currentPath.add(currentNode.val);
	    int pathCount = 0, pathSum = 0;
	    // find the sums of all sub-paths in the current path list
	    ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
	    while (pathIterator.hasPrevious()) {
	      pathSum += pathIterator.previous();
	      // if the sum of any sub-path is equal to 'S' we increment our path count.
	      if (pathSum == S) {
	        pathCount++;
	      }
	    }

	    // traverse the left sub-tree
	    pathCount += countPathsRecursive(currentNode.left, S, currentPath);
	    // traverse the right sub-tree
	    pathCount += countPathsRecursive(currentNode.right, S, currentPath);

	    // remove the current node from the path to backtrack, 
	    // we need to remove the current node while we are going up the recursive call stack.
	    currentPath.remove(currentPath.size() - 1);

	    return pathCount;
	  }

}

class TreeKR {
	TreeKR left;
	TreeKR right;
	int val;

	public TreeKR(int val) {
		this.val = val;
	}
}
