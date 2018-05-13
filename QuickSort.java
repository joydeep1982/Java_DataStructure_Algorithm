package ds.algo.solutions;

import java.util.stream.Stream;

public class QuickSort {

	public void quickSort(Integer[] integers, int low, int high) {

		if (low < high) {
			int pi = partition(integers, high, low);

			quickSort(integers, low, pi - 1);
			quickSort(integers, pi + 1, high);
		}
	}

	private int partition(Integer[] integers, int high, int low) {
		int pivot = high;
		int i = low - 1;
		int temp;

		for (int j = low; j < pivot; j++) {
			if (integers[j] < integers[pivot]) {
				i++;
				temp = integers[i];
				integers[i] = integers[j];
				integers[j] = temp;
			}
		}

		temp = integers[i + 1];
		integers[i + 1] = integers[pivot];
		integers[pivot] = temp;

		return i + 1;
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {0, 9, 7, 6, 1, 3, 5, 2, 4, 8};
		new QuickSort().quickSort(arr, 0, arr.length - 1);
		Stream.of(arr).forEach(System.out::println);
	}
}
