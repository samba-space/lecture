package s8_utilize_dfs_bfs.p14_피자배달거리;

import java.util.*;

public class Main {

    int N, M;

    List<int[]> house = new ArrayList<>();
    List<int[]> pizza = new ArrayList<>();
    int[] check;
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
        T.check = new int[T.pizza.size()];
        T.dfs(0, 0);
        System.out.println(T.answer);
    }

    public void dfs(int level, int selectPizzaCount) {
        if (selectPizzaCount > M) {
            return;
        }
        if (level == check.length) {
            if (selectPizzaCount == M) {
                int sum = calDistance();
                if (answer > sum) {
                    answer = sum;
                }
            }
            return;
        }
        check[level] = 1;
        dfs(level + 1, selectPizzaCount + 1);
        check[level] = 0;
        dfs(level + 1, selectPizzaCount);
    }

    public int calDistance() {
        int sum = 0;
        for (int[] housePosition : house){
            int minSum = Integer.MAX_VALUE;
            for (int i = 0; i < check.length; i++) {
                if (check[i] == 1) {
                    int tempSum = Math.abs(housePosition[0] - pizza.get(i)[0]) + Math.abs(housePosition[1] - pizza.get(i)[1]);
                    if (minSum > tempSum) {
                        minSum = tempSum;
                    }
                }
            }
            sum += minSum;
        }
        return sum;
    }
}
