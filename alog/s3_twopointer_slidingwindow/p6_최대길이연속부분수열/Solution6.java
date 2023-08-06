package s3_twopointer_slidingwindow.p6_최대길이연속부분수열;

import java.util.Scanner;

public class Solution6 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int solution = solution(n, k, arr);
        System.out.println(solution);
        return;
    }

    public static int solution(int n, int k, int[] arr) {
        int max = 0;
        int answer = 1;
        int lt = 0, rt = 0;

        while (rt < n - 1) {
            if (arr[rt + 1] == 1) {
                answer++;
                rt++;
            } else {
                if (k > 0) {
                    k--;
                    answer++;
                    rt++;
                } else {
                    while (k == 0) {
                        max = Math.max(max, answer);
                        if (arr[lt] == 1) {
                            answer--;
                            lt++;
                        } else {
                            answer--;
                            k++;
                            lt++;
                        }
                    }
                }
            }
        }
        return max;
    }
}
