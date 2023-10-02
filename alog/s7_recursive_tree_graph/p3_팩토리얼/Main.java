package s7_recursive_tree_graph.p3_팩토리얼;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int result = dfs(N);
        System.out.println(result);
    }

    public static int dfs(int n) {
        if (n == 1) {
            return n;
        }
        return n * dfs(n - 1);
     }
}

//d(1) 1
//d(2) 2 * d(1)
//d(3) 3 * d(2)
//d(4) 4 * d(3)
//d(5) 5 * d(4)