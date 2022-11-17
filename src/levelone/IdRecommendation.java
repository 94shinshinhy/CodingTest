package levelone;

public class IdRecommendation {
    public static void main(String[] args) {
        String new_id1= "...!@BaT#*..y.abcdefghijklm"; // "bat.y.abcdefghi"
        String new_id2 = "z-+.^."; // "z--"
        String new_id3 = "=.="; // "aaa"
        String new_id4 = "123_.def"; // "123_.def"
        String new_id5 = "abcdefghijklmn.p"; // "abcdefghijklmn"

        System.out.println(solution(new_id1));
        System.out.println(solution(new_id2));
        System.out.println(solution(new_id3));
        System.out.println(solution(new_id4));
        System.out.println(solution(new_id5));
    }

    static final int MAX = 15;
    static final int MIN = 3;

    public static String solution(String new_id) {

        new_id = new_id.toLowerCase();
        //System.out.println("1 : " + new_id);

        new_id = stepTwo(new_id);
        //System.out.println("2 : " + new_id);

        new_id = stepThree(new_id);
        //System.out.println("3 : " + new_id);

        new_id = stepFour(new_id);
        //System.out.println("4 : " + new_id);

        if(new_id.length() == 0) {
            new_id = stepFive(new_id);
            //System.out.println("5 : " + new_id);
        }

        if(new_id.length() > MAX) {
            new_id = stepSix(new_id);
            //System.out.println("6 : " + new_id);
        }

        if(new_id.length() < MIN) {
            new_id = stepSeven(new_id);
            //System.out.println("7 : " + new_id);
        }

        return new_id;
    }

    public static String stepTwo(String new_id) {
        StringBuilder sb = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz-_.1234567890";

        for(int i=0; i<new_id.length(); i++) {
            for(int j=0; j<alphabet.length(); j++) {
                if(Character.compare(new_id.charAt(i), alphabet.charAt(j)) == 0) {
                    sb.append(new_id.charAt(i));
                } else {
                    continue;
                }
            }
        }

        return sb.toString();
    }

    public static String stepThree(String new_id) {
        StringBuilder sb = new StringBuilder();
        char alphabet = '.';

        for(int i=0; i<new_id.length(); i++) {
            if(i == new_id.length()-1) {
                sb.append(new_id.charAt(i));
                break;
            }

            if(new_id.charAt(i) == alphabet) {
                if(new_id.charAt(i) == new_id.charAt(i+1)) {
                    continue;
                } else {
                    sb.append(new_id.charAt(i));
                }
            } else {
                sb.append(new_id.charAt(i));
            }
        }

        return sb.toString();
    }

    public static String stepFour(String new_id) {
        char alphabet = '.';

        if(new_id.length() == 0 || new_id.charAt(0) != alphabet && new_id.charAt(new_id.length()-1) != alphabet) {
            return new_id;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<new_id.length(); i++) {
            if(i == 0) {
                if(new_id.charAt(i) == alphabet) {
                    continue;
                } else {
                    sb.append(new_id.charAt(i));
                }
            } else if(i == new_id.length()-1) {
                if(new_id.charAt(i) == alphabet) {
                    break;
                } else {
                    sb.append(new_id.charAt(i));
                }
            } else {
                sb.append(new_id.charAt(i));
            }
        }

        return stepFour(sb.toString());
    }

    public static String stepFive(String new_id) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<MIN; i++) {
            sb.append("a");
        }

        return sb.toString();
    }

    public static String stepSix(String new_id) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<MAX; i++) {
            sb.append(new_id.charAt(i));
        }

        return stepFour(sb.toString());
    }

    public static String stepSeven(String new_id) {
        StringBuilder sb = new StringBuilder();
        char alphabet = new_id.charAt(new_id.length()-1);
        sb.append(new_id);

        for(int i=new_id.length(); i<MIN; i++) {
            sb.append(alphabet);
        }

        return sb.toString();
    }
}
