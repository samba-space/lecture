package s5_stack_queue.p5_쇠막대기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.next();
        System.out.println(sol(input));
    }

    public static int sol(String input){
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        char[] inputs = input.toCharArray();

        for (int i = 0; i < inputs.length - 1; i++) {
            if (inputs[i] == '(' && inputs[i + 1] == ')') {
                answer += stack.size();
                i++;
            } else {
                if (inputs[i] == '(') {
                    stack.push(inputs[i]);
                    answer++;
                } else {
                    stack.pop();
                }
            }
        }
//        ()(((()())(())()))(())
        //((( ()
        // (개 들어오면 answer ++ 분리되고 왼쪽부분
        //메인로직은 () 붙여서 만나면 stack에 (개수만큼(stack size) ++, )만나면 stack pop필요
        //() 붙어 있으면 stack대상이 아님. 파이프 확인 시 stack empty 체크 필요
        //
        return answer;
    }
}
