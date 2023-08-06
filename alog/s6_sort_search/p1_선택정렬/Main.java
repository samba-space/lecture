package s6_sort_search.p1_선택정렬;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] inputs = new int[N];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = in.nextInt();
        }
        int[] result = solution(N, inputs);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] solution(int N, int[] inputs) {

        for (int i = 1; i < N; i++) {
            int elem = inputs[i];
            for (int j = i - 1; j >= 0; j--) {
                if (elem < inputs[j]) {
                    inputs[j + 1] = inputs[j];
                    inputs[j] = elem;
                } else {
                    break;
                }
            }
        }

        return inputs;
    }
}
