package ds.algo.solutions;

import java.util.stream.Stream;

public class MergeSort {
	
	public void mergeSort(Integer[] integers, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(integers, l, m);
			mergeSort(integers, m + 1, r);

			merge(integers, l, m, r);
		}
	}

	private void merge(Integer[] integers, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = integers[l + i];
		}

		for (int i = 0; i < n2; i++) {
			R[i] = integers[m + 1 + i];
		}

		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				integers[k++] = L[i++];
			} else {
				integers[k++] = R[j++];
			}
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			integers[k++] = L[i++];
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			integers[k++] = R[j++];
		}

	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {0, 9, 7, 6, 1, 3, 5, 2, 4, 8};
		new MergeSort().mergeSort(arr, 0, arr.length - 1);
		Stream.of(arr).forEach(System.out::println);
	}
	
}
