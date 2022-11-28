package levelone;

public class PrimeNumber {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {1,2,7,6,4};

        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int temp = 0;
        int cnt = 0;

        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    temp = nums[i] + nums[j] + nums[k];

                    for(int w=2; w<temp/2; w++) {
                        cnt = 0;
                        if(temp % w == 0) {
                            cnt++;
                            break;
                        }
                    }

                    if(cnt == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
