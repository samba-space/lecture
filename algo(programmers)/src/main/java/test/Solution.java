package test;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String[]> recordsByPlayer = new HashMap<>();
        Map<Long, List<String>> namesByCompleteCourse = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] nameAndRecords = record[i].split(":");
            String name = nameAndRecords[0];
            String[] records = nameAndRecords[1].split(",");
            recordsByPlayer.put(name, records);
        }

        recordsByPlayer.forEach((key, val) -> {
            long count = Arrays.stream(val).filter(item -> !item.equals("0")).count();
            List<String> result = namesByCompleteCourse.get(count);
            if (result == null) {
                List<String> tempNames = new ArrayList<>();
                tempNames.add(key);
                namesByCompleteCourse.put(count, tempNames);
            } else {
                result.add(key);
            }
        });
        System.out.println("namesByCompleteCourse = " + namesByCompleteCourse);

        return answer;
    }
}