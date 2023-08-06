package p1.sort_search.p4_LRU;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int S = in.nextInt();
        List<Integer> cache = new ArrayList<>();
        int N = in.nextInt();
        List<Integer> inputs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            inputs.add(in.nextInt());
        }
        for (int i = 0; i < S; ++i) {
            cache.add(0);
        }
        List<Integer> result = solution(cache, N, inputs);

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    public static List<Integer> solution(List<Integer> cache, int N, List<Integer> inputs) {
        for (int input : inputs) {
            if (!cache.contains(input)) {
                if (cache.get(0) == 0) {
                    cache.set(0, input);
                } else {
                    for (int j = cache.size() - 1; j > 0; j--) {
                        cache.set(j, cache.get(j - 1));
                    }
                    cache.set(0, input);
                }
            } else {
                int removeIndex = cache.indexOf(input);
                cache.set(removeIndex, 0);
                for (int i = removeIndex; i > 0; i--) {
                    cache.set(i, cache.get(i - 1));
                }
                cache.set(0, input);
            }
        }

        return cache;
    }
}
