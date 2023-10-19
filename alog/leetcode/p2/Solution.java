
package leetcode.p2;


import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution T = new Solution();
        T.backspaceCompare("y#fo##f", "y#f#o##f");
    }
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = makeStack(s);
        Stack<Character> s2 = makeStack(t);
        return s1.equals(s2);
    }
    public Stack<Character> makeStack(String str) {
        Stack<Character> s = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '#') {
                if (!s.empty()) {
                    s.pop();
                }
            } else {
                s.push(ch);
            }
        }
        return s;
    }

}
