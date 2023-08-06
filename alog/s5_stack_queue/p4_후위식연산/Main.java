package s5_stack_queue.p4_후위식연산;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.next();
        System.out.println(sol(input));
        return ;
    }

    public static int sol(String input){

        Stack<Integer> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch >= '1' && ch <= '9') {
                stack.push(ch - '0');
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(num2 + num1);
                        break;
                    case '-':
                        stack.push(num2 - num1);
                        break;
                    case '*':
                        stack.push(num2 * num1);
                        break;
                    case '/':
                        stack.push(num2 / num1);
                        break;
                }
            }
        }
        //352+*9-
        return stack.pop();
    }
}
