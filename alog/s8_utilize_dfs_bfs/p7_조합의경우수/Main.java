package s8_utilize_dfs_bfs.p7_조합의경우수;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

//    int[] inputs = new int[]{1, 2, 3, 4, 5};
    int[] checks = new int[5];
    int N = 5;
    int R = 3;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main T = new Main();
        T.dfs(0);
    }

    public void dfs(int L) {
        if (L == N) {
            for (int i = 0; i < N; i++) {
                if (checks[i] == 1) {
                    System.out.print(i + 1 + " ");
                }
            }
            System.out.println();
            return;
        }
        checks[L] = 1;
        dfs(L + 1);
        checks[L] = 0;
        dfs(L + 1);
    }
}
