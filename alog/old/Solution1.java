package p1.old;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();
        String input2 = in.nextLine();
        String[] s1 = input2.split(" ");
        String input3 = in.nextLine();
        String input4 = in.nextLine();
        String[] s2 = input4.split(" ");
        ArrayList<Integer> solution = solution(Integer.parseInt(input1), s1, Integer.parseInt(input3), s2);

        for (int i = 0; i < solution.size(); i++) {
            System.out.print(solution.get(i) + " ");
        }
        System.out.println();
        return;
    }

    public static ArrayList<Integer> solution(int firstSize, String[] firstStrArray, int secondSize, String[] secondStrArray) {
        int[] firstArray = makeArray(firstSize, firstStrArray);
        int[] secondArray = makeArray(secondSize, secondStrArray);
        ArrayList<Integer> result = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < firstSize && p2 < secondSize) {
            if (firstArray[p1] <= secondArray[p2]) {
                result.add(firstArray[p1++]);
            } else {
                result.add(secondArray[p2++]);
            }
        }
        while (p1 < firstSize) {
            result.add(firstArray[p1++]);
        }

        while (p2 < secondSize) {
            result.add(secondArray[p2++]);
        }

        return result;
    }

    private static int[] makeArray(int size, String[] array) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }
}
