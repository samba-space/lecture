package s8_utilize_dfs_bfs.p2_바둑이승차;

import java.util.Scanner;

public class Main {

    private int C, N;
    private int answer = Integer.MIN_VALUE;
    private int[] weights;


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main main = new Main();
        main.C = in.nextInt();
        main.N = in.nextInt();
        main.weights = new int[main.N];
        for (int i = 0; i < main.N; i++) {
            main.weights[i] = in.nextInt();
        }

        main.dfs(0, 0);
        System.out.println(main.answer);
    }

    public void dfs(int level, int sum) {
        if (sum > C) {
            return;
        }
        if (level == N) {
            answer = Math.max(answer, sum);
            return;
        }
        dfs(level + 1, sum + weights[level]);
        dfs(level + 1, sum);
    }
}
