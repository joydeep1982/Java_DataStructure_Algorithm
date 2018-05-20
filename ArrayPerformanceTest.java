package ds.algo.solutions;

public class ArrayPerformanceTest {

	public static int[][] getArray(int rows, int cols) {
		int[][] arr = new int[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arr[i][j] = 1;
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		
		int rows = 10000;
		int cols = 30000;
		int[][] arr = getArray(rows, cols);
		
		long start = System.currentTimeMillis();
		int sum = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				sum += arr[i][j];
			}
		}
		long timeTaken = System.currentTimeMillis() - start;
		System.out.println("Sum: " + sum + " Time taken: " + timeTaken + " mills");
		
		
		start = System.currentTimeMillis();
		sum = 0;
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				sum += arr[j][i];
			}
		}
		timeTaken = System.currentTimeMillis() - start;
		System.out.println("Sum: " + sum + " Time taken: " + timeTaken + " mills");
	}
}
