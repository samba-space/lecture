package s8_utilize_dfs_bfs.p1_합이같은부분집합;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int N;
    private static int[] input;
    private static int[] check;
    private static String answer = "NO";
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        N = in.nextInt();
        input = new int[N];
        check = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = in.nextInt();
        }
        check[0] = 1;
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int index) {
        if (index == N) {
            return;
        }

        int sum = 0;
        int anOtherSum = 0;
        for (int i = 0; i < N; i++) {
            if (check[i] == 1) {
                sum += input[i];
            } else {
                anOtherSum += input[i];
            }
        }
        if (sum == anOtherSum) {
            answer = "YES";
        }

        check[index] = 1;
        dfs(index + 1);
        check[index] = 0;
        dfs(index + 1);
    }
}