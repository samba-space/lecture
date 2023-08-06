package s6_sort_search.p9_뮤직비디오;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] videos = new int[n];
        for (int i = 0; i < n; i++) {
            videos[i] = in.nextInt();
        }
        int answer = solution(n, m, videos);
        System.out.println(answer);
    }

    public static int solution(int n, int m, int[] videos) {
        int answer = 0;
        int lt = Arrays.stream(videos).max().getAsInt();
        int rt = Arrays.stream(videos).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (getVideoCount(mid, videos) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    private static int getVideoCount(int mid, int[] videos) {
        int videoCount = 1;
        int sum = 0;
        for (int i = 0; i < videos.length; i++) {
            if (sum + videos[i] > mid) {
                sum = videos[i];
                videoCount++;
            } else {
                sum += videos[i];
            }
        }
        return videoCount;
    }
}
