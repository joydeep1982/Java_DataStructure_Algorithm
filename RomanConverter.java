package ds.algo.solutions;

import java.util.HashMap;
import java.util.Map;

public class RomanConverter {

	public static Map<Integer, String> INTEGER_TO_ROMAN_MAP = new HashMap<Integer, String>() {
		{
			put(1, "I");
			put(4, "IV");
			put(5, "V");
			put(9, "IX");
			put(10, "X");
			put(40, "XL");
			put(50, "L");
			put(90, "XC");
			put(100, "C");
			put(400, "CD");
			put(500, "D");
			put(900, "CM");
			put(1000, "M");
		}
	};

	public static Map<String, Integer> ROMAN_TO_INTEGER = new HashMap<String, Integer>() {
		{
			put("I", 1);
			put("V", 5);
			put("X", 10);
			put("L", 50);
			put("C", 100);
			put("D", 500);
			put("M", 1000);
		}
	};

	private static Integer[] BASES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	public static void main(String[] args) {
		// System.out.println(toRoman(666));
		System.out.println(toInteger("DCLXVI"));
	}

	public static String toRoman(int num) {

		StringBuilder result = new StringBuilder();

		for (int i : BASES) {
			while (num >= i) {
				result.append(INTEGER_TO_ROMAN_MAP.get(i));
				num = num - i;
			}
		}

		return result.toString();
	}

	public static Integer toInteger(String str) {
		// Initialize result
		Integer res = 0;

		for (int i = 0; i < str.length(); i++) {
			// Getting value of symbol s[i]
			Integer s1 = ROMAN_TO_INTEGER.get(String.valueOf(str.charAt(i)));

			// Getting value of symbol s[i+1]
			if (i + 1 < str.length()) {
				Integer s2 = ROMAN_TO_INTEGER.get(String.valueOf(str.charAt(i + 1)));

				// Comparing both values
				if (s1 >= s2) {
					// Value of current symbol is greater
					// or equalto the next symbol
					res = res + s1;
				} else {
					res = res + s2 - s1;
					i++; // Value of current symbol is
					// less than the next symbol
				}
			} else {
				res = res + s1;
				i++;
			}
		}

		return res;
	}
}
