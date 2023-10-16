package s8_utilize_dfs_bfs.p4_중복순열;

import java.util.Scanner;

public class Main {

    int[] checks;
    int[] inputs;
    int N;
    int M;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        T.N = in.nextInt();
        T.M = in.nextInt();
        T.inputs = new int[T.N];
        for (int i = 0; i < T.N; i++) {
            T.inputs[i] = in.nextInt();
        }
        T.checks = new int[T.M];
        T.dfs(0);
    }

    public void dfs(int L) {
        if (L == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(checks[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            checks[L] = inputs[i];
            dfs(L + 1);
        }
    }
}
