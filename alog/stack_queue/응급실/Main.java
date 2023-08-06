package p1.stack_queue.응급실;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] warningRate = new int[N];
        for (int i = 0; i < N; i++) {
            warningRate[i] = in.nextInt();
        }

        int result = solution(N, M, warningRate);

        System.out.println(result);
    }

//    public static int solution(int N, int M, int[] warningRate) {
//        int result = 0;
//
//        Queue<Integer> Q = new LinkedList<>();
//        for (int elem : warningRate) {
//            Q.offer(elem);
//        }
//
//        while (true) {
//            int person = Q.poll();
//            M--;
//            for (Integer integer : Q) {
//                if (person < integer) {
//                    Q.offer(person);
//                    result--;
//                    if (M == -1) {
//                        M = Q.size() - 1;
//                    }
//                    break;
//                }
//            }
//            result++;
//            if (M == -1) {
//                break;
//            }
//        }
//
//        return result;
//    }

    public static int solution(int N, int M, int[] warningRate) {
        int result = 0;

        Queue<Person> Q = new LinkedList<>();
        for (int i = 0; i < warningRate.length; i++) {
            Q.offer(new Person(i, warningRate[i]));
        }

        while(!Q.isEmpty()) {
            Person firstPerson = Q.poll();
            for (Person person : Q) {
                if (firstPerson.priority < person.priority) {
                    Q.offer(firstPerson);
                    firstPerson = null;
                    break;
                }
            }
            if (firstPerson != null) {
                result++;
                if (firstPerson.id == M) {
                    return result;
                }
            }
        }

        return result;
    }

    public static class Person {
        private int id;
        private int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

    }

}
