package levelone;

public class Keypad {
    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand1 = "rigth";

        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand2 = "left";

        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand3 = "rigth";

        System.out.println(solution(numbers1, hand1));
        System.out.println(solution(numbers2, hand2));
        System.out.println(solution(numbers3, hand3));
    }
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        int left_tmp = 0;
        int right_tmp = 0;

        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] == 0) numbers[i] = 11;

            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                left = numbers[i];
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                right = numbers[i];
            } else {
                left_tmp = Math.abs(numbers[i] - left) / 3 + Math.abs(numbers[i] - left) % 3;
                right_tmp = Math.abs(numbers[i] - right) / 3 + Math.abs(numbers[i] - right) % 3;

                if(left_tmp == right_tmp) {
                    if("right".equals(hand)) {
                        sb.append("R");
                        right = numbers[i];
                    } else {
                        sb.append("L");
                        left = numbers[i];
                    }
                } else if(left_tmp > right_tmp) {
                    sb.append("R");
                    right = numbers[i];
                } else {
                    sb.append("L");
                    left = numbers[i];
                }
            }
        }

        return sb.toString();
    }
}
