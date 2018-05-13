package ds.algo.solutions;

public class ReverseArrayWithoutAffectingSpecialChars {

	public static void main(String[] args) {
		String str = "Ab,c,de!$";
		char[] arr = str.toCharArray();
		
		int start = 0;
		int end = arr.length - 1;
		char temp;
		
		System.out.println("Before");
		System.out.println(arr);
		
		while (start < end) {
			if (isAlphabet(arr[start]) && isAlphabet(arr[end])) {
				temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++; end--;
				continue;
			}
			if (!isAlphabet(arr[start])) {
				start++;
			}
			if (!isAlphabet(arr[end])) {
				end--;
			}
		}
		
		
		System.out.println("After");
		System.out.println(arr);
	}
	
	private static boolean isAlphabet(char ch) {
		return ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122; 
	}
}
