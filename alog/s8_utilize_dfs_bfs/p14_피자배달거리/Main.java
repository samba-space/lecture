package s8_utilize_dfs_bfs.p14_피자배달거리;

import java.util.*;

public class Main {

    int N, M;

    List<int[]> house = new ArrayList<>();
    List<int[]> pizza = new ArrayList<>();
    int[] combination;
    int answer = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        T.N = in.nextInt();
        T.M = in.nextInt();
        for (int i = 0; i < T.N; i++) {
            for (int j = 0; j < T.N; j++) {
                int temp = in.nextInt();
                if (temp == 1) {
                    T.house.add(new int[]{i, j});
                } else if (temp == 2) {
                    T.pizza.add(new int[]{i, j});
                }
            }
        }
        T.combination = new int[T.M];
        T.dfs(0, 0);
        System.out.println(T.answer);
    }

    public void dfs(int level, int start) {
        if (level == M) {
            int sum = calDistance();
            answer = Math.min(sum, answer);
            return;
        }
        for (int i = start; i < pizza.size(); i++) {
            combination[level] = i;
            dfs(level + 1, i + 1);
        }
    }

    public int calDistance() {
        int sum = 0;
        for (int[] housePosition : house){
            int minSum = Integer.MAX_VALUE;
            for (int i = 0; i < combination.length; i++) {
                int index = combination[i];
                int tempSum = Math.abs(housePosition[0] - pizza.get(index)[0]) + Math.abs(housePosition[1] - pizza.get(index)[1]);
                minSum = Math.min(tempSum, minSum);
            }
            sum += minSum;
        }
        return sum;
    }
}
