package levelone;

public class PhoneNumber {
    public static void main(String[] args) {
        String phone_number1 = "01033334444";
        String phone_number2 = "027778888";

        System.out.println(solution(phone_number1));
        System.out.println(solution(phone_number2));
    }

    public static String solution(String phone_number) {
        String answer = "";

        String[] phone_number_arr = phone_number.split("");

        for(int i=0; i<phone_number_arr.length; i++){
            if(i < phone_number_arr.length-4){
                phone_number_arr[i] = "*";
            }
            answer += phone_number_arr[i];
        }

        return answer;
    }
}
