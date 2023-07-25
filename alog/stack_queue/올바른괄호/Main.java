package p1.stack_queue.올바른괄호;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        System.out.println(solution(str));
        return;
    }

    public static String solution(String str) {

        Stack<Character> ST = new Stack<>();

        for (char elem : str.toCharArray()) {
            if (elem == ')') {
                if (ST.empty()) {
                    return "NO";
                }
                ST.pop();
            } else {
                ST.push(elem);
            }
        }

        return ST.empty() ? "YES" : "NO";
    }
}
