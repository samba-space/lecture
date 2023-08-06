package s4_hashmap_treeset.p3_매출액의종류;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] input3 = new int[N];

        for (int i = 0; i < N; i++) {
            input3[i] = in.nextInt();
        }

        int[] results = sol(N, K, input3);
        for (int result : results) {
            System.out.print(result + " ");
        }

        return ;
    }

    public static int[] sol(int N, int K, int[] sellOfDays) {
        int[] results = new int[N - K + 1];
        Map<Integer, Integer> HM = new HashMap<>();
        for (int i = 0; i < K - 1; i++) {
            HM.put(sellOfDays[i], HM.getOrDefault(sellOfDays[i], 0) + 1);
        }
        int left = 0;

        for (int right = K - 1; right < N; right++) {
            HM.put(sellOfDays[right], HM.getOrDefault(sellOfDays[right], 0) + 1);
            results[left] = HM.size();
            HM.put(sellOfDays[left], HM.get(sellOfDays[left]) - 1);
            if (HM.get(sellOfDays[left]) == 0) {
                HM.remove(sellOfDays[left]);
            }
            left++;
        }
//7 4
//20 12 20 10 23 17 10

        return results;
    }
}
