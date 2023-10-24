package s8_utilize_dfs_bfs.p13_섬나라아일랜드;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_dfs {

    int N;
    int[] dirX = {0, 1, 0, -1, -1, 1, -1, 1};
    int[] dirY = {-1, 0, 1, 0, -1, -1, 1, 1};
    int[][] map;
    int answer = 0;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main_dfs T = new Main_dfs();
        T.N = in.nextInt();
        T.map = new int[T.N][T.N];

        for (int i = 0; i < T.N; i++) {
            for (int j = 0; j < T.N; j++) {
                int status = in.nextInt();
                T.map[i][j] = status;
            }
        }
        for (int i = 0; i < T.N; i++) {
            for (int j = 0; j < T.N; j++) {
                if (T.map[i][j] == 1) {
                    T.map[i][j] = 0;
                    T.dfs(i, j);
                    T.answer++;
                }

            }
        }

        System.out.println(T.answer);
    }

    public void dfs(int y, int x) {
        for (int i = 0; i < 8; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];
            if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < N && map[nextY][nextX] == 1) {
                map[nextY][nextX] = 0;
                dfs(nextY, nextX);
            }
        }
    }
}
