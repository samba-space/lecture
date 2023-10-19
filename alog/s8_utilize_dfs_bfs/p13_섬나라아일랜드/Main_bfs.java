package s8_utilize_dfs_bfs.p13_섬나라아일랜드;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_bfs {

    int N;
    int[] dirX = {0, 1, 0, -1, -1, 1, -1, 1};
    int[] dirY = {-1, 0, 1, 0, -1, -1, 1, 1};
    int[][] map;
    int[][] visited;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main_bfs T = new Main_bfs();
        T.N = in.nextInt();
        T.map = new int[T.N][T.N];
        T.visited = new int[T.N][T.N];

        for (int i = 0; i < T.N; i++) {
            for (int j = 0; j < T.N; j++) {
                int status = in.nextInt();
                T.map[i][j] = status;
            }
        }

        System.out.println(T.bfs());
    }

    public int bfs() {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = 1;
                    answer++;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int z = 0; z < size; z++) {
                            int[] currentPos = queue.poll();
                            for (int k = 0; k < 8; k++) {
                                int nextY = dirY[k] + currentPos[0];
                                int nextX = dirX[k] + currentPos[1];
                                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && visited[nextY][nextX] == 0 && map[nextY][nextX] == 1) {
                                    queue.offer(new int[]{nextY, nextX});
                                    visited[nextY][nextX] = 1;
                                }
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}
