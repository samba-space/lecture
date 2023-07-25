package p1.stack_queue.괄호문자제거;

import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Stack<Character> results = solution(str);

        for (Character ch : results) {
            System.out.print(ch);
        }

    }

    public static Stack<Character> solution(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == ')') {
                while(stack.pop() != '(');
            } else {
                stack.push(ch);
            }
        }

        return stack;
    }
}
