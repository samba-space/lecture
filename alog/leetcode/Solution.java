package leetcode;

import java.util.Arrays;

public class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] checkArray = new int[s.length()];

        for (String word : dictionary) {
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < word.length(); j++) {
                    if (s.charAt(i) == word.charAt(j)) {
                        checkArray[i] = 1;
                        break;
                    }
                }
            }
        }

        return Arrays.stream(checkArray).filter(check -> check == 0)
                .toArray().length;
    }

    public static void main(String[] arg) {
        Solution solution = new Solution();
        solution.minExtraChar("sayhelloworld", new String[]{"hello", "world"});
    }

}
