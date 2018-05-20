package ds.algo.solutions;

public class MergeTwoSortedArray {

	public int[] merge(int[] arr1, int[] arr2) {
		
		int arr1Len = arr1.length;
		int arr2Len = arr2.length;
		int i = 0, x = 0, y = 0;
		
		int[] resultArr = new int[arr1Len + arr2Len];
		
		while (x < arr1Len && y < arr2Len) {
			if(arr1[x] < arr2[y]) {
				resultArr[i] = arr1[x];
				x++;
			}
			else {
				resultArr[i] = arr2[y];
				y++;
			}
			
			i++;
		}
		
		for (int q = x; q < arr1.length; q++) {
			resultArr[i++] = arr1[q];
		}
		
		for (int q = y; q < arr2.length; q++) {
			resultArr[i++] = arr2[q];
		}
		
		return resultArr;
	}
	
	public static void main(String[] args) {
		int[] arr1 = new int[] {2, 6, 8, 41};
		int[] arr2 = new int[] {20, 60, 80, 90};
		
		int a[] = new MergeTwoSortedArray().merge(arr1, arr2);
		for(int i : a) {
			System.out.println(i);
		}
	}
}
