package levelone;

import java.util.*;

public class DartGame {
    public static final int S = 1;
    public static final int D = 2;
    public static final int T = 3;
    public static final String STAR = "*";
    public static final String ACHA = "#";

    public static void main(String[] args) {
        String dartResult1 = "1S2D*3T";
        String dartResult2 = "1D2S#10S";
        String dartResult3 = "1D2S0T";
        String dartResult4 = "1S*2T*3S";
        String dartResult5 = "1D#2S*3S";
        String dartResult6 = "1T2D3D#";
        String dartResult7 = "1D2S3T*";

        System.out.println("1 : " + solution(dartResult1));
        System.out.println("2 : " + solution(dartResult2));
        System.out.println("3 : " + solution(dartResult3));
        System.out.println("4 : " + solution(dartResult4));
        System.out.println("5 : " + solution(dartResult5));
        System.out.println("6 : " + solution(dartResult6));
        System.out.println("7 : " + solution(dartResult7));
    }

    public static int solution(String dartResult) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("S", S);
        map.put("D", D);
        map.put("T", T);

        Queue<String> q = new LinkedList<String>();
        for(int i=0; i<dartResult.length(); i++) {
            q.add(String.valueOf(dartResult.charAt(i)));
        }

        Stack<Integer> s = new Stack<Integer>();

        int i = 0;
        int temp = 0;
        int answer = 0;

        while(!q.isEmpty()) {
            i = Integer.parseInt(q.poll());

            if("0".equals(q.peek())) {
                q.poll();
                i = 10;
            }

            temp = (int) Math.pow(i, map.get(q.poll()));

            if(STAR.equals(q.peek())) {
                q.poll();
                temp = temp * 2;
                if(!s.isEmpty()) {
                    answer += s.peek();
                }
            } else if(ACHA.equals(q.peek())) {
                q.poll();
                temp = -temp;
            }

            answer += temp;

            s.add(temp);
        }

        return answer;
    }
}
