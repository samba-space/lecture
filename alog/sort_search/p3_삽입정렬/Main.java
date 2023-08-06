package p1.sort_search.p3_삽입정렬;

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
        for (int i = 0; i < N; i++) {
            int target = inputs[0];
            int targetIndex;
            for (targetIndex = 1; targetIndex < N; targetIndex++) {
                if (target < inputs[targetIndex]) {
                    break;
                }
            }

            for (int j = 1; j < targetIndex; j++) {
                inputs[j - 1] = inputs[j];
            }
            for (int j = inputs.length - 1; j > targetIndex; j--) {
                inputs[j + 1] = inputs[j];
            }
            inputs[targetIndex-1] = target;
        }

        return inputs;
    }
}
