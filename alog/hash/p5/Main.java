package p1.hash.p5;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; ++i) {
            numbers[i] = in.nextInt();
        }

        int result = solution(N, K, numbers);

        System.out.println(result);
        return;
    }

    public static int solution(int N, int K, int[] numbers) {
        TreeSet<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());

        new TreeSet<>();
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    treeSet.add(numbers[i] + numbers[j] + numbers[k]);
                }
            }
        }


        return K > treeSet.size() ? -1 : (int) treeSet.toArray()[K-1];
    }
}
