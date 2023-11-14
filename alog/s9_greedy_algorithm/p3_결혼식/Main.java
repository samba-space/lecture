package s9_greedy_algorithm.p3_결혼식;

import java.util.*;

public class Main {
    private int N;
    private List<Visitor> visitors;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        T.visitors = new ArrayList<>();

        T.N = in.nextInt();

        for (int i = 0; i < T.N; i++) {
            T.visitors.add(new Visitor(in.nextInt(), 'S'));
            T.visitors.add(new Visitor(in.nextInt(), 'E'));
        }

        System.out.println(T.solution());
    }

    public int solution() {
        int answer = Integer.MIN_VALUE;
        int currentVisitorNumber = 0;

        visitors.sort(Comparator.<Visitor, Integer>comparing(visitor -> visitor.time)
                .thenComparing(visitor -> visitor.status));
        Collections.sort(visitors);
        
        for (Visitor visitor : visitors) {
            if (visitor.status == 'E') {
                currentVisitorNumber--;
            } else if (visitor.status == 'S') {
                currentVisitorNumber++;
            }
            answer = Math.max(answer, currentVisitorNumber);
        }

        return answer;
    }

    public static class Visitor implements Comparable<Visitor>{
        private int time;
        private char status;

        public Visitor(int time, char status) {
            this.time = time;
            this.status = status;
        }

        @Override
        public int compareTo(Visitor o) {
            if (this.time != o.time) {
                return this.time - o.time;    
            }
            return this.status - o.status;
        }
    }
}