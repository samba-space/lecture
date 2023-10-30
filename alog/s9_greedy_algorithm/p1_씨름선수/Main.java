package s9_greedy_algorithm.p1_씨름선수;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private int N;
    private Person[] people;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main T = new Main();
        T.N = in.nextInt();
        T.people = new Person[T.N];

        for (int i = 0; i < T.N; i++) {
            T.people[i] = new Person(in.nextInt(), in.nextInt());
        }

        System.out.println(T.solution());
    }

    public int solution() {
        int answer = 0;
        int maxWeight = Integer.MIN_VALUE;

        Arrays.sort(people);
        for (int i = 0; i < N; i++) {
            if(people[i].weight >= maxWeight){
                maxWeight = people[i].weight;
                answer++;
            }
        }

        return answer;
    }

    public static class Person implements Comparable<Person>{
        private int height;
        private int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height - this.height;
        }
    }
}