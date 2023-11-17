package s9_greedy_algorithm.p4_최대수입스케줄;

import java.util.*;

public class Main {
    private int N;
    private List<Lecture> lectures;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        T.lectures = new ArrayList<>();

        T.N = in.nextInt();

        for (int i = 0; i < T.N; i++) {
            T.lectures.add(new Lecture(in.nextInt(), in.nextInt()));
        }

        System.out.println(T.solution());
    }

    public int solution() {
        Collections.sort(lectures);

        int answer = 0;
        int maxDay = lectures.get(0).deadLine;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (Lecture lecture : lectures) {
            if (lecture.deadLine == maxDay) {
                pq.offer(lecture.money);
            } else {
                maxDay = lecture.deadLine;
                answer += pq.poll();
                pq.offer(lecture.money);
            }
        }

        return answer;
    }

    public static class Lecture implements Comparable<Lecture>{
        private int money;
        private int deadLine;

        public Lecture(int money, int deadLine) {
            this.money = money;
            this.deadLine = deadLine;
        }

        @Override
        public int compareTo(Lecture o) {
            return Integer.compare(o.deadLine, this.deadLine);
        }
    }
}