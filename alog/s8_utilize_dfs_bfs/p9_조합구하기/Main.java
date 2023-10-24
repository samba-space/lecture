package s8_utilize_dfs_bfs.p9_조합구하기;

import java.util.Scanner;

public class Main {

    int N, M;
    int[] combination;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        T.N = in.nextInt();
        T.M = in.nextInt();
        T.combination = new int[T.M];
        T.dfs(0, 1);

    }

    public void dfs(int level, int start) {
        if (level == M) {
            for (int combi : combination) {
                System.out.print(combi + " ");

            }
            System.out.println();
            return;
        }
        for (int i = start; i <= N; i++) {
            combination[level] = i;
            dfs(level + 1, i + 1);
        }
    }
}
