package leveltwo;

import java.util.*;

public class Tangerine {
    public static void main(String[] args) {
        int k1 = 6;
        int[] tangerine1 = {1, 3, 2, 5, 4, 5, 2, 3};

        int k2 = 4;
        int[] tangerine2 = {1, 3, 2, 5, 4, 5, 2, 3};

        int k3 = 2;
        int[] tangerine3 = {1, 1, 1, 1, 2, 2, 2, 3};

        System.out.println(solution(k1, tangerine1));
        System.out.println(solution(k2, tangerine2));
        System.out.println(solution(k3, tangerine3));
    }

    public static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int cnt = 0;

        for(int tan : tangerine) {
            map.put(tan, map.getOrDefault(tan, 0)+1);
        }
        //System.out.println("map : " + map);

        List<Integer> list = new ArrayList<Integer>(map.keySet());
        //System.out.println("list : " + list);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        //System.out.println("list sort : " + list);

        for(int l : list) {
            sum += map.get(l);
            cnt++;
            if(sum >= k) break;
        }

        //System.out.println(cnt);
        return cnt;
    }
}
