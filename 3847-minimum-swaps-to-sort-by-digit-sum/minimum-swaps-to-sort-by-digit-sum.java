import java.util.*;
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = nums[i], sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            arr[i][0] = sum;
            arr[i][1] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(arr[i][1], i);
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            int j = i, count = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = map.get(nums[j]);
                count++;
            }

            if (count > 1)
                swaps += count - 1;
        }
        return swaps;
    }
}