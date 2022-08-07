import java.util.*;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {
//        System.out.println(solution("0010"));
//        System.out.println(solution(new int[]{1, 1, 1, 1, 1, 1}));

//        int[] stepOne = new int[]{1,2,3};
//        int[] stepTwo = new int[]{10,20,30};
//        int[] stepThree = new int[]{1000,1,1};
//
//        String[] nameOne = new String[]{"james", "bob", "alice"};
//        String[] nameTwo = new String[]{"james", "alice", "bob"};
//        String[] nameThree = new String[]{"bob", "alice", "james"};
//        String[] solution = solution(stepOne, nameOne, stepTwo, nameTwo, stepThree, nameThree);
//        for (String s : solution) {
//            System.out.println("s = " + s);
//        }
    }

//    public static int solution(String s) {
//        int answer = -1;
//
//        for (int i = 0; i <= s.length() - 3; i++) {
//            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
//                int dandyNum = Integer.parseInt(s.substring(i, i + 3));
//                if (answer < dandyNum) {
//                    answer = dandyNum;
//                }
//            }
//        }
//
//        return answer;
//    }

//    public static int solution(int[] levels) {
//        Arrays.sort(levels);
//        if (levels.length < 4) {
//            return levels[levels.length - 1];
//        }
//        int topProblemCount = levels.length / 4;
//        return levels[levels.length - topProblemCount];
//    }


//    public static int solution(int[] tasks) {
//        int answer = 0;
//        List<Integer> collect = Arrays.stream(tasks).boxed()
//                .collect(Collectors.toList());
//        Set<Integer> set = Arrays.stream(tasks).boxed()
//                .collect(Collectors.toSet());
//        for (Integer integer : set) {
//            int totalCount = Collections.frequency(collect, integer);
//            if (totalCount / 3 == 0) {
//                if (totalCount % 3 == 1) {
//                  //1일때
//                  return -1;
//                }
//                answer += 1;
//            }
//            if (totalCount % 2 == 0) {
//                answer += totalCount / 2;
//            }
//            //홀수
//            else {
//                if (totalCount / 3 == 0) {
//                    return -1;
//                } else {
//                    if (totalCount % 3 == 0) {
//                        answer += totalCount / 3;
//                    } else {
//                        answer += totalCount / 3 + 1;
//                    }
//                }
//            }
//        }
//        return answer;
//    }

//    public static String[] solution(int[] stepsOne, String[] namesOne, int[] stepsTwo, String[] namesTwo, int[] stepsThree, String[] namesThree) {
//
//        Map<String, Integer> userMap = new HashMap<>();
//        makeMap(stepsOne, namesOne, userMap);
//        makeMap(stepsTwo, namesTwo, userMap);
//        makeMap(stepsThree, namesThree, userMap);
//
//        List<Map.Entry<String, Integer>> list = new ArrayList<>(userMap.entrySet());
//        list.sort(Map.Entry.comparingByKey());
//        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
//        String[] answer = new String[list.size()];
//
//        for (int i = 0; i < list.size(); i++) {
//            answer[i] = list.get(i).getKey();
//        }
//
//        return answer;
//    }
//
//    private static void makeMap(int[] stepsOne, String[] namesOne, Map<String, Integer> userMap) {
//        for (int i = 0; i < namesOne.length; i++) {
//            if (!userMap.containsKey(namesOne[i])) {
//                userMap.put(namesOne[i], stepsOne[i]);
//            } else {
//                userMap.put(namesOne[i], userMap.get(namesOne[i]) + stepsOne[i]);
//            }
//        }
//    }
}
