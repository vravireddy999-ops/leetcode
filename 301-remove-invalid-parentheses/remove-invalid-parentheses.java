class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s, 0, 0, new char[]{'(', ')'}, ans);
        return ans;
    }
    void dfs(String s, int last_i, int last_j, char[] p, List<String> ans) {
        int count = 0;
        for (int i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == p[0]) count++;
            if (s.charAt(i) == p[1]) count--;
            if (count >= 0) continue;
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == p[1] &&
                    (j == last_j || s.charAt(j - 1) != p[1])) {
                    dfs(s.substring(0, j) + s.substring(j + 1),
                        i, j, p, ans);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (p[0] == '(') {
            dfs(reversed, 0, 0, new char[]{')', '('}, ans);
        } else {
            ans.add(reversed);
        }
    }
}