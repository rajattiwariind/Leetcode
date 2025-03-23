import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        // Modulo value
        int MOD = 1_000_000_007;
        
        // Create an adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        
        // Min heap to store (time, node)
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});  // (time, node)
        
        // Distance array to store shortest time to reach each node
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        // Ways array to store number of ways to reach each node in shortest time
        int[] ways = new int[n];
        ways[0] = 1;
        
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long currTime = current[0];
            int node = (int) current[1];
            
            // Skip outdated times
            if (currTime > dist[node]) continue;
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                long newTime = currTime + neighbor[1];
                
                // Found a shorter time to reach nextNode
                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    ways[nextNode] = ways[node];  // Copy ways count
                    pq.offer(new long[]{newTime, nextNode});
                } 
                // Found another way to reach nextNode in the same shortest time
                else if (newTime == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        
        return ways[n - 1];
    }
}
