package s8_utilize_dfs_bfs.p12_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    int M, N;
    int unRipeCount = 0;
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {-1, 0, 1, 0};
    //위, 오, 아래, 왼
    int[][] map;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        T.M = in.nextInt();
        T.N = in.nextInt();
        T.map = new int[T.N][T.M];

        for (int i = 0; i < T.N; i++) {
            for (int j = 0; j < T.M; j++) {
                int status = in.nextInt();
                T.map[i][j] = status;
                if (status == 0) {
                    T.unRipeCount++;
                }
            }
        }
        if (T.unRipeCount == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(T.bfs());
    }

    public int bfs() {
        int answer = 0;
        int ripeCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            if (ripeCount == unRipeCount) {
                return answer;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentStatus = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextY = currentStatus[0] + dirY[j];
                    int nextX = currentStatus[1] + dirX[j];
                    if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && map[nextY][nextX] == 0) {
                        map[nextY][nextX] = 1;
                        queue.offer(new int[]{nextY, nextX});
                        ripeCount++;
                    }
                }
            }
            answer++;
        }

        if (ripeCount != unRipeCount) {
            return -1;
        }

        return answer;
    }
}
