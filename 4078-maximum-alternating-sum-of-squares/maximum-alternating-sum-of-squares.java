import java.util.Arrays;
class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        long ans = 0;
        int mid = nums.length / 2;
        for (int i = 0; i < mid; i++) {
            ans -= nums[i];
        }
        for (int i = mid; i < nums.length; i++) {
            ans += nums[i];
        }
        return ans;
    }
}