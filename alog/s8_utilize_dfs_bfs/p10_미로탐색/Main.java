package s8_utilize_dfs_bfs.p10_미로탐색;

import java.util.Scanner;

public class Main {

    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {-1, 0, 1, 0};
    //위, 오, 아래, 왼
    int[][] map = new int[8][8];
    int[][] check = new int[8][8];
    int answer = 0;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                T.map[i + 1][j + 1] = in.nextInt();
            }
        }
        T.check[1][1] = 1;
        T.dfs(0, 1, 1);
        System.out.println(T.answer);
    }

    public void dfs(int L, int x, int y) {
        if (x == 7 && y == 7) {
            answer++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            if (nextX >= 1 && nextX <= 7 && nextY >= 1 && nextY <= 7) {
                if (map[nextY][nextX] == 0 && check[nextY][nextX] == 0) {
                    check[nextY][nextX] = 1;
                    dfs(L + 1, nextX, nextY);
                    check[nextY][nextX] = 0;
                }

            }
        }
    }
}
