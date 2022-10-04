package org.howard.edu.lsp.assignment3;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public void recurse(int[] arr, int target, List<Integer> curr, List<List<Integer>> all_sets, int start) {
		int i, sum = 0;
		for (i = 0; i < curr.size(); i++) {
			int index = curr.get(i);
			sum += arr[index];
		}
		if (sum == target) {
			all_sets.add(curr);
			return ;
		}
		
		for (i = start; i < arr.length; i++) {
			List<Integer> temp = new ArrayList<Integer>(curr);
			temp.add(i);
			recurse(arr, target, temp, all_sets, i+1);
		}
	}
	
	public void compute(int[] input, int target_sum) {
		List<List<Integer>> sets = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();
		
		recurse(input, target_sum, curr, sets, 0);
		System.out.println(sets);
	}
}
