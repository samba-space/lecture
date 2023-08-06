package p1.stack_queue.공주구하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int result = solution(N, K);

        System.out.println(result);
    }

    public static int solution(int N, int K) {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(i + 1);
        }
        while (queue.size() != 1) {
            for (int i = 1; i < K; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        return queue.poll();
    }
}
