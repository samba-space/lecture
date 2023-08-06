package p1.sort_search.p2_버블정렬;

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
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (inputs[j] > inputs[j+1]) {
                    int temp = inputs[j];
                    inputs[j] = inputs[j+1];
                    inputs[j+1] = temp;
                }
            }
        }
        return inputs;
    }
}
