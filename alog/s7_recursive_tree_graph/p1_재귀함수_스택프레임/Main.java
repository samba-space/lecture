package s7_recursive_tree_graph.p1_재귀함수_스택프레임;

import java.util.LinkedList;
import java.util.Queue;
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
        dfs(n-1);
        System.out.print(n + " ");
    }
}
