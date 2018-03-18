package org.hacker.rank;

import java.util.Map;
import java.util.TreeMap;

public class Anagram {
	
	public static void main(String[] args) {
		String input = "abc";
		
		// Create map to find the unique aphabets and count
		Map<Character, Integer> dataMap = new TreeMap<>();
		for(int i = 0; i <input.length(); i++) {
			if (dataMap.containsKey(input.charAt(i))) {
				dataMap.put(input.charAt(i), dataMap.get(input.charAt(i)) + 1);
			}
			else {
				dataMap.put(input.charAt(i), 1);
			}
		}
		
		// character array to hold the characters
		char[] chars = new char[dataMap.size()];

		// integer array to hold the count of the character
		int[] count = new int[dataMap.size()];
		
		int index = 0;
		
		for(Map.Entry<Character, Integer> entry : dataMap.entrySet()) {
			chars[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
		
		char[] container = new char[input.length()];
		anagram(chars, count, container, 0);
	}

	// recursively find the anagram
	public static void anagram(char[] chars, int[] count, char[] result, int level){
		if (level == result.length) {
			print(result);
			return;
		}
		for (int i = 0; i < count.length; i++) {
			if(count[i] == 0) continue;
			count[i]--;
			result[level] = chars[i];
			anagram(chars, count, result, level + 1);
			count[i]++;
		}
	}
	
	public static void print(char[] ch) {
		for(char c : ch) {
			System.out.print(c);
		}
		System.out.println("");
	}
}
