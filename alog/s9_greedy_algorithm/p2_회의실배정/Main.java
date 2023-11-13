package s9_greedy_algorithm.p2_회의실배정;

import java.util.*;

public class Main {
    private int N;
    private List<Meeting> meetings;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        T.meetings = new ArrayList<>();

        T.N = in.nextInt();

        for (int i = 0; i < T.N; i++) {
            T.meetings.add(new Meeting(in.nextInt(), in.nextInt()));
        }

        System.out.println(T.solution());
    }

    public int solution() {
        int answer = 1;

        meetings.sort(Comparator.<Meeting, Integer>comparing(meeting -> meeting.endTime)
                .thenComparing(meeting -> meeting.startTime));


        int endTime = meetings.get(0).endTime;
        for (int i = 1; i < N; i++) {
            if (meetings.get(i).startTime >= endTime) {
                endTime = meetings.get(i).endTime;
                answer++;
            }
        }

        return answer;
    }

    public static class Meeting {
        public int startTime;
        public int endTime;

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }
}