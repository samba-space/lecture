package s4_hashmap_treeset.p2_아나그램;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();

        String result = sol(input1, input2);
        System.out.println(result);
        return ;
    }

    public static String sol(String target1, String target2) {
        String result = "YES";

        Map<Character, Integer> anagram = new HashMap<>();

        char[] str1 = target1.toCharArray();
        char[] str2 = target2.toCharArray();

        for (char str : str1) {
            anagram.put(str, anagram.getOrDefault(str, 0) + 1);
        }

        for (char str : str2) {
            if (anagram.get(str) == null || anagram.get(str) == 0) {
                return "NO";
            }
            anagram.put(str, anagram.get(str) - 1);
        }

        return result;
    }
}
