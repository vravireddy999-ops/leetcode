import java.util.Arrays;
class Solution {
    private int[] memo;
    private final int INF = Integer.MAX_VALUE / 2;
    public int climbStairs(int n, int[] costs) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve(n, costs);
    }
    private int solve(int i, int[] costs) {
        if (i == 0) return 0;
        if (memo[i] != -1) return memo[i];
        int minCost = INF;
        for (int jump = 1; jump <= 3; jump++) {
            int prevStep = i - jump;
            if (prevStep >= 0) {
                int currentCost = solve(prevStep, costs) + costs[i - 1] + (jump * jump);
                minCost = Math.min(minCost, currentCost);
            }
        }
        return memo[i] = minCost;
    }
}