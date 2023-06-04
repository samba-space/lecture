package p1;

import java.util.Scanner;

public class Solution5 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int solution = solution(n);
        System.out.println(solution);
        return;
    }

    public static int solution(int n) {
        int answer = n % 2 == 1 ? 1 : 0;
        int[] numbers = new int[n / 2];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int sum = 0;
        int left = 0;
        sum += numbers[left];

        for (int right = 1; right < numbers.length; right++) {
            sum += numbers[right];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= numbers[left++];
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
