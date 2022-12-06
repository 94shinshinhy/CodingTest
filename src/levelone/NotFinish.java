package levelone;

import java.util.Arrays;

public class NotFinish {
    public static void main(String[] args) {
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion1 = {"eden", "kiki"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        String[] completion3 = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant1, completion1));
        System.out.println(solution(participant2, completion2));
        System.out.println(solution(participant3, completion3));
    }

    public static String solution(String[] participant, String[] completion) {

        StringBuilder sb = new StringBuilder();

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<completion.length; i++){

            if(!(completion[i].equals(participant[i]))){
                sb.append(participant[i]);
                break;
            }

            if(i == completion.length - 1) sb.append(participant[i+1]);
        }

        return sb.toString();
    }
}
