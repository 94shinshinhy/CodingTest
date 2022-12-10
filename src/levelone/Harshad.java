package levelone;

import java.util.LinkedList;

public class Harshad {
    public static void main(String[] args) {
        int arr1 = 10;
        int arr2 = 12;
        int arr3 = 11;
        int arr4 = 13;

        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
        System.out.println(solution(arr3));
        System.out.println(solution(arr4));
    }

    public static boolean solution(int x) {

        boolean answer = true;
        int temp = x;
        int res = 0;

        LinkedList<Integer> ll = new LinkedList<Integer>();

        while(temp > 0){

            ll.push(temp % 10);
            temp = temp / 10;
            res = res + ll.pop();
        }

        if(x % res == 0){
            answer = true;
        } else{
            answer = false;
        }

        return answer;
    }
}
