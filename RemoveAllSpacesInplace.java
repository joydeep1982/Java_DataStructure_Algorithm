package ds.algo.solutions;

public class RemoveAllSpacesInplace {

	public static void main(String[] args) {
		String str = " h e        llo wor ld    ";
		
		char[] ch = str.toCharArray();
		System.out.println("Before");
		System.out.println(ch);
		boolean spaceFlag = false;
		int pos = 0;
		int spaceCounter = 0;
		
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ') {
				spaceCounter++;
			}
			if (ch[i] == ' ' && !spaceFlag) {
				pos = i;
				spaceFlag = true;
			}
			else if (ch[i] != ' ' && spaceFlag) {
				spaceFlag = false;
				for (int j = i; j < ch.length; j++) {
					ch[pos++] = ch[j];
				}
				i = i - spaceCounter;
				
				// remove the trailing character
				for (int k = 0; k < spaceCounter; k++) {
					ch[ch.length - 1 - k] = ' ';
				}
				
				spaceCounter = 0;
			}
		}
		
		
		System.out.println("After");
		System.out.println(ch);
	}
}
