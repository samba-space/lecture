package s7_recursive_tree_graph.p6_부분집합;

import java.util.Scanner;

public class Main {

    private static int N;
    private static int[] check;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        check = new int[N + 1];
        dfs(1);
    }

    public static void dfs(int L) {
        if (L > N) {
            for (int i = 1; i < check.length; i++) {
                if (check[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }
        check[L] = 1;
        dfs(L + 1);
        check[L] = 0;
        dfs(L + 1);
    }
}
