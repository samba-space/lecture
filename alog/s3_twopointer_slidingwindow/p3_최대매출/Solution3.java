package s3_twopointer_slidingwindow.p3_최대매출;

import java.util.Scanner;

public class Solution3 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int solution = solution(n, k, a);

        System.out.println(solution);

        return;
    }

    public static int solution(int n, int k, int[] arr) {
        int max;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        max = windowSum;

        for (int i = k; i < n; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            max = Math.max(windowSum, max);
        }

        return max;
    }
}
