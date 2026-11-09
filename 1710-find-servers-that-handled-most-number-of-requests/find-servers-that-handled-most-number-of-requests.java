import java.util.*;
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        TreeSet<Integer> idle = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            idle.add(i);
        }
        int[] count = new int[k];
        int maxLoaded = 0;
        for (int i = 0; i < arrival.length; i++) {
            int currTime = arrival[i];
            while (!busy.isEmpty() && busy.peek()[0] <= currTime) {
                idle.add(busy.poll()[1]);
            }
            if (idle.isEmpty()) {
                continue; // All servers busy, drop request
            }
            Integer server = idle.ceiling(i % k);
            if (server == null) {
                server = idle.first(); // Wrap around to the start
            }
            idle.remove(server);
            busy.offer(new int[] { currTime + load[i], server });
            count[server]++;
            maxLoaded = Math.max(maxLoaded, count[server]);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxLoaded) {
                result.add(i);
            }
        }
        return result;
    }
}