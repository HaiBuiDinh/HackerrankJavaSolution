package Java.JavaStack;

import java.util.*;

class Solution {

    public static boolean myCompare(char a, char b) {
        if (a == '{' && b == '}') {
            return true;
        }
        if (a == '(' && b == ')') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }
        return false;
    }

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            //Complete the code
            Stack<Character> stack = new Stack<>();
            char[] chars = input.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (stack.empty()) {
                    stack.push(chars[i]);
                } else {
                    if (myCompare(stack.peek(), chars[i])) {
                        stack.pop();
                    } else {
                        stack.push(chars[i]);
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}



