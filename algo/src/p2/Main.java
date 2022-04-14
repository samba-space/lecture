package p2;

import java.util.Scanner;

public class Main {
    public String solution(String input) {
        String answer = "";

        for (int i = 0; i < input.length(); i++) {
            char targetChar = input.charAt(i);
            if (Character.isUpperCase(targetChar)) {
                answer += Character.toLowerCase(targetChar);
            } else {
                answer += Character.toUpperCase(targetChar);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(T.solution(str));
        return ;
    }
}
