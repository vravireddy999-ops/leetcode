class Solution {
    public int sumCounts(int[] nums) {
        int n = nums.length;
        long mod = 1000000007;
        long ans = 0;
        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);
        long[] tree = new long[4 * n];
        long[] lazy = new long[4 * n];
        long[] sum = new long[4 * n];
        for (int i = 0; i < n; i++) {
            int l = last[nums[i]] + 1;
            update(1, 0, n - 1, l, i, tree, lazy, sum, mod);
            ans = (ans + tree[1]) % mod;
            last[nums[i]] = i;
        }
        return (int) ans;
    }
    void update(int node, int s, int e, int l, int r,
                long[] tree, long[] lazy, long[] sum, long mod) {
        if (l > e || r < s) return;
        if (l <= s && e <= r) {
            tree[node] = (tree[node] + 2 * sum[node] + (e - s + 1)) % mod;
            sum[node] = (sum[node] + e - s + 1) % mod;
            lazy[node]++;
            return;
        }
        int m = (s + e) / 2;
        push(node, s, e, tree, lazy, sum, mod);
        update(node * 2, s, m, l, r, tree, lazy, sum, mod);
        update(node * 2 + 1, m + 1, e, l, r, tree, lazy, sum, mod);
        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % mod;
        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % mod;
    }
    void push(int node, int s, int e, long[] tree,
              long[] lazy, long[] sum, long mod) {
        if (lazy[node] == 0 || s == e) return;
        int m = (s + e) / 2;
        apply(node * 2, s, m, lazy[node], tree, lazy, sum, mod);
        apply(node * 2 + 1, m + 1, e, lazy[node], tree, lazy, sum, mod);
        lazy[node] = 0;
    }

    void apply(int node, int s, int e, long v, long[] tree,
               long[] lazy, long[] sum, long mod) {
        tree[node] = (tree[node] + 2 * v * sum[node]
                     + (e - s + 1) * v * v) % mod;
        sum[node] = (sum[node] + (e - s + 1) * v) % mod;
        lazy[node] = (lazy[node] + v) % mod;
    }
}