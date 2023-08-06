package s5_stack_queue.p7_교육과정설계;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String q1 = in.next();
        String q2 = in.next();
        String result = solution(q1, q2);

        System.out.println(result);
    }

//    public static String solution(String q1, String q2) {
//        String result = "NO";
//
//        Queue<Character> queue1 = new LinkedList<>();
//        Queue<Character> queue2 = new LinkedList<>();
//        for (char c : q1.toCharArray()) {
//            queue1.offer(c);
//        }
//        for (char c : q2.toCharArray()) {
//            queue2.offer(c);
//        }
//
//        for (int i = 0; i < q2.length(); ++i) {
//            if (queue1.contains(queue2.peek())) {
//                queue2.offer(queue2.poll());
//            } else {
//                queue2.poll();
//            }
//        }
//
//        if (queue1.equals(queue2)) {
//            return "YES";
//        }
//        return result;
//    }

    public static String solution(String q1, String q2) {
        String result = "YES";

        Queue<Character> Q = new LinkedList<>();
        for (char c : q1.toCharArray()) {
            Q.offer(c);
        }

        for (char c : q2.toCharArray()) {
            if (Q.contains(c)) {
                if(Q.poll() != c) return "NO";
            }
        }

        if(!Q.isEmpty()) return "NO";

        return result;
    }
}
