package s3_twopointer_slidingwindow.p2_공통원소구하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }
        int n = in.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        ArrayList<Integer> solution = solution(m, a, n, b);
        for (Integer num :
                solution) {
            System.out.print(num + " ");
        }

        return;
    }

    public static ArrayList<Integer> solution(int m, int[] a, int n, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int p1 = 0, p2 = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        while (p1 < m && p2 < n) {
            if (a[p1] < b[p2]) {
                p1++;

            } else if (a[p1] > b[p2]) {
                p2++;
            } else {
                result.add(a[p1++]);
                p2++;
            }
        }

        return result;
    }
}
