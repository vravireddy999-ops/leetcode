import java.util.Arrays;
class Solution {
    private static final int MOD = 1_000_000_007;
    private Integer[][][] memo;
    private int[][] grid;
    private int m, n;
    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new Integer[m][n][3];
        return dfs(0, 0, 2);
    }
    private int dfs(int r, int c, int dir) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 0; 
        }
        if (r == m - 1 && c == n - 1) {
            return 1; 
        }
        if (memo[r][c][dir] != null) {
            return memo[r][c][dir];
        }
        long ways = 0;
        if (dir == 2) {
            ways = (ways + dfs(r, c + 1, 0)) % MOD;
            ways = (ways + dfs(r + 1, c, 1)) % MOD;
        } else if (dir == 0) {
            if (grid[r][c] == 1) {
                ways = (ways + dfs(r + 1, c, 1)) % MOD;
            } else {
                ways = (ways + dfs(r, c + 1, 0)) % MOD;
                ways = (ways + dfs(r + 1, c, 1)) % MOD;
            }
        } else if (dir == 1) {
            if (grid[r][c] == 1) {
                ways = (ways + dfs(r, c + 1, 0)) % MOD;
            } else {
                ways = (ways + dirDownOrRight(r, c)) % MOD; 
            }
        }
        return memo[r][c][dir] = (int) (ways % MOD);
    }
    private int dirDownOrRight(int r, int c) {
        long res = 0;
        res = (res + dfs(r + 1, c, 1)) % MOD;
        res = (res + dfs(r, c + 1, 0)) % MOD;
        return (int) res;
    }
}
