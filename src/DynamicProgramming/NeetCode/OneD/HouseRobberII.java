package DynamicProgramming.NeetCode.OneD;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];

        int withoutLast  = rob(nums, 0, n-2);
        int withoutFirst  = rob(nums, 1, n-1);

        return Math.max(withoutLast, withoutFirst);
    }

    public int rob(int[] nums, int start, int end) {
        int second = 0, last = 0;
        for(int i=start; i<=end; i++){
            int curr = second + nums[i];
            int temp = last;
            last = Math.max(last, curr);
            second = temp;
        }
        return last;
    }
}
