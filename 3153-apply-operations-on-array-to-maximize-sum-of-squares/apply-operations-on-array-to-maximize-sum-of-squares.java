class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1000000007;
        int[] bits = new int[32];
        for (int n : nums) {
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {
                    bits[i]++;
                }
            }
        }
        long ans = 0;
        for (int j = 0; j < k; j++) {
            long x = 0;
            for (int i = 0; i < 32; i++) {
                if (bits[i] > 0) {
                    x |= (1L << i);
                    bits[i]--;
                }
            }
            ans = (ans + x * x) % MOD;
        }
        return (int) ans;
    }
}