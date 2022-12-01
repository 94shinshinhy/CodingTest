package levelone;

public class Collatz {
    public static void main(String[] args) {
        int n1 = 6;
        int n2 = 16;
        int n3 = 626331;

        System.out.println(solution(n1));
        System.out.println(solution(n2));
        System.out.println(solution(n3));
    }

    public static int solution(int num) {
        int answer = 0;
        long num1 = (long)num;

        while(num1 != 1){
            if(num1 % 2 == 0)
                num1 = num1/2;
            else
                num1 = (num1*3)+1;
            answer++;
            if(answer > 500){
                answer = -1;
                break;
            }
        }

        return answer;
    }
}
