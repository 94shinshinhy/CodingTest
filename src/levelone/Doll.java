package levelone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doll {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<board.length; i++) {
            map.put(i+1, new ArrayList<Integer>());
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                if(board[i][j] != 0) {
                    map.get(j+1).add(board[i][j]);
                }
            }
        }

        //System.out.println("map : " + map);

        for(int i=0; i<moves.length; i++) {
            if(map.get(moves[i]).size() != 0) {
                list.add(map.get(moves[i]).get(0));
                map.get(moves[i]).remove(0);
            }
        }

        return res(list, answer);
    }

    public static int res(List<Integer> list, int answer) {
        int temp = answer;

        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) == list.get(i+1)) {
                list.remove(i);
                list.remove(i);
                answer += 2;
            }
        }

        if(temp == answer) {
            return answer;
        } else {
            return res(list, answer);
        }
    }
}
