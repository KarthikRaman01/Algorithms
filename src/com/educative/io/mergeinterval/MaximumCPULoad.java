package com.educative.io.mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumCPULoad {

	public static void main(String[] args) {
		List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
		System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

		input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
		System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

		input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
		System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
	}

	public static int findMaxCPULoad(List<Job> jobs) {
		Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
		int maxSum = 0;
		int end = jobs.get(0).end;
		int index = 1;
		int sum = jobs.get(0).cpuLoad;
		while (index < jobs.size()) {
			if (jobs.get(index).start <= end) {
				end = Math.max(end, jobs.get(index).end);
				sum = sum + jobs.get(index).cpuLoad;
			} else {

				end = jobs.get(index).end;
				if (sum > maxSum) {
					maxSum = sum;
				}
				sum = jobs.get(index).cpuLoad;
			}

			index++;

		}

		if (sum > maxSum) {
			maxSum = sum;
		}

		return maxSum;
	}

}

class Job {
	int start;
	int end;
	int cpuLoad;

	public Job(int start, int end, int cpuLoad) {
		this.start = start;
		this.end = end;
		this.cpuLoad = cpuLoad;
	}
};
