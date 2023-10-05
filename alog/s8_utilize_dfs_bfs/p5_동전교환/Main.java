package s8_utilize_dfs_bfs.p5_동전교환;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        int N = in.nextInt();
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = in.nextInt();
        }
        int M = in.nextInt();
        Main T = new Main();

        int answer = T.bfs(coins, M);
        System.out.println(answer);
    }

    public int bfs(int[] coins, int M) {
        int level = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curSum = queue.poll();
                for (int j = 0; j < coins.length; j++) {
                    if (curSum + coins[j] == M) {
                        return level + 1;
                    }
                    if (curSum + j < M) {
                        queue.offer(curSum + coins[j]);
                    }
                }
            }
            level++;
        }

        return level;
    }
}
