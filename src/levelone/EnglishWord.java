package levelone;

public class EnglishWord {
    public static void main(String[] args) {
        String s1 = "one4seveneight";
        String s2 = "23four5six7";
        String s3 = "2three45sixseven";
        String s4 = "123";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }

    public static int solution(String s) {
        int answer = 0;
        String temp = "";

        String[] cp = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0; i<cp.length; i++) {
            if(s.contains(cp[i])) {
                temp = s.replace(cp[i], ""+i+"");
                s = temp;
            }
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
