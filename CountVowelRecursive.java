package ds.algo.solutions;

public class CountVowelRecursive {

	public static void main(String[] args) {
		
		String str = "hello world";
		System.out.println(countVowels(str, str.length() - 1));
	}

	private static boolean isVowel(char ch) {
		return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || 
				ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
	
	private static int countVowels(String str, int pos) {
		if (pos == 1)
			return isVowel(str.charAt(pos - 1)) ? 1 : 0;
		
		return countVowels(str, pos - 1) + (isVowel(str.charAt(pos - 1)) ? 1 : 0);
	}
}
