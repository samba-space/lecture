package s4_hashmap_treeset.p4_모든아나그램찾기;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();
        String input2 = in.nextLine();

        int result = solution(input1, input2);

        System.out.println(result);
        return;
    }

    public static int solution(String S, String T) {
        int result = 0;
        Map<Character, Integer> HM = new HashMap<>();
        Map<Character, Integer> TM = new HashMap<>();

        char[] sArray = S.toCharArray();
        char[] tArray = T.toCharArray();

        for (int i = 0; i < tArray.length - 1; i++) {
            HM.put(sArray[i], HM.getOrDefault(sArray[i], 0) + 1);
        }

        for (char t : tArray) {
            TM.put(t, TM.getOrDefault(t, 0) + 1);
        }

        int left = 0;

        for (int right = tArray.length - 1; right < sArray.length; right++) {
            HM.put(sArray[right], HM.getOrDefault(sArray[right], 0) + 1);
            if (HM.equals(TM)) {
                result++;
            }
            HM.put(sArray[left], HM.get(sArray[left]) - 1);
            if (HM.get(sArray[left]) == 0) {
                HM.remove(sArray[left]);
            }
            left++;
        }


        return result;
    }
}
