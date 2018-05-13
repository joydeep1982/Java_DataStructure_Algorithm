package ds.algo.solutions;

import java.util.ArrayList;
import java.util.List;

public class MergeNSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = new int[] {1, 5, 9, 10, 90, 91};
		int[] arr2 = new int[] {2, 6, 11, 50, 51};
		int[] arr3 = new int[] {3, 7, 18, 19};
		int[] arr4 = new int[] {4, 8, 30, 35};
		int[] arr5 = new int[] {};
		
		int[] res = new MergeNSortedArrays().mergeNArrays(arr1, arr2, arr3, arr4, arr5);
		for (int i : res) {
			System.out.println(i);
		}
	}
	
	public int[] mergeNArrays(int[]...arrays) {
		
		int totalLen = 0;
		List<Integer> counters = new ArrayList<>();
		
		for (int[] array : arrays) {
			totalLen += array.length;
			counters.add(0);
		}
		
		int[] resultArr = new int[totalLen];
		int index = 0;
		
		while(index < totalLen) {
			resultArr[index++] = getMin(arrays, counters);
		}
		
		return resultArr;
	}

	private int getMin(int[][] arrays, List<Integer> counters) {
		int min = Integer.MAX_VALUE;
		int val, index;
		int arrayIndex = -1;
		
		for (int i = 0; i < arrays.length; i++) {
			index = counters.get(i);
			if (index > arrays[i].length - 1) {
				continue;
			}
			val = arrays[i][index];
			if (val < min) {
				min = val;
				arrayIndex = i;
			}
		}
		counters.set(arrayIndex, counters.get(arrayIndex) + 1);
		
		return min;
	}
}
