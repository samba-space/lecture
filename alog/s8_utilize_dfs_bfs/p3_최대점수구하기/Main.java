package s8_utilize_dfs_bfs.p3_최대점수구하기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private int N, M;
    private int answer = Integer.MIN_VALUE;
    private List<int[]> problems = new ArrayList<>();

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main main = new Main();
        main.N = in.nextInt();
        main.M = in.nextInt();

        for (int i = 0; i < main.N; i++) {
            main.problems.add(new int[]{in.nextInt(), in.nextInt()});
        }

        main.dfs(0, 0, 0);
        System.out.println(main.answer);
    }

    public void dfs(int level, int timeSum, int scoreSum) {
        if (timeSum > M) {
            return;
        }
        if (level == N) {
            //구하기
            answer = Math.max(scoreSum, answer);
            return;
        }
        dfs(level + 1, timeSum + problems.get(level)[1], scoreSum + problems.get(level)[0]);
        dfs(level + 1, timeSum, scoreSum);
    }
}
