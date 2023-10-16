package s8_utilize_dfs_bfs.p7_조합의경우수;

import java.util.Scanner;

public class Main {

    int[][] check;
    int N, R;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main T = new Main();
        T.N = in.nextInt();
        T.R = in.nextInt();
        T.check = new int[T.N + 1][T.N + 1];
        int result = T.combination(T.N, T.R);
        System.out.println(result);
    }

    private int combination(int n, int r) {
        if (check[n][r] != 0) {
            return check[n][r];
        }
        if (n == r || r == 0) {
            return check[n][r] = 1;
        }
        return check[n][r] = combination(n - 1, r) + combination(n - 1, r - 1);
    }


}
