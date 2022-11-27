package levelone;

import java.util.Arrays;

public class SecretMap {
    public static void main(String[] args) {
        int n1 = 5;
        int[] arr1_1 = {9, 20, 28, 18, 11};
        int[] arr2_1 = {30, 1, 21, 17, 28};

        int n2 = 6;
        int[] arr1_2 = {46, 33, 33 ,22, 31, 50};
        int[] arr2_2 = {27 ,56, 19, 14, 14, 10};

        String[] answer1 = solution(n1, arr1_1, arr2_1);
        String[] answer2 = solution(n2, arr1_2, arr2_2);

        System.out.println(Arrays.toString(answer1));
        System.out.println(Arrays.toString(answer2));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        Arrays.fill(answer, "");

        for(int i=0; i<arr1.length; i++) {
            String conv1 = Integer.toBinaryString(arr1[i]);
            String conv2 = Integer.toBinaryString(arr2[i]);

            conv1 = fillZero(n, conv1);
            conv2 = fillZero(n, conv2);

            for(int j=0; j<arr1.length; j++) {
                if(conv1.charAt(j) == '1' || conv2.charAt(j) == '1') {
                    answer[i] += "#";
                } else {
                    answer[i] += " ";
                }
            }
        }

        return answer;
    }

    public static String fillZero(int n, String s) {
        StringBuilder sb = new StringBuilder();

        if(s.length() != n) {
            for(int i=0; i<n-s.length(); i++) {
                sb.append("0");
            }
        }

        sb.append(s);

        return sb.toString();
    }
}
