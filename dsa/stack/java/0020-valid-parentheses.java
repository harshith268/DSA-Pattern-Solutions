// LeetCode 20: Valid Parentheses
// Pattern: Stack
// Approaches:
// 1) Brute Force
// 2) Optimal (Stack)

import java.util.Stack;

public class ValidParentheses {

    // Brute Force Approach
    // Time: O(n^2), Space: O(n)
    public static boolean isValidBrute(String s) {
        String prev;
        do {
            prev = s;
            s = s.replace("()", "")
                 .replace("{}", "")
                 .replace("[]", "");
        } while (!s.equals(prev));
        return s.isEmpty();
    }

    // Optimal Approach (Stack)
    // Time: O(n), Space: O(n)
    public static boolean isValidOptimal(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidOptimal("({[]})")); // true
    }
}

