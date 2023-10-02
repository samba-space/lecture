package s7_recursive_tree_graph.p2_이진수출력_재귀;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        dfs(N);
    }

    public static void dfs(int n) {
        if (n == 0) {
            return;
        }

        dfs(n / 2);
        System.out.print(n % 2);
    }
}
