package s4_hashmap_treeset.p1_학급회장;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int input1 = Integer.parseInt(in.nextLine());
        String input2 = in.nextLine();

        int maxIndex = sol(input1, input2);
        System.out.println((char)(maxIndex + 65));
        return ;
    }

    public static int sol(int N, String votes) {
        int[] result = new int[5];

        char[] charArray = votes.toCharArray();
        for (char ch : charArray) {
            result[ch - 65]++;
        }

        for (int re : result) {
        }

        int max=result[0];
        int maxIndex = 0;
        for (int i = 0; i < result.length; ++i) {
            if (result[i] > max) {
                maxIndex = i;
                max = result[i];
            }
        }

        return maxIndex;
    }
}
