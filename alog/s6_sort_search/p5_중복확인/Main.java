package s6_sort_search.p5_중복확인;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] inputs = new int[N];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = in.nextInt();
        }
        String result = solution(N, inputs);
        System.out.println(result);

    }
    public static String solution(int N, int[] inputs) {

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (inputs[i] == inputs[j]) {
                    return "D";
                }
            }
        }

        return "U";
    }
}
