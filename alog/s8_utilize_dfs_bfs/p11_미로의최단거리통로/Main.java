package s8_utilize_dfs_bfs.p11_미로의최단거리통로;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {-1, 0, 1, 0};
    //위, 오, 아래, 왼
    int[][] map = new int[8][8];
    int[][] check = new int[8][8];

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                T.map[i + 1][j + 1] = in.nextInt();
            }
        }
        System.out.println(T.bfs());
    }

    public int bfs() {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        //X, Y
        check[1][1] = 1;
        queue.offer(new int[]{1, 1});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentPosition = queue.poll();

                if (currentPosition[0] == 7 && currentPosition[1] == 7) {
                    return answer;
                }
                for (int j = 0; j < 4; j++) {
                    int nextX = currentPosition[0] + dirX[j];
                    int nextY = currentPosition[1] + dirY[j];
                    if (nextX >= 1 && nextX <= 7 && nextY >= 1 && nextY <= 7) {
                        if (map[nextY][nextX] == 0 && check[nextY][nextX] == 0) {
                            check[nextY][nextX] = 1;
                            queue.offer(new int[]{nextX, nextY});
                        }
                    }
                }
            }
            answer++;
        }

        return -1;
    }
}
