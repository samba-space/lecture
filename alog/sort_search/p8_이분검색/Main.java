package p1.sort_search.p8_이분검색;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = in.nextInt();
        }
        Arrays.sort(numbers);

        int result = sol(numbers, 0, N - 1, M);
        System.out.println(result + 1);

    }

    public static int sol(int[] numbers, int low, int high, int target) {
        int mid = (low + high) / 2;
        if (numbers[mid] == target) {
            return mid;
        }
        if (low == high) {
            return -1;
        }

        if (numbers[mid] > target) {
            return sol(numbers, low, mid, target);
        } else {
            return sol(numbers, mid + 1, high, target);
        }
    }
}