package s6_sort_search.p7_좌표정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[][] positions = new int[N][2];
        for (int i = 0; i < N; ++i) {
            positions[i][0] = in.nextInt();
            positions[i][1] = in.nextInt();
        }

        List<Position> answer = sol(N, positions);
        for (Position position : answer) {
            System.out.println(position.x + " " + position.y);
        }
    }

    public static List<Position> sol(int N, int[][] inputs) {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            positions.add(new Position(inputs[i][0], inputs[i][1]));
        }

//        positions.sort(Comparator.comparing(Position::getX)
//                .thenComparing(Position::getY));
        Collections.sort(positions);

        return positions;
    }

    public static class Position implements Comparable<Position>{
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Position o) {
            if (this.x < o.x) {
                return -1;
            } else if (this.x == o.x) {
                return Integer.compare(this.y, o.y);
            } else {
                return 1;
            }
        }
    }


}