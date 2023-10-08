package s8_utilize_dfs_bfs.p4_중복순열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private int N, M;
    private int[] check;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main main = new Main();
        main.N = in.nextInt();
        main.M = in.nextInt();
        main.check = new int[main.M];

        main.dfs(0);
    }

    public void dfs(int level) {
        if (level == M) {
            for (int i = 0; i < check.length; i++) {
                System.out.print(check[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            check[level] = i;
            dfs(level + 1);
        }
    }
}
