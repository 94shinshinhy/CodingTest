package levelone;

import java.util.*;

public class MinimalRectangle {
    public static void main(String[] args) {
        int[][] sizes1 = {{60, 50}, {30, 70}, {0, 30}, {80, 40}};
        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {8, 7}, {7, 11}};

        System.out.println(solution(sizes1));
        System.out.println(solution(sizes2));
        System.out.println(solution(sizes3));
    }

    public static int solution(int[][] sizes) {
        int one = 0;
        int two = 0;

        for(int i=0; i<sizes.length; i++) {
            Arrays.sort(sizes[i]);
        }

        for(int i=0; i<sizes.length; i++) {
            one = Math.max(one, sizes[i][0]);
            two = Math.max(two, sizes[i][1]);
        }

        return one * two;
    }
}
