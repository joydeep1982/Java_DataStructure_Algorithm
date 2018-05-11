package org.ds_algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BasicTRIE {

	public static void main(String[] args) {
		Node head = new Node();
		head.ch = null;

		addString("hacker", head);
		addString("hack", head);
		addString("hacking", head);
		addString("hacked", head);
		
		addString("animal", head);
		addString("anagram", head);
		addString("angry", head);
		addString("antelope", head);
		addString("anagrams", head);

		System.out.println(findInTRIE("hack", head));
	}

	private static int findInTRIE(String str, Node head) {
		Node n = head;
		for (int i = 0; i < str.length(); i++) {
			if (n.children.get(str.charAt(i)) == null) {
				return 0;
			}
			n = n.children.get(str.charAt(i));
		}
		return n.count;
	}

	private static void printTRIE(Node head, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print(" ");
		}
		System.out.println(head.ch);
		Set<Entry<Character, Node>> entries = head.children.entrySet();
		for (Entry<Character, Node> entry : entries) {
			printTRIE(entry.getValue(), level + 1);
		}
	}

	public static void addString(String str, Node head) {
		Node n = head;
		for (int i = 0; i < str.length(); i++) {
			n = add(str.charAt(i), n);
		}
	}

	public static Node add(char ch, Node head) {
		Node n = head.children.get(ch);
		if (n == null) {
			n = new Node();
			n.ch = ch;
			head.children.put(ch, n);
		}
		n.count++;
		return n;
	}
}

class Node {
	Character ch;
	Integer count = 0;
	Map<Character, Node> children = new HashMap<>();
}
