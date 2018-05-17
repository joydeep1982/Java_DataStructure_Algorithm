package ds.algo.solutions;

import java.util.Stack;

public class ExpressionBalance {
	
	public static void main(String[] args) {
		System.out.println(isBalanced("{{{([[[]]])()()()}}}"));
		System.out.println(isBalanced("{{{([[[m+l]]])(x+3)(p-q-w-e-e-e)(f-d-r-e)}}}"));
		System.out.println(isBalanced("{{{([[[m+l]]])(x+3)(p-q-w-e-e-e)(f-d-r-e)}}}{]"));
	}

	static String isBalanced(String s) {
        // Complete this function
        int b1 = 0, b2 = 0, b3 = 0;
        char ch;
        Stack<Character> nextClose = new Stack<>();
        
        for (int i = 0; i < s.length(); i++){
            ch = s.charAt(i);
            if (ch == '[') {
                b3++;
                nextClose.push(']');
            }
            else if (ch == ']') {
                b3--;
                if (nextClose.isEmpty() || nextClose.pop() != ch) return "NO";
                if(b3<0) {
                    return "NO";
                }
            }
            else if (ch == '{') {
                b2++;
                nextClose.push('}');
            }
            else if (ch == '}') {
                b2--;
                if (nextClose.isEmpty() || nextClose.pop() != ch) return "NO";
                if(b2<0) {
                    return "NO";
                }
            }
            else if (ch == '(') {
                b1++;
                nextClose.push(')');
            }
            else if (ch == ')') {
                b1--;
                if (nextClose.isEmpty() || nextClose.pop() != ch) return "NO";
                if(b1<0) {
                    return "NO";
                }
            }
        }
        return b1 + b2 + b3 == 0 ? "YES" : "NO";
    }
}
