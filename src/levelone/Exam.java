package levelone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam {
    public static void main(String[] args) {
        int[] answers1 = {1,2,3,4,5};
        int[] answers2 = {1,3,2,4,2};

        System.out.println(Arrays.toString(solution(answers1)));
        System.out.println(Arrays.toString(solution(answers2)));
    }

    public static int[] solution(int[] answers) {

        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int aCnt = 0, bCnt = 0, cCnt = 0;
        int aIdx = 0, bIdx = 0, cIdx = 0;

        for(int i=0; i<answers.length; i++){

            if(aIdx == a.length) aIdx = 0;
            if(bIdx == b.length) bIdx = 0;
            if(cIdx == c.length) cIdx = 0;

            if(answers[i] == a[aIdx]) aCnt++;
            if(answers[i] == b[bIdx]) bCnt++;
            if(answers[i] == c[cIdx]) cCnt++;

            aIdx++;
            bIdx++;
            cIdx++;
        }

        int max = Math.max(aCnt, Math.max(bCnt, cCnt));
        List<Integer> list = new ArrayList<Integer>();

        if(max == aCnt) list.add(1);
        if(max == bCnt) list.add(2);
        if(max == cCnt) list.add(3);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
