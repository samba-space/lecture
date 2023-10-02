package s7_recursive_tree_graph.p4_피보나치재귀_메모이제이션;

import java.util.Scanner;

public class Main {

    public static int[] fibo;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int sum = 0;
        for (int i = 1; i <= N; i++) {

        }

//        fibo = new int[N + 1];
//        dfs(N);
//
//        for (int i = 1; i <= N; i++) {
//            System.out.print(fibo[i] + " ");
//        }
    }

    public static int dfs(int n) {
        if(fibo[n] > 0) return fibo[n];
        if (n < 2) {
            return fibo[n] = n;
        }
        return fibo[n] = dfs(n - 1) + dfs(n - 2);
    }
}

//1 1 2 3 5 7