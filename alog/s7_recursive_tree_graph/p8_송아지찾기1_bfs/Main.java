package s7_recursive_tree_graph.p8_송아지찾기1_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int S = in.nextInt();
        int E = in.nextInt();

        int answer = solution(S, E);
        System.out.println(answer);
    }

    public static int solution(int s, int e) {
        int[] distance = {1, -1, 5};
        int[] visited = new int[10000 + 1];
        int L = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int findPosition = queue.poll();
                for(int dis : distance){
                    int nextPosition = findPosition + dis;
                    if (nextPosition == e) {
                        return L + 1;
                    }
                    if (nextPosition >= 1 && nextPosition <= 10000 && visited[nextPosition] != 1) {
                        queue.offer(nextPosition);
                        visited[nextPosition] = 1;
                    }
                }
            }
            L++;
        }
        return -1;
    }
}

