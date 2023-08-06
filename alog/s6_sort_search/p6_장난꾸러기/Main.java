package s6_sort_search.p6_장난꾸러기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] inputs = new int[N];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = in.nextInt();
        }
        List<Integer> sol = sol(N, inputs);
        for (int i : sol) {
            System.out.print(i + " ");
        }
        return ;
    }

    public static List<Integer> sol(int N, int[] students) {
        List<Integer> answer = new ArrayList<>();
        int[] origin = Arrays.copyOf(students, students.length);
        Arrays.sort(students);
        for (int i = 0; i < N; i++) {
            if (origin[i] != students[i]) {
                answer.add(i + 1);
            }
        }
        return answer;
    }
}