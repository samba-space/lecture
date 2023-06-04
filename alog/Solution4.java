package p1;

import java.util.Scanner;

public class Solution4 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int solution = solution(n, m, a);

        System.out.println(solution);

        return;
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            if (sum == m) {
                answer++;
            }
            while (sum >= m) {
                sum -= arr[left++];
                if (sum == m) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
