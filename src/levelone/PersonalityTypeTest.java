package levelone;

import java.util.HashMap;
import java.util.Map;

public class PersonalityTypeTest {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(solution(survey, choices));
    }

    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        for(int i=0; i<survey.length; i++) {
            if(choices[i] < 4) {
                map.put(String.valueOf(survey[i].charAt(0)), map.get(String.valueOf(survey[i].charAt(0))) + 4 - choices[i]);
            } else if(choices[i] > 4) {
                map.put(String.valueOf(survey[i].charAt(1)), map.get(String.valueOf(survey[i].charAt(1))) + choices[i] - 4);
            } else {
                continue;
            }
        }

        if(map.get("R") >= map.get("T")) answer.append("R");
        else answer.append("T");

        if(map.get("C") >= map.get("F")) answer.append("C");
        else answer.append("F");

        if(map.get("J") >= map.get("M")) answer.append("J");
        else answer.append("M");

        if(map.get("A") >= map.get("N")) answer.append("A");
        else answer.append("N");

        return answer.toString();
    }
}
