package s8_utilize_dfs_bfs.p8_수열추측하기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    int[] answer;
    int[] array;
    int[] check;
    int N,F;
    boolean isAnswer = false;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main T = new Main();
        T.N = in.nextInt();
        T.F = in.nextInt();
        T.answer = new int[T.N];
        T.array = new int[T.N];
        for (int i = 0; i < T.array.length; i++) {
            T.array[i] = i + 1;
        }
        T.check = new int[T.N];
        T.dfs(0);
    }

    public void dfs(int L) {
        if (isAnswer) {
            return;
        }
        if (L == N) {
            int[] temp = Arrays.copyOf(answer, N);
            for (int j = 1; j < temp.length; j++) {
                for (int i = 0; i < temp.length - j; i++) {
                    temp[i] = temp[i] + temp[i + 1];
                }
            }
            if (temp[0] == F) {
                isAnswer = true;
                for (int ans : answer) {
                    System.out.print(ans + " ");
                }
                System.out.println();
            }
            return;
        }
        for (int i = 0; i < answer.length; i++) {
            if (check[i] == 0) {
                answer[L] = array[i];
                check[i] = 1;
                dfs(L + 1);
                check[i] = 0;
            }
        }
    }
}
