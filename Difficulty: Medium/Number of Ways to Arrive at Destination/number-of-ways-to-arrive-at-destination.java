import java.util.*;
class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int countPaths(int V, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(new int[] {e[1], e[2]});
            graph.get(e[1]).add(new int[] {e[0], e[2]});
        }
        
        long[] dist = new long[V];
        int[] ways = new int[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[] {0, 0});
        
        while (!pq.isEmpty()) {
            long[] node = pq.poll();
            long d = node[0];
            int u = (int)node[1];
            
            if (d > dist[u]) continue;
            
            for (int[] nei : graph.get(u)) {
                int v = nei[0];
                int t = nei[1];
                if (dist[v] > dist[u] + t) {
                    dist[v] = dist[u] + t;
                    ways[v] = ways[u];
                    pq.offer(new long[] {dist[v], v});
                } else if (dist[v] == dist[u] + t) {
                    ways[v] = (int)((ways[v] + ways[u]) % MOD);
                }
            }
        }
        return ways[V - 1];
    }
}
