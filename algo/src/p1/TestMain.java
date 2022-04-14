package p1;

import java.util.Scanner;

public class TestMain {

    public int solution(String targetString, String findChar) {
        int answer = 0;
        String target = targetString.toUpperCase();
        String find = findChar.toUpperCase();

        for (int i = 0; i < targetString.length(); i++) {
            if (target.charAt(i) == find.charAt(0)) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        TestMain T = new TestMain();
        Scanner in = new Scanner(System.in);
        String targetString = in.nextLine();
        String findChar = in.nextLine();
        System.out.println(T.solution(targetString, findChar));
        return ;
    }

}