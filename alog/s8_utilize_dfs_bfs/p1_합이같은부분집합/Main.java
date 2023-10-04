package s8_utilize_dfs_bfs.p1_합이같은부분집합;

import java.util.Scanner;

public class Main {

    private static int N, total;
    private static int[] input;
    private static String answer = "NO";
    private static boolean finish = false;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        N = in.nextInt();
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = in.nextInt();
            total += input[i];
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int level, int sum) {
        if (finish) {
            return;
        }
        if (sum > total / 2) {
            return;
        }
        if (level == N) {
            if (total - sum == sum) {
                answer = "YES";
                finish = true;
            }
            return;
        }

        dfs(level + 1, sum + input[level]);
        dfs(level + 1, sum);
    }
}