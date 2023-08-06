package p1.sort_search.p10_마구간;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = in.nextInt();
        }
        int answer = solution(n, c, positions);
        System.out.println(answer);
    }

    public static int solution(int n, int c, int[] positions) {
        int answer = 0;
        int lt = 1;
        int rt = Arrays.stream(positions).max().getAsInt()
                - Arrays.stream(positions).min().getAsInt();
        Arrays.sort(positions);

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (getHorseCount(mid, positions) < c) {
                rt = mid - 1;
            } else {
                answer = mid;
                lt = mid + 1;
            }
        }

        return answer;
    }

    private static int getHorseCount(int mid, int[] positions) {
        int horseCount = 1;
        int endPosition = positions[0];
        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - endPosition >= mid) {
                horseCount++;
                endPosition = positions[i];
            }
        }
        return horseCount;
    }
}
