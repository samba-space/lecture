package s8_utilize_dfs_bfs.p6_순열구하기;

import java.util.Scanner;

public class Main {

    int[] check;
    int[] pm;
    int[] inputs;
    int N;
    int M;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main T = new Main();
        T.N = in.nextInt();
        T.M = in.nextInt();
        T.inputs = new int[T.N];
        T.check = new int[T.N];
        for (int i = 0; i < T.N; i++) {
            T.inputs[i] = in.nextInt();
        }
        T.pm = new int[T.M];
        T.dfs(0);
    }

    public void dfs(int L) {
        if (L == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(pm[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (check[i]==0) {
                check[i] = 1;
                pm[L] = inputs[i];
                dfs(L + 1);
                check[i] = 0;
            }
        }
    }
}
